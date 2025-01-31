# Testkonzept für das Battleship-Projekt

## Überblick
Das Projekt basiert auf einem klassischen "Schiffe versenken"-Spiel. Es enthält mehrere Klassen, wie `Cell`, `Board`, `Ship`, `Game`, und `Menu`, die getestet werden müssen. Ziel der Tests ist es, eine vollständige Testabdeckung (mindestens 80%) zu erreichen, die sicherstellt, dass alle Funktionen korrekt arbeiten und Fehler im Code frühzeitig erkannt werden. Wir verwenden Unit-Tests und Mocking, um die verschiedenen Komponenten unabhängig voneinander zu testen.

## Zu testende Komponenten und deren Funktionalität:
- **Cell**: Verwaltung des Status der Zellen (besetzt, getroffen, verfehlt)
- **Board**: Spielfeldmanagement, Platzierung und Angriff auf Zellen
- **Ship**: Verwaltung der Schiffe und ihrer Positionen
- **Game**: Spiellogik (Spiel starten, Angriffe ausführen, Scoreboard anzeigen)
- **Menu**: Interaktive Benutzeroberfläche für die Auswahl von Optionen

## Testarten:
1. **Unit-Tests**: Diese Tests prüfen die Methoden und die Logik innerhalb einer Klasse ohne Abhängigkeiten von anderen Komponenten.
2. **Mocking-Tests**: Diese Tests nutzen Scheinobjekte (Mocks), um externe Abhängigkeiten zu simulieren, sodass die Interaktionen zwischen den Klassen getestet werden können, ohne dass die tatsächliche Logik ausgeführt wird.

## Testabdeckung:
- **Unit-Tests**: Jede einzelne Methode und Logik innerhalb einer Klasse wird getestet.
- **Mocking**: Externe Interaktionen zwischen den Klassen (z.B. `Game` und `Board`) werden mit Mocking getestet, um zu prüfen, wie die Klassen miteinander interagieren.

## Architektur-Skizze:
Die Architektur des Projekts besteht aus mehreren Modulen:
- **Cell**: Zustandsverwaltung für einzelne Zellen.
- **Board**: Verwalten des Spielfelds, Platzierung und Angriff auf Zellen.
- **Ship**: Verwaltung der Schiffe und ihrer Positionen auf dem Spielfeld.
- **Game**: Logik für das Spiel selbst, Steuerung des Spielflusses.
- **Menu**: Interaktive Menüauswahl für den Benutzer.

## Testfälle und Mocking

| **Komponente**     | **Funktionalität**                                                                                                                                           | **Testfälle (Unit-Test)**                                                                                                                       | **Testfälle (mit Mocking)**                                                                                                                   |
|--------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------|
| **Cell**           | Verwaltung der Zellen im Spielfeld (Status: besetzt, getroffen, verfehlt)                                                                                   | - Testen der Getter/Setter für `occupied`, `hit`, `miss`<br>- Testen der `toString`-Methode (korrekte Darstellung des Zellstatus)                 | Keine Mocks erforderlich, da keine externen Abhängigkeiten vorhanden sind.                                                                  |
| **Board**          | Spielfeldmanagement, Platzierung der Schiffe, Angriff auf Zellen                                                                                           | - Überprüfung der Funktionsweise der `placeShip`-Methode (Platzierung auf dem Spielfeld)<br>- Testen des `attackCell` (richtig/falsch Treffer)    | - Mock von `Cell`-Objekten, um das Spielfeld ohne echte Platzierung der Schiffe zu testen<br>- Mock von `Ship` für die Platzierung und Angriffe |
| **Ship**           | Verwaltung der Schiffe (Name, Länge, Positionen, Status: versenkt oder nicht)                                                                               | - Testen der `addPosition`-Methode (fuegt Positionen korrekt hinzu)<br>- Testen der `isSunk`-Methode (richtig/falsch je nach Trefferstatus)       | Keine Mocks erforderlich, da es keine externen Abhängigkeiten gibt, die gemockt werden müssten.                                              |
| **Game**           | Spiellogik (Spiel starten, Angriffe ausführen, Scoreboard anzeigen)                                                                                        | - Testen des vollständigen Spielablaufs (Spiel starten, Angriffe ausführen)<br>- Testen der Eingabevalidierung für Angriffskoordinaten            | - Mock von `Board`-Objekten, um das Verhalten des Spiels ohne die tatsächliche Spielfeld-Logik zu testen<br>- Mock von `Scanner` für Benutzereingaben |
| **Menu**           | Interaktive Benutzeroberfläche für die Auswahl von Optionen (Neues Spiel, Scoreboard anzeigen, Beenden)                                                    | - Testen der Menülogik (z.B. Auswahlmöglichkeiten, Beenden der Anwendung)<br>- Testen der Eingabevalidierung im Menü                            | - Mock von `Game` und `Scanner`-Objekten, um das Verhalten des Menüs ohne echte Benutzereingaben zu testen                                      |

## Beispiel für Mocking-Tests:
- **Board**: Wir könnten ein Mock-Objekt für die `Cell`-Klasse erstellen, um das Verhalten von Angriffen ohne die tatsächliche Platzierung der Schiffe zu testen.
- **Game**: Das `Scanner`-Objekt könnte gemockt werden, um Benutzereingaben zu simulieren und zu testen, ob die Spiellogik korrekt auf Eingaben reagiert.

## Testumgebung:
- **JUnit 5** wird für die Durchführung der Unit-Tests verwendet.
- **Mockito** wird für das Mocking von Objekten eingesetzt.
- **CI/CD Pipeline** wird eingerichtet, um alle Tests bei jeder Codeänderung automatisch auszuführen.

## Automatisierung:
- Alle Tests werden in eine CI/CD-Pipeline integriert, um bei jeder Änderung im Code sicherzustellen, dass alle Tests erfolgreich sind und keine Fehler eingeführt wurden.