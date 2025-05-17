package com.hamderber.actuallyelectrical.datagen;

import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalBlocks;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
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
        //https://youtu.be/T-9h-FbAQH0?si=KI9VrJniNrj_XORq&t=1492
        // define CHAR not STRING !!
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ActuallyElectricalBlocks.MACHINE_CHASSIS.get())
                .pattern(" f ")
                .pattern(" i ")
                .pattern("   ")
                .define('f', Items.FLINT.asItem())
                .define('i', Items.IRON_BLOCK.asItem())
                .unlockedBy("has_air", InventoryChangeTrigger.TriggerInstance.hasItems(Items.AIR))
                .save(recipeOutput);
    }
}
