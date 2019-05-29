package io.github.mqrecieverstub.listener.service;

import io.github.mqrecieverstub.listener.domain.BankSystemsDomain;
import io.github.mqrecieverstub.listener.repository.BankSystemInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigHandling {

    private BankSystemInfoRepository bankSystemInfoRepository;

    @Autowired
    public ConfigHandling(BankSystemInfoRepository bankSystemInfoRepository) {
        this.bankSystemInfoRepository = bankSystemInfoRepository;
    }

    public List<BankSystemsDomain> getConfigInfoFrom(){
        List<BankSystemsDomain> bankSystemsDomains = bankSystemInfoRepository.findAll();
        bankSystemInfoRepository.
            return bankSystemsDomains;
    }

    public void getBankSystemOneInfoFromDatabase(){


    }

}
