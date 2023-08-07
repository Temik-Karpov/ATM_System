package ru.karpov.ATM.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.karpov.ATM.models.BankAccountOwner;

@Repository
public interface BankAccountOwnerRepo extends JpaRepository<BankAccountOwner, Long> {

}
