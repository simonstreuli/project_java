# Testkonzept für die Battleships-Applikation

## 1. Ziel des Testkonzepts

Das Ziel dieses Testkonzepts ist es, eine testgetriebene Entwicklung (Test-Driven Development, TDD) für die Battleships-Applikation sicherzustellen. Dabei stehen automatisierte Tests im Vordergrund, um die Qualität und Stabilität der Anwendung zu gewährleisten.

## 2. Software-Architektur

Die Applikation basiert auf einer objektorientierten Architektur mit den Hauptkomponenten:

- **Game**: Steuert den Spielablauf  
- **Board**: Stellt das Spielfeld dar  
- **Cell**: Repräsentiert einzelne Zellen auf dem Spielfeld  
- **Ship**: Definiert die Schiffe und deren Status  
- **Scoreboard**: Speichert Spielergebnisse  

### Zu testende Komponenten:

- **Board**: Platzierung und Anzeige von Schiffen, Angriffsszenarien, Spielende-Bedingungen  
- **Ship**: Überprüfung, ob ein Schiff versenkt wurde, Positionierung und Status  
- **Game**: Spielsteuerung, Benutzereingaben, Versuchszähler  
- **Scoreboard**: Speicherung und Abruf von Spielergebnissen  
- **Cell**: Statusänderungen (besetzt, getroffen, verfehlt)  

## 3. Zu testende Features

| Feature            | Beschreibung                                           | Testmethode                      |
|--------------------|-------------------------------------------------------|----------------------------------|
| **Schiffsplatzierung** | Zufällige Platzierung von Schiffen auf dem Spielfeld | Unit-Tests mit Mocking          |
| **Angriffssystem**  | Treffer oder Fehlschlag einer Attacke                 | Unit-Tests                      |
| **Spielende-Bedingung** | Überprüfung, ob alle Schiffe versenkt wurden        | Integrationstests               |
| **Scoreboard**      | Speicherung und Anzeige von Spielergebnissen         | Unit-Tests mit Datenüberprüfung |
| **Benutzerinteraktion** | Verarbeitung von Benutzereingaben                  | End-to-End-Tests                |
| **Versuchsmanagement** | Begrenzung der Anzahl von Versuchen                 | Unit-Tests                      |
| **Eingabevalidierung** | Überprüfung der Benutzerangaben auf Korrektheit    | Unit-Tests                      |

## 4. Nicht getestete Bereiche

- Grafische Darstellung der Spieloberfläche  
- Audio-Ausgabe (falls implementiert)  
- Netzwerkkommunikation für Multiplayer-Modus (zukünftige Erweiterung)  

## 5. Gewählte Testumgebung

- **Unit-Testing-Framework**: JUnit 5  
- **Mocking-Framework**: Mockito  
- **Continuous Integration (CI)**: GitHub Actions für automatisierte Tests bei jedem Commit  

## 6. Testplan

1. Implementierung der Unit-Tests für grundlegende Funktionen (*Board, Ship, Game, Scoreboard, Cell*)  
2. Erweiterung der Tests auf Integrationsebene  
3. Automatische Testausführung mittels CI/CD-Pipeline  
4. Manuelle Tests zur Validierung der Benutzeroberfläche  
5. Validierung von Grenzfällen (z. B. Angriffe außerhalb des Spielfelds, ungültige Eingaben, Schiffe außerhalb des Spielfelds)  
6. Sicherstellung, dass das Spielende korrekt erkannt wird  
