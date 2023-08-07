package ru.karpov.ATM.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.karpov.ATM.models.BankAccountOwnerAuthInfo;

@Repository
public interface BankAccountOwnerAuthInfoRepo extends JpaRepository<BankAccountOwnerAuthInfo, Long> {
}
