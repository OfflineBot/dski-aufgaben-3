> Runde 4. Teil A prüft in drei Aufgaben, was du laut eigener Einschätzung kannst. Teil B übt, was noch nicht sitzt: Dockerfile und Proxy. Jede Aufgabe steht für sich.

# Teil A – Kurzcheck

## A1 - Container bedienen

*Aufgabe*: Aus dem Image `nginx` läuft ein Container, den du mit `--name web` erstellt hast. Vier Befehle: a) seine Logs ausgeben b) seine Ressourcennutzung anzeigen c) ihn stoppen d) genau diesen Container wieder zum Laufen bringen.

```sh

```

## A2 - Neuen Container erstellen

*Aufgabe*: Das Image `zeitserver:1.0` liegt lokal. Die Anwendung darin horcht im Container auf Port 8080 und liest die Umgebungsvariable `GREETING`. Erstelle einen neuen Container: im Hintergrund, mit dem Namen `zeit`, im Browser erreichbar unter `http://localhost:9000`, mit `GREETING` auf dem Wert `Moin`.

```sh

```

## A3 - Compose

*Aufgabe*: Neben der `compose.yaml` liegen der Ordner `app` (mit `Dockerfile` und `app.env`) und die Datei `config/app.conf`. Schreibe die vollständige `compose.yaml` mit einem Service `app`: aus dem Dockerfile im Ordner `app` gebaut · Umgebungsvariablen aus `app/app.env` · Containerport 8080 auf Hostport 8080 · das benannte Volume `daten` im Container unter `/data` · die Datei `config/app.conf` im Container unter `/etc/app.conf` · im selbst angelegten Netzwerk `netz`.

```yaml

```

# Teil B – Was noch nicht sitzt

## B1 - Bauzeit und Laufzeit

Merke:

- `docker image build` arbeitet das ganze Dockerfile ab. Das Ergebnis ist das Image.
- `docker container run` führt nur noch `CMD` aus.

Beispiel:

```dockerfile
FROM alpine:3.20                # Bauen
RUN apk add curl                # Bauen: curl ist danach im Image
CMD ["curl","--version"]        # Laufen: erst beim Start des Containers
```

*Aufgabe*: Schreibe hinter jede Zeile „Bauen“ oder „Laufen“. Was liegt nach dem Bauen im Image unter `/app`, noch bevor ein Container gestartet wurde?

```dockerfile
FROM eclipse-temurin:21-jre-alpine
ENV STAGE=prod
WORKDIR /app
COPY build/libs/shop.jar shop.jar
EXPOSE 3000
CMD ["java","-jar","shop.jar"]
```

```

```

## B2 - Build-Cache

Merke:

- Beim erneuten Bauen geht Docker von oben nach unten.
- Unveränderte Zeile → `CACHED`.
- Ab der ersten geänderten Zeile wird diese und alles darunter neu gebaut.

Beispiel: In einem Dockerfile mit den Zeilen `FROM`, `RUN`, `COPY`, `CMD` ändert sich die kopierte Datei. Dann sind `FROM` und `RUN` `CACHED`, `COPY` und `CMD` werden neu gebaut.

*Aufgabe*: Das Image aus diesem Dockerfile wurde schon einmal gebaut. Nenne für beide Fälle, welche Zeilen aus dem Cache kommen und welche neu gebaut werden. a) Du änderst nur den Java-Code, `shop.jar` ist also neu. b) Du änderst nur die Zeile `ENV STAGE=prod` in `ENV STAGE=test`. c) Warum steht das `COPY` so weit unten?

```dockerfile
FROM eclipse-temurin:21-jre-alpine
ENV STAGE=prod
WORKDIR /app
COPY build/libs/shop.jar shop.jar
EXPOSE 3000
CMD ["java","-jar","shop.jar"]
```

```

```

## B3 - EXPOSE und -p

Merke:

- `EXPOSE` steht im Dockerfile und nennt den Port, auf dem die Anwendung **im Container** horcht.
- `-p <Host>:<Container>` steht beim `run` und macht den Port auf dem Host erreichbar.
- Ein Hostport steht nie im Dockerfile.

Beispiel: Die Anwendung horcht auf 8080 und soll unter Hostport 3030 erreichbar sein → `EXPOSE 8080` und `-p 3030:8080`.

*Aufgabe*: Eine Anwendung horcht im Container auf Port 5000 und soll im Browser unter `http://localhost:80` erreichbar sein. Das Image heißt `api:1.0`. a) Welche Zeile steht im Dockerfile? b) Schreibe den `run`-Befehl, im Hintergrund. c) Ist der Container vom Host aus erreichbar, wenn du das `-p` weglässt?

```

```

## B4 - ENV

Merke:

- Jede Variable in eine eigene `ENV`-Zeile, oder mehrere mit Leerzeichen getrennt. Nie mit Komma.
- `ENV` setzt nur den Startwert. `-e` beim `run` überschreibt ihn, ohne Neubau.

Beispiel:

```dockerfile
ENV STAGE=prod
ENV LEVEL=info
```

*Aufgabe*: a) Schreibe die Dockerfile-Zeilen, die `PORT` auf `8080` und `GREETING` auf `Hallo` setzen. b) Das Image heißt `zeitserver:1.0`. Schreibe den `run`-Befehl, bei dem `GREETING` den Wert `Servus` hat. c) Welchen Wert hat `PORT` in diesem Container, und warum musstest du das Image nicht neu bauen?

```

```

## B5 - CMD

Merke:

- Exec-Form: `CMD ["java","-jar","app.jar"]`. Der Prozess läuft direkt.
- Shell-Form: `CMD java -jar app.jar`. Dazwischen läuft eine Shell, das ist unsicherer.
- Überschreiben: Was beim `run` hinter dem Image steht, ersetzt `CMD`.

Beispiel: `docker container run alpine:3.20 echo hallo` führt `echo hallo` aus statt des Startkommandos aus dem Image.

*Aufgabe*: a) Schreibe `python server.py` als `CMD` in beiden Formen und sag, welche die Exec-Form ist. b) Das Image `api:1.0` startet normalerweise einen Server. Schreibe den Befehl, der daraus einen Container erstellt, der stattdessen nur `ls -la /app` ausführt. c) Ist das Image danach verändert?

```

```

## B6 - Proxy-Zeile

Merke:

- `proxy_pass` ist das Ziel, an das nginx jede Anfrage weiterreicht.
- Das Ziel ist der andere Container: `http://<Service-Name>:<Port im Container>;`
- `localhost` wäre der nginx-Container selbst.

Beispiel: Der Service heißt `app` und horcht im Container auf 8080 → `proxy_pass http://app:8080;`

*Aufgabe*: Schreibe für beide Fälle die richtige `proxy_pass`-Zeile. a) In der `compose.yaml` heißt der Spring-Service `greeting` und horcht im Container auf Port 8080. In der nginx-Datei steht `proxy_pass http://host.docker.internal:8081;`. b) In der `compose.yaml` heißt der Service `shop`, horcht im Container auf Port 3000 und ist zusätzlich mit `ports: - "9000:3000"` veröffentlicht. In der nginx-Datei steht `proxy_pass http://localhost:9000;`.

```nginx

```
