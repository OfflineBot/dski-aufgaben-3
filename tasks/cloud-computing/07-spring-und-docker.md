# Blatt 07 – Spring Boot und Docker

Das Blatt, das der Klausur am nächsten kommt: eine Spring-Anwendung bekommen,
Code anpassen, Dockerfile schreiben, über Umgebungsvariablen steuern.

Hinweise: `topics/docker/03-docker-image` (Abschnitt „Spring Boot & Docker“),
`topics/docker/04-best-practices`

Arbeitsverzeichnis: `projekt/greeting`. Was die Anwendung kann, steht in
[`projekt/README.md`](projekt/README.md).

---

# Teil A – Theorie

## 1 Spring und Umgebungsvariablen

**1.1** Drei Zwecke, für die Spring Umgebungsvariablen unterstützt:

→

**1.2** Was steuern Profile, und welche Datei wird je Profil gewählt?

→

**1.3** Welche Umgebungsvariable definiert das aktive Profil?

→

**1.4** Was erzeugt `mvn clean install`, und was bedeutet „self-contained (fat) Jar“?

→

**1.5** Lies die drei Code-Beispiele und beantworte die Fragen:

```java
@Value("${demo.version:0.0.1}")
private String version;
```

- Was passiert, wenn `demo.version` nirgends gesetzt ist?

  →

```java
@Value("${nameservers:1.1.1.1,8.8.8.8}")
private String[] nameservers;
```

- Wie viele Einträge hat das Array ohne externe Konfiguration, und wie trennt man
  die Werte in einer Umgebungsvariable?

  →

```java
@Service
@Profile("dev")
public class GreetingServiceImpl implements GreetingService { }
```

- Wann existiert diese Bean, und wann nicht?

  →

**1.6** Warum ist es ein Vorteil, dass Umgebungsvariablen von jedem Betriebssystem
unterstützt werden?

→

**1.7** Die Anwendung soll im produktiven Betrieb andere Endpunkte benutzen als in
der Entwicklung. Welche zwei Spring-Mittel kommen dafür in Frage?

→

## 2 Zusammenspiel mit dem Dockerfile

**2.1** Welche drei Zeilen eines Dockerfiles sind für eine Spring-Boot-Anwendung
die entscheidenden, und was steht in jeder?

→

**2.2** Warum kopiert man die Jar-Datei und nicht den Quellcode?

→

**2.3** Welcher Befehl muss auf dem Host gelaufen sein, bevor man baut?

→

**2.4** An welcher Stelle im Dockerfile steht `COPY build/libs/app.jar`, und warum
nicht weiter oben?

→

---

# Teil B – Praxis

## 3 Anwendung kennenlernen

**3.1** Baue die Jar-Datei und starte die Anwendung ohne Docker.

```sh
→
```

**3.2** Rufe die drei Endpunkte auf und notiere die Antworten:

| Aufruf | Antwort |
| --- | --- |
| `curl "http://localhost:8080/?name=Anna"` | … |
| `curl "http://localhost:8080/?name=Anna&apikey=alpha1234"` | … |
| `curl http://localhost:8080/info` | … |

**3.3** Starte die Anwendung mit gesetzter Umgebungsvariable:

```sh
GREETING_TEXT="Guten Abend" java -jar build/libs/app.jar
```

Welche Property hat Spring daraus befüllt? Schreibe die Umwandlungsregel auf.

→

**3.4** Starte mit `SPRING_PROFILES_ACTIVE=prod`. Was zeigt `/info`?

→

## 4 Dockerfile für die Anwendung

**4.1** Schreibe `projekt/greeting/Dockerfile` nach den Best Practices:

- Baseimage `eclipse-temurin:21-jre-noble` (versioniert, offiziell, JRE statt JDK)
- `ENV SPRING_PROFILES_ACTIVE=prod`
- Arbeitsverzeichnis `/app`
- unprivilegierter Benutzer `springuser` in der Gruppe `spring`
  (Debian-basiert: `groupadd -r spring && useradd -r -g spring springuser`)
- die Jar aus `build/libs/app.jar` wird zu `app.jar`
- Port 8080 freigeben
- Start in Exec-Notation

```dockerfile
→
```

**4.2** Baue das Image als `greeting:1.0` und starte es so, dass die Anwendung
unter http://localhost:8080 erreichbar ist.

```sh
→
```

**4.3** Prüfe `/info`: welches Profil ist aktiv, welcher Hostname steht da, und was
bedeutet dieser Hostname?

→

**4.4** Überschreibe das Profil beim Start auf `dev`, ohne das Image neu zu bauen.

