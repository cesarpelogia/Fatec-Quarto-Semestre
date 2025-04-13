package edu.fatec.strategy.controller;


import org.springframework.web.bind.annotation.RestController;

import edu.fatec.strategy.dto.PaymentDTO;
import edu.fatec.strategy.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<String> realizarPagamento(@RequestBody PaymentDTO paymentDTO) {
        String result = paymentService.processPayment(paymentDTO);
        return ResponseEntity.ok(result);
    }
}
