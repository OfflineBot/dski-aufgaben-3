# Korrektur Blatt 01 – Container starten und kontrollieren

## Übersicht

| | Anzahl | Anteil |
| --- | --- | --- |
| ✅ richtig | 16 | 55 % |
| 🟡 teilweise | 10 | 34 % |
| ❌ falsch oder nicht gewusst | 3 | 10 % |

Gewertet sind 29 von 30 Aufgaben. 5.2 zählt nicht, weil man sie nur am Rechner beantworten kann.
Tippfehler und ein fehlendes `-d` sind nicht gewertet.

- ✅ **Richtig:** 1.1 · 1.2 · 1.4 · 1.5 · 2.2 · 3.1 · 4.1 · 4.2 · 4.3 · 4.4 · 5.1 · 5.4 · 7.2 · 7.3 · 8 · 9.2
- 🟡 **Teilweise:** 1.3 · 2.1 · 2.3 · 3.2 · 3.3 · 3.4 · 5.5 · 7.1 · 9.1 · 9.3
- ❌ **Falsch:** 5.3 · 6.1 · 6.2

## Die drei Dinge, die hängen

**1. Du sprichst Container über den falschen Namen an (2.3, 3.2, 3.3, 3.4, 5.5, 7.1)**

- `hello-world` und `nginx` sind **Images**. Ein Container bekommt beim `run` eine Id und einen zufälligen Namen, außer du gibst mit `--name` einen vor.
- `docker container stats hello-world` → Docker antwortet `No such container: hello-world` (getestet).
- In 3.2 bis 3.4 ging es außerdem um den **nginx**-Container aus 3.1, nicht um hello-world.
- So geht es: Namen selbst vergeben (`--name web`) oder die Id aus `docker container list` nehmen.

**2. `--rm` kennst du noch nicht (6.1, 6.2, 9.3)**

- `--rm` ist eine Option von `run`: Der Container wird automatisch gelöscht, sobald er stoppt.
- Das ist etwas anderes als der Befehl `docker container rm`, den du von Hand aufrufst.

**3. Denselben Container wieder betreten (5.3)**

- `docker container start -i <id>` startet einen gestoppten Container und verbindet dich wieder mit seiner Shell.

---

## Die einzelnen Aufgaben

Nur was nicht ganz richtig war.

### 1.3 🟡

- `-p` steht für **publish**, nicht für port.
- `-it` steht für **interactive** und **tty**.
- Die Wirkung hast du bei allen dreien richtig beschrieben.

### 2.1 🟡

- Befehl ✅
- Es fehlt: Der Container gibt seinen Text aus und **beendet sich sofort**. Er läuft nicht weiter.

### 2.3 🟡

```sh
docker container list -a          # Id oder Namen des Containers ablesen
docker container rm <id>
docker container list -a          # ist er weg?
docker image list                 # ist das Image noch da?
```

- ❌ `stop hello-world` und `rm hello-world`: Der Container heißt nicht wie das Image.
- `stop` ist unnötig, der Container ist schon beendet.
- ❌ `docker image history` zeigt die Schichten eines Images. Ob ein Image da ist, zeigt `docker image list`.

### 3.2 und 3.3 🟡

```sh
docker container list             # Id des nginx-Containers ablesen
docker container stats <id>
docker container logs <id>
```

- ✅ `stats` und `logs` sind die richtigen Befehle.
- ❌ Das Ziel stimmt nicht (siehe Punkt 1 oben).
- Deine Vermutung zu den Logs stimmt: Jeder Seitenaufruf erzeugt eine neue Zeile.

### 3.4 🟡

```sh
docker container stop <id>
docker container start <id>
docker container stop <id>
docker container rm <id>
```

- Gefragt war: stoppen, **denselben** wieder starten, am Ende löschen.
- Du hast gestoppt, gelöscht und mit `run` einen neuen erstellt.
- ✅ Dein Nachsatz stimmt: Für einen gestoppten Container ist es `start`.

### 5.2 nicht gewertet

- Die Aufgabe ist ein Schritt am Rechner: im Container `touch test.txt`, `pwd`, `ls` eintippen. Auf Papier gibt es dazu nichts zu schreiben.

### 5.3 ❌

```sh
exit
docker container list -a          # Id des ubuntu-Containers ablesen
docker container start -i <id>
ls
```

- `start` nimmt den alten Container, `-i` verbindet dich mit seiner Shell.
- Die Datei ist dann noch da.

### 5.4 ✅

- Ergebnis stimmt. So wäre die Begründung vollständig: Die Datei liegt in der beschreibbaren Schicht des Containers. Die bleibt erhalten, solange der Container nur gestoppt und nicht gelöscht ist.

### 5.5 🟡

```sh
docker container run -it ubuntu
```

- ✅ Ergebnis und Begründung stimmen: neuer Container, eigene beschreibbare Schicht, Datei nicht da.
- ❌ „Dasselbe Image“ ist hier `ubuntu`, nicht `nginx`.

### 6.1 ❌

- `--rm` löscht den Container automatisch, sobald er stoppt. So bleiben keine gestoppten Container liegen.

### 6.2 ❌

```sh
docker container run ubuntu echo hallo
docker container run --rm ubuntu echo hallo
docker container list -a
```

- In der Liste steht nur der Container **ohne** `--rm`. Der andere ist schon weg.
- `echo hallo` hinter dem Image ersetzt das Startkommando.

### 7.1 🟡

```sh
docker container run -d --name web -p 8080:80 nginx
docker container exec -it web bash
```

- ✅ `exec -it web bash`
- ❌ Im ersten Befehl steht `web` an der Stelle des Images. `web` ist der Name, also `--name web`, und das Image `nginx` gehört ans Ende.

### 9.1 🟡

- ✅ Ein Image, zehn Container
- Es fehlt: **zehn** beschreibbare Schichten. Jeder Container hat seine eigene.

### 9.3 🟡

- Vier von fünf richtig.
- `docker container run --rm ubuntu echo hi` → **gelöscht**. Der Container läuft kurz, endet und wird durch `--rm` sofort entfernt.
