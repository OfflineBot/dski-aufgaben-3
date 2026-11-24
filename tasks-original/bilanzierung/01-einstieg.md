# Bilanzierung – Blatt 01: Einstieg

Kein Test. Jede Station zeigt ein Thema der Vorlesung: kurze Erklärung, ein
vorgerechnetes Beispiel, dann machst du es einmal selbst. Die Aufgaben sind auf dem
Niveau der Übungsblätter, mit eigenen Zahlen. Deine Lösung kommt in den leeren Block.

- Teil A: den Jahresabschluss erstellen (Station 1 bis 10)
- Teil B: den Jahresabschluss analysieren (Station 11 bis 14)
- Teil C: Pflichten und Funktionen (Station 15 und 16)
- Zum Schluss: alle Formeln aus dem Kopf (Station 17)

Zum Nachlesen: `dski-sources-3/bilanzierung/topics/`. Bei jeder Station steht der Ordner.

Laut `ABOUT.md` kommen in der Klausur Varianten der Übungsaufgaben und die Theorie
dahinter: warum rechne ich das, was bedeutet das Ergebnis. Alle Formeln müssen sitzen.

---

# Teil A - Den Jahresabschluss erstellen

## 1 - Die Bilanz lesen

*Nachlesen: `jahresabschlusserstellung/01-bilanz-grundlagen`*

**Erklärung**

- Rechte Seite, **Passiva**: Woher kommt das Geld?
  - Eigenkapital: von den Eigentümern, bleibt dauerhaft
  - Rückstellungen: Schulden, die wahrscheinlich, aber noch unsicher sind
  - Verbindlichkeiten: sichere Schulden
- Linke Seite, **Aktiva**: Wofür wurde es verwendet?
  - Anlagevermögen: bleibt lange im Unternehmen (Maschinen, Patente)
  - Umlaufvermögen: wird schnell umgeschlagen (Vorräte, Forderungen, Kasse)
- Beide Seiten sind immer gleich groß.

**Beispiel**

- Zwei Gründer legen 50.000 € ein, das Geld liegt auf dem Konto.
- Aktiva: Kasse 50.000 (Umlaufvermögen)
- Passiva: Gezeichnetes Kapital 50.000 (Eigenkapital)

**Deine Umsetzung**

*Aufgabe*: Ordne jede Position ein. Erst Aktiva oder Passiva, dann die Gruppe (Anlagevermögen, Umlaufvermögen, Eigenkapital, Rückstellung, Verbindlichkeit). Lieferwagen · Bankkredit · Kasse · gekauftes Patent · Rohstoffe im Lager · Rechnung, die ein Kunde uns noch zahlen muss · gezeichnetes Kapital · geschätzte Steuerschuld · Rechnung eines Lieferanten, die wir noch zahlen müssen

```

```

## 2 - Eigenkapital: Aktien ausgeben

*Nachlesen: `jahresabschlusserstellung/02-abbildung-von-finanzierungen`*

**Erklärung**

- Jede Aktie hat einen Nennwert. Verkauft wird sie oft teurer, zum Ausgabepreis.
- Gezeichnetes Kapital = Anzahl × Nennwert
- Kapitalrücklage = Anzahl × (Ausgabepreis − Nennwert). Der Aufschlag heißt Agio.
- Die Kasse steigt um Anzahl × Ausgabepreis.
- Weitere Arten von Eigenkapital: Gewinnrücklage (angesammelte, nicht ausgeschüttete Gewinne), Gewinnvortrag (Rest, der ins nächste Jahr mitgenommen wird), Jahresüberschuss (Gewinn des laufenden Jahres).
- Merkmale von Eigenkapital: trägt das Risiko, ist unbefristet, hat Anspruch auf den Gewinn, hat Mitbestimmung.

**Beispiel**

- 1.000 Aktien, Nennwert 2 €, Ausgabepreis 9 €
- Kasse + 9.000
- Gezeichnetes Kapital + 2.000
- Kapitalrücklage + 7.000

**Deine Umsetzung**

