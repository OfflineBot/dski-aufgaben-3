# Blatt 03 – Best Practices

Die Konventionen, nach denen in der Klausur ein Dockerfile bewertet wird:
Baseimage, Tagging, Umgebungsvariablen, Schichtenreihenfolge, non-root.

Hinweis: `topics/docker/04-best-practices`

---

# Teil A – Theorie

## 1 Baseimage

**1.1** Nach welchem Kriterium wählst du ein Baseimage aus, und welche drei Vorteile
bringt ein kleinerer Funktionsumfang?

→

**1.2** Trage die Größen aus den Folien ein und rechne das Verhältnis zu `alpine`:

| Image | Größe | Faktor gegenüber alpine |
| --- | --- | --- |
| `ubuntu` | … | … |
| `opensuse:latest` | … | … |
| `alpine` | … | 1 |

**1.3** Warum offizielle Images bevorzugen? Zwei Gründe.

→

**1.4** Mit welchem Tag wird ein Baseimage referenziert, und mit welchem **nie**?

→

**1.5** Warum müssen abgeleitete Images bei Aktualisierungen des Baseimage neu
gebaut werden? Was passiert mit Patches, die man zur Laufzeit im Container einspielt?

→

## 2 Tagging

**2.1** Vier Gründe, warum `latest` strikt zu vermeiden ist:

→

**2.2** Stable oder unique? Trage ein, wofür du welche Art verwendest und warum:

| | Art des Tags | Beispiel | Warum |
| --- | --- | --- | --- |
| Abhängigkeiten (Baseimages) | … | … | … |
| Eigene erstellte Images | … | … | … |

**2.3** Was sollte man in unique Tags sinnvollerweise integrieren, und wovor wird
bei Git-Tags gewarnt?

→

**2.4** Welches Problem entsteht konkret, wenn zwei verschiedene Versionsstände
denselben Tag tragen (einmal in der Registry, einmal lokal auf dem Client)?

→

## 3 Umgebungsvariablen

**3.1** Warum dürfen sensible Daten wie Passwörter nicht per `ENV` ins Dockerfile?
Nenne den Befehl, mit dem man sie auslesen könnte.

→

**3.2** Wie übergibt man sensible Daten stattdessen, und was ist noch besser?

→

**3.3** Wann lohnt sich eine `--env-file`?

→

**3.4** Die Lesereihenfolge, von schwach nach stark:

… → … → …

**3.5** Wann `ARG` statt `ENV`?

→

## 4 Schichtenarchitektur

**4.1** Nach welchem Kriterium ordnest du die Instruktionen im Dockerfile an?
Was steht oben, was unten?

→

**4.2** Das Dockerfile aus den Folien ist falsch angeordnet. Sortiere es neu und
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

**4.3** Welchen konkreten Schaden richtet das `COPY` an Position 2 bei jedem
Compiliervorgang an?

→

**4.4** Warum kombiniert man zusammengehörige `RUN`-Befehle mit `&&`?

→

**4.5** Warum sind Wildcards in `COPY` gefährlich?

→

## 5 Non-Root-Ausführung

**5.1** Unter welchem Account laufen Prozesse im Container in der Standard­konfiguration?

→

**5.2** Warum ist das kritisch? (Stichwort: Ausbruch, Gleichberechtigung zum
nativen Prozess)

→

**5.3** Mit welcher Instruktion wechselt man den Benutzer, und ab wann wirkt sie?

→

**5.4** Welchem Fallstrick muss man beim Anlegen eines neuen Benutzers ausweichen?

→

**5.5** Schreibe die zwei Zeilen auf, die auf Alpine einen unprivilegierten Benutzer
`springuser` in der Gruppe `spring` anlegen und aktivieren:

```dockerfile
→
```

---

# Teil B – Praxis

## 6 Das Passwort im Image finden

**6.1** Baue ein Image aus diesem absichtlich schlechten Dockerfile
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

**6.2** Finde das Passwort, ohne den Container zu starten. Welcher Befehl zeigt es?

```sh
→
```

**6.3** Zeige, dass es auch ohne History geht: `docker image inspect` mit Blick auf
den Abschnitt `Env`.

```sh
→
```

**6.4** Formuliere in zwei Sätzen, was das für ein Image bedeutet, das in einer
Registry liegt.

→

*Selbstkontrolle:* `docker image history --no-trunc <image>` enthält die Zeile mit
`DB_PASSWORD=adw123fde234awe`.

## 7 Lesereihenfolge von Umgebungsvariablen beweisen

Arbeitsverzeichnis: `projekt/greeting`. Baue zuerst die Jar und ein Image, dessen
Dockerfile `ENV GREETING_TEXT="aus dem Dockerfile"` setzt.

```sh
./gradlew bootJar
```

**7.1** Schreibe das Dockerfile (Baseimage `eclipse-temurin:21-jre-noble`,
`ENV GREETING_TEXT="aus dem Dockerfile"`, Jar nach `/app/app.jar`, Exec-Notation)
und baue `greeting:envtest`.

```dockerfile
→
```

**7.2** Starte den Container ohne weitere Angaben und rufe `/info` auf. Welchen
Wert hat `greeting.text`?

```sh
→
```

**7.3** Starte erneut, diesmal mit `--env-file greeting.env` (die Datei setzt
`GREETING_TEXT=Guten Tag`). Welcher Wert gewinnt?

