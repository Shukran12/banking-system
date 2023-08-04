package Enums;

import java.time.LocalDate;
import java.time.LocalDateTime;

public enum ExceptionsEnums {

    WRONG_FORMAT_EMAIL("Wrong Format email", LocalDateTime.now()),
    EMAIL_EXIST("This email is exist", LocalDateTime.now()),
    CUSTOMER_BLOCKED("User blocked",LocalDateTime.now()),
    WRONG_ORDER("Entered Wrong Order", LocalDateTime.now()),
   LACKOFFUNDS("Lack of found", LocalDateTime.now()),
    CUSTOMER_NOT_FOUND("Customer Not found", LocalDateTime.now()),
    PASSWORD_NOT_MATCH("Password did not match", LocalDateTime.now()),

    CARD_NOT_FOUND("No card found such number", LocalDateTime.now());


    private String message;
    private LocalDateTime ldt;


    ExceptionsEnums(String message, LocalDateTime  ldt){
        this.message = message;
        this.ldt = ldt;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getLdt() {
        return ldt;
    }
}
