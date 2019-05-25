package listener.controller.domain;


import org.springframework.context.annotation.Bean;

public class BankSystemsDomain {

    private int BankSystemOne = 1;
    private int BankSystemTwo = 1;

    public BankSystemsDomain() {
    }

    public BankSystemsDomain(int bankSystemOne, int bankSystemTwo) {
        BankSystemOne = bankSystemOne;
        BankSystemTwo = bankSystemTwo;
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

    @Override
    public String toString() {
        return "BankSystemsDomain{" +
                "BankSystemOne=" + BankSystemOne +
                ", BankSystemTwo=" + BankSystemTwo +
                '}';
    }
}
