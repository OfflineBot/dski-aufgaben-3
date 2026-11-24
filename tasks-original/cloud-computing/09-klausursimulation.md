# Blatt 09 – Klausursimulation

90 Minuten, 100 Punkte, keine Hilfsmittel. Erst alles schreiben, dann am Rechner
prüfen — Teil F ist bewusst so gebaut, dass du sie wirklich laufen lassen kannst.

Laut `ABOUT.md`: alles über Docker, die Aufgaben des Foliensatzes sind
repräsentativ, auch mit Spring Framework, CLI-Kommando zu Docker-Script und
umgekehrt. Keine abstrakten Theoriefragen, aber das Verständnis muss da sein.

| Teil | Thema | Punkte | Zeit |
| --- | --- | --- | --- |
| A | Grundlagen und Verständnis | 15 | 10 min |
| B | Container bedienen | 15 | 10 min |
| C | Dockerfile schreiben | 20 | 15 min |
| D | Dockerfile optimieren | 15 | 15 min |
| E | Storage, Networking, Compose | 20 | 20 min |
| F | Spring im Container | 15 | 20 min |

---

# Teil A – Grundlagen und Verständnis (15 P)

**A1** (2 P) Welche zwei Linux-Kernelfunktionen nutzt Docker, und wofür?

→

**A2** (2 P) Was unterscheidet ein Docker Image von einem Container?
Zwei Unterschiede.

→

**A3** (2 P) Erklär copy-on-write in zwei Sätzen und sag, was beim Löschen des
Containers mit den Änderungen passiert.

→

**A4** (2 P) Was bedeutet *immutable infrastructure* für die Schichten eines Images?

→

**A5** (2 P) Warum ist `latest` als Tag zu vermeiden? Zwei Gründe.

→

**A6** (2 P) Zerlege `registry.dhbw.de/cc/greeting:1.4.2` in seine vier Abschnitte.

| Registry | User | Image | Version |
| --- | --- | --- | --- |
| … | … | … | … |

**A7** (3 P) Ordne jedem Netzwerktreiber die Isolation (hoch/mittel/keine) und einen
Einsatzzweck zu:

| Treiber | Isolation | Einsatz |
| --- | --- | --- |
| `bridge` | … | … |
| `host` | … | … |
| `none` | … | … |

---

# Teil B – Container bedienen (15 P)

**B1** (3 P) Schreibe den Befehl: Image `nginx`, im Hintergrund, Host-Port 3030 auf
Container-Port 80, Name `web`, Container wird beim Beenden automatisch gelöscht.

```sh
→
```

**B2** (2 P) Du brauchst eine Shell in genau diesem laufenden Container.
Welcher Befehl?

```sh
→
```

**B3** (2 P) Welchen Befehl brauchst du für die Ressourcennutzung, welchen für die
Logausgabe?

```sh
→
```

**B4** (4 P) Übersetze in Prosa und nenne die Falle:

```sh
docker container run -d -p 80:80 --net=host nginx
```

→

**B5** (4 P) Ein Kollege startet einen Container, legt darin eine Datei an, löscht
den Container und startet ihn neu aus demselben Image. Die Datei ist weg.
Erklär ihm das Verhalten und nenne die zwei Mechanismen, mit denen er die Datei
behalten könnte.

→

---

# Teil C – Dockerfile schreiben (20 P)

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

**C1** (14 P)

```dockerfile
→
```

**C2** (2 P) Build-Befehl mit unique Tag, der das Datum enthält:

```sh
→
```

**C3** (2 P) Run-Befehl: Host-Port 8080, `APP_STAGE` auf `test` überschrieben,
Container im Hintergrund.

```sh
→
```

**C4** (2 P) Warum steht das `COPY` der Jar-Datei am Ende und nicht am Anfang?

→

---

# Teil D – Dockerfile optimieren (15 P)

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

**D1** (8 P) Nenne acht Verstöße gegen die Best Practices, je mit einem Satz
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

**D2** (5 P) Schreibe die optimierte Fassung:

```dockerfile
→
```

