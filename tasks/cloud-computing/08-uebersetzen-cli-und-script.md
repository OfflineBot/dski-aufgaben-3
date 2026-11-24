# Blatt 08 – Übersetzen: CLI, Dockerfile, compose.yaml

Laut `ABOUT.md` kommt genau das in der Klausur: „CLI command zu Docker Script und
vice versa“. Hier gibt es nichts zu starten, nur zu schreiben. Ohne Nachschlagen.

---

# Teil A – Beschreibung → CLI

Schreibe für jede Beschreibung den vollständigen Befehl.

**1.1** Starte einen Container aus dem Image `nginx` im Hintergrund, Host-Port 8080
auf Container-Port 80.

```sh
→
```

**1.2** Starte denselben Container, gib ihm zusätzlich den Namen `web` und lass ihn
beim Beenden automatisch löschen.

```sh
→
```

**1.3** Verschaffe dir eine interaktive Shell in einem **neuen** Container aus dem
Image `ubuntu`.

```sh
→
```

**1.4** Verschaffe dir eine interaktive Shell in einem **laufenden** Container mit
dem Namen `web`.

```sh
→
```

**1.5** Zeige alle Container, auch die gestoppten.

```sh
→
```

**1.6** Gib die Logausgaben des Containers `web` aus, danach seine Ressourcennutzung.

```sh
→
```

**1.7** Lade das Image `openjdk:16-jdk-slim` herunter, ohne einen Container zu
starten, und zeige danach seine Schichten.

```sh
→
```

**1.8** Baue aus dem Dockerfile im aktuellen Verzeichnis ein Image mit dem Tag
`greeting:1.4.2`.

```sh
→
```

**1.9** Gib dem Image `greeting:1.4.2` zusätzlich den Tag `greeting:stable`.

```sh
→
```

**1.10** Erstelle ein Volume `psql` und starte `postgres:17.6` im Hintergrund damit
an `/var/lib/postgresql/data`, mit dem Passwort `mypassword` in der
Umgebungsvariable `POSTGRES_PASSWORD`.

```sh
→
```

**1.11** Starte `nginx` im Hintergrund und binde das Host-Verzeichnis
`/home/student/site` an `/usr/share/nginx/html` im Container.

```sh
→
```

**1.12** Erstelle ein Bridge-Netzwerk `mynet` und starte darin im Hintergrund einen
Container `app` aus dem Image `greeting:1.0`.

```sh
→
```

**1.13** Starte `nginx` so, dass der Container den Netzwerkstack des Hosts nutzt.
Danach einen zweiten völlig ohne Netzwerk.

```sh
→
```

**1.14** Starte `greeting:1.0` im Hintergrund mit allen Variablen aus der Datei
`greeting.env` und überschreibe zusätzlich `SPRING_PROFILES_ACTIVE` mit `dev`.

```sh
→
```

**1.15** Stoppe und lösche den Container `web`. Lösche danach das Volume `psql`
und alle unbenutzten Volumes.

```sh
→
```

---

# Teil B – CLI → Beschreibung

Schreibe für jeden Befehl in einem Satz, was er tut — und wo eine Falle steckt.

| Befehl | Was tut er? |
| --- | --- |
| `docker container run -d -p 3030:8080 greeting:1.0` | … |
| `docker container run -it --rm alpine:3.20 sh` | … |
| `docker container run -d --name db -e POSTGRES_PASSWORD=pw -v psql:/var/lib/postgresql/data postgres:17.6` | … |
| `docker container run -d --net=host nginx` | … |
| `docker container exec -it web bash` | … |
| `docker container run -d -p 80:80 --net=my_net --name web nginx` | … |
| `docker compose up --build` | … |
| `docker compose down --rmi=local` | … |

---

# Teil C – CLI → compose.yaml

Übersetze jeden Befehl in eine vollständige `compose.yaml`. Der Servicename steht
jeweils dabei.

**3.1** Service `web`:

```sh
docker container run -d -p 8080:80 nginx
```

```yaml
→
```

**3.2** Service `db`:

```sh
docker volume create psql
docker container run -d --name db \
  -e POSTGRES_PASSWORD=mypassword \
  -v psql:/var/lib/postgresql/data \
  postgres:17.6
```

```yaml
→
```

