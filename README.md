# conference-managment-app
## Table of contents
* [Introduction](#Introduction)
* [Example](#Example Postman Requests)
* [Pull](#Pull)



# Introduction
Konferencja trwa 1 dzień: 1 czerwca 2021. 
2.	Rozpoczyna się o godzinie 10:00 a kończy o godzinie 15:45.
3.	Każda prelekcja trwa 1h 45m (15 minut to przerwa na kawę):
	- pierwsza prelekcja rozpoczyna się o 10:00 i trwa do 11:45. 
	- druga rozpoczyna się o 12:00 i kończy o 13:45
	- trzecia rozpoczyna się o 14:00 i kończy o 15:45
4.	W ramach konferencji obsługiwane są 3 różne ścieżki tematyczne prowadzone równolegle. Jeśli użytkownik zapisze się w danej ścieżce na daną godzinę, to nie może już uczęszczać w tym okresie w innej ścieżce, natomiast o innej godzinie najbardziej może wybrać inną ścieżkę. 
5.	Każda prelekcja może pomieścić maksymalnie 5 słuchaczy. 

# Example Postman Requests
Użytkownik może obejrzeć plan konferencji. 

    GET http://localhost:8085/conferences/plan
    
Użytkownik po podaniu swojego loginu jako requestparam może obejrzeć prelekcje na które się zapisał. 

    POST http://localhost:8085/reservations/
    PARAM: login=?
    
Jeżeli prelekcja ma jeszcze wolne miejsca, użytkownik ma możliwość dokonania rezerwacji. Podczas dokonywania rezerwacji powinien podać swój login oraz adres e-mail jako requestBody.
+ Jeżeli w systemie istnieje już użytkownik z danym loginem, ale z innym adresem e-mail, system powinien zaprezentować komunikat „Podany login jest już zajęty”.
+  Poprawne dokonanie rezerwacji skutkuje wysłaniem powiadomienia użytkownikowi na podany przez niego adres (wysyłka wiadomości - patrz wskazówki). 


    POST http://localhost:8085/reservations/{lectureID}/{lectureRootID}
##### Path:
    lectureID:      (1-3)   - 3 prelekcje do wyboru
    lectureRootID:  (1-3)   - 3 ścieżki do wyboru
    
##### RequestBody:
    {
    "login":"login",
    "email":"email@email.com"
    }

## Pull repository
You can pull repository [here](https://github.com/LukaszDziewicki/conference-managment-app/archive/refs/heads/main.zip)

