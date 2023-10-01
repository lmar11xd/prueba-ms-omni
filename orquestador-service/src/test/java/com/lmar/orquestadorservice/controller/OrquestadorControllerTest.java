package com.lmar.orquestadorservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lmar.orquestadorservice.model.dto.DominioTO;
import com.lmar.orquestadorservice.model.dto.ResponseTO;
import com.lmar.orquestadorservice.service.OrquestadorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = OrquestadorController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class OrquestadorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrquestadorService orquestadorServiceMock;

    @Autowired
    private ObjectMapper objectMapper;

    private DominioTO inputDominio;
    private DominioTO outputDominio;

    @BeforeEach
    void init() {
        inputDominio = new DominioTO();
        inputDominio.setDescripcion("Material Test 1");
        inputDominio.setCantidad(4);
        inputDominio.setPrecio(10.2);

        outputDominio = new DominioTO();
        outputDominio.setId(1);
        outputDominio.setDescripcion("Material Test 1");
        outputDominio.setCantidad(4);
        outputDominio.setPrecio(10.2);
    }

    @Test
    void validarReturnOk() throws Exception {
        ResponseEntity<ResponseTO<DominioTO>> responseController;
        given(orquestadorServiceMock.registrarDominio(ArgumentMatchers.any()))
                .willAnswer((invocation -> invocation.getArgument(0)));

        ResultActions response = mockMvc.perform(post("/api/orquestador/validar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inputDominio)));

        response.andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void validarReturnInvalidFields() throws Exception {
        inputDominio.setDescripcion("");
        inputDominio.setPrecio(130.2);
        ResponseEntity<ResponseTO<DominioTO>> responseController;
        given(orquestadorServiceMock.registrarDominio(ArgumentMatchers.any()))
                .willAnswer((invocation -> invocation.getArgument(0)));

        ResultActions response = mockMvc.perform(post("/api/orquestador/validar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inputDominio)));

        response.andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

}