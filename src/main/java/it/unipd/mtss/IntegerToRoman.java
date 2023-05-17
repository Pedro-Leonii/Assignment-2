////////////////////////////////////////////////////////////////////
// Matteo Pincin 2034306
// Pedro Leoni 2042359
////////////////////////////////////////////////////////////////////


package it.unipd.mtss;
public class IntegerToRoman {
  public static String convert(int number) {
      if (number <= 0) {
          throw new IllegalArgumentException("Il numero deve essere un intero positivo.");
      }
      if (number > 1000) {
        throw new IllegalArgumentException("Il numero deve essere minore o uguale a mille.");
    }

      int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

      String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

      StringBuilder romanNumeral = new StringBuilder();
      int index = 0;

      while (number > 0) {
          if (number >= arabicValues[index]) {
              romanNumeral.append(romanSymbols[index]);
              number -= arabicValues[index];
          } else {
              index++;
          }
      }

      return romanNumeral.toString();
  }
}
