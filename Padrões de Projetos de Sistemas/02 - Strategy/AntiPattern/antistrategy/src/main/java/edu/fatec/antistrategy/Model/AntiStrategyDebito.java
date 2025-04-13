package edu.fatec.antistrategy.Model;

public class AntiStrategyDebito {

    public String pagamentoDebito(String tipoPagamento){
        if (tipoPagamento.toLowerCase().equals("debito")) {
            return "Pagamento via Débito";
        } else {
            return "Tipo de pagamento não suportado!";
        }
    }

}
