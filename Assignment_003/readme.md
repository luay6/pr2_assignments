# Assignment: Stein, Papier, Schere (, Echse, Spock)

**🎓 Benotetes Assignment 🎓**

📆 **Fällig: 07.10.2025** 📆

## Lernziel

Einfaches Kommandozeilenprogramm mit Konsolen-Eingabe und Ausgabe.

## Aufgabe

Gehen Sie in das Paket [pr2.auffrischung.schnick](../sources/src/main/java/pr2/auffrischung/schnick).

![Regeln für Schnick-Schnack-Schnuck](img/schnick.png)

Schreiben Sie ein einfaches Spiel (Klasse `SchnickSchnackSchnuck`), bei dem Sie gegen den Computer Schnick-Schnack-Schnuck spielen (auch Rock, Paper, Scissors genannt) mit folgenden Eigenschaften:

  * Das Spiel geht über drei Runden.
  * Es fragt den Spieler nach seiner Auswahl (r, p, s).
  * Der Computer zieht zufällig eine der drei Möglichkeiten.
  * Nach jeder Runde sagt das Spiel, wer welche Möglichkeit gewählt hat und wer die Runde gewonnen hat.
  * Ein Sieg der Runde bringt einen Punkt, ein Unentschieden 0 Punkte.
  * Die Punkte jeder Runde werden addiert.
  * Am Ende wird der Gesamtpunktestand ausgegeben.

Eine beispielhafte Session mit dem Programm sieht dann wie folgt aus:

```console
Runde 1: Dein Zug ([r]rock, [p]aper, [s]cissors)? r
Der Computer hat gewonnen - Du: ROCK, Computer: PAPER - [0:1]

Runde 2: Dein Zug ([r]rock, [p]aper, [s]cissors)? p
Unentschieden - Du: PAPER, Computer: PAPER - [0:1]

Runde 3: Dein Zug ([r]rock, [p]aper, [s]cissors)? s
Du hast gewonnen: Du: SCISSORS, Computer: PAPER - [1:1]### Abgabe
Ergebnis - Du 1 Punkt(e), Computer 1 Punkt(e)
```

Verwenden Sie intern Integer-Konstanten, um die möglichen Züge (Schere, Stein, Papier) zu repräsentieren.

Daten von der Konsole lesen Sie am einfachsten mit der Klasse [java.util.Scanner](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Scanner.html).

Für Zufallszahlen können Sie die Klasse [java.util.Random](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Random.html) benutzen.



## Abgabe

Alle Abgaben für die Vorlesung erfolgen über `git`.

Hierzu gehen Sie wie folgt vor:

  1. Öffnen Sie eine Kommandozeile (Terminal).
  2. Gehen Sie in Ihr Working Directory.
  3. Rufen Sie mit `bin/submit.sh` das Skript auf, das die Lösungen testet und kompiliert. Wenn Maven eine Fehlermeldung zeigt, beheben Sie diese zuerst, bevor Sie mit dem nächsten Schritt fortfahren.
  4. Wenn Sie Meldung "✅ Projekt gebaut" bekommen, checken Sie Ihre Änderungen in `git` **auf der Kommandozeile** ein (comitten), d.h. mit `git add` und `git commit`. Verwenden Sie **nicht** Eclipse für diesen Schritt.
  5. Rufen Sie mit `bin/submit.sh` erneut das Skript auf. Wenn alles klappt, bekommen Sie die Anzeige "✅ Aktuelle Lösungen eingereicht" und Ihre Lösung ist im System angekommen.