```sh
→
```

**4.5** Die Folien schreiben `ENV Spring.profiles.active=prod`, die
Spring-Dokumentation `SPRING_PROFILES_ACTIVE`. Teste beide Schreibweisen und
notiere, welche bei dir ankommt (`/info` zeigt es).

→

**4.6** Prüfe mit `docker image history greeting:1.0`, welche Schichten entstanden
sind. Wie viele, und welche ist die größte?

→

*Selbstkontrolle:* `curl "http://localhost:8080/?name=Anna"` antwortet mit der
Begrüßung, `/info` zeigt `profile=prod`.

## 5 ApiKey-Authentifizierung (vgl. Aufgabe 6a)

Passe `GreetingController` (und falls nötig das Dockerfile) so an, dass eine
Authentifizierung via ApiKey umgesetzt wird: der Wert zum Schlüssel `apikey` wird
aus der URL gelesen und gegen eine vorgegebene Liste erlaubter Werte geprüft.
Nur wenn der übergebene Wert in der Liste ist, wird `greet(...)` aufgerufen.
Andernfalls kommt eine **leere Antwort** zurück.

Erlaubte ApiKeys: `alpha1234`, `beta6`, `charly4321`

Die erlaubten Keys werden über eine **Umgebungsvariable** übergeben, nicht im Code
hinterlegt.

**5.1** Welches Feld brauchst du im Controller, und mit welcher Annotation
injizierst du die Liste? Schreibe die zwei Zeilen auf:

```java
→
```

**5.2** Schreibe die Prüfung. Vergleiche zwei Strings am besten mit
`string_1.contentEquals(string_2)`.

```java
@GetMapping
public String greeting(
        @RequestParam(value = "name", defaultValue = "Welt") String name,
        @RequestParam(value = "apikey", defaultValue = "") String apikey) {
    →
}
```

**5.3** In welcher Datei steht der Standardwert, falls die Umgebungsvariable fehlt,
und wie schreibst du ihn in die Annotation?

→

**5.4** Baue die Jar neu, baue das Image neu und starte den Container mit den
erlaubten Keys als Umgebungsvariable. Prüfe alle vier Fälle:

| Aufruf | Erwartung | Ergebnis |
| --- | --- | --- |
| `?name=Anna&apikey=alpha1234` | Begrüßung | … |
| `?name=Anna&apikey=beta6` | Begrüßung | … |
| `?name=Anna&apikey=falsch` | leere Antwort | … |
| `?name=Anna` | leere Antwort | … |

**5.5** Warum übergibt man die Liste per Umgebungsvariable und schreibt sie nicht
per `ENV` ins Dockerfile — und was gilt erst recht für echte Passwörter?

→

**5.6** Lege die Keys in eine Datei `greeting.env` und starte den Container mit
`--env-file`. Prüfe, dass es weiterhin funktioniert.

```sh
→
```

*Selbstkontrolle:* `curl -i "http://localhost:8080/?name=Anna&apikey=falsch"`
liefert Status 200 mit leerem Body, mit gültigem Key den Text.

## 6 Sprachen je Umgebung (vgl. Aufgabe 6b)

Setze um, dass auf der Produktions-, Test- und Entwicklungsumgebung unterschiedliche
Sprachen unterstützt werden:

| Profil | Sprache | Rückgabetext |
| --- | --- | --- |
| `prod` | Deutsch | `Herzlich Willkommen zur Veranstaltung Cloud Computing` |
| `test` | Englisch | `Wellcome to the course on cloud computing` |
| `dev` | Französisch | `Bienvenue au cours sur le cloud computing` |

Verwende dafür **Spring Profile** und setze das zu verwendende Profil im Dockerfile.

**6.1** Wie viele Klassen brauchst du, welches Interface implementieren sie, und
welche Annotationen stehen über jeder?

→

**6.2** Schreibe die drei Klassenköpfe auf (Paket `de.dhbw.greeting.service`):

```java
→
```

**6.3** Baue und starte den Container ohne gesetztes Profil. Welche Fehlermeldung
kommt beim Start, und warum?

→

**6.4** Nenne zwei Wege, dieses Problem zu lösen (Stichworte: `@Profile("default")`,
Profil im Dockerfile setzen).

→

**6.5** Starte denselben Container dreimal mit `prod`, `test`, `dev` und prüfe die
Antwort:

| Profil | Antwort auf `/?name=Anna` |
| --- | --- |
| `prod` | … |
| `test` | … |
| `dev` | … |

