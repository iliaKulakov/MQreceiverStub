package listener.controller.domain;


import org.springframework.context.annotation.Bean;

public class BankSystemsDomain {

    private int BankSystemOne = 1;
    private int BankSystemTwo = 1;
    private static volatile BankSystemsDomain instance;

    public BankSystemsDomain() {
    }

    public BankSystemsDomain(int bankSystemOne, int bankSystemTwo) {
        BankSystemOne = bankSystemOne;
        BankSystemTwo = bankSystemTwo;
    }

    public static BankSystemsDomain getInstance() {
        BankSystemsDomain localInstance = instance;
        if (localInstance == null) {
            synchronized (BankSystemsDomain.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new BankSystemsDomain();
                }
            }
        }
        return localInstance;
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
