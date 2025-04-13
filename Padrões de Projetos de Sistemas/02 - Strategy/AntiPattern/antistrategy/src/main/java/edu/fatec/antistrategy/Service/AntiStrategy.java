package edu.fatec.antistrategy.Service;

import org.springframework.stereotype.Service;

import edu.fatec.antistrategy.Model.AntiStrategyBoleto;
import edu.fatec.antistrategy.Model.AntiStrategyCredito;
import edu.fatec.antistrategy.Model.AntiStrategyDebito;
import edu.fatec.antistrategy.Model.AntiStrategyPix;

@Service
public class AntiStrategy {

    public String processarPagamento(String tipoPagamento){

        if (tipoPagamento == null || tipoPagamento.isEmpty()) {
            return "Tipo de pagamento não pode ser nulo ou vazio!";
        }

        tipoPagamento = tipoPagamento.trim().toLowerCase();

        switch (tipoPagamento) {
            case "boleto":
                return new AntiStrategyBoleto().pagamentoBoleto(tipoPagamento);
            case "credito":
                return new AntiStrategyCredito().pagamentoCredito(tipoPagamento);
            case "debito":
                return new AntiStrategyDebito().pagamentoDebito(tipoPagamento);
            case "pix":
                return new AntiStrategyPix().pagamentoPix(tipoPagamento);
            default:
                return "Tipo de pagamento não suportado!";
        }
    }
}
