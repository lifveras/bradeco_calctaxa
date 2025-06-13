package io.github.lifveras.bradeco_template_dependencia_pic.provided.interfaces;

import java.util.List;
import java.util.Map;

import io.github.lifveras.bradeco_template_dependencia_pic.internal.model.Item;

public interface CalculadoraTaxaInterface {
    Map<String, Double> calculaTaxas(List<Item> items);
}