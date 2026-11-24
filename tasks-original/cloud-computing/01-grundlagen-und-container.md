# Blatt 01 – Grundlagen und Docker Container

Paradigma, Architektur, und dann Container starten, überwachen, stoppen, löschen.

Hinweise: `topics/docker/01-grundlagen`, `topics/docker/02-docker-container`

---

# Teil A – Theorie

## 1 Paradigma

**1.1** Vier Probleme der Frachtschifffahrt *vor* dem Standardcontainer, und was
die Standardisierung jeweils daraus gemacht hat:

| Vorher | Nachher |
| --- | --- |
| Manueller Aufwand: … | Standardisierung: … |
| Gefahr: … | Sicherheit: … |
| Performance: … | Performance: … |
| Unsichere Dauer: … | Planung: … |

**1.2** Die Zahlen aus dem Vergleich der ersten Jahre: eine …-köpfige Crew brauchte
eine …-Stunden-Schicht für … Tonnen. Danach entlud eine …-köpfige Crew in derselben
Zeit … Tonnen.

→

**1.3** Wie viel Prozent aller Frachtcontainer sind heute Standardcontainer, und
welche Folge hat das für die Infrastruktur an Häfen und auf Schiffen?

→

**1.4** Übertrage das Bild: Was ist im Docker-Umfeld der Container, was das Schiff,
was der Hafenkran? Schreibe für jedes ein technisches Gegenstück.

→

## 2 Was ist Docker

**2.1** Docker in einem Satz: Anwendungen …, … und … .

→

**2.2** Welche zwei Linux-Kernelfunktionen nutzt Docker für die Prozessvirtualisierung?

→

**2.3** Warum ist Docker die Programmiersprache der Anwendung gleichgültig?

→

**2.4** Die zwei Teile von Docker und ihre Aufgaben:

| Teil | Aufgabe | Wie kommuniziert er? |
| --- | --- | --- |
| Docker-Client | … | … |
| Docker-Deamon | … | … |

**2.5** Warum fand die Technologie so große Verbreitung? Nenne zwei Gründe aus den Folien.

→

## 3 Die vier Grundpfeiler

**3.1** Ordne zu:

| Begriff | Was ist es? |
| --- | --- |
| Docker Image | … |
| Docker Container | … |
| Docker Registry | … |
| Dockerfile | … |

**3.2** Die Kuchenrezept-Analogie: Was ist das Rezept, was der Kuchen, was die
Internetplattform, was das eigene Verfassen des Rezepts?

→

**3.3** Welcher der vier Grundpfeiler ist *nicht* ausführbar, und warum nicht?

→

## 4 Image gegen Container

**4.1** Fülle die Gegenüberstellung:

| | Docker Image | Docker Container |
| --- | --- | --- |
| Schreibbar? | … | … |
| Was beschreibt/ist es? | … | … |
| Portabel / replizierbar? | … | … |
| Hardwarebindung? | … | … |

**4.2** Was passiert beim Start eines Containers mit den Instruktionen des Images?

→

**4.3** Beschreibe das copy-on-write-Prinzip in drei Sätzen: warum ist es nötig,
was wird kopiert, wohin?

→

**4.4** Was passiert mit der beschreibbaren Schicht, wenn der Container beendet wird?

→

**4.5** Warum ist das der starke Kontrast zur virtuellen Maschine? Was passiert dort
mit Änderungen zur Laufzeit?

→

**4.6** Wieso vereinfacht dieses Modell die horizontale Skalierung?

→

## 5 Befehlssyntax

**5.1** Zerlege `docker container run -d hello-world` in die fünf Bestandteile:

| Docker Client | Objektklasse | Befehl | Optionale Parameter | Objektinstanz |
| --- | --- | --- | --- | --- |
| … | … | … | … | … |

**5.2** Zerlege genauso `docker container stop 682` und `docker image rm test:1.2`.

→

**5.3** Warum reichen bei ContainerIds in der Regel die ersten drei Zeichen?

→

**5.4** Was macht jeder Befehl? Eine Zeile pro Zeile.

| Befehl | Wirkung |
| --- | --- |
| `docker container run hello-world` | … |
| `docker container stop 684` | … |
| `docker container rm 684` | … |
| `docker container list` | … |
| `docker container list -a` | … |
| `docker container start 684` | … |
| `docker container stats 684` | … |
| `docker container logs 684` | … |

