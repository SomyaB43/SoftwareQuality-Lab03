package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("10001"));
    }
	@Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    @Test
    public void multiplyJson() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1", "1101").param("operand2", "1010"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value("1101"))
            .andExpect(jsonPath("$.operand2").value("1010"))
            .andExpect(jsonPath("$.result").value("10000010"))
            .andExpect(jsonPath("$.operator").value("multiply"));
    }

@Test
public void Logical_OR() throws Exception {
    mvc.perform(get("/logical_or_json")
            .param("operand1", "1010")
            .param("operand2", "1101"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$.operand1").value("1010"))
            .andExpect(jsonPath("$.operator").value("logical_or"))
            .andExpect(jsonPath("$.operand2").value("1101"))
            .andExpect(jsonPath("$.result").value("1111"));
}

@Test
   public void logical_or_json() throws Exception {
    this.mvc.perform(get("/logical_or_json").param("operand1", "1010").param("operand2", "1101"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.operand1").value("1010"))
        .andExpect(jsonPath("$.operand2").value("1101"))
        .andExpect(jsonPath("$.result").value("1111"))
        .andExpect(jsonPath("$.operator").value("logical_or"));
}

@Test
public void logical_and_json() throws Exception {
    this.mvc.perform(get("/logical_and_json").param("operand1", "1010").param("operand2", "1101"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.operand1").value("1010"))
        .andExpect(jsonPath("$.operand2").value("1101"))
        .andExpect(jsonPath("$.result").value("1000"))
        .andExpect(jsonPath("$.operator").value("logical_and"));
}
}