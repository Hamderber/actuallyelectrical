package com.hamderber.actuallyelectrical.common.registries;

import com.hamderber.actuallyelectrical.common.registration.BlockDeferredRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * For any {@link Block} that should also be obtainable as an {@link Item}, ensure that the associated
 * {@link BlockItem} is registered in the {@link ActuallyElectricalItems} class.
 */
public class ActuallyElectricalBlocks {
    public static final DeferredRegister.Blocks BLOCKS = new BlockDeferredRegister();

    //<editor-fold desc="Obtainable">
    public static final DeferredBlock<Block> EXAMPLE_BLOCK =
            BLOCKS.registerSimpleBlock("example_block",
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .requiresCorrectToolForDrops());

    public static final DeferredBlock<Block> MACHINE_CHASSIS =
            BLOCKS.registerSimpleBlock("machine_chassis",
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.METAL)
                            .requiresCorrectToolForDrops()
                            .strength(5.0F, 6.0F)
                            .sound(SoundType.METAL));
    //</editor-fold>

    //<editor-fold desc="Unobtainable">
    public static final DeferredBlock<Block> UNOBTAINABLE_BLOCK =
            BLOCKS.registerSimpleBlock("unobtainable_block",
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE));
    //</editor-fold>
}
