# Blatt 06 – Docker Compose

Von einzelnen `run`-Befehlen zur deklarativen Datei. YAML zuerst, dann
Container-Gruppen.

Hinweis: `topics/docker/07-docker-compose`

---

# Teil A – Theorie

## 1 Motivation

**1.1** Welche drei Probleme hat das Starten mehrerer Container per CLI?

→

**1.2** Was ist der deklarative Ansatz, und welche drei Befehle ersetzt die Datei?

→

**1.3** Was macht aus einer Sammlung einzelner Container eine „orchestrierte
Anwendung“?

→

## 2 YAML

**2.1** Wofür steht die Abkürzung, und was ist YAML *nicht*?

→

**2.2** Wie wird Struktur abgebildet, und was passiert bei falscher Einrückung?

→

**2.3** Welche vier primitiven Datentypen kennt YAML, und wie wird der Typ bestimmt?

→

**2.4** Bestimme Schlüssel, Wert und Datentyp:

```yaml
Stunden: 55
Programmierung: true
Raum: Labor
Note: 1.3
Kuerzel: "true"
```

| Schlüssel | Wert | Datentyp |
| --- | --- | --- |
| `Stunden` | … | … |
| `Programmierung` | … | … |
| `Raum` | … | … |
| `Note` | … | … |
| `Kuerzel` | … | … |

**2.5** Wie werden Zeilenkommentare gekennzeichnet?

→

**2.6** Ist YAML case-sensitive? Was bedeutet das für `Image:` und `image:`?

→

**2.7** Die drei erweiterten Datentypen und ihre Notation:

| Typ | Notation | Geordnet? | Zugriff |
| --- | --- | --- | --- |
| Objekt / Dictionary | … | … | … |
| Liste | … | … | … |

**2.8** Lies die Struktur und beantworte: Wie viele Einträge hat `DHBW`,
und wie sprichst du die Studierendenzahl von Heidenheim an?

```yaml
DHBW:
  Ravensburg:
    Studierende: 2223
    Mitarbeiter: 190
  Heidenheim:
    Studierende: 2413
    Mitarbeiter: 176
```

→

**2.9** Schreibe die drei Studiengänge Wirtschaftsinformatik, Data Science und
Elektrotechnik als YAML-Liste unter dem Schlüssel `Studiengänge`:

```yaml
→
```

**2.10** Was bedeutet ein Schlüssel ohne Wert?

→

## 3 Aufbau der compose.yaml

**3.1** Wie heißt die Datei, und was stand früher in der obersten Zeile?

→

**3.2** Die drei Abschnitte und ihr Inhalt:

| Abschnitt | Inhalt |
| --- | --- |
| … | … |
| … | … |
| … | … |

**3.3** Was ist ein *Service* bei Compose?

→

**3.4** Welche Rolle hat der Servicename für die Kommunikation zwischen Containern?

→

**3.5** Ordne jedem Schlüssel innerhalb eines Service die Bedeutung zu:

| Schlüssel | Bedeutung |
| --- | --- |
| `image` | … |
| `build` | … |
| `ports` | … |
| `environment` | … |
| `volumes` | … |
| `networks` | … |

**3.6** Lies die Datei und beantworte die Fragen darunter:

```yaml
services:
 web:
  image: nginx
  ports:
   - "8080:80"
  environment:
   Log_Level: Info
  networks:
   - mynet

volumes:
 psql:

networks:
 mynet:
```

- Welchen Port ruft der Browser auf, welchen hört der Container?

  →

- Welcher Treiber wird für `mynet` verwendet, obwohl keiner dasteht?

  →

- Wird das Volume `psql` hier überhaupt benutzt?

  →

## 4 Image Building

**4.1** Welche zwei Angaben braucht der `build`-Abschnitt?

→

**4.2** Nach welchem Schema wird das gebaute Image benannt?

→

**4.3** Wann wird neu gebaut, und mit welcher Option erzwingst du es?

→

**4.4** Mit welchem Zusatz löscht `docker compose down` auch die selbst gebauten
Images?

→

## 5 Befehle und Verhalten

| Befehl | Wirkung |
| --- | --- |
| `docker compose up` | … |
| `docker compose up --build` | … |
| `docker compose down` | … |
| `docker compose down --rmi=local` | … |

**5.1** Woher nimmt Compose den Projektnamen?

→

**5.2** In welcher Reihenfolge werden Netzwerk, Volume und Container erstellt?

→

**5.3** Was löscht `docker compose down` *nicht*, und warum ist das so gewollt?

→

**5.4** Warum bekommt jeder Service in der Logausgabe eine eigene Farbe?

→

---

# Teil B – Praxis

## 6 YAML reparieren

Jede Datei hat genau einen Fehler. Finde ihn und schreibe die korrigierte Zeile auf.

**6.1**

```yaml
services:
web:
  image: nginx
  ports:
    - "8080:80"
```

→

**6.2**

```yaml
services:
  web:
    image: nginx
    ports:
      "8080:80"
```

→

**6.3**

```yaml
services:
  db:
    image: postgres:17.6
    environment:
      POSTGRES_PASSWORD: mypassword
    volumes:
      - psql:/var/lib/postgresql/data
```

(Hinweis: hier fehlt nichts *innerhalb* des Services.)

→

**6.4** Prüfe deine Korrekturen mit `docker compose config` — der Befehl liest die
Datei und gibt sie normalisiert wieder aus. Welche Fehlermeldung kam vorher?

→

## 7 Web und Datenbank (vgl. Aufgabe 11a)

Erstelle eine `compose.yaml`, die diese Anforderungen erfüllt:

