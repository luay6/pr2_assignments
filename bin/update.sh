#!/usr/bin/bash

# Fail on first error
set -e

# check how we have been called
if [ ! "$0" == "bin/update.sh" ]; then
    echo -e "\e[31m"
    echo "💣 Das Skript muss aus dem Hauptverzeichnis des Projektes"
    echo "💣 mit bin/update.sh oder bash bin/update.sh aufgerufen werden."
    echo -e "\e[0m"
    exit 1
fi

# Check the integrity of the .assignments directory
if [ -d ".assignments" ] && [ ! -d ".assignments/.git" ]; then
    echo -e "\e[31m"
    echo "Nicht korrektes .assignments-Verzeichnis. Wird gelöscht."
    echo "Bitte achten Sie darauf, das .assignments-Verzeichnis nicht"
    echo "einzuchecken."
    echo -ne "\e[0m"
    rm -rf ".assignments"
fi

# Sync exercises with local directory
echo -e "\e[32m"
echo "---------------------------------------------------------------"
echo "Hole neue Aufgaben und Quelltexte                              "
echo "---------------------------------------------------------------"
echo -ne "\e[0m"
rm -rf .assignments
git clone https://gitty.informatik.hs-mannheim.de/pr2-lecture/assignments.git .assignments
mkdir -p sources/src/main/java

# Copy everything new into students workspace
rsync --ignore-existing -raz .assignments/sources/ sources/

for dir in .assignments/Assignment_*; do
    rsync --ignore-existing -raz "$dir" ./
done

# Assignment files
rsync --ignore-existing -raz --include='Assignment_*' --exclude='*' .assignments/* ./

# Libraries
#rsync -raz .assignments/sources/lib/ ./sources/lib

# Main readme
cp .assignments/readme.md README.md

# Update scripts
cp .assignments/bin/submit.sh bin/submit.sh

if [ -f .assignments/bin/update.sh ]; then
    # Remove myself
    rm bin/update.sh

    # Copy the new version at the old location
    cp .assignments/bin/update.sh bin/update.sh
fi
