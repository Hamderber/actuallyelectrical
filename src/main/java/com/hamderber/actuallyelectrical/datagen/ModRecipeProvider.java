package com.hamderber.actuallyelectrical.datagen;

import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalBlocks;
import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        //https://docs.neoforged.net/docs/resources/server/tags/#using-tags
        //https://youtu.be/T-9h-FbAQH0?si=KI9VrJniNrj_XORq&t=1492
        // define CHAR not STRING !!
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ActuallyElectricalBlocks.CIRCUIT_DESIGN_BENCH.get())
                .pattern("rby")
                .pattern("ppp")
                .pattern(" c ")
                .define('r', ItemTags
                        .create(ResourceLocation.fromNamespaceAndPath("c", "dyes/red")))
                .define('b', ItemTags
                        .create(ResourceLocation.fromNamespaceAndPath("c", "dyes/blue")))
                .define('y', ItemTags
                        .create(ResourceLocation.fromNamespaceAndPath("c", "dyes/yellow")))
                .define('p', Items.PAPER.asItem())
                .define('c', Items.CRAFTING_TABLE.asItem())
                .unlockedBy("has_air", InventoryChangeTrigger.TriggerInstance.hasItems(Items.AIR))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ActuallyElectricalBlocks.MACHINE_CHASSIS.get())
                .pattern(" f ")
                .pattern(" i ")
                .pattern("   ")
                .define('f', Items.FLINT.asItem())
                .define('i', Items.IRON_BLOCK.asItem())
                .unlockedBy("has_air", InventoryChangeTrigger.TriggerInstance.hasItems(Items.AIR))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ActuallyElectricalItems.FLAME_RESISTANT_COTTON.get(), 24)
                .pattern("sws")
                .pattern("wmw")
                .pattern("sws")
                .define('s', ItemTags
                        .create(ResourceLocation.fromNamespaceAndPath("c", "strings")))
                .define('w', ItemTags
                        .create(ResourceLocation.fromNamespaceAndPath("minecraft", "wool")))
                .define('m', Items.MAGMA_CREAM)
                .unlockedBy("has_flame_resistant_cotton",
                        InventoryChangeTrigger
                                .TriggerInstance.hasItems(ActuallyElectricalItems.FLAME_RESISTANT_COTTON.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ActuallyElectricalItems.ARC_FLASH_HELMET.get())
                .pattern("fff")
                .pattern("fbf")
                .pattern("   ")
                .define('f', ActuallyElectricalItems.FLAME_RESISTANT_COTTON.get())
                .define('b', ItemTags
                        .create(ResourceLocation.fromNamespaceAndPath("c", "dyes/blue")))
                .unlockedBy("has_flame_resistant_cotton",
                        InventoryChangeTrigger
                                .TriggerInstance.hasItems(ActuallyElectricalItems.FLAME_RESISTANT_COTTON.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ActuallyElectricalItems.ARC_FLASH_CHESTPLATE.get())
                .pattern("fbf")
                .pattern("fff")
                .pattern("fff")
                .define('f', ActuallyElectricalItems.FLAME_RESISTANT_COTTON.get())
                .define('b', ItemTags
                        .create(ResourceLocation.fromNamespaceAndPath("c", "dyes/blue")))
                .unlockedBy("has_flame_resistant_cotton",
                        InventoryChangeTrigger
                                .TriggerInstance.hasItems(ActuallyElectricalItems.FLAME_RESISTANT_COTTON.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ActuallyElectricalItems.ARC_FLASH_LEGGINGS.get())
                .pattern("fff")
                .pattern("fbf")
                .pattern("f f")
                .define('f', ActuallyElectricalItems.FLAME_RESISTANT_COTTON.get())
                .define('b', ItemTags
                        .create(ResourceLocation.fromNamespaceAndPath("c", "dyes/blue")))
                .unlockedBy("has_flame_resistant_cotton",
                        InventoryChangeTrigger
                                .TriggerInstance.hasItems(ActuallyElectricalItems.FLAME_RESISTANT_COTTON.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ActuallyElectricalItems.ARC_FLASH_BOOTS.get())
                .pattern("fbf")
                .pattern("f f")
                .pattern("   ")
                .define('f', ActuallyElectricalItems.FLAME_RESISTANT_COTTON.get())
                .define('b', ItemTags
                        .create(ResourceLocation.fromNamespaceAndPath("c", "dyes/blue")))
                .unlockedBy("has_flame_resistant_cotton",
                        InventoryChangeTrigger
                                .TriggerInstance.hasItems(ActuallyElectricalItems.FLAME_RESISTANT_COTTON.get()))
                .save(recipeOutput);
    }
}
