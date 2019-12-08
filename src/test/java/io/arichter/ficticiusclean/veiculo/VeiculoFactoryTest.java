package io.arichter.ficticiusclean.veiculo;

import io.arichter.ficticiusclean.veiculo.payload.VeiculoResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VeiculoFactoryTest {

    private static final String NOME = "Carro 01";
    private static final String MARCA = "GM";
    private static final String MODELO = "Onix 1.0";
    private static final LocalDate DATA_FABRICACAO = LocalDate.of(2019, 1, 1);
    private static final BigDecimal LITROS_COMBUSTIVEL = BigDecimal.valueOf(20.0);
    private static final BigDecimal VALOR_COMBUSTIVEL = BigDecimal.valueOf(80.0);

    @InjectMocks
    private VeiculoFactory veiculoFactory;

    @Mock
    private Veiculo veiculo;

    @Test
    public void shouldCreateVeiculoResponse() {
        when(veiculo.getNome()).thenReturn(NOME);
        when(veiculo.getMarca()).thenReturn(MARCA);
        when(veiculo.getModelo()).thenReturn(MODELO);
        when(veiculo.getDataFabricacao()).thenReturn(DATA_FABRICACAO);

        VeiculoResponse veiculoResponse = veiculoFactory.create(veiculo, LITROS_COMBUSTIVEL, VALOR_COMBUSTIVEL);

        assertThat(veiculoResponse.getNome()).isEqualTo(NOME);
        assertThat(veiculoResponse.getMarca()).isEqualTo(MARCA);
        assertThat(veiculoResponse.getModelo()).isEqualTo(MODELO);
        assertThat(veiculoResponse.getAno()).isEqualTo(DATA_FABRICACAO.getYear());
        assertThat(veiculoResponse.getLitrosCombustivel()).isEqualTo(LITROS_COMBUSTIVEL);
        assertThat(veiculoResponse.getValorCombustivel()).isEqualTo(VALOR_COMBUSTIVEL);
    }
}