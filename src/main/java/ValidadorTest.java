import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorTest {

    @Test
    @DisplayName("Test para validar si se ingresan letras")
    void entradaNumLetra() {
        ByteArrayInputStream in = new ByteArrayInputStream("a".getBytes());
        System.setIn(in);
        assertEquals(0, Validador.entradaDouble());
    }

    @Test
    @DisplayName("Test para validar si la entrada es vacía")
    void entradaNumVacia() {
        ByteArrayInputStream in = new ByteArrayInputStream(("" + System.lineSeparator()).getBytes());
        System.setIn(in);
        assertEquals(0, Validador.entradaDouble());
    }
}
