# Systems Engineering – Agiles SE zum Ausfüllen

Arbeitsblatt 2 von 4: LE 4 (Agiles Software Engineering).

- **Stufe 1** – Schwergewichtig gegen leichtgewichtig, Manifest, Prinzipien
- **Stufe 2** – Verfahren: Crystal, Scrum, Methodenauswahl
- **Stufe 3** – Agile Begriffe: Epic, User Story, INVEST, DoD/DoR, Agile Fluency

Hinweise zeigen auf `dski-sources-3/systems-engineering/topics/...`.
Leere Zeile nach `→` ist dein Platz. Tabellenzellen mit `…` füllst du aus.

LE 4 ist die punktreichste Lerneinheit: in jeder Altklausur kommt das Agile
Manifest (4–8 P) und mindestens eine Frage zu Scrum, INVEST oder DoD/DoR.
Abschnitt 8 sammelt die Themen, deren Antwort **nicht** in `topics/` steht,
sondern nur in der Literatur unter `origin/`.

---

# Stufe 1 – Grundlagen

## 1 Schwergewichtig und leichtgewichtig

*Hinweis: `agiles-software-engineering/01-schwergewichtig-und-leichtgewichtig`*

**1.1** Warum wird die klassische Softwareentwicklung als schwergewichtig bezeichnet? Nenne alle sechs Vorwürfe (Klausur 2024 Aufgabe 1c):

| # | Vorwurf | Was ist damit gemeint? |
|---|---|---|
| 1 | … | … |
| 2 | … | … |
| 3 | … | … |
| 4 | … | … |
| 5 | … | … |
| 6 | … | … |

**1.2** Zwei Gründe, warum eine vollständige Spezifikation nicht immer möglich oder sinnvoll ist, je mit dem Beispiel aus der Vorlesung:

| Grund | Beispiel |
|---|---|
| … | … |
| … | … |

**1.3** Space-Shuttle-Rechnung: In jeder LOC steckt … Gesamtaufwand. Rechne das auf ein typisches betriebliches IS hoch:

- Typische Größe: … KLOC
- Kosten: …
- Dauer bei 1000 Mitarbeitern: …
- Welches Gesetz ist dabei noch gar nicht berücksichtigt? …

**1.4** Vervollständige Fazit 1 (drei Zeilen):

> Formalismus bedeutet nicht …
>
> Prozess bedeutet nicht …
>
> Dokumentation bedeutet nicht …

**1.5** Was fordern leichtgewichtige SE-Prozesse, und worauf konzentrieren sie sich?

→

**1.6** Setze die Gleichung richtig fort:

- Schwergewichtige Prozesse = … (… the … things)
- Leichtgewichtige Prozesse = … und … (… the … things …)
- Der Anspruch der Leichtgewichtigen in einem Satz: …

**1.7** Was bedeutet „agil“ wörtlich, worauf wird bei der agilen SE hoher Wert gelegt, und was ist das einzige Erfolgskriterium?

→

## 2 Agiles Manifest und Prinzipien

*Hinweis: `agiles-software-engineering/02-agiles-manifest-und-prinzipien`*

