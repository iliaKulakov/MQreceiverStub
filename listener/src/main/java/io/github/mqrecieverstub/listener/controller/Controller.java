package io.github.mqrecieverstub.listener.controller;


import io.github.mqrecieverstub.listener.controller.domain.BankSystemsDomain;
import io.github.mqrecieverstub.listener.controller.dto.BankSystemInfoDto;
import io.github.mqrecieverstub.listener.controller.repo.BankSystemInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuration")
public class Controller {

    private BankSystemInfoRepository bankSystemInfoRepository;

    @Autowired
    public Controller(BankSystemInfoRepository bankSystemInfoRepository) {
        this.bankSystemInfoRepository = bankSystemInfoRepository;
    }

    @ResponseBody
    @PostMapping
    public BankSystemsDomain createBankSystemDatabaseRecord(BankSystemInfoDto bankSystemInfoDto) {

        BankSystemsDomain bankSystemsDomain = new BankSystemsDomain(bankSystemInfoDto.getBankSystemOne(), bankSystemInfoDto.getBankSystemTwo());
        bankSystemsDomain = bankSystemInfoRepository.save(bankSystemsDomain);
        return bankSystemsDomain;

    }

    @ResponseBody
    @GetMapping
    public List<BankSystemsDomain> getAllBankSystems() {
        List<BankSystemsDomain> bankSystemsDomains = bankSystemInfoRepository.findAll();

        return bankSystemsDomains;

    }


}
