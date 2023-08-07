package ru.karpov.ATM.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.karpov.ATM.Security.TripleDES;
import ru.karpov.ATM.models.BankAccountOwnerAuthInfo;
import ru.karpov.ATM.repos.BankAccountOwnerAuthInfoRepo;
import ru.karpov.ATM.repos.BankAccountOwnerRepo;

@Controller
public class RegistrationController extends GetPagesController {

    public RegistrationController(final BankAccountOwnerRepo bankAccountOwnerRepo,
                                  final TripleDES tripleDES,
                                  final BankAccountOwnerAuthInfoRepo bankAccountOwnerAuthInfoRepo) {
        super(bankAccountOwnerRepo, tripleDES, bankAccountOwnerAuthInfoRepo);
    }

    @PostMapping("/register")
    public String registerBankAccountOwner(@ModelAttribute(name="authInfo") final BankAccountOwnerAuthInfo bankAccountOwnerAuthInfo,
                                           final Model model)
    {
        final String encryptPassword = tripleDES.encrypt(bankAccountOwnerAuthInfo.getBankAccountOwnerPassword());
        bankAccountOwnerAuthInfo.setBankAccountOwnerPassword(encryptPassword);
        bankAccountOwnerAuthInfoRepo.save(bankAccountOwnerAuthInfo);
        return "main";  //TODO: поменять
    }
}
