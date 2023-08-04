package Model;
import java.time.LocalDateTime;

public class Card {
    private long id;
    private String  cardNumber;
    private int currentBalance;
    private LocalDateTime updateTime;
    public Card(long id, String cardNumber) {
        this.id = id;
        this.cardNumber = cardNumber;
    }

    public Card() {
    }

    public long getId() {
        return id;
    }

    public String  getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", currentBalance=" + currentBalance +
                ", updateTime=" + updateTime +
                '}';
    }
}


