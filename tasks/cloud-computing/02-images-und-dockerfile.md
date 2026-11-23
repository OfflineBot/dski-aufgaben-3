# Blatt 02 – Docker Image und Dockerfile

Schichten, Prüfsummen, Tags, Registry — und dann das erste eigene Dockerfile.
Ab hier wird gebaut.

Hinweis: `topics/docker/03-docker-image`

---

# Teil A – Theorie

## 1 Warum überhaupt Images

**1.1** Fünf typische Fehlerursachen beim Livegang einer Anwendung in der
produktiven Umgebung:

→

**1.2** Welche dieser Ursachen löst ein Docker Image, welche nicht?

→

## 2 Aufbau in Schichten

**2.1** Woraus besteht ein Docker Image, und was hat es außerdem?

→

**2.2** Was wird pro Schicht gespeichert, und was wird zusätzlich pro Schicht erfasst?

→

**2.3** Was besagt das Prinzip der *immutable infrastructure* für eine Schicht?

→

**2.4** Was passiert beim Bau, wenn sich die Prüfsumme einer Schicht geändert hat?
Welche Schichten werden neu gebaut?

→

**2.5** Warum belegen zwei Images, die sich nur in der letzten Konfigurationszeile
unterscheiden, kaum doppelten Speicher?

→

**2.6** Was wird beim Down- und Upload eines Images übertragen?

→

**2.7** Was ist der Build-Cache?

→

**2.8** Mit welchem Befehl siehst du die Schichten eines Images?

→

**2.9** Worin unterscheidet sich das Image einer virtuellen Maschine strukturell
von einem Docker Image?

→

## 3 Tags

**3.1** Die vier Abschnitte eines Tags, mit Pflicht oder optional:

| Nr. | Abschnitt | Pflicht? |
| --- | --- | --- |
| 1 | … | … |
| 2 | … | … |
| 3 | … | … |
| 4 | … | … |

**3.2** Zerlege die Tags in ihre Abschnitte:

| Tag | Registry | User | Image | Version |
| --- | --- | --- | --- | --- |
| `hub.docker.com/plexinc/pms-docker:latest` | … | … | … | … |
| `openjdk:16-jdk-slim` | … | … | … | … |
| `postgres:17.6` | … | … | … | … |
| `registry.dhbw.de/cc/greeting:1.4.2` | … | … | … | … |
| `nginx` | … | … | … | … |

**3.3** Was wird gesetzt, wenn du keine Version angibst?

→

**3.4** Warum bedeutet `latest` *nicht* „die aktuelle Version“?

→

**3.5** Zwei Tags zeigen auf dasselbe Image. Wie viel Speicher kostet der zweite Tag?

→

**3.6** Woran erkennst du auf Docker Hub ein offizielles Image?

→

## 4 Registry

**4.1** Was ist eine Docker Registry, und welche zwei Zugriffsarten gibt es?

→

**4.2** Was bedeutet das Paradigma „image from the shelf“?

→

**4.3** Welche Registry ist nach der Installation als Standard gesetzt?

→

**4.4** Warum ist der Transfer zur Registry effizient? (Stichwort Schichten)

→

## 5 Dockerfile

**5.1** Wie heißt die Datei, und welche Dateiendung hat sie?

→

**5.2** Die drei Teile eines Dockerfiles, in der richtigen Reihenfolge:

| Nr. | Teil | Welche Instruktionen gehören dahin? |
| --- | --- | --- |
| 1 | … | … |
| 2 | … | … |
| 3 | … | … |

**5.3** Was erzeugt jede Zeile eines Dockerfiles?

→

**5.4** Mit welchem Befehl baust du ein Image mit dem Tag `imagetag` aus dem
Dockerfile im aktuellen Verzeichnis?

→

**5.5** Trage für jede Instruktion ein, was sie tut und *wann* sie wirkt
(Bauzeit oder Laufzeit):

| Instruktion | Wirkung | Bauzeit oder Laufzeit? |
| --- | --- | --- |
| `FROM` | … | … |
| `ENV` | … | … |
| `RUN` | … | … |
| `WORKDIR` | … | … |
| `COPY` | … | … |
| `EXPOSE` | … | … |
| `CMD` | … | … |

**5.6** Was ist der Unterschied zwischen `EXPOSE 8080` im Dockerfile und
`-p 80:8080` beim `run`? Braucht man beides?

→

**5.7** Die zwei Formen von `CMD`. Schreibe beide für `java -jar app.jar` auf und
nenne den Sicherheitsunterschied.