**5.5** Welchen Fehler macht jemand, der mit `docker container start nginx` einen
neuen nginx-Container starten will?

→

## 6 Optionen zur Ausführung

**6.1** Trage ein, wofür die Option steht und was sie bewirkt:

| Option | Kürzel für | Wirkung |
| --- | --- | --- |
| `-p 80:80` | … | … |
| `-d` | … | … |
| `-it` | … | … |

**6.2** In welcher Reihenfolge stehen die Ports bei `-p`? Schreibe die Notation auf.

→

**6.3** Was ist der *attached mode*, und was ist daran im Alltag unpraktisch?

→

**6.4** Was gibt `docker container run -d …` auf der Kommandozeile zurück?

→

## 7 Der Weg von „hello-world“

**7.1** Bringe die sieben Schritte in die richtige Reihenfolge (1–7):

| Schritt | Nr. |
| --- | --- |
| Docker Deamon erstellt einen Container basierend auf dem Image | … |
| Docker Deamon gibt den Output des Containers auf der Befehlszeile aus | … |
| Docker Deamon kontaktiert die Docker Registry und sucht dort nach dem Image | … |
| Docker Client ruft Docker Deamon auf | … |
| Docker Deamon stoppt den Container | … |
| Docker Deamon schaut, ob das Image lokal vorliegt | … |
| Docker Deamon lädt das Image von der Registry | … |

**7.2** Welche Schritte entfallen beim *zweiten* Aufruf desselben Befehls, und warum?

→

---

# Teil B – Praxis

Jede Aufgabe wirklich ausführen. Notiere die Befehle, die du benutzt hast —
in der Klausur musst du sie aufschreiben, nicht anklicken.

## 8 hello-world

**8.1** Führe das Image `hello-world` als Container aus. Welche Ausgabe kommt,
und wie lange läuft der Container danach weiter?

```sh
→
```

**8.2** Lass dir alle Container anzeigen — erst nur die laufenden, dann auch die
gestoppten. Warum ist der Container in der ersten Liste nicht zu sehen?

```sh
→
```

**8.3** Lösche den Container wieder. Prüfe, dass er weg ist, das Image aber noch da.

```sh
→
```

*Selbstkontrolle:* `docker container list -a` enthält keinen `hello-world`-Container mehr,
`docker image list` enthält das Image weiterhin.

## 9 nginx im Hintergrund (vgl. Aufgabe 5a)

**9.1** Starte `nginx` **detached** und mappe den Host-Port 8080 auf den
Container-Port 80. Öffne http://localhost:8080 im Browser oder mit
`curl -s http://localhost:8080 | head -5`.

```sh
→
```

**9.2** Bestimme die benötigten Ressourcen des Containers: CPU, RAM, Speicher.
Welcher Befehl, und welche Werte bekommst du?

```sh
→
```

| Ressource | Wert |
| --- | --- |
| CPU | … |
| RAM | … |
| Netz / Block I/O | … |

**9.3** Gib die Logs des Containers aus. Ruf die Seite im Browser erneut auf und
schau die Logs noch einmal an — was ist dazugekommen?

```sh
→
```

**9.4** Stoppe den Container, starte ihn wieder, und lösche ihn am Ende.
Welchen Befehl brauchst du für den Start eines *gestoppten* Containers?

```sh
→
```

*Selbstkontrolle:* nach `stop` antwortet `curl http://localhost:8080` nicht mehr,
nach `start` wieder. In `docker container list` steht in der Spalte `PORTS`
`0.0.0.0:8080->80/tcp`.

## 10 Zwei Container aus einem Image

**10.1** Starte zwei nginx-Container gleichzeitig, einen auf Host-Port 8080, einen
auf 8081. Gib beiden mit `--name` einen eigenen Namen.

```sh
→
```

**10.2** Wie viele Images liegen dafür lokal? Warum ist das so?

→

**10.3** Starte einen dritten nginx auf Host-Port 8080. Was passiert, und wie heißt
die Fehlermeldung ungefähr?

→

**10.4** Starte einen vierten Container mit dem Namen des ersten. Was passiert?

→

*Selbstkontrolle:* `docker container list` zeigt zwei laufende Container mit
unterschiedlichen Ports und denselben Wert in der Spalte `IMAGE`.

## 11 Interaktiv und flüchtig (vgl. Aufgabe 5b)

