////////////////////////////////////////////////////////////////////
// Matteo Pincin 2034306
// Pedro Leoni 2042359
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import java.util.HashMap;

public class RomanPrinter {
    static private HashMap<Character, String[]> romanDict = new HashMap<>();
    static {
        romanDict.put('I', new String[] {
                "  _____  ",
                " |_   _| ",
                "   | |   ",
                "   | |   ",
                "  _| |_  ",
                " |_____| "
        });
        romanDict.put('V', new String[] {
            "__      __",
            "\\ \\    / /",
            " \\ \\  / / ",
            "  \\ \\/ / ",
            "   \\  / ",  
            "    \\/   "
                    
        });
        romanDict.put('X', new String[] {
                "__   __",
                "\\ \\ / /",
                " \\ V /",
                "  > < ",
                " / . \\",
                "/_/ \\_\\"
        });
        romanDict.put('L', new String[] {
                " __       ",
                " | |      ",
                " | |      ",
                " | |      ",
                " | |___   ",
                " |_____|  "
        });
        romanDict.put('C', new String[] {
                "   _____  ",
                "  / ____| ",
                " | |      ",
                " | |      ",
                " | |____  ",
                "  \\_____| "
        });
        romanDict.put('D', new String[] {
                "_____",
                "|  __ \\",
                "| |  | |",
                "| |  | |",
                "| |__| |",
                "|_____/"

        });
        romanDict.put('M', new String[] {
                " __  __ ",
                " |  \\/  | ",
                " | \\  / | ",
                " | |\\/| | ",
                " | |  | | ",
                " |_|  |_| "
        });
    }

    public static String print(int num) {
        return printAsciiArt(IntegerToRoman.convert(num));
    }

    private static String printAsciiArt(String romanNumber) {
        if (romanNumber == null || romanNumber.length() == 0){
            throw new IllegalArgumentException("Null value as input.");
        }

        StringBuilder asciiArtBuilder = new StringBuilder();
        String[] lines = new String[] { "", "", "", "", "", "" };

        for (int i = 0; i < romanNumber.length(); i++) {
            char digit = romanNumber.charAt(i);
            if (romanDict.containsKey(digit)) {
                String[] digitLines = romanDict.get(digit);
                for (int j = 0; j < lines.length; j++) {
                    lines[j] += digitLines[j];
                }
            } else {
                throw new IllegalArgumentException("Input contains invalid characters.");
            }
        }

        for (String line : lines) {
            asciiArtBuilder.append(line).append("\n");
        }

        return asciiArtBuilder.toString();
    }
}
