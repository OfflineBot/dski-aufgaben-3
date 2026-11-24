# Blatt 02 – Docker Image und Dockerfile

Images beziehen, ansehen, taggen — und dann das erste eigene Dockerfile.

Hinweis: `topics/docker/03-docker-image`

---

## 1 Befehle und Instruktionen kennen

**1.1** Was macht jeder Befehl?

| Befehl | Wirkung |
| --- | --- |
| `docker image list` | … |
| `docker image history hello-world` | … |
| `docker image tag alpine v1` | … |
| `docker image pull alpine` | … |
| `docker image build -t test .` | … |
| `docker image rm test` | … |

**1.2** Was bedeutet der Punkt am Ende von `docker image build -t test .`, und
was gibt `-t test` an?

→

**1.3** Trage für jede Instruktion ein, was sie tut und *wann* sie wirkt
(Bauzeit oder Laufzeit):

| Instruktion | Wirkung | Bauzeit oder Laufzeit? |
| --- | --- | --- |
| `FROM` | … | … |
| `ENV` | … | … |
| `RUN` | … | … |
| `WORKDIR` | … | … |
| `COPY` | … | … |
| `EXPOSE` | … | … |
| `CMD` | … | … |

**1.4** Die zwei Formen von `CMD`. Schreibe beide für `java -jar app.jar` auf und
nenne den Sicherheitsunterschied.

| Form | Notation |
| --- | --- |
| Exec form | … |
| Shell form | … |

→

**1.5** Zerlege die Tags in ihre Abschnitte:

| Tag | Registry | User | Image | Version |
| --- | --- | --- | --- | --- |
| `hub.docker.com/plexinc/pms-docker:latest` | … | … | … | … |
| `postgres:17.6` | … | … | … | … |
| `nginx` | … | … | … | … |

## 2 Images beziehen und ansehen

**2.1** Lade `alpine:3.20` herunter, ohne einen Container zu starten.

```sh
→
```

**2.2** Zeige die Schichten von `alpine:3.20` und von `nginx`. Wie viele Schichten
hat jedes?

```sh
→
```

**2.3** Vergib für `alpine:3.20` zusätzlich den Tag `meinalpine:v1`. Prüfe in der
Image-Liste: wie viele Einträge, welche IMAGE ID, wie viel Speicher zusätzlich?

```sh
→
```

**2.4** Lösche den Tag `meinalpine:v1`. Ist `alpine:3.20` danach noch da?

→

*Selbstkontrolle:* nach 2.3 stehen zwei Zeilen mit **derselben** IMAGE ID in
`docker image list`.

## 3 Das erste eigene Dockerfile (Zeitserver)

Arbeitsverzeichnis: `projekt/zeitserver`. Darin liegt nur `Zeitserver.java`.
Die Datei braucht kein Build-Werkzeug: `java Zeitserver.java` startet sie direkt.

**3.1** Schreibe ein `Dockerfile` in `projekt/zeitserver`, das:

- auf dem offiziellen Baseimage `eclipse-temurin:21-jdk-alpine` aufsetzt
- die Umgebungsvariablen `PORT=8080` und `GREETING=Hallo` setzt
- `/app` als Arbeitsverzeichnis setzt
- `Zeitserver.java` nach `/app` kopiert
- Port 8080 freigibt
- den Container mit `java Zeitserver.java` in **Exec-Notation** startet

```dockerfile
→
```

**3.2** Baue daraus das Image `zeitserver:1.0` und starte einen Container, der auf
http://localhost:8080 erreichbar ist.

```sh
→
```

**3.3** Welche Ausgabe liefert `curl http://localhost:8080`, und was steht in
`docker container logs`?

→

**3.4** Erstelle einen neuen Container aus `zeitserver:1.0` und überschreibe dabei
`GREETING` mit `-e GREETING="Moin"`, ohne das Image neu zu bauen. Was zeigt die Antwort?

```sh
→
```

**3.5** Warum musst du für 3.4 das Image nicht neu bauen? Welche Instruktion macht
das möglich?

→

*Selbstkontrolle:* `curl http://localhost:8080` antwortet mit
`Hallo von <containerid>`, nach 3.4 mit `Moin von <containerid>`.

## 4 Schichten und Build-Cache beobachten

Weiter mit dem Dockerfile aus Aufgabe 3.

**4.1** Baue `zeitserver:1.0` ein zweites Mal, ohne etwas zu ändern. Was steht
jetzt in der Ausgabe hinter den einzelnen Schritten?