| Form | Notation | Prozess |
| --- | --- | --- |
| Exec form | … | … |
| Shell form | … | … |

→

**5.8** Welche zwei Instruktionen können zur Laufzeit überschrieben werden?

→

**5.9** Warum wird bei `FROM` ein detaillierter Tag empfohlen, und wie bekommt ein
Image Aktualisierungen des Baseimage?

→

**5.10** Was muss das Baseimage mitbringen, damit ein `RUN`-Kommando funktioniert?

→

## 6 Wichtige Image-Befehle

| Befehl | Wirkung |
| --- | --- |
| `docker image list` | … |
| `docker image history hello-world` | … |
| `docker image tag alpine v1` | … |
| `docker image pull alpine` | … |
| `docker image build -t test .` | … |
| `docker image rm test` | … |

**6.1** Was passiert bei `docker image tag alpine v1` mit dem alten Tag?

→

**6.2** Was bedeutet der Punkt am Ende von `docker image build -t test .`?

→

---

# Teil B – Praxis

## 7 Images beziehen und ansehen

**7.1** Lade `alpine:3.20` herunter, ohne einen Container zu starten.

```sh
→
```

**7.2** Liste die lokalen Images und notiere die Größe von `alpine:3.20` und `nginx`.

| Image | Größe |
| --- | --- |
| `alpine:3.20` | … |
| `nginx` | … |

**7.3** Zeige die Schichten von `alpine:3.20` und von `nginx`. Wie viele Schichten
hat jedes, und welche Instruktion steht in der obersten?

```sh
→
```

**7.4** Vergib für `alpine:3.20` zusätzlich den Tag `meinalpine:v1`. Prüfe in der
Image-Liste: wie viele Einträge, welche IMAGE ID, wie viel Speicher zusätzlich?

```sh
→
```

**7.5** Lösche den Tag `meinalpine:v1`. Ist `alpine:3.20` danach noch da?

→

*Selbstkontrolle:* nach 7.4 stehen zwei Zeilen mit **derselben** IMAGE ID in
`docker image list`.

## 8 Hands-On: Recherche eines Baseimage

**8.1** Suche auf https://hub.docker.com ein geeignetes Baseimage für eine
Spring-Anwendung. Woran erkennst du ein offizielles Image, und worüber informieren
die Tags?

→

**8.2** Notiere drei Kandidaten mit Tag und Größe und entscheide dich begründet:

| Image:Tag | Größe | Enthält JDK oder JRE? | Für uns geeignet, weil … |
| --- | --- | --- | --- |
| … | … | … | … |
| … | … | … | … |
| … | … | … | … |

**8.3** Lade dein gewähltes Image und inspiziere seine Schichten.

```sh
→
```

## 9 Das erste eigene Dockerfile (Zeitserver)

Arbeitsverzeichnis: `projekt/zeitserver`. Darin liegt nur `Zeitserver.java`.
Die Datei braucht kein Build-Werkzeug: `java Zeitserver.java` startet sie direkt.

**9.1** Schreibe ein `Dockerfile` in `projekt/zeitserver`, das:

- auf dem offiziellen Baseimage `eclipse-temurin:21-jdk-alpine` aufsetzt
- die Umgebungsvariablen `PORT=8080` und `GREETING=Hallo` setzt
- das Verzeichnis `/app` anlegt und als Arbeitsverzeichnis setzt
- `Zeitserver.java` nach `/app` kopiert
- Port 8080 freigibt
- den Container mit `java Zeitserver.java` in **Exec-Notation** startet

```dockerfile
→
```

**9.2** Baue daraus das Image `zeitserver:1.0` und starte einen Container, der auf
http://localhost:8080 erreichbar ist.

```sh
→
```

**9.3** Welche Ausgabe liefert `curl http://localhost:8080`, und was steht in
`docker container logs`?

→

**9.4** Überschreibe `GREETING` beim Start mit `-e GREETING="Moin"`, ohne das Image
neu zu bauen. Was zeigt die Antwort?

```sh
→
```

**9.5** Warum musst du für 9.4 das Image nicht neu bauen? Welche Instruktion macht
das möglich?

→

*Selbstkontrolle:* `curl http://localhost:8080` antwortet mit
`Hallo von <containerid>`, nach 9.4 mit `Moin von <containerid>`.
Der Besuchszähler steht auf `-1`, weil `/data` noch nicht beschreibbar ist —
das ist richtig und wird in Blatt 04 gelöst.

