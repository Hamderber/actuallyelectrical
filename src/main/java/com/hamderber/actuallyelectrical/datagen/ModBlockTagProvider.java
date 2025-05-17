package com.hamderber.actuallyelectrical.datagen;

import com.hamderber.actuallyelectrical.ActuallyElectrical;
import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ActuallyElectrical.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ActuallyElectricalBlocks.CIRCUIT_DESIGN_BENCH.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ActuallyElectricalBlocks.MACHINE_CHASSIS.get());
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ActuallyElectricalBlocks.MACHINE_CHASSIS.get());
    }
}
