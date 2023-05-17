////////////////////////////////////////////////////////////////////
// Matteo Pincin 2034306
// Pedro Leoni 2042359
////////////////////////////////////////////////////////////////////


package it.unipd.mtss;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class IntegerToRomanTest {

        @Test (expected = IllegalArgumentException.class)
        public void TestConvert_NumeroZero(){
            int number = 0;
            IntegerToRoman.convert(number);
            fail("Numero zero accettato come input");
        }
    
        @Test (expected = IllegalArgumentException.class)
        public void TestConvert_NumeroNegativo(){
            int number=-10;
            IntegerToRoman.convert(number);
            fail("Numero negativo accettato come input");
    
        }
    
        @Test (expected = IllegalArgumentException.class)
        public void TestConvert_NumeroGrande(){
            int number=1001;
            IntegerToRoman.convert(number);
            fail("Numero maggiore di 1000 accettato come input");
        }   

        @Test 
        public void TestConvert_Numero4(){
            int number=4;
            String romanNumber = IntegerToRoman.convert(number);
            assertEquals("IV",romanNumber);
        } 

        @Test
        public void TestConvert_Numero54(){
            int number=54;
            String romanNumber = IntegerToRoman.convert(number);
            assertEquals("LIV",romanNumber);
        }

        @Test
        public void TestConvert_Numero999(){
            int number=999;
            String romanNumber = IntegerToRoman.convert(number);
            assertEquals("CMXCIX",romanNumber);
        }
    
}
