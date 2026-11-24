# Blatt 04 – Docker Storage

Container sind flüchtig, Daten sollen es nicht sein. Volumes und Bind Mounts.

Hinweis: `topics/docker/05-docker-storage`

---

## 1 Befehle und Syntax kennen

**1.1** Was macht jeder Befehl?

| Befehl | Wirkung |
| --- | --- |
| `docker volume create myDB` | … |
| `docker volume ls` | … |
| `docker volume inspect myDB` | … |
| `docker volume rm myDB` | … |
| `docker volume prune` | … |

**1.2** Schreibe den Befehl: Volume `myDB` an `/var/lib/mysql` eines
`mysql:8`-Containers.

```sh
→
```

**1.3** Schreibe den Befehl: Host-Verzeichnis `/home/student/myproject` an
`/app/myproject` in einem Container aus dem Image `mytest`.

```sh
→
```

**1.4** In welcher Reihenfolge stehen die beiden Angaben bei `-v`, und woran
erkennt man, ob ein Volume oder ein Bind Mount gemeint ist?

→

## 2 Postgres und das Volume (vgl. Aufgabe 9)

**2.1** Erstelle ein Volume mit dem Namen `psql`.

```sh
→
```

**2.2** Starte einen Container auf Basis von `postgres:17.5` und:

- verknüpfe `psql` mit dem Pfad `/var/lib/postgresql/data`
- setze die Umgebungsvariable `POSTGRES_PASSWORD` auf `mypassword`

```sh
→
```

**2.3** Wechsle interaktiv in den Container und führe dort aus:

- `psql -U postgres` öffnet die Postgres-CLI
- `CREATE TABLE TEST();` erstellt eine neue Tabelle
- `\q` schließt die CLI, danach den Container verlassen

```sh
→
```

**2.4** Stoppe und lösche den Container. Prüfe, dass das Volume noch existiert.

```sh
→
```

**2.5** Starte einen neuen Container auf Basis von `postgres:17.6` — also einer
**anderen Version** — mit demselben Volume und demselben Passwort.

```sh
→
```

**2.6** Wechsle interaktiv hinein, öffne `psql -U postgres`, liste mit `\dt` alle
Tabellen. Ist deine Tabelle `test` dabei?

→

**2.7** Erkläre in zwei Sätzen, warum die Tabelle das Löschen des Containers
überlebt hat.

→

**2.8** Stoppe und lösche den Container, lösche danach das Volume `psql`.

```sh
→
```

*Selbstkontrolle:* in 2.6 listet `\dt` die Tabelle `test`.

## 3 Besuchszähler überlebt den Container

Arbeitsverzeichnis: `projekt/zeitserver`. Der Server zählt Besuche in
`/data/besucher.txt`. Ausgangspunkt ist dieses Dockerfile:

```dockerfile
FROM eclipse-temurin:21-jdk-alpine
ENV PORT=8080
ENV GREETING=Hallo
WORKDIR /app
COPY Zeitserver.java .
EXPOSE 8080
CMD ["java","Zeitserver.java"]
```

**3.1** Baue daraus `zeitserver:1.0`. Starte einen Container **ohne** Volume auf
Host-Port 8080 und ruf die Seite dreimal auf. Welche Zahl steht bei „Besuch Nr.“?
Lösche den Container, starte einen neuen und ruf die Seite wieder auf — welche
Zahl steht jetzt da, und warum?

```sh
→
```

**3.2** Ergänze im Dockerfile `VOLUME /data` und baue das Image neu als
`zeitserver:1.1`.

```dockerfile
→
```

**3.3** Erstelle ein Volume `zeitdaten`, starte den Container damit an `/data`
und ruf die Seite dreimal auf.

```sh
→
```

**3.4** Lösche den Container. Starte einen neuen mit demselben Volume und ruf
die Seite auf. Bei welcher Zahl geht es weiter?

→

**3.5** Lösche das Volume und starte erneut. Was steht jetzt in der Antwort?

→

*Selbstkontrolle:* in 3.1 beginnt der Zähler bei jedem **neuen** Container wieder
bei 1; ab 3.3 zählt er über Containergrenzen hinweg weiter.

## 4 Bind Mount für eine Webseite

**4.1** Lege auf dem Host ein Verzeichnis `site` an mit einer `index.html`,
die „Hallo aus dem Bind Mount“ enthält.

```sh
→
```

**4.2** Starte nginx so, dass dieses Verzeichnis unter
`/usr/share/nginx/html` im Container liegt, erreichbar auf Host-Port 8080.

```sh
→
```

**4.3** Ändere die `index.html` auf dem Host und lade die Seite neu, **ohne**
den Container anzufassen. Was siehst du?

→

*Selbstkontrolle:* `curl http://localhost:8080` liefert deinen Text, und nach dem
Editieren auf dem Host sofort den neuen — ohne Neustart.

## 5 Verständnis

**5.1** Trage ein, was nach jeder Aktion noch existiert (`ja` / `nein`):

| Aktion | Container | Daten in der beschreibbaren Schicht | Daten im Volume | Image |
| --- | --- | --- | --- | --- |
| `docker container stop` | … | … | … | … |
| `docker container rm` | … | … | … | … |
| `docker volume rm` (nach rm des Containers) | … | … | … | … |

**5.2** Volume oder Bind Mount? Je eine Zeile Begründung.

| Anforderung | Volume oder Bind Mount | Begründung |
| --- | --- | --- |
| Datenbankdateien | … | … |
| Quellcode während der Entwicklung live im Container | … | … |
| Konfigurationsdatei vom Host in den nginx-Container | … | … |

**5.3** Du willst nur die Anwendung aktualisieren, die Daten aber behalten.
Was löschst du, was nicht?

→

---

# Weiter

- Originalaufgabe: `cloud-computing/origin-tasks/task-9/` (Aufgabe 9, mit Lösung)
- Nächstes Blatt: [05 – Docker Networking](05-networking.md)
