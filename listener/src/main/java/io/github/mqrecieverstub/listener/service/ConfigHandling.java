package io.github.mqrecieverstub.listener.service;

import io.github.mqrecieverstub.listener.domain.BankSystemsDomain;
import io.github.mqrecieverstub.listener.repository.BankSystemInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class ConfigHandling {

    private BankSystemInfoRepository bankSystemInfoRepository;

    @Autowired
    public ConfigHandling(BankSystemInfoRepository bankSystemInfoRepository) {
        this.bankSystemInfoRepository = bankSystemInfoRepository;
    }

    public void getConfigInfoFromDb(){
        List<BankSystemsDomain> bankSystemsDomains = bankSystemInfoRepository.findAll();
        Stream bankSystemDomainsStream = bankSystemsDomains.stream();
        bankSystemDomainsStream.max(bankSystemInfoRepository.findBankSystemsDomainById()).toString();
        System.out.println(bankSystemDomainsStream);
    }



}
