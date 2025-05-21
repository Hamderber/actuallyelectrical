package com.hamderber.actuallyelectrical.datagen;

import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider  extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        //<editor-fold desc="Obtainable">
        dropSelf(ActuallyElectricalBlocks.CIRCUIT_DESIGN_BENCH.get());
        dropSelf(ActuallyElectricalBlocks.ELECTRICAL_COMPONENT_WORKBENCH.get());
        dropSelf(ActuallyElectricalBlocks.MACHINE_CHASSIS.get());
        //</editor-fold>
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ActuallyElectricalBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
