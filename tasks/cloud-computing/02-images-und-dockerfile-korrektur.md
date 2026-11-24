# Korrektur Blatt 02 – Docker Image und Dockerfile

## Übersicht

| | Anzahl | Anteil |
| --- | --- | --- |
| ✅ richtig | 6 | 20 % |
| 🟡 teilweise | 14 | 47 % |
| ❌ falsch oder nicht gewusst | 10 | 33 % |

Gewertet sind 30 von 31 Aufgaben. 3.3 zählt nicht, weil man sie nur am Rechner beantworten kann.
Tippfehler und ein fehlendes `-d` sind nicht gewertet.

- ✅ **Richtig:** 1.2 · 2.1 · 7.2 · 7.3 · 8.1 · 8.4
- 🟡 **Teilweise:** 1.1 · 1.3 · 1.5 · 2.2 · 2.3 · 2.4 · 3.1 · 3.2 · 3.4 · 4.3 · 5.2 · 6 · 8.2 · 8.3
- ❌ **Falsch:** 1.4 · 3.5 · 4.1 · 4.2 · 4.4 · 5.1 · 5.3 · 6.1 · 6.2 · 7.1

## Die vier Dinge, die hängen

**1. Bauzeit und Laufzeit verwechselt (1.3, 4.4, 5.1)**

- Beim **Bauen** (`docker image build`) wird das ganze Dockerfile abgearbeitet: `FROM`, `ENV`, `RUN`, `WORKDIR`, `COPY`, `EXPOSE`. Das Ergebnis ist das Image.
- Beim **Starten** eines Containers läuft nur noch `CMD`.
- Du hast `RUN`, `WORKDIR` und `COPY` zur Laufzeit gezählt. Alle drei passieren beim Bauen.

**2. Build-Cache nicht verstanden (4.1, 4.2, 4.4)**

- Beim erneuten Bauen prüft Docker jede Zeile von oben: unverändert → aus dem Cache, in der Ausgabe steht `CACHED`.
- Ab der ersten geänderten Zeile wird diese und **alles darunter** neu gebaut.
- Deshalb: oben, was sich selten ändert. Unten, was sich oft ändert, also das `COPY` des Codes.

**3. `EXPOSE` ist kein Port-Mapping (6, 8.2)**

- `EXPOSE 8080` nennt den Port, auf dem die Anwendung **im Container** horcht. Nach außen geht dadurch nichts.
- Erst `-p 3030:8080` beim `run` macht den Port auf dem Host erreichbar.
- Der Hostport 3030 gehört also nie ins Dockerfile.

**4. `run` und `start` wieder vertauscht (3.4), dazu fehlende Teile beim `run` (3.2, 7.1)**

- `docker container start -e …` gibt es nicht (getestet: `unknown shorthand flag: 'e'`). Ein neuer Container aus einem Image ist `run`.
- Ein Befehl hinter dem Image ersetzt `CMD`: `docker container run <image> <befehl>`.

---

## Die einzelnen Aufgaben

Nur was nicht ganz richtig war.

### 1.1 🟡

- `docker image pull alpine` lädt das Image `alpine` aus der Registry. `alpine` ist hier der Name des Images, keine Variante eines anderen.
- `docker image history` zeigt die **Schichten** des Images.
- Die anderen vier stimmen.

### 1.3 🟡

- `FROM` Bauzeit ✅ · `CMD` Laufzeit ✅
- `RUN`, `WORKDIR`, `COPY` → **Bauzeit** (siehe Punkt 1)
- `ENV` setzt Umgebungs**variablen**, keine Dateien. Der Wert wird beim Bauen festgelegt und gilt zur Laufzeit.
- `EXPOSE` nennt den Port des Containers (siehe Punkt 3).

### 1.4 ❌

