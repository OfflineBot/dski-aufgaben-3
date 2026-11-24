# Blatt 07 – Spring Boot und Docker

Das Blatt, das der Klausur am nächsten kommt: eine Spring-Anwendung bekommen,
Code anpassen, Dockerfile schreiben, über Umgebungsvariablen steuern.

Hinweise: `topics/docker/03-docker-image` (Abschnitt „Spring Boot & Docker“),
`topics/docker/04-best-practices`

Arbeitsverzeichnis: `projekt/greeting`. Was die Anwendung kann, steht in
[`projekt/README.md`](projekt/README.md).

---

## 1 Code lesen

Lies die drei Beispiele aus den Folien und beantworte die Fragen.

```java
@Value("${demo.version:0.0.1}")
private String version;
```

**1.1** Was passiert, wenn `demo.version` nirgends gesetzt ist?

→

```java
@Value("${nameservers:1.1.1.1,8.8.8.8}")
private String[] nameservers;
```

**1.2** Wie viele Einträge hat das Array ohne externe Konfiguration, und wie trennt
man die Werte in einer Umgebungsvariable?

→

```java
@Service
@Profile("dev")
public class GreetingServiceImpl implements GreetingService { }
```

**1.3** Wann existiert diese Klasse, und wann nicht? Mit welcher Umgebungsvariable
wird das aktive Profil gesetzt?

→

## 2 Anwendung kennenlernen

**2.1** Baue die Jar-Datei und starte die Anwendung ohne Docker.

```sh
→
```

**2.2** Rufe die Endpunkte auf und notiere die Antworten:

| Aufruf | Antwort |
| --- | --- |
| `curl "http://localhost:8080/?name=Anna"` | … |
| `curl http://localhost:8080/info` | … |

**2.3** Starte die Anwendung mit gesetzter Umgebungsvariable:

```sh
GREETING_TEXT="Guten Abend" java -jar build/libs/app.jar
```

Welche Property hat Spring daraus befüllt? Schreibe die Umwandlungsregel auf.

→

**2.4** Starte mit `SPRING_PROFILES_ACTIVE=prod`. Was zeigt `/info`?

→

## 3 Dockerfile für die Anwendung

**3.1** Schreibe `projekt/greeting/Dockerfile` nach den Best Practices:

- Baseimage `eclipse-temurin:21-jre-noble`
- `ENV SPRING_PROFILES_ACTIVE=prod`
- Arbeitsverzeichnis `/app`
- unprivilegierter Benutzer `springuser` in der Gruppe `spring`
  (das Image ist Debian-basiert: `groupadd -r spring && useradd -r -g spring springuser`)
- die Jar aus `build/libs/app.jar` wird zu `app.jar`
- Port 8080 freigeben
- Start in Exec-Notation

```dockerfile
→
```

**3.2** Baue das Image als `greeting:1.0` und starte es so, dass die Anwendung
unter http://localhost:8080 erreichbar ist.

```sh
→
```

**3.3** Prüfe `/info`: welches Profil ist aktiv, und welcher Hostname steht da?

→

**3.4** Überschreibe das Profil beim Start auf `dev`, ohne das Image neu zu bauen.

```sh
→
```

**3.5** Die Folien schreiben `ENV Spring.profiles.active=prod`, die
Spring-Dokumentation `SPRING_PROFILES_ACTIVE`. Teste beide Schreibweisen im
Dockerfile und notiere, was `/info` zeigt.

→

*Selbstkontrolle:* `curl "http://localhost:8080/?name=Anna"` antwortet mit der
Begrüßung, `/info` zeigt `profile=prod`. Beide Schreibweisen aus 3.5 funktionieren.

## 4 ApiKey-Authentifizierung (vgl. Aufgabe 6a)

Passe `GreetingController` so an, dass eine Authentifizierung via ApiKey umgesetzt
wird: der Wert zum Schlüssel `apikey` wird aus der URL gelesen und gegen eine
vorgegebene Liste erlaubter Werte geprüft. Nur wenn der übergebene Wert in der
Liste ist, wird `greet(...)` aufgerufen. Andernfalls kommt eine **leere Antwort**
zurück.

