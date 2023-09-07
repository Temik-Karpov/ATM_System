package ru.karpov.ATM;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.karpov.ATM.models.BankAccountOwnerAuthInfo;
import ru.karpov.ATM.repos.BankAccountOwnerAuthInfoRepo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@SpringBootTest
@AutoConfigureMockMvc
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class RegistrationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BankAccountOwnerAuthInfoRepo bankAccountOwnerAuthInfoRepo;

    @Autowired
    private WebApplicationContext context;

    private BankAccountOwnerAuthInfo bankAccountOwnerAuthInfo;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        bankAccountOwnerAuthInfoRepo.deleteAll();
    }

    @Test
    public void testRegisterBankAccountOwnerWithCorrectData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .param("BankAccountOwnerLogin", "123")
                .param("BankAccountOwnerPassword","345"))
                .andDo(print())
                .andExpect(redirectedUrl("/addBankAccountOwnerInfo"));
        Assert.assertNotNull(bankAccountOwnerAuthInfoRepo.findByBankAccountOwnerLogin("123"));
    }

    @Test
    public void testRegisterBankAccountOwnerWithEmptyLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .param("BankAccountOwnerLogin", "")
                .param("BankAccountOwnerPassword","345"))
                .andDo(print())
                .andExpect(redirectedUrl("/registrationPage"));
        Assert.assertNull(bankAccountOwnerAuthInfoRepo.findByBankAccountOwnerLogin("123"));
    }

    @Test
    public void testRegisterBankAccountOwnerWithEmptyPassword() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .param("BankAccountOwnerLogin", "123")
                .param("BankAccountOwnerPassword",""))
                .andDo(print())
                .andExpect(redirectedUrl("/registrationPage"));
        Assert.assertNull(bankAccountOwnerAuthInfoRepo.findByBankAccountOwnerLogin("123"));
    }
}
