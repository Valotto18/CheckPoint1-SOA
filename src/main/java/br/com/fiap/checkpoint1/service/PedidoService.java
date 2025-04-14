package br.com.fiap.checkpoint1.service;

import org.springframework.stereotype.Service;
import br.com.fiap.checkpoint1.model.Pedido;
import br.com.fiap.checkpoint1.repository.PedidoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizar(Long id, Pedido pedidoAtualizado) {
        Pedido pedidoAtual = pedidoRepository.findById(id)
             .orElseThrow(() -> new RuntimeException("Pedido não encontrado")); 

        pedidoAtualizado.setDataPedido(pedidoAtual.getDataPedido());

        pedidoAtualizado.setId(id);

        return pedidoRepository.save(pedidoAtualizado);
    }
    

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}