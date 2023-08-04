package Enums;

public enum MessageEnums {
    REGISTER_SUCCESSFULLY("Register Succesfully"),
    SUCCESSFULLY_CHANGED("Successfully changed"),
    SUCCESSFULLY_LOGOUT("Log out successfully"),
    BALANCE_INCREASED("Balance Successfuly increase"),
    OPERATION_SUCCESSFULLY("Operation Successfully");
    String message;
    MessageEnums(String message){
        this.message = message;
    }
}
