# Systems Engineering – Altklausur-Themen zum Ausfüllen

Arbeitsblatt 5 von 5: die Themen, die in den Altklausuren regelmäßig gefragt
werden, deren Lerneinheit `ABOUT.md` aber als **nicht relevant** führt.

- **Stufe 1** – LE 5: Essenz, Ereignisse, Ereignisreaktionsmodelle
- **Stufe 2** – LE 10: Anforderungsarten, SOPHIST-Schablonen, Snowcard, Kano
- **Stufe 3** – Exkurs: Lastenheft, Pflichtenheft, Spezifikationsstandards
- **Stufe 4** – LE 1 und Literatur: FISCUS, CHAOS, Brook's Law, Requirements Creep

Hinweise zeigen auf `dski-sources-3/systems-engineering/topics/...`.
Leere Zeile nach `→` ist dein Platz. Tabellenzellen mit `…` füllst du aus.

## Warum es dieses Blatt gibt

`ABOUT.md` sagt: relevant sind LE 2, 3, 4, 7, 8, 9; nicht relevant sind LE 1, 5,
6, 10. Gleichzeitig sagt dieselbe Datei: relevant sind **alle** BSDS-Fragen.
Die Altklausuren fragen die unten stehenden Themen trotzdem – und zwar nicht
nebenbei:

| Klausur | Betroffene Aufgaben | Punkte |
|---|---|---|
| 2025 (WDSx24) | 1b Essenz (2), 1e Brook's Law (4), 1g FISCUS (4) | 10 von 100 |
| 2024 (WDSx23) | 1a essentielle Anforderung (4), 1b FISCUS (3), 1g Ereignisarten (2), 2 Kano (6), 3 Anforderungsarten (8) | 23 von 100 |
| 2024 WKL | 1a essentielle Anforderung (2), 2g Lastenheft (1) | 3 von 60 |
| 2022 | 1a essentielle Anforderung (4), 1b CHAOS (3), 2f Essenzbildung (1), 2g Lastenheft (1), 2h Ereignisart (1) | 10 von 60 |
| 2021 | 1b FISCUS (3), 2d Datenfluss (1), 2f Essenzbildung (1), 2g Lastenheft (1), 2h Ereignisart (1) | 7 von 60 |
| 2020 | 1a Essenz (2), 1b ERM (2), 1g Lastenheft (2), 2c FISCUS (1), 2f Ereignisart (1), 2j ERM (1) | 9 von 60 |

Arbeite dieses Blatt also **nach** den Blättern 01–04 durch, aber arbeite es
durch. Rechne nicht damit, dass die Themen diesmal ausfallen.

**Nicht enthalten: LE 6 (Erhebungstechniken).** Die habe ich geprüft – in keiner
der sechs Altklausuren und in keinem BSDS-Satz wird danach gefragt. „Erhebung“
taucht dort nur als Einleitungssatz der Fallstudien auf („Bei der
Anforderungserhebung haben Sie folgende Informationen erhalten…“). Falls du sie
trotzdem willst: der Stoff liegt vollständig in `topics/erhebungstechniken/`.

---

# Stufe 1 – LE 5: Essenzielle Modellierung

## 1 Essenz

*Hinweis: `essenzielle-modellierung/03-zeitliche-ereignisse`,
`essenzielle-modellierung/05-muster-fuer-ereignisreaktionsmodelle`*

**1.1** Erläutere den Begriff der Essenz (Klausur 2025 Aufgabe 1b, Klausur 2020 Aufgabe 1a):

→

**1.2** Was zeigt die essentielle Sicht, und was ist daran ausdrücklich uninteressant?

→

**1.3** Nimm das Beispiel „Kunde gibt Kauforder“ auseinander:

| | Im Ereignis enthalten |
|---|---|
| Funktionen | … |
| Daten | … |
| Wer braucht die Daten danach? | … |
| Was ist *nicht* essentiell? | … |

