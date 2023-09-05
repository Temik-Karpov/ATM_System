package ru.karpov.ATM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.karpov.ATM.Security.TripleDES;
import ru.karpov.ATM.repos.BankAccountOwnerAuthInfoRepo;
import ru.karpov.ATM.repos.BankAccountOwnerRepo;

@WebMvcTest
public class ATMControllerTest {
    protected final BankAccountOwnerRepo bankAccountOwnerRepo;
    protected final TripleDES tripleDES;
    protected final BankAccountOwnerAuthInfoRepo bankAccountOwnerAuthInfoRepo;

    @Autowired
    public ATMControllerTest(final BankAccountOwnerRepo bankAccountOwnerRepo,
                             final TripleDES tripleDES,
                             final BankAccountOwnerAuthInfoRepo bankAccountOwnerAuthInfoRepo) {
        this.bankAccountOwnerRepo = bankAccountOwnerRepo;
        this.tripleDES = tripleDES;
        this.bankAccountOwnerAuthInfoRepo = bankAccountOwnerAuthInfoRepo;
    }
}
