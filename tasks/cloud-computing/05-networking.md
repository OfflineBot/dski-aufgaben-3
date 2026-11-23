# Blatt 05 – Docker Networking

Drei Treiber, eine virtuelle Netzwerkkarte und die Frage, warum
`wget http://web` manchmal funktioniert und manchmal nicht.

Hinweis: `topics/docker/06-docker-networking`

---

# Teil A – Theorie

## 1 Motivation

**1.1** Warum ist Netzwerk überhaupt der entscheidende Mehrwert? Nenne ein Beispiel
aus drei Containern.

→

**1.2** Was bedeutet das Designprinzip „Batteries included, but removable“?

→

**1.3** Die drei Treiber, in einer Tabelle:

| Treiber | Isolation | Performance | Portfreigabe nötig? | Typischer Einsatz |
| --- | --- | --- | --- | --- |
| `bridge` | … | … | … | … |
| `host` | … | … | … | … |
| `none` | … | … | … | … |

**1.4** Welcher Treiber ist der Standard?

→

## 2 bridge

**2.1** Wo liegen alle Container im Standardfall, und wie sind sie mit der Außenwelt
verbunden?

→

**2.2** Wie heißt die virtuelle Netzwerkkarte auf dem Host?

→

**2.3** Wie können Container innerhalb des bridge-Netzwerks aufeinander zugreifen?

→

**2.4** Die Namensauflösung über Docker-DNS funktioniert nur unter einer Bedingung.
Welche?

→

**2.5** Wie kommt Verkehr von außen zum Container?

→

**2.6** Die drei Schritte aus den Folien für `docker container run -p 80:80 nginx`:

1. …
2. …
3. …

## 3 host

**3.1** Welche Netzwerkschnittstelle nutzt der Container im host-Modus?

→

**3.2** Was entfällt, und was wird dadurch besser?

→

**3.3** Welches Sicherheitsrisiko entsteht?

→

**3.4** Welcher Konflikt kann auftreten, und wie vermeidest du ihn?

→

**3.5** Was passiert mit `-p 80:80`, wenn gleichzeitig `--net=host` gesetzt ist?

→

## 4 none

**4.1** Was bekommt der Container im none-Modus *nicht*?

→

**4.2** Wie erreicht der Host den Container dann noch?

→

**4.3** Zwei Einsatzszenarien:

→

**4.4** Warum ist none das entgegengesetzte Ende des Spektrums zu host?

→

## 5 Befehle

| Befehl | Wirkung |
| --- | --- |
| `docker network ls` | … |
| `docker network inspect bridge` | … |
| `docker network create my_net --driver=bridge` | … |
| `docker network connect my_net my_cont` | … |
| `docker network disconnect my_net my_cont` | … |

**5.1** Welche Informationen liefert `docker network inspect` über die verbundenen
Container?

→

**5.2** Wofür nutzt man `disconnect` im Betrieb?

→

---

# Teil B – Praxis

## 6 Namensauflösung im Standardnetz (vgl. Aufgabe 10)

**6.1** Starte einen Container auf Basis von `nginx` im Hintergrund, gib ihm den
Namen `web` und mache den Containerport 80 über den Hostport 8080 zugreifbar.

```sh
→
```

**6.2** Starte einen weiteren Container auf Basis von `busybox` interaktiv, mit dem
Befehlszusatz `sh`, und gib ihm den Namen `tester`.

```sh
→
```

**6.3** Führe im `tester`-Container aus:

```sh
wget -qO- http://web
```

Was kommt zurück?

→

**6.4** Warum funktioniert der Zugriff über den Namen `web` nicht?

→

**6.5** Wie müsste man stattdessen auf den `web`-Container zugreifen? Finde die
nötige Information mit `docker network inspect bridge` heraus und führe den
Zugriff aus.

```sh
→
```

*Selbstkontrolle:* `wget -qO- http://web` scheitert mit `bad address 'web'`,
`wget -qO- http://172.17.0.x` liefert die nginx-Startseite.

## 7 Dasselbe mit einem user-defined network

**7.1** Erstelle ein Netzwerk `my_net` mit dem Treiber `bridge`.

```sh
→
```

**7.2** Starte `web` und `tester` neu, beide in `my_net`
(Option `--net=my_net` oder `--network my_net`).

```sh
→
```

**7.3** Führe im `tester` erneut `wget -qO- http://web` aus. Ergebnis?

→

