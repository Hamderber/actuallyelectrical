package com.hamderber.actuallyelectrical.common.registries;

import com.hamderber.actuallyelectrical.ActuallyElectrical;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ActuallyElectricalArmorMaterials {
    public static final Holder<ArmorMaterial> ARC_FLASH_ARMOR_MATERIAL = register("arc_flash",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 1);
                attribute.put(ArmorItem.Type.LEGGINGS, 2);
                attribute.put(ArmorItem.Type.CHESTPLATE, 3);
                attribute.put(ArmorItem.Type.HELMET, 1);
            }), 12, 0, 0, SoundEvents.ARMOR_EQUIP_LEATHER,
            ActuallyElectricalItems.FLAME_RESISTANT_COTTON);

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
                                                  int enchantibility, float toughness, float knockbackResistance,
                                                  Holder<SoundEvent> equipSound, Supplier<Item> ingredientItem) {
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath(ActuallyElectrical.MODID, name);
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(resourceLocation));

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, resourceLocation,
                new ArmorMaterial(typeProtection, enchantibility, equipSound, ingredient, layers, toughness, knockbackResistance));
    }
}