**6.6** Welcher Satz aus den Folien beschreibt, was hier passiert ist?
(„Profile steuern die Sichtbarkeit …“)

→

*Selbstkontrolle:* ein Image, drei Container, drei Sprachen — ohne Neubau.

## 7 Profil-Properties statt Code

**7.1** Lege `src/main/resources/application-prod.properties` mit
`greeting.text=Herzlich Willkommen` und `application-dev.properties` mit
`greeting.text=Bienvenue` an.

→

**7.2** Baue neu und starte mit `SPRING_PROFILES_ACTIVE=dev` beziehungsweise `prod`.
Welche Datei wird jeweils gelesen?

→

**7.3** Setze zusätzlich `-e GREETING_TEXT="von der Kommandozeile"`.
Was gewinnt, die Profil-Datei oder die Umgebungsvariable?

→

**7.4** Wann nimmst du Profil-Properties, wann eigene Beans mit `@Profile`?

→

## 8 Gästeliste und 403

Erweitere die Anwendung: im Profil `prod` darf nur begrüßt werden, wer auf der
Gästeliste steht. Steht der Name nicht darauf, antwortet die Anwendung mit
HTTP 403. Im Profil `dev` wird jeder begrüßt.

Die Gästeliste kommt aus der Property `greeting.allowed-names`
(Umgebungsvariable `GREETING_ALLOWED_NAMES`).

**8.1** Mit welcher Klasse wirft man in Spring einen HTTP-Status als Antwort?
Schreibe die Zeile auf (Import nicht vergessen).

```java
→
```

**8.2** Schreibe die `greet`-Methode der prod-Implementierung:

```java
@Override
public String greet(String name) {
    →
}
```

**8.3** Wie übergibst du mehrere Namen in **einer** Umgebungsvariable, wenn das
Feld ein `String[]` ist? Teste mit `GREETING_ALLOWED_NAMES=Anna,Ben,Clara`.

→

**8.4** Prüfe mit `curl -i`:

| Profil | Aufruf | Erwarteter Status |
| --- | --- | --- |
| `prod` | `/?name=Anna` | … |
| `prod` | `/?name=Zoe` | … |
| `dev` | `/?name=Zoe` | … |

**8.5** Was antwortet die Anwendung, wenn `name` ganz fehlt? Ist das gewollt?
Wie würdest du es ändern?

→

*Selbstkontrolle:* `curl -i "http://localhost:8080/?name=Zoe"` im Profil `prod`
antwortet mit `HTTP/1.1 403`.

## 9 Fehlersuche im fremden Projekt

Diese Fehler stecken typischerweise in einem Projekt, das man zur Prüfung bekommt.
Ursache und Korrektur:

| Symptom | Ursache | Korrektur |
| --- | --- | --- |
| `docker image build` scheitert mit `COPY failed: no source files were specified` | … | … |
| Container startet und beendet sich sofort, `logs` zeigt `Unable to access jarfile app.jar` | … | … |
| Container läuft, `curl http://localhost:8080` antwortet nicht, `PORTS` ist leer | … | … |
| `/info` zeigt `profile=default`, obwohl im Dockerfile ein Profil steht | … | … |
| Start scheitert mit `required a single bean, but 2 were found` | … | … |
| `greeting.text` bleibt auf `Hallo`, obwohl `-e greeting.text=Moin` gesetzt wurde | … | … |
| Im Container läuft alles als `root` | … | … |
| Jede Codeänderung baut das Image komplett neu | … | … |

## 10 Alles zusammen

**10.1** Schreibe eine `compose.yaml` in `projekt/`, die den Proxy und die
Spring-Anwendung startet (vgl. Blatt 06, Aufgabe 8), das Profil auf `prod` setzt,
die ApiKeys per `env_file` übergibt und beide Services in das Netzwerk `mynet2`
legt.

```yaml
→
```

**10.2** Starte mit einem Befehl und prüfe über den Proxy:

```sh
→
```

**10.3** Welche Schritte wären nötig, um dieselbe Anwendung mit einer Postgres-
Datenbank und persistentem Volume zu betreiben? Schreibe den zusätzlichen Service.

```yaml
→
```

**10.4** Räume alles auf, inklusive der selbst gebauten Images.

```sh
→
```

---

# Weiter

- Originalaufgabe: `cloud-computing/origin-tasks/task-6/` (Aufgabe 6, mit
  Startprojekt und Lösung), `cloud-computing/origin-tasks/task-probe-programmentwurf/`
- Nächstes Blatt: [08 – Übersetzen: CLI und Script](08-uebersetzen-cli-und-script.md)
