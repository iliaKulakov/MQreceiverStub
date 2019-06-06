package io.github.mqrecieverstub.listener.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "configuration_info")
public class BankSystemInfo implements Serializable {

    @Id
    @SequenceGenerator(name = "configuration_seq", sequenceName = "configuration_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "configuration_seq")
    private long id;

    @NotNull(message = "value can't be empty")
    @Column(name = "bank_system_one_id")
    private int bankSystemOne;

    @NotNull(message = "value can't be empty")
    @Column(name = "default_bank_system_one_id")
    private int defaultBankSystemOne;

    @Column(name = "bank_system_two_id")
    private int bankSystemTwo;

    @NotNull(message = "value can't be empty")
    @Column(name = "default_bank_system_two_id")
    private int defaultBankSystemTwo;

    public BankSystemInfo(@NotNull(message = "value can't be empty") int bankSystemOne, @NotNull(message = "value can't be empty") int defaultBankSystemOne, int bankSystemTwo, @NotNull(message = "value can't be empty") int defaultBankSystemTwo) {
        this.bankSystemOne = bankSystemOne;
        this.defaultBankSystemOne = defaultBankSystemOne;
        this.bankSystemTwo = bankSystemTwo;
        this.defaultBankSystemTwo = defaultBankSystemTwo;
    }
}
