# Systems Engineering – Grundlagen zum Ausfüllen

Arbeitsblatt 1 von 5: LE 2 (Softwaretechnik) und LE 3 (Prozessmodelle).

- **Stufe 1** – Softwaretechnik: Begriffe, Prinzipien, Methoden, Komplexität
- **Stufe 2** – Prozessmodelle: von code & fix bis inkrementell
- **Stufe 3** – Modelle gegeneinander abgrenzen (das fragt die Klausur am liebsten)

Regeln für dich: erst ohne Nachschlagen antworten, dann mit dem Hinweis prüfen.
Hinweise zeigen auf `dski-sources-3/systems-engineering/topics/...`.
Leere Zeile nach `→` ist dein Platz. Tabellenzellen mit `…` füllst du aus.

Laut `ABOUT.md` sind nur LE 2, 3, 4, 7, 8, 9 klausurrelevant, und daraus nur das,
was in der Vorlesung besprochen wurde. Alle BSDS-Fragen sind relevant und machen
ca. 30 % der Klausur aus. Dieses Blatt deckt LE 2 und LE 3 ab.

---

# Stufe 1 – Softwaretechnik

## 1 Was ist Software-Technik?

*Hinweis: `softwaretechnik/01-begriff-und-magisches-dreieck`*

**1.1** Schreibe die Definition von Software-Technik aus der Vorlesung auf. Welche drei Dinge werden bereitgestellt und systematisch verwendet, und wofür?

→

**1.2** Das magische Dreieck – trage die drei Ecken ein und erkläre, warum es „magisch“ heißt:

| Ecke | Was wird hier optimiert? |
|---|---|
| … | … |
| … | … |
| … | … |

Warum kann man nicht alle drei gleichzeitig maximieren?

→

## 2 Prinzipien, Methoden, Zerlegung

*Hinweis: `softwaretechnik/02-prinzipien-methoden-zerlegung`*