*Aufgabe*: Eine AG gibt 20.000 Aktien aus. Nennwert 1 €, Ausgabepreis 6 €. a) Wie hoch sind gezeichnetes Kapital und Kapitalrücklage? b) Um wie viel steigt die Kasse? c) Nenne zwei Merkmale von Eigenkapital und erkläre sie in je einem Satz. d) Nenne drei Arten von Eigenkapital und sag, worin sie sich unterscheiden.

```

```

## 3 - Fremdkapital: Verbindlichkeit oder Rückstellung

*Nachlesen: `jahresabschlusserstellung/02-abbildung-von-finanzierungen`*

**Erklärung**

- **Verbindlichkeit**: Die Schuld ist sicher, also ob, wie hoch und wann.
- **Rückstellung**: Die Schuld ist unsicher, aber wahrscheinlich (über 30 %).
- Unter 30 %: keine Buchung, nur eine Beschreibung im Anhang (Eventualverbindlichkeit).
- Ein bloßer Plan für die Zukunft ist noch gar keine Schuld.
- Arten von Verbindlichkeiten: gegenüber Kreditinstituten (Kredit), erhaltene Anzahlungen (Kunde hat gezahlt, wir haben noch nicht geliefert), aus Lieferung und Leistung (Ware erhalten, noch nicht bezahlt), sonstige (etwa gegenüber Mitarbeitern oder dem Finanzamt).
- Merkmale von Fremdkapital: muss zurückgezahlt werden, ist zeitlich begrenzt, hat keine Mitbestimmung, kostet Zinsen.

**Beispiel**

- Kredit über 100.000 € aufgenommen → Verbindlichkeit gegenüber Kreditinstituten
- Kunde klagt auf 80.000 €, der Anwalt rechnet zu 70 % mit einer Niederlage → Rückstellung 80.000

**Deine Umsetzung**

*Aufgabe*: Entscheide für jeden Fall: Verbindlichkeit, Rückstellung, nur Anhang oder gar nichts? Begründe in einem Satz. a) Ein Lieferant hat Rohstoffe für 8.000 € geliefert, die Rechnung ist in 30 Tagen fällig. b) Eine Steuerprüfung läuft. Der Steuerberater rechnet mit 60 % Wahrscheinlichkeit mit einer Nachzahlung von 12.000 €. c) Ein Kunde droht mit einer Klage über 50.000 €. Die Anwälte sehen eine Chance von 10 %, dass er gewinnt. d) Die Geschäftsführung beschließt, im nächsten Jahr eine Halle für 200.000 € zu bauen und dafür einen Kredit aufzunehmen. e) Nenne zwei Merkmale von Fremdkapital und drei Arten von Verbindlichkeiten.

```

```

## 4 - Anschaffungskosten berechnen

*Nachlesen: `jahresabschlusserstellung/03-abbildung-von-investitionen`*

**Erklärung**

- Ein gekaufter Gegenstand steht mit seinen Anschaffungskosten in der Bilanz.
- Rechnung: Kaufpreis − Rabatte + Nebenkosten + nachträgliche Anschaffungskosten
- Nebenkosten zählen, wenn sie nötig sind, um den Gegenstand zu bekommen und betriebsbereit zu machen (Transport, Montage).
- Nachträgliche Anschaffungskosten sind spätere Erweiterungen.
- Nicht dazu gehören: Zinsen für die Finanzierung, laufende Kosten wie Wartung oder Reinigung, Kosten für andere Gegenstände.

**Beispiel**

- Maschine: Kaufpreis 80.000, Rabatt 5.000, Transport 4.000, Montage 3.000, Kreditzinsen 1.500
- 80.000 − 5.000 + 4.000 + 3.000 = 82.000
- Die Zinsen bleiben draußen.

**Deine Umsetzung**

*Aufgabe*: Ein Getränkehersteller kauft eine Abfüllanlage. Bestimme die Anschaffungskosten und sag zu jeder Position, warum sie dazugehört oder nicht. Kaufpreis 120.000 · Rabatt des Verkäufers 10.000 · Transport zum Werk 4.000 · Fundament und Montage 6.000 · jährliche Wartung 3.000 · Zinsen für den Kredit 2.000 · später angebauter Roboterarm 15.000

