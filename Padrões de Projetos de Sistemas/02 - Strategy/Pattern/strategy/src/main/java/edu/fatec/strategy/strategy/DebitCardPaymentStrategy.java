package edu.fatec.strategy.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import edu.fatec.strategy.dto.PaymentDTO;
import lombok.Data;

@Data
@Component("CARTAO_DEBITO")
public class DebitCardPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentDTO executePayment(PaymentDTO paymentDTO) {

        String product = paymentDTO.getProduct();
        Integer quantity = paymentDTO.getQuantity();
        BigDecimal unitaryPrice = paymentDTO.getUnitaryPrice();
        BigDecimal totalValue = unitaryPrice.multiply(BigDecimal.valueOf(quantity));
        LocalDate paymentDate = LocalDate.now();

        if (product == null || quantity == null || unitaryPrice == null || quantity <= 0 || unitaryPrice.compareTo(BigDecimal.ZERO) <= 0) {
        throw new IllegalArgumentException("Dados do pagamento inválidos ou incompletos.");
    }

        // Calculando desconto (5% do valor total)
        BigDecimal discount = unitaryPrice.multiply(BigDecimal.valueOf(quantity)).multiply(BigDecimal.valueOf(0.05)).setScale(2, RoundingMode.HALF_UP);
        paymentDTO.setDiscount(discount);

        // Calculando valor total com desconto
        BigDecimal totalWithDiscount = unitaryPrice.multiply(BigDecimal.valueOf(quantity)).subtract(discount).setScale(2, RoundingMode.HALF_UP);
        paymentDTO.setTotalValue(totalWithDiscount);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Gerando resultado detalhado
        String result = "Pagamento realizado com sucesso! " + "\n" +
                "Quantidade / Produto: " + quantity + " " + product +"\n" +
                "Preço unitário: R$" + unitaryPrice.setScale(2, RoundingMode.HALF_UP) + "\n" +
                "Preço total: R$" + totalValue.setScale(2, RoundingMode.HALF_UP) + "\n" +
                "Valor total com desconto: R$" + totalWithDiscount + "\n" +
                "Data do pagamento: " + paymentDate.format(formatter) + "\n" +
                "Desconto aplicado (cashback): R$" + discount;
        paymentDTO.setResult(result);
        return paymentDTO;
    }
}
