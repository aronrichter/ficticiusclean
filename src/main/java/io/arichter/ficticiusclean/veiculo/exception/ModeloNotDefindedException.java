package io.arichter.ficticiusclean.veiculo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ModeloNotDefindedException extends RuntimeException {

    public ModeloNotDefindedException() {
        super("É obrigatório informar o modelo do veículo");
    }
}
