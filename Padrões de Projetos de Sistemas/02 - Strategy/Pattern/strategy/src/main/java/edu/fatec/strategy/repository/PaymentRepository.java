package edu.fatec.strategy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.fatec.strategy.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
}
