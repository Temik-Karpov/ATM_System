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
public class AuthorizationController extends ATMController {

    public AuthorizationController(final BankAccountOwnerRepo bankAccountOwnerRepo,
                                   final TripleDES tripleDES,
                                   final BankAccountOwnerAuthInfoRepo bankAccountOwnerAuthInfoRepo) {
        super(bankAccountOwnerRepo, tripleDES, bankAccountOwnerAuthInfoRepo);
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginInfo") final BankAccountOwnerAuthInfo bankAccountOwnerAuthInfo,
                        final Model model)
    {
        final String login = bankAccountOwnerAuthInfo.getBankAccountOwnerLogin();
        final BankAccountOwnerAuthInfo owner = bankAccountOwnerAuthInfoRepo.findByBankAccountOwnerLogin(login);
        if(owner == null) {
            //TODO: валидация нужна
            return "redirect:/authorizationPage";
        }
        final String password = tripleDES.decrypt(owner.getBankAccountOwnerPassword());
        return bankAccountOwnerAuthInfo.getBankAccountOwnerPassword().equals(password) ? "redirect:/authProfilePage" :
                 "redirect:/authorizationPage";
    }
}