- es sollen die zwei Services `web` und `db` gestartet und in das neu angelegte
  Bridge-Netzwerk `mynet` integriert werden
- `web` basiert auf dem offiziellen `nginx`-Image; der Containerport 80 soll unter
  dem Hostport 8080 anzusprechen sein
- `db` basiert auf dem offiziellen Image `postgres:17.6`; das benannte Volume
  `psql` wird im Container unter `/var/lib/postgresql/data` gemountet, und die
  Umgebungsvariable `POSTGRES_PASSWORD` hat den Wert `mypassword`

```yaml
→
```

**7.1** Starte die Anwendung und beobachte die Ausgabe. In welcher Reihenfolge
entstehen die Ressourcen, und wie heißen sie (Präfix)?

```sh
→
```

**7.2** Prüfe mit `docker container list`, `docker network ls` und
`docker volume ls`, was angelegt wurde.

→

**7.3** Kann der `web`-Container die Datenbank über den Namen `db` erreichen?
Zeige es mit
`docker compose exec web bash -c "getent hosts db"` (oder `ping -c1 db`,
falls installiert).

→

**7.4** Fahre alles mit `docker compose down` herunter. Was ist danach noch da?

→

**7.5** Starte erneut und prüfe: ist eine in der Datenbank angelegte Tabelle
noch vorhanden? (Tabelle anlegen wie in Blatt 04.)

→

*Selbstkontrolle:* `docker compose down` entfernt Container und Netzwerk,
`docker volume ls` zeigt das Volume weiterhin.

## 8 Proxy und Spring (vgl. Aufgabe 11b)

Arbeitsverzeichnis: `projekt/`. Darin liegen `greeting/` (Spring-Projekt),
`proxy/nginx.conf` und `zeitserver/`.

**8.1** Baue zuerst die Jar-Datei:

```sh
cd greeting && ./gradlew bootJar && cd ..
```

Wo liegt sie danach?

→

**8.2** Schau in `proxy/nginx.conf`. Auf welchen Hostnamen und Port leitet der
Proxy weiter? Welchen Namen **muss** dein Spring-Service deshalb haben?

→

**8.3** Erstelle `projekt/compose.yaml` mit zwei Services im neu angelegten
Bridge-Netzwerk `mynet2`:

- `proxy` basiert auf dem offiziellen `nginx`-Image, Containerport 80 unter
  Hostport 8080; die Datei `proxy/nginx.conf` wird unter
  `/etc/nginx/conf.d/default.conf` eingebunden
- der zweite Service wird aus dem Dockerfile im Ordner `greeting` gebaut
  (das Dockerfile schreibst du selbst, falls noch nicht vorhanden)

```yaml
→
```

**8.4** Starte mit `docker compose up` und prüfe http://localhost:8080.
Kommt die Begrüßung?

→

**8.5** Welchen Tag hat das selbst gebaute Image bekommen?
Prüfe mit `docker image list` und vergleiche mit dem Schema aus Aufgabe 4.2.
Compose v2 benennt anders als der Foliensatz — schreibe beide Schemata auf.

→

**8.6** Ändere `greeting.text` für den Container über `environment` in der
compose.yaml und starte neu. Prüfe mit http://localhost:8080/info.

```yaml
→
```

**8.7** Ändere die Java-Datei (z. B. den Standardtext) und starte erneut mit
`docker compose up`. Warum ändert sich nichts? Welche zwei Schritte sind nötig?

→

**8.8** Räume vollständig auf, inklusive des selbst gebauten Images.

```sh
→
```

*Selbstkontrolle:* `curl http://localhost:8080/?name=Anna` geht durch den Proxy
an die Spring-Anwendung und antwortet mit der Begrüßung. Antwortet der Proxy mit
`502 Bad Gateway`, passt der Servicename nicht zu `proxy_pass`.

## 9 Alles zusammen: Zeitserver mit Volume und env-file

**9.1** Erstelle eine `compose.yaml`, die den Zeitserver aus dem Dockerfile baut,
Host-Port 8080 auf Container-Port 8080 legt, das benannte Volume `zeitdaten`
unter `/data` mountet und `GREETING` per `environment` auf `Hallo Compose` setzt.

```yaml
→
```

**9.2** Starte, ruf die Seite dreimal auf, mach `docker compose down`, starte
erneut. Bei welcher Zahl geht der Zähler weiter?

→

**9.3** Ersetze `environment` durch `env_file: greeting.env` (lege die Datei mit
`GREETING=Hallo aus der Datei` an). Prüfe die Antwort.

→

**9.4** Setze beides gleichzeitig, mit unterschiedlichen Werten. Welcher gewinnt?
Passt das zur Lesereihenfolge aus Blatt 03?

→

## 10 Skalieren und Logs

**10.1** Starte den Zeitserver-Service mit drei Instanzen:
`docker compose up --scale <service>=3`. Warum musst du dafür das
Port-Mapping entfernen?

→

**10.2** Prüfe mit `docker compose ps`, wie die drei Container heißen.

→

**10.3** Ruf aus einem weiteren Container im selben Netz mehrfach
`wget -qO- http://<service>:8080` auf. Was fällt beim Hostnamen in der Antwort auf?

→

**10.4** Lies die Logs aller Services mit `docker compose logs`, dann nur die eines
Services. Wie unterscheidet die Ausgabe die Services?

→

---

# Weiter

- Originalaufgabe: `cloud-computing/origin-tasks/task-11/` (Aufgabe 11, mit Lösung
  und Startprojekt)
- Nächstes Blatt: [07 – Spring und Docker](07-spring-und-docker.md)
