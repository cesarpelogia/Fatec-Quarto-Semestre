package edu.fatec.strategy.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import edu.fatec.strategy.dto.PaymentDTO;
import lombok.Data;

@Data
@Component("CARTAO_CREDITO")
public class CredCardPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentDTO executePayment(PaymentDTO paymentDTO) {

        String product = paymentDTO.getProduct();
        Integer quantity = paymentDTO.getQuantity();
        BigDecimal unitaryPrice = paymentDTO.getUnitaryPrice();
        Integer installments = paymentDTO.getInstallments();
        BigDecimal interest = paymentDTO.getInterest();
        BigDecimal totalValue = unitaryPrice.multiply(BigDecimal.valueOf(quantity));
        LocalDate paymentDate = LocalDate.now();

        // Setando taxa de juros padrão
        if(interest == null) {
            interest = BigDecimal.valueOf(0.02);
            paymentDTO.setInterest(interest);
        }

        if (quantity == null || unitaryPrice == null || installments == null ) {
            throw new IllegalArgumentException("Dados do pagamento não informados");
        }

        if (quantity <= 0 || unitaryPrice.compareTo(BigDecimal.ZERO) <= 0 || installments <= 0
                || interest.compareTo(BigDecimal.ZERO) < 0 || totalValue.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Dados do pagamento inválidos");
        }

        BigDecimal total = unitaryPrice.multiply(BigDecimal.valueOf(quantity));
        if (installments > 1) {
            BigDecimal interestValue = total.multiply(interest).multiply(BigDecimal.valueOf(installments));
            total = total.add(interestValue);
        }
        
        if (total == null || installments == null || installments <= 0) {
            throw new IllegalArgumentException("Valores inválidos: total ou parcelas não podem ser nulos ou menores que 1.");
        }
        
        BigDecimal installmentValue = total.divide(BigDecimal.valueOf(installments), 2, RoundingMode.HALF_UP);
        paymentDTO.setInstallmentValue(installmentValue);
        paymentDTO.setTotalValue(total);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        StringBuilder installmentDates = new StringBuilder();
        for (int i = 1; i <= installments; i++) {
            LocalDate installmentDate = paymentDate.plusDays(30L * i);
            installmentDates.append("Parcela ").append(i).append(": ").append(installmentDate.format(formatter)).append("\n"); // Formata a data
        }

        paymentDTO.setResult(
            "Pagamento realizado com sucesso!\n" +
            "Quantidade / Produto: " + quantity + " " + product +"\n" +
            "Preço unitário: R$" + unitaryPrice.setScale(2, RoundingMode.HALF_UP) + "\n" +
            "Taxa de juros: " + interest.multiply(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP) + "%\n" +
            "Valor total: R$" + total.setScale(2, RoundingMode.HALF_UP) + "\n" +
            "Número de parcelas: " + installments + "\n" +
            "Valor por parcela: R$" + installmentValue.setScale(2, RoundingMode.HALF_UP) + "\n" +
            "Data do pagamento: " + paymentDate.format(formatter) + "\n" +
            "Datas das parcelas:\n" + installmentDates.toString()
        );
        return paymentDTO;
    }
}
