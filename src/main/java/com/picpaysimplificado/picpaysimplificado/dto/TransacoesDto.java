package com.picpaysimplificado.picpaysimplificado.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransacoesDto {
    private Long idTransacao;
    private Long remetente;
    private Long destinatario;
    private BigDecimal valor;
    private LocalDate dataHora;

    public Long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public Long getRemetente() {
        return remetente;
    }

    public void setRemetente(Long remetente) {
        this.remetente = remetente;
    }

    public Long getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Long destinatario) {
        this.destinatario = destinatario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }
}