```sh
→
```

**7.4** Starte ein drittes Mal: `--env-file greeting.env` **und**
`-e GREETING_TEXT="direkt am Befehl"`. Welcher Wert gewinnt?

```sh
→
```

**7.5** Trage das Ergebnis ein und vergleiche mit der Regel aus 3.4:

| Start | Wert von `greeting.text` |
| --- | --- |
| nur Dockerfile | … |
| Dockerfile + env-file | … |
| Dockerfile + env-file + `-e` | … |

*Selbstkontrolle:* `curl -s http://localhost:8080/info` zeigt in den drei Fällen
drei verschiedene Werte, und der letzte gewinnt immer.

## 8 Non-Root nachweisen

**8.1** Starte einen Container aus deinem Image von 7.1 mit `id` als Startkommando.
Welche UID und welche Gruppe kommen zurück?

```sh
→
```

**8.2** Ergänze das Dockerfile so, dass die Anwendung unter einem unprivilegierten
Benutzer läuft. Das Baseimage ist Debian-basiert (`noble`), also:
`RUN groupadd -r spring && useradd -r -g spring springuser` und danach `USER springuser`.

```dockerfile
→
```

**8.3** Baue neu und prüfe `id` erneut. Was hat sich geändert?

→

**8.4** Versuche im laufenden Container, eine Datei unter `/` anzulegen
(`docker container exec <id> touch /test`). Was passiert jetzt, was wäre vorher
passiert?

→

*Selbstkontrolle:* `id` liefert vorher `uid=0(root)`, danach einen Namen mit
UID ≠ 0; das `touch /test` schlägt mit `Permission denied` fehl.

## 9 Image-Größe messen

Achtung bei Alpine: dort heißen die Befehle zum Anlegen des Benutzers
`addgroup -S app && adduser -S appuser -G app`, nicht `groupadd`/`useradd`.

**9.1** Baue dasselbe Spring-Image dreimal, nur mit anderem Baseimage:
`eclipse-temurin:21-jdk-noble`, `eclipse-temurin:21-jre-noble`,
`eclipse-temurin:21-jre-alpine`. Tagge sie `greeting:jdk`, `greeting:jre`,
`greeting:alpine`.

```sh
→
```

**9.2** Trage die Größen ein:

| Tag | Baseimage | Größe |
| --- | --- | --- |
| `greeting:jdk` | … | … |
| `greeting:jre` | … | … |
| `greeting:alpine` | … | … |

**9.3** Welches nimmst du für den produktiven Betrieb, und mit welchen zwei
Argumenten aus den Best Practices begründest du das?

→

**9.4** Warum reicht ein JRE-Image, obwohl die Anwendung in Java geschrieben ist?

→

## 10 Dockerfile optimieren (vgl. Aufgabe 7)

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

**10.1** Finde alle Verstöße gegen die Best Practices. Pro Zeile eine Zeile in der
Tabelle:

| Zeile | Verstoß | Korrektur |
| --- | --- | --- |
| … | … | … |
| … | … | … |
| … | … | … |
| … | … | … |
| … | … | … |
| … | … | … |

**10.2** Schreibe das optimierte Dockerfile auf:

```dockerfile
→
```

**10.3** Wie würde der Build-Befehl aussehen?

→

**10.4** Würdest du für dein Image eine stable oder eine unique Versionierung
nutzen? Begründe.

→

**10.5** Warum ist es nicht sinnvoll, einen SSH-Server im Docker Container zu
installieren?

→

**10.6** Kann man den Befehl `mvn clean install` ins Dockerfile aufnehmen?
Was ist die Konsequenz?

→

## 11 Zweites Optimieren (vgl. Hands-On der Folien)

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

**11.1** Fünf Verbesserungen sind möglich. Nenne sie als Schlagworte.

→

**11.2** Schreibe die verbesserte Fassung auf:

```dockerfile
→
```

**11.3** Wie viele Schichten hat die Ausgangsfassung, wie viele deine Fassung?

→

**11.4** Welche der Verbesserungen ist eine *Sicherheits*verbesserung, welche eine
*Performance*verbesserung?

→

## 12 ARG gegen ENV

**12.1** Baue ein Image aus diesem Dockerfile und übergib beim Bauen
`--build-arg BUILD_ID=42`:

```dockerfile
FROM alpine:3.20
ARG BUILD_ID=unbekannt
ENV APP_STAGE=prod
RUN echo "gebaut als $BUILD_ID" > /build.txt
CMD ["sh","-c","cat /build.txt; echo stage=$APP_STAGE; echo build=$BUILD_ID"]
```

```sh
→
```

**12.2** Starte den Container. Welche der drei Ausgaben ist leer, und warum?

→

**12.3** Formuliere die Regel: Wann `ARG`, wann `ENV`?

→

*Selbstkontrolle:* `/build.txt` enthält `gebaut als 42`, `stage=prod`, aber
`build=` ist leer — `ARG` existiert zur Laufzeit nicht mehr.

---

# Weiter

- Originalaufgaben: `cloud-computing/origin-tasks/task-7/` (Aufgabe 7, mit Lösung),
  `cloud-computing/origin-tasks/task-8/` (Aufgabe 8, mit Lösung)
- Nächstes Blatt: [04 – Docker Storage](04-storage.md)
