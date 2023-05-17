////////////////////////////////////////////////////////////////////
// Matteo Pincin 2034306
// Pedro Leoni 2042359
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class RomanPrinterTest {
    private static MockedStatic<IntegerToRoman> mockConverter;

    @Before
    public void setup() {
        mockConverter = Mockito.mockStatic(IntegerToRoman.class);
    }

    @After
    public void clear() {
        mockConverter.close();
    }

    @Test
    public void PrinterTest_Numero1() {
        int number = 1;
        when(IntegerToRoman.convert(number)).thenReturn("I");
        
        String expected = new String(
                "  _____  \n"
                        + " |_   _| \n"
                        + "   | |   \n"
                        + "   | |   \n"
                        + "  _| |_  \n"
                        + " |_____| \n");
        String actual = RomanPrinter.print(number);

        assertEquals(actual, expected);
    }

    @Test
    public void PrinterTest_Numero50() {
        int number = 50;
        when(IntegerToRoman.convert(number)).thenReturn("L");
        
        String expected = new String(
            " __       \n"
            +" | |      \n"
            +" | |      \n"
            +" | |      \n"
            +" | |___   \n"
            +" |_____|  \n");
        String actual = RomanPrinter.print(number);

        assertEquals(actual, expected);
    }

    @Test
    public void PrinterTest_Numero5() {
        int number = 5;
        when(IntegerToRoman.convert(number)).thenReturn("V");

        String expected = new String(
                "__      __\n"
                        + "\\ \\    / /\n"
                        + " \\ \\  / / \n"
                        + "  \\ \\/ / \n"
                        + "   \\  / \n"
                        + "    \\/   \n");
        String actual = RomanPrinter.print(number);

        assertEquals(actual, expected);
    }

    @Test
    public void PrinterTest_Numero10() {
        int number = 10;
        when(IntegerToRoman.convert(number)).thenReturn("X");

        String expected = new String(
                "__   __\n"
                        + "\\ \\ / /\n"
                        + " \\ V /\n"
                        + "  > < \n"
                        + " / . \\\n"
                        + "/_/ \\_\\\n");
        String actual = RomanPrinter.print(number);

        assertEquals(actual, expected);
    }

    @Test
    public void PrinterTest_Numero100() {
        int number = 100;
        when(IntegerToRoman.convert(number)).thenReturn("C");

        String expected = new String(
                "   _____  \n"
                        + "  / ____| \n"
                        + " | |      \n"
                        + " | |      \n"
                        + " | |____  \n"
                        + "  \\_____| \n");
        String actual = RomanPrinter.print(number);
        assertEquals(actual, expected);
    }

    @Test
    public void PrinterTest_Numero500() {
        int number = 500;
        when(IntegerToRoman.convert(number)).thenReturn("D");

        String expected = new String(
            "_____\n"
            +"|  __ \\\n"
            +"| |  | |\n"
            +"| |  | |\n"
            +"| |__| |\n"
            +"|_____/\n");
        String actual = RomanPrinter.print(number);
        assertEquals(actual, expected);
    }

    @Test
    public void PrinterTest_Numero1000() {
        int number = 1000;
        when(IntegerToRoman.convert(number)).thenReturn("M");

        String expected = new String(
            " __  __ \n"
            +" |  \\/  | \n"
            +" | \\  / | \n"
            +" | |\\/| | \n"
            +" | |  | | \n"
            +" |_|  |_| \n");
        String actual = RomanPrinter.print(number);
        assertEquals(actual, expected);
    }


    @Test(expected = IllegalArgumentException.class)
    public void PrinterTest_StringaCasuale() {
        when(IntegerToRoman.convert(anyInt())).thenReturn("CIAO");

        String result = RomanPrinter.print(0);
        fail("E'stata accettata in input una stringa casuale"); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void PrinterTest_StringaNulla() {
        when(IntegerToRoman.convert(anyInt())).thenReturn(null);

        String result = RomanPrinter.print(0);
        fail("E'stata accettata in input una stringa nulla"); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void PrinterTest_StringaVuota() {
        when(IntegerToRoman.convert(anyInt())).thenReturn("");

        String result = RomanPrinter.print(0);
        fail("E'stata accettata in input una stringa vuota"); 
    }
}
