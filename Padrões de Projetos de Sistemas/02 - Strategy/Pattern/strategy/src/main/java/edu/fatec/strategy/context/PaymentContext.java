package edu.fatec.strategy.context;

import org.springframework.stereotype.Component;

import edu.fatec.strategy.dto.PaymentDTO;
import edu.fatec.strategy.strategy.PaymentStrategy;
import lombok.Data;

@Data
@Component
public class PaymentContext {

    private PaymentStrategy strategy;

    public PaymentDTO executeContextPayment(PaymentDTO paymentDTO) {
        return strategy.executePayment(paymentDTO);
    }
    
}