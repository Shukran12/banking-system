package Service.Impl;
import Exceptions.AllExcpetions;
import Service.BankSystemApp;

import java.util.InputMismatchException;

import static Util.InputUtil.*;
import static Util.MenuUtil.*;
public class BankSystemAppImpl implements BankSystemApp {
    @Override
    public void managment() {
        while (true) {
            try {
                byte menuChoose = inputByte("[1] -> Exit\n[2] -> Register\n[3] -> Login\n[4] -> Increase Balans\n Choose Order: ");
                 menu(menuChoose);
            }catch (AllExcpetions  |InputMismatchException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
