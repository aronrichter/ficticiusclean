package io.arichter.ficticiusclean.veiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "veiculos")
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
}
