
<p align="center">
     <a href="https://circleci.com/gh/Ghislain1/workflows/fopt-app/tree/master" title="Build Status"><img src="https://circleci.com/gh/Ghislain1/fopt-app.svg?style=shield&circle-token=3f33dc69061bec9eed0c430fccb9630c9ed3efec">
     </a>
</p>


# fopt-app
## Intro
Übungen, **Alte Prüfungen** in Fortgeschrittene Programmiertechniken (FOPT) mit Java.
Das Hauptziel ist alte Klausuren zusammen zu lösen mit ausführlichen Kommentaren auf  jeweils Fragen
# Howtos
## Package structure in src folder
- **fopt.buch**: Übungsaufgaben,Listing, Abschnitte und Beispiele aus dem Buch
- **fopt.lehrmaterial**: Aufgaben aus der Lehrmaterial 
- **fopt.asb**: beinhalt alle asb selbstgemachte ASB-Aufgaben, ASB-Zusatzaufgaben,  ASB-Pflichtaufgaben
- **fopt.klausur**: sind alle Klausuren. Hier können alle Lösungsansätze gepackt werden
     - fopt.klausur.ws2013 hat z.b ghislain.md, jochen.md, lin.md
     - fopt.klausur.ss2019 hat z.b ghislain.md, jochen.md, lin.md
 ##  Coding
1. Clone the Repository 
1. Start your IDE and Import the project as git project
1. Create your package as follows fopt.klausur.your firstname.period:
   * e.g. fopt.klausur.**ghis**.ss2019, fopt.klausur.**lin**.ss2019, fopt.klausur.**jochen**.ss2019
   * Diese package dient nur um die verwendenten Klassen auszuproblieren
   * Die tatsächliche Lösung soll als **Mark Down file** in fopt.klausur.xxxxx e.g. Ghislain.md, jochen.md, lin.md
1. Export your package in module-info.java file e.g. exports fopt.klausur.ghis.ws2013;
1. Commit your change with suitable comments
1. Push it 
1. That's all!!
# Bücher
* [Java Threads and the Concurrency Utilities- Jef f Friesen](https://drive.google.com/drive/folders/1vY-kjzbNTtK9c46XpZM1Y0GFERTEiDD2): Buch mit Aufgaben und Lösung  ür die Verständnis
# Links
* [ASB-Zusatzaufgaben](https://olat.vcrp.de/auth/RepositoryEntry/2535325809/CourseNode/92787204650784)
* [Online-Tutorien](https://olat.vcrp.de/auth/RepositoryEntry/2535325809/CourseNode/94291001914984)
* [Alte Klausure](https://drive.google.com/drive/folders/0B9ZkMECasmz5WlJSQ194Q0FwTG8)
* [JUnit on Eclipse](https://www.eclipse.org/community/eclipse_newsletter/2017/october/article5.php)
* [Eclipse-IDE Improvements](https://www.youtube.com/watch?v=U-ZTkhek5TU&feature=youtu.be&t=2m32s) -- Video
