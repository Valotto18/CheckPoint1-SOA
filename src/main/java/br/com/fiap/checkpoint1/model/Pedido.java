    package br.com.fiap.checkpoint1.model;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.PrePersist;
    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.PositiveOrZero;
    import java.time.LocalDate;

    @Entity
    public class Pedido {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "É obrigátorio o preenchimento do nome do cliente.")
        private String clienteNome;

        private LocalDate dataPedido;

        @PositiveOrZero(message = "Não pode ser negativo o valor do pedido(total)")
        private double valorTotal;

        public Pedido() {
        }

        @PrePersist
        private void prePersist() {
            this.dataPedido = LocalDate.now();
        }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getClienteNome() {
            return clienteNome;
        }

        public void setClienteNome(String clienteNome) {
            this.clienteNome = clienteNome;
        }

        public LocalDate getDataPedido() {
            return dataPedido;
        }

        public void setDataPedido(LocalDate dataPedido) {
            this.dataPedido = dataPedido;
        }

        public double getValorTotal() {
            return valorTotal;
        }

        public void setValorTotal(double valorTotal) {
            this.valorTotal = valorTotal;
        }

    }