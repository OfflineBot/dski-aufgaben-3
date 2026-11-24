# Systems Engineering – Blatt 04: Modellierung

LE 7 (Use Cases), LE 8 (Aktivitätsdiagramme, BPMN), LE 9 (Entscheidungstabellen).

Laut `ABOUT.md` sind die Aufgaben außerhalb der BSDS-Fragen „weit überwiegend
Modellierungsaufgaben“. Der zweite Teil dieses Blattes, die Modellierungsaufgaben,
ist deshalb Pflicht. Der erste Teil sammelt nur die Regeln, die du dafür brauchst
und die in den Klausuren zusätzlich abgefragt werden.

Hinweise zeigen auf `dski-sources-3/systems-engineering/topics/...`.
Leere Zeile nach `→` ist dein Platz. Tabellenzellen mit `…` füllst du aus.
Diagramme zeichnest du auf Papier.

---

# Teil A – Regeln, die du zum Modellieren brauchst

## 1 Use Case, Akteur, Systemgrenze

*Hinweis: `use-cases/02-abgrenzung-und-use-case-begriff`*

**1.1** Was ist ein Use Case? Schreibe die Definition aus der Vorlesung auf.

→

**1.2** Ist das zu modellierende System (SuD) ein Akteur bei der Modellierung seiner eigenen Product Use Cases? Begründe. (Single-Choice Klausur 2024/WKL)

→

**1.3** Grenze Business Use Case und Product Use Case voneinander ab:

| | Business Use Case | Product Use Case |
|---|---|---|
| Was umfasst er? | … | … |
| Wo liegt die Grenze? | … | … |

## 2 Die UC-Schablone

*Hinweis: `use-cases/04-notation-und-schablone`*

**2.1** Die acht Felder der UC-Schablone, in der richtigen Reihenfolge:

| # | Feld | Was gehört hinein? |
|---|---|---|
| 1 | … | … |
| 2 | … | … |
| 3 | … | … |
| 4 | … | … |
| 5 | … | … |
| 6 | … | … |
| 7 | … | … |
| 8 | … | … |

**2.2** Muss es eine Nachbedingung Fehlschlag geben? Begründe. (Single-Choice Klausur 2024/WKL)

→

**2.3** Grenze Erweiterungen und Alternativen voneinander ab:

| | Erweiterung | Alternative |
|---|---|---|
| Was tut sie mit der Aktivität? | … | … |
| Wie wird sie nummeriert? | … | … |
| Läuft der UC danach weiter? | … | … |

## 3 Use-Case-Diagramm und Beziehungen

*Hinweis: `use-cases/05-use-case-diagramm`, `use-cases/06-beziehungen-zwischen-use-cases`*

**3.1** Erläutere, was ein Use-Case-Diagramm modelliert. (Klausur 2025, 4 Punkte)

→

**3.2** Nenne und erläutere die Beziehungsarten bei Use Cases. (Klausur 2025, 4 Punkte)

| | `<<include>>` | `<<extend>>` |
|---|---|---|
| Bedeutung | … | … |
| Wann genutzt? | … | … |
| In welche Richtung zeigt der Pfeil? | … | … |

**3.3** Ordne zu – `include` oder `extend`?

| Situation | Beziehung |
|---|---|
| „Kundenauftrag ausführen“ braucht immer „Rechnung erstellen“ | … |
| „Kundendaten aktualisieren“ läuft nur, wenn die Daten veraltet sind | … |
| Drei verschiedene Use Cases brauchen alle „Dokument drucken“ | … |
| Ein Sonderfall, der aus dem Hauptablauf ausgelagert wurde | … |

## 4 Detaillierungsgrad und Formulierungsregeln

*Hinweis: `use-cases/07-detaillierungsgrad`, `use-cases/08-formulierungsregeln`*

**4.1** Was meint der Coffee-Break-Test – den sinnvollen Umfang einer Aktivität oder den eines Product Use Cases? (Single-Choice in vier Altklausuren)

→

**4.2** Operatives Ziel oder nicht? Begründe.

