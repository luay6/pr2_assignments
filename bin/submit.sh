#!/usr/bin/bash

# Fail on first error
set -e

# check how we have been called
if [ ! "$0" == "bin/submit.sh" ]; then
    echo -e "\e[31m"
    echo "💣 Das Skript muss aus dem Hauptverzeichnis des Projektes"
    echo "💣 mit bin/submit.sh aufgerufen werden."
    echo -e "\e[0m"
    exit 1
fi

echo "***************************************************************"
echo "Abgabe einreichen"
echo "***************************************************************"
echo ""
cd sources

# Test, if project builds
echo "------------------------------------------------------------------"
echo "Build..."
echo ""
if ! mvn; then
  echo -e "\e[31m"
  echo "💣 Projekt baut nicht und kann deswegen nicht abgegeben werden."
  echo "💣 Bitte beheben Sie alle gemeldeten Fehler und versuchen Sie  "
  echo "💣 es dann erneut                                              "
  echo -e "\e[0m"
  exit 1
else
  echo -e "\e[32m"
  echo "✅ Projekt gebaut                                              "
  echo -e "\e[0m"
fi

# Test, if all changes are committed
echo "------------------------------------------------------------------"
echo "Teste git-Staus..."
if ! git status | grep -q "nothing to commit" && ! git status | grep -q "nichts zu committen" ; then
  echo -e "\e[31m"
  echo "💣 Bitte checken Sie alle Änderungen per git ein.              "
  echo -e "\e[0m"
  exit 1
else
  echo -e "\e[32m"
  echo "✅ Alle Dateien eingecheckt                                     "
  echo -e "\e[0m"
fi

# Submit
echo "------------------------------------------------------------------"
echo "Sende Lösung..."
if ! git push origin main; then
  echo -e "\e[31m"
  echo "💣 Push nicht erfolgreich. Bitte beheben Sie den Fehler und     "
  echo "💣 starten Sie das Skript erneut.                               "
  echo -e "\e[0m"
  exit 1
else
  echo -e "\e[32m"
  echo "✅ Aktuelle Lösungen eingereicht                                "
  echo -e "\e[0m"
fi
