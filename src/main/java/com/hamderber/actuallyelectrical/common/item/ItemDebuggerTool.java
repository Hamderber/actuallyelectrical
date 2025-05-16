package com.hamderber.actuallyelectrical.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ItemDebuggerTool extends Item {
    public ItemDebuggerTool(Properties properties) {
        // Set stack size to 1 and have the rarity be uncommon, which makes the name be yellow
        // https://minecraft.wiki/w/Rarity
        super(properties.stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @NotNull
    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if(!world.isClientSide) {
            player.sendSystemMessage(Component
                    .literal("Hello, world!")
                    .withStyle(ChatFormatting.DARK_GREEN)
                    .withStyle(ChatFormatting.BOLD));
        }
        return InteractionResultHolder.sidedSuccess(itemStack, world.isClientSide);
    }
}