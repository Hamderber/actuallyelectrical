package com.hamderber.actuallyelectrical.common.registries;

import com.hamderber.actuallyelectrical.common.registration.BlockDeferredRegister;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ActuallyElectricalBlocks {
    public static final DeferredRegister.Blocks BLOCKS = new BlockDeferredRegister();

    public static final DeferredBlock<Block> EXAMPLE_BLOCK =
            BLOCKS.registerSimpleBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
}