**1.4** Dein Auftraggeber sagt: „Die Kontaktaufnahme mit dem Kunden durch unseren First-Level-Support findet über Microsoft Teams statt.“ Ist diese Anforderung essentiell? Begründe. (Diese Frage steht wortgleich in den Klausuren 2022 Aufgabe 1a und 2024 Aufgabe 1a, je 4 Punkte.)

→

**1.5** Formuliere die Anforderung aus 1.4 so um, dass sie essentiell wird.

→

**1.6** Stimmt die Aussage: „Für die Essenzbildung müssen Ablaufreihenfolgen und Abhängigkeiten in den Tätigkeiten der Problemdomäne betrachtet werden, die keinen fachlichen Hintergrund haben“? Begründe. (Single-Choice Klausuren 2021 und 2022, Aufgabe 2f)

→

## 2 Ereignisse und Ereignisreaktion

*Hinweis: `essenzielle-modellierung/02-ereignisse-und-ereignisreaktion`,
`essenzielle-modellierung/03-zeitliche-ereignisse`*

**2.1** Wozu existieren Informationssysteme, und was ist ein Dienst in diesem Sinn?

→

**2.2** Nenne die Arten von Ereignissen, die im Requirements Engineering relevant sind (Klausur 2024 Aufgabe 1g, 2 Punkte; als Single-Choice in den Klausuren 2020 Aufgabe 2f, 2021 und 2022 Aufgabe 2h):

→

**2.3** Welche der folgenden sind **keine** Ereignisarten der Systemanalyse? Streiche durch und begründe: personelle Ereignisse, zeitliche Ereignisse, externe Ereignisse, echte Ereignisse.

→

**2.4** Die zwei Merksätze zum Datenfluss:

> Jedes Ereignis produziert …
>
> Durch den Inhalt des Datenflusses identifiziert das System, …

**2.5** Was ist eine Ereignisreaktion? Schreibe den Merksatz auf.

→

**2.6** Erläutere den Zweck eines Ereignisreaktionsmodells (Klausur 2020 Aufgabe 1b):

→

**2.7** Wovon wird die Reaktion des Systems in einem ERM immer eingegrenzt? (Merksatz)

→

**2.8** Wodurch werden zeitliche Ereignisse ausgelöst, und wann endet ein solches Ereignis?

→

**2.9** Trage das Börsenbeispiel ein:

| | Inhalt |
|---|---|
| Auslöser | … |
| Zeitliches Ereignis | … |
| Reaktion | … |

**2.10** Welche Aussage zum auslösenden Datenfluss einer Ereignisreaktion ist **falsch**? Begründe. (Single-Choice Klausuren 2021 und 2022, Aufgabe 2d)

- A. Das Nachbarsystem, das ein Ereignis auslöst, muss auch immer dasjenige sein, das die Reaktion erhält
- B. Jedes auslösende externe Ereignis erzeugt einen eindeutigen Datenfluss in das System
- C. Datenspeicher sind immer systemintern und stellen keine Nachbarsysteme dar

→

**2.11** Modelliert man Ereignisreaktionsmodelle immer oder nur bei Bedarf? (Single-Choice Klausur 2020, Aufgabe 2j)

→

## 3 Namensregeln und Ereignisliste

*Hinweis: `essenzielle-modellierung/04-namensregeln-und-ereignisliste`*

**3.1** Die zwei Namensregeln:

- Externer Ereignisname = … + …
- Zeitlicher Ereignisname = … + …

**3.2** Benenne jedes Ereignis regelkonform:

| Sachverhalt | Ereignisname |
|---|---|
| Ein Kunde erteilt einen Kaufauftrag für Aktien | … |
| Am Ende des Börsentages werden offene Ordern gelöscht | … |
| Ein Lieferant meldet eine Lieferverzögerung | … |
| Jeden Monatsersten werden die Mahnungen erzeugt | … |

**3.3** Wozu dient die Ereignisliste, und welche zwei Spalten hat sie?

→