**11.1** Führe das Image `ubuntu` **interaktiv** als Container aus, sodass du eine
Shell bekommst.

```sh
→
```

**11.2** Erstelle im Container eine Datei mit `touch test.txt` in einem beliebigen
Verzeichnis. Notiere das Verzeichnis (`pwd`) und prüfe mit `ls`, dass die Datei da ist.

→

**11.3** Verlasse den Container mit `exit`. Starte **denselben** Container erneut
interaktiv und schau, ob die Datei noch da ist.

```sh
→
```

Hilfreich: `ls` gibt den Verzeichnisinhalt aus, `cd` wechselt das Verzeichnis,
`mkdir` erstellt ein Verzeichnis. Die Option `-i` funktioniert auch bei
`docker container start`.

**11.4** Ergebnis und Erklärung: Ist die Datei noch da? Begründe mit der
beschreibbaren Schicht.

→

**11.5** Starte jetzt einen **neuen** Container aus demselben Image und schau nach
der Datei. Ergebnis? Warum unterscheidet sich das von 11.3?

→

*Selbstkontrolle:* in 11.3 ist die Datei da, in 11.5 nicht. Wenn es bei dir anders
ist, hast du in 11.3 einen neuen Container gestartet statt den alten.

## 12 Die Option `--rm` (vgl. Aufgabe 5c)

**12.1** Was bewirkt `--rm` beim `docker container run`-Befehl?

→

**12.2** Zeige es: starte `ubuntu` einmal mit und einmal ohne `--rm`, jeweils mit
dem Startkommando `echo hallo`, und schau danach in `docker container list -a`.

```sh
→
```

**12.3** Wann willst du `--rm` haben, wann nicht? Je ein Beispiel.

→

## 13 In einen laufenden Container hinein

**13.1** Starte nginx detached. Verschaffe dir mit `docker container exec` eine
Shell *im laufenden* Container.

```sh
→
```

**13.2** Welche Linux-Distribution läuft im nginx-Image? Finde es mit
`cat /etc/os-release` heraus.

→

**13.3** Was ist der Unterschied zwischen `docker container exec -it <id> bash`
und `docker container run -it nginx bash`?

→

**13.4** Lege im laufenden Container mit
`echo "<h1>Hallo</h1>" > /usr/share/nginx/html/index.html` eine neue Startseite an
und lade die Seite im Browser neu. Lösche den Container, starte ihn neu aus dem
Image — was zeigt die Seite jetzt, und warum?

→

## 14 Fehlersuche

Jede Zeile ist ein echter Fehler. Was ist die Ursache, was die Korrektur?

| Symptom | Ursache | Korrektur |
| --- | --- | --- |
| `docker: invalid reference format` bei `docker container run -p 80 :80 nginx` | … | … |
| `Bind for 0.0.0.0:8080 failed: port is already allocated` | … | … |
| `Conflict. The container name "/web" is already in use` | … | … |
| `You cannot start a container that is paused` nach `docker container start …` | … | … |
| Browser auf http://localhost:8080 lädt nicht, `docker container list` zeigt den Container aber als `Up` und `PORTS` ist leer | … | … |
| `Error response from daemon: No such container: ac1` | … | … |

---

# Teil C – Verstehen prüfen

**15.1** Erklär einem Kommilitonen in drei Sätzen, warum ein Container nach dem
Löschen keine Daten mehr hat, ein Image aber nach dem Bauen immer gleich bleibt.

→

**15.2** Du sollst eine Anwendung mit zehn gleichzeitigen Instanzen betreiben.
Wie viele Images, wie viele Container, wie viele beschreibbare Schichten?

→

**15.3** Nenne für jeden Befehl den Zustand, in dem der Container danach ist
(`läuft`, `gestoppt`, `gelöscht`, `existiert nicht`):

| Befehl | Zustand danach |
| --- | --- |
| `docker container run -d nginx` | … |
| `docker container stop ac1` | … |
| `docker container start ac1` | … |
| `docker container rm ac1` | … |
| `docker container run --rm ubuntu echo hi` | … |

---

# Weiter

- Originalaufgabe: `cloud-computing/origin-tasks/task-5/` (Aufgabe 5, mit Lösung als PDF)
- Nächstes Blatt: [02 – Images und Dockerfile](02-images-und-dockerfile.md)
