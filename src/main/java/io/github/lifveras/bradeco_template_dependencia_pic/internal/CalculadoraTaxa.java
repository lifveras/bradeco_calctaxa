package io.github.lifveras.bradeco_template_dependencia_pic.internal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.lifveras.bradeco_template_dependencia_pic.internal.model.Item;

public class CalculadoraTaxa {
    static public Map<String, Double>
        calcularTaxas(RegistroDeTaxas registroDeTaxas, List<Item> items){
        
        Map<String, Double> taxasCalculadas = new HashMap<>();

        for (Item item : items) {
            double proporcaoTaxa = registroDeTaxas.getRegra(item.getCategoria());
            double valorDeTaxa = item.getPreco() * proporcaoTaxa;
            taxasCalculadas.put(item.getNome(), valorDeTaxa);
        }

        return taxasCalculadas;
    }
}
