package io.github.mqrecieverstub.listener.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankSystemInfoDto implements Serializable {

    private int bankSystemOne;
    private int defaultBankSystemOne;
    private int bankSystemTwo;
    private int defaultBankSystemTwo;
}
