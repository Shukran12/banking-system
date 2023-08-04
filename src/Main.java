import Service.BankSystemApp;
import Service.Impl.BankSystemAppImpl;


public class Main {
    public static void main(String[] args) {
        BankSystemApp bankSystemApp = new BankSystemAppImpl();
        bankSystemApp.managment();
    }
}