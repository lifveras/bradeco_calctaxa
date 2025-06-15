package io.github.lifveras.bradeco_template_dependencia_pic.provided;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.lifveras.bradeco_template_dependencia_pic.internal.RegistroDeTaxas;
import io.github.lifveras.bradeco_template_dependencia_pic.internal.model.Item;
import io.github.lifveras.bradeco_template_dependencia_pic.provided.interfaces.CalculadoraTaxaInterface;
import io.github.lifveras.bredeco_pic_abstract.provided.InterfacePort;

// Classe Concreta de Porto de Interface
public class CalculadoraTaxaInterfacePort extends InterfacePort implements CalculadoraTaxaInterface {

    private RegistroDeTaxas registroDeTaxas; // referência interna

    public CalculadoraTaxaInterfacePort(String id) {
        this.id = id;
        initialize();
    }

    @Override
    public void initialize() {
        // Não há portos de outbox.
    }

    @Override
    public Map<String, Double> calculaTaxas(List<Item> items) {
        Map<String, Double> taxasCalculadas = new HashMap<>();

        for (Item item : items) {
            double proporcaoTaxa = registroDeTaxas.getRegra(item.getCategoria());
            double valorDeTaxa = item.getPreco() * proporcaoTaxa;
            taxasCalculadas.put(item.getNome(), valorDeTaxa);
        }

        return taxasCalculadas;
    }

    public void setRegistroDeTaxas(RegistroDeTaxas registroDeTaxas) {
        this.registroDeTaxas = registroDeTaxas;
    }
}
