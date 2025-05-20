package com.hamderber.actuallyelectrical.datagen;

import com.hamderber.actuallyelectrical.ActuallyElectrical;
import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ActuallyElectrical.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //<editor-fold desc="Items">
        handheldItem(ActuallyElectricalItems.ITEM_DEBUGGER_TOOL.get());

        itemWithTintLayers(ActuallyElectricalItems.RESISTOR_THROUGH_HOLE.get(),
                modLoc("item/resistor_through_hole_base"),
                modLoc("item/resistor_through_hole_band_1"),
                modLoc("item/resistor_through_hole_band_2"),
                modLoc("item/resistor_through_hole_band_3"),
                modLoc("item/resistor_through_hole_band_4"));

        basicItem(ActuallyElectricalItems.FLAME_RESISTANT_COTTON.get());
        basicItem(ActuallyElectricalItems.ARC_FLASH_HELMET.get());
        basicItem(ActuallyElectricalItems.ARC_FLASH_CHESTPLATE.get());
        basicItem(ActuallyElectricalItems.ARC_FLASH_LEGGINGS.get());
        basicItem(ActuallyElectricalItems.ARC_FLASH_BOOTS.get());
        //</editor-fold>
    }

    private void itemWithTintLayers(ItemLike item, ResourceLocation... layers) {
        ItemModelBuilder builder = getBuilder(BuiltInRegistries.ITEM.getKey(item.asItem()).getPath())
                .parent(getExistingFile(mcLoc("item/generated")));
        for (int i = 0; i < layers.length; i++) {
            builder.texture("layer" + i, layers[i]);
        }
    }
}
