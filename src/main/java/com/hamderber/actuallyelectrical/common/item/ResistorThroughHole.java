package com.hamderber.actuallyelectrical.common.item;

import com.hamderber.actuallyelectrical.common.registration.DataComponentTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

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
}
