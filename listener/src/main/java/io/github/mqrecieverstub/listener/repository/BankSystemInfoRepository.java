package io.github.mqrecieverstub.listener.repository;

import io.github.mqrecieverstub.listener.domain.BankSystemsDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BankSystemInfoRepository extends JpaRepository<BankSystemsDomain, Long> {

    BankSystemsDomain findBankSystemsDomainById(Long id);

    BankSystemsDomain findBankSystemsDomainById(int id);

//    @Query("select * from configuration_info e where e.salary > :salary")
    BankSystemsDomain findBankSystemsDomainByIdorOrderByIdDesc(Long id);
    BankSystemsDomain findBankSystemsDomainByIdorOrderByIdDesc(int id);
}

