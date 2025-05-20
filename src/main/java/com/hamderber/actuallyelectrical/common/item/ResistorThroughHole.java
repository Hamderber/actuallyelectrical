package com.hamderber.actuallyelectrical.common.item;

import com.hamderber.actuallyelectrical.common.registration.DataComponentTypes;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Supplier;

public class ResistorThroughHole extends Item {
    public ResistorThroughHole(Properties properties) {
        super(properties);
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level world, Player player) {
        if (!stack.has(DataComponentTypes.RESISTANCE_VALUE.get())) {
            stack.set(DataComponentTypes.RESISTANCE_VALUE.get(), 1000.); // default 1k
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        var resistanceValue = stack.get(DataComponentTypes.RESISTANCE_VALUE);

        if (resistanceValue == null || resistanceValue == -1) {
            tooltipComponents.add(Component
                    .translatable("tooltip.actuallyelectrical.resistor_through_hole.tooltip_invalid"));
        }
        else {
            tooltipComponents.add(Component
                    .translatable("tooltip.actuallyelectrical.resistor_through_hole.tooltip")
                    .append(Component.literal(": " + resistanceValue)));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
