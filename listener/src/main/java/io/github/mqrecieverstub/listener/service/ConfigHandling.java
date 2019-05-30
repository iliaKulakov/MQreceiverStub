package io.github.mqrecieverstub.listener.service;

import io.github.mqrecieverstub.listener.domain.BankSystemsDomain;
import io.github.mqrecieverstub.listener.repository.BankSystemInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ConfigHandling {

    private BankSystemInfoRepository bankSystemInfoRepository;

    @Autowired
    public ConfigHandling(BankSystemInfoRepository bankSystemInfoRepository) {
        this.bankSystemInfoRepository = bankSystemInfoRepository;
    }

    public BankSystemsDomain getConfigInfoFromDb() {
        List<BankSystemsDomain> bankSystemsDomains = bankSystemInfoRepository.findAll();
        Stream bankSystemDomainsStream = bankSystemsDomains.stream();

        Comparator<BankSystemsDomain> comparator = Comparator.comparing(BankSystemsDomain::getId);

        BankSystemsDomain maxBankSystemDomainfromDb = (BankSystemsDomain) bankSystemDomainsStream
                .max(comparator)
                .get();

        return maxBankSystemDomainfromDb;
    }


}
