package io.arichter.ficticiusclean.veiculo;

import io.arichter.ficticiusclean.veiculo.service.VeiculoService;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class VeiculoEventHandler {

    private VeiculoService veiculoService;

    public VeiculoEventHandler(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @HandleBeforeCreate
    @HandleBeforeSave
    public void handleBeforeSave(Veiculo veiculo) {
        veiculoService.checkFields(veiculo);
    }
}
