package Util;
import Enums.ExceptionsEnums;
import Exceptions.AllExcpetions;
import Service.CardService;
import Service.CustomerService;
import Service.Impl.CardServiceImpl;
import Service.Impl.CustomerServiceImpl;
import static Util.InputUtil.*;
public class MenuUtil {
public static CustomerService customerService  = new CustomerServiceImpl();
    public static void menu(byte ch){
        switch (ch){
            case 1:
                System.out.println("Bye Bye :)");
                System.exit(-1);
                break;
            case 2:
                customerService.registr();
                break;
            case 3:
                long id = customerService.login();
                if(id > 0){
                    byte loggedChoose = inputByte("[1] ->Show My Details\n[2] -> Update My Details\n[3] -> Operations\n[4] -> Logout\n Choose Order: ");
                    loggedMenu(loggedChoose, id);
                }else{
                    throw new AllExcpetions(ExceptionsEnums.CUSTOMER_NOT_FOUND);
                }
                break;
            case 4:
               String cardNumber = inputString("Enter Card Number: ");
                CardService cardService = new CardServiceImpl();
                cardService.increaseBalance(cardNumber);
               break;
            default:
                throw new AllExcpetions(ExceptionsEnums.WRONG_ORDER);
        }
    }

    public static void loggedMenu(byte ch, long id){
        switch (ch){
            case 1:
                customerService.showMyDetails(id);
                break;
            case 2:
                byte updateChoose = inputByte("[1] -> Update Name\n[2] -> Update Surname\n[3] -> Update Email\n[4] -> Update Password\n[5] -> Update All\n Choose Order: ");
                customerService.updateMyDetails(id, updateChoose);
                break;
            case 3:
                byte operationChoose = inputByte("[1] -> Show Balance\n[2] -> CashOut\n[3] -> Back To Menu\n Choose Order: ");
                operationMenu(id, operationChoose);
            case 4:
                customerService.logOut();
            default: throw new AllExcpetions(ExceptionsEnums.WRONG_ORDER);
        }
    }
    public static void operationMenu(long id, byte operationChoose){
        CardService cardService = new CardServiceImpl();
        switch (operationChoose){
            case 1:
                System.out.println("Your Balance: "); cardService.showBalance(id);
                byte loggedChoose = inputByte("[1] ->Show My Details\n[2] -> Update My Details\n[3] -> Operations\n[4] -> Logout\n Choose Order: ");
                loggedMenu(loggedChoose, id);
                break;
            case 2:
                try {
                    int cash = inputInt("Enter Cash: ");
                    cardService.cashOut(id, cash);
                    loggedChoose = inputByte("[1] ->Show My Details\n[2] -> Update My Details\n[3] -> Operations\n[4] -> Logout\n Choose Order: ");
                    loggedMenu(loggedChoose, id);
                }catch (AllExcpetions ex){
                    System.out.println(ex.getMessage());
                    loggedChoose = inputByte("[1] ->Show My Details\n[2] -> Update My Details\n[3] -> Operations\n[4] -> Logout\n Choose Order: ");
                    loggedMenu(loggedChoose, id);
                }
                break;
            case 3:
                loggedChoose = inputByte("[1] ->Show My Details\n[2] -> Update My Details\n[3] -> Operations\n[4] -> Logout\n Choose Order: ");
                loggedMenu(loggedChoose, id);
                break;
            default:throw new AllExcpetions(ExceptionsEnums.WRONG_ORDER);
        }
    }


    }



