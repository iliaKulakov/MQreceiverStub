package io.github.mqrecieverstub.listener.service;

import io.github.mqrecieverstub.listener.domain.BankSystemsDomain;
import io.github.mqrecieverstub.listener.repository.BankSystemInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ConfigProcessing {
    private BankSystemInfoRepository bankSystemInfoRepository;

    @Autowired
    public ConfigProcessing(BankSystemInfoRepository bankSystemInfoRepository) {
        this.bankSystemInfoRepository = bankSystemInfoRepository;
    }

    BankSystemsDomain getConfigInfoFromDb() {
        List<BankSystemsDomain> bankSystemsDomains = bankSystemInfoRepository.findAll();
        //TODO: Тут надо сразу определять тип
        Stream<BankSystemsDomain> bankSystemDomainsStream = bankSystemsDomains.stream();

        Comparator<BankSystemsDomain> comparator = Comparator.comparing(BankSystemsDomain::getId);

        //TODO: Тут возращается optional. Почему ты сразу возращаешь объект без проверки?
        return bankSystemDomainsStream
                .max(comparator)
                .get();
    }
}
