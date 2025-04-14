package br.com.fiap.checkpoint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.checkpoint1.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}