```

```

## 5 - Vorräte bewerten

*Nachlesen: `jahresabschlusserstellung/03-abbildung-von-investitionen`*

**Erklärung**

- Am Bilanzstichtag vergleichst du: Wert in den Büchern gegen aktuellen Marktwert.
- Marktwert **niedriger**: Du musst auf den niedrigeren Wert abschreiben. Das ist das strenge Niederstwertprinzip. Es gilt bei Vorräten immer, auch wenn der Preis nur kurz gefallen ist.
- Marktwert **höher**: Es bleibt beim alten Wert. Das ist das Anschaffungskostenprinzip. Ein Gewinn zählt erst, wenn wirklich verkauft wurde.

**Beispiel**

- 100 Tonnen zu 30 € gekauft, Buchwert 3.000
- Stichtag, Preis 25 € → Wert 2.500, Abschreibung 500
- Stichtag, Preis 35 € → Wert bleibt 3.000

**Deine Umsetzung**

*Aufgabe*: Eine Schokoladenfabrik hat 2.000 kg Kakao zu 4 € pro kg gekauft, also für 8.000 €. Mit welchem Wert steht der Kakao am Stichtag in der Bilanz, und welches Prinzip steckt dahinter? a) Der Marktpreis ist auf 3 € gefallen. b) Der Marktpreis ist auf 5 € gestiegen. c) Der Kakao ist feucht geworden und nur noch 1 € pro kg wert.

```

```

## 6 - Abschreibungen

*Nachlesen: `jahresabschlusserstellung/04-guv-und-aufwendungen`*

**Erklärung**

- Eine Maschine verliert jedes Jahr an Wert. Dieser Wertverlust ist Aufwand.
- **Linear**: jedes Jahr gleich viel. (Kaufpreis − Restwert) / Nutzungsdauer
- **Geometrisch-degressiv**: am Anfang viel, dann immer weniger. Im ersten Jahr Kaufpreis × Satz, danach jeweils der verbliebene Wert × Satz.
- Gebucht wird an zwei Stellen: Sachanlagen sinken, in der GuV steht Aufwand „Abschreibungen“.
- Es fließt dabei kein Geld.

**Beispiel**

- Maschine 50.000, Restwert 10.000, Nutzungsdauer 5 Jahre
- Linear: (50.000 − 10.000) / 5 = 8.000 pro Jahr
- Degressiv mit 20 %: Jahr 1 sind 10.000, es bleiben 40.000. Jahr 2 sind 8.000.

**Deine Umsetzung**

*Aufgabe*: Ein Lieferwagen kostet 60.000 €. Nutzungsdauer 6 Jahre, Restwert am Ende 6.000 €. Der Satz für die degressive Abschreibung ist 30 %. a) Wie hoch ist die lineare Abschreibung pro Jahr? b) Wie hoch ist die degressive Abschreibung im ersten und im zweiten Jahr? c) Mit welchem Wert steht der Wagen nach zwei Jahren in der Bilanz, einmal linear, einmal degressiv?

```

```

## 7 - Umsatz: wann ist er entstanden

*Nachlesen: `jahresabschlusserstellung/05-ertraege`*

**Erklärung**

- Ein unterschriebener Vertrag allein wird nicht gebucht. Das ist ein schwebendes Geschäft.
- Umsatz entsteht erst, wenn **geliefert** wurde. Das ist das Realisationsprinzip.
- Geliefert, noch nicht bezahlt: Forderung + und Umsatzerlöse +
- Geliefert und bezahlt: Kasse + und Umsatzerlöse +
- Bezahlt, aber noch nicht geliefert: Kasse + und „Erhaltene Anzahlungen“ +. Das ist eine Schuld, kein Umsatz.

**Beispiel**

- Ein Fahrradhändler verkauft ein Rad für 500 €.
- Rad übergeben, Kunde zahlt nächsten Monat: Forderungen + 500, Umsatzerlöse + 500. Als Buchungssatz: Forderungen an Umsatzerlöse 500.
- Kunde zahlt heute, Rad kommt erst in zwei Wochen: Kasse + 500, Erhaltene Anzahlungen + 500. Kein Umsatz.

