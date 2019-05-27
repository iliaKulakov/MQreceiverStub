package listener.controller.repo;

import listener.controller.domain.BankSystemsDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface BankSystemInfoRepository extends JpaRepository<BankSystemsDomain, Long> {

        BankSystemsDomain findBankSystemsDomainById(Long id);

        BankSystemsDomain findBankSystemsDomainById(int id);
    }

