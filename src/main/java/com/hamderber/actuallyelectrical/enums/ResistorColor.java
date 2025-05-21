package com.hamderber.actuallyelectrical.enums;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public enum ResistorColor {
    //https://eepower.com/uploads/education/resistor_color_codes_chart.png
    BLACK(0, 0x000000, "black", 1, 0),
    BROWN(1, 0x8B4513, "brown", 10, 1),
    RED(2, 0xFF0000, "red", 100, 2),
    ORANGE(3, 0xFFA500, "orange", 1_000, 3),
    YELLOW(4, 0xFFFF00, "yellow", 10_000, 4),
    GREEN(5, 0x00FF00, "green", 100_000, 5),
    BLUE(6, 0x0000FF, "blue", 1_000_000, 6),
    VIOLET(7, 0x7F00FF, "violet", 10_000_000, 7),
    GRAY(8, 0x808080, "gray", 100_000_000, 8),
    WHITE(9, 0xFFFFFF, "white", 1_000_000_000, 9),
    GOLD(10, 0xFFD700, "gold", 0.1, -1),
    SILVER(11, 0xC0C0C0, "silver", 0.01, -2);

    public final int id;
    public final int colorHex;
    public final String langKey;
    public final double multiplier;
    public final int digitValue;

    ResistorColor(int id, int colorHex, String langKey, double multiplier, int digitValue) {
        this.id = id;
        this.colorHex = colorHex;
        this.langKey = langKey;
        this.multiplier = multiplier;
        this.digitValue = digitValue;
    }

    public Component getTranslatedName() {
        return Component.translatable("color.actuallyelectrical.resistor." + langKey);
    }

    public static @NotNull ResistorColor byId(int id, boolean isExponent) {
        // Exponent band index = id - 2, because the first 3 digits cover digits × 10^(exponent - 2)
        // ex: 4.71E3 (4710) → digits: 471, exponent: 3 → multiplier = 3 - 2 = 1 (brown, ×10)
        // first 3 digits = 471, multiplier = 10^1 = 10, so total = 471 × 10 = 4710
        id = isExponent ? Math.max(0, Math.min(id - 2, ResistorColor.numColors() - 1)) : id;

        for (ResistorColor color : values()) {
            if (color.id == id) return color;
        }

        // Default to white because that is the invalid/base color used for texture tinting
        return WHITE;
    }

    public static int numColors() {
        // How many colors are defined
        return 12;
    }
}
