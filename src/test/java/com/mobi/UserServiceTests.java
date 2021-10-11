package com.mobi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobi.domain.Users;
import com.mobi.services.VotoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private VotoService votoService;

    /**
     * Este simples teste está aqui apenas para demonstrar um método. Esta aplicação necessitaria
     * de muito mais testes porém o tempo estava curto demais.
     *
     * @throws Exception
     */
    @Test
    void case1() throws Exception {

        Users user = new Users();
        user.setUsername("Test");
        user.setCpf("73766667297");

        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }

}


