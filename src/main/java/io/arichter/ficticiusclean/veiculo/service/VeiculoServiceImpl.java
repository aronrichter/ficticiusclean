package io.arichter.ficticiusclean.veiculo.service;

import io.arichter.ficticiusclean.veiculo.Veiculo;
import io.arichter.ficticiusclean.veiculo.VeiculoFactory;
import io.arichter.ficticiusclean.veiculo.VeiculoRepository;
import io.arichter.ficticiusclean.veiculo.payload.VeiculoResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
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
                .map(v -> getVeiculos(v, valorCombunstivel, kmRodadosCidade, kmRodadosRodovia))
                .sorted(Comparator.comparing(VeiculoResponse::getValorCombustivel))
                .collect(Collectors.toList());
    }

    private VeiculoResponse getVeiculos(Veiculo veiculo,
                                        BigDecimal valorCombunstivel,
                                        BigDecimal kmRodadosCidade,
                                        BigDecimal kmRodadosRodovia) {
        BigDecimal totalLitros = calculateTotalLitros(veiculo, kmRodadosCidade, kmRodadosRodovia);

        BigDecimal totalValor = caculateValorCombustivel(valorCombunstivel, totalLitros);

        return veiculoFactory.create(veiculo, totalLitros, totalValor);
    }

    private BigDecimal calculateTotalLitros(Veiculo veiculo, BigDecimal kmRodadoCidade, BigDecimal kmRodadoRodovia) {
        BigDecimal litrosGastoCidade = calculateLitrosCombustivel(kmRodadoCidade, veiculo.getConsumoMedioCidade());

        BigDecimal litrosGastoRodovia = calculateLitrosCombustivel(kmRodadoRodovia, veiculo.getConsumoMedioRodovia());

        return litrosGastoCidade.add(litrosGastoRodovia);
    }

    private BigDecimal calculateLitrosCombustivel(BigDecimal kmRodado, BigDecimal consumoMedio) {
        return kmRodado.divide(consumoMedio, RoundingMode.UP);
    }

    private BigDecimal caculateValorCombustivel(BigDecimal valorCombustivel, BigDecimal litros) {
        return litros.multiply(valorCombustivel);
    }


}
