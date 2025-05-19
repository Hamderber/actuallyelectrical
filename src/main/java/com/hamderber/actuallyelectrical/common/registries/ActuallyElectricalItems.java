package com.hamderber.actuallyelectrical.common.registries;

import com.hamderber.actuallyelectrical.common.item.ItemDebuggerTool;
import com.hamderber.actuallyelectrical.common.registration.ItemDeferredRegister;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class ActuallyElectricalItems {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister();

    public static final int ARC_FLASH_DURABILITY_FACTOR = 15;

    //<editor-fold desc="Items">
    public static final DeferredItem<Item> ITEM_DEBUGGER_TOOL =
            ITEMS.registerItem("item_debugger_tool",
                    ItemDebuggerTool::new,
                    new Item.Properties());

    public static final DeferredItem<Item> FLAME_RESISTANT_COTTON =
            ITEMS.registerSimpleItem("flame_resistant_cotton");
    //</editor-fold>

    //<editor-fold desc="Armor">
    public static final DeferredItem<ArmorItem> ARC_FLASH_HELMET =
            ITEMS.register("arc_flash_helmet",
                    () -> new ArmorItem(ActuallyElectricalArmorMaterials.ARC_FLASH_ARMOR_MATERIAL,
                            ArmorItem.Type.HELMET,
                            new Item.Properties().durability(ArmorItem.Type.HELMET
                                    .getDurability(ARC_FLASH_DURABILITY_FACTOR))));

    public static final DeferredItem<ArmorItem> ARC_FLASH_CHESTPLATE =
            ITEMS.register("arc_flash_chestplate",
                    () -> new ArmorItem(ActuallyElectricalArmorMaterials.ARC_FLASH_ARMOR_MATERIAL,
                            ArmorItem.Type.CHESTPLATE,
                            new Item.Properties().durability(ArmorItem.Type.CHESTPLATE
                                    .getDurability(ARC_FLASH_DURABILITY_FACTOR))));

    public static final DeferredItem<ArmorItem> ARC_FLASH_LEGGINGS =
            ITEMS.register("arc_flash_leggings",
                    () -> new ArmorItem(ActuallyElectricalArmorMaterials.ARC_FLASH_ARMOR_MATERIAL,
                            ArmorItem.Type.LEGGINGS,
                            new Item.Properties().durability(ArmorItem.Type.LEGGINGS
                                    .getDurability(ARC_FLASH_DURABILITY_FACTOR))));

    public static final DeferredItem<ArmorItem> ARC_FLASH_BOOTS =
            ITEMS.register("arc_flash_boots",
                    () -> new ArmorItem(ActuallyElectricalArmorMaterials.ARC_FLASH_ARMOR_MATERIAL,
                            ArmorItem.Type.BOOTS,
                            new Item.Properties().durability(ArmorItem.Type.BOOTS
                                    .getDurability(ARC_FLASH_DURABILITY_FACTOR))));
    //</editor-fold>

    //<editor-fold desc="BlockItems">
    public static final DeferredItem<BlockItem> CIRCUIT_DESIGN_BENCH_ITEM =
            ITEMS.registerSimpleBlockItem("circuit_design_bench",
                    ActuallyElectricalBlocks.CIRCUIT_DESIGN_BENCH);

    public static final DeferredItem<BlockItem> MACHINE_CHASSIS_ITEM =
            ITEMS.registerSimpleBlockItem("machine_chassis",
                    ActuallyElectricalBlocks.MACHINE_CHASSIS);
    //</editor-fold>
}
