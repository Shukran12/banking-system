package Helper;

import Data.Global;
import Enums.ExceptionsEnums;
import Exceptions.AllExcpetions;
import Model.Card;
import Model.Customer;

import static Helper.CardHelper.fillCard;
import static Util.InputUtil.inputString;

public class CustomerHelper {
    public static long id;
    public static Customer fillCustomer(){
        try {
            String name = inputString("Enter Name: ");
            String surName = inputString("Enter Surname: ");
            String email = checkEmail(inputString("Enter email: "));
            String password = inputString("Enter Password: ");
            Card card = fillCard();
            Card[] tempCard = new Card[Global.cards.length + 1];
            for(int i=0; i<Global.cards.length; i++){
                tempCard[i] = Global.cards[i];
            }
            tempCard[Global.customers.length] = card;
            Global.cards = tempCard;
            return new Customer(++id, name, surName, email, password, card);
        }catch (AllExcpetions ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static String checkEmail(String email){
        String[] emailLetter = email.split("");
        boolean isEmail = false;
        for(int i=0; i<emailLetter.length; i++){
            if(emailLetter[i].equals("@")){
                isEmail = true;
            }
        }

        for(int i=0; i< Global.customers.length; i++){
            if(Global.customers[i].getEmail().equals(email)){
                throw new AllExcpetions(ExceptionsEnums.EMAIL_EXIST);
            }
        }
        if(isEmail){
            return email;
        }else{
            throw new AllExcpetions(ExceptionsEnums.WRONG_FORMAT_EMAIL);
        }



    }
    public static String changePassword(long id, String pass){

        for(int i=0; i< Global.customers.length; i++){
            if(Global.customers[i].getId() == id){
                if(Global.customers[i].getPassWord().equals(pass)){
                    return inputString("Enter new password: ");
                }
            }
        }
        throw new AllExcpetions(ExceptionsEnums.PASSWORD_NOT_MATCH);
    }






}
