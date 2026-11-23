# Systems Engineering – Modellierung zum Ausfüllen

Arbeitsblatt 3 von 5: LE 7 (Use Cases), LE 8 (Aktivitätsdiagramme, BPMN),
LE 9 (Entscheidungstabellen).

- **Stufe 1** – Einordnung, Abgrenzung, Begriffe
- **Stufe 2** – Use Cases: Schablone, Diagramm, Beziehungen, Formulierungsregeln
- **Stufe 3** – Aktivitätsdiagramme und BPMN
- **Stufe 4** – Entscheidungstabellen
- **Stufe 5** – Modellierungsdrills: fünf Aufgaben im Klausurformat

Hinweise zeigen auf `dski-sources-3/systems-engineering/topics/...`.
Leere Zeile nach `→` ist dein Platz. Tabellenzellen mit `…` füllst du aus.
Diagramme zeichnest du auf Papier; im Blatt steht nur, was darin vorkommen muss.

Laut `ABOUT.md` sind die Aufgaben außerhalb der BSDS-Fragen „weit überwiegend
Modellierungsaufgaben“. Dieses Blatt ist damit das wichtigste der vier.
Stufe 5 ist Pflicht – Theorie allein reicht hier nicht.

---

# Stufe 1 – Einordnung und Abgrenzung

## 1 Das RE-Vorgehensmodell

*Hinweis: `use-cases/01-einordnung-im-re-vorgehensmodell`,
`aktivitaetsdiagramme-bpmn/01-einordnung-im-re-vorgehensmodell`,
`entscheidungstabellen/01-einordnung-im-re-vorgehensmodell`*

**1.1** Die drei Phasen des RE-Vorgehensmodells, von oben nach unten:

| # | Phase | Was wird hier erreicht? |
|---|---|---|
| 1 | … | … |
| 2 | … | … |
| 3 | … | … |

**1.2** Die drei Arbeitsschritte und was sie jeweils aus was machen:

| Schritt | aus | wird |
|---|---|---|
| 1 Identifizieren | … | … |
| 2 Abgrenzen | … | … |
| 3 Spezifizieren | … | … |

**1.3** Welche Artefakte entstehen beim Spezifizieren neben den Product Use Cases, und in welchem Dokument landet am Ende alles?

→

## 2 Business Use Case und Product Use Case

*Hinweis: `use-cases/02-abgrenzung-und-use-case-begriff`*

**2.1** Die zwei Methoden zur Abgrenzung des Systems:

| Methode | Zu welcher Methodenfamilie gehört sie? | Aktuell oder alt? |
|---|---|---|
| … | … | … |
| … | … | … |

**2.2** Was ist ein Use Case? Schreibe die Definition aus der Vorlesung auf (Aufgabe, Akteur, Ziel):

→

**2.3** Was ist ein Akteur? Nenne die Definition und die drei möglichen Erscheinungsformen (Klausur 2022 Aufgabe 1d, 3 Punkte):

→

**2.4** Der Merksatz zum Ort des Akteurs lautet: Akteure befinden sich stets …

→

**2.5** Ist das zu modellierende System (SuD) ein Akteur bei der Modellierung seiner eigenen Product Use Cases? Begründe. (Single-Choice Klausur 2024/WKL, Aufgabe 2d)

→

**2.6** Grenze Business Use Case und Product Use Case voneinander ab:

| | Business Use Case | Product Use Case |
|---|---|---|
| Was umfasst er? | … | … |
| Wo liegt die Grenze? | … | … |
| Wer arbeitet darin? | … | … |

**2.7** Erläutere das Systemverständnis in einem Geschäftsprozessmodell und in einem Product Use Case (Klausur 2021 Aufgabe 1a, 4 Punkte):

→

**2.8** Welche Aussage stimmt – und warum? „Ein Nachbarsystem ist immer auch ein Akteur“ / „Ein Akteur ist immer auch ein Nachbarsystem“ / „Akteur und Nachbarsystem können identisch sein“ (Single-Choice Klausur 2020, Aufgabe 2a)

→

### Fallbeispiel Vorlesungsplanung

*Hinweis: `use-cases/03-fallbeispiel-vorlesungsplanung`*

**2.9** Lies den Text zur Vorlesungsplanung und trage die Akteure ein. Markiere, wer Person, wer Organisationseinheit und wer externes System ist.

