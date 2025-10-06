# Erster Commit

**🎓 Benotetes Assignment 🎓**

📆 **Fällig: 01.10.2025** 📆

## Lernziel

Einen ersten Commit erfolgreich einchecken, pushen und testen.

## Aufgabe

Es ist wichtig, dass Sie diese Aufgabe erfolgreich abschließen. Der Ablauf ist die Vorlage für alle weiteren Übungen, welche Sie fristgerecht einreichen müssen. Diese Aufgabe ist zwar trivial, zeigt Ihnen aber den generellen Ablauf.

Lesen Sie deswegen dieses Assignment sehr sorgfältig und führen Sie die beschriebenen Schritte durch.

Die folgenden Schritte beziehen sich auf Ihr persönliches Repository, dass Sie im vorhergehenden Assignment angelegt und konfiguriert haben. Sie arbeiten in Ihrer lokalen Kopie, dem __Working Directory__ und übertragen Ihre Ergebnisse am Ende in das Repository auf dem zentralen Git-Server.

Wie Sie die Umgebung aufsetzen, wurde im vorhergehenden Assignment erläutert. Sorgen Sie dafür, dass Sie den aktuellen Stand der Aufgaben haben, indem Sie in Ihrem Working Directory `bin/update.sh` aufrufen.

### Eclipse einrichten

Hier erhalten Sie eine Anleitung, wie Sie Eclipse für die Bearbeitung der Aufgaben einrichten.

  1. Legen Sie einen neuen Workspace für die Vorlesung PR2 an. Es empfiehlt sich, diesen in einem Unterverzeichnis, z.B. `eclipse-workspace` in Ihrem Working Directory anzulegen. Allerdings sollten Sie das Verzeichnis dann über die `.gitignore`-Datei von der Versionsverwaltung ausschließen. Auf keinen Fall sollten Sie den Workspace mit unter die Versionsverwaltung stellen.
  2. Erzeugen Sie mit `File` -> `New` -> `Java Project` ein neues Java-Projekt.
     * Geben Sie dem Projekt einen beliebigen Namen, z.B. "pr2"
     * _Entfernen_ Sie das Häkchen für `Use Default Location` und tragen Sie den Pfad zu dem `sources`-Ordner in Ihrem Working Directory ein.
     * _Entfernen_ Sie das Häkchen für `Create module-info.java file`.
     * Drücken Sie auf `Finish`.

Wenn alles richtig funktioniert hat, findet Eclipse die Datei `.classpath` im `sources`-Verzeichnis und macht automatisch die notwendigen Einstellungen. Überprüfen Sie aber den folgenden Punkt trotzdem und passen Sie die Einstellungen gegebenenfalls an.

Gehen Sie auf die Projekteigenschaften (`Properties`), wählen Sie `Java Build Path` und dann die Registrierkarte `Source`.
  * Stellen Sie sicher, dass der Ordner `src/main/java` eingetragen ist.
  * Stellen Sie sicher, dass der Eintrag `Default output folder` `.../target/classes` entspricht.

Es gibt noch ein paar weitere Einstellungen, die Sie in Eclipse vornehmen sollten. Eine Anleitung dazu finden Sie [hier](../help/eclipse.md).

### HelloWorld programmieren

In dieser Aufgabe geht es darum, ein einfaches Hello-World-Programm zu schreiben und dann einzureichen.

  1. Bitte gehen Sie in das Paket [pr2.bootstrap.hello](../sources/src/main/java/pr2/bootstrap/hello/)
  2. Schauen Sie sich die Klassen `HelloWorld` und `Greeter` an.
  3. Vervollständigen Sie den Code, achten Sie dabei insbesondere auf die `// TODO:`-Kommentare. Entfernen Sie diese Kommentare, nachdem Sie die entsprechenden Aktionen durchgeführt haben.
  4. Testen Sie Ihr Programm und geben es danach ab.


## Abgabe

Alle Abgaben für die Vorlesung erfolgen über `git`.

Hierzu gehen Sie wie folgt vor:

  1. Öffnen Sie eine Kommandozeile (Terminal).
  2. Gehen Sie in Ihr Working Directory.
  3. Rufen Sie mit `bin/submit.sh` das Skript auf, das die Lösungen testet und kompiliert. Wenn Maven eine Fehlermeldung zeigt, beheben Sie diese zuerst, bevor Sie mit dem nächsten Schritt fortfahren.
  4. Wenn Sie Meldung "✅ Projekt gebaut" bekommen, checken Sie Ihre Änderungen in `git` **auf der Kommandozeile** ein (comitten), d.h. mit `git add` und `git commit`. Verwenden Sie **nicht** Eclipse für diesen Schritt.
  5. Rufen Sie mit `bin/submit.sh` erneut das Skript auf. Wenn alles klappt, bekommen Sie die Anzeige "✅ Aktuelle Lösungen eingereicht" und Ihre Lösung ist im System angekommen.

Wenn beim Bauen des Programms durch Maven Fehler auftreten, dann lesen Sie die Fehlermeldungen sorgfältig **von oben nach unten**. **Sie müssen immer den ersten Fehler (von oben gesehen) zuerst beheben.**

Als Beispiel soll folgende Ausgabe von Maven dienen:

```console
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< de.hs_mannheim.pr2:solutions >--------------------
[INFO] Building PR2 Excercises 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-checkstyle-plugin:3.2.0:check (validate) @ solutions ---
[INFO] Starting audit...
[ERROR] /tmp/team-79/sources/src/main/java/pr2/auffrischung/schnick/
SchnickSchnackSchnuck.java:3:8: Unused import - java.util.Random. [UnusedImports]
[ERROR] /tmp/team-79/sources/src/main/java/pr2/auffrischung/schnick/
SchnickSchnackSchnuck.java:4:8: Unused import - java.util.Scanner. [UnusedImports]
[ERROR] /tmp/team-79/sources/src/main/java/pr2/bootstrap/hello/
HelloWorld.java:17:11: Comment matches to-do format 'TODO:'. [TodoComment]
[ERROR] /tmp/team-79/sources/src/main/java/pr2/bootstrap/hello/
HelloWorld.java:18:11: Comment matches to-do format 'TODO:'. [TodoComment]
[ERROR] /tmp/team-79/sources/src/main/java/pr2/bootstrap/hello/
HelloWorld.java:19:11: Comment matches to-do format 'TODO:'. [TodoComment]
Audit done.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.988 s
[INFO] Finished at: 2023-03-23T16:39:26+01:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-checkstyle-plugin:3.2.0:check (validate) on project solutions: Failed during checkstyle execution: There are 5 errors reported by Checkstyle 10.4 with checkstyle.xml ruleset. -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
```

Dann ist der **erste Fehler, den Sie beheben müssen**, der unbenutzte Import in der Datei `SchnickSchnackSchnuck.java` in Zeile 3.

```console
[ERROR] /tmp/team-79/sources/src/main/java/pr2/auffrischung/schnick/SchnickSchnackSchnuck.java:3:8: Unused import - java.util.Random. [UnusedImports]
```