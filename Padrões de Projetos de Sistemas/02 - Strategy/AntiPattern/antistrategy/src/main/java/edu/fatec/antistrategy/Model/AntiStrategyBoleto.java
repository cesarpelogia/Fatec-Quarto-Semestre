package edu.fatec.antistrategy.Model;

public class AntiStrategyBoleto {

    public String pagamentoBoleto(String tipoPagamento){
        if (tipoPagamento.toLowerCase().equals("boleto")) {
            return "Pagamento via Boleto";
        } else {
            return "Tipo de pagamento não suportado!";
        }
    }

}
