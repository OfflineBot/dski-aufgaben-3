# Blatt 03 – Best Practices

Die Konventionen, nach denen ein Dockerfile bewertet wird: Baseimage, Tagging,
Umgebungsvariablen, Schichtenreihenfolge, non-root.

Hinweis: `topics/docker/04-best-practices`

---

## 1 Schichten richtig anordnen

**1.1** Das Dockerfile aus den Folien ist falsch angeordnet. Sortiere es neu und
begründe die Position der verschobenen Zeile:

```dockerfile
FROM openjdk:8-jdk-alpine
COPY *.jar app/app.jar
ENV stage=prod
RUN mkdir app
WORKDIR target/
CMD ["java","-jar","/app.jar"]
```

```dockerfile
→
```

Begründung:

→

**1.2** Welchen konkreten Schaden richtet das `COPY` an Position 2 bei jedem
Compiliervorgang an?

→

## 2 Non-Root in zwei Zeilen

**2.1** Schreibe die zwei Zeilen auf, die auf Alpine einen unprivilegierten Benutzer
`springuser` in der Gruppe `spring` anlegen und aktivieren:

```dockerfile
→
```

**2.2** Ab wann wirkt `USER`, und warum muss man die Gruppe selbst anlegen?

→

## 3 Das Passwort im Image finden

**3.1** Baue ein Image aus diesem absichtlich schlechten Dockerfile
(Verzeichnis egal, z. B. ein leerer Ordner):

```dockerfile
FROM alpine:3.20
ENV DB_USER=dhbw-rv
ENV DB_PASSWORD=adw123fde234awe
CMD ["echo","ok"]
```

```sh
→
```

**3.2** Finde das Passwort, ohne den Container zu starten. Welcher Befehl zeigt es?

```sh
→
```

**3.3** Wie übergibt man das Passwort stattdessen, und was ist noch besser?

→

*Selbstkontrolle:* `docker image history --no-trunc <image>` enthält die Zeile mit
`DB_PASSWORD=adw123fde234awe`.

## 4 Lesereihenfolge von Umgebungsvariablen beweisen

Arbeitsverzeichnis: `projekt/greeting`. Baue zuerst die Jar:

```sh
./gradlew bootJar
```

**4.1** Schreibe das Dockerfile (Baseimage `eclipse-temurin:21-jre-noble`,
`ENV GREETING_TEXT="aus dem Dockerfile"`, Jar aus `build/libs/app.jar` nach
`/app/app.jar`, Exec-Notation) und baue `greeting:envtest`.

```dockerfile
→
```

**4.2** Starte den Container auf Host-Port 8080 ohne weitere Angaben und rufe
`/info` auf. Welchen Wert hat `greeting.text`?

```sh
→
```

**4.3** Starte erneut, diesmal mit `--env-file greeting.env` (die Datei setzt
`GREETING_TEXT=Guten Tag`). Welcher Wert gewinnt?

```sh
→
```

**4.4** Starte ein drittes Mal: `--env-file greeting.env` **und**
`-e GREETING_TEXT="direkt am Befehl"`. Welcher Wert gewinnt?

```sh
→
```

**4.5** Schreibe die Lesereihenfolge auf, von schwach nach stark:

… → … → …

*Selbstkontrolle:* `curl -s http://localhost:8080/info` zeigt in den drei Fällen
drei verschiedene Werte, und der letzte gewinnt immer.

## 5 Non-Root nachweisen

Weiter mit dem Image `greeting:envtest` aus Aufgabe 4.

**5.1** Starte einen Container daraus mit `id` als Startkommando.
Welche UID und welche Gruppe kommen zurück?

```sh
→
```

**5.2** Ergänze das Dockerfile so, dass die Anwendung unter einem unprivilegierten
Benutzer läuft. Das Baseimage ist Debian-basiert (`noble`), dort heißen die Befehle
anders als auf Alpine:
`RUN groupadd -r spring && useradd -r -g spring springuser` und danach `USER springuser`.

