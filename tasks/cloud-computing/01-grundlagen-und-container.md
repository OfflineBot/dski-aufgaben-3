# Blatt 01 – Container starten und kontrollieren

Container starten, überwachen, stoppen, löschen. Alles hier wird wirklich ausgeführt.
Notiere die Befehle, die du benutzt hast.

Hinweis: `topics/docker/02-docker-container`

---

## 1 Befehle kennen

**1.1** Zerlege `docker container run -d hello-world` in die fünf Bestandteile:

| Docker Client | Objektklasse | Befehl | Optionale Parameter | Objektinstanz |
| --- | --- | --- | --- | --- |
| docker | container | run | -d | hello-world |

**1.2** Was macht jeder Befehl? Eine Zeile pro Zeile.

| Befehl | Wirkung |
| --- | --- |
| `docker container run hello-world` | startet das hello-world image (als container) |
| `docker container stop 684` | stoppt den container mit id 684 |
| `docker container rm 684` | löscht den container mit id 684 |
| `docker container list` | listet alle laufenden container |
| `docker container list -a` | listet alle container (uach gestoppte) |
| `docker container start 684` | startet einen gestoppten container der die id 684 hat |
| `docker container stats 684` | steigt stats wie cpu usage eines containers (mit id 684) an |
| `docker container logs 684` | zeigt die logs von container mit id 684 an |

**1.3** Trage ein, wofür die Option steht und was sie bewirkt:

| Option | Kürzel für | Wirkung |
| --- | --- | --- |
| `-p 8080:80` | port | startet auf port 80 und von außen wird port 8080 auf docker intern 80 gemappt. |
| `-d` | detached | startet im hintergrund. terminal danach weiter benutzbar |
| `-it` | integrated tty | geht in den container rein und man hat doch sh/bash zugriff auf die umgebung (als würde man per ssh in ein anderen pc gehen) |

**1.4** In welcher Reihenfolge stehen die Ports bei `-p`? Schreibe die Notation auf.

→ hostport:internal_port

**1.5** Welchen Fehler macht jemand, der mit `docker container start nginx` einen
neuen nginx-Container starten will?

→ start, startet nur einen stoppten. mit run erstellt man einen neuen

## 2 hello-world

**2.1** Führe das Image `hello-world` als Container aus. Welche Ausgabe kommt,
und wie lange läuft der Container danach weiter?

```sh
→ docker container run hello-world
```

danach sieht man die logs direkt im terminal

**2.2** Lass dir alle Container anzeigen — erst nur die laufenden, dann auch die
gestoppten. Warum ist der Container in der ersten Liste nicht zu sehen?

```sh
→ docker container list
→ docker container list -a
```

weil er noch gestoppt ist?

**2.3** Lösche den Container wieder. Prüfe, dass er weg ist, das Image aber noch da.

```sh
→ docker container stop hello-world
docker container rm hello-world
docker container list -a
docker image history
```

*Selbstkontrolle:* `docker container list -a` enthält keinen `hello-world`-Container mehr,
`docker image list` enthält das Image weiterhin.

## 3 nginx im Hintergrund (vgl. Aufgabe 5a)

**3.1** Starte `nginx` **detached** und mappe den Host-Port 8080 auf den
Container-Port 80. Öffne http://localhost:8080 im Browser oder mit
`curl -s http://localhost:8080 | head -5`.

```sh
→ docker container run -p 8080:80 -d nginx
curl -s http://localhost:8080 | head -5
```

das sind aufgaben. ich kann das nicht im hintergrund tastächlich öffnen

**3.2** Bestimme die benötigten Ressourcen des Containers (CPU, RAM).
Welcher Befehl, und welche Werte bekommst du?

```sh
→ docker container stats hello-world
```

**3.3** Gib die Logs des Containers aus. Ruf die Seite erneut auf und schau die
Logs noch einmal an — was ist dazugekommen?

```sh
→ docker container logs hello-world
```

da ich die website nicht selber sehe, kann ich nur vermuten: ein neuer connection attempt wird geloggt

**3.4** Stoppe den Container, starte ihn wieder, und lösche ihn am Ende.
Welchen Befehl brauchst du für den Start eines *gestoppten* Containers?

```sh
→ docker container stop hello-world
→ docker container rm hello-world
→ docker container run hello-world
```
wenn er nur gestoppt wäre bräuchte ich nur docker container start hello-world

*Selbstkontrolle:* nach `stop` antwortet `curl http://localhost:8080` nicht mehr,
nach `start` wieder. In `docker container list` steht in der Spalte `PORTS`
`0.0.0.0:8080->80/tcp`.

## 4 Zwei Container aus einem Image

**4.1** Starte zwei nginx-Container gleichzeitig, einen auf Host-Port 8080, einen
auf 8081. Gib beiden mit `--name` einen eigenen Namen.

```sh
→ docker container run -p 8080:80 --name a nginx
→ docker container run -p 8081:80 --name b nginx
```

**4.2** Wie viele Images liegen dafür lokal? Warum ist das so?

→ nur nginx, es sind nur 2 instanzen davon offen
image: blueprint, container: instanz davon

**4.3** Starte einen dritten nginx auf Host-Port 8080. Was passiert, und wie heißt
die Fehlermeldung ungefähr?