**Deine Umsetzung**

*Aufgabe*: Eine Schreinerei hat mit vier Kunden je einen Vertrag über 200 Stühle zu 40 € geschlossen, also 8.000 € pro Kunde. Sag für jeden Kunden, ob Umsatz entstanden ist und welche zwei Positionen sich ändern. Wie hoch sind die Umsatzerlöse insgesamt? a) Kunde 1: nicht geliefert, nicht bezahlt. b) Kunde 2: geliefert, nicht bezahlt. c) Kunde 3: bezahlt, nicht geliefert. d) Kunde 4: geliefert und bezahlt.

```

```

## 8 - Rückstellungen bilden

*Nachlesen: `jahresabschlusserstellung/06-rueckstellungen`*

**Erklärung**

- Über 30 % wahrscheinlich: Rückstellung in voller Höhe. Sie steht rechts in der Bilanz, und derselbe Betrag ist Aufwand im aktuellen Jahr.
- Welcher Aufwand: bei einer Klage sonstiger betrieblicher Aufwand, bei Steuern Steueraufwand, bei Pensionen Personalaufwand.
- Unter 30 %: keine Rückstellung, nur Anhang.
- Sonderfall drohender Verlust: Du hast einen Verkauf fest zugesagt, und die Herstellung kostet inzwischen mehr als der vereinbarte Preis. Dann bildest du eine Rückstellung in Höhe des Verlusts. Dieser Fall kommt im Übungsblatt 2 vor, in den Folien steht er nicht.

**Beispiel**

- Klage über 80.000 €, Niederlage zu 70 % wahrscheinlich: Sonstige Rückstellungen + 80.000, sonstiger betrieblicher Aufwand 80.000
- Zugesagt: 200 Stück zu 10 €. Herstellkosten jetzt 12 €. Verlust 2 € × 200 = 400 → Rückstellung 400
- Herstellkosten 8 €: kein Verlust, keine Rückstellung

**Deine Umsetzung**

*Aufgabe*: Entscheide jeweils, ob eine Rückstellung zu bilden ist und in welcher Höhe. a) Ein Kunde verklagt eine Bäckerei auf 60.000 € Schadensersatz. Die Anwälte rechnen zu 75 % mit einer Niederlage. b) Ein zweiter Kunde klagt auf 40.000 €. Die Anwälte sehen eine Chance von 15 %, dass er gewinnt. c) Die Bäckerei hat zugesagt, im nächsten Jahr 500 Torten zu je 20 € zu liefern. Am 30.12. steigen die Herstellkosten auf 23 € pro Torte. d) Wie c), aber die Herstellkosten steigen nur auf 18 €.

```

```

## 9 - Cash Flow: fließt Geld, und welche Art

*Nachlesen: `jahresabschlusserstellung/07-kapitalflussrechnung`*

**Erklärung**

- Cash Flow heißt: Geld kommt wirklich herein oder geht wirklich hinaus.
- **Operativ**: das laufende Geschäft (Verkäufe, Gehälter, Miete, Rohstoffe)
- **Investition**: Kauf oder Verkauf von Anlagevermögen (Maschinen, Fahrzeuge, Patente)
- **Finanzierung**: Geld von Eigentümern oder Banken und zurück (Einlagen, Kredit, Tilgung, Dividende)
- Kein Cash Flow: Abschreibungen, Rückstellungen, Kauf und Verkauf „auf Ziel“

**Beispiel**

- Kredit über 20.000 aufgenommen → Finanzierung, + 20.000
- Maschine für 15.000 bar gekauft → Investition, − 15.000
- Gehälter 8.000 überwiesen → operativ, − 8.000
- Maschine um 3.000 abgeschrieben → kein Cash Flow

**Deine Umsetzung**

