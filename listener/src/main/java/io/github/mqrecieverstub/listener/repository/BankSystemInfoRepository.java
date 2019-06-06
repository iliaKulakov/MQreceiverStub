package io.github.mqrecieverstub.listener.repository;

import io.github.mqrecieverstub.listener.domain.BankSystemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankSystemInfoRepository extends JpaRepository<BankSystemInfo, Long> {

    BankSystemInfo findDistinctFirstById(long id);

}

