package io.arichter.ficticiusclean.veiculo;

import io.arichter.ficticiusclean.veiculo.payload.VeiculoResponse;
import io.arichter.ficticiusclean.veiculo.service.VeiculoService;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@RepositoryRestController
@RequestMapping("veiculos")
public class VeiculoController {

    private VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping("consumo")
    @ResponseBody
    public List<VeiculoResponse> getVeiculos(@RequestParam BigDecimal valorCombustivel,
                                             @RequestParam BigDecimal kmRodadosCidade,
                                             @RequestParam BigDecimal kmRodadesRodovia) {
        return veiculoService.getConsumoVeiculos(valorCombustivel, kmRodadosCidade, kmRodadesRodovia);
    }
}
