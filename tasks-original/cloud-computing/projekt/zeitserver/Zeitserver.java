import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Winziger HTTP-Server ohne Build-Werkzeug und ohne Abhaengigkeiten.
 * Laeuft mit "java Zeitserver.java" ab Java 11.
 *
 * Umgebungsvariablen:
 *   PORT       Port, auf dem gehorcht wird (Standard 8080)
 *   GREETING   Text der Antwort (Standard "Hallo")
 *   DATA_DIR   Verzeichnis fuer die Besucherzaehlung (Standard /data)
 */
public class Zeitserver {

    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(env("PORT", "8080"));
        String greeting = env("GREETING", "Hallo");
        Path counterFile = Path.of(env("DATA_DIR", "/data")).resolve("besucher.txt");

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", exchange -> {
            String body = greeting + " von " + hostname() + "\n"
                    + "Zeit: " + ZonedDateTime.now() + "\n"
                    + "Besuch Nr.: " + count(counterFile) + "\n";
            send(exchange, 200, body);
        });

        server.createContext("/health", exchange -> send(exchange, 200, "OK\n"));

        server.start();
        System.out.println("Zeitserver hoert auf Port " + port);
        System.out.println("GREETING=" + greeting + " DATA_DIR=" + counterFile.getParent());
    }

    private static String env(String key, String fallback) {
        String value = System.getenv(key);
        return value == null || value.isBlank() ? fallback : value;
    }

    private static String hostname() {
        return env("HOSTNAME", "unbekannt");
    }

    /** Zaehlt den Besuch in DATA_DIR hoch; ohne Schreibrecht wird -1 geliefert. */
    private static long count(Path file) {
        try {
            Files.createDirectories(file.getParent());
            long value = Files.exists(file) ? Long.parseLong(Files.readString(file).trim()) + 1 : 1;
            Files.write(file, List.of(Long.toString(value)));
            return value;
        } catch (Exception e) {
            return -1;
        }
    }

    private static void send(com.sun.net.httpserver.HttpExchange exchange, int status, String body)
            throws IOException {
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=utf-8");
        exchange.sendResponseHeaders(status, bytes.length);
        try (OutputStream out = exchange.getResponseBody()) {
            out.write(bytes);
        }
    }
}