**3.4** Fülle die Ereignisliste aus dem Börsenbeispiel aus. Markiere jeden Datenfluss mit (I) oder (O).

| Ereignisname | Zugehörige Datenflüsse |
|---|---|
| … | … |
| … | … |

**3.5** Was bedeuten (I) und (O)?

→

**3.6** Der Merksatz zum Zusammenhang von Ereignisliste und ERM lautet: Zu jedem … Ereignis aus der Ereignisreaktionsliste wird …

**3.7** Was heißt in diesem Merksatz „nicht-trivial“ – wann lohnt sich also kein eigenes ERM?

→

## 4 Muster und Datenmodell

*Hinweis: `essenzielle-modellierung/05-muster-fuer-ereignisreaktionsmodelle`,
`essenzielle-modellierung/06-exkurs-datenmodell`*

**4.1** Zeichne das Muster für ein **externes** Ereignis. Welche Elemente kommen vor und in welcher Reihenfolge?

→

**4.2** Zeichne das Muster für ein **zeitliches** Ereignis. Worin unterscheidet es sich vom externen?

→

**4.3** Woher kommen die Entitäten bzw. Klassen für das Datenmodell, wenn du von den Ereignisreaktionsmodellen ausgehst?

→

---

# Stufe 2 – LE 10: Anforderungen formulieren

## 5 Anforderungsarten

*Hinweis: `anforderungen-formulieren/01-einordnung-und-anforderungsarten`*

**5.1** Erläutere die Arten von Anforderungen und nenne jeweils ein Beispiel (Klausur 2024 Aufgabe 3, 8 Punkte):

| Art | Kürzel | Was beschreibt sie? | Beispiel |
|---|---|---|---|
| … | … | … | … |
| … | … | … | … |
| … | … | … | … |

**5.2** Zu welcher Oberkategorie gehören die Randbedingungen?

→

**5.3** Was sind Qualitätsanforderungen, und zu welcher Art zählen sie?

→

**5.4** Ordne zu – FANF, NFANF oder RANF?

| Anforderung | Art |
|---|---|
| Das System muss die Kundenstammdaten auf Plausibilität prüfen | … |
| Die Plausibilitätsprüfung muss nach maximal 5 Sekunden abgeschlossen sein | … |
| Das System muss auf der bestehenden IT-Infrastruktur lauffähig sein | … |
| Die Bildschirmmasken müssen EN ISO 9241 entsprechen | … |
| Die SW-Lösung darf nicht mehr als 50.000 EUR kosten | … |
| Das System muss dem Sachbearbeiter ermöglichen, einen Auftrag anzulegen | … |

## 6 SOPHIST-Schablonen und Schlüsselwörter

*Hinweis: `anforderungen-formulieren/02-schablonen-und-schluesselwoerter`*

**6.1** Die drei Typen der SOPHIST-Normsprache:

| Typ | Name | Wann anwenden? |
|---|---|---|
| 1 | … | … |
| 2 | … | … |
| 3 | … | … |

**6.2** Schreibe die Satzschablone für jeden Typ auf.

→

**6.3** Die drei Schlüsselwörter und ihre Rechtsverbindlichkeit:

| Schlüsselwort | Englisch | Verbindlichkeit | Folge bei Nichterfüllung |
|---|---|---|---|
| … | … | … | … |
| … | … | … | … |
| … | … | … | … |

**6.4** Welcher Typ liegt hier jeweils vor? (Übung aus der Vorlesung)

| Aussage | Typ |
|---|---|
| Der Kunde will, dass das System Deutsch, Englisch und Chinesisch als Benutzersprache unterstützt | … |
| Der Kunde möchte, dass das System auch beliebige Sprachen in der Zukunft unterstützen kann | … |
| Das System muss nicht mandantenfähig sein, soll diese Fähigkeit aber zukünftig nicht unmöglich machen | … |

**6.5** Welches Schlüsselwort gehört in jeden der drei Sätze aus 6.4?

→

