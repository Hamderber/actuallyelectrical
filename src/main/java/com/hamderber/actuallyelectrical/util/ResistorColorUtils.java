package com.hamderber.actuallyelectrical.util;

public class ResistorColorUtils {
    //https://eepower.com/uploads/education/resistor_color_codes_chart.png
    private static final int[] COLORS = {
            0x000000, // 0 - Black
            0x8B4513, // 1 - Brown
            0xFF0000, // 2 - Red
            0xFFA500, // 3 - Orange
            0xFFFF00, // 4 - Yellow
            0x00FF00, // 5 - Green
            0x0000FF, // 6 - Blue
            0xEE82EE, // 7 - Violet
            0x808080, // 8 - Gray
            0xFFFFFF, // 9 - White
            0xFFD700, // 10 - Gold (×0.1)
            0xC0C0C0  // 11 - Silver (×0.01)
    };

    public static int[] getColorBands(double resistance) {
        // Minimum resistance
        if (resistance < 0.01) resistance = 0.01;

        // Convert to scientific notation with 3 significant digits
        String sci = String.format("%.3E", resistance); // ex: "4.71E3"
        String[] parts = sci.split("E");
        StringBuilder digits = new StringBuilder(parts[0].replace(".", "")); // "471"

        while (digits.length() < 3) {
            digits.append("0"); // Failsafe for 0.01 or similar edge cases
        }

        int exponent = Integer.parseInt(parts[1]);

        int first = Character.getNumericValue(digits.charAt(0));
        int second = Character.getNumericValue(digits.charAt(1));
        int third = Character.getNumericValue(digits.charAt(2));

        // Multiplier band index = exponent - 2, because the first 3 digits cover digits × 10^(exponent - 2)
        // ex: 4.71E3 (4710) → digits: 471, exponent: 3 → multiplier = 3 - 2 = 1 (brown, ×10)
        // first 3 digits = 471, multiplier = 10^1 = 10, so total = 471 × 10 = 4710
        int multiplierIndex = exponent - 2;
        multiplierIndex = Math.max(0, Math.min(multiplierIndex, COLORS.length - 1));

        // Fix issue with 0 being rendered as transparency by bitwise OR-ing with 0xFF000000 to ensure color visibility
        return new int[] {
                COLORS[first] | 0xFF000000,
                COLORS[second] | 0xFF000000,
                COLORS[third] | 0xFF000000,
                COLORS[multiplierIndex] | 0xFF000000
        };
    }
}