Erlaubte ApiKeys: `alpha1234`, `beta6`, `charly4321`

Die erlaubten Keys werden über eine **Umgebungsvariable** übergeben, nicht im Code
hinterlegt.

**4.1** Welches Feld brauchst du im Controller, und mit welcher Annotation
liest du die Liste ein? Schreibe die zwei Zeilen auf:

```java
→
```

**4.2** Schreibe die Prüfung. Vergleiche zwei Strings am besten mit
`string_1.contentEquals(string_2)`.

```java
@GetMapping
public String greeting(
        @RequestParam(value = "name", defaultValue = "Welt") String name,
        @RequestParam(value = "apikey", defaultValue = "") String apikey) {
    →
}
```

**4.3** Baue die Jar neu, baue das Image neu und starte den Container mit den
erlaubten Keys als Umgebungsvariable. Prüfe alle vier Fälle:

| Aufruf | Erwartung | Ergebnis |
| --- | --- | --- |
| `?name=Anna&apikey=alpha1234` | Begrüßung | … |
| `?name=Anna&apikey=beta6` | Begrüßung | … |
| `?name=Anna&apikey=falsch` | leere Antwort | … |
| `?name=Anna` | leere Antwort | … |

**4.4** Die Keys stehen auch in der Datei `greeting.env`. Starte den Container mit
`--env-file` statt mit `-e` und prüfe, dass es weiterhin funktioniert.

```sh
→
```

**4.5** Warum übergibt man die Liste zur Laufzeit und schreibt sie nicht per `ENV`
ins Dockerfile?

→

*Selbstkontrolle:* `curl -i "http://localhost:8080/?name=Anna&apikey=falsch"`
liefert Status 200 mit leerem Body, mit gültigem Key den Text.

## 5 Sprachen je Umgebung (vgl. Aufgabe 6b)

Setze um, dass auf der Produktions-, Test- und Entwicklungsumgebung unterschiedliche
Sprachen unterstützt werden:

| Profil | Sprache | Rückgabetext |
| --- | --- | --- |
| `prod` | Deutsch | `Herzlich Willkommen zur Veranstaltung Cloud Computing` |
| `test` | Englisch | `Welcome to the course on cloud computing` |
| `dev` | Französisch | `Bienvenue au cours sur le cloud computing` |

Verwende dafür **Spring Profile** und setze das zu verwendende Profil im Dockerfile.

**5.1** Wie viele Klassen brauchst du, welches Interface implementieren sie, und
welche Annotationen stehen über jeder?

→

**5.2** Schreibe die drei Klassenköpfe auf (Paket `de.dhbw.greeting.service`):

```java
→
```

**5.3** Baue und starte den Container **ohne** gesetztes Profil (nimm die
`ENV`-Zeile dafür kurz aus dem Dockerfile). Welche Fehlermeldung kommt beim Start,
und warum?

→

**5.4** Starte denselben Container dreimal mit `prod`, `test`, `dev` und prüfe die
Antwort:

| Profil | Antwort auf `/?name=Anna` |
| --- | --- |
| `prod` | … |
| `test` | … |
| `dev` | … |

*Selbstkontrolle:* ein Image, drei Container, drei Sprachen — ohne Neubau.

## 6 Profil-Properties statt Code

**6.1** Lege `src/main/resources/application-prod.properties` mit
`greeting.text=Herzlich Willkommen` und `application-dev.properties` mit
`greeting.text=Bienvenue` an. Baue neu und starte mit `SPRING_PROFILES_ACTIVE=dev`
beziehungsweise `prod`. Welche Datei wird jeweils gelesen? Prüfe mit `/info`.

→

**6.2** Setze zusätzlich `-e GREETING_TEXT="von der Kommandozeile"`.
Was gewinnt, die Profil-Datei oder die Umgebungsvariable?

→

## 7 Gästeliste und 403

