package Service.Impl;

import Data.Global;
import Enums.ExceptionsEnums;
import Enums.MessageEnums;
import Exceptions.AllExcpetions;
import Helper.CardHelper;
import Service.CardService;

import java.time.LocalDateTime;
import java.util.Arrays;

import static Util.InputUtil.inputInt;

public class CardServiceImpl implements CardService {
    @Override
    public void showBalance(long id) {
        for(int i=0; i< Global.customers.length; i++){
            if(Global.customers[i].getId() == id){
                System.out.println(Global.customers[i].getCard().getCurrentBalance());
                break;
            }
        }
    }

    @Override
    public void cashOut(long id, int cash) {
     for(int i=0; i<Global.customers.length; i++){
         if(Global.customers[i].getId() == id){
             if(Global.customers[i].getCard().getCurrentBalance() > cash){
                 Global.customers[i].getCard().setCurrentBalance(Global.customers[i].getCard().getCurrentBalance() - cash);
                 CardHelper.calculateCash(cash);

                 System.out.println("---- Increament Receipt ---- \nDate&Time: "+ LocalDateTime.now()+"\nCardnumber:"+CardHelper.maskedCard(Global.customers[i].getCard().getCardNumber()) +"\nCash: " + cash+"\nTotal Balance: "+ (Global.customers[i].getCard().getCurrentBalance() - cash));
                 System.out.println(MessageEnums.OPERATION_SUCCESSFULLY);

             }else{
                 throw new AllExcpetions(ExceptionsEnums.LACKOFFUNDS);
             }
         }
     }
    }

    @Override
    public void increaseBalance(String card) {
        for(int i=0; i<Global.cards.length; i++){
            if(Global.cards[i].getCardNumber().equals(card)){
                int balance =  inputInt("Enter cash: ");
                Global.cards[i].setCurrentBalance(balance);
                System.out.println(MessageEnums.BALANCE_INCREASED);
            }else if(i==Global.cards.length-1 && !Global.cards[i].getCardNumber().equals(card)){
                throw new AllExcpetions(ExceptionsEnums.CARD_NOT_FOUND);
            }
        }

        }
    }

