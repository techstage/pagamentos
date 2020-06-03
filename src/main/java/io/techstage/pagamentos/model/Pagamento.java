package io.techstage.pagamentos.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Pagamento {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
  Long transacao;
  Double valor;
	Long cliente;
	String nome;
	String cartao;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public Long getTransacao() {
      return transacao;
    }

    public void setTransacao(Long transacao) {
      this.transacao = transacao;
    }

    public Double getValor() {
      return valor;
    }

    public void setValor(Double valor) {
      this.valor = valor;
    }

    public Long getCliente() {
      return cliente;
    }

    public void setCliente(Long cliente) {
      this.cliente = cliente;
    }

    public String getNome() {
      return nome;
    }

    public void setNome(String nome) {
      this.nome = nome;
    }

    public String getCartao() {
      return cartao;
    }

    public void setCartao(String cartao) {
      this.cartao = cartao;
    }
}