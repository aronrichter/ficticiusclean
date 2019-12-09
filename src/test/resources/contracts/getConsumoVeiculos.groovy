package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "get consumo dos veiculos"

    request {
        url("/veiculos/consumo") {
            queryParameters {
                parameter('valorCombustivel', 4)
                parameter('kmRodadosCidade', 20.00)
                parameter('kmRodadesRodovia', 150.00)
            }
        }

        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                [[

                      nome             : "Carro 01",
                      marca            : "GM",
                      modelo           : "Onix 1.0",
                      ano              : 2019,
                      litrosCombustivel: 20,
                      valorCombustivel : 100
              ]]
        )
    }
}
