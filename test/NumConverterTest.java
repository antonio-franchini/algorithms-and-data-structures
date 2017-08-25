import org.junit.Test;

import static org.junit.Assert.*;

public class NumConverterTest {
    @Test
    public void testBase10() {
        NumConverter t = new NumConverter();

        final int DECIMAL_BASE = 10;

        for(int i = 0; i < 1000; i++){
            assertEquals(Integer.toString(i, DECIMAL_BASE), t.intToStringOfBase(i, DECIMAL_BASE));
        }

    }

    @Test
    public void testBase8() {
        NumConverter t = new NumConverter();

        final int OCTAL_BASE = 16;

        for(int i = 0; i < 1000; i++){
            assertEquals(Integer.toString(i, OCTAL_BASE).toUpperCase(), t.intToStringOfBase(i, OCTAL_BASE));
        }

    }

    @Test
    public void testBase16() {
        NumConverter t = new NumConverter();

        final int HEX_BASE = 16;

        for(int i = 0; i < 1000; i++){
            assertEquals(Integer.toString(i, HEX_BASE).toUpperCase(), t.intToStringOfBase(i, HEX_BASE));
        }

    }

}