# Blatt 04 – Docker Storage

Container sind flüchtig, Daten sollen es nicht sein. Volumes und Bind Mounts.

Hinweis: `topics/docker/05-docker-storage`

---

# Teil A – Theorie

## 1 Motivation

**1.1** Warum sind Änderungen in einem Container flüchtig? Wie heißt die Schicht,
und wann verschwindet sie?

→

**1.2** Was braucht eine Datenbank, was ein Container von sich aus nicht bietet?

→

**1.3** Was bedeutet *Separation of Concerns* hier konkret? Was ist Code, was Daten?

→

**1.4** Wie lässt sich „immutable infrastructure“ und „persistent data“ gleichzeitig
haben?

→

## 2 Docker Volumes

**2.1** Was ist ein Docker Volume in einem Satz?

→

**2.2** An welchen zwei Stellen kommt ein Volume vor, und was wird jeweils festgelegt?

| Ort | Instruktion / Option | Was wird festgelegt? |
| --- | --- | --- |
| Dockerfile | … | … |
| `docker container run` | … | … |

**2.3** Schreibe die Syntax auf: Volume `myDB` an `/var/lib/mysql` eines
`mysql:8`-Containers.

```sh
→
```

**2.4** Wohin werden Änderungen in einem als Volume deklarierten Verzeichnis
geschrieben — und wohin *nicht* mehr?

→

**2.5** Was passiert mit dem Volume, wenn der Container gelöscht wird?

→

**2.6** Wo kann ein Volume liegen?

→

## 3 Befehle

| Befehl | Wirkung |
| --- | --- |
| `docker volume create myDB` | … |
| `docker volume ls` | … |
| `docker volume inspect myDB` | … |
| `docker volume rm myDB` | … |
| `docker volume prune` | … |

**3.1** Warum kommt man unter Windows und macOS nicht einfach an das
Volume-Verzeichnis?

→

## 4 Bind Mounts

**4.1** Was ist ein Bind Mount, und worin unterscheidet er sich vom Volume?

| | Volume | Bind Mount |
| --- | --- | --- |
| Wer verwaltet den Speicher? | … | … |
| Im Dockerfile deklarierbar? | … | … |
| Typischer Einsatz | … | … |
| Risiko | … | … |

**4.2** Schreibe die Syntax auf: Host-Verzeichnis `/home/student/myproject` an
`/app/myproject` im Container `mytest`.

```sh
→
```

**4.3** In welcher Reihenfolge stehen die beiden Pfade?

→

**4.4** Warum ist ein Bind Mount in der Entwicklung praktisch? Nenne zwei Dateiarten,
die man so einbindet.

→

---

# Teil B – Praxis

## 5 Postgres und das Volume (vgl. Aufgabe 9)

**5.1** Erstelle ein Volume mit dem Namen `psql`.

```sh
→
```

**5.2** Starte einen Container auf Basis von `postgres:17.5` und:

- verknüpfe `psql` mit dem Pfad `/var/lib/postgresql/data`
- setze die Umgebungsvariable `POSTGRES_PASSWORD` auf `mypassword`

```sh
→
```

**5.3** Wechsle interaktiv in den Container und führe dort aus:

- `psql -U postgres` öffnet die Postgres-CLI
- `CREATE TABLE TEST();` erstellt eine neue Tabelle
- `\q` schließt die CLI, danach den Container verlassen

```sh
→
```

**5.4** Stoppe und lösche den Container. Prüfe, dass das Volume noch existiert.

```sh
→
```

**5.5** Starte einen neuen Container auf Basis von `postgres:17.6` — also einer
**anderen Version** — mit demselben Volume und demselben Passwort.

```sh
→
```

**5.6** Wechsle interaktiv hinein, öffne `psql -U postgres`, liste mit `\dt` alle
Tabellen. Ist deine Tabelle `test` dabei?

→

**5.7** Erkläre in zwei Sätzen, warum die Tabelle das Löschen des Containers und
den Versionswechsel überlebt hat.

→

**5.8** Stoppe und lösche den Container, lösche danach das Volume `psql`.

```sh
→
```

**5.9** Starte zum Schluss noch einmal `postgres:17.6` mit einem Volume `psql`
und schau mit `\dt` nach. Was zeigt es jetzt, und warum?

→

