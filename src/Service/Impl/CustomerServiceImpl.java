package Service.Impl;
import Data.Global;
import Enums.ExceptionsEnums;
import Enums.MessageEnums;
import Exceptions.AllExcpetions;
import Helper.CustomerHelper;
import Model.Customer;
import Service.CustomerService;
import Util.MenuUtil;
import static Helper.CustomerHelper.changePassword;
import static Util.MenuUtil.loggedMenu;
import java.time.LocalDateTime;
import static Helper.CustomerHelper.fillCustomer;
import static Util.InputUtil.inputByte;
import static Util.InputUtil.inputString;
import static Util.MenuUtil.menu;
public class CustomerServiceImpl implements CustomerService {
    @Override
    public void registr() {
        Customer newCustomer = fillCustomer();
        if(newCustomer !=null) {
            Customer[] tempCustomer = new Customer[Global.customers.length + 1];
            for (int i = 0; i < tempCustomer.length; i++) {
               if(i<Global.customers.length){
                   tempCustomer[i] = Global.customers[i];
               }else{
                   tempCustomer[i] = newCustomer;
               }
            }
            Global.customers = tempCustomer;
            System.out.println(MessageEnums.REGISTER_SUCCESSFULLY);
        }
    }
    @Override
    public long login() {
      String email = inputString("Enter Email: ");
      for(int i =0; i<Global.customers.length; i++){
          if(Global.customers[i].getEmail().equals(email)) {
              if(!(Global.customers[i].isBlockStatus())) {
                  for (int j=0; j<3; j++){
                      String pass  = inputString("Enter Password: ");
                      if (Global.customers[i].getPassWord().equals(pass)) {
                          System.out.println("Welcome dear: " + Global.customers[i].getName());
                          Global.customers[i].setAttemps(0);
                          Global.customers[i].setBlockStatus(false);
                          return Global.customers[i].getId();
                      } else {
                          Global.customers[i].setAttemps(Global.customers[i].getAttemps() + 1);
                      }
              }
                  if(Global.customers[i].getAttemps() == 3){
                      Global.customers[i].setBlockStatus(true);
                      throw new AllExcpetions(ExceptionsEnums.CUSTOMER_BLOCKED);
                  }
                  }else{
                  throw new AllExcpetions(ExceptionsEnums.CUSTOMER_BLOCKED);
              }
              }
              }
        return 0;
      }
    @Override
    public void updateMyDetails(long id, byte choose) {
        for(int i=0; i<Global.customers.length; i++){
            if(Global.customers[i].getId() == id){
                switch (choose){
                    case 1:  //name
                        Global.customers[i].setName(inputString("Enter new name: "));
                        Global.customers[i].setRegistryDate(null);
                        Global.customers[i].setUpdateDate(LocalDateTime.now());
                        System.out.println(MessageEnums.SUCCESSFULLY_CHANGED);
                        byte loggedChoose = inputByte("[1] ->Show My Details\n[2] -> Update My Details\n[3] -> Operations\n[4] -> Logout\n Choose Order: ");
                        loggedMenu(loggedChoose, id);

                        break;
                    case 2: //surname
                        Global.customers[i].setSurName(inputString("Enter new surname: "));
                        Global.customers[i].setRegistryDate(null);
                        Global.customers[i].setUpdateDate(LocalDateTime.now());
                        System.out.println(MessageEnums.SUCCESSFULLY_CHANGED);
                        loggedChoose = inputByte("[1] ->Show My Details\n[2] -> Update My Details\n[3] -> Operations\n[4] -> Logout\n Choose Order: ");
                        loggedMenu(loggedChoose, id);
                        break;
                    case 3: // email
                        try {
                            Global.customers[i].setEmail(CustomerHelper.checkEmail(inputString("Enter new Email: ")));
                            Global.customers[i].setRegistryDate(null);
                            Global.customers[i].setUpdateDate(LocalDateTime.now());
                            System.out.println(MessageEnums.SUCCESSFULLY_CHANGED);
                            loggedChoose = inputByte("[1] ->Show My Details\n[2] -> Update My Details\n[3] -> Operations\n[4] -> Logout\n Choose Order: ");
                            loggedMenu(loggedChoose, id);
                        }catch (AllExcpetions ex){
                            System.out.println(ex.getMessage());
                            byte updateChoose = inputByte("[1] -> Update Name\n[2] -> Update Surname\n[3] -> Update Email\n[4] -> Update Password\n[5] -> Update All\n Choose Order: ");
                            updateMyDetails(id, updateChoose);
                        }
                        break;

                    case 4: // password
                        try {
                            Global.customers[i].setPassWord(changePassword(id, inputString("Enter old passWord")));
                            System.out.println(MessageEnums.SUCCESSFULLY_CHANGED);
                            loggedChoose = inputByte("[1] ->Show My Details\n[2] -> Update My Details\n[3] -> Operations\n[4] -> Logout\n Choose Order: ");
                            loggedMenu(loggedChoose, id);
                        }catch (AllExcpetions ex){
                            System.out.println(ex.getMessage());
                            byte updateChoose = inputByte("[1] -> Update Name\n[2] -> Update Surname\n[3] -> Update Email\n[4] -> Update Password\n[5] -> Update All\n Choose Order: ");
                            updateMyDetails(id, updateChoose);
                        }
                          break;

                    case 5:
                        try {
                            Global.customers[i].setName(inputString("Enter new name: "));
                            Global.customers[i].setSurName(inputString("Enter new Surname: "));
                            Global.customers[i].setEmail(CustomerHelper.checkEmail(inputString("Enter new Email: ")));
                            Global.customers[i].setPassWord(changePassword(id, inputString("Enter old Password: ")));
                            loggedChoose = inputByte("[1] ->Show My Details\n[2] -> Update My Details\n[3] -> Operations\n[4] -> Logout\n Choose Order: ");
                            loggedMenu(loggedChoose, id);
                        }catch (AllExcpetions ex){
                            System.out.println(ex.getMessage());
                            byte updateChoose = inputByte("[1] -> Update Name\n[2] -> Update Surname\n[3] -> Update Email\n[4] -> Update Password\n[5] -> Update All\n Choose Order: ");
                            updateMyDetails(id, updateChoose);
                        }
                        break;
                    default:
                        throw new AllExcpetions(ExceptionsEnums.WRONG_ORDER);
                }
            }
        }
    }

    @Override
    public void showMyDetails(long id) {
      for (int i=0; i<Global.customers.length; i++){
          if(Global.customers[i].getId() == id){
              System.out.println(Global.customers[i]);
              byte loggedChoose = inputByte("[1] ->Show My Details\n[2] -> Update My Details\n[3] -> Operations\n[4] -> Logout\n Choose Order: ");
              MenuUtil.loggedMenu(loggedChoose, id);
              break;
          }
      }
    }
    @Override
    public void logOut() {
        System.out.println("*****   "+ MessageEnums.SUCCESSFULLY_LOGOUT+"   *****");
        byte menuChoose = inputByte("[1] -> Exit\n[2] -> Register\n[3] -> Login\n[4] -> Increase Balans\n Choose Order: ");
        menu(menuChoose);

    }
}
