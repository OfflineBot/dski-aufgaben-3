# Blatt 09 – Klausursimulation

90 Minuten, 100 Punkte, keine Hilfsmittel. Erst alles schreiben, dann am Rechner
prüfen — Teil E ist so gebaut, dass du ihn wirklich laufen lassen kannst.

Laut `ABOUT.md`: alles über Docker, die Aufgaben des Foliensatzes sind
repräsentativ, auch mit Spring Framework, CLI-Kommando zu Docker-Script und
umgekehrt. Keine Theoriefragen, aber das Verständnis muss da sein.

| Teil | Thema | Punkte | Zeit |
| --- | --- | --- | --- |
| A | Container bedienen | 15 | 10 min |
| B | Dockerfile schreiben | 20 | 15 min |
| C | Dockerfile optimieren | 15 | 15 min |
| D | Storage, Networking, Compose | 25 | 25 min |
| E | Spring im Container | 25 | 25 min |

---

# Teil A – Container bedienen (15 P)

**A1** (3 P) Schreibe den Befehl: Image `nginx`, im Hintergrund, Host-Port 3030 auf
Container-Port 80, Name `web`, Container wird beim Beenden automatisch gelöscht.

```sh
→
```

**A2** (2 P) Du brauchst eine Shell in genau diesem laufenden Container.
Welcher Befehl?

```sh
→
```

**A3** (2 P) Welchen Befehl brauchst du für die Ressourcennutzung, welchen für die
Logausgabe?

```sh
→
```

**A4** (4 P) Beschreibe, was dieser Befehl tut, und nenne die Falle:

```sh
docker container run -d -p 80:80 --net=host nginx
```

→

**A5** (4 P) Ein Kollege startet einen Container, legt darin eine Datei an, löscht
den Container und startet einen neuen aus demselben Image. Die Datei ist weg.
Erklär ihm das Verhalten und nenne die zwei Mechanismen, mit denen er die Datei
behalten könnte.

→

---

# Teil B – Dockerfile schreiben (20 P)

Schreibe ein Dockerfile nach diesen Vorgaben und nach den Best Practices:

- Baseimage: offizielles `eclipse-temurin`, Version `21-jre-alpine`
- die Anwendung liest die Umgebungsvariable `APP_STAGE` mit dem Startwert `prod`
- das Paketverzeichnis wird aktualisiert und `curl` installiert, in **einer** Schicht
- es gibt das Verzeichnis `/usr/src/app`, das auch Arbeitsverzeichnis ist
- die Anwendung läuft unter dem neuen Benutzer `appuser` in der neuen Gruppe `app`
  (Alpine: `addgroup -S` / `adduser -S … -G …`)
- die Datei `build/libs/app.jar` wird als `app.jar` ins Arbeitsverzeichnis kopiert
- Port 8080 wird freigegeben
- Start: `java -jar app.jar` in Exec-Notation

**B1** (14 P)

```dockerfile
→
```

**B2** (2 P) Build-Befehl mit einem unique Tag, der das heutige Datum enthält:

```sh
→
```

**B3** (2 P) Run-Befehl: Host-Port 8080, `APP_STAGE` auf `test` überschrieben,
Container im Hintergrund.

```sh
→
```

**B4** (2 P) Warum steht das `COPY` der Jar-Datei am Ende und nicht am Anfang?

→

---

# Teil C – Dockerfile optimieren (15 P)

Gegeben:

```dockerfile
FROM ubuntu:latest

ENV DB_USER=admin
ENV DB_PASSWORD=geheim123

RUN apt-get update
RUN apt-get install -y openjdk-21-jdk
RUN apt-get install -y curl
RUN apt-get install -y openssh-server

COPY target/* /app/

WORKDIR /app

CMD java -jar app.jar
```

**C1** (8 P) Nenne acht Verstöße gegen die Best Practices, je mit einem Satz
Begründung:

| Nr. | Verstoß | Warum schlecht |
| --- | --- | --- |
| 1 | … | … |
| 2 | … | … |
| 3 | … | … |
| 4 | … | … |
| 5 | … | … |
| 6 | … | … |
| 7 | … | … |
| 8 | … | … |

**C2** (5 P) Schreibe die optimierte Fassung:

```dockerfile
→
```

**C3** (2 P) Wie kommen `DB_USER` und `DB_PASSWORD` stattdessen in den Container,
und mit welchem Befehl könnte ein Angreifer sie im alten Image lesen?

→

---

# Teil D – Storage, Networking, Compose (25 P)

**D1** (4 P) Volume oder Bind Mount? Trage ein:

| Anforderung | Volume oder Bind Mount | Begründung |
| --- | --- | --- |
| Datenbankdateien in Produktion | … | … |
| Quellcode während der Entwicklung live im Container | … | … |
| Konfigurationsdatei vom Host in den nginx-Container | … | … |
| Daten, die das Löschen des Containers überleben sollen | … | … |

**D2** (3 P) Zwei Container im Standardnetz `bridge`. Container A ruft
`wget http://b` auf und bekommt `bad address`. Warum, und was sind die zwei
möglichen Korrekturen?

→

