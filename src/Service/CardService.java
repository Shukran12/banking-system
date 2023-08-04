package Service;

public interface CardService {
    void showBalance(long id);
    void cashOut(long id, int cash);
    void increaseBalance(String card);
}