| Kandidat | Operatives Ziel? | Begründung |
|---|---|---|
| Benutzer anmelden | … | … |
| Neukunde erfassen | … | … |
| Produkt auswählen | … | … |
| Kundenauftrag ausführen | … | … |

**4.3** Trage die acht Formulierungsregeln ein:

| Regel | Inhalt |
|---|---|
| R1 | … |
| R2 | … |
| R3 | … |
| R4 | … |
| R5 | … |
| R6 | … |
| R7 | … |
| R8 | … |

**4.4** Was bedeutet die Regel „Who has the ball“ – aus Sicht des Akteurs schreiben, angeben wer die Aktivität ausführt, oder angeben für wen etwas getan wird? (Single-Choice in drei Altklausuren)

→

**4.5** R7 „Validieren statt überprüfen“: Welches Problem erzeugt „prüfen“, und wie löst „validieren“ es?

→

**4.6** Korrigiere jede fehlerhafte Formulierung und nenne die verletzte Regel:

| Formulierung | Verletzte Regel | Korrektur |
|---|---|---|
| Er hebt den Geldbetrag von seinem Bankkonto ab. | … | … |
| 1. Authentifizierungsdaten lesen. 2. Authentifizierungsdaten prüfen. | … | … |
| 1. Vornamen eingeben. 2. Nachnamen eingeben. 3. Kontonummer eingeben. | … | … |
| Das System überprüft die Authentifizierungsdaten. | … | … |

## 5 Aktivitätsdiagramme

*Hinweis: `aktivitaetsdiagramme-bpmn/02-aktivitaetsdiagramme`*

**5.1** Die Notationssymbole eines Aktivitätsdiagramms – zeichne jedes daneben:

| Element | Symbol |
|---|---|
| Aktivität | … |
| Startknoten | … |
| Endeknoten | … |
| Entscheidungsknoten | … |
| Synchronisationsbalken | … |
| Kontrollfluss mit Bedingung | … |

**5.2** Die vier logischen Operatoren:

| Operator | Knotenname | Symbol |
|---|---|---|
| Aufteilendes UND | … | … |
| Zusammenführendes UND | … | … |
| Aufteilendes XOR | … | … |
| Zusammenführendes XOR | … | … |

**5.3** Zeichne das Muster für **(a) Alternativen** und **(b) Erweiterungen** in einem Product Use Case mit der Methode der Aktivitätsdiagramme. (Klausur 2024/WKL, 10 Punkte)

→

**5.4** Woran erkennst du im Aktivitätsdiagramm den Unterschied zwischen einer Alternative und einer Erweiterung?

→

## 6 BPMN

*Hinweis: `aktivitaetsdiagramme-bpmn/04-exkurs-bpmn`*

**6.1** Die wichtigsten Notationssymbole – zeichne sie daneben:

| Element | Symbol |
|---|---|
| Aufgabe | … |
| Startereignis | … |
| Endereignis | … |
| Kontrollfluss | … |
| Datenobjekt | … |
| Pool und Lane | … |

**6.2** Die drei Gateways:

| Gateway | Symbol | Bedeutung |
|---|---|---|
| Exklusives ODER | … | … |
| Logisches ODER | … | … |
| Logisches UND | … | … |

**6.3** Übersetze von Aktivitätsdiagramm nach BPMN:

| Aktivitätsdiagramm | BPMN |
|---|---|
| Aktivität | … |
| Entscheidungsknoten | … |
| Parallelisierungsknoten | … |
| Startknoten | … |
| Swimlane | … |

## 7 Entscheidungstabellen

*Hinweis: `entscheidungstabellen/03-entscheidungstabelle-aufstellen`, `entscheidungstabellen/04-auswirkungen-auf-uc-und-ad`*

**7.1** Die drei Teile einer Entscheidungstabelle:

| Teil | Was steht darin? |
|---|---|
| … | … |
| … | … |
| … | … |

**7.2** Wie viele Regeln hat eine vollständige, nicht konsolidierte Entscheidungstabelle bei n Bedingungen? Rechne für n = 2, 3, 4 aus.

→

**7.3** Wann lassen sich zwei Regeln zusammenfassen, und was bedeutet der Strich `-` in einer Zelle?

→

