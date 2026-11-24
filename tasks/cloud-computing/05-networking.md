# Blatt 05 – Docker Networking

Drei Treiber und die Frage, warum `wget http://web` manchmal funktioniert und
manchmal nicht.

Hinweis: `topics/docker/06-docker-networking`

---

## 1 Befehle und Treiber kennen

**1.1** Was macht jeder Befehl?

| Befehl | Wirkung |
| --- | --- |
| `docker network ls` | … |
| `docker network inspect bridge` | … |
| `docker network create my_net --driver=bridge` | … |
| `docker network connect my_net my_cont` | … |
| `docker network disconnect my_net my_cont` | … |

**1.2** Die drei Treiber:

| Treiber | Isolation | `-p` nötig? | Typischer Einsatz |
| --- | --- | --- | --- |
| `bridge` | … | … | … |
| `host` | … | … | … |
| `none` | … | … | … |

**1.3** Welcher Treiber ist der Standard, und mit welcher Option wählst du beim
`run` einen anderen?

→

## 2 Namensauflösung im Standardnetz (vgl. Aufgabe 10)

**2.1** Starte einen Container auf Basis von `nginx` im Hintergrund, gib ihm den
Namen `web` und mache den Containerport 80 über den Hostport 8080 zugreifbar.

```sh
→
```

**2.2** Starte einen weiteren Container auf Basis von `busybox` interaktiv, mit dem
Befehlszusatz `sh`, und gib ihm den Namen `tester`.

```sh
→
```

**2.3** Führe im `tester`-Container aus:

```sh
wget -qO- http://web
```

Was kommt zurück?

→

**2.4** Warum funktioniert der Zugriff über den Namen `web` nicht?

→

**2.5** Wie müsste man stattdessen auf den `web`-Container zugreifen? Finde die
nötige Information mit `docker network inspect bridge` heraus und führe den
Zugriff aus.

```sh
→
```

*Selbstkontrolle:* `wget -qO- http://web` scheitert mit `bad address 'web'`,
`wget -qO- http://172.17.0.x` liefert die nginx-Startseite.

## 3 Dasselbe mit einem eigenen Netzwerk

Lösche vorher `web` und `tester` aus Aufgabe 2.

**3.1** Erstelle ein Netzwerk `my_net` mit dem Treiber `bridge`.

```sh
→
```

**3.2** Starte `web` (nginx, im Hintergrund) und `tester` (busybox, interaktiv mit
`sh`) neu, beide in `my_net`.

```sh
→
```

**3.3** Führe im `tester` erneut `wget -qO- http://web` aus. Ergebnis?

→

**3.4** Was ist der einzige Unterschied zu Aufgabe 2, und welche Docker-Funktion
erklärt ihn?

→

**3.5** Ein dritter Container `alt` läuft bereits im Standardnetz. Mit welchem
Befehl hängst du ihn nachträglich in `my_net`, mit welchem trennst du ihn wieder?

```sh
→
```

*Selbstkontrolle:* in 3.3 kommt die nginx-Startseite über den **Namen**.

## 4 host-Modus

Unter Linux direkt beobachtbar; mit Docker Desktop verhält sich der host-Modus anders.

**4.1** Starte `nginx` mit `--net=host` und **ohne** `-p`, im Hintergrund.
Auf welchem Port ist er vom Host aus erreichbar?

```sh
→
```

**4.2** Prüfe `docker container list`: was steht in der Spalte `PORTS`?

→

**4.3** Starte einen zweiten nginx im host-Modus. Was passiert, und warum?

→

*Selbstkontrolle:* `curl http://localhost:80` antwortet, obwohl kein `-p` gesetzt
wurde; die Spalte `PORTS` ist leer.

## 5 none-Modus

**5.1** Starte `nginx` mit `--net=none` im Hintergrund, mit dem Namen `allein`.

```sh
→
```

**5.2** Versuche `curl http://localhost:80` vom Host. Ergebnis?

→

**5.3** Wie kommst du trotzdem noch in den Container hinein?

```sh
→
```

## 6 publish gegen expose

Arbeitsverzeichnis: `projekt/zeitserver`, mit diesem Dockerfile:

```dockerfile
FROM eclipse-temurin:21-jdk-alpine
ENV PORT=8080
WORKDIR /app
COPY Zeitserver.java .
EXPOSE 8080
CMD ["java","Zeitserver.java"]
```

**6.1** Baue das Image als `zeitserver:1.0` und starte es **ohne** `-p`.
Ist der Server vom Host aus erreichbar?

→

**6.2** Starte es mit `-p 9000:8080`. Welche Adresse rufst du im Browser auf,
und auf welchem Port horcht die Anwendung im Container?

→

**6.3** Formuliere in zwei Sätzen, was `EXPOSE` leistet und was nur `-p` leistet.

→

## 7 Diagnose

**7.1** Liste alle Netzwerke mit ihrem Treiber. Welche drei existieren nach einer
frischen Installation?

```sh
→
```

**7.2** Ein Kollege sagt: „Der Container läuft, aber ich erreiche ihn nicht.“
Nenne vier Dinge, die du der Reihe nach prüfst, jeweils mit dem Befehl.

→

## 8 Verständnis

**8.1** Unter welcher Bedingung funktioniert die Namensauflösung zwischen
Containern?

→

**8.2** Warum braucht ein Container im host-Modus kein `-p`, und welches Risiko
entsteht dadurch?

→

**8.3** Zwei Container hängen in zwei **verschiedenen** eigenen Netzwerken.
Erreichen sie sich über den Namen? Was folgt daraus für die Isolation?

→

---

# Weiter

- Originalaufgabe: `cloud-computing/origin-tasks/task-10/` (Aufgabe 10, mit Lösung)
- Nächstes Blatt: [06 – Docker Compose](06-compose.md)