```dockerfile
→
```

**5.3** Baue neu und prüfe `id` erneut. Was hat sich geändert?

→

*Selbstkontrolle:* `id` liefert vorher `uid=0(root)`, danach einen Namen mit
UID ≠ 0.

## 6 Dockerfile optimieren (vgl. Aufgabe 7)

Gegeben dieses Dockerfile:

```dockerfile
FROM javaee/springdemo:103

ENV JAR_FILE=target/*.jar
ENV USER=dhbw-rv

ENV PWD=adw123fde234awe

RUN apk update

RUN apk add curl

RUN mkdir app

COPY ${JAR_FILE} app.jar

CMD java -jar /app.jar -Xmx1024m
```

**6.1** Finde alle Verstöße gegen die Best Practices:

| Zeile | Verstoß | Korrektur |
| --- | --- | --- |
| … | … | … |
| … | … | … |
| … | … | … |
| … | … | … |
| … | … | … |
| … | … | … |

**6.2** Schreibe das optimierte Dockerfile auf:

```dockerfile
→
```

**6.3** Wie würde der Build-Befehl aussehen?

→

**6.4** Würdest du für dein Image eine stable oder eine unique Versionierung
nutzen? Begründe.

→

**6.5** Warum ist es nicht sinnvoll, einen SSH-Server im Docker Container zu
installieren?

→

**6.6** Kann man den Befehl `mvn clean install` ins Dockerfile aufnehmen?
Was ist die Konsequenz?

→

## 7 Zweites Optimieren (vgl. Hands-On der Folien)

Gegeben:

```dockerfile
FROM ubuntu
RUN apt-get update
RUN apt-get install openjdk-8-jdk -y
RUN apt-get install curl -y
RUN mkdir app
COPY target/* app/
CMD java -jar app.jar
```

**7.1** Fünf Verbesserungen sind möglich. Nenne sie als Schlagworte.

→

**7.2** Schreibe die verbesserte Fassung auf:

```dockerfile
→
```

## 8 ARG gegen ENV

**8.1** Baue ein Image aus diesem Dockerfile und starte einen Container daraus:

```dockerfile
FROM alpine:3.20
ARG BUILD_ID=42
ENV APP_STAGE=prod
RUN echo "gebaut als $BUILD_ID" > /build.txt
CMD ["sh","-c","cat /build.txt; echo stage=$APP_STAGE; echo build=$BUILD_ID"]
```

```sh
→
```

**8.2** Welche der drei Ausgaben ist leer, und warum?

→

**8.3** Formuliere die Regel: Wann `ARG`, wann `ENV`?

→

*Selbstkontrolle:* die Ausgabe ist `gebaut als 42`, `stage=prod` und ein leeres
`build=` — `ARG` existiert zur Laufzeit nicht mehr.

## 9 Verständnis

**9.1** Stable oder unique? Trage ein, wofür du welche Art verwendest und warum:

| | Art des Tags | Beispiel | Warum |
| --- | --- | --- | --- |
| Abhängigkeiten (Baseimages) | … | … | … |
| Eigene erstellte Images | … | … | … |

**9.2** Warum ist `latest` zu vermeiden? Zwei Gründe.

→

**9.3** Nach welchem Kriterium wählst du ein Baseimage aus, und warum bevorzugt man
offizielle Images?

→

**9.4** Warum kombiniert man zusammengehörige `RUN`-Befehle mit `&&`, und warum
sind Wildcards in `COPY` gefährlich?

→

**9.5** Warum müssen abgeleitete Images neu gebaut werden, wenn das Baseimage
aktualisiert wurde?

→

---

# Weiter

- Originalaufgaben: `cloud-computing/origin-tasks/task-7/` (Aufgabe 7, mit Lösung),
  `cloud-computing/origin-tasks/task-8/` (Aufgabe 8, mit Lösung)
- Nächstes Blatt: [04 – Docker Storage](04-storage.md)
