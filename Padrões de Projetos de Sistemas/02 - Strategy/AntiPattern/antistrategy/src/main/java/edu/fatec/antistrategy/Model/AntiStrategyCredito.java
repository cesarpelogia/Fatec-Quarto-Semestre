package edu.fatec.antistrategy.Model;

public class AntiStrategyCredito {

    public String pagamentoCredito(String tipoPagamento){
        if (tipoPagamento.toLowerCase().equals("credito")) {
            return "Pagamento via Crédito";
        } else {
            return "Tipo de pagamento não suportado!";
        }
    }

}
