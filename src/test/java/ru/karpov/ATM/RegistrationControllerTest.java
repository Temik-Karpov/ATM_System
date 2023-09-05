package ru.karpov.ATM;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.karpov.ATM.Security.TripleDES;
import ru.karpov.ATM.controllers.RegistrationController;
import ru.karpov.ATM.models.BankAccountOwnerAuthInfo;
import ru.karpov.ATM.repos.BankAccountOwnerAuthInfoRepo;
import ru.karpov.ATM.repos.BankAccountOwnerRepo;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class RegistrationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testRegisterBankAccountOwnerWithCorrectData() throws Exception {
        BankAccountOwnerAuthInfo bankAccountOwnerAuthInfo = new BankAccountOwnerAuthInfo("123", "345");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(bankAccountOwnerAuthInfo);

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .param("BankAccountOwnerLogin", "123")
                .param("BankAccountOwnerPassword","345"))
                .andDo(print())
                .andExpect(redirectedUrl("/addBankAccountOwnerInfo"));
    }

    @Test
    public void testRegisterBankAccountOwnerWithEmptyLogin() throws Exception {
        BankAccountOwnerAuthInfo bankAccountOwnerAuthInfo = new BankAccountOwnerAuthInfo("123", "345");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(bankAccountOwnerAuthInfo);

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .param("BankAccountOwnerLogin", "")
                .param("BankAccountOwnerPassword","345"))
                .andDo(print())
                .andExpect(redirectedUrl("/registrationPage"));
    }

    @Test
    public void testRegisterBankAccountOwnerWithEmptyPassword() throws Exception {
        BankAccountOwnerAuthInfo bankAccountOwnerAuthInfo = new BankAccountOwnerAuthInfo("123", "345");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(bankAccountOwnerAuthInfo);

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .param("BankAccountOwnerLogin", "123")
                .param("BankAccountOwnerPassword",""))
                .andDo(print())
                .andExpect(redirectedUrl("/registrationPage"));
    }
}
