package com.hamderber.actuallyelectrical.datagen;

import com.hamderber.actuallyelectrical.ActuallyElectrical;
import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ActuallyElectrical.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //<editor-fold desc="Items">
        handheldItem(ActuallyElectricalItems.ITEM_DEBUGGER_TOOL.get());
        basicItem(ActuallyElectricalItems.FLAME_RESISTANT_COTTON.get());
        basicItem(ActuallyElectricalItems.ARC_FLASH_HELMET.get());
        basicItem(ActuallyElectricalItems.ARC_FLASH_CHESTPLATE.get());
        basicItem(ActuallyElectricalItems.ARC_FLASH_LEGGINGS.get());
        basicItem(ActuallyElectricalItems.ARC_FLASH_BOOTS.get());
        //</editor-fold>
    }
}