## 7 Vom Use Case zur Anforderung

*Hinweis: `anforderungen-formulieren/03-beispiele-anforderungsermittlung`*

**7.1** Nimm Aktivität 1 aus UC #001 Neukunde erfassen („Der Kundensachbearbeiter validiert die Kundenstammdaten…“) und leite daraus drei funktionale Anforderungen ab. Nummeriere sie und verweise auf die ET.

- FANF #001: …
- FANF #002: …
- FANF #003: …

**7.2** Warum erzeugt eine einzige UC-Aktivität mehrere Anforderungssätze? Was ist also eine *atomare* Anforderung?

→

**7.3** Wie verweisen Anforderungen aufeinander? Schau dir FANF #004 bis #006 an und beschreibe das Muster.

→

**7.4** Übertrage deinen Use Case „PUC #001 Lastenrad ausleihen“ aus `03-modellierung.md` in präzise, überprüfbare Anforderungssätze nach der SOPHIST-Satzschablone (Arbeitsauftrag #04 der AIM-Fallstudie).

→

## 8 Snowcard-Schablone

*Hinweis: `anforderungen-formulieren/04-snowcard-schablone`*

**8.1** Die Felder der Snowcard-Schablone:

| Feld | Inhalt |
|---|---|
| ANF # | … |
| ANF-Typ | … |
| UC # | … |
| Definition | … |
| Grund | … |
| Quelle | … |
| Abnahme-Kriterium | … |
| Kundenzufriedenheit | … |
| Kundenunzufriedenheit | … |
| Priorität | … |
| Zusatzmaterial | … |
| Änderungshistorie | … |

**8.2** Welche Skalen gelten für Kundenzufriedenheit und Kundenunzufriedenheit, und was bedeuten die Endpunkte?

→

**8.3** Wie viele Sätze soll das Feld „Definition“ im Regelfall enthalten?

→

**8.4** Für wie viele Anforderungen wird die Schablone ausgefüllt?

→

**8.5** Fülle eine Snowcard für eine selbst formulierte FANF aus deinem Lastenrad-UC aus.

→

## 9 Kano-Modell

*Hinweis: `anforderungen-formulieren/05-kano-modell`*

**9.1** Welche Bedeutung hat das Kano-Modell für die Priorisierung von Anforderungen, und wie werden Basis-, Leistungs- und Begeisterungsfaktoren voneinander unterschieden? (Klausur 2024 Aufgabe 2, 6 Punkte)

| Faktor | Definition | Wirkung auf die Zufriedenheit | Ist dem Kunden bewusst? |
|---|---|---|---|
| Basisfaktor | … | … | … |
| Leistungsfaktor | … | … | … |
| Begeisterungsfaktor | … | … | … |

**9.2** Die vier Schritte des Kano-Ablaufs:

1. …
2. …
3. …
4. …

**9.3** Was ist eine funktionale, was eine dysfunktionale Frage im Kano-Fragebogen?

→

**9.4** Die sechs Merkmalsklassen der Auswertung:

| Kürzel | Englisch | Deutsch |
|---|---|---|
| A | … | … |
| I | … | … |
| O | … | … |
| M | … | … |
| Q | … | … |
| R | … | … |

**9.5** Welches Feld der Snowcard wird durch den Kano-Index ersetzt bzw. ergänzt?

→

**9.6** Ordne ein – Basis-, Leistungs- oder Begeisterungsfaktor?

| Merkmal eines Geldautomaten | Faktor |
|---|---|
| Die Auszahlung funktioniert | … |
| Die Auszahlung dauert nur 5 statt 20 Sekunden | … |
| Der Automat begrüßt den Kunden mit Namen und seiner Lieblingsstückelung | … |
| Die PIN-Eingabe ist vor Blicken geschützt | … |

**9.7** Warum altern Begeisterungsfaktoren mit der Zeit zu Basisfaktoren? Erkläre an einem Beispiel.

→

---

# Stufe 3 – Exkurs: Spezifikationsvorlagen