*Aufgabe*: Sag für jeden Vorfall, ob Geld fließt, in welche Richtung und welche Art von Cash Flow es ist. Rechne am Ende die drei Arten und die Summe aus. 1) Die Gesellschafter zahlen 80.000 € ein. 2) Ein Lieferwagen wird für 30.000 € bar gekauft. 3) Waren für 45.000 € werden bar verkauft. 4) Waren für 20.000 € werden auf Ziel verkauft. 5) 6.000 € Miete werden überwiesen. 6) Der Lieferwagen wird um 5.000 € abgeschrieben. 7) 10.000 € eines Kredits werden getilgt. 8) Rohstoffe für 12.000 € werden bar gekauft.

```

```

## 10 - Geschäftsvorfälle eintragen und den Jahresüberschuss bestimmen

*Nachlesen: `jahresabschlusserstellung/`, alle Unterordner. Das ist der Aufgabentyp aus Übungsblatt 2, Kapitel 9.*

**Erklärung**

- Jeder Vorfall ändert **zwei** Positionen.
- Trifft er nur die Bilanz, ändert sich der Gewinn nicht (Kredit, Kauf einer Maschine).
- Trifft er die GuV, ändert sich der Gewinn (Verkauf, Gehalt, Abschreibung, Rückstellung).
- Jahresüberschuss = Erträge − Aufwendungen. Er steht rechts im Eigenkapital. Deshalb geht die Bilanz am Ende wieder auf.

**Beispiel**

- Gründung mit 30.000: Kasse + 30.000, Gezeichnetes Kapital + 30.000
- Barverkauf 10.000: Kasse + 10.000, Umsatzerlöse 10.000
- Miete 4.000 überwiesen: Kasse − 4.000, sonstiger betrieblicher Aufwand 4.000
- Jahresüberschuss: 10.000 − 4.000 = 6.000
- Aktiva: Kasse 36.000. Passiva: Gezeichnetes Kapital 30.000 + Jahresüberschuss 6.000 = 36.000.

**Deine Umsetzung**

*Aufgabe*: Ein Unternehmen hat im ersten Jahr diese elf Vorfälle. Schreib zu jedem die zwei Positionen mit Plus oder Minus. Bestimme danach a) den Jahresüberschuss, b) den Kassenbestand, c) die Bilanzsumme. Kontrolle: Aktiva und Passiva müssen gleich sein. 1) Gründung durch Einlage von 60.000 €. 2) Bankkredit über 40.000 €. 3) Kauf einer Maschine für 50.000 € in bar. 4) Kauf von Rohstoffen für 10.000 € auf Ziel. 5) Rohstoffe für 6.000 € werden in der Produktion verbraucht. 6) Gehälter von 20.000 € werden überwiesen. 7) Verkauf von Waren für 45.000 € in bar. 8) Verkauf von Waren für 15.000 € auf Ziel. 9) Die Maschine wird um 5.000 € abgeschrieben. 10) 2.000 € Zinsen werden an die Bank gezahlt. 11) Ein Kunde klagt, das Unternehmen bildet eine Rückstellung von 7.000 €.

```

```

---

# Teil B - Den Jahresabschluss analysieren

Bei jeder Kennzahl sind es drei Schritte: ausrechnen, mit der Faustregel vergleichen, in einem Satz deuten.

## 11 - Ertragslage: Verdient das Unternehmen Geld

*Nachlesen: `jahresabschlussanalyse/02-beurteilung-der-ertragslage`*

**Erklärung**

- Jahresüberschuss: sollte größer als 0 sein.
- EBIT = Ergebnis vor Zinsen und Steuern = Jahresüberschuss + Zinsaufwand + Steuern. Zeigt, was das eigentliche Geschäft abwirft. Sollte größer als der Zinsaufwand sein.
- Umsatzrendite = Jahresüberschuss / Umsatzerlöse × 100 %. Wie viel von 100 € Umsatz als Gewinn bleibt. Faustregel: über 5 %.
- Eigenkapitalrentabilität = Jahresüberschuss / Eigenkapital. Ob sich die Investition für die Eigentümer lohnt. Faustregel: 6 bis 8 %.
- Die Folie nennt das durchschnittliche Eigenkapital. Ist nur ein Jahr gegeben, nimmst du das Eigenkapital am Jahresende; so rechnet auch die Lösung zum Übungsblatt 3.