| Akteur | Art | Was tut er/sie/es? |
|---|---|---|
| … | … | … |
| … | … | … |
| … | … | … |
| … | … | … |

**2.10** Welche Datenspeicher und welche Nachbarsysteme kommen im Text vor?

→

**2.11** Grenze ab: Was ist hier der Business Use Case, und was bleibt als Product Use Case übrig? Begründe, warum der Postversand des VVZ nicht ins System gehört.

→

**2.12** Welches Ereignis löst den Ablauf aus, und wann tritt es ein?

→

---

# Stufe 2 – Use Cases

## 3 Notation und Schablone

*Hinweis: `use-cases/04-notation-und-schablone`*

**3.1** Wann reicht eine umgangssprachliche Beschreibung, wann braucht man die Schablone?

→

**3.2** Die acht Felder der UC-Schablone, in der richtigen Reihenfolge, mit je einer Zeile, was hineingehört:

| # | Feld | Inhalt |
|---|---|---|
| 1 | … | … |
| 2 | … | … |
| 3 | … | … |
| 4 | … | … |
| 5 | … | … |
| 6 | … | … |
| 7 | … | … |
| 8 | … | … |

**3.3** Muss es eine Nachbedingung Fehlschlag geben? Begründe. (Single-Choice Klausur 2024/WKL, Aufgabe 2h)

→

**3.4** Wie viele Wörter darf ein Use-Case-Name haben, und welche Frage beantwortet er?

→

**3.5** Grenze Erweiterungen und Alternativen im Beschreibungsteil voneinander ab:

| | Erweiterung | Alternative |
|---|---|---|
| Was tut sie mit der Aktivität? | … | … |
| Wie wird sie nummeriert? | … | … |
| Läuft der UC danach weiter? | … | … |

**3.6** Welche Aussage stimmt bezüglich Alternativen in einem Product Use Case: „Eine Alternative ergänzt eine Aktivität“ / „Zu einer Alternative kann es keine Erweiterungen geben“ / „nichts davon“? Begründe. (Single-Choice Klausuren 2021 und 2022, Aufgabe 2i)

→

## 4 Use-Case-Diagramm

*Hinweis: `use-cases/05-use-case-diagramm`*

**4.1** Was modelliert ein Use-Case-Diagramm? (Klausur 2025 Aufgabe 3b, 4 Punkte)

→

**4.2** Ist ein UC-Diagramm die Darstellung *eines* Product Use Case oder die Zusammenfassung *aller* Product Use Cases und Akteure? (Single-Choice Klausuren 2021 und 2022, Aufgabe 2a)

→

**4.3** Die Notationselemente:

| Element | Symbol |
|---|---|
| Akteur | … |
| Externes System | … |
| Use Case | … |
| System | … |
| Kommunikation | … |

**4.4** Was bedeutet eine Linie zwischen Akteur und Use Case genau?

→

## 5 Beziehungen zwischen Use Cases

*Hinweis: `use-cases/06-beziehungen-zwischen-use-cases`*

**5.1** Nenne und erläutere die Beziehungsarten bei Use Cases (Klausur 2025 Aufgabe 3a, 4 Punkte):

→

**5.2** Fülle die Gegenüberstellung ohne Nachschlagen aus:

| | `<<include>>` | `<<extend>>` |
|---|---|---|
| Bedeutung | … | … |
| Wann genutzt? | … | … |
| Bedeutung für UC A | … | … |
| Abhängigkeiten | … | … |

**5.3** Was ist ein Extension Point, und an welchem der beiden Use Cases wird er notiert?

→

**5.4** In welche Richtung zeigt der Pfeil bei `<<include>>`, in welche bei `<<extend>>`?

→

**5.5** Welche Aussage ist richtig: „`include` erweitert einen Use Case unter bestimmten Bedingungen“ oder „`extend` wird für Erweiterungen und Alternativen eines Use Cases benutzt“? (Single-Choice Klausuren 2020, 2021, 2022)

→

**5.6** Für welche Teile eines Use Cases ist eine extend-Beziehung möglich – nur Erweiterungsteil, nur Alternativenteil oder beide? (Single-Choice Klausur 2020, Aufgabe 2h)

→

**5.7** Ordne zu – `include` oder `extend`?

| Situation | Beziehung |
|---|---|
| UC #002 Kundenauftrag ausführen braucht immer UC #020 Rechnung erstellen | … |
| UC #004 Kundendaten aktualisieren nur, wenn die Daten veraltet sind | … |
| Drei verschiedene UC brauchen alle „Dokument drucken“ | … |
| Ein Sonderfall, der aus dem Hauptablauf ausgelagert wurde | … |

