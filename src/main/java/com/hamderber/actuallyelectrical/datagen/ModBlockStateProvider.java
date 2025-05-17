package com.hamderber.actuallyelectrical.datagen;

import com.hamderber.actuallyelectrical.ActuallyElectrical;
import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider  extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ActuallyElectrical.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ActuallyElectricalBlocks.MACHINE_CHASSIS);

        blockWithItemBlockbenchModel(ActuallyElectricalBlocks.CIRCUIT_DESIGN_BENCH,
                "block/circuit_design_bench");
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockWithItemBlockbenchModel(DeferredBlock<?> deferredBlock, String path) {
        simpleBlockWithItem(deferredBlock.get(), models().getExistingFile(modLoc(path)));
    }
}
