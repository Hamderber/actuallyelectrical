package com.hamderber.actuallyelectrical.records;

import com.hamderber.actuallyelectrical.enums.ResistorColor;
import org.jetbrains.annotations.NotNull;

public record ResistanceRecord(int firstDigit, int secondDigit, int thirdDigit, int exponent) {
    public static ResistanceRecord create(double resistance) {
        // Minimum resistance
        if (resistance < 0.01) resistance = 0.01;

        // Convert to scientific notation with 3 significant digits
        String sci = String.format("%.3E", resistance); // ex: "4.71E3"
        String[] parts = sci.split("E"); // ["4.71", "3"]
        StringBuilder stringDigits = new StringBuilder(parts[0].replace(".", "")); // "471"

        while (stringDigits.length() < 3) {
            // Ensure at at least three digits to avoid array out of bounds exceptions
            stringDigits.append("0");
        }

        // This is an unnecessary assignment but aids in legibility
        int[] intDigits = {
                Character.getNumericValue(stringDigits.charAt(0)),
                Character.getNumericValue(stringDigits.charAt(1)),
                Character.getNumericValue(stringDigits.charAt(2)),
                Integer.parseInt(parts[1])
        };

        return new ResistanceRecord(intDigits[0], intDigits[1], intDigits[2], intDigits[3]);
    }

    public int[] getColorBands() {
        return new int[] {
                ResistorColor.byId(firstDigit(), false).colorHex | 0xFF000000,
                ResistorColor.byId(secondDigit(), false).colorHex | 0xFF000000,
                ResistorColor.byId(thirdDigit(), false).colorHex | 0xFF000000,
                ResistorColor.byId(exponent(), true).colorHex | 0xFF000000
        };
    }

    @Override
    public @NotNull String toString() {
        int combinedDigits = firstDigit * 100 + secondDigit * 10 + thirdDigit;

        // Calculate the total resistance as a double. The -2 is from shifting the decimal (above)
        double resistance = combinedDigits * Math.pow(10, exponent - 2);

        String formatted;
        if (resistance >= 1_000_000) {
            formatted = String.format("%.2fMΩ", resistance / 1_000_000.0);
        } else if (resistance >= 1_000) {
            formatted = String.format("%.2fkΩ", resistance / 1_000.0);
        } else if (resistance >= 1) {
            formatted = String.format("%.2fΩ", resistance);
        } else {
            formatted = String.format("%.2fmΩ", resistance * 1_000);
        }

        return formatted;
    }
}
