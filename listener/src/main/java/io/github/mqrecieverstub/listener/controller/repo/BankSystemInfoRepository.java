package io.github.mqrecieverstub.listener.controller.repo;

import io.github.mqrecieverstub.listener.controller.domain.BankSystemsDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankSystemInfoRepository extends JpaRepository<BankSystemsDomain, Long> {

    BankSystemsDomain findBankSystemsDomainById(Long id);

    BankSystemsDomain findBankSystemsDomainById(int id);
}

