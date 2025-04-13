package edu.fatec.strategy.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import edu.fatec.strategy.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

    private Long id;
    private String product;
    private Integer quantity;
    private BigDecimal unitaryPrice;
    private PaymentMethod paymentMethod;
    private Integer installments;
    private BigDecimal interest;
    private BigDecimal totalValue;
    private BigDecimal installmentValue;
    private LocalDate paymentDate;
    private String result;
    private BigDecimal discount;
}