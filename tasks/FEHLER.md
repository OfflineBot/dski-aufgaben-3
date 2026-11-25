# Fehlerliste

Nur was noch nicht sitzt. Was du kannst, fliegt raus. Neue Fehler kommen nach jeder Korrektur dazu.

Stand: 25.11.2026

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

---

# Bilanzierung

| Nr. | Was nicht sitzt | Zuletzt |
| --- | --- | --- |
| B1 | Aktiva oder Passiva zuordnen | Blatt 01, Station 1 |
| B2 | Fließt Geld oder nicht: Forderung, Anzahlung, auf Ziel | Blatt 01, Station 7, 9 |
| B3 | Degressive Abschreibung ab Jahr 2, Buchwert | Blatt 01, Station 6 |
| B4 | Nachträgliche Anschaffungskosten | Blatt 01, Station 4 |
| B5 | Plan oder möglicher Gewinn: nichts buchen | Blatt 01, Station 3d, 8d |
| B6 | Eigenkapital: Merkmale und Arten erklären | Blatt 01, Station 2c, 2d |
| B7 | Art des Cash Flows und Vorzeichen | Blatt 01, Station 9 |
| B8 | Gewinn ist nicht Kasse | Blatt 01, Station 10 |
| B9 | Von der GuV zu Jahresüberschuss und EBIT | Blatt 01, Station 11 |
| B10 | Kennzahlen deuten, nicht nur ausrechnen | Blatt 01, Station 12, 13 |
| B11 | Überschuldung und Illiquidität prüfen | Blatt 01, Station 14 |
| B12 | Pflichten: welche Abschlüsse, welche Frist | Blatt 01, Station 15 |
| B13 | Zahlungsbemessung erklären | Blatt 01, Station 16b |
| B14 | Formeln aus dem Kopf | Blatt 01, Station 17 |

## B1 - Aktiva oder Passiva zuordnen

- Du: Bankkredit ins Umlaufvermögen, Kasse ins Eigenkapital, Rohstoffe zu den Rückstellungen, gezeichnetes Kapital offen
- Richtig: Kasse und Rohstoffe sind Aktiva (Umlaufvermögen). Bankkredit ist Passiva (Verbindlichkeit). Gezeichnetes Kapital ist Passiva (Eigenkapital).
- Regel: Haben wir es → Aktiva. Schulden wir es oder gehört es den Eigentümern → Passiva.
- Wo: Blatt 01, Station 1

## B2 - Fließt Geld oder nicht: Forderung, Anzahlung, auf Ziel

- Du: geliefert und nicht bezahlt → Kasse +. Bezahlt und nicht geliefert → Forderung +.
- Richtig: geliefert, nicht bezahlt → Forderungen + und Umsatzerlöse +. Bezahlt, nicht geliefert → Kasse + und Erhaltene Anzahlungen +, kein Umsatz.
- Regel: Geliefert? Dann Umsatz. Bezahlt? Dann Kasse. Nur Vertrag → nichts.
- Auch: Verkauf auf Ziel und Abschreibung als Cash Flow gezählt. Beides ist kein Cash Flow.
- Wo: Blatt 01, Station 7, 9 (Vorfall 4 und 6)

## B3 - Degressive Abschreibung ab Jahr 2, Buchwert

- Du: Jahr 2 = 60.000 × 0,3². Buchwert nach zwei Jahren offen.
- Richtig: Jahr 2 = (60.000 − 18.000) × 0,3 = 12.600. Buchwert = Kaufpreis − alle bisherigen Abschreibungen.
- Regel: Der Satz geht immer auf den Restwert, nie wieder auf den Kaufpreis.
- Wo: Blatt 01, Station 6b, 6c

## B4 - Nachträgliche Anschaffungskosten

- Du: später angebauter Roboterarm „noch nicht“, Ergebnis 120.000
- Richtig: Er gehört dazu, Ergebnis 135.000.
- Regel: Spätere Erweiterung = nachträgliche Anschaffungskosten. Draußen bleiben nur Zinsen und laufende Kosten.
- Wo: Blatt 01, Station 4

## B5 - Plan oder möglicher Gewinn: nichts buchen

