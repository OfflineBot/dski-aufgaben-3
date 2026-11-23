# Systems Engineering – Klausursimulation

Arbeitsblatt 4 von 5. Aufbau, Punkteverteilung und Aufgabentypen sind aus den
Altklausuren übernommen, die Sachverhalte sind neu.

Dauer: 120 Minuten · Max. Punkte: 100 · Bestehensgrenze: 50 P · Hilfsmittel: keine

| Aufgabe Nr.: | 1 | 2 | 3 | 4 | 5 | 6 | ∑ |
|---|---|---|---|---|---|---|---|
| max. Punktzahl: | 34 | 19 | 8 | 19 | 10 | 10 | 100 |
| erreicht: | … | … | … | … | … | … | … |

So arbeitest du damit: Uhr stellen, Blätter 01–03 weglegen, durchschreiben.
Erst danach kontrollieren – die Hinweise auf die Fundstellen stehen am Ende
dieses Blattes, nicht bei den Aufgaben.

Zeitbudget als Richtwert: Aufgabe 1 ≈ 40 min, Aufgabe 2 ≈ 23 min,
Aufgabe 3 ≈ 10 min, Aufgabe 4 ≈ 23 min, Aufgabe 5 ≈ 12 min, Aufgabe 6 ≈ 12 min.

---

## 1. Bitte beantworten Sie die nachfolgenden Fragen aus BSDS. [34 Punkte]

**(a) [4 Punkte]** Nennen und erläutern Sie das Agile Manifest.

→

**(b) [3 Punkte]** Erläutern Sie die analytische und die konstruktive Qualitätssicherung und geben Sie zu jeder ein Beispiel an.

→

**(c) [3 Punkte]** Erläutern Sie die drei Arten von Prototypen: explorativ, experimentell und evolutionär.

→

**(d) [4 Punkte]** Grenzen Sie das inkrementelle und das evolutionäre Prozessmodell voneinander ab.

→

**(e) [4 Punkte]** Nennen und erläutern Sie die vier zu modellierenden Sichten eines SuD.

→

**(f) [3 Punkte]** Grenzen Sie Prinzipien und Methoden in der Softwaretechnik voneinander ab.

→

**(g) [2 Punkte]** Erläutern Sie, was man unter dem Begriff der semantischen Lücke versteht.

→

**(h) [4 Punkte]** Erläutern Sie die beiden Begriffe Definition of Done und Definition of Ready.

→

**(i) [3 Punkte]** Nennen und erläutern Sie die Arten von Akteuren eines Product Use Cases.

→

**(j) [4 Punkte]** Ist die Sprint Retrospektive eine konstruktive oder eine analytische QS-Maßnahme? Begründen Sie Ihre Antwort. Ordnen Sie außerdem das Sprint Review zu.

→

---

## 2. Agile Softwareentwicklung [19 Punkte]

**(a) [9 Punkte]** Nennen und erläutern Sie die Komponenten von Scrum. Gehen Sie dabei auf Rollen, Artefakte und Ereignisse ein.

→

**(b) [4 Punkte]** Nennen und erläutern Sie die vier Zonen des Agile-Fluency-Modells.

→

**(c) [6 Punkte]** Erläutern Sie den Begriff INVEST.

→

---

## 3. Grundlagen der Use-Case-Modellierung [8 Punkte]

**(a) [4 Punkte]** Nennen und erläutern Sie die Beziehungsarten bei Use Cases. Geben Sie zu jeder Beziehungsart an, ob der erweiterte bzw. inkludierende Use Case für sich vollständig ist.

→

**(b) [4 Punkte]** Erläutern Sie, wie detailliert ein Product Use Case sein muss. Gehen Sie dabei auf die Zielebenen und auf den Coffee-Break-Test ein.

→

---

## 4. Paketshop: Paket annehmen [19 Punkte]

Die Logistikkette ShipFix betreibt Paketshops in Einzelhandelsgeschäften. Ein
Kunde erscheint mit einem versandfertigen Paket am Annahmeschalter.

