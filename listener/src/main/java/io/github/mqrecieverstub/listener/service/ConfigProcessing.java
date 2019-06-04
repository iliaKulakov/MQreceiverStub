package io.github.mqrecieverstub.listener.service;

import io.github.mqrecieverstub.listener.domain.BankSystemsDomain;
import io.github.mqrecieverstub.listener.repository.BankSystemInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.ExhaustedRetryException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ConfigProcessing {
    private BankSystemInfoRepository bankSystemInfoRepository;

    BankSystemsDomain defaultConfingVar = new BankSystemsDomain(0,0);

    @Autowired
    public ConfigProcessing(BankSystemInfoRepository bankSystemInfoRepository) {
        this.bankSystemInfoRepository = bankSystemInfoRepository;
    }
//
//    BankSystemsDomain getConfigInfoFromDb() {
//        List<BankSystemsDomain> bankSystemsDomains = bankSystemInfoRepository.findAll();
//        //TODO: Тут надо сразу определять тип
//        Optional<Stream<BankSystemsDomain>> bankSystemDomainsStream = bankSystemsDomains.stream();
//        Comparator<BankSystemsDomain> comparator = Comparator.comparing(BankSystemsDomain::getId);
//
//        //TODO: Тут возращается optional. Почему ты сразу возращаешь объект без проверки?
//
//        Optional<BankSystemsDomain> result = bankSystemDomainsStream.max(comparator).get();
//        return result.isPresent() ? result.get() : defaultConfingVar;
//
//    }

    public BankSystemsDomain getConfigInfoFromDb() {
        List<BankSystemsDomain> bankSystemsDomains = bankSystemInfoRepository.findAll();
        //TODO: Тут надо сразу определять тип
        Stream<BankSystemsDomain> bankSystemDomainsStream = bankSystemsDomains.stream();
        Comparator<BankSystemsDomain> comparator = Comparator.comparing(BankSystemsDomain::getId);

        //TODO: Тут возращается optional. Почему ты сразу возращаешь объект без проверки?

        Optional<BankSystemsDomain> result = bankSystemDomainsStream.max(comparator);

        //Не стал удалять данное условие несмотря на то что у нас изначально есть дефолтный конфиг
        //в бд, гипотетически чтобы исключить ситуации когда нам вернется null вместо него и записать
        //дефолтную конфигурацию
        return result.orElseGet(() -> defaultConfingVar);

    }

    public void putDefaultConfigInfoInDatabase(){

        List<BankSystemsDomain> bankSystemsDomains = bankSystemInfoRepository.findAll();

        if (bankSystemsDomains.size()<=0){

            bankSystemInfoRepository.save(defaultConfingVar);
        }

    }

}
