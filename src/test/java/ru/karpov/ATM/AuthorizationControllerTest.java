package ru.karpov.ATM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.karpov.ATM.Security.TripleDES;
import ru.karpov.ATM.models.BankAccountOwnerAuthInfo;
import ru.karpov.ATM.repos.BankAccountOwnerAuthInfoRepo;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@SpringBootTest
@AutoConfigureMockMvc
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class AuthorizationControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private BankAccountOwnerAuthInfoRepo bankAccountOwnerAuthInfoRepo;

    @Autowired
    private WebApplicationContext context;

    private BankAccountOwnerAuthInfo bankAccountOwnerAuthInfo;

    private TripleDES tripleDES;


    @BeforeEach
    void setup() throws Exception {
        bankAccountOwnerAuthInfoRepo.deleteAll();
        bankAccountOwnerAuthInfo = new BankAccountOwnerAuthInfo("123", "345");
        tripleDES = new TripleDES();
        final String encryptPassword = tripleDES.encrypt(bankAccountOwnerAuthInfo.getBankAccountOwnerPassword());
        bankAccountOwnerAuthInfo.setBankAccountOwnerPassword(encryptPassword);
        bankAccountOwnerAuthInfo.setId(UUID.randomUUID().toString());
        bankAccountOwnerAuthInfoRepo.save(bankAccountOwnerAuthInfo);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void loginWithCorrectDataTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .param("BankAccountOwnerLogin", "123")
                .param("BankAccountOwnerPassword","345"))
                .andDo(print())
                .andExpect(redirectedUrl("/authProfilePage"));
    }

    @Test
    public void loginWithNotCorrectLoginTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .param("BankAccountOwnerLogin", "122")
                .param("BankAccountOwnerPassword","345"))
                .andDo(print())
                .andExpect(redirectedUrl("/authorizationPage"));
    }

    @Test
    public void loginWithNotCorrectPasswordTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .param("BankAccountOwnerLogin", "122")
                .param("BankAccountOwnerPassword","344"))
                .andDo(print())
                .andExpect(redirectedUrl("/authorizationPage"));
    }

    @Test
    public void loginWithEmptyLoginTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .param("BankAccountOwnerLogin", "")
                .param("BankAccountOwnerPassword","344"))
                .andDo(print())
                .andExpect(redirectedUrl("/authorizationPage"));
    }

    @Test
    public void loginWithEmptyPasswordTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .param("BankAccountOwnerLogin", "123")
                .param("BankAccountOwnerPassword",""))
                .andDo(print())
                .andExpect(redirectedUrl("/authorizationPage"));
    }
}
