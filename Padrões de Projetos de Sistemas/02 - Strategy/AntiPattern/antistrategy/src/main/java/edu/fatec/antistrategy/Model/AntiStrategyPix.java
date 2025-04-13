package edu.fatec.antistrategy.Model;

public class AntiStrategyPix {

    public String pagamentoPix(String tipoPagamento){
        if (tipoPagamento.toLowerCase().equals("pix")) {
            return "Pagamento via Pix";
        } else {
            return "Tipo de pagamento não suportado!";
        }
    }

}
