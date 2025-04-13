package edu.fatec.strategy.service;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.stereotype.Service;

import edu.fatec.strategy.context.PaymentContext;
import edu.fatec.strategy.dto.PaymentDTO;
import edu.fatec.strategy.model.Payment;
import edu.fatec.strategy.repository.PaymentRepository;
import edu.fatec.strategy.strategy.PaymentStrategy;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Service
@RequiredArgsConstructor
public class PaymentService {

    private final Map<String, PaymentStrategy> strategyMap;

    private final PaymentRepository paymentRepository;

    private final PaymentContext paymentContext;

    public String processPayment(PaymentDTO paymentDTO) {

        String paymentType = paymentDTO.getPaymentMethod().getValue();

        if (paymentType == null) {
            throw new IllegalArgumentException("Método de pagamento não informado");
        }

        PaymentStrategy paymentStrategy = strategyMap.get(paymentType);

        if (paymentStrategy == null) {
            throw new IllegalArgumentException("Estratégia de pagamento não encontrada para: " + paymentType);
        }

        paymentContext.setStrategy(paymentStrategy);
        PaymentDTO processedPayment = paymentContext.executeContextPayment(paymentDTO);

        
        Payment payment = new Payment();
        payment.setProduct(processedPayment.getProduct());
        payment.setQuantity(processedPayment.getQuantity());
        payment.setUnitaryPrice(processedPayment.getUnitaryPrice());
        payment.setPaymentMethod(processedPayment.getPaymentMethod());
        payment.setInstallments(processedPayment.getInstallments());
        payment.setInterest(processedPayment.getInterest());
        payment.setTotalValue(processedPayment.getTotalValue());
        payment.setDiscount(processedPayment.getDiscount());
        payment.setPaymentDate(LocalDate.now());

        paymentRepository.save(payment);

        return processedPayment.getResult();
    }
}
