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

public class ActuallyElectricalBlocks {
    public static final DeferredRegister.Blocks BLOCKS = new BlockDeferredRegister();

    //<editor-fold desc="Obtainable">
    public static final DeferredBlock<Block> CIRCUIT_DESIGN_BENCH =
            BLOCKS.registerSimpleBlock("circuit_design_bench",
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WOOD)
                            .strength(2.5F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava());

    public static final DeferredBlock<Block> MACHINE_CHASSIS =
            BLOCKS.registerSimpleBlock("machine_chassis",
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.METAL)
                            .requiresCorrectToolForDrops()
                            .strength(5.0F, 6.0F)
                            .sound(SoundType.METAL));
    //</editor-fold>

    //<editor-fold desc="Unobtainable">
//    public static final DeferredBlock<Block> UNOBTAINABLE_BLOCK =
//            BLOCKS.registerSimpleBlock("unobtainable_block",
//                    BlockBehaviour.Properties.of()
//                            .mapColor(MapColor.STONE)
//                            .noLootTable());
    //</editor-fold>
}
