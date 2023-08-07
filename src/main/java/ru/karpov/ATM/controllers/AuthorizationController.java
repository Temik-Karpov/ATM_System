package ru.karpov.ATM.controllers;

import org.springframework.stereotype.Controller;
import ru.karpov.ATM.Security.TripleDES;
import ru.karpov.ATM.repos.BankAccountOwnerAuthInfoRepo;
import ru.karpov.ATM.repos.BankAccountOwnerRepo;

@Controller
public class AuthorizationController extends GetPagesController {

    public AuthorizationController(final BankAccountOwnerRepo bankAccountOwnerRepo,
                                   final TripleDES tripleDES,
                                   final BankAccountOwnerAuthInfoRepo bankAccountOwnerAuthInfoRepo) {
        super(bankAccountOwnerRepo, tripleDES, bankAccountOwnerAuthInfoRepo);
    }

}
