package io.arichter.ficticiusclean.veiculo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.management.relation.RoleUnresolved;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataFabricacaoNotDefinedException extends RuntimeException {

    public DataFabricacaoNotDefinedException() {
        super("É obrigatório informar a data de fabricação do veículo");
    }
}