Erweitere die Anwendung: im Profil `prod` darf nur begrüßt werden, wer auf der
Gästeliste steht. Steht der Name nicht darauf, antwortet die Anwendung mit
HTTP 403. Im Profil `dev` wird jeder begrüßt.

Die Gästeliste kommt aus der Property `greeting.allowed-names`
(Umgebungsvariable `GREETING_ALLOWED_NAMES`).

Einen HTTP-Status als Antwort wirft man in Spring so:

```java
throw new ResponseStatusException(HttpStatus.FORBIDDEN);
```

**7.1** Schreibe das Feld für die Gästeliste und die `greet`-Methode der
prod-Implementierung:

```java
→
```

**7.2** Wie übergibst du mehrere Namen in **einer** Umgebungsvariable, wenn das
Feld ein `String[]` ist? Teste mit Anna, Ben und Clara.

→

**7.3** Prüfe mit `curl -i`:

| Profil | Aufruf | Erwarteter Status |
| --- | --- | --- |
| `prod` | `/?name=Anna` | … |
| `prod` | `/?name=Zoe` | … |
| `dev` | `/?name=Zoe` | … |

*Selbstkontrolle:* `curl -i "http://localhost:8080/?name=Zoe"` im Profil `prod`
antwortet mit `HTTP/1.1 403`.

## 8 Fehlersuche im fremden Projekt

Diese Fehler stecken typischerweise in einem Projekt, das man zur Prüfung bekommt.
Ursache und Korrektur:

| Symptom | Ursache | Korrektur |
| --- | --- | --- |
| `docker image build` bricht beim `COPY` ab: Datei nicht gefunden | … | … |
| Container startet und beendet sich sofort, `logs` zeigt `Unable to access jarfile app.jar` | … | … |
| Container läuft, `curl http://localhost:8080` antwortet nicht, `PORTS` ist leer | … | … |
| Start scheitert mit `required a single bean, but 2 were found` | … | … |
| `greeting.text` bleibt auf `Hallo`, obwohl in der env-Datei `GREETINGTEXT=Moin` steht | … | … |
| Im Container läuft alles als `root` | … | … |
| Jede Codeänderung baut das Image komplett neu | … | … |

## 9 Alles zusammen

Arbeitsverzeichnis: `projekt/`. Darin liegen `greeting/` mit deinem Dockerfile und
der Datei `greeting.env` sowie `proxy/nginx.conf`. Der Proxy leitet an
`http://greeting:8080` weiter.

**9.1** Schreibe eine `compose.yaml` in `projekt/` mit zwei Services im neu
angelegten Bridge-Netzwerk `mynet2`:

- `proxy`: Image `nginx`, Containerport 80 unter Hostport 8080, die Datei
  `proxy/nginx.conf` wird unter `/etc/nginx/conf.d/default.conf` eingebunden
- `greeting`: wird aus dem Dockerfile im Ordner `greeting` gebaut, läuft im Profil
  `prod`, bekommt die übrigen Variablen per `env_file` aus `greeting/greeting.env`

```yaml
→
```

**9.2** Starte mit einem Befehl und prüfe über den Proxy:

```sh
→
```

**9.3** Räume alles auf, inklusive der selbst gebauten Images.

```sh
→
```

## 10 Verständnis

**10.1** Warum kopiert man die Jar-Datei ins Image und nicht den Quellcode, und
welcher Schritt muss deshalb vor jedem `docker image build` laufen?

→

**10.2** An welcher Stelle im Dockerfile steht das `COPY` der Jar, und warum nicht
weiter oben?

→

**10.3** Du änderst nur eine Java-Datei und rufst `docker container run` erneut
auf — die Änderung ist nicht da. Welche zwei Schritte hast du vergessen?

→

---

# Weiter

- Originalaufgabe: `cloud-computing/origin-tasks/task-6/` (Aufgabe 6, mit
  Startprojekt und Lösung), `cloud-computing/origin-tasks/task-probe-programmentwurf/`
- Nächstes Blatt: [08 – Übersetzen: CLI und Script](08-uebersetzen-cli-und-script.md)
