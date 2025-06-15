import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.lifveras.bradeco_template_dependencia_pic.internal.Categoria;
import io.github.lifveras.bradeco_template_dependencia_pic.internal.model.Item;
import io.github.lifveras.bradeco_template_dependencia_pic.provided.CalculadoraTaxaConcreteInterface;
import io.github.lifveras.bradeco_template_dependencia_pic.provided.CalculadoraTaxaInterfacePort;

public class CalculadoraTaxaInterfacePortTest {
    private CalculadoraTaxaConcreteInterface calculadoraComponente;
    private CalculadoraTaxaInterfacePort calculadoraComponentePort;

    @BeforeEach
    public void setup() {
        calculadoraComponente = new CalculadoraTaxaConcreteInterface();
        calculadoraComponentePort = ((CalculadoraTaxaInterfacePort) calculadoraComponente.getPort("calcPort"));
    }

    @Test
    public void testCalculaTaxasComItens() {
        List<Item> itens = List.of(
                new Item("Banana", 10.0, Categoria.FOOD),
                new Item("Camisa", 100.0, Categoria.CLOTHING));

        // when(registroDeTaxas.getRegra(Categoria.FOOD)).thenReturn(0.05);
        // when(registroDeTaxas.getRegra(Categoria.CLOTHING)).thenReturn(0.1);

        Map<String, Double> resultado = calculadoraComponentePort.calculaTaxas(itens);

        assertEquals(2, resultado.size());
        assertEquals(0.5, resultado.get("Banana"));
        assertEquals(10.0, resultado.get("Camisa"));
    }

    @Test
    public void testCalculaTaxasComListaVazia() {
        Map<String, Double> resultado = calculadoraComponentePort.calculaTaxas(List.of());
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void testCalculaTaxasComCategoriaNaoRegistrada() {
        Item item = new Item("Livro", 50.0, Categoria.BOOK);

        // when(registroDeTaxas.getRegra(Categoria.BOOK)).thenReturn(0.0);

        Map<String, Double> resultado = calculadoraComponentePort.calculaTaxas(List.of(item));

        assertEquals(1, resultado.size());
        assertEquals(0.0, resultado.get("Livro"));
    }
}