**2.1** Grenze Prinzip und Methode voneinander ab (BSDS #3, Frage 7):

| | Prinzip | Methode |
|---|---|---|
| Was ist es? | … | … |
| Wie allgemein? | … | … |
| Woher kommt es? | … | … |

**2.2** Nenne die vier Prinzipien der Softwaretechnik:

→

**2.3** Was ist mit „Methode“ in der Softwaretechnik außerdem gemeint (Oberbegriff wofür)?

→

**2.4** Methoden sind Zerlegungsstrategien. Welche Aufgabe haben sie, und welche drei Eigenschaften sollen die entstehenden Teile haben?

- Aufgabe: …
- Eigenschaft 1: …
- Eigenschaft 2: …
- Eigenschaft 3: …

**2.5** Nenne drei Arten bzw. Prinzipien der Zerlegung für Anforderungen (Klausurfrage WDSx24, Aufgabe 1f):

→

## 3 Teilaufgaben und Modellsichten

*Hinweis: `softwaretechnik/03-teilaufgaben-und-modellsichten`*

**3.1** Die vier zu modellierenden Sichten eines SuD, je mit zwei Basiskonzepten (Klausurfrage WDSx24, Aufgabe 1c):

| Sicht | Basiskonzepte |
|---|---|
| … | … |
| … | … |
| … | … |
| … | … |

**3.2** Warum reicht eine einzige Sicht auf ein System nicht aus?

→

## 4 Komplexitätsarten und Basiskonzepte

*Hinweis: `softwaretechnik/04-komplexitaet-und-basiskonzepte`*

**4.1** Die sechs Komplexitätsarten mit je einem Beispiel:

| Komplexität … | Beispiel |
|---|---|
| … | … |
| … | … |
| … | … |
| … | … |
| … | … |
| … | … |

**4.2** Ordne das passende Basiskonzept zu:

| Komplexität | Basiskonzepte | Anwendungsbereich |
|---|---|---|
| …der Daten | … | … |
| …der Funktionen | … | … |
| …der Algorithmen | … | … |
| …der Systemumgebung | … | … |
| …des zeitabhängigen Verhaltens | … | … |
| …der GUI | … | … |

**4.3** Welche Komplexitätsart liegt bei einem Motormanagement im Auto vor, welche bei einem Data Warehouse? Begründe.

→

## 5 Methodenbewertung und semantische Lücke

*Hinweis: `softwaretechnik/05-methodenbewertung`*

**5.1** Nach welchen Kriterien kann man Methoden vergleichen? Nenne mindestens fünf.

→

**5.2** Was versteht man unter der semantischen Lücke (*semantic gap*)? (Klausurfrage WDSx24, Aufgabe 1d)

→

**5.3** Nenne das Beispiel aus der Vorlesung: Wofür eignet sich SA, wofür nicht?

→

**5.4** Vier der 10 Forderungen an eine Methode – nenne sie:

→

**5.5** Die letzte Forderung lautet: aktive Unterstützung des Entwicklers. Was genau soll eine Methode sagen, und was nicht?

→

---

# Stufe 2 – Prozessmodelle

## 6 Risiken und Grundlagen

*Hinweis: `prozessmodelle/01-risiken-und-grundlagen`*

**6.1** Nenne fünf der Top-Ten-Risiken und je eine Gegenmaßnahme:

| Risiko | Gegenmaßnahme |
|---|---|
| … | … |
| … | … |
| … | … |
| … | … |
| … | … |

**6.2** Was ist ein Prozessmodell? Woraus besteht es?

→

**6.3** Wofür steht WHISCY, und was ist das Syndrom dahinter?

→

**6.4** Schreibe die vier Schritte von „code & fix“ auf:

1. …
2. …
3. …
4. …

**6.5** Drei Nachteile von code & fix, und welche Phase jeder Nachteil erzwingt:

| Nachteil | Notwendige Phase |
|---|---|
| … | … |
| … | … |
| … | … |

**6.6** Die sechs Inhalte eines Prozessmodells:

→

## 7 Wasserfallmodell

*Hinweis: `prozessmodelle/02-wasserfallmodell`*

**7.1** Die sechs Merkmale des Wasserfallmodells:

→

**7.2** Warum heißt das Wasserfallmodell „dokumentengetrieben“?

→

**7.3** Wann ist eine Anwender-/Auftraggeberbeteiligung vorgesehen, und wann nicht mehr?

→

**7.4** Die vier Nachteile:

→

**7.5** Warum können spät erkannte Anforderungsfehler im Wasserfallmodell teuer werden? (BSDS #2, Frage 3)

→

**7.6** Trotz aller Nachteile: wozu hat das Wasserfallmodell wesentlich beigetragen?

→

## 8 V-Modell

*Hinweis: `prozessmodelle/03-v-modell`*

**8.1** Welche zwei V-Modelle gibt es, und was erweitert jeweils was?

→

**8.2** Erläutere die Grundidee des klassischen V-Modells (BSDS #2, Frage 6):

→

**8.3** Verifikation gegen Validation:

| | Leitfrage | Was wird geprüft? | Anwenderbeteiligung? |
|---|---|---|---|
| Verifikation | … | … | … |
| Validation | … | … | … |

**8.4** Warum bedeutet formale Korrektheit nicht, dass das richtige Produkt entsteht?

→

**8.5** Die zwei Arten von QS-Maßnahmen (Dauerbrenner in jeder Klausur):

| Art | Zielt primär auf | Definition | Beispiele |
|---|---|---|---|
| Analytische QS | … | … | … |
| Konstruktive QS | … | … | … |

**8.6** Ordne zu – analytisch oder konstruktiv? Begründe jeweils in einem Halbsatz.

| Maßnahme | Art | Begründung |
|---|---|---|
| Code-Review | … | … |
| Programmierrichtlinie | … | … |
| Modultest | … | … |
| Checkliste für Abnahmen | … | … |
| Sprint Review | … | … |
| Sprint Retrospektive | … | … |

**8.7** Worin unterscheiden sich Integrations- und Systemtest? (BSDS #2, Frage 1)

→

**8.8** Warum sollten Testaktivitäten im V-Modell frühzeitig geplant werden? (BSDS #2, Frage 7)

→

## 9 Prototypen-Modell

*Hinweis: `prozessmodelle/04-prototypen-modell`*

**9.1** Vier Probleme traditioneller Prozessmodelle:

→

**9.2** Was unterstützt das Prototypen-Modell, und wie lautet sein Motto?

→

**9.3** Grenze die drei Prototyp-Arten voneinander ab (BSDS #2, Frage 2 – kommt praktisch in jeder Klausur):

| Art | Anderer Name | Wozu dient er? | Was passiert damit danach? |
|---|---|---|---|
| Experimenteller PT | … | … | … |
| Explorativer PT | … | … | … |
| Evolutionärer PT | … | … | … |

**9.4** Horizontaler gegen vertikaler Prototyp – was wird jeweils umgesetzt?

| | Was wird gebaut? | Wofür gut? |
|---|---|---|
| Horizontal | … | … |
| Vertikal | … | … |

**9.5** Die fünf Schritte des Kreislaufs des Verstehens, in der richtigen Reihenfolge:

1. …
2. …
3. …
4. …
5. …

**9.6** Warum ist der Kreislauf des Verstehens der Schlüssel zu einer erfolgreichen Systemanalyse?

→

**9.7** Bewertung des Prototypen-Modells – fünf Vorteile, fünf Nachteile:

| ☑ Vorteil | ☒ Nachteil |
|---|---|
| … | … |
| … | … |
| … | … |
| … | … |
| … | … |

**9.8** Vervollständige das Zitat des typischen Anwenders und erkläre, was es für das RE bedeutet:

> I can't tell you what I want, but …

→

## 10 Evolutionäres Modell

*Hinweis: `prozessmodelle/05-evolutionaeres-modell`*

**10.1** Beschreibe den Ablauf: Was ist der Ausgangspunkt, was der Produktkern, wie heißt die erste Auslieferung?

→

**10.2** Die vier Merkmale des evolutionären Modells:

→

**10.3** Was heißt „code-getrieben“, und wo ist der Gegensatz zum Wasserfallmodell?

→

**10.4** Fünf Vorteile und zwei Nachteile:

| ☑ Vorteil | ☒ Nachteil |
|---|---|
| … | … |
| … | … |
| … | |
| … | |
| … | |

**10.5** Welches Risiko entsteht beim evolutionären Vorgehen durch häufige Änderungen? (BSDS #2, Frage 4)

→

## 11 Inkrementelles Modell

*Hinweis: `prozessmodelle/06-inkrementelles-modell`*

**11.1** Welchen Nachteil des evolutionären Modells behebt das inkrementelle Modell, und wodurch genau?

→

**11.2** Was wird beim inkrementellen Modell vollständig gemacht, und was nur teilweise?

| | vollständig | nur teilweise |
|---|---|---|
| Modell / Analyse | … | … |
| Umsetzung | … | … |

**11.3** Warum sind Schnittstellen beim inkrementellen Modell besonders wichtig? (BSDS #2, Frage 5)

→

---

# Stufe 3 – Modelle abgrenzen

## 12 Zusammenfassung

*Hinweis: `prozessmodelle/07-zusammenfassung`*

**12.1** Fülle die Übersicht ohne Nachschlagen aus:

| Modell | Primäres Ziel | Fokus | Benutzerbeteiligung | Merkmale |
|---|---|---|---|---|
| Wasserfallmodell | … | … | … | … |
| V-Modell | … | … | … | … |
| Prototypen-Modell | … | … | … | … |
| Evolutionäres Modell | … | … | … | … |
| Inkrementelles Modell | … | … | … | … |

**12.2** Grenze das inkrementelle und das evolutionäre Modell voneinander ab (BSDS #2, Frage 8; Klausur 2020 Aufgabe 1e; Klausur 2022 Aufgabe 1e – diese Frage kommt immer):

→

**12.3** Welches Modell wählst du, wenn …? Trage Modell und Begründung ein.

| Situation | Modell | Begründung |
|---|---|---|
| Sicherheitskritische Steuerung, Anforderungen stehen fest | … | … |
| Auftraggeber weiß noch nicht, was er will | … | … |
| Echtzeit-Anforderung, deren Machbarkeit unklar ist | … | … |
| Festpreisprojekt mit minimalem Managementaufwand | … | … |
| Anforderungen vollständig klar, aber Time-to-Market zählt | … | … |

**12.4** Welche zwei Modelle sind dokumentengetrieben, welche drei code-getrieben?

→

---

# Nächste Schritte

- `02-agil.md` – LE 4: Agiles Software Engineering
- `03-modellierung.md` – LE 7, 8, 9: Use Cases, AD/BPMN, Entscheidungstabellen
- `04-klausursimulation.md` – 100 Punkte, 120 min, im Klausurformat
- `05-altklausur-themen.md` – LE 1, 5, 10 und Exkurs: laut `ABOUT.md` nicht
  relevant, in den Altklausuren aber regelmäßig gefragt

Originalfragen zu diesem Blatt:
`dski-sources-3/systems-engineering/origin-tasks/task-4` (BSDS #2, acht LE-3-Fragen)
und `task-5` Frage 7 (LE 2: Prinzipien gegen Methoden).
