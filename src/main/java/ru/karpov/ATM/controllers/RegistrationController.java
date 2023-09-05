package ru.karpov.ATM.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.karpov.ATM.Security.TripleDES;
import ru.karpov.ATM.models.BankAccountOwnerAuthInfo;
import ru.karpov.ATM.repos.BankAccountOwnerAuthInfoRepo;
import ru.karpov.ATM.repos.BankAccountOwnerRepo;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class RegistrationController extends ATMController {

    public RegistrationController(final BankAccountOwnerRepo bankAccountOwnerRepo,
                                  final TripleDES tripleDES,
                                  final BankAccountOwnerAuthInfoRepo bankAccountOwnerAuthInfoRepo) {
        super(bankAccountOwnerRepo, tripleDES, bankAccountOwnerAuthInfoRepo);
    }

    @PostMapping("/hello")
    public String test(final Integer number)
    {
        return "redirect:/registrationPage";
    }

    @PostMapping("/register")
    public String registerBankAccountOwner(@ModelAttribute("registerInfo") @Valid
                                               final BankAccountOwnerAuthInfo bankAccountOwnerAuthInfo,
                                           final BindingResult bindingResult,
                                           final Model model)
    {
        if(bindingResult.hasErrors())
        {
            return "redirect:/registrationPage";
        }
        final String encryptPassword = tripleDES.encrypt(bankAccountOwnerAuthInfo.getBankAccountOwnerPassword());
        bankAccountOwnerAuthInfo.setBankAccountOwnerPassword(encryptPassword);
        bankAccountOwnerAuthInfo.setId(UUID.randomUUID().toString());
        bankAccountOwnerAuthInfoRepo.save(bankAccountOwnerAuthInfo);
        return "redirect:/addBankAccountOwnerInfo";
    }
}
