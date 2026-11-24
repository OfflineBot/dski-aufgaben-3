# Systems Engineering – Blatt 02: Softwaretechnik und Prozessmodelle

LE 2 und LE 3. Hier steht, was über die BSDS-Fragen hinaus zum Verständnis gehört.
Die BSDS-Fragen selbst stehen in [Blatt 01](01-bsds.md) und kommen hier nicht noch einmal vor.

Erst ohne Nachschlagen antworten, dann mit dem Hinweis prüfen.
Hinweise zeigen auf `dski-sources-3/systems-engineering/topics/...`.
Leere Zeile nach `→` ist dein Platz. Tabellenzellen mit `…` füllst du aus.

---

# LE 2 – Softwaretechnik

## 1 Begriff und magisches Dreieck

*Hinweis: `softwaretechnik/01-begriff-und-magisches-dreieck`*

**1.1** Schreibe die Definition von Software-Technik aus der Vorlesung auf. Welche drei Dinge werden bereitgestellt und systematisch verwendet, und wofür?

→

**1.2** Das magische Dreieck – trage die drei Ecken ein:

| Ecke | Was wird hier optimiert? |
|---|---|
| … | … |
| … | … |
| … | … |

Warum kann man nicht alle drei gleichzeitig maximieren?

→

## 2 Prinzipien, Methoden, Zerlegung

*Hinweis: `softwaretechnik/02-prinzipien-methoden-zerlegung`*

**2.1** Nenne die vier Prinzipien der Softwaretechnik:

→

**2.2** Methoden sind Zerlegungsstrategien. Welche Aufgabe haben sie, und welche drei Eigenschaften sollen die entstehenden Teile haben?

→

**2.3** Was ist eine korrekte Aufzählung von Arten der Zerlegung: „ereignisorientiert, funktionsorientiert“, „klassisch, objektorientiert“ oder „agil, klassisch“? (Single-Choice Klausur 2024/WKL)

→

## 3 Komplexität

*Hinweis: `softwaretechnik/04-komplexitaet-und-basiskonzepte`*

**3.1** Ordne jeder Komplexitätsart das passende Basiskonzept zu:

| Komplexität | Basiskonzepte |
|---|---|
| …der Daten | … |
| …der Funktionen | … |
| …der Algorithmen | … |
| …der Systemumgebung | … |
| …des zeitabhängigen Verhaltens | … |
| …der GUI | … |

---

# LE 3 – Prozessmodelle

## 4 Grundlagen

*Hinweis: `prozessmodelle/01-risiken-und-grundlagen`*

**4.1** Was ist ein Prozessmodell, und was legt es fest?

→

**4.2** Schreibe die Schritte von „code & fix“ auf und nenne drei Nachteile:

→

## 5 Wasserfallmodell

*Hinweis: `prozessmodelle/02-wasserfallmodell`*

**5.1** Nenne die Merkmale des Wasserfallmodells:

→

**5.2** Warum heißt das Wasserfallmodell „dokumentengetrieben“?

→

**5.3** Nenne die Nachteile:

→

## 6 V-Modell und Qualitätssicherung

*Hinweis: `prozessmodelle/03-v-modell`*

**6.1** Verifikation gegen Validation:

| | Leitfrage | Was wird geprüft? |
|---|---|---|
| Verifikation | … | … |
| Validation | … | … |

**6.2** Die zwei Arten von QS-Maßnahmen. Diese Unterscheidung wird in fast jeder Klausur gebraucht.

| Art | Definition | Beispiele |
|---|---|---|
| Analytische QS | … | … |
| Konstruktive QS | … | … |

**6.3** Ordne zu – analytisch oder konstruktiv? Begründe jeweils in einem Halbsatz.

| Maßnahme | Art | Begründung |
|---|---|---|
| Code-Review | … | … |
| Programmierrichtlinie | … | … |
| Modultest | … | … |
| Sprint Review | … | … |
| Sprint Retrospektive | … | … |

## 7 Prototypen-Modell

*Hinweis: `prozessmodelle/04-prototypen-modell`*

**7.1** Welche Probleme traditioneller Prozessmodelle soll das Prototypen-Modell lösen?

→

**7.2** Horizontaler gegen vertikaler Prototyp – was wird jeweils umgesetzt?

| | Was wird gebaut? | Wofür gut? |
|---|---|---|
| Horizontal | … | … |
| Vertikal | … | … |

**7.3** Nenne je drei Vorteile und Nachteile des Prototypen-Modells:

→

## 8 Evolutionäres und inkrementelles Modell

*Hinweis: `prozessmodelle/05-evolutionaeres-modell`, `prozessmodelle/06-inkrementelles-modell`*

**8.1** Evolutionäres Modell: Was ist der Ausgangspunkt, was ist der Produktkern, und was heißt „code-getrieben“?

→

**8.2** Welchen Nachteil des evolutionären Modells behebt das inkrementelle Modell, und wodurch?

→

**8.3** Was wird beim inkrementellen Modell vollständig gemacht, und was nur teilweise?

→

## 9 Modelle gegeneinander abgrenzen

*Hinweis: `prozessmodelle/07-zusammenfassung`*

**9.1** Fülle die Übersicht ohne Nachschlagen aus:

| Modell | Primäres Ziel | Benutzerbeteiligung | Merkmale |
|---|---|---|---|
| Wasserfallmodell | … | … | … |
| V-Modell | … | … | … |
| Prototypen-Modell | … | … | … |
| Evolutionäres Modell | … | … | … |
| Inkrementelles Modell | … | … | … |

**9.2** Welches Modell wählst du, wenn …? Trage Modell und Begründung ein.

| Situation | Modell | Begründung |
|---|---|---|
| Sicherheitskritische Steuerung, Anforderungen stehen fest | … | … |
| Auftraggeber weiß noch nicht, was er will | … | … |
| Anforderungen vollständig klar, aber eine erste Version soll früh ausgeliefert werden | … | … |

**9.3** Welche Modelle sind dokumentengetrieben, welche code-getrieben?

→

---

# Weiter

- Nächstes Blatt: [03 – Agiles Software Engineering](03-agil.md)
