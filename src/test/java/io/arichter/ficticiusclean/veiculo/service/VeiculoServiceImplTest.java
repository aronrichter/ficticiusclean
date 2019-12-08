package io.arichter.ficticiusclean.veiculo.service;

import io.arichter.ficticiusclean.veiculo.Veiculo;
import io.arichter.ficticiusclean.veiculo.VeiculoFactory;
import io.arichter.ficticiusclean.veiculo.exception.*;
import io.arichter.ficticiusclean.veiculo.payload.VeiculoResponse;
import org.junit.Test;
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
public class VeiculoServiceImplTest {

    private static final String NOME = "Carro 01";
    private static final String MARCA = "GM";
    private static final String MODELO = "Onix 1.0";
    private static final LocalDate DATA_FABRICACAO = LocalDate.of(2019, 1, 1);
    private static final BigDecimal CONSUMO_MEDIO_CIDADE = BigDecimal.valueOf(12.5);
    private static final BigDecimal CONSUMO_MEDIO_RODOVIA = BigDecimal.valueOf(15);
    private static final BigDecimal KM_RODADO = BigDecimal.valueOf(50);
    private static final BigDecimal KM_RODADO_RODOVIA = BigDecimal.valueOf(150);
    private static final BigDecimal LITROS_COMBUSTIVEL = BigDecimal.valueOf(5);
    private static final BigDecimal VALOR_COMBUSTIVEL = BigDecimal.valueOf(4);

    @InjectMocks
    private VeiculoServiceImpl veiculoService;

    @Mock
    private Veiculo veiculo;

    @Mock
    private VeiculoResponse veiculoResponse;

    @Mock
    private VeiculoFactory veiculoFactory;

    @Test(expected = NomeNotDefinedException.class)
    public void shouldThrowNomeNotDefinedExceptionWithNullName() {
        when(veiculo.getMarca()).thenReturn(MARCA);
        when(veiculo.getModelo()).thenReturn(MODELO);
        when(veiculo.getDataFabricacao()).thenReturn(DATA_FABRICACAO);
        when(veiculo.getConsumoMedioCidade()).thenReturn(CONSUMO_MEDIO_CIDADE);
        when(veiculo.getConsumoMedioRodovia()).thenReturn(CONSUMO_MEDIO_RODOVIA);

        veiculoService.checkFields(veiculo);
    }

    @Test(expected = NomeNotDefinedException.class)
    public void shouldThrowNomeNotDefinedExceptionWithEmptyName() {
        when(veiculo.getMarca()).thenReturn(MARCA);
        when(veiculo.getModelo()).thenReturn(MODELO);
        when(veiculo.getDataFabricacao()).thenReturn(DATA_FABRICACAO);
        when(veiculo.getConsumoMedioCidade()).thenReturn(CONSUMO_MEDIO_CIDADE);
        when(veiculo.getConsumoMedioRodovia()).thenReturn(CONSUMO_MEDIO_RODOVIA);

        veiculoService.checkFields(veiculo);
    }

    @Test(expected = MarcaNotDefinedException.class)
    public void shouldThrowMarcaNotDefinedExceptionWithNullMarca() {
        when(veiculo.getNome()).thenReturn(NOME);
        when(veiculo.getModelo()).thenReturn(MODELO);
        when(veiculo.getDataFabricacao()).thenReturn(DATA_FABRICACAO);
        when(veiculo.getConsumoMedioCidade()).thenReturn(CONSUMO_MEDIO_CIDADE);
        when(veiculo.getConsumoMedioRodovia()).thenReturn(CONSUMO_MEDIO_RODOVIA);

        veiculoService.checkFields(veiculo);
    }

    @Test(expected = MarcaNotDefinedException.class)
    public void shouldThrowMarcaNotDefinedExceptionWithEmptyMarca() {
        when(veiculo.getNome()).thenReturn(NOME);
        when(veiculo.getModelo()).thenReturn(MODELO);
        when(veiculo.getDataFabricacao()).thenReturn(DATA_FABRICACAO);
        when(veiculo.getConsumoMedioCidade()).thenReturn(CONSUMO_MEDIO_CIDADE);
        when(veiculo.getConsumoMedioRodovia()).thenReturn(CONSUMO_MEDIO_RODOVIA);

        veiculoService.checkFields(veiculo);
    }