**3.3** Services `web` und `db`, beide im Netz `mynet`:

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

**3.4** Service `app`, Image wird aus dem Dockerfile im Unterordner `greeting`
gebaut:

```sh
docker image build -t app:1.0 ./greeting
docker container run -d -p 8080:8080 --env-file greeting/greeting.env app:1.0
```

```yaml
→
```

**3.5** Service `proxy` mit einer eingebundenen Konfigurationsdatei:

```sh
docker container run -d -p 8080:80 \
  -v ./proxy/nginx.conf:/etc/nginx/conf.d/default.conf \
  nginx
```

```yaml
→
```

---

# Teil D – compose.yaml → CLI

Schreibe die `docker`-Befehle, die dasselbe erreichen, in der richtigen Reihenfolge.
Vergiss Netzwerk und Volume nicht.

**4.1**

```yaml
services:
  web:
    image: nginx
    ports:
      - "8080:80"
```

```sh
→
```

**4.2**

```yaml
services:
  app:
    image: greeting:1.0
    ports:
      - "80:8080"
    environment:
      SPRING_PROFILES_ACTIVE: prod
      GREETING_TEXT: Hallo
    networks:
      - mynet

networks:
  mynet:
```

```sh
→
```

**4.3**

```yaml
services:
  db:
    image: postgres:17.6
    environment:
      POSTGRES_PASSWORD: mypassword
    volumes:
      - psql:/var/lib/postgresql/data
    networks:
      - mynet
  web:
    image: nginx
    ports:
      - "8081:80"
    volumes:
      - ./site:/usr/share/nginx/html
    networks:
      - mynet

volumes:
  psql:

networks:
  mynet:
```

```sh
→
```

**4.4** Welche Befehle ersetzen diesen Service? Es sind zwei.

```yaml
services:
  app:
    build:
      context: ./greeting
      dockerfile: Dockerfile
    ports:
      - "8080:8080"
```

```sh
→
```

---

# Teil E – Dockerfile ⇄ CLI

**5.1** Trage ein, womit man die Wirkung der Instruktion beim `run` ergänzt oder
überschreibt:

| Instruktion im Dockerfile | Entsprechung beim `run` |
| --- | --- |
| `ENV GREETING_TEXT=Hallo` | … |
| `EXPOSE 8080` | … |
| `VOLUME /data` | … |
| `CMD ["java","-jar","app.jar"]` | … |

**5.2** Gegeben dieses Dockerfile. Schreibe den `build`- und den `run`-Befehl, der
die Anwendung im Hintergrund auf Host-Port 3030 erreichbar macht und das Profil auf
`test` setzt:

```dockerfile
FROM eclipse-temurin:21-jre-noble
ENV SPRING_PROFILES_ACTIVE=prod
WORKDIR /app
COPY build/libs/app.jar app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]
```

```sh
→
```

**5.3** Schreibe für dasselbe Dockerfile die passende `compose.yaml`
(Service `app`, Build aus dem aktuellen Verzeichnis, Profil `test`, Host-Port 3030).

```yaml
→
```

---

# Teil F – Szenario in beiden Formen

Szenario: Eine Spring-Anwendung soll auf Host-Port 8080 erreichbar sein. Dahinter
liegt eine Postgres-Datenbank (`postgres:17.6`) mit dem benannten Volume `pgdaten`
unter `/var/lib/postgresql/data`. Beide Container liegen im eigenen Bridge-Netzwerk
`appnet`, die Datenbank ist von außen **nicht** erreichbar. Die Anwendung wird aus
dem Dockerfile im Ordner `greeting` gebaut und horcht im Container auf 8080, ihr
Profil ist `prod`. Das Datenbankpasswort (`POSTGRES_PASSWORD`) steht in der Datei
`db.env`.

**6.1** Schreibe alle nötigen `docker`-Befehle, in der richtigen Reihenfolge:

```sh
→
```

**6.2** Schreibe dieselbe Umgebung als `compose.yaml` mit den Services `app` und `db`:

```yaml
→
```

**6.3** Welchen Befehl brauchst du, um die Compose-Umgebung samt selbst gebautem
Image wieder zu entfernen — und was bleibt trotzdem übrig?

→

---

# Weiter

- Nächstes Blatt: [09 – Klausursimulation](09-klausursimulation.md)
