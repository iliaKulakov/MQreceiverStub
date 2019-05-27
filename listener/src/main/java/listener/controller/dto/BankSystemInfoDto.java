package listener.controller.dto;

import java.io.Serializable;

public class BankSystemInfoDto implements Serializable {

    private int BankSystemOne;
    private int BankSystemTwo;

    public BankSystemInfoDto(int bankSystemOne, int bankSystemTwo) {
        BankSystemOne = bankSystemOne;
        BankSystemTwo = bankSystemTwo;
    }

    public BankSystemInfoDto() {
    }

    public int getBankSystemOne() {
        return BankSystemOne;
    }

    public void setBankSystemOne(int bankSystemOne) {
        BankSystemOne = bankSystemOne;
    }

    public int getBankSystemTwo() {
        return BankSystemTwo;
    }

    public void setBankSystemTwo(int bankSystemTwo) {
        BankSystemTwo = bankSystemTwo;
    }

}