## 10 Lastenheft und Pflichtenheft

*Hinweis: `spezifikationsvorlagen/01-einordnung-und-spezifikationsdokumente`*

**10.1** Grenze die beiden Dokumente ab:

| | Lastenheft | Pflichtenheft |
|---|---|---|
| Inhalt | … | … |
| Aus wessen Sicht? | … | … |
| Wozu kann es dienen? | … | … |
| Zeitpunkt im Projekt | … | … |

**10.2** Nenne die Aufgaben eines Lastenhefts (Klausur 2020 Aufgabe 1g, 2 Punkte):

→

**10.3** Was ist die korrekte Definition eines Lastenhefts – „WAS und WOFÜR zu lösen ist“ oder „WAS WIE zu lösen ist“? Begründe. (Single-Choice in den Klausuren 2021, 2022 und 2024/WKL, jeweils Aufgabe 2g)

→

**10.4** Welches der beiden Dokumente beschreibt Benutzeranforderungen, welches Systemanforderungen?

→

## 11 Standards und Aufbau

*Hinweis: `spezifikationsvorlagen/02-standards-als-vorlagen`,
`spezifikationsvorlagen/03-aufbau-eines-pflichtenhefts`*

**11.1** Welche zwei bedeutenden Standards dienen als Vorlage für Spezifikationsdokumente?

→

**11.2** Die Kapitel eines Pflichtenhefts nach IEEE/ANSI 830-1998, in der richtigen Reihenfolge:

| # | Kapitel | Was steht darin? |
|---|---|---|
| 1 | … | … |
| 2 | … | … |
| 3 | … | … |
| 4 | … | … |
| 5 | … | … |
| 6 | … | … |
| 7 | … | … |
| 8 | … | … |
| 9 | … | … |
| 10 | … | … |
| 11 | … | … |

**11.3** In welchem Kapitel landen deine Product Use Cases, in welchem die Anforderungssätze, in welchem das ERM?

→

**11.4** Warum darf das Kapitel „Begriffe“ kein Fachwissen beim Leser voraussetzen?

→

**11.5** Welche Angaben gehören auf das Deckblatt?

→

---

# Stufe 4 – LE 1 und Literatur

Die folgenden Themen stehen **nicht** in den Vorlesungsfolien unter `topics/`.
Sie sind Rechercheaufgaben: die Quelle steht jeweils dabei. Trage deine Antwort
hier ein, dann hast du sie beim nächsten Durchgang parat.

## 12 Black Swans und Studien

*Hinweis: `black-swans/01-begriff-und-beispiel`, `black-swans/03-empirische-studie`,
`black-swans/04-chaos-studie`*

**12.1** Die drei Charakteristika eines Black-Swan-Ereignisses nach Taleb:

→

**12.2** Fasse den Fall Levi Strauss in fünf Sätzen zusammen: Ausgangslage, Ziel des Projekts, was schiefging, Schaden, Konsequenz.

→

**12.3** Capers Jones' empirische Studie: Wie viele Projekte, welcher Zeitraum, welches Ziel?

→

**12.4** Trage die Umrechnungsfaktoren Function Point zu LOC ein:

| Sprache | 1 FP ≈ … LOC |
|---|---|
| Java/C++ | … |
| C | … |
| VB | … |

**12.5** Wie lang ist die durchschnittliche Lebensdauer einer Programmiersprache?

→

**12.6** Nenne die drei Hauptpunkte für das Scheitern von Projekten in der CHAOS-Studie (Klausur 2022 Aufgabe 1b, 3 Punkte).
*Quelle: Wikipedia-Eintrag zur CHAOS-Studie, siehe `black-swans/04-chaos-studie`*

→

**12.7** Wie hoch ist laut CHAOS-Studie der Anteil der Projekte, die zumindest teilweise nicht erfolgreich waren? Wie lautet die Kritik an der Studie?

→

## 13 FISCUS

