package com.hamderber.actuallyelectrical.datagen;

import com.hamderber.actuallyelectrical.ActuallyElectrical;
import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ActuallyElectrical.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //<editor-fold desc="Items">
        basicItem(ActuallyElectricalItems.ITEM_DEBUGGER_TOOL.get());
        //</editor-fold>
    }
}
