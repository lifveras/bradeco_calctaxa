package io.github.lifveras.bradeco_calctaxa.provided;

import io.github.lifveras.bradeco_calctaxa.internal.RegistroDeTaxas;
import io.github.lifveras.bredeco_pic_abstract.provided.ComponentInterface;

// Classe Concreta de Interface
public class CalculadoraTaxaConcreteInterface extends ComponentInterface {

    private RegistroDeTaxas registroDeTaxas; // referência interna

    public CalculadoraTaxaConcreteInterface() {
        super();
        initialize();
    }

    @Override
    public void initialize() {
        id = "calcComponent";
        CalculadoraTaxaInterfacePort port = new CalculadoraTaxaInterfacePort("calcPort");
        ports.add(port);

        // Parte Interna
        this.registroDeTaxas = new RegistroDeTaxas();
        port.setRegistroDeTaxas(registroDeTaxas);
    }
}