**7.4** Was fordert die Redundanzfreiheit, was die Widerspruchsfreiheit?

→

**7.5** Wie wird eine Entscheidungstabelle in einen Use Case eingebaut, und warum entstehen aus einer Tabelle mit drei Aktionen drei Zweige?

→

---

# Teil B – Modellierungsaufgaben

Zeitvorgabe wie in der Klausur: Use Case ca. 20 min, AD/BPMN ca. 8 min,
Entscheidungstabelle ca. 12 min. Erst modellieren, dann gegen die
Formulierungsregeln R1–R8 prüfen.

## 8 Drill A: Lastenrad ausleihen

Die Stadtwerke betreiben an mehreren Stationen einen Lastenradverleih. Ein Kunde
kommt an die Station und möchte ein Lastenrad ausleihen. Der Stationsmitarbeiter
ruft im Verleihsystem die Funktion „Ausleihe anlegen“ auf und erfasst den Kunden
über dessen Kundenkarte. Das System stellt fest, ob der Kunde ausleihberechtigt
ist, also ob er volljährig ist und keine offenen Gebühren aus früheren Ausleihen
hat. Danach erfasst der Mitarbeiter das gewünschte Rad über die am Rahmen
angebrachte Rad-ID und den gewünschten Ausleihzeitraum. Das System stellt fest,
ob das Rad im gewünschten Zeitraum frei ist und ob die benötigte Ausstattung
(z. B. Kindersitz, Regenverdeck) daran montiert ist. Passt alles, legt das System
die Ausleihe an, berechnet die Kaution und sendet die Ausleihbestätigung an den
Stationsdrucker. Der Mitarbeiter händigt dem Kunden die ausgedruckte Bestätigung
und den Radschlüssel aus.

Lässt sich die Rad-ID nicht einlesen, gibt der Mitarbeiter sie von Hand ein und
führt den Vorgang fort. Fehlt am Rad eine gewünschte Ausstattung, rüstet der
Mitarbeiter sie nach und setzt den Vorgang fort. Ist der Kunde nicht
ausleihberechtigt oder ist im gewünschten Zeitraum kein Rad verfügbar, wird keine
Ausleihe angelegt und der Vorgang endet ohne Ausleihe.

**8.1** Erstelle mit der UC-Schablone aus der Vorlesung den Product Use Case
„PUC #001 Lastenrad ausleihen“.

→

**8.2** Erstelle das zugehörige Aktivitätsdiagramm.

→

**8.3** Erstelle das zugehörige BPMN-Modell (ohne Swimlanes).

→

**8.4** Kontrolliere deinen UC gegen diese Liste und hake ab:

| Prüfpunkt | ok? |
|---|---|
| Name aus zwei bis drei Wörtern | … |
| Nachbedingung Fehlschlag vorhanden und nicht „keiner“ | … |
| SuD **nicht** in der Akteursliste | … |
| Jede Aktivität hat ein Subjekt (R2) | … |
| „validieren“ statt „prüfen“ (R7) | … |
| Höchstens 9–10 Aktivitäten (R4) | … |
| Keine Lösungs- oder Implementierungsdetails | … |
| Jede Alternative beendet oder verzweigt den UC eindeutig | … |

## 9 Drill B: Mietwagen zurücknehmen

Bei der Autovermietung Rent-a-BäM gibt ein Kunde am Rückgabeschalter sein
Fahrzeug zurück. Der Stationsmitarbeiter ruft im Vermietsystem den Mietvertrag
über die Vertragsnummer auf. Anschließend erfasst er den Kilometerstand und den
Tankfüllstand und nimmt das Fahrzeug in Augenschein. Das System ermittelt aus
Mietdauer, gefahrenen Kilometern und Tankfüllstand den Endbetrag und bucht ihn
über den Zahlungsdienstleister von der hinterlegten Kreditkarte ab. Nach
erfolgreicher Abbuchung schließt das System den Mietvertrag ab und sendet die
Endabrechnung per E-Mail an den Kunden.

