package io.arichter.ficticiusclean.contracts;

import io.arichter.ficticiusclean.FicticiusCleanApplication;
import io.arichter.ficticiusclean.veiculo.payload.VeiculoResponse;
import io.arichter.ficticiusclean.veiculo.service.VeiculoService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class VeiculosConsumo {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private VeiculoService veiculoService;

    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(context);


        VeiculoResponse veiculoResponse = new VeiculoResponse();
        veiculoResponse.setNome("Carro 01");
        veiculoResponse.setMarca("GM");
        veiculoResponse.setModelo("Onix 1.0");
        veiculoResponse.setAno(2019);
        veiculoResponse.setLitrosCombustivel(BigDecimal.valueOf(20));
        veiculoResponse.setValorCombustivel(BigDecimal.valueOf(100));

        List<VeiculoResponse> veiculoResponses = new ArrayList<>();
        veiculoResponses.add(veiculoResponse);

        when(veiculoService.getConsumoVeiculos(BigDecimal.valueOf(4), BigDecimal.valueOf(20), BigDecimal.valueOf(150)))
                .thenReturn(veiculoResponses);
    }
}
