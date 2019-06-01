package io.github.mqrecieverstub.listener.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mqrecieverstub.listener.domain.BankSystemsDomain;
import io.github.mqrecieverstub.listener.dto.BankSystemInfoDto;
import io.github.mqrecieverstub.listener.repository.BankSystemInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuration")
public class ConfigController {

    ObjectMapper mapper = new ObjectMapper();
    private BankSystemInfoRepository bankSystemInfoRepository;
    private String json;

    @Autowired
    public ConfigController(BankSystemInfoRepository bankSystemInfoRepository) {
        this.bankSystemInfoRepository = bankSystemInfoRepository;
    }

    @ResponseBody
    @PostMapping
    public BankSystemsDomain createBankSystemDatabaseRecord(@RequestBody String json) throws Exception {

        this.json = json;
        BankSystemInfoDto bankSystemInfoDto1 = mapper.readValue(json, BankSystemInfoDto.class);
        BankSystemsDomain bankSystemsDomain = new BankSystemsDomain(bankSystemInfoDto1.getBankSystemOne(), bankSystemInfoDto1.getBankSystemTwo());
        bankSystemsDomain = this.bankSystemInfoRepository.save(bankSystemsDomain);
        return bankSystemsDomain;
    }

    @ResponseBody
    @GetMapping
    public List<BankSystemsDomain> getAllBankSystems() {
        List<BankSystemsDomain> bankSystemsDomains = bankSystemInfoRepository.findAll();

        return bankSystemsDomains;
    }

}
