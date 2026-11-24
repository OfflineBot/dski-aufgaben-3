# Blatt 06 – Docker Compose

Von einzelnen `run`-Befehlen zur deklarativen Datei. Erst YAML lesen und
reparieren, dann Container-Gruppen starten.

Hinweis: `topics/docker/07-docker-compose`

---

## 1 YAML lesen und schreiben

**1.1** Bestimme den Datentyp:

```yaml
Stunden: 55
Programmierung: true
Raum: Labor
Note: 1.3
Kuerzel: "true"
```

| Schlüssel | Datentyp |
| --- | --- |
| `Stunden` | … |
| `Programmierung` | … |
| `Raum` | … |
| `Note` | … |
| `Kuerzel` | … |

**1.2** Wie viele Einträge hat `DHBW`, und welche Werte gehören zu Heidenheim?

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

**1.3** Schreibe die drei Studiengänge Wirtschaftsinformatik, Data Science und
Elektrotechnik als YAML-Liste unter dem Schlüssel `Studiengänge`:

```yaml
→
```

**1.4** Womit wird in YAML eingerückt, und was passiert bei einem Tab?

→

## 2 compose.yaml lesen

**2.1** Ordne jedem Schlüssel innerhalb eines Service die Bedeutung zu:

| Schlüssel | Bedeutung |
| --- | --- |
| `image` | … |
| `build` | … |
| `ports` | … |
| `environment` | … |
| `volumes` | … |
| `networks` | … |

**2.2** Was macht jeder Befehl?

| Befehl | Wirkung |
| --- | --- |
| `docker compose up` | … |
| `docker compose up --build` | … |
| `docker compose down` | … |
| `docker compose down --rmi=local` | … |

**2.3** Lies die Datei und beantworte die Fragen darunter:

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

- Welchen Port ruft der Browser auf, auf welchem horcht der Container?

  →

- Welcher Treiber wird für `mynet` verwendet, obwohl keiner dasteht?

  →

- Wird das Volume `psql` hier überhaupt benutzt?

  →

## 3 YAML reparieren

Jede Datei hat genau einen Fehler. Finde ihn und schreibe die korrigierte Fassung auf.
Prüfen kannst du mit `docker compose config`: der Befehl liest die Datei und meldet Fehler.

**3.1**

```yaml
services:
web:
  image: nginx
  ports:
    - "8080:80"
```

→

**3.2**

```yaml
services:
  web:
    image: nginx
    ports:
      "8080:80"
```

→

**3.3** Hier fehlt nichts *innerhalb* des Services.

```yaml
services:
  db:
    image: postgres:17.6
    environment:
      POSTGRES_PASSWORD: mypassword
    volumes:
      - psql:/var/lib/postgresql/data
```

→

**3.4**

```yaml
services:
  web:
    image: nginx
    network: mynet

networks:
  mynet:
```

→

**3.5**

```yaml
services:
  db:
    image: postgres:17.6
    environment:
      POSTGRES_PASSWORD=mypassword
```

→

## 4 Web und Datenbank (vgl. Aufgabe 11a)

Erstelle in einem leeren Ordner eine `compose.yaml`, die diese Anforderungen erfüllt:

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

**4.1** Starte die Anwendung im Hintergrund. In welcher Reihenfolge entstehen die
Ressourcen, und wie heißen sie (Präfix)?

```sh
→
```

**4.2** Prüfe mit `docker container list`, `docker network ls` und
`docker volume ls`, was angelegt wurde.

→

**4.3** Fahre alles mit `docker compose down` herunter. Was ist danach noch da,
und warum ist das so gewollt?

→

*Selbstkontrolle:* `docker compose down` entfernt Container und Netzwerk,
`docker volume ls` zeigt das Volume weiterhin.

## 5 Proxy und Spring (vgl. Aufgabe 11b)

Arbeitsverzeichnis: `projekt/`. Darin liegen `greeting/` (Spring-Projekt) und
`proxy/nginx.conf`.

**5.1** Baue zuerst die Jar-Datei. Wo liegt sie danach?

