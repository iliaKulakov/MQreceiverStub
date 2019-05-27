package io.github.mqrecieverstub.listener.web;


import io.github.mqrecieverstub.listener.domain.BankSystemsDomain;
import io.github.mqrecieverstub.listener.dto.BankSystemInfoDto;
import io.github.mqrecieverstub.listener.repository.BankSystemInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuration")
public class ConfigController {

    private BankSystemInfoRepository bankSystemInfoRepository;

    @Autowired
    public ConfigController(BankSystemInfoRepository bankSystemInfoRepository) {
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