- Exec form: `CMD ["java","-jar","app.jar"]`
- Shell form: `CMD java -jar app.jar`
- Unterschied: In der Shell-Form läuft der Befehl als Unterprozess einer Shell. Bricht ein Angreifer aus der Anwendung aus, hat er alle Werkzeuge der Shell. In der Exec-Form läuft nur der Prozess selbst.
- Die Exec-Form hast du in 3.1 und 6 selbst richtig geschrieben. Dir fehlte nur der Name.

### 1.5 🟡

| Tag | Registry | User | Image | Version |
| --- | --- | --- | --- | --- |
| `hub.docker.com/plexinc/pms-docker:latest` | hub.docker.com | plexinc | pms-docker | latest |
| `postgres:17.6` | Standard | keiner, offizielles Image | postgres | 17.6 |
| `nginx` | Standard | keiner, offizielles Image | nginx | latest, weil nichts angegeben |

- Bei dir ist `plexinc` in die Image-Spalte gerutscht. Es ist der User.

### 2.2 🟡

```sh
docker image history alpine:3.20
docker image history nginx
```

- Der Befehl aus der Vorlesung für die Schichten ist `history`.
- `inspect` zeigt alle Details eines Images. Die Schichten stehen dort auch, aber nur als Prüfsummen.

### 2.3 🟡

- Befehl ✅
- Es fehlt die Antwort: zwei Einträge in der Liste, **dieselbe** IMAGE ID, kein zusätzlicher Speicher. Ein Tag ist nur ein Verweis.

### 2.4 🟡

```sh
docker image rm meinalpine:v1
```

- ✅ `alpine:3.20` ist danach noch da.
- ❌ `-t` gibt es bei `rm` nicht (getestet).
- ❌ `alpine:3.20` darf nicht mit in den Befehl. Sonst löschst du genau das Image, das bleiben soll.

### 3.1 🟡

```dockerfile
FROM eclipse-temurin:21-jdk-alpine
ENV PORT=8080
ENV GREETING=Hallo
WORKDIR /app
COPY Zeitserver.java .
EXPOSE 8080
CMD ["java","Zeitserver.java"]
```

- Alles richtig bis auf eine Zeile.
- ❌ `ENV PORT=8080,GREETING=Hallo`: Das Komma trennt nicht. Getestet: `PORT` hat dann den Wert `8080,GREETING=Hallo`, und `GREETING` ist leer. Der Server würde beim Start abstürzen.
- Richtig sind zwei Zeilen, oder eine Zeile mit Leerzeichen: `ENV PORT=8080 GREETING=Hallo`.

### 3.2 🟡

```sh
docker image build -t zeitserver:1.0 .
docker container run -d -p 8080:8080 zeitserver:1.0
```

- ✅ `build`
- ❌ Beim `run` fehlt `-p 8080:8080`. Ohne Mapping ist der Server vom Host aus nicht erreichbar.

### 3.3 nicht gewertet

- Antwort am Rechner: `Hallo von <containerid>`, dazu Zeit und Besuchszähler. In den Logs steht die Startmeldung des Servers.

### 3.4 🟡

```sh
docker container run -d -p 8080:8080 -e GREETING="Moin" zeitserver:1.0
```

- ✅ `-e GREETING=Moin` und die erwartete Antwort
- ❌ `start` statt `run` (siehe Punkt 4)

### 3.5 ❌

- `ENV` setzt nur einen **Startwert**. Der steht im Image, kann aber bei jedem `run` mit `-e` überschrieben werden.
- Das Image selbst ändert sich dabei nicht, deshalb kein Neubau.

### 4.1 ❌

- Gefragt war die Ausgabe von `docker image build`, nicht die Antwort des Servers.
- Hinter jedem Schritt steht `CACHED`. Nichts hat sich geändert, also wird nichts neu gebaut.

### 4.2 ❌

