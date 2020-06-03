package io.techstage.pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.techstage.pagamentos.model.Pagamento;

public interface Pagamentos extends JpaRepository<Pagamento, Long> {

}