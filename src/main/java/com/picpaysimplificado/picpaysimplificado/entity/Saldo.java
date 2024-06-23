package com.picpaysimplificado.picpaysimplificado.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "saldo")
public class Saldo {

    @Id
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;


    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal balance) {
        this.saldo = balance;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
