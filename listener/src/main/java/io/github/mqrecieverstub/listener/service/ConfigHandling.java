package io.github.mqrecieverstub.listener.service;

import io.github.mqrecieverstub.listener.repository.BankSystemInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigHandling {

    private BankSystemInfoRepository bankSystemInfoRepository;

    @Autowired
    public ConfigHandling(BankSystemInfoRepository bankSystemInfoRepository) {
        this.bankSystemInfoRepository = bankSystemInfoRepository;
    }

    public void getConfigInfoFromDatabase(){

    }

}
