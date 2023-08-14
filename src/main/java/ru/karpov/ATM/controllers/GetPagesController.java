package ru.karpov.ATM.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.karpov.ATM.Security.TripleDES;
import ru.karpov.ATM.repos.BankAccountOwnerAuthInfoRepo;
import ru.karpov.ATM.repos.BankAccountOwnerRepo;

@Controller
public class GetPagesController extends ATMController {

    public GetPagesController(final BankAccountOwnerRepo bankAccountOwnerRepo,
                              final TripleDES tripleDES,
                              final BankAccountOwnerAuthInfoRepo bankAccountOwnerAuthInfoRepo) {
        super(bankAccountOwnerRepo, tripleDES, bankAccountOwnerAuthInfoRepo);
    }

    @GetMapping("/authorizationPage")
    public String getAuthorizationPage()
    {
        return "authorizationPage";
    }

    @GetMapping("/registrationPage")
    public String getRegistrationPage()
    {
        return "registrationPage";
    }
}