Der Shopmitarbeiter ruft im Shopsystem die Funktion „Paket annehmen“ auf und
erfasst den Versandauftrag über den vom Kunden mitgebrachten QR-Code des
Versandlabels. Das Shopsystem stellt anhand des Versandauftrags fest, ob der
Auftrag gültig und noch nicht eingeliefert ist. Danach erfasst der Mitarbeiter
Gewicht und Maße des Pakets über die Waage am Schalter. Das Shopsystem stellt
fest, ob Gewicht und Maße zum gebuchten Versandprodukt passen und ob der
Zielort beliefert wird. Passt alles, bucht das Shopsystem die Einlieferung,
vergibt die Sendungsnummer und sendet die Einlieferungsdaten an den
Belegdrucker. Der Mitarbeiter händigt dem Kunden den Einlieferungsbeleg aus und
legt das Paket in den Abholbehälter des Versanddienstleisters.

Lässt sich der QR-Code nicht einlesen, gibt der Mitarbeiter die
Auftragsnummer von Hand ein und führt den Vorgang fort. Passen Gewicht oder
Maße nicht zum gebuchten Versandprodukt, bucht der Mitarbeiter das passende
Produkt nach und kassiert die Differenz; der Vorgang läuft danach weiter. Ist
der Versandauftrag ungültig oder bereits eingeliefert oder wird der Zielort
nicht beliefert, wird keine Einlieferung gebucht und der Vorgang endet ohne
Annahme.

**(a) [15 Punkte]** Erstellen Sie mit der UC-Schablone aus der Vorlesung den
Product Use Case „PUC #001 Paket annehmen“.

→

**(b) [4 Punkte]** Erstellen Sie das zugehörige BPMN-Modell (ohne Swimlanes).

→

---

## 5. Fehlerhafter Use Case [10 Punkte]

Der folgende Use Case beschreibt den Vorgang „Paket abholen“ im Paketshop der
ShipFix. Im Modell sind **fünf schwere formale Modellierungsfehler** enthalten,
die Sie identifizieren und korrigieren sollen. Geben Sie zu jeder Korrektur eine
kurze Begründung an.

| Use Case #021: | Abholcode eingeben |
|---|---|
| Ziel: | Der Kunde hat sein hinterlegtes Paket erhalten. |
| Vorbedingung: | Für den Kunden liegt ein abholbereites Paket im Shop. |
| NB Erfolg: | Das Paket ist an den Kunden ausgehändigt und die Abholung im Shopsystem quittiert. |
| NB Fehlschlag: | — |
| Akteure: | Kunde, Shopmitarbeiter, Shopsystem (SuD), Versanddienstleister. |
| Auslösendes Ereignis: | Der Kunde erscheint mit seinem Abholcode im Paketshop. |

Normaler Ablauf:

1. Das Shopsystem erfragt den Abholcode.
2. Der Kunde nennt dem Shopmitarbeiter den Abholcode.
3. Das Shopsystem erfragt den Ausweis.
4. Der Kunde legt dem Shopmitarbeiter seinen Ausweis vor.
5. Das Shopsystem prüft den Abholcode.
6. Der Shopmitarbeiter entnimmt das Paket dem Lagerplatz und händigt es dem Kunden aus.
7. Der Shopmitarbeiter quittiert die Abholung im Shopsystem.

Erweiterungen:

6a. Das Paket ist nicht am angegebenen Lagerplatz auffindbar: UC beenden (Fehlschlag).

Alternativen:

7a. Der Kunde verweigert die Quittung: Der Shopmitarbeiter vermerkt die Aushändigung ohne Unterschrift.

| # | Formaler Fehler | Begründung / verletzte Regel | Korrektur |
|---|---|---|---|
| 1 | … | … | … |
| 2 | … | … | … |
| 3 | … | … | … |
| 4 | … | … | … |
| 5 | … | … | … |

---

## 6. Entscheidungstabelle [10 Punkte]

Am Annahmeschalter des Paketshops entscheidet das Shopsystem, ob und zu welchem
Tarif ein Paket angenommen wird.

