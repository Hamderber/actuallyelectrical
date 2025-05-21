package com.hamderber.actuallyelectrical.common.item;

import com.hamderber.actuallyelectrical.common.registration.DataComponentTypes;
import com.hamderber.actuallyelectrical.enums.ResistorColor;
import com.hamderber.actuallyelectrical.records.ResistanceRecord;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Random;

public class ResistorThroughHole extends Item {
    public ResistorThroughHole(Properties properties) {
        super(properties);
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level world, Player player) {
        if (!stack.has(DataComponentTypes.RESISTANCE_VALUE.get())) {

            // Assign a random value to the resistor when crafted (temporary solution)
            stack.set(DataComponentTypes.RESISTANCE_VALUE.get(), new Random().nextDouble(0, 2_000_000));
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        var resistanceValue = stack.get(DataComponentTypes.RESISTANCE_VALUE);

        //<editor-fold desc="Resistance">
        if (resistanceValue == null || resistanceValue == -1) {
            tooltipComponents.add(Component
                    .translatable("tooltip.actuallyelectrical.resistor_through_hole.resistance")
                    .append(Component.literal(": "))
                    .append(Component.translatable("tooltip.actuallyelectrical.resistor_through_hole.invalid"))
                    .withStyle(ChatFormatting.GRAY));
        }
        else {
            ResistanceRecord record = ResistanceRecord.create(resistanceValue);
            tooltipComponents.add(Component
                    .translatable("tooltip.actuallyelectrical.resistor_through_hole.resistance")
                    .append(Component.literal(": " + record))
                    .withStyle(ChatFormatting.GRAY));
        }
        //</editor-fold>

        //<editor-fold desc="Color text">
        if (resistanceValue == null || resistanceValue == -1) {
            tooltipComponents.add(Component
                    .translatable("tooltip.actuallyelectrical.resistor_through_hole.color")
                    .append(Component.literal(": "))
                    .append(Component.translatable("tooltip.actuallyelectrical.resistor_through_hole.invalid"))
                    .withStyle(ChatFormatting.GRAY));
        }
        else {
            ResistanceRecord record = ResistanceRecord.create(resistanceValue);
            tooltipComponents.add(Component
                    .translatable("tooltip.actuallyelectrical.resistor_through_hole.color")
                    .append(Component.literal(": "))
                    .append(ResistorColor.byId(record.firstDigit(), false).getTranslatedName())
                    .append(Component.literal("-"))
                    .append(ResistorColor.byId(record.secondDigit(), false).getTranslatedName())
                    .append(Component.literal("-"))
                    .append(ResistorColor.byId(record.thirdDigit(), false).getTranslatedName())
                    .append(Component.literal("-"))
                    .append(ResistorColor.byId(record.exponent(), true).getTranslatedName())
                    .append(Component.literal("-"))
                    // Hard-code red because of only using the 1% tolerance resistor style
                    .append(ResistorColor.RED.getTranslatedName())
                    .withStyle(ChatFormatting.GRAY));
        }
        //</editor-fold>
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