Stellt der Mitarbeiter einen neuen Schaden am Fahrzeug fest, legt er zusätzlich
einen Schadensfall an und beauftragt den Schadengutachter; der Vorgang läuft
danach weiter. Hat der Kunde die Vertragsnummer nicht zur Hand, ermittelt der
Mitarbeiter den Vertrag über das Kennzeichen. Schlägt die Abbuchung fehl, wird
der Mietvertrag nicht abgeschlossen; der Mitarbeiter informiert den Kunden über
den Grund und der Vorgang endet.

**9.1** Erstelle den Product Use Case „PUC #002 Mietwagen zurücknehmen“.

→

**9.2** Zeichne das Use-Case-Diagramm für die Vermietung mit mindestens
„PUC #002 Mietwagen zurücknehmen“, „PUC #003 Schadensfall anlegen“ und
„PUC #004 Vertrag über Kennzeichen suchen“. Setze `<<include>>` und
`<<extend>>` dort ein, wo sie hingehören, und begründe jede Wahl.

→

**9.3** Welche Aktivitäten in deinem Ablauf könnten parallel laufen? Zeichne
das Aktivitätsdiagramm mit Parallelisierungs- und Synchronisationsknoten.

→

## 10 Drill C: Fehlerhaften Use Case korrigieren

Im folgenden Modell stecken **fünf schwere formale Modellierungsfehler**.
Identifiziere und korrigiere sie und gib zu jeder Korrektur eine kurze
Begründung an (Aufgabentyp aus Klausur 2024 Aufgabe 6 und Klausur 2025 Aufgabe 5).

| Use Case #012: | Lastenrad zurückgeben |
|---|---|
| Ziel: | Das Lastenrad ist zurückgenommen und die Miete abgerechnet. |
| Vorbedingung: | Für das Rad existiert eine laufende Ausleihe. |
| NB Erfolg: | Die Ausleihe ist beendet und die Abrechnung erstellt. |
| NB Fehlschlag: | keiner |
| Akteure: | Kunde, Stationsmitarbeiter, Verleihsystem (SuD), Zahlungsdienst. |
| Auslösendes Ereignis: | Der Kunde stellt das Lastenrad an der Station ab. |

Normaler Ablauf:

1. Die Rad-ID wird eingescannt.
2. Das System überprüft den Zustand des Rades.
3. Das System berechnet die Mietdauer, schreibt den Datensatz in die Tabelle RENTALS und ruft SP_CLOSE_RENTAL auf.
4. Der Zahlungsdienst bucht den Mietbetrag vom hinterlegten Konto ab und bestätigt die Zahlung an das System.
5. Der Stationsmitarbeiter händigt dem Kunden die Quittung aus.

Erweiterungen:

1a. Rad-ID nicht lesbar: Der Stationsmitarbeiter gibt die Rad-ID manuell ein.

Alternativen:

4a. Die Abbuchung schlägt fehl: Das System informiert den Kunden über den Grund und bricht ab.

| # | Fehler | Verletzte Regel / Grundsatz | Korrektur |
|---|---|---|---|
| 1 | … | … | … |
| 2 | … | … | … |
| 3 | … | … | … |
| 4 | … | … | … |
| 5 | … | … | … |

## 11 Drill D: Entscheidungstabellen modellieren

**11.1 Parkhausschranke.** Modelliere die konsolidierte, redundanz- und
widerspruchsfreie Entscheidungstabelle:

An der Einfahrt eines Parkhauses entscheidet die Schranke über die Einfahrt.
Wer einen gültigen Dauerparkerausweis vorzeigt, darf immer ohne Ticket
einfahren, unabhängig davon, wie voll das Parkhaus ist. Alle übrigen Fahrer
bekommen ein Ticket und dürfen einfahren, solange das Parkhaus nicht voll ist.
Ist das Parkhaus voll, dürfen sie nur dann mit Ticket einfahren, wenn für sie
eine Reservierung vorliegt. Liegt keine Reservierung vor, wird die Einfahrt
verweigert.

Bedingungen und Aktionen zuerst festlegen:

- B1: …
- B2: …
- B3: …
- A1: …
- A2: …
- A3: …

Konsolidierte Entscheidungstabelle:

