import org.junit.Test;

import static org.junit.Assert.*;

public class TransformerTest {
    @Test
    public void testBase10() {
        Transformer t = new Transformer();

        final int DECIMAL_BASE = 10;

        for(int i = 0; i < 1000; i++){
            assertEquals(Integer.toString(i, DECIMAL_BASE), t.itoa(i, DECIMAL_BASE));
        }

    }

    @Test
    public void testBase8() {
        Transformer t = new Transformer();

        final int OCTAL_BASE = 16;

        for(int i = 0; i < 1000; i++){
            assertEquals(Integer.toString(i, OCTAL_BASE).toUpperCase(), t.itoa(i, OCTAL_BASE));
        }

    }

    @Test
    public void testBase16() {
        Transformer t = new Transformer();

        final int HEX_BASE = 16;

        for(int i = 0; i < 1000; i++){
            assertEquals(Integer.toString(i, HEX_BASE).toUpperCase(), t.itoa(i, HEX_BASE));
        }

    }

}