- Aus dem Cache: `FROM`, `ENV`, `WORKDIR`
- Neu gebaut: ab `COPY`, also `COPY`, `EXPOSE`, `CMD`
- Warum ab dort: Die kopierte Datei `Zeitserver.java` hat sich geändert. Das ist die erste Zeile, deren Inhalt anders ist.
- Mit `ENV` und `CMD` hat das nichts zu tun, es geht nur um den Bau.

### 4.3 🟡

- ✅ Fast alles wird neu gebaut, nur `FROM` kommt noch aus dem Cache.
- Der Grund ist aber nicht „durchmischt“: Das `COPY` steht jetzt ganz oben, und alles darunter hängt davon ab.

### 4.4 ❌

- Besser ist die erste Reihenfolge, mit `COPY` weit unten.
- Regel: Je seltener sich eine Zeile ändert, desto weiter oben steht sie. Was sich oft ändert, steht unten.
- Mit Bauzeit und Laufzeit hat die Regel nichts zu tun.

### 5.1 ❌

- Beim Bauen: alle Zeilen von `FROM` bis `EXPOSE`, also auch das `COPY`.
- Beim Starten: nur `CMD`.

### 5.2 🟡

- ✅ Die Jar liegt in `/app/app.jar`.
- Es fehlt: `CMD` startet `/app.jar`, also eine Ebene zu hoch. Das passt nicht.
- Richtig: `CMD ["java","-jar","app.jar"]`, das sucht im `WORKDIR`.

### 5.3 ❌

- `mvn clean install`. Der Befehl baut die Jar-Datei und legt sie in `target/`. Ohne ihn findet `COPY` nichts.

### 6 🟡

```dockerfile
FROM openjdk:16-jdk-alpine
EXPOSE 8080
RUN apk update && apk add vim -y
RUN mkdir -p /usr/src/app
RUN addgroup -S java && adduser -S javauser -G java
USER javauser
COPY target/app.jar /usr/src/app/app.jar
CMD ["java","-jar","/usr/src/app/app.jar"]
```

- ✅ Baseimage, `&&`, die Benutzer-Zeile mit `-G`, `USER`, Exec-Form. Die Benutzer-Zeile war in Runde 1 noch falsch.
- ❌ `EXPOSE 3030`: Im Dockerfile steht der Containerport 8080 (siehe Punkt 3).
- ❌ `COPY ./target/* ./app.jar`: Die Wildcard nimmt alles aus `target`. Richtig ist genau die eine Datei.
- Das ist die Lösung aus der Vorlesung.

### 6.1 ❌

- Technisch geht `RUN mvn clean install` im Dockerfile. Der Befehl läuft dann aber beim Bauen **im Image** und nicht auf dem Host.
- Die Vorlesung empfiehlt dafür Multi-Stage-Dockerfiles.

### 6.2 ❌

```sh
docker image build -t app:1.0 .
docker container run -d -p 3030:8080 app:1.0
```

- Die Frage hat nichts mit Maven zu tun. Gefragt waren die zwei Befehle zu deinem Dockerfile.
- Hier kommt der Hostport 3030 aus der Vorgabe hin: links im `-p`.

### 7.1 ❌

```sh
docker container run zeitserver:1.0 ls -la /app
```

- Was hinter dem Image steht, ersetzt `CMD`. Getestet.
- In 7.2 hast du richtig gesagt, dass `CMD` überschrieben wird. Es fehlte nur der Befehl dazu.

### 8.1 ✅

- Der erste Satz stimmt. Den Zusatz mit „Buildschicht“ und „Laufzeit“ kannst du streichen: Alle Schichten entstehen beim Bauen.

### 8.2 🟡

- ✅ `-p` hast du richtig beschrieben.
- ❌ `EXPOSE` geht nicht „nach außen“ (siehe Punkt 3).

### 8.3 🟡

- ✅ `ENV` wird mit `-e` überschrieben.
- ❌ Die zweite ist `CMD`, überschrieben durch einen Befehl hinter dem Image. `-v` hängt Speicher ein und überschreibt nichts.
