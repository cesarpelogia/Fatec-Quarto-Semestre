package edu.fatec.antistrategy.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fatec.antistrategy.Service.AntiStrategy;

@RestController
public class AntiStrategyController {

    @Autowired
    private AntiStrategy service;

    @RequestMapping("/payment")
    public ResponseEntity<String> processarPagamento(@RequestBody Map<String, String> payload) {
        String tipoPagamento = payload.get("tipoPagamento");
    
        if (tipoPagamento == null || tipoPagamento.isEmpty()) {
            return ResponseEntity.badRequest().body("Tipo de pagamento não pode ser nulo ou vazio!");
        }
        return ResponseEntity.ok(service.processarPagamento(tipoPagamento));
    }
}
