# conference-managment-app

# Example Postman Requests
Użytkownik może obejrzeć plan konferencji. 

    GET http://localhost:8085/conferences/plan
    
Użytkownik po podaniu swojego loginu jako requestparam może obejrzeć prelekcje na które się zapisał. 

    POST http://localhost:8085/reservations/
    PARAM: login=?
    
    POST http://localhost:8085/reservations/{lectureID}/{lectureRootID}
    
Jeżeli prelekcja ma jeszcze wolne miejsca, użytkownik ma możliwość dokonania rezerwacji. Podczas dokonywania rezerwacji powinien podać swój login oraz adres e-mail jako requestBody.
+ Jeżeli w systemie istnieje już użytkownik z danym loginem, ale z innym adresem e-mail, system powinien zaprezentować komunikat „Podany login jest już zajęty”.
+ Poprawne dokonanie rezerwacji skutkuje wysłaniem powiadomienia użytkownikowi na podany przez niego adres (wysyłka wiadomości - patrz wskazówki). 
  
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