**7.4** Was ist der einzige Unterschied zu Aufgabe 6, und welche Docker-Funktion
erklärt ihn?

→

**7.5** Hänge den laufenden `tester` zusätzlich an das Standardnetz `bridge`
(`docker network connect`) und prüfe mit `ip addr` oder `ifconfig` im Container,
wie viele Schnittstellen er jetzt hat.

```sh
→
```

**7.6** Trenne ihn wieder von `my_net` und wiederhole `wget -qO- http://web`.
Ergebnis?

→

*Selbstkontrolle:* in 7.3 kommt die nginx-Startseite über den **Namen**,
in 7.6 scheitert es wieder.

## 8 Zwei Netze, keine Verbindung

**8.1** Erstelle `net_a` und `net_b`. Starte `nginx` als `web_a` in `net_a` und
einen `busybox`-Container `tester_b` in `net_b`.

```sh
→
```

**8.2** Versuche aus `tester_b` den Zugriff auf `web_a`, erst über den Namen,
dann über die IP, die du mit `docker network inspect net_a` findest.

→

**8.3** Was lernst du daraus über Isolation durch Netzwerke?

→

**8.4** Mach `web_a` für `tester_b` erreichbar, ohne einen Container neu zu starten.

```sh
→
```

## 9 host-Modus

**9.1** Starte den Zeitserver (Image aus Blatt 02) mit `--net=host` und **ohne**
`-p`. Auf welchem Port ist er erreichbar?

```sh
→
```

**9.2** Prüfe `docker container list`: was steht in der Spalte `PORTS`?

→

**9.3** Starte einen zweiten Container im host-Modus mit demselben Port.
Was passiert, und wie heißt das Problem?

→

**9.4** Starte den zweiten Container im host-Modus mit `-e PORT=8090`.
Funktioniert es jetzt? Warum?

→

**9.5** Schau im Container mit `hostname -i` oder `ip addr` nach:
welche IP hat er?

→

*Selbstkontrolle:* `curl http://localhost:8080` antwortet, obwohl kein `-p` gesetzt
wurde; die Spalte `PORTS` ist leer.

## 10 none-Modus

**10.1** Starte den Zeitserver mit `--net=none` detached.

```sh
→
```

**10.2** Versuche `curl http://localhost:8080` vom Host. Ergebnis?

→

**10.3** Prüfe im Container, welche Netzwerkschnittstellen es gibt
(`docker container exec <id> ip addr` — notfalls `ifconfig`). Was fehlt?

→

**10.4** Versuche aus dem Container heraus, nach außen zu kommen:
`docker container exec <id> wget -qO- http://example.com`. Ergebnis?

→

**10.5** Erreicht der Prozess im Container trotzdem seinen eigenen Port?
Prüfe mit `docker container exec <id> wget -qO- http://localhost:8080`.
Erkläre das Ergebnis.

→

*Selbstkontrolle:* vom Host keine Antwort, im Container nur `lo`, und der Zugriff
auf `localhost` innerhalb des Containers funktioniert.

## 11 publish gegen expose

**11.1** Baue ein Image aus dem Zeitserver-Dockerfile **ohne** `EXPOSE` und starte
es mit `-p 8080:8080`. Erreichbar?

→

**11.2** Baue es **mit** `EXPOSE 8080` und starte es **ohne** `-p`. Erreichbar
vom Host?

→

**11.3** Formuliere daraus in zwei Sätzen, was `EXPOSE` tatsächlich leistet und
was nur `-p` leistet.

→

**11.4** Starte den Container mit `-p 9000:8080`. Welche Adresse rufst du im
Browser auf, und welchen Port hört die Anwendung im Container?

→

## 12 Netzwerk-Diagnose

**12.1** Liste alle Netzwerke mit ihrem Treiber. Welche drei existieren nach einer
frischen Installation?

```sh
→
```

**12.2** Finde für das Netz `bridge` heraus: Subnetz, Gateway, verbundene Container.

| Angabe | Wert |
| --- | --- |
| Subnetz | … |
| Gateway | … |
| Verbundene Container | … |

**12.3** Ein Kollege sagt: „Der Container läuft, aber ich erreiche ihn nicht.“
Nenne vier Dinge, die du der Reihe nach prüfst.

→

---

# Weiter

- Originalaufgabe: `cloud-computing/origin-tasks/task-10/` (Aufgabe 10, mit Lösung)
- Nächstes Blatt: [06 – Docker Compose](06-compose.md)
