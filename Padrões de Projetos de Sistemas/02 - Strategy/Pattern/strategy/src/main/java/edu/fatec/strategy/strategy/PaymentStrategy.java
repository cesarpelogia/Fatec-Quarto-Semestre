package edu.fatec.strategy.strategy;

import edu.fatec.strategy.dto.PaymentDTO;

public interface PaymentStrategy {

    PaymentDTO executePayment(PaymentDTO paymentDTO);

}
