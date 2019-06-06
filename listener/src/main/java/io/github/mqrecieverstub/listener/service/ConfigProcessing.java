package io.github.mqrecieverstub.listener.service;

import io.github.mqrecieverstub.listener.domain.BankSystemInfo;
import io.github.mqrecieverstub.listener.repository.BankSystemInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ConfigProcessing {
//    TODO: Константы всегда лучше сразу FIINAL делать и старайся все перменные закрывать
    private final BankSystemInfo defaultConfingVar = new BankSystemInfo(0, 0, 0, 0);
    private BankSystemInfoRepository bankSystemInfoRepository;

    @Autowired
    public ConfigProcessing(BankSystemInfoRepository bankSystemInfoRepository) {
        this.bankSystemInfoRepository = bankSystemInfoRepository;
    }

    public BankSystemInfo getConfigInfoFromDb() {
        List<BankSystemInfo> bankSystemInfos = bankSystemInfoRepository.findAll();

        Stream<BankSystemInfo> bankSystemDomainsStream = bankSystemInfos.stream();
        Comparator<BankSystemInfo> comparator = Comparator.comparing(BankSystemInfo::getId);

        Optional<BankSystemInfo> result = bankSystemDomainsStream.max(comparator);

        return result.orElseGet(() -> defaultConfingVar);

    }

    public void putDefaultConfigInfoInDatabase() {
        List<BankSystemInfo> bankSystemInfos = bankSystemInfoRepository.findAll();
        if (bankSystemInfos.size() <= 0) {
            bankSystemInfoRepository.save(defaultConfingVar);
        }

    }

}