```sh
cd greeting && ./gradlew bootJar && cd ..
```

→

**5.2** Schau in `proxy/nginx.conf`. Auf welchen Hostnamen und Port leitet der
Proxy weiter? Welchen Namen **muss** dein Spring-Service deshalb haben?

→

**5.3** Schreibe `projekt/greeting/Dockerfile`: Baseimage
`eclipse-temurin:21-jre-noble`, Arbeitsverzeichnis `/app`, die Jar aus
`build/libs/app.jar` wird zu `app.jar`, Port 8080, Start in Exec-Notation.

```dockerfile
→
```

**5.4** Erstelle `projekt/compose.yaml` mit zwei Services im neu angelegten
Bridge-Netzwerk `mynet2`:

- `proxy` basiert auf dem offiziellen `nginx`-Image, Containerport 80 unter
  Hostport 8080; die Datei `proxy/nginx.conf` wird unter
  `/etc/nginx/conf.d/default.conf` eingebunden
- der zweite Service wird aus dem Dockerfile im Ordner `greeting` gebaut

```yaml
→
```

**5.5** Starte mit `docker compose up` und prüfe http://localhost:8080/?name=Anna.
Kommt die Begrüßung?

→

**5.6** Welchen Namen hat das selbst gebaute Image bekommen? Prüfe mit
`docker image list`. Compose benennt heute anders als im Foliensatz — schreibe
beide Schemata auf.

→

**5.7** Setze `GREETING_TEXT` für den Spring-Container über `environment` in der
compose.yaml und starte neu. Prüfe mit http://localhost:8080/info.

```yaml
→
```

**5.8** Ändere in der Java-Datei den Standardtext und starte erneut mit
`docker compose up`. Warum ändert sich nichts? Welche zwei Schritte sind nötig?

→

**5.9** Räume vollständig auf, inklusive des selbst gebauten Images.

```sh
→
```

*Selbstkontrolle:* `curl "http://localhost:8080/?name=Anna"` geht durch den Proxy
an die Spring-Anwendung und antwortet mit der Begrüßung. Antwortet der Proxy mit
`502 Bad Gateway`, passt der Servicename nicht zu `proxy_pass`.

## 6 Volume und env-Datei in Compose

Arbeitsverzeichnis: `projekt/zeitserver`, mit diesem Dockerfile:

```dockerfile
FROM eclipse-temurin:21-jdk-alpine
ENV PORT=8080
WORKDIR /app
COPY Zeitserver.java .
EXPOSE 8080
CMD ["java","Zeitserver.java"]
```

**6.1** Erstelle eine `compose.yaml`, die den Zeitserver aus diesem Dockerfile baut,
Host-Port 8080 auf Container-Port 8080 legt, das benannte Volume `zeitdaten`
unter `/data` mountet und `GREETING` per `environment` auf `Hallo Compose` setzt.

```yaml
→
```

**6.2** Starte, ruf die Seite dreimal auf, mach `docker compose down`, starte
erneut. Bei welcher Zahl geht der Zähler weiter?

→

**6.3** Ersetze `environment` durch `env_file` und lege dafür die Datei
`zeit.env` mit `GREETING=Hallo aus der Datei` an. Prüfe die Antwort.

```yaml
→
```

**6.4** Setze beides gleichzeitig, mit unterschiedlichen Werten. Welcher gewinnt?

→

## 7 Verständnis

**7.1** Welche Rolle hat der Servicename für die Kommunikation zwischen Containern?

→

**7.2** Wann braucht ein `volumes`-Eintrag im Service zusätzlich einen Eintrag auf
oberster Ebene, wann nicht?

→

**7.3** Wann baut `docker compose up` ein Image neu, und mit welcher Option
erzwingst du es?

→

**7.4** Was bedeutet ein Schlüssel ohne Wert, zum Beispiel `mynet:` unter
`networks`?

→

---

# Weiter

- Originalaufgabe: `cloud-computing/origin-tasks/task-11/` (Aufgabe 11, mit Lösung
  und Startprojekt)
- Nächstes Blatt: [07 – Spring und Docker](07-spring-und-docker.md)