- Du: geplanter Hallenbau mit Kredit → Rückstellung. Herstellkosten unter dem Verkaufspreis → „−1.000?“
- Richtig: beide Male keine Buchung.
- Regel: Rückstellung nur bei einer wahrscheinlichen Schuld oder einem drohenden Verlust. Ein Plan ist keine Schuld, ein Gewinn zählt erst beim Verkauf.
- Wo: Blatt 01, Station 3d, 8d

## B6 - Eigenkapital: Merkmale und Arten erklären

- Du: Risiko = „man verwaltet das Risiko selber“, unbefristet = „nutzen, wann man will“. Arten fehlen.
- Richtig: Eigenkapital haftet für Verluste und muss nie zurückgezahlt werden. Arten: gezeichnetes Kapital, Kapitalrücklage, Gewinnrücklage, Gewinnvortrag, Jahresüberschuss.
- Regel: Die ersten zwei kommen von den Eigentümern, die anderen sind selbst verdient.
- Wo: Blatt 01, Station 2c, 2d

## B7 - Art des Cash Flows und Vorzeichen

- Du: Warenverkauf → Finanzierung. Tilgung → operativ. Rohstoffe → Investition. Miete mit Plus.
- Richtig: Warenverkauf, Miete, Rohstoffe sind operativ. Tilgung ist Finanzierung. Wir zahlen → Minus.
- Regel: Investition nur bei Anlagevermögen. Finanzierung nur bei Eigentümern und Bank. Der Rest ist operativ.
- Wo: Blatt 01, Station 9 (Vorfall 3, 5, 7, 8)

## B8 - Gewinn ist nicht Kasse

- Du: Jahresüberschuss nach Einlage 60.000, nach Kredit 100.000. Bilanzsumme steigt beim Barkauf der Maschine.
- Richtig: Einlage, Kredit und Maschinenkauf ändern den Gewinn nicht. Barkauf tauscht nur Kasse gegen Maschine, die Bilanzsumme bleibt.
- Regel: Der Gewinn ändert sich nur bei Ertrag oder Aufwand. Jeder Vorfall hat zwei Positionen.
- Wo: Blatt 01, Station 10

## B9 - Von der GuV zu Jahresüberschuss und EBIT

- Du: nicht gelöst
- Richtig: Umsatz − alle Aufwendungen = Jahresüberschuss. EBIT = Jahresüberschuss + Zinsen + Steuern.
- Regel: Treppe: Umsatz → EBIT → minus Zinsen und Steuern → Jahresüberschuss.
- Wo: Blatt 01, Station 11

## B10 - Kennzahlen deuten, nicht nur ausrechnen

- Du: Zahl hingeschrieben, Vergleich mit der Faustregel und Deutung fehlen. Eigenkapitalquote nicht ausgerechnet, DIO nur geschätzt.
- Richtig: immer drei Schritte: ausrechnen, mit der Faustregel vergleichen, ein Satz Deutung.
- Regel: Operativer Cash Flow > Investitionen heißt: Investitionen aus eigener Kraft bezahlt.
- Wo: Blatt 01, Station 12, 13

## B11 - Überschuldung und Illiquidität prüfen

- Du: nicht gelöst
- Richtig: Überschuldung → Eigenkapital anschauen. Illiquidität → Kasse gegen kurzfristige Schulden.
- Regel: Eine Rückstellung senkt das Eigenkapital, aber nicht die Kasse.
- Wo: Blatt 01, Station 14

## B12 - Pflichten: welche Abschlüsse, welche Frist

- Du: nur ja/nein. Einzelkaufmann als „klein“ eingestuft.
- Richtig: HGB + Steuerrecht, bei Töchtern Konzernabschluss, börsennotiert nach IFRS. Aufstellen: groß 3 Monate, sonst 6. Offenlegen: 12 Monate.
- Regel: Größenklassen gelten nur für Kapitalgesellschaften.
- Wo: Blatt 01, Station 15

## B13 - Zahlungsbemessung erklären

- Du: „schaut, ob man zahlen kann“
- Richtig: Aus dem Gewinn wird berechnet, wie viel gezahlt wird: Steuern und Dividende.
- Regel: Ob man zahlen kann, ist Liquidität, keine Funktion des Abschlusses.
- Wo: Blatt 01, Station 16b

## B14 - Formeln aus dem Kopf

- Du: noch keine
- Richtig: siehe `bilanzierung/formeln.md`
- Wo: Blatt 01, Station 17