Pakete, deren Inhalt als Gefahrgut deklariert ist, werden grundsätzlich nicht
angenommen. Ebenso wird die Annahme verweigert, wenn das Paket das zulässige
Höchstmaß oder Höchstgewicht überschreitet. Alle übrigen Pakete werden
angenommen: zum Standardtarif, und falls der Kunde eine Zusatzversicherung
wünscht, zum Standardtarif mit Versicherungsaufschlag.

Erstellen Sie die konsolidierte, redundanz- und widerspruchsfreie
Entscheidungstabelle. Benennen Sie Bedingungs-, Aktions- und Regelteil.

Bedingungen:

- B1: …
- B2: …
- B3: …

Aktionen:

- A1: …
- A2: …
- A3: …

Konsolidierte Entscheidungstabelle:

| ET #001 | R… | R… | R… | R… |
|---|---|---|---|---|
| B1: … | … | … | … | … |
| B2: … | … | … | … | … |
| B3: … | … | … | … | … |
| A1: … | … | … | … | … |
| A2: … | … | … | … | … |
| A3: … | … | … | … | … |

Von wie vielen Regeln sind Sie ausgegangen, und welche haben Sie warum
zusammengefasst?

→

---

# Nach der Klausur: Kontrolle

Erst jetzt nachschlagen. Fundstellen in
`dski-sources-3/systems-engineering/topics/...`:

| Aufgabe | Fundstelle |
|---|---|
| 1a | `agiles-software-engineering/02-agiles-manifest-und-prinzipien` |
| 1b, 1j | `prozessmodelle/03-v-modell` (Definition analytisch/konstruktiv) |
| 1c | `prozessmodelle/04-prototypen-modell` |
| 1d | `prozessmodelle/05-evolutionaeres-modell`, `06-inkrementelles-modell`, `07-zusammenfassung` |
| 1e | `softwaretechnik/03-teilaufgaben-und-modellsichten` |
| 1f | `softwaretechnik/02-prinzipien-methoden-zerlegung` |
| 1g | `softwaretechnik/05-methodenbewertung` |
| 1h | `agiles-software-engineering/06-definition-of-done-und-ready` |
| 1i | `use-cases/02-abgrenzung-und-use-case-begriff` |
| 2a | nur in der Literatur: `origin/.../07 LE 4_ .../Sutherland, J_ Scrum Handbook` |
| 2b | `agiles-software-engineering/07-agile-fluency-grundlagen`, `08-agile-fluency-zonen` |
| 2c | `agiles-software-engineering/05-agile-begriffe` |
| 3a | `use-cases/06-beziehungen-zwischen-use-cases` |
| 3b | `use-cases/07-detaillierungsgrad` |
| 4a | `use-cases/04-notation-und-schablone`, `08-formulierungsregeln` |
| 4b | `aktivitaetsdiagramme-bpmn/04-exkurs-bpmn` |
| 5 | `use-cases/04-notation-und-schablone`, `07-detaillierungsgrad`, `08-formulierungsregeln` |
| 6 | `entscheidungstabellen/03-entscheidungstabelle-aufstellen` |

Vergleichbare Originalaufgaben mit Musterlösung bzw. Originalwortlaut:

- `dski-sources-3/systems-engineering/origin-tasks/task-3` – ET #001 „Geld einzahlen“
  **mit BäMs Musterlösung**
- `dski-sources-3/systems-engineering/origin-exams/exam-6-2025` – gleicher Aufbau
  (34/19/8/19/10/10), PUC Kfz-Werkstatt + BPMN, fehlerhafter UC, ET Bibliothek
- `dski-sources-3/systems-engineering/origin-exams/exam-5-2024` – fehlerhafte ET
  und fehlerhafter UC
- `dski-sources-3/systems-engineering/origin-tasks/task-7` – alle BSDS-Fragen aus
  den Altklausuren im Originalwortlaut

Themen aus LE 1, 5, 10 und dem Exkurs, die in den Altklausuren vorkommen,
stehen in `05-altklausur-themen.md`.

**Achtung bei 2a und 1i:** Die Komponenten von Scrum und die Arten von Akteuren
werden in den Klausuren regelmäßig gefragt, stehen aber nicht in den
Vorlesungsfolien unter `topics/`. Siehe `02-agil.md`, Stufe 4.