## 6 Detaillierungsgrad

*Hinweis: `use-cases/07-detaillierungsgrad`*

**6.1** Die vier Ebenen der Zielhierarchie von oben nach unten, und wo die „Wasserlinie“ liegt:

| Ebene | Frage (Warum? / Wie?) | Beispiel |
|---|---|---|
| … | … | … |
| … | … | … |
| … | … | … |
| … | … | … |

**6.2** Die vier Merksätze zum Detaillierungsgrad:

1. Ausgangspunkt sind …
2. Die Abgrenzung der Use Cases ist nie …, kann aber sehr wohl …
3. Ein UC für operative Ziele muss den … bestehen: „…“
4. Typischerweise dauert diese Aktivität … min, betrifft … Person(en) und wird in … Sitzung(en) erledigt.

**6.3** Was meint der Coffee-Break-Test – den sinnvollen Umfang einer Aktivität oder den eines Product Use Cases? (Single-Choice in den Klausuren 2020, 2021, 2022 und 2024/WKL – jedes Mal dieselbe Frage)

→

**6.4** Operatives Ziel oder nicht? Kreuze an und begründe.

| Kandidat | Operatives Ziel? | Begründung |
|---|---|---|
| Benutzer anmelden | … | … |
| Neukunde erfassen | … | … |
| Kampagne auswählen | … | … |
| Kampagne planen | … | … |
| Produkt auswählen | … | … |
| Kundenauftrag ausführen | … | … |

## 7 Formulierungsregeln R1–R8

*Hinweis: `use-cases/08-formulierungsregeln`*

**7.1** Trage alle acht Regeln ein:

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

**7.2** Die einfache Grammatik aus R1: … … … …

**7.3** Was bedeutet die Regel „Who has the ball“ – aus Sicht des Akteurs schreiben, angeben wer die Aktivität ausführt, oder angeben für wen etwas getan wird? (Single-Choice in den Klausuren 2021, 2022 und 2024/WKL)

→

**7.4** Die Daumenregel aus R4: mehr als ca. … Aktivitäten hat kein guter Use Case.
Mit welcher Frage ermittelst du, ob eine Aktivität einen Zwischenerfolg liefert?

→

**7.5** Das vollständige Ereignis-Reaktionsschema aus R6, in vier Schritten:

1. …
2. …
3. …
4. …

**7.6** R7 „Validieren statt überprüfen“: Welches Problem erzeugt „prüfen“ fast immer, und wie löst „validieren“ es?

→

**7.7** Stimmt die Aussage „Nach ‚prüfen‘, ‚validieren‘ etc. kommt immer genau eine Alternative“? (Single-Choice Klausur 2020, Aufgabe 2b)

→

**7.8** Die Schreibweise für Wiederholungen aus R8: … — … — …

**7.9** Korrigiere jede fehlerhafte Formulierung und nenne die verletzte Regel:

| Formulierung | Verletzte Regel | Korrektur |
|---|---|---|
| Er hebt den Geldbetrag von seinem Bankkonto ab. | … | … |
| 1. Authentifizierungsdaten lesen. 2. Authentifizierungsdaten prüfen. | … | … |
| 1. Vornamen eingeben. 2. Nachnamen eingeben. 3. Kontonummer eingeben. | … | … |
| 1. System erfragt Vornamen. 2. Kunde gibt Vornamen an. (… sechs Schritte) | … | … |
| Das System überprüft die Authentifizierungsdaten. | … | … |

---

# Stufe 3 – Aktivitätsdiagramme und BPMN

## 8 Aktivitätsdiagramme

*Hinweis: `aktivitaetsdiagramme-bpmn/02-aktivitaetsdiagramme`*