| ET | R… | R… | R… | R… |
|---|---|---|---|---|
| B1: … | … | … | … | … |
| B2: … | … | … | … | … |
| B3: … | … | … | … | … |
| A1: … | … | … | … | … |
| A2: … | … | … | … | … |
| A3: … | … | … | … | … |

Von wie vielen Regeln bist du ausgegangen, wie viele bleiben übrig?

→

**11.2 Kreditantrag.** Modelliere die konsolidierte Entscheidungstabelle:

Eine Bank entscheidet über Kreditanträge. Ist die Bonität des Antragstellers in
Ordnung und bringt er mindestens 20 % Eigenkapital mit, wird der Kredit zum
Normalzins bewilligt. Ist die Bonität in Ordnung, liegt der Eigenkapitalanteil
aber darunter, wird der Kredit nur zum Risikozins bewilligt. Ist die Bonität
nicht in Ordnung, wird der Kredit abgelehnt – es sei denn, es liegt eine
Bürgschaft vor; dann wird zum Risikozins bewilligt. Der Eigenkapitalanteil
spielt in diesem Fall keine Rolle.

| ET | R… | R… | R… | R… |
|---|---|---|---|---|
| B1: … | … | … | … | … |
| B2: … | … | … | … | … |
| B3: … | … | … | … | … |
| A1: … | … | … | … | … |
| A2: … | … | … | … | … |
| A3: … | … | … | … | … |

Welche Bedingung ist in welcher Regel irrelevant, und woran erkennst du das im
Aufgabentext?

→

**11.3** Baue das Ergebnis von 11.2 in einen Use Case ein: Wie lautet die
Aktivität im Normalablauf, und welche Alternativen entstehen daraus?

→

## 12 Drill E: Fehlerhafte Entscheidungstabelle korrigieren

Ein Werkstudent legt dir diese Entscheidungstabelle für die Versandkonditionen
eines Onlineshops vor und behauptet, sie sei konsolidiert und widerspruchsfrei.
Sie enthält **genau zwei Fehler: eine Redundanz und einen Widerspruch**.
Finde beide, begründe sie und schreibe die bereinigte Tabelle auf
(Aufgabentyp aus Klausur 2024 Aufgabe 5).

| Bedingungen / Aktionen | R1 | R2 | R3 | R4 | R5 |
|---|---|---|---|---|---|
| B1: Kunde ist Mitglied | J | J | J | N | N |
| B2: Bestellwert > 30 € | J | J | N | J | - |
| B3: Aktionscode eingegeben | - | N | - | - | - |
| A1: Versandkostenfrei | X | X | | X | |
| A2: 5 % Rabatt | X | X | X | | |

**12.1** Redundanz: Welche Regel ist überflüssig, und warum?

→

**12.2** Widerspruch: Welche beiden Regeln widersprechen sich, bei welcher
Bedingungskombination, und worin besteht der Widerspruch?

→

**12.3** Bereinigte Tabelle:

| Bedingungen / Aktionen | R… | R… | R… | R… |
|---|---|---|---|---|
| B1: Kunde ist Mitglied | … | … | … | … |
| B2: Bestellwert > 30 € | … | … | … | … |
| B3: Aktionscode eingegeben | … | … | … | … |
| A1: Versandkostenfrei | … | … | … | … |
| A2: 5 % Rabatt | … | … | … | … |

**12.4** Prüfe zum Schluss: Ist deine Tabelle vollständig, also deckt sie alle
acht Bedingungskombinationen ab? Weise es nach.

→

---

# Weiter

- Nächstes Blatt: [05 – Klausursimulation](05-klausursimulation.md)

Originalaufgaben zu diesem Blatt:

- `dski-sources-3/systems-engineering/origin-tasks/task-2` – Fallstudie AIM:
  Use Case, Aktivitätsdiagramm, BPMN und Entscheidungstabelle zu einer User Story
- `dski-sources-3/systems-engineering/origin-tasks/task-3` – Modellierungsaufgabe
  ET #001 „Geld einzahlen“, mit Musterlösung im selben Ordner
- Altklausuren mit Modellierungsaufgaben: `origin-exams/exam-4-2024`,
  `exam-5-2024` und `exam-6-2025`