*Quelle: `origin/.../04 LE 1_ Black Swans .../Peter Mertens_ Fehlschläge bei IT-Großprojekten
der Öffentlichen Verwaltung .../01_Mertens.Fehlschlaege.pdf`; Arbeitsauftrag in
`origin-tasks/task-1`*

**13.1** Was war FISCUS – Auftraggeber, Ziel, Zeitraum, Ausgang?

→

**13.2** Nenne und erläutere zwei Gründe für das Scheitern von FISCUS (Klausur 2024 Aufgabe 1b, 3 Punkte; Single-Choice Klausur 2020 Aufgabe 2c):

→

**13.3** Nenne und erläutere die Gründe für das Scheitern von FISCUS **im zweiten Anlauf** (Klausur 2025 Aufgabe 1g mit 4 Punkten, Klausur 2021 Aufgabe 1b mit 3 Punkten). Achte darauf: gefragt ist der zweite Anlauf, nicht der erste.

→

**13.4** Was war laut der Single-Choice-Frage von 2020 **kein** Grund für das Scheitern von FISCUS – Personalmangel, Überforderung der Objektorientierung oder Projektmanagementfehler?

→

**13.5** Welche Gemeinsamkeiten erkennst du zwischen den Fehlschlägen bei Mertens? Verbinde sie mit den Top-Ten-Risiken aus `01-grundlagen.md`, Abschnitt 6.

→

## 14 Brook's Law und Requirements Creep

**14.1** Nenne und erläutere Brook's Law (Klausur 2025 Aufgabe 1e, 4 Punkte).
*In `topics/` wird es nur beiläufig erwähnt:
`agiles-software-engineering/01-schwergewichtig-und-leichtgewichtig`
(„dabei Brooks Law noch gar nicht berücksichtigt!“). Quelle:
`origin/.../05 LE 2_ Softwaretechnik .../Interview mit Fred Brooks zum Thema
„Erhebung effektiver Anforderungen im großen Zusammenhang“`*

- Der Satz: …
- Die Begründung dahinter: …
- Was folgt daraus für die Projektplanung: …

**14.2** Warum macht Brook's Law die Space-Shuttle-Rechnung aus `02-agil.md`, Aufgabe 1.3, noch schlimmer als dort gerechnet?

→

**14.3** Erläutere, was man unter Requirements Creep versteht (BSDS #3, Frage 8).
*Verwandt: der „Anteil nachgebesserter Anforderungen“ in `black-swans/03-empirische-studie`;
siehe auch Risiko 6 „Kontinuierliche Anforderungsänderungen“ in
`prozessmodelle/01-risiken-und-grundlagen`*

→

**14.4** Welche Gegenmaßnahmen gegen Requirements Creep kennst du aus den Top-Ten-Risiken? Nenne zwei und erkläre, wie sie wirken.

→

**14.5** Wie geht agiles Vorgehen mit Requirements Creep um – und widerspricht das nicht Risiko 6? Begründe mit den agilen Prinzipien 2 und 3.

→

---

# Nächste Schritte

Wenn dieses Blatt sitzt, ist der komplette Fragenpool der sechs Altklausuren
abgedeckt. Dann noch einmal `04-klausursimulation.md` unter Zeitdruck.

Originalquellen zu diesem Blatt:

- `dski-sources-3/systems-engineering/origin-tasks/task-1` – Arbeitsauftrag #1
  (Mertens-Studie, gescheiterte Großprojekte)
- `dski-sources-3/systems-engineering/origin-tasks/task-2` – AIM-Fallstudie,
  Arbeitsauftrag #04: Anforderungssätze nach SOPHIST-Satzschablone
- `dski-sources-3/systems-engineering/origin-tasks/task-5` – BSDS #3, Frage 8
  (Requirements Creep)
- `dski-sources-3/systems-engineering/origin-exams/exam-5-2024` – Kano (Aufgabe 2)
  und Anforderungsarten (Aufgabe 3) als Originalaufgaben
