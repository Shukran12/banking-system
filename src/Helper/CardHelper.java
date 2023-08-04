package Helper;
import Enums.ChashEnum;
import Model.Card;
import java.util.Arrays;
import java.util.Random;
public class CardHelper {
    public static long id;
    public static Card fillCard(){
        Random random  = new Random();
        String cardNumber = "41697388" + random.nextInt(8999999)+100000;
        return new Card(++id, cardNumber);
    }

    public static String calculateCash(int cash){
        ChashEnum[] cashs =ChashEnum.values();
        int qtyCurrency=0;
        int i=0;
        while(cash>0){
            if(cash / cashs[i].getChash() > 0) {
                qtyCurrency = cash / cashs[i].getChash();
                cash = cash % cashs[i].getChash();
                System.out.println("Qty: " + qtyCurrency + " - Currency: " + cashs[i].getChash());
            }
            i++;
        }
        return "";
    }

    public static String maskedCard(String card){
        String[] cardNumbers = card.split("");
        String maskedCard = "";
        for(int i=8; i<16; i++){
            cardNumbers[i] = "*";
        }
        maskedCard = Arrays.toString(cardNumbers).replace("[", "").replace(",","").replace("]", "").replace(" ", "");
        return maskedCard;
    }


}
