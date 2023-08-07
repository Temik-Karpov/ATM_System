package ru.karpov.ATM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.karpov.ATM.Security.TripleDES;
import ru.karpov.ATM.repos.BankAccountOwnerAuthInfoRepo;
import ru.karpov.ATM.repos.BankAccountOwnerRepo;

@Controller
abstract class ATMController {
    protected final BankAccountOwnerRepo bankAccountOwnerRepo;
    protected final TripleDES tripleDES;
    protected final BankAccountOwnerAuthInfoRepo bankAccountOwnerAuthInfoRepo;

    @Autowired
    public ATMController(final BankAccountOwnerRepo bankAccountOwnerRepo, final TripleDES tripleDES,
                         final BankAccountOwnerAuthInfoRepo bankAccountOwnerAuthInfoRepo)
    {
        this.bankAccountOwnerRepo = bankAccountOwnerRepo;
        this.tripleDES = tripleDES;
        this.bankAccountOwnerAuthInfoRepo = bankAccountOwnerAuthInfoRepo;
    }
}
