package io.arichter.ficticiusclean.veiculo.service;

import io.arichter.ficticiusclean.veiculo.Veiculo;
import io.arichter.ficticiusclean.veiculo.VeiculoFactory;
import io.arichter.ficticiusclean.veiculo.VeiculoRepository;
import io.arichter.ficticiusclean.veiculo.exception.*;
import io.arichter.ficticiusclean.veiculo.payload.VeiculoResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    private VeiculoRepository veiculoRepository;

    private VeiculoFactory veiculoFactory;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository, VeiculoFactory veiculoFactory) {
        this.veiculoRepository = veiculoRepository;
        this.veiculoFactory = veiculoFactory;
    }

    @Override
    public List<Veiculo> getVeiculos() {
        return veiculoRepository.findAll();
    }

    @Override
    public List<VeiculoResponse> getConsumoVeiculos(BigDecimal valorCombunstivel,
                                                    BigDecimal kmRodadosCidade,
                                                    BigDecimal kmRodadosRodovia) {
        List<Veiculo> veiculos = getVeiculos();

        return veiculos.stream()
                .map(v -> getConsumoVeiculos(v, valorCombunstivel, kmRodadosCidade, kmRodadosRodovia))
                .sorted(Comparator.comparing(VeiculoResponse::getValorCombustivel))
                .collect(Collectors.toList());
    }

    @Override
    public void checkFields(Veiculo veiculo) {
        if (veiculo.getNome() == null || veiculo.getNome().isEmpty()) {
            throw new NomeNotDefinedException();
        }

        if (veiculo.getMarca() == null || veiculo.getMarca().isEmpty()) {
            throw new MarcaNotDefinedException();
        }

        if (veiculo.getModelo() == null || veiculo.getModelo().isEmpty()) {
            throw new ModeloNotDefindedException();
        }

        if (veiculo.getDataFabricacao() == null) {
            throw new DataFabricacaoNotDefinedException();
        }

        if (veiculo.getConsumoMedioCidade() == null) {
            throw new ConsumoMedioCidadeNotDefinedException();
        }

        if (veiculo.getConsumoMedioRodovia() == null) {
            throw new ConsumoMedioRodoviaNotDefinedException();
        }

    }

    public VeiculoResponse getConsumoVeiculos(Veiculo veiculo,
                                              BigDecimal valorCombunstivel,
                                              BigDecimal kmRodadosCidade,
                                              BigDecimal kmRodadosRodovia) {
        BigDecimal totalLitros = calculateTotalLitros(veiculo, kmRodadosCidade, kmRodadosRodovia);

        BigDecimal totalValor = caculateValorCombustivel(valorCombunstivel, totalLitros);

        return veiculoFactory.create(veiculo, totalLitros, totalValor);
    }

    public BigDecimal calculateTotalLitros(Veiculo veiculo, BigDecimal kmRodadoCidade, BigDecimal kmRodadoRodovia) {
        BigDecimal litrosGastoCidade = calculateLitrosCombustivel(kmRodadoCidade, veiculo.getConsumoMedioCidade());

        BigDecimal litrosGastoRodovia = calculateLitrosCombustivel(kmRodadoRodovia, veiculo.getConsumoMedioRodovia());

        return litrosGastoCidade.add(litrosGastoRodovia);
    }

    public BigDecimal calculateLitrosCombustivel(BigDecimal kmRodado, BigDecimal consumoMedio) {
        return kmRodado.divide(consumoMedio, RoundingMode.UP);
    }

    public BigDecimal caculateValorCombustivel(BigDecimal valorCombustivel, BigDecimal litros) {
        return litros.multiply(valorCombustivel);
    }


}
