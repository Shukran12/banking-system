package Service;

public interface CustomerService {
    void registr();
    long login();
    void updateMyDetails(long id, byte choose);
    void showMyDetails(long id);
    void logOut();

}
