package Enums;

public enum ChashEnum {
    Azn500(500),
    Azn200(200),
    Azn100(100),
    Azn50(50),
    Azn20(20),
    Azn10(10),
    Azn5(5),
    Azn1(1);

    int chash;
    ChashEnum(int cash){
        this.chash = cash;
    }

    public int getChash() {
        return chash;
    }
}
