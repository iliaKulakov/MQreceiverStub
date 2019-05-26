package listener.controller.dto;

import java.io.Serializable;

public class CreateBankSystemInfo implements Serializable {

    private int BankSystemOne = 1;
    private int BankSystemTwo = 1;

    public CreateBankSystemInfo() {
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
