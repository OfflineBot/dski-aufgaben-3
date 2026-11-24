# Übungsprojekt

Die Dateien, die die Aufgabenblätter brauchen. Nichts hier ist eine Lösung.
`Dockerfile` und `compose.yaml` fehlen absichtlich — die schreibst du.

```text
projekt/
  greeting/            Spring-Boot-Anwendung (Gradle, Wrapper liegt dabei)
    src/main/java/...  Quellcode, den du in Blatt 07 erweiterst
    greeting.env       Umgebungsvariablen für --env-file
  zeitserver/
    Zeitserver.java    HTTP-Server in einer Datei, ohne Build-Werkzeug
  proxy/
    nginx.conf         Proxy-Konfiguration, zeigt auf http://greeting:8080
```

## greeting (Spring Boot)

Jar bauen (aus `projekt/greeting`):

```sh
./gradlew bootJar          # Windows: gradlew.bat bootJar
```

Ergebnis: `build/libs/app.jar`. Ohne Docker starten:

```sh
java -jar build/libs/app.jar
```

Endpunkte:

| Endpunkt | Antwort |
| --- | --- |
| `GET /?name=Anna` | Begrüßung, z. B. `Hallo Anna` |
| `GET /?name=Anna&apikey=alpha1234` | wie oben; der ApiKey wird erst in Blatt 07 ausgewertet |
| `GET /info` | aktives Profil, `greeting.text`, `demo.version`, Hostname |

`/info` ist das Prüfwerkzeug für alle Aufgaben zu Umgebungsvariablen und Profilen.

Konfigurationswerte:

| Property | Umgebungsvariable | Standard |
| --- | --- | --- |
| `greeting.text` | `GREETING_TEXT` | `Hallo` |
| `demo.version` | `DEMO_VERSION` | `0.0.1` |
| `spring.profiles.active` | `SPRING_PROFILES_ACTIVE` | keins (`default`) |

Spring liest Properties auch aus Umgebungsvariablen: Punkte werden zu Unterstrichen,
alles groß. Aus `greeting.text` wird `GREETING_TEXT`.

## zeitserver (reines Java)

Kein Maven, kein Gradle, keine Abhängigkeiten. Ab Java 11 direkt startbar:

```sh
java Zeitserver.java
```

| Umgebungsvariable | Standard | Wirkung |
| --- | --- | --- |
| `PORT` | `8080` | Port, auf dem gehorcht wird |
| `GREETING` | `Hallo` | Text der Antwort |
| `DATA_DIR` | `/data` | Verzeichnis für die Besucherzählung |

Endpunkte: `GET /` (Begrüßung, Hostname, Zeit, Besuchszähler) und `GET /health` (`OK`).
Der Zähler steht in `$DATA_DIR/besucher.txt` — damit wird Persistenz in Blatt 04 sichtbar.
Ist das Verzeichnis nicht beschreibbar, liefert der Zähler `-1`.
