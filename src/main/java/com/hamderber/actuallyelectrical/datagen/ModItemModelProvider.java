package com.hamderber.actuallyelectrical.datagen;

import com.hamderber.actuallyelectrical.ActuallyElectrical;
import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ActuallyElectrical.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //<editor-fold desc="Items">
        basicItem(ActuallyElectricalItems.ITEM_DEBUGGER_TOOL.get());
        //</editor-fold>

        //<editor-fold desc="BlockItems">
        basicItemBlockbenchModel(ActuallyElectricalItems
                .CIRCUIT_DESIGN_BENCH_ITEM, "circuit_design_bench", "block/circuit_design_bench");

        simpleBlockItem(ActuallyElectricalItems.MACHINE_CHASSIS_ITEM.get().getBlock());
        //</editor-fold>
    }

    private void basicItemBlockbenchModel(DeferredItem<?> deferredItem, String name, String path){
        getBuilder(name).parent(new ModelFile.UncheckedModelFile(modLoc(path)));
    }
}