**Beispiel**

- Umsatz 200.000, Jahresüberschuss 10.000, Zinsaufwand 4.000, Steuern 6.000, Eigenkapital 100.000
- EBIT = 10.000 + 4.000 + 6.000 = 20.000
- Umsatzrendite = 10.000 / 200.000 = 5 %
- Eigenkapitalrentabilität = 10.000 / 100.000 = 10 %

**Deine Umsetzung**

*Aufgabe*: Berechne Jahresüberschuss, EBIT, Umsatzrendite und Eigenkapitalrentabilität. Vergleiche jeden Wert mit der Faustregel und deute ihn in einem Satz. Daten der GuV: Umsatzerlöse 400.000 · Materialaufwand 140.000 · Personalaufwand 140.000 · Abschreibungen 30.000 · sonstiger betrieblicher Aufwand 40.000 · Zinsaufwand 10.000 · Steueraufwand 12.000. Das Eigenkapital in der Bilanz beträgt einschließlich Jahresüberschuss 128.000.

```

```

## 12 - Finanzlage: Bleibt das Unternehmen zahlungsfähig

*Nachlesen: `jahresabschlussanalyse/03-beurteilung-der-finanzlage`*

**Erklärung**

- Operativer Cash Flow: sollte größer sein als das, was für Investitionen ausgegeben wird.
- Zinsdeckungsgrad = EBIT / Zinsaufwand. Wie oft die Zinsen aus dem Geschäft bezahlt werden könnten. Faustregel: mindestens 2, also 200 %.
- Eigenkapital: muss größer als 0 sein. Es ist der Puffer für Verluste.
- Eigenkapitalquote = Eigenkapital / Gesamtkapital × 100 %. Gesamtkapital ist die Bilanzsumme. Der Durchschnitt liegt bei 33 %.

**Beispiel**

- EBIT 20.000, Zinsaufwand 4.000 → Zinsdeckungsgrad 5, also 500 %. Gut.
- Eigenkapital 100.000, Bilanzsumme 400.000 → Eigenkapitalquote 25 %. Unter dem Durchschnitt.

**Deine Umsetzung**

*Aufgabe*: Berechne Zinsdeckungsgrad und Eigenkapitalquote und beurteile den operativen Cash Flow. Vergleiche mit den Faustregeln und deute in je einem Satz. Daten: EBIT 50.000 · Zinsaufwand 10.000 · Eigenkapital 128.000 · Bilanzsumme 300.000 · operativer Cash Flow 55.000 · Investitions-Cash-Flow −40.000 · Finanzierungs-Cash-Flow −5.000.

```

```

## 13 - Vermögensstruktur: Wie lange ist Geld gebunden

*Nachlesen: `jahresabschlussanalyse/04-beurteilung-der-vermoegensstruktur`*

**Erklärung**

- DIO = 365 × Vorräte / Umsatzerlöse. So viele Tage liegt Ware im Lager. Je niedriger, desto besser.
- DRO = 365 × Forderungen / Umsatzerlöse. So viele Tage brauchen Kunden zum Zahlen. Je niedriger, desto besser.
- DPO = 365 × Verbindlichkeiten aus Lieferung und Leistung / Umsatzerlöse. So viele Tage lässt sich das Unternehmen selbst Zeit. Je höher, desto besser.

**Beispiel**

- Umsatz 365.000, Vorräte 20.000, Forderungen 30.000, Verbindlichkeiten aus Lieferung und Leistung 25.000
- DIO = 365 × 20.000 / 365.000 = 20 Tage
- DRO = 30 Tage
- DPO = 25 Tage

**Deine Umsetzung**

*Aufgabe*: Berechne DIO, DRO und DPO und deute jeden Wert in einem Satz. Daten: Umsatzerlöse 400.000 · Vorräte 30.000 · Forderungen 40.000 · Verbindlichkeiten aus Lieferung und Leistung 30.000.

```

```

## 14 - Insolvenzrisiko: Überschuldung und Illiquidität

*Nachlesen: `jahresabschlussanalyse/03-beurteilung-der-finanzlage`*

