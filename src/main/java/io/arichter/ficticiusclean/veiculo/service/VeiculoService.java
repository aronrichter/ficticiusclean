package io.arichter.ficticiusclean.veiculo.service;

import io.arichter.ficticiusclean.veiculo.Veiculo;
import io.arichter.ficticiusclean.veiculo.payload.VeiculoResponse;

import java.math.BigDecimal;
import java.util.List;

public interface VeiculoService {

    List<Veiculo> getVeiculos();

    List<VeiculoResponse> getConsumoVeiculos(BigDecimal valorCombunstivel,
                                             BigDecimal kmRodadosCidade,
                                             BigDecimal kmRodadosRodovia);

    void checkFields(Veiculo veiculo);
}