**8.1** Welchen Nachteil der UC-Schablone beseitigt das Aktivitätsdiagramm? Nenne das Beispiel aus der Vorlesung (welche Aktivitäten von UC #002 müssen nicht sequentiell ablaufen?).

→

**8.2** Die grundlegenden Notationssymbole eines AD – zeichne jedes Symbol daneben:

| Element | Symbol |
|---|---|
| Aktivität | … |
| Entscheidungsknoten | … |
| Synchronisationsbalken | … |
| Startknoten | … |
| Endeknoten | … |
| Kontrollfluss mit Bedingung | … |

**8.3** Die vier logischen Operatoren und ihre Knotennamen:

| Operator | Knotenname | Symbol |
|---|---|---|
| Aufteilendes UND | … | … |
| Zusammenführendes UND | … | … |
| Aufteilendes XOR | … | … |
| Zusammenführendes XOR | … | … |

**8.4** Weiterführende Elemente – wozu dienen sie?

| Element | Wozu? |
|---|---|
| Swimlane / Partition | … |
| `<<datastore>>` | … |
| Konnektor (eingekreiste Zahl) | … |

**8.5** Was kennzeichnet `<<datastore>>`, und darf man es weglassen?

→

**8.6** Zeichne das Muster für **(a) Alternativen** und **(b) Erweiterungen** in einem Product Use Case mit der Methode der Aktivitätsdiagramme (Klausur 2024/WKL, Aufgabe 3, 10 Punkte – diese Aufgabe kam wortgleich dran).

(a) Muster für Alternativen – welche Knoten brauchst du, wohin führt der Zweig?

→

(b) Muster für Erweiterungen – welche Knoten brauchst du, wohin führt der Zweig zurück?

→

**8.7** Woran erkennst du im AD den Unterschied zwischen einer Alternative und einer Erweiterung? Nenne das Kriterium in einem Satz.

→

## 9 Exkurs: SA und AD

*Hinweis: `aktivitaetsdiagramme-bpmn/03-exkurs-sa-und-ad`*

**9.1** Welches Element der Structured Analysis entspricht welchem Element im Aktivitätsdiagramm?

| SA | AD |
|---|---|
| Prozess | … |
| Datenspeicher | … |
| Datenfluss | … |
| Nachbarsystem | … |

## 10 BPMN 2.0

*Hinweis: `aktivitaetsdiagramme-bpmn/04-exkurs-bpmn`*

**10.1** Warum ist BPMN „die elegantere Lösung, aber halt nicht UML“?

→

**10.2** Die wichtigsten Notationssymbole – zeichne sie daneben:

| Element | Symbol |
|---|---|
| Aufgabe | … |
| Teilaufgabe | … |
| Startereignis | … |
| Endereignis | … |
| Zeitliches Ereignis | … |
| Kontrollfluss | … |
| Standardverzweigung | … |
| Gerichtete (Daten-)Assoziation | … |
| Ungerichtete Assoziation | … |
| Anmerkung | … |
| Datenobjekt | … |
| Datenspeicher | … |
| Pool | … |
| Lane | … |

**10.3** Die drei Gateways:

| Gateway | Symbol | Bedeutung |
|---|---|---|
| Exklusives ODER | … | … |
| Logisches ODER | … | … |
| Logisches UND | … | … |

**10.4** Übersetze von AD nach BPMN:

| AD | BPMN |
|---|---|
| Aktivität | … |
| Entscheidungsknoten | … |
| Parallelisierungsknoten | … |
| Swimlane | … |
| Startknoten | … |
| `<<datastore>>` | … |

**10.5** Worin unterscheiden sich Pool und Lane?

→

---

# Stufe 4 – Entscheidungstabellen

## 11 Anforderung erfassen

*Hinweis: `entscheidungstabellen/02-anforderung-bonitaetspruefung`*

**11.1** Die drei Schritte, wenn eine neue Anforderung auftaucht, je mit den Unterpunkten:

| Schritt | Was tust du? |
|---|---|
| 1 Anforderung erfassen | … |
| 2 Auswirkung auf bestehendes Modell klären | … |
| 3 Modell anpassen | … |

**11.2** Der CRM-Kunde redet im O-Ton und nennt dabei einen Betrag zweimal unterschiedlich. Welcher Wert gilt am Ende, und was lernst du daraus über Erhebungsgespräche?

→

**11.3** Welche Fragen stellst du als RE-Ingenieur/in an diesen Kunden? Schreibe fünf auf.

→

## 12 Entscheidungstabelle aufstellen

*Hinweis: `entscheidungstabellen/03-entscheidungstabelle-aufstellen`*

**12.1** Die drei Teile einer Entscheidungstabelle:

| Teil | Was steht darin? |
|---|---|
| … | … |
| … | … |
| … | … |

**12.2** Wie viele Regeln hat eine vollständige, nicht konsolidierte ET bei n Bedingungen? Rechne für n = 2, 3, 4 aus.

→

**12.3** Wann ist eine Entscheidungstabelle konsolidierbar, und was bedeutet der Strich `-` in einer Zelle?

→

**12.4** Was fordert die Redundanzfreiheit? Erkläre am Beispiel aus der Vorlesung, warum dort R1 überflüssig ist.

→

**12.5** Was fordert die Widerspruchsfreiheit/Konsistenz? Erkläre am Beispiel, worin der Widerspruch besteht.

→

**12.6** Rekonstruiere die ET #001 „Bonitätsprüfung“ aus der Vorlesung, erst vollständig, dann konsolidiert.

Vollständig (8 Regeln):

| ET #001 | R1 | R2 | R3 | R4 | R5 | R6 | R7 | R8 |
|---|---|---|---|---|---|---|---|---|
| B1: Kunde gesperrt | … | … | … | … | … | … | … | … |
| B2: Offene Rechnungen > … EUR | … | … | … | … | … | … | … | … |
| B4: Einwandfreies Zahlungsverhalten | … | … | … | … | … | … | … | … |
| A1: Verweigerung | … | … | … | … | … | … | … | … |
| A2: Bankeinzug | … | … | … | … | … | … | … | … |
| A3: Nachnahme | … | … | … | … | … | … | … | … |

Konsolidiert:

| ET #001 | R1 | R5 | R6 | R7 | R8 |
|---|---|---|---|---|---|
| B1: Kunde gesperrt | … | … | … | … | … |
| B2: Offene Rechnungen > … EUR | … | … | … | … | … |
| B4: Einwandfreies Zahlungsverhalten | … | … | … | … | … |
| A1: Verweigerung | … | … | … | … | … |
| A2: Bankeinzug | … | … | … | … | … |
| A3: Nachnahme | … | … | … | … | … |

Welche Regeln wurden zu R1 zusammengefasst, und warum ging das?

→

**12.7** Woran liegt es, dass die Bedingung „B3“ in der Vorlesungstabelle fehlt? Was sagt dir das über das Erhebungsgespräch?

→

## 13 Auswirkungen auf UC und AD

*Hinweis: `entscheidungstabellen/04-auswirkungen-auf-uc-und-ad`*

**13.1** Wie wird eine Entscheidungstabelle in einen Use Case integriert – Verweis in der Aktivität, Tabelle im Erweiterungsteil, oder gar nicht? (Single-Choice Klausur 2020, Aufgabe 2g)

→

**13.2** Vergleiche UC #002 vor und nach der Bonitätsprüfung. Was ist im Normalablauf dazugekommen, und welche Alternativen sind neu?

| | vorher | nachher |
|---|---|---|
| Aktivitäten | … | … |
| Alternativen | … | … |

**13.3** Warum erzeugt eine ET mit drei Aktionen im Use Case genau drei Zweige (eine Alternative je Aktion)?

→

**13.4** Was musst du nach einer ET-Änderung außer dem UC noch anpassen?

→

## 14 Grundsätze ordnungsgemäßer Modellierung

*Hinweis: `entscheidungstabellen/05-grundsaetze-ordnungsgemaesser-modellierung`*

**14.1** Die sechs GoM, je mit einem Satz:

| Grundsatz | Was fordert er? |
|---|---|
| … | … |
| … | … |
| … | … |
| … | … |
| … | … |
| … | … |

**14.2** Grenze semantische und syntaktische Richtigkeit voneinander ab. Warum ist semantische Richtigkeit nicht beweisbar, und woraus ergibt sie sich stattdessen?

→

**14.3** Welcher Grundsatz ist verletzt? Trage ein.

| Situation | Verletzter Grundsatz |
|---|---|
| Das Modell enthält Datenbanktabellen, obwohl nur der Fachablauf interessiert | … |
| Niemand im Fachbereich versteht das Diagramm | … |
| Die Modellierung kostet mehr als das Projekt einspart | … |
| Ist- und Sollmodell wurden in verschiedenen Notationen gezeichnet | … |
| Nur die Datensicht wurde modelliert, die Dynamik fehlt | … |
| Ein Akteur steht innerhalb der Systemgrenze | … |

**14.4** Welche vier Sichten werden bei der Modellierung von Informationssystemen unterschieden (Variante 1), und welche zwei (Variante 2)?

→

---

# Stufe 5 – Modellierungsdrills

Zeitvorgabe wie in der Klausur: Use Case ca. 20 min, AD/BPMN ca. 8 min,
Entscheidungstabelle ca. 12 min. Erst modellieren, dann gegen die
Formulierungsregeln R1–R8 und die GoM prüfen.

## 15 Drill A: Lastenrad ausleihen

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

**15.1** Erstelle mit der UC-Schablone aus der Vorlesung den Product Use Case
„PUC #001 Lastenrad ausleihen“.

→

**15.2** Erstelle das zugehörige Aktivitätsdiagramm.

→

**15.3** Erstelle das zugehörige BPMN-Modell (ohne Swimlanes).

→

**15.4** Kontrolliere deinen UC gegen diese Liste und hake ab:

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

## 16 Drill B: Mietwagen zurücknehmen

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

**16.1** Erstelle den Product Use Case „PUC #002 Mietwagen zurücknehmen“.

→

**16.2** Zeichne das Use-Case-Diagramm für die Vermietung mit mindestens
„PUC #002 Mietwagen zurücknehmen“, „PUC #003 Schadensfall anlegen“ und
„PUC #004 Vertrag über Kennzeichen suchen“. Setze `<<include>>` und
`<<extend>>` dort ein, wo sie hingehören, und begründe jede Wahl.

→

**16.3** Welche Aktivitäten in deinem Ablauf könnten parallel laufen? Zeichne
das Aktivitätsdiagramm mit Parallelisierungs- und Synchronisationsknoten.

→

## 17 Drill C: Fehlerhaften Use Case korrigieren

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

## 18 Drill D: Entscheidungstabellen modellieren

**18.1 Parkhausschranke.** Modelliere die konsolidierte, redundanz- und
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

**18.2 Kreditantrag.** Modelliere die konsolidierte Entscheidungstabelle:

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

**18.3** Baue das Ergebnis von 18.2 in einen Use Case ein: Wie lautet die
Aktivität im Normalablauf, und welche Alternativen entstehen daraus?

→

## 19 Drill E: Fehlerhafte Entscheidungstabelle korrigieren

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

**19.1** Redundanz: Welche Regel ist überflüssig, und warum?

→

**19.2** Widerspruch: Welche beiden Regeln widersprechen sich, bei welcher
Bedingungskombination, und worin besteht der Widerspruch?

→

**19.3** Bereinigte Tabelle:

| Bedingungen / Aktionen | R… | R… | R… | R… |
|---|---|---|---|---|
| B1: Kunde ist Mitglied | … | … | … | … |
| B2: Bestellwert > 30 € | … | … | … | … |
| B3: Aktionscode eingegeben | … | … | … | … |
| A1: Versandkostenfrei | … | … | … | … |
| A2: 5 % Rabatt | … | … | … | … |

**19.4** Prüfe zum Schluss: Ist deine Tabelle vollständig, also deckt sie alle
acht Bedingungskombinationen ab? Weise es nach.

→

---

# Nächste Schritte

- `04-klausursimulation.md` – 100 Punkte, 120 min, im Klausurformat
- `05-altklausur-themen.md` – LE 1, 5, 10 und Exkurs; dort stehen die
  Ereignisreaktionsmodelle und die SOPHIST-Satzschablone

Originalaufgaben zu diesem Blatt:

- `dski-sources-3/systems-engineering/origin-tasks/task-2` – Fallstudie AIM
  (All-Inclusive-Maschine): sieben User Stories, dazu UC, AD, BPMN, ET und
  Anforderungssätze nach SOPHIST-Schablone
- `dski-sources-3/systems-engineering/origin-tasks/task-3` – Modellierungsaufgabe
  ET #001 „Geld einzahlen“, **mit Musterlösung von BäM** im selben Ordner
- Altklausuren mit Modellierungsaufgaben:
  `origin-exams/exam-1-2020` (ET Buchhandlung, PUC Fitnessstudio),
  `origin-exams/exam-2-2021` und `exam-3-2022` (ET Krankenhausbesuch, PUC Ticketsystem),
  `origin-exams/exam-4-2024` (AD-Muster, PUC Fitnessstudio),
  `origin-exams/exam-5-2024` (ET Onlineshop-Rabatt, fehlerhafte ET, fehlerhafter UC, PUC Ticketsystem),
  `origin-exams/exam-6-2025` (PUC Kfz-Werkstatt + BPMN, fehlerhafter UC, ET Bibliothek)
