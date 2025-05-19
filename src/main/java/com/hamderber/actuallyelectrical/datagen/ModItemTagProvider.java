package com.hamderber.actuallyelectrical.datagen;

import com.hamderber.actuallyelectrical.ActuallyElectrical;
import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags,
                              @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ActuallyElectrical.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        // add tags that would be made using
        // https://youtu.be/O_Nyak3OtiI?si=JlRv9T_hzCV1m0I8
        // as a reference
        // Ex:
//        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
//                .add(ModItems.RAW_BISMUTH.get());
        // Without this, the enchantment table just says "...?\nLimited Enchantibility" when trying to enchant the armor
        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(ActuallyElectricalItems.ARC_FLASH_HELMET.get());
        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(ActuallyElectricalItems.ARC_FLASH_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR_ENCHANTABLE).add(ActuallyElectricalItems.ARC_FLASH_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR).add(ActuallyElectricalItems.ARC_FLASH_BOOTS.get());
    }
}