## 10 Schichten und Build-Cache beobachten

**10.1** Baue `zeitserver:1.0` ein zweites Mal, ohne etwas zu ändern. Was steht
jetzt in der Ausgabe hinter den einzelnen Schritten?

→

**10.2** Ändere in `Zeitserver.java` den Standardwert von `GREETING` (die Zeile
`env("GREETING", "Hallo")`) und baue erneut. Welche Schritte kommen aus dem Cache,
ab welchem Schritt wird neu gebaut? Warum genau ab dort?

→

**10.3** Verschiebe das `COPY` im Dockerfile nach *oben*, direkt unter `FROM`,
und wiederhole 10.2. Was wird jetzt neu gebaut?

→

**10.4** Welche Reihenfolge ist die bessere, und wie lautet die Regel dahinter?

→

**10.5** Zeige die Schichten deines Images und finde die Zeile, in der dein
`GREETING` steht.

```sh
→
```

*Selbstkontrolle:* in 10.1 steht hinter den Schritten `CACHED`, in 10.2 nur bis zum
`COPY`.

## 11 Dockerfile lesen

Gegeben:

```dockerfile
FROM openjdk:8-jdk-alpine
ENV demo.version=0.9
RUN mkdir app
WORKDIR app/
COPY target/*.jar app.jar
EXPOSE 8080
CMD ["java","-jar","/app.jar"]
```

**11.1** Beschreibe Zeile für Zeile, was beim **Bauen** passiert.

→

**11.2** Was passiert beim **Starten** eines Containers aus diesem Image?

→

**11.3** Wie viele Schichten entstehen?

→

**11.4** In welchem Verzeichnis im Container liegt die Jar-Datei nach dem `COPY`,
und welchen Pfad startet `CMD`? Passt das zusammen? Falls nicht: schreibe die
`CMD`-Zeile so, dass sie zum `WORKDIR` passt.

→

**11.5** Welcher Befehl auf dem Host muss *vor* dem Bauen gelaufen sein, damit
`COPY target/*.jar` etwas findet?

→

## 12 Dockerfile nach Vorgabe schreiben (vgl. Aufgabe 8)

Schreibe ein Dockerfile, das genau diese Vorgaben erfüllt:

- die Anwendung basiert auf dem offiziellen Baseimage `openjdk` in der Version
  `16-jdk-alpine`
- die Anwendung horcht im Container auf Port 8080, und dieser Port soll über den
  Hostport 3030 angesprochen werden
- `apk update` aktualisiert das Paketverzeichnis
- `apk add vim -y` installiert einen Texteditor
- `mkdir -p /usr/src/app` erstellt das Anwendungsverzeichnis
- es gibt einen neuen Benutzer `javauser` in der neuen Gruppe `java` mit
  eingeschränkten Rechten, unter dem die Anwendung läuft
- die Jar-Datei wird aus dem Verzeichnis `target` nach `/usr/src/app/app.jar` kopiert
- der Container startet mit `java -jar /usr/src/app/app.jar` in Exec-Notation

```dockerfile
→
```

Diese Aufgabe wird nur geschrieben, nicht gebaut: `openjdk:16-jdk-alpine` gibt es
auf Docker Hub nicht mehr. Willst du sie trotzdem bauen, nimm
`eclipse-temurin:21-jdk-alpine` und eine beliebige Jar-Datei in `target/`.

**12.1** Eine der Vorgaben gehört nach Best-Practice **nicht** ins Dockerfile:
„führe den Befehl `mvn clean install` aus“. Begründe, und nenne die Konsequenz,
wenn man es doch tut.

→

**12.2** Wie lautet der Build-Befehl, und wie der Run-Befehl mit dem Port-Mapping
aus der Vorgabe?

```sh
→
```

## 13 CMD überschreiben

**13.1** Starte einen Container aus `zeitserver:1.0`, der statt des Servers nur
`ls -la /app` ausführt.

```sh
→
```

**13.2** Welche Instruktion hast du damit überschrieben? Ist das Image dadurch
verändert?

→

**13.3** Starte `alpine:3.20` interaktiv mit `sh` als Startkommando und sieh nach,
welche Shell im Image überhaupt vorhanden ist (`ls /bin`). Warum funktioniert
`bash` bei Alpine nicht?

→

---

# Weiter

- Originalaufgaben: `cloud-computing/origin-tasks/task-8/` (Dockerfile nach Vorgabe)
- Nächstes Blatt: [03 – Best Practices](03-best-practices.md)