→ docker container run -p 8080:80 nginx

port 8080 wird schon genutzt

**4.4** Starte einen vierten Container mit dem Namen des ersten. Was passiert?

→ docker container run -p 8080:80 --name a nginx

port 8080 wird schon genutzt und der name ist der selbe

*Selbstkontrolle:* `docker container list` zeigt zwei laufende Container mit
unterschiedlichen Ports und demselben Wert in der Spalte `IMAGE`.

## 5 Interaktiv und flüchtig (vgl. Aufgabe 5b)

**5.1** Führe das Image `ubuntu` **interaktiv** als Container aus, sodass du eine
Shell bekommst.

```sh
→ docker container run -it ubuntu sh
```

**5.2** Erstelle im Container eine Datei mit `touch test.txt` in einem beliebigen
Verzeichnis. Notiere das Verzeichnis (`pwd`) und prüfe mit `ls`, dass die Datei da ist.

→ diese aufgabe ergibt so keinen sinn! 

**5.3** Verlasse den Container mit `exit`. Starte **denselben** Container erneut
interaktiv und schau, ob die Datei noch da ist. Die Option `-i` funktioniert auch
bei `docker container start`.

```sh
auch kein sinn..
```

**5.4** Ist die Datei noch da? Begründe mit der beschreibbaren Schicht.

→ copy on write. ja sie ist noch da

**5.5** Starte jetzt einen **neuen** Container aus demselben Image und schau nach
der Datei. Ergebnis? Warum unterscheidet sich das von 5.3?

→ container run nginx

nicht mehr da. es ist eine neue instanz!

*Selbstkontrolle:* in 5.3 ist die Datei da, in 5.5 nicht. Wenn es bei dir anders
ist, hast du in 5.3 einen neuen Container gestartet statt den alten.

## 6 Die Option `--rm` (vgl. Aufgabe 5c)

**6.1** Was bewirkt `--rm` beim `docker container run`-Befehl?

→ als --rm verstehe ich nicht. ich kenne nur docker container rm <name oder id>

**6.2** Zeige es: starte `ubuntu` einmal mit und einmal ohne `--rm`, jeweils mit
dem Startkommando `echo hallo`, und schau danach in `docker container list -a`.

```sh
→ weiß ich nicht.
```

## 7 In einen laufenden Container hinein

**7.1** Starte nginx detached mit dem Namen `web` auf Host-Port 8080. Verschaffe
dir mit `docker container exec` eine Shell *im laufenden* Container.

```sh
→ docker container run -d -p 8080:80 web
docker container exec -it web bash
```

**7.2** Was ist der Unterschied zwischen `docker container exec -it web bash`
und `docker container run -it nginx bash`?

→ run erstellt einen neuen container und gehr rein. exec geht in ein laufenden container rein in shell

**7.3** Lege im laufenden Container mit
`echo "<h1>Hallo</h1>" > /usr/share/nginx/html/index.html` eine neue Startseite an
und lade die Seite im Browser neu. Lösche den Container, starte ihn neu aus dem
Image — was zeigt die Seite jetzt, und warum?

→ nichts mehr, da es eine neue instanz ist!

## 8 Fehlersuche

Jede Zeile ist ein echter Fehler. Was ist die Ursache, was die Korrektur?

| Symptom | Ursache | Korrektur |
| --- | --- | --- |
| `docker: invalid reference format` bei `docker container run -p 80 :80 nginx` | port ist falsch definiert  (ohne leerzeichen) | -p 8080:80 |
| `Bind for 0.0.0.0:8080 failed: port is already allocated` | port ist schon vergeben | -p 8081:80 |
| `Conflict. The container name "/web" is already in use` | name schon vergeben | --name other_name1 |
| Browser auf http://localhost:8080 lädt nicht, `docker container list` zeigt den Container aber als `Up` und `PORTS` ist leer | keine ports vergeben | -p 8080:80 beim start befehl hinzufügen |
| `Error response from daemon: No such container: ac1` | id nicht gefunden | erst listen und dann den richtigen namen/id nehmen |

## 9 Verständnis

**9.1** Du sollst eine Anwendung mit zehn gleichzeitigen Instanzen betreiben.
Wie viele Images, wie viele Container, wie viele beschreibbare Schichten?

→ ein image, 10 container, mit schichten weiß ich nicht

**9.2** Warum hat ein neuer Container nichts von dem, was in einem anderen Container
aus demselben Image geändert wurde?

→ weil es nur eine instanz des images ist. das image ist der blueprint und ein container eine instanz davon

**9.3** Nenne für jeden Befehl den Zustand, in dem der Container danach ist
(`läuft`, `gestoppt`, `gelöscht`):

| Befehl | Zustand danach |
| --- | --- |
| `docker container run -d nginx` | nginx läuft detached, läuft |
| `docker container stop ac1` | der container mit id ac1 ist gestoppt |
| `docker container start ac1` | läuft |
| `docker container rm ac1` | gelöscht |
| `docker container run --rm ubuntu echo hi` | --rm weiß ich noch nicht |

---

# Weiter

- Originalaufgabe: `cloud-computing/origin-tasks/task-5/` (Aufgabe 5, mit Lösung als PDF)
- Nächstes Blatt: [02 – Images und Dockerfile](02-images-und-dockerfile.md)
