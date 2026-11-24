# Cloud Computing – Aufgabenblätter

Alles aus dem Foliensatz „3-Docker“, als Aufgaben. Theorie nur so viel, wie zum
Verständnis gehört — der Rest ist Tippen, Bauen, Starten und Erklären.

Laut `ABOUT.md` der Vorlesung gilt für die Klausur:

- alles über Docker, die Aufgaben des Foliensatzes sind repräsentativ
- auch mit Spring Framework
- CLI-Kommando zu Docker-Script und umgekehrt
- keine abstrakten Theoriefragen, aber Verständnis muss da sein

Genau darauf sind die Blätter zugeschnitten: Blatt 08 übt die Übersetzung in
beide Richtungen, Blatt 07 Spring, Blatt 09 simuliert die Klausur.

## Reihenfolge

| Blatt | Thema | Quelle (Unterthema in `topics/docker/`) |
| --- | --- | --- |
| [01](01-grundlagen-und-container.md) | Paradigma, Architektur, Container starten und kontrollieren | `01-grundlagen`, `02-docker-container` |
| [02](02-images-und-dockerfile.md) | Schichten, Tags, Registry, eigenes Dockerfile | `03-docker-image` |
| [03](03-best-practices.md) | Baseimage, Tagging, Umgebungsvariablen, non-root | `04-best-practices` |
| [04](04-storage.md) | Volumes, Bind Mounts, Persistenz | `05-docker-storage` |
| [05](05-networking.md) | bridge, host, none, Namensauflösung | `06-docker-networking` |
| [06](06-compose.md) | YAML, `compose.yaml`, Container-Gruppen | `07-docker-compose` |
| [07](07-spring-und-docker.md) | Spring Boot im Container: Profile, ApiKey, Umgebungsvariablen | `03-docker-image` (Spring Boot & Docker), `04-best-practices` |
| [08](08-uebersetzen-cli-und-script.md) | CLI ⇄ Dockerfile ⇄ compose.yaml übersetzen | alle |
| [09](09-klausursimulation.md) | Klausursimulation, 90 Minuten, 100 Punkte | alle |

## So arbeitest du damit

Jedes Blatt hat zwei Arten von Aufgaben:

- **Theorie** – erst ohne Nachschlagen antworten, danach mit dem Hinweis prüfen.
  Die leere Zeile nach `→` ist dein Platz, Tabellenzellen mit `…` füllst du aus.
- **Praxis** – wirklich ausführen. Unter *Selbstkontrolle* steht, woran du siehst,
  dass es stimmt. Wenn die Kontrolle nicht passt, ist die Aufgabe nicht fertig.

Hinweise zeigen auf `dski-sources-3/cloud-computing/topics/docker/...`.
Die Originalaufgaben der Vorlesung samt Lösungen liegen in
`dski-sources-3/cloud-computing/origin-tasks/`; am Ende jedes Blattes steht,
welche dazu passt. Dort schaust du nach, wenn du nicht weiterkommst.

## Voraussetzungen

| Was | Prüfen mit | Nötig für |
| --- | --- | --- |
| Docker Engine | `docker --version` | alle Blätter |
| Docker Compose v2 | `docker compose version` | Blatt 06, 08, 09 |
| Internetzugang | `docker image pull alpine:3.20` | alle (Images kommen von Docker Hub) |
| JDK 21 oder neuer | `java -version` | Blatt 02, 04 (Zeitserver), 07 (Jar bauen) |
| `curl` oder ein Browser | `curl --version` | alle Praxisaufgaben mit HTTP |

Alles, was die Aufgaben an Code brauchen, liegt in [`projekt/`](projekt/README.md).
Gradle musst du nicht installieren, der Wrapper liegt im Projekt.

Unter Windows gilt: `./gradlew` → `gradlew.bat`, Pfade mit `\` statt `/`,
und Docker braucht Linux-Container.

## Aufräumen

Nach jedem Blatt, damit die nächste Aufgabe auf einem sauberen Host startet.
Räume **namentlich** auf — die Übungscontainer heißen in den Blättern `web`,
`tester`, `db`, `app`, `proxy`:

```sh
docker container list -a                      # was läuft oder liegt noch herum?
docker container stop web tester db app       # nur die Übungscontainer
docker container rm web tester db app
docker compose down --rmi=local               # im Ordner mit der compose.yaml
docker volume rm psql zeitdaten               # nur die Volumes der Blätter
docker network rm mynet mynet2 my_net net_a net_b
```

Vorsicht mit den pauschalen Varianten: `docker container stop $(docker container list -q)`,
`docker container rm $(docker container list -aq)` und `docker volume prune` treffen
**alles** auf dem Rechner, also auch Container und Daten anderer Projekte.
In Blatt 04 ist es sogar die Aufgabe, die Daten im Volume *nicht* zu verlieren.

Images bleiben absichtlich liegen — sie sind der Cache für das nächste Blatt.
Mit `docker image list` siehst du, was da ist, mit `docker image rm <tag>` wird
einzeln gelöscht.
