package edu.fatec.strategy.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import edu.fatec.strategy.enums.PaymentMethod;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product", nullable = false)
    private String product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unitary_price")
    private BigDecimal unitaryPrice;

    @Column(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "installments")
    private Integer installments;

    @Column(name = "interest")
    private BigDecimal interest;

    @Column(name = "total_value")
    private BigDecimal totalValue;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "payment_date")
    private LocalDate paymentDate;
}
