# Fehlerliste

Nur was noch nicht sitzt. Was du kannst, fliegt raus. Neue Fehler kommen nach jeder Korrektur dazu.

Stand: 24.11.2026

---

# Cloud Computing

| Nr. | Was nicht sitzt | Zuletzt |
| --- | --- | --- |
| 1 | Bauzeit und Laufzeit im Dockerfile | Blatt 02 |
| 2 | Build-Cache und Reihenfolge der Schichten | Blatt 02 |
| 3 | `EXPOSE` ist kein Port-Mapping | Blatt 02 |
| 4 | `ENV`: mehrere Variablen, Startwert | Blatt 02 |
| 5 | `CMD`: Formen und Überschreiben | Blatt 02 |
| 6 | Proxy-Zeile | Runde 3 |
| 7 | Image-Befehle | Blatt 02 |
| 8 | `--rm` und `start -i` | Blatt 01 |
| 9 | Jar muss vor dem Bauen existieren | Blatt 02 |
| 10 | Zwei Kleinigkeiten | Blatt 01, 02 |

## 1 - Bauzeit und Laufzeit im Dockerfile

- **Du schreibst:** `RUN`, `WORKDIR` und `COPY` wirken zur Laufzeit.
- **Richtig:** Beim Bauen läuft das ganze Dockerfile von `FROM` bis `EXPOSE`. Beim Starten eines Containers läuft nur `CMD`.
- **Vorkommen:** Blatt 02 (1.3, 4.4, 5.1)

## 2 - Build-Cache und Reihenfolge der Schichten

- **Richtig:** Docker geht das Dockerfile von oben durch. Unveränderte Zeilen kommen aus dem Cache (`CACHED`). Ab der ersten geänderten Zeile wird diese und alles darunter neu gebaut.
- **Merke:** Oben steht, was sich selten ändert. Das `COPY` des Codes steht weit unten.
- **Vorkommen:** Runde 1 (6.1) · Blatt 02 (4.1, 4.2, 4.4)

## 3 - `EXPOSE` ist kein Port-Mapping

- **Du schreibst:** `EXPOSE 3030`, wenn die Anwendung auf 8080 horcht und über Hostport 3030 erreichbar sein soll.
- **Richtig:** `EXPOSE 8080` im Dockerfile, `-p 3030:8080` beim `run`.
- **Merke:** `EXPOSE` nennt nur den Port im Container. Nach außen geht erst `-p`. Ein Hostport steht nie im Dockerfile.
- **Vorkommen:** Blatt 02 (6, 8.2)

## 4 - `ENV`: mehrere Variablen, Startwert

- **Du schreibst:** `ENV PORT=8080,GREETING=Hallo`
- **Richtig:** zwei `ENV`-Zeilen, oder `ENV PORT=8080 GREETING=Hallo` mit Leerzeichen
- **Merke:** `ENV` setzt nur einen Startwert. `-e` beim `run` überschreibt ihn, ohne Neubau. Reihenfolge: Dockerfile → env-file → `-e`.
- **Vorkommen:** Runde 1 (3.3) · Blatt 02 (3.1, 3.5)

## 5 - `CMD`: Formen und Überschreiben

- Exec-Form: `CMD ["java","-jar","app.jar"]`
- Shell-Form: `CMD java -jar app.jar`
- Die Exec-Form ist sicherer, weil keine Shell dazwischen läuft.
- Überschreiben: Befehl hinter das Image schreiben, `docker container run zeitserver:1.0 ls -la /app`
- **Vorkommen:** Blatt 02 (1.4, 7.1, 8.3)

## 6 - Proxy-Zeile

- **Richtig:** `proxy_pass http://<Service-Name>:<Port im Container>;`
- **Merke:** Im Compose-Netz heißt jeder Container wie sein Service. `localhost` und `0.0.0.0` sind keine Ziele.
- **Vorkommen:** Runde 2 (5.6) · Runde 3 (7.1)

## 7 - Image-Befehle

- `docker image list` → welche Images gibt es
- `docker image history <image>` → Schichten
- `docker image pull <image>` → aus der Registry laden
- `docker image tag <alt> <neu>` → zusätzlicher Tag, kostet keinen Speicher
- `docker image rm <tag>` → löschen, ohne `-t`
- **Du schreibst:** `history`, um zu prüfen, ob ein Image da ist · `inspect` für die Schichten · `rm -t meinalpine:v1 alpine:3.20`
- **Vorkommen:** Runde 1 (4.2 bis 4.4) · Blatt 01 (2.3) · Blatt 02 (1.1, 2.2, 2.4)

## 8 - `--rm` und `start -i`

- `docker container run --rm …` → Container wird gelöscht, sobald er stoppt
- `docker container start -i <id>` → gestoppten Container starten und wieder in seine Shell kommen
- `-i` heißt **interactive**, nicht Id. Name und Id gehen beide ohne Flag: `start web` oder `start ac1`.
- **Vorkommen:** Blatt 01 (5.3, 6.1, 6.2, 9.3) · Rückfrage am 24.11.

## 9 - Jar muss vor dem Bauen existieren

- **Richtig:** Vor `docker image build` läuft `mvn clean install` bzw. `gradlew bootJar` auf dem Host. Sonst findet `COPY` keine Jar.
- `mvn clean install` im Dockerfile geht technisch, läuft dann aber im Image. Die Vorlesung empfiehlt dafür Multi-Stage-Dockerfiles.
- **Vorkommen:** Blatt 02 (5.3, 6.1)

## 10 - Zwei Kleinigkeiten

- Tag zerlegen: `hub.docker.com/plexinc/pms-docker:latest` → User ist `plexinc`, Image ist `pms-docker`.
- Jeder Container hat seine eigene beschreibbare Schicht. Zehn Container sind zehn Schichten.
