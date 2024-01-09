package com.michael.webapi.UnitTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class SimpleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test   
    public void testGreetEndpoint() throws Exception
    {
        mockMvc.perform(get("/api/greet"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, welcome to the Spring Boot REST API!"));
    }

    @Test
    public void testEchoEndpoint() throws Exception {
        String message = "Testing echo endpoint";
        mockMvc.perform(get("/api/echo").param("message", message))
               .andExpect(status().isOk())
               .andExpect(content().string(message));
    }

    @Test
    public void testSquareEndpoint() throws Exception {
        double number = 5.0;
        mockMvc.perform(get("/api/square").param("number", String.valueOf(number)))
               .andExpect(status().isOk())
               .andExpect(content().string(String.valueOf(Math.sqrt(number))));
    }

    @Test
    public void testSquareEndpointWithInvalidParameter() throws Exception {
        // Invalid number
        mockMvc.perform(get("/api/square").param("number", "-9"))
               .andExpect(status().isBadRequest());
    }

    @Test
    public void testSquareEndpointWithMissingParameter() throws Exception {
        // Missing parameter
        mockMvc.perform(get("/api/square"))
               .andExpect(status().isBadRequest());
    }

}
