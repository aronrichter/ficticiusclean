CREATE TABLE veiculo (
    id                      INT AUTO_INCREMENT NOT NULL,
    nome                    VARCHAR(50) NOT NULL,
    marca                   VARCHAR(50) NOT NULL,
    modelo                  VARCHAR(50) NOT NULL,
    data_fabricacao         DATE NOT NULL,
    consumo_medio_cidade    DECIMAL(10,2) NOT NULL,
    consumo_medio_rodovia   DECIMAL(10,2) NOT NULL
);

COMMENT ON TABLE veiculo IS 'Veículo';
COMMENT ON COLUMN veiculo.id IS 'ID do veículo';
COMMENT ON COLUMN veiculo.nome IS 'Nome do veículo';
COMMENT ON COLUMN veiculo.marca IS 'Marca do veículo';
COMMENT ON COLUMN veiculo.modelo IS 'Modelo do veículo';
COMMENT ON COLUMN veiculo.data_fabricacao IS 'Data de fabricação do veículo';
COMMENT ON COLUMN veiculo.consumo_medio_cidade IS 'Consumo médio do veículo na cidade';
COMMENT ON COLUMN veiculo.consumo_medio_rodovia IS 'Consumo médio do veículo na rodovia';
