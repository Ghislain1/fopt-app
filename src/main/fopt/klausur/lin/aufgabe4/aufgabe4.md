Mit MVPwerden drei Komponenten einer Anwendung bezeichnet: die Modell-, die Darstellungs- und die Kontrollkomponente 
(Model – View – Presenter). Es beschreibt einen neuartigen Ansatz, 
um das Modell (engl. model) und die Ansicht (engl. view) komplett voneinander zu trennen 
und über einen Präsentierer (engl. presenter) zu verbinden.
Dabei steht neben einer deutlich verbesserten Testbarkeit auch die strengere Trennung der einzelnen Komponenten im Vordergrund.


MVP basiert wie MVC auch auf drei Komponenten: Dem Modell (model), der Ansicht (view) und dem Präsentierer (presenter).

Model
    Das Modell stellt die Logik der Ansicht dar. Dies kann auch die Geschäftslogik sein. Über das Modell muss jedoch alle Funktionalität erreichbar sein, um die Ansicht betreiben zu können. Die Steuerung des Modells erfolgt allein vom Präsentierer. Das Modell selbst kennt weder die Ansicht noch den Präsentierer.
View
    Die Ansicht enthält keinerlei steuernde Logik und ist nur allein für die Darstellung und die Ein- und Ausgaben zuständig.
    Sie erhält weder Zugriff auf die Funktionalität des Präsentierers noch auf das Modell.
    Sämtliche Steuerung der Ansicht erfolgt durch den Präsentierer.
Presenter
    Der Präsentierer ist das Bindeglied zwischen Modell und Ansicht. Er steuert die logischen Abläufe zwischen den beiden anderen Schichten und sorgt dafür, dass die Ansicht ihre Funktionalität erfüllen kann.
    

Vorteile:

MVP is easier to do the unit testing and low maintenance cost