**D3** (5 P) Übersetze diese Befehle in eine `compose.yaml` mit den Services
`web` und `db`:

```sh
docker network create mynet --driver=bridge
docker volume create psql
docker container run -d --name web --net=mynet -p 8080:80 nginx
docker container run -d --name db --net=mynet \
  -e POSTGRES_PASSWORD=mypassword \
  -v psql:/var/lib/postgresql/data postgres:17.6
```

```yaml
→
```

**D4** (4 P) Beantworte zur Datei aus D3:

- Welchen Hostnamen benutzt `web`, um `db` zu erreichen?

  →

- Ist `db` von außen erreichbar? Warum (nicht)?

  →

- Was löscht `docker compose down`, was nicht?

  →

- Welche Option erzwingt einen Neubau der Images?

  →

**D5** (4 P) Schreibe eine `compose.yaml` mit einem Service `app`, dessen Image aus
dem Dockerfile im Ordner `greeting` gebaut wird, der unter Host-Port 3030 erreichbar
ist (die Anwendung horcht im Container auf 8080), seine Umgebungsvariablen aus
`greeting/greeting.env` bekommt und im neu angelegten Netz `mynet` liegt:

```yaml
→
```

**D6** (5 P) Die Gegenrichtung. Schreibe die `docker`-Befehle, die dasselbe
erreichen wie diese Datei, in der richtigen Reihenfolge:

```yaml
services:
  cache:
    image: redis:7
    ports:
      - "6380:6379"
    environment:
      LOG_LEVEL: warning
    volumes:
      - cachedaten:/data
    networks:
      - backend

volumes:
  cachedaten:

networks:
  backend:
    driver: bridge
```

```sh
→
```

---

# Teil E – Spring im Container (25 P)

Grundlage: `projekt/greeting` und `projekt/proxy/nginx.conf`. Diesen Teil kannst du
wirklich ausführen. Die Anwendung horcht auf Port 8080, die Jar entsteht mit
`./gradlew bootJar` unter `build/libs/app.jar`, der Proxy leitet an
`http://greeting:8080` weiter.

Anforderung: Die Anwendung soll im Profil `prod` auf Deutsch begrüßen und im Profil
`en` auf Englisch. Die erlaubten ApiKeys kommen aus einer Umgebungsvariable; ohne
gültigen Key kommt eine leere Antwort. Die Anwendung läuft im Container als
unprivilegierter Benutzer, das Profil steht im Dockerfile auf `prod`.

**E1** (4 P) Welche Java-Klassen legst du an oder änderst du, und welche
Annotationen stehen über jeder? (Klassenköpfe reichen.)

```java
→
```

**E2** (3 P) Mit welcher Annotation liest du die erlaubten ApiKeys als `String[]`
ein, inklusive Standardwert? Schreibe die zwei Zeilen.

```java
→
```

**E3** (5 P) Schreibe das Dockerfile (Baseimage `eclipse-temurin:21-jre-alpine`).

```dockerfile
→
```

**E4** (3 P) Schreibe die Befehlskette: Jar bauen, Image `greeting:1.0` bauen,
Container im Hintergrund auf Host-Port 8080 starten, Profil auf `en` überschrieben,
ApiKeys aus `greeting.env`.

```sh
→
```

**E5** (5 P) Schreibe die `compose.yaml` für `projekt/`: Service `proxy` (Image
`nginx`, Hostport 8080 auf Containerport 80, `proxy/nginx.conf` eingebunden unter
`/etc/nginx/conf.d/default.conf`) und der Spring-Service (aus `greeting/` gebaut,
Variablen aus `greeting/greeting.env`), beide im neu angelegten Bridge-Netzwerk
`appnet`.

```yaml
→
```

**E6** (3 P) Wie muss der Spring-Service in E5 heißen, damit der Proxy ihn findet,
und warum braucht er selbst keinen `ports`-Eintrag?

→

**E7** (2 P) Du änderst nur die Java-Datei und rufst `docker compose up` erneut
auf — die Änderung ist nicht da. Welche zwei Schritte hast du vergessen?

→

---

# Auswertung

| Teil | Erreichbar | Erreicht |
| --- | --- | --- |
| A | 15 | … |
| B | 20 | … |
| C | 15 | … |
| D | 25 | … |
| E | 25 | … |
| **Summe** | **100** | … |

Unter 60 Punkten: das Blatt zu dem schwächsten Teil noch einmal durcharbeiten.

| Teil | Zugehöriges Blatt |
| --- | --- |
| A | [01](01-grundlagen-und-container.md) |
| B | [02](02-images-und-dockerfile.md), [03](03-best-practices.md) |
| C | [03](03-best-practices.md) |
| D | [04](04-storage.md), [05](05-networking.md), [06](06-compose.md), [08](08-uebersetzen-cli-und-script.md) |
| E | [07](07-spring-und-docker.md) |

Danach die Originalaufgaben mit Lösung: `cloud-computing/origin-tasks/`.
Der Probe-Programmentwurf in `origin-tasks/task-probe-programmentwurf/` ist die
Aufgabenform, die der Prof selbst als Probe gestellt hat.