**Erklärung**

- Es gibt zwei Gründe für eine Insolvenz.
- **Überschuldung**: Das Eigenkapital ist kleiner als 0. Verluste, Abschreibungen und neue Rückstellungen senken das Eigenkapital. Je kleiner der Puffer, desto größer das Risiko.
- **Illiquidität**: Das Unternehmen kann fällige Rechnungen nicht bezahlen. Vergleiche das schnell verfügbare Geld (Kasse, dazu Forderungen) mit den kurzfristigen Schulden.
- Eine Abschreibung oder Rückstellung kostet kein Geld. Sie kann überschulden, aber nicht illiquide machen.

**Beispiel**

- Eigenkapital 30.000. Eine Maschine wird zerstört und um 40.000 abgeschrieben.
- Neues Eigenkapital: 30.000 − 40.000 = −10.000 → überschuldet
- Die Kasse ändert sich dabei nicht.

**Deine Umsetzung**

*Aufgabe*: Zwei Firmen, beide mit einer Bilanzsumme von 1.000. Firma A, Aktiva: Anlagevermögen 700 · Vorräte 150 · Forderungen 100 · Kasse 50. Firma A, Passiva: Eigenkapital 40 · langfristige Bankdarlehen 600 · kurzfristige Bankdarlehen 260 · Verbindlichkeiten aus Lieferung und Leistung 100. Firma B, Aktiva: Anlagevermögen 500 · Vorräte 100 · Forderungen 150 · Kasse 250. Firma B, Passiva: Eigenkapital 600 · langfristige Bankdarlehen 250 · kurzfristige Bankdarlehen 50 · Verbindlichkeiten aus Lieferung und Leistung 100. a) Berechne für beide die Eigenkapitalquote. b) Welche Firma ist eher von Überschuldung bedroht, und warum? c) Vergleiche bei beiden die Kasse mit den kurzfristigen Schulden. Wo droht Illiquidität? d) Firma A muss eine Rückstellung von 60 bilden. Was passiert mit dem Eigenkapital, und ist die Firma dann überschuldet?

```

```

---

# Teil C - Pflichten und Funktionen

## 15 - Wer muss aufstellen, prüfen lassen, offenlegen

*Nachlesen: `jahresabschlussgrundlagen/02-aufstellungspflichten`, `03-pruefungspflichten`, `04-veroeffentlichungspflichten`*

**Erklärung**

- **Aufstellen** müssen alle Kaufleute. Eine GmbH oder AG ist immer Kaufmann.
  - Ausnahme: Einzelkaufleute mit höchstens 800.000 € Umsatz und 80.000 € Jahresüberschuss, an zwei Stichtagen in Folge.
  - Zusätzlich gibt es den Abschluss nach Steuerrecht für das Finanzamt.
  - Hat eine Kapitalgesellschaft Tochterunternehmen, kommt ein Konzernabschluss dazu. Ist sie börsennotiert, wird er nach IFRS erstellt.
  - Frist: große Kapitalgesellschaften 3 Monate, kleine und mittelgroße 6 Monate.
- **Prüfen lassen** müssen nur mittelgroße und große Kapitalgesellschaften.
- **Offenlegen** müssen Kapitalgesellschaften, im Bundesanzeiger, innerhalb von 12 Monaten. Kleine dürfen verkürzen.
  - Einzelkaufleute und Personengesellschaften müssen es nicht, außer sie sind sehr groß.
- Die **Größenklassen**, jeweils Bilanzsumme · Umsatz · Arbeitnehmer:
  - Kleinst: bis 0,35 Mio. € · bis 0,7 Mio. € · bis 10
  - Klein: bis 6 Mio. € · bis 12 Mio. € · bis 50
  - Mittelgroß: bis 20 Mio. € · bis 40 Mio. € · bis 250
  - Groß: alles darüber
  - Es zählt die Klasse, bei der zwei der drei Merkmale passen, an zwei Stichtagen in Folge.
  - Wer börsennotiert ist, gilt immer als groß.

**Beispiel**

