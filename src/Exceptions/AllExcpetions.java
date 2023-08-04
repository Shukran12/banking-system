package Exceptions;
import Enums.ExceptionsEnums;
import java.time.LocalDateTime;

public class AllExcpetions extends RuntimeException{
    LocalDateTime ldt;

    public AllExcpetions(ExceptionsEnums exceptionsEnums) {
        super(exceptionsEnums.getMessage());
        this.ldt = exceptionsEnums.getLdt();
    }

    public LocalDateTime getLdt() {
        return ldt;
    }
}