**D3** (2 P) Wie kommen `DB_USER` und `DB_PASSWORD` stattdessen in den Container,
und mit welchem Befehl könnte ein Angreifer sie im alten Image lesen?

→

---

# Teil E – Storage, Networking, Compose (20 P)

**E1** (4 P) Volume oder Bind Mount? Trage ein:

| Anforderung | Volume oder Bind Mount | Begründung |
| --- | --- | --- |
| Datenbankdateien in Produktion | … | … |
| Quellcode während der Entwicklung live im Container | … | … |
| Konfigurationsdatei vom Host in den nginx-Container | … | … |
| Logs, die ein Container-Neustart überleben sollen | … | … |

**E2** (3 P) Zwei Container im Standardnetz `bridge`. Container A ruft
`wget http://b` auf und bekommt `bad address`. Warum, und was sind die zwei
möglichen Korrekturen?

→

**E3** (5 P) Übersetze diese Befehle in eine `compose.yaml` mit den Services
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

**E4** (4 P) Beantworte zur Datei aus E3:

- Welchen Hostnamen benutzt `web`, um `db` zu erreichen?

  →

- Ist `db` von außen erreichbar? Warum (nicht)?

  →

- Was löscht `docker compose down`, was nicht?

  →

- Welche Option erzwingt einen Neubau der Images?

  →

**E5** (4 P) Schreibe einen Service `app`, dessen Image aus dem Dockerfile im
Ordner `greeting` gebaut wird, der auf Host-Port 3030 hört, seine
Umgebungsvariablen aus `greeting.env` bekommt und im Netz `mynet` liegt:

```yaml
→
```

---

# Teil F – Spring im Container (15 P)

Grundlage: `projekt/greeting`. Diesen Teil kannst du wirklich ausführen.

Anforderung: Die Anwendung soll im Profil `prod` auf Deutsch begrüßen und im Profil
`en` auf Englisch. Die erlaubten ApiKeys kommen aus einer Umgebungsvariable; ohne
gültigen Key kommt eine leere Antwort. Die Anwendung läuft im Container als
unprivilegierter Benutzer auf Host-Port 8080, das Profil steht im Dockerfile
auf `prod` und wird beim Start auf `en` überschrieben.

**F1** (4 P) Welche Java-Klassen legst du an oder änderst du, und welche
Annotationen stehen über jeder? (Klassenköpfe reichen.)

```java
→
```

**F2** (3 P) Mit welcher Annotation liest du die erlaubten ApiKeys als `String[]`
ein, inklusive Standardwert? Schreibe die zwei Zeilen.

```java
→
```

**F3** (4 P) Schreibe das Dockerfile.

```dockerfile
→
```

**F4** (2 P) Schreibe die Befehlskette: Jar bauen, Image bauen, Container starten
mit überschriebenem Profil und ApiKeys aus `greeting.env`.

```sh
→
```

**F5** (2 P) Du änderst nur die Java-Datei und rufst `docker container run` erneut
auf — die Änderung ist nicht da. Welche zwei Schritte hast du vergessen?

→

---

# Auswertung

| Teil | Erreichbar | Erreicht |
| --- | --- | --- |
| A | 15 | … |
| B | 15 | … |
| C | 20 | … |
| D | 15 | … |
| E | 20 | … |
| F | 15 | … |
| **Summe** | **100** | … |

Unter 60 Punkten: das Blatt zu dem schwächsten Teil noch einmal durcharbeiten.

| Teil | Zugehöriges Blatt |
| --- | --- |
| A | [01](01-grundlagen-und-container.md), [02](02-images-und-dockerfile.md), [05](05-networking.md) |
| B | [01](01-grundlagen-und-container.md) |
| C | [02](02-images-und-dockerfile.md), [03](03-best-practices.md) |
| D | [03](03-best-practices.md) |
| E | [04](04-storage.md), [05](05-networking.md), [06](06-compose.md) |
| F | [07](07-spring-und-docker.md) |

Danach die Originalaufgaben mit Lösung: `cloud-computing/origin-tasks/`.
Der Probe-Programmentwurf in `origin-tasks/task-probe-programmentwurf/` ist die
Aufgabenform, die der Prof selbst als Probe gestellt hat.
