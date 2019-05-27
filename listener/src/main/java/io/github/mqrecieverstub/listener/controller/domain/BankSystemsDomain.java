package io.github.mqrecieverstub.listener.controller.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "configuration_info")
public class BankSystemsDomain implements Serializable {

    @Id
    @SequenceGenerator(name = "configuration_seq", sequenceName = "configuration_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "configuration_seq")
    private long id;

    @NotNull(message = "value can't be empty")
    @Column(name = "bank_system_one_id")
    private int BankSystemOne;

    @Column(name = "bank_system_two_id")
    private int BankSystemTwo;

    public BankSystemsDomain() {
    }

    public BankSystemsDomain(@NotNull(message = "value can't be empty") int bankSystemOne, int bankSystemTwo) {
        BankSystemOne = bankSystemOne;
        BankSystemTwo = bankSystemTwo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
