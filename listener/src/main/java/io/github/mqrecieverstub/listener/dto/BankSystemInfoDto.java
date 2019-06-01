package io.github.mqrecieverstub.listener.dto;

import java.io.Serializable;

public class BankSystemInfoDto implements Serializable {

    private int bankSystemOne;
    private int bankSystemTwo;

    public BankSystemInfoDto(int bankSystemOne, int bankSystemTwo) {
        this.bankSystemOne = bankSystemOne;
        this.bankSystemTwo = bankSystemTwo;
    }

    public BankSystemInfoDto() {
    }

    public int getBankSystemOne() {
        return bankSystemOne;
    }

    public void setBankSystemOne(int bankSystemOne) {
        this.bankSystemOne = bankSystemOne;
    }

    public int getBankSystemTwo() {
        return bankSystemTwo;
    }

    public void setBankSystemTwo(int bankSystemTwo) {
        this.bankSystemTwo = bankSystemTwo;
    }

    @Override
    public String toString() {
        return "BankSystemInfoDto{" +
                "bankSystemOne=" + bankSystemOne +
                ", bankSystemTwo=" + bankSystemTwo +
                '}';
    }
}
