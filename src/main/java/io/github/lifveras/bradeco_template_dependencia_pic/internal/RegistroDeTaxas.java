package io.github.lifveras.bradeco_template_dependencia_pic.internal;

import java.util.HashMap;
import java.util.Map;

public class RegistroDeTaxas {

    private final Map<Categoria, Double> regras = new HashMap<>();

    public RegistroDeTaxas() {
        regras.put(Categoria.FOOD, 0.05);
        regras.put(Categoria.ELECTRONICS, 0.15);
        regras.put(Categoria.CLOTHING, 0.1);
        regras.put(Categoria.BOOK, 0.0);
    }

    public double getRegra(Categoria categoria) {
        return regras.getOrDefault(categoria, 0.0);
    }
}