*Selbstkontrolle:* in 5.6 listet `\dt` die Tabelle `test`, in 5.9 kommt
`Did not find any relations.`

## 6 Besuchszähler überlebt den Container

Arbeitsverzeichnis: `projekt/zeitserver`, mit dem Image aus Blatt 02
(`zeitserver:1.0`). Der Server zählt Besuche in `$DATA_DIR/besucher.txt`,
Standard `/data`.

**6.1** Starte den Container **ohne** Volume und ruf die Seite dreimal auf.
Welche Zahl steht bei „Besuch Nr.“? Lösche den Container, starte einen neuen und
ruf die Seite wieder auf — welche Zahl steht jetzt da, und warum?

```sh
→
```

**6.2** Ergänze im Dockerfile `VOLUME /data` und baue das Image neu als
`zeitserver:1.1`.

```dockerfile
→
```

**6.3** Erstelle ein Volume `zeitdaten`, starte den Container damit an `/data`
und ruf die Seite dreimal auf.

```sh
→
```

**6.4** Lösche den Container. Starte einen neuen mit demselben Volume und ruf
die Seite auf. Bei welcher Zahl geht es weiter?

→

**6.5** Finde heraus, wo das Volume auf dem Host liegt, und lies die Datei
`besucher.txt` (unter Linux direkt, sonst über einen Container mit Bind Mount).

```sh
→
```

**6.6** Lösche das Volume und starte erneut. Was steht jetzt in der Antwort?

→

*Selbstkontrolle:* in 6.1 zählt der Zähler innerhalb des Containers hoch, beginnt
aber bei jedem **neuen** Container wieder bei 1; ab 6.3 zählt er über
Containergrenzen hinweg weiter.

## 7 Bind Mount für eine Webseite

**7.1** Lege auf dem Host ein Verzeichnis `site` an mit einer `index.html`,
die „Hallo aus dem Bind Mount“ enthält.

```sh
→
```

**7.2** Starte nginx so, dass dieses Verzeichnis unter
`/usr/share/nginx/html` im Container liegt, erreichbar auf Host-Port 8080.

```sh
→
```

**7.3** Ändere die `index.html` auf dem Host und lade die Seite neu, **ohne**
den Container anzufassen. Was siehst du?

→

**7.4** Warum geht das mit einem Volume so nicht?

→

**7.5** Binde die Datei schreibgeschützt ein (`:ro` am Ende der `-v`-Angabe) und
versuche im Container `echo x >> /usr/share/nginx/html/index.html`. Ergebnis?

→

*Selbstkontrolle:* `curl http://localhost:8080` liefert deinen Text, und nach dem
Editieren auf dem Host sofort den neuen — ohne Neustart.

## 8 Bind Mount für die Entwicklung

**8.1** Starte `eclipse-temurin:21-jdk-alpine` interaktiv und binde
`projekt/zeitserver` auf dem Host an `/src` im Container.

```sh
→
```

**8.2** Starte im Container `java /src/Zeitserver.java`. Ändere auf dem Host den
Begrüßungstext in der Java-Datei und starte im Container erneut. Was passiert,
und warum musst du kein Image bauen?

→

**8.3** Welchen Nachteil hat dieses Vorgehen für den produktiven Betrieb?

→

## 9 Was überlebt was?

**9.1** Trage ein, was nach jeder Aktion noch existiert (`ja` / `nein`):

| Aktion | Container | Daten im r/w-Layer | Daten im Volume | Image |
| --- | --- | --- | --- | --- |
| `docker container stop` | … | … | … | … |
| `docker container rm` | … | … | … | … |
| `docker image rm` (nach rm des Containers) | … | … | … | … |
| `docker volume rm` | … | … | … | … |
| `docker volume prune` bei laufendem Container | … | … | … | … |

**9.2** Du willst die Datenbank eines Projekts komplett zurücksetzen.
Welche zwei Befehle brauchst du, in welcher Reihenfolge?

→

**9.3** Du willst nur die Anwendung aktualisieren, die Daten aber behalten.
Was machst du, was nicht?

→

---

# Weiter

- Originalaufgabe: `cloud-computing/origin-tasks/task-9/` (Aufgabe 9, mit Lösung)
- Nächstes Blatt: [05 – Docker Networking](05-networking.md)
