package Model;

import java.time.LocalDateTime;

public class Customer {
    private long id;
    private String name;
    private String surName;
    private String email;
    private String passWord;
    private boolean status;
    private boolean blockStatus;
    private LocalDateTime registryDate;
    private LocalDateTime updateDate;

    private  int attemps;
   private Card card;

    public Customer(long id, String name, String surName, String email, String passWord, Card card) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.passWord = passWord;
        this.status = true;
        this.registryDate = LocalDateTime.now();
        this.card = card;
    }

    public int getAttemps() {
        return attemps;
    }

    public void setAttemps(int attemps) {
        this.attemps = attemps;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(boolean blockStatus) {
        this.blockStatus = blockStatus;
    }

    public LocalDateTime getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(LocalDateTime registryDate) {
        this.registryDate = registryDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Costumer{" +

                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", cardNumber='" + card.getCardNumber() + '\'' +
                '}';
    }
}
