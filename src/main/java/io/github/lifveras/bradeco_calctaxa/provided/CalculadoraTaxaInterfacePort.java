package io.github.lifveras.bradeco_calctaxa.provided;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.lifveras.bradeco_calctaxa.internal.CalculadoraTaxa;
import io.github.lifveras.bradeco_calctaxa.internal.RegistroDeTaxas;
import io.github.lifveras.bradeco_calctaxa.internal.model.Item;
import io.github.lifveras.bradeco_calctaxa.provided.interfaces.CalculadoraTaxaInterface;
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
        return CalculadoraTaxa.calcularTaxas(registroDeTaxas, items);
    }

    public void setRegistroDeTaxas(RegistroDeTaxas registroDeTaxas) {
        this.registroDeTaxas = registroDeTaxas;
    }
}