    @Test(expected = ModeloNotDefindedException.class)
    public void shouldThrowNodeloNotDefinedExceptionWithNullModelo() {
        when(veiculo.getNome()).thenReturn(NOME);
        when(veiculo.getMarca()).thenReturn(MARCA);
        when(veiculo.getDataFabricacao()).thenReturn(DATA_FABRICACAO);
        when(veiculo.getConsumoMedioCidade()).thenReturn(CONSUMO_MEDIO_CIDADE);
        when(veiculo.getConsumoMedioRodovia()).thenReturn(CONSUMO_MEDIO_RODOVIA);

        veiculoService.checkFields(veiculo);
    }

    @Test(expected = ModeloNotDefindedException.class)
    public void shouldThrowModeloNotDefinedExceptionWithEmptyModelo() {
        when(veiculo.getNome()).thenReturn(NOME);
        when(veiculo.getMarca()).thenReturn(MARCA);
        when(veiculo.getDataFabricacao()).thenReturn(DATA_FABRICACAO);
        when(veiculo.getConsumoMedioCidade()).thenReturn(CONSUMO_MEDIO_CIDADE);
        when(veiculo.getConsumoMedioRodovia()).thenReturn(CONSUMO_MEDIO_RODOVIA);

        veiculoService.checkFields(veiculo);
    }


    @Test(expected = DataFabricacaoNotDefinedException.class)
    public void shouldThrowDataFabricacaoNotDefinedException() {
        when(veiculo.getNome()).thenReturn(NOME);
        when(veiculo.getMarca()).thenReturn(MARCA);
        when(veiculo.getModelo()).thenReturn(MODELO);
        when(veiculo.getConsumoMedioCidade()).thenReturn(CONSUMO_MEDIO_CIDADE);
        when(veiculo.getConsumoMedioRodovia()).thenReturn(CONSUMO_MEDIO_RODOVIA);

        veiculoService.checkFields(veiculo);
    }

    @Test(expected = ConsumoMedioCidadeNotDefinedException.class)
    public void shouldThrowConsumoMedioCidadeNotDefinedException() {
        when(veiculo.getNome()).thenReturn(NOME);
        when(veiculo.getMarca()).thenReturn(MARCA);
        when(veiculo.getModelo()).thenReturn(MODELO);
        when(veiculo.getDataFabricacao()).thenReturn(DATA_FABRICACAO);
        when(veiculo.getConsumoMedioRodovia()).thenReturn(CONSUMO_MEDIO_RODOVIA);

        veiculoService.checkFields(veiculo);
    }

    @Test(expected = ConsumoMedioRodoviaNotDefinedException.class)
    public void shouldThrowConsumoMedioRodoviaNotDefinedException() {
        when(veiculo.getNome()).thenReturn(NOME);
        when(veiculo.getMarca()).thenReturn(MARCA);
        when(veiculo.getModelo()).thenReturn(MODELO);
        when(veiculo.getDataFabricacao()).thenReturn(DATA_FABRICACAO);
        when(veiculo.getConsumoMedioCidade()).thenReturn(CONSUMO_MEDIO_CIDADE);

        veiculoService.checkFields(veiculo);
    }

    @Test
    public void shouldCalculateLitrosCombustivel() {
        BigDecimal litrosCombustivel = veiculoService.calculateLitrosCombustivel(KM_RODADO, CONSUMO_MEDIO_CIDADE);

        assertThat(litrosCombustivel).isEqualTo(BigDecimal.valueOf(4));
    }

    @Test
    public void shouldCaculateValorCombustivel() {
        BigDecimal litrosCombustivel = veiculoService.caculateValorCombustivel(VALOR_COMBUSTIVEL, LITROS_COMBUSTIVEL);

        assertThat(litrosCombustivel).isEqualTo(BigDecimal.valueOf(20));
    }

    @Test
    public void shouldCalculateTotalLitros() {
        when(veiculo.getNome()).thenReturn(NOME);
        when(veiculo.getMarca()).thenReturn(MARCA);
        when(veiculo.getModelo()).thenReturn(MODELO);
        when(veiculo.getDataFabricacao()).thenReturn(DATA_FABRICACAO);
        when(veiculo.getConsumoMedioCidade()).thenReturn(CONSUMO_MEDIO_CIDADE);
        when(veiculo.getConsumoMedioRodovia()).thenReturn(CONSUMO_MEDIO_RODOVIA);

        BigDecimal litrosCombustivel = veiculoService.calculateTotalLitros(veiculo, KM_RODADO, KM_RODADO_RODOVIA);

        assertThat(litrosCombustivel).isEqualTo(BigDecimal.valueOf(14));
    }
}