→

**4.2** Ändere in `Zeitserver.java` den Standardwert von `GREETING` (die Zeile
`env("GREETING", "Hallo")`) und baue erneut. Welche Schritte kommen aus dem Cache,
ab welchem Schritt wird neu gebaut? Warum genau ab dort?

→

**4.3** Verschiebe das `COPY` im Dockerfile nach *oben*, direkt unter `FROM`,
und wiederhole 4.2. Was wird jetzt neu gebaut?

→

**4.4** Welche Reihenfolge ist die bessere, und wie lautet die Regel dahinter?

→

*Selbstkontrolle:* in 4.1 steht hinter den Schritten `CACHED`, in 4.2 nur bis zum
`COPY`.

## 5 Dockerfile lesen

Gegeben:

```dockerfile
FROM openjdk:8-jdk-alpine
ENV demo.version=0.9
RUN mkdir app
WORKDIR app/
COPY target/*.jar app.jar
EXPOSE 8080
CMD ["java","-jar","/app.jar"]
```

**5.1** Was passiert beim **Bauen**, was erst beim **Starten** eines Containers?

→

**5.2** In welchem Verzeichnis im Container liegt die Jar-Datei nach dem `COPY`,
und welchen Pfad startet `CMD`? Passt das zusammen? Falls nicht: schreibe die
`CMD`-Zeile so, dass sie zum `WORKDIR` passt.

→

**5.3** Welcher Befehl auf dem Host muss *vor* dem Bauen gelaufen sein, damit
`COPY target/*.jar` etwas findet?

→

## 6 Dockerfile nach Vorgabe schreiben (vgl. Aufgabe 8)

Schreibe ein Dockerfile, das genau diese Vorgaben erfüllt:

- die Anwendung basiert auf dem offiziellen Baseimage `openjdk` in der Version
  `16-jdk-alpine`
- die Anwendung horcht im Container auf Port 8080, und dieser Port soll über den
  Hostport 3030 angesprochen werden
- `apk update` aktualisiert das Paketverzeichnis
- `apk add vim -y` installiert einen Texteditor
- `mkdir -p /usr/src/app` erstellt das Anwendungsverzeichnis
- es gibt einen neuen Benutzer `javauser` in der neuen Gruppe `java` mit
  eingeschränkten Rechten, unter dem die Anwendung läuft
- die Jar-Datei wird aus dem Verzeichnis `target` nach `/usr/src/app/app.jar` kopiert
- der Container startet mit `java -jar /usr/src/app/app.jar` in Exec-Notation

```dockerfile
→
```

Diese Aufgabe wird nur geschrieben, nicht gebaut: `openjdk:16-jdk-alpine` gibt es
auf Docker Hub nicht mehr.

**6.1** Die Originalaufgabe nennt außerdem die Vorgabe „führe den Befehl
`mvn clean install` aus“. Warum gehört das nach Best Practice **nicht** ins
Dockerfile, und was ist die Konsequenz, wenn man es doch tut?

→

**6.2** Wie lautet der Build-Befehl, und wie der Run-Befehl mit dem Port-Mapping
aus der Vorgabe?

```sh
→
```

## 7 CMD überschreiben

Voraussetzung: das Image `zeitserver:1.0` aus Aufgabe 3.

**7.1** Starte einen Container aus `zeitserver:1.0`, der statt des Servers nur
`ls -la /app` ausführt.

```sh
→
```

**7.2** Welche Instruktion hast du damit überschrieben? Ist das Image dadurch
verändert?

→

**7.3** Starte `alpine:3.20` interaktiv mit `sh` als Startkommando. Warum
funktioniert `bash` bei Alpine nicht?

→

## 8 Verständnis

**8.1** Was passiert beim Bau, wenn sich eine Schicht geändert hat? Welche Schichten
werden neu gebaut?

→

**8.2** Was ist der Unterschied zwischen `EXPOSE 8080` im Dockerfile und
`-p 80:8080` beim `run`?

→

**8.3** Welche zwei Instruktionen können beim `run` überschrieben werden, und womit?

→

**8.4** Was wird gesetzt, wenn du beim Image keine Version angibst, und warum heißt
das *nicht* „die aktuelle Version“?

→

---

# Weiter

- Originalaufgabe: `cloud-computing/origin-tasks/task-8/` (Dockerfile nach Vorgabe)
- Nächstes Blatt: [03 – Best Practices](03-best-practices.md)
