package io.github.lifveras.bradeco_calctaxa.provided.interfaces;

import java.util.List;
import java.util.Map;

import io.github.lifveras.bradeco_calctaxa.internal.model.Item;

public interface CalculadoraTaxaInterface {
    Map<String, Double> calculaTaxas(List<Item> items);
}