- Bäckerei GmbH: Bilanzsumme 3 Mio. €, Umsatz 8 Mio. €, 40 Arbeitnehmer, keine Tochter
- Alle drei Werte liegen in „klein“.
- Aufstellen: ja, Abschluss nach HGB und nach Steuerrecht, Frist 6 Monate
- Prüfen: nein
- Offenlegen: ja, verkürzt, innerhalb von 12 Monaten

**Deine Umsetzung**

*Aufgabe*: Beurteile für jedes Unternehmen: Welche Abschlüsse muss es aufstellen? Muss es prüfen lassen? Muss es offenlegen, und bis wann? a) Ein Einzelkaufmann betreibt einen Blumenladen mit 250.000 € Umsatz und 30.000 € Jahresüberschuss. b) Eine Werkzeugbau GmbH hat 15 Mio. € Bilanzsumme, 30 Mio. € Umsatz, 120 Arbeitnehmer und keine Tochterunternehmen. c) Eine börsennotierte Solar AG hat 4 Mrd. € Bilanzsumme, 6 Mrd. € Umsatz, 9.000 Arbeitnehmer und 30 Tochterunternehmen.

```

```

## 16 - Wozu der Jahresabschluss dient

*Nachlesen: `jahresabschlussgrundlagen/05-funktionen-des-jahresabschlusses`*

**Erklärung**

- **Dokumentation**: Alle Buchungen sind nachvollziehbar festgehalten. Das dient als Beweis, etwa bei einer Insolvenz.
- **Zahlungsbemessung**: Aus dem Gewinn wird berechnet, wie viel gezahlt wird.
  - an das Finanzamt: die Steuern. Der Abschluss nach HGB ist die Grundlage für die Steuerbilanz. Das nennt man Maßgeblichkeitsprinzip.
  - an die Eigentümer: die Ausschüttung. Mehr als der Jahresüberschuss darf in der Regel nicht ausgeschüttet werden.
- **Information**: Außenstehende sollen ein zutreffendes Bild der Vermögens-, Finanz- und Ertragslage bekommen. Das betrifft Aktionäre, Banken, Mitarbeiter, Lieferanten.

**Beispiel**

- Eine Bank liest vor einer Kreditvergabe den Abschluss → Information

**Deine Umsetzung**

*Aufgabe*: a) Welche Funktion steckt jeweils dahinter? 1) Das Finanzamt berechnet aus dem Gewinn die Steuer. 2) Die Aktionäre beschließen eine Dividende und dürfen dabei den Jahresüberschuss nicht überschreiten. 3) Nach einer Insolvenz prüft ein Gericht anhand der Bücher, was passiert ist. 4) Ein Lieferant schaut in den Abschluss, bevor er auf Rechnung liefert. b) Erkläre die drei Funktionen in je einem Satz mit eigenen Worten.

```

```

---

# Zum Schluss

## 17 - Alle Formeln aus dem Kopf

Erst wenn du die Stationen 1 bis 16 gemacht hast. Schreibe jede Formel auf, ohne nach oben zu schauen, und dahinter die Faustregel, wenn es eine gibt.

*Aufgabe*: Anschaffungskosten · lineare Abschreibung · geometrisch-degressive Abschreibung · gezeichnetes Kapital und Kapitalrücklage bei einer Aktienausgabe · Jahresüberschuss · EBIT · Umsatzrendite · Eigenkapitalrentabilität · Zinsdeckungsgrad · Eigenkapitalquote · DIO · DRO · DPO

```

```

---

# Weiter

Wenn das hier sitzt, weiter mit den Originalaufgaben unter
`dski-sources-3/bilanzierung/origin-tasks/`:

- `task-1`: Aufstellungs-, Prüfungs- und Offenlegungspflicht an vier Unternehmen. Keine Lösung hinterlegt.
- `task-2`: Geschäftsvorfälle buchen und den kompletten Jahresabschluss aufstellen. Lösung nur zu Kapitel 9.
- `task-3`: Analyse, Vergleich zweier Fußballvereine, Überschuldungsfälle. Lösung nur zu Analyse 1.

Wo keine Lösung liegt, kontrollierst du gegen die `topics/`.