**2.1** Die vier Werte des Agilen Manifests, links und rechts (BSDS #3, Frage 1; in jeder Altklausur, bis zu 8 Punkte):

| | wird höher bewertet als | |
|---|---|---|
| … | über | … |
| … | über | … |
| … | über | … |
| … | über | … |

**2.2** Welcher Satz steht am Ende des Manifests, und warum ist er für die Interpretation entscheidend?

→

**2.3** Ordne die vier Werte dem schwergewichtigen Gegenstück zu:

| Schwergewichtiges SWE | Leichtgewichtiges SWE |
|---|---|
| Detaillierte Prozesse und Werkzeuge | … |
| Umfangreiche Dokumente sind notwendig | … |
| Detaillierte Verträge | … |
| Konzentration auf Planung, Steuerung und Kontrolle | … |

**2.4** Schreibe alle 12 Prinzipien der agilen SE auf. (Wenn dir weniger einfallen: markiere die Lücken und hole sie nach.)

1. …
2. …
3. …
4. …
5. …
6. …
7. …
8. …
9. …
10. …
11. …
12. …

**2.5** Nenne drei agile Prinzipien, die besonders den Umgang mit dem Kunden bzw. seinen Anforderungen betreffen (BSDS #3, Frage 6):

→

**2.6** Welche Form der Kommunikation wird nach den agilen Prinzipien bevorzugt? (BSDS #3, Frage 2)

→

**2.7** Was ist das wichtigste Fortschrittsmaß in der agilen Entwicklung, und was ausdrücklich nicht? (BSDS #3, Frage 3)

→

**2.8** Welche Bedeutung haben selbstorganisierte Teams? (BSDS #3, Frage 4)

→

**2.9** Fazit 2 lautet: agile Softwareentwicklung ist Software Engineering. Mit welchem Argument über den „dummen Softwareingenieur“ wird das begründet?

→

---

# Stufe 2 – Verfahren und Auswahl

## 3 Taxonomie agiler Verfahren

*Hinweis: `agiles-software-engineering/03-agile-verfahren`*

**3.1** Was bedeutet „Crystal“, und wie versteht Cockburn seine Methodenfamilie – als verbindlichen Satz oder als Beispiel?

→

**3.2** Wonach richtet sich bei Crystal die Wahl der konkreten Methode?

→

**3.3** Die vier Kategorien des möglichen Schadens:

| Buchstabe | Möglicher Schaden |
|---|---|
| L | … |
| E | … |
| D | … |
| C | … |

**3.4** Crystal Clear ist Kategorie D6. Was heißt das – Teamgröße und Schadensart?

→

**3.5** Crystal Clear im Detail – fülle aus:

| Merkmal | Ausprägung |
|---|---|
| Teams / Orte | … |
| Rollen | … |
| Auslieferungsrhythmus | … |
| Fortschrittsmessung | … |
| Tests | … |
| Kundenreviews pro Release | … |
| Drei wichtigste Tools | … |

**3.6** Nenne fünf typische Produkte/Dokumente, die bei Crystal Clear entstehen:

→

## 4 Methodenauswahl klassisch gegen agil

*Hinweis: `agiles-software-engineering/04-methodenauswahl-und-fazit`*

**4.1** Die Klassifizierung der Fähigkeiten eines Entwicklungsteams:

| Ebene | Charakteristik |
|---|---|
| 3 | … |
| 2 | … |
| 1A | … |
| 1B | … |
| −1 | … |

**4.2** Was unterscheidet Ebene 2 von Ebene 3 genau?

→

**4.3** Die fünf Dimensionen der Methodenauswahl, je mit der Größe, die auf der Achse abgetragen wird (Klausur 2024 Aufgabe 1j, 6 Punkte – „nennen und erläutern Sie drei Dimensionen“):

| Dimension | Was wird gemessen? | agil, wenn … | klassisch, wenn … |
|---|---|---|---|
| … | … | … | … |
| … | … | … | … |
| … | … | … | … |
| … | … | … | … |
| … | … | … | … |

**4.4** Ein Projekt mit 300 Mitarbeitern, Kritikalität „Leben vieler“ und 1 % Anforderungsänderungen: agil oder klassisch? Begründe mit drei Dimensionen.

→

**4.5** Nenne vier Bedingungen, unter denen agile Softwareentwicklung ungeeignet ist (Klausur 2020 Aufgabe 1h):

→

**4.6** Fazit 3: Hype, Mode oder Zukunft? Begründe alle drei mit je einem Stichwort aus der Vorlesung.

| | Antwort | Begründung |
|---|---|---|
| Hype | … | … |
| Mode | … | … |
| Zukunft | … | … |

---

# Stufe 3 – Agile Begriffe

## 5 Epic und User Story

*Hinweis: `agiles-software-engineering/05-agile-begriffe`*

**5.1** Grenze Epic und User Story voneinander ab (BSDS #4, Frage 1):

| | Epic | User Story |
|---|---|---|
| Definition | … | … |
| Anwendung | … | … |
| Mitwirkende | … | … |
| In einem Sprint umsetzbar? | … | … |
| Schätzbarkeit | … | … |

**5.2** Die Satzschablone für eine User Story (BSDS-Dauerbrenner, Klausur 2024 Aufgabe 1h und 2025 Aufgabe 1a):

> Als … will ich … sodass/weil …

**5.3** Wie groß darf eine User Story maximal sein (Entwicklungsaufwand)?

→

**5.4** Schreibe für das Epic „Der Geldautomat erlaubt es einem Kunden 24x7 seine Geldtransaktionen mit unserer Bank abzuwickeln“ drei User Stories in der Schablone. Kläre vorher, was eine „Geldtransaktion“ ist.

- Geldtransaktion heißt hier: …
- US #1: …
- US #2: …
- US #3: …

**5.5** Wofür steht INVEST? Nenne jeden Buchstaben und erläutere ihn (Klausur 2024 Aufgabe 1d mit 6 P, Klausur 2024/WKL Aufgabe 1d mit 5 P, BSDS #4 Frage 5):

| Buchstabe | Begriff | Bedeutung |
|---|---|---|
| I | … | … |
| N | … | … |
| V | … | … |
| E | … | … |
| S | … | … |
| T | … | … |

**5.6** Welches INVEST-Kriterium verletzt diese User Story, und warum?

> Als Admin will ich ein Reporting, damit alles besser wird.

→

## 6 Definition of Done und Definition of Ready

*Hinweis: `agiles-software-engineering/06-definition-of-done-und-ready`*

**6.1** Die DoD ist eine Checkliste mit zwei Sichten. Welche, und was steht in jeder?

| Sicht | Inhalt |
|---|---|
| … | … |
| … | … |

**6.2** Wofür steht SMART bei den DoD-Kriterien?

| Buchstabe | Begriff | Bedeutung |
|---|---|---|
| S | … | … |
| M | … | … |
| A | … | … |
| R | … | … |
| T | … | … |

**6.3** Was ist die DoR, und worüber entscheidet sie genau (welches Backlog in welches)?

→

**6.4** Nenne sechs Beispielkriterien einer DoR:

→

**6.5** Erläutere DoD und DoR im Vergleich (Klausur 2024 Aufgabe 1i, Klausur 2025 Aufgabe 2c mit 6 P, BSDS #4 Frage 7):

| | DoD | DoR |
|---|---|---|
| Gegenstand | … | … |
| Zeitpunkt im Sprint | … | … |
| Frage, die sie beantwortet | … | … |

**6.6** Die neun Qualitätskriterien für Anforderungen nach IEEE 830-1998 und IREB:

| Kriterium | Worauf achten? |
|---|---|
| … | … |
| … | … |
| … | … |
| … | … |
| … | … |
| … | … |
| … | … |
| … | … |
| … | … |

**6.7** Welche sprachlichen Konstrukte machen eine Anforderung mehrdeutig? Nenne die vier Gruppen mit je einem Beispielwort.

→

**6.8** Vervollständige den Merksatz zur Prüfbarkeit:

> Solange man für eine Anforderung nicht genau weiß, wie man sie später abnehmen und testen wird, …

**6.9** Welches Kriterium steht für „Essenz“, und was heißt das?

→

## 7 Agile Fluency

*Hinweis: `agiles-software-engineering/07-agile-fluency-grundlagen`, `agiles-software-engineering/08-agile-fluency-zonen`*

**7.1** Warum ist Fluency keine Reife, und wo entsteht sie – beim Individuum oder im Team?

→

**7.2** Die vier Stufen der Reife innerhalb einer Zone, je mit dem Retrospektiven-Beispiel:

| Stufe | Was kann das Team? | Beispiel Retrospektive |
|---|---|---|
| 1 … | … | … |
| 2 … | … | … |
| 3 … | … | … |
| 4 … | … | … |

**7.3** Die vier Zonen des Agile-Fluency-Modells, je mit dem Kernthema und dem Schlagwort:

| Zone | Worum geht es? | Schlagwort |
|---|---|---|
| … | … | … |
| … | … | … |
| … | … | … |
| … | … | … |

**7.4** Focusing: welche drei Punkte gehören zu den agilen Grundlagen, und woran erkennt man ein Team, das hier routiniert ist?

→

**7.5** Delivering: vier Ziele der technischen Exzellenz, und welche zwei Investitionen nötig sind:

→

**7.6** Optimizing: drei Veränderungen in der Organisation, und welches skalierbare Modell hier relevant wird:

→

**7.7** Strengthening: worum geht es, und welcher experimentelle Managementansatz wird genannt? Was ist dieser Ansatz?

→

**7.8** Welche Kritik äußert die Vorlesung an den Methodengurus hinter solchen Modellen?

→

---

# Stufe 4 – Lücken: BSDS-Themen ohne Eintrag in `topics/`

Diese Fragen stehen in den BSDS-Sätzen und in den Altklausuren, ihre Antwort
steht aber **nicht** in `topics/`, weil die Vorlesungsfolien sie nicht enthalten.
Quelle ist jeweils die Literatur unter
`dski-sources-3/systems-engineering/origin/.../07 LE 4_ Agiles Software Engineering .../`.
Beantworte sie aus der dort liegenden Literatur und schreibe die Antwort hier hin.

## 8 Scrum, Skalierung, Spotify

**8.1** Nenne und erläutere die Komponenten von Scrum – Rollen, Artefakte, Ereignisse (Klausur 2021 Aufgabe 1d, 10 Punkte).
*Quelle: `Sutherland, J_ Scrum Handbook`*

| Kategorie | Elemente |
|---|---|
| Rollen | … |
| Artefakte | … |
| Ereignisse (Events) | … |

**8.2** Beschreibe die drei zentralen Rollen und ihre Verantwortlichkeiten (Klausur 2025 Aufgabe 2a, 9 Punkte):

| Rolle | Verantwortung | Was gehört *nicht* dazu? |
|---|---|---|
| Product Owner | … | … |
| Scrum Master | … | … |
| Entwicklungsteam | … | … |

**8.3** Was ist **keine** Aufgabe des Scrum Masters – die fachliche Leitung, die fachliche Unterstützung oder die fachliche Moderation des Teams? (Single-Choice in den Klausuren 2021, 2022; 2024 fragt: Moderation der Retrospektiven, Arbeitsplanung des Teams, Unterstützung bei Problemen)

→

**8.4** Was ist der Zweck der Sprint-Retrospektive, und wie trägt sie zur kontinuierlichen Verbesserung bei? (Klausur 2025 Aufgabe 2b)

→

**8.5** Ordne Sprint Review und Sprint Retrospektive der analytischen bzw. konstruktiven QS zu und begründe. Diese Frage steht wortgleich in BSDS #3 (Frage 5), BSDS #4 (Frage 2), als Single-Choice in Klausur 2024/WKL (Aufgabe 2i) und als 3-Punkte-Frage in Klausur 2024 (Aufgabe 1f).

- Sprint Review: … QS, weil …
- Sprint Retrospektive: … QS, weil …

(Die Definition von analytischer und konstruktiver QS steht in
`prozessmodelle/03-v-modell`. Überlege: Wird ein fertiges Produkt gemessen
oder wird der Prozess für die Zukunft gestaltet?)

**8.6** Grenze Product Owner, Area Product Owner und Scrum Master voneinander ab (BSDS #4 Frage 3; Klausur 2024 Aufgabe 1e fragt nur nach dem Area Product Owner).
*Quelle: `Large Scale Scrum (LeSS)`*

→

**8.7** Warum verwendet LeSS Huge Requirement Areas? (BSDS #4, Frage 4)
*Quelle: `Large Scale Scrum (LeSS)`*

→

**8.8** Erläutere den Begriff Agile Release Train (BSDS #4, Frage 6).
*Quelle: `Scaled Agile Framework (SAFe)_  Big Picture`, `Shore SAFe`*

→

**8.9** Erläutere das Spotify-Modell anhand von Tribe, Squad, Chapter und Guild (BSDS #4, Frage 8).
*Quelle: `Henrik Kniberg, Anders Ivarsson_ Scaling Agile @ Spotify with Tribes, Squads, Chapters & Guilds`*

| Begriff | Was ist das? | Wonach gruppiert? |
|---|---|---|
| Squad | … | … |
| Tribe | … | … |
| Chapter | … | … |
| Guild | … | … |

**8.10** Welche Rolle spielt das Projektmanagement bei Scrum – gar keine, hilft dem Team, oder führt die Gespräche mit dem Product Owner? (Single-Choice Klausur 2020, Aufgabe 2d)

→

---

# Nächste Schritte

- `03-modellierung.md` – LE 7, 8, 9: Use Cases, AD/BPMN, Entscheidungstabellen
- `04-klausursimulation.md` – 100 Punkte, 120 min, im Klausurformat

Originalfragen zu diesem Blatt:
`dski-sources-3/systems-engineering/origin-tasks/task-5` (BSDS #3),
`task-6` (BSDS #4, acht LE-4-Fragen) und `task-7` (BSDS-Fragen aus den Altklausuren).
Die Übungsaufgabe zu den User Stories steht in
`topics/agiles-software-engineering/05-agile-begriffe`, die Fallstudie dazu in
`origin-tasks/task-2`.
