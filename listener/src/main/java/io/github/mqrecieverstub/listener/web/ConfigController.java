package io.github.mqrecieverstub.listener.web;


import io.github.mqrecieverstub.listener.domain.BankSystemInfo;
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

//    TODO: тут вручную мапить не надо. RequestBody делает все сам
    @ResponseBody
    @PostMapping
    public BankSystemInfo createBankSystemDatabaseRecord(@RequestBody BankSystemInfoDto bankSystemInfoDto) {

        BankSystemInfo bankSystemInfo = this.bankSystemInfoRepository.findDistinctFirstById(1);

        bankSystemInfo.setBankSystemOne(bankSystemInfoDto.getBankSystemOne());
        bankSystemInfo.setDefaultBankSystemOne(bankSystemInfoDto.getDefaultBankSystemOne());
        bankSystemInfo.setBankSystemTwo(bankSystemInfoDto.getBankSystemTwo());
        bankSystemInfo.setDefaultBankSystemTwo(bankSystemInfoDto.getDefaultBankSystemTwo());

        bankSystemInfo = this.bankSystemInfoRepository.save(bankSystemInfo);
        return bankSystemInfo;
    }

    @ResponseBody
    @GetMapping
    public List<BankSystemInfo> getAllBankSystems() {
        List<BankSystemInfo> bankSystemInfos = bankSystemInfoRepository.findAll();

        return bankSystemInfos;
    }

}
