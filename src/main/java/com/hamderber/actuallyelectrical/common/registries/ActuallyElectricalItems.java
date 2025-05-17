package com.hamderber.actuallyelectrical.common.registries;

import com.hamderber.actuallyelectrical.common.item.ItemDebuggerTool;
import com.hamderber.actuallyelectrical.common.registration.ItemDeferredRegister;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class ActuallyElectricalItems {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister();

    //<editor-fold desc="Items">
    public static final DeferredItem<ItemDebuggerTool> ITEM_DEBUGGER_TOOL =
            ITEMS.registerItem("item_debugger_tool",
                    ItemDebuggerTool::new,
                    new Item.Properties());

    public static final DeferredItem<Item> EXAMPLE_ITEM =
            ITEMS.registerSimpleItem("example_item",
                    new Item.Properties()
                            .food(new FoodProperties.Builder()
                                    .alwaysEdible()
                                    .nutrition(1)
                                    .saturationModifier(2f)
                                    .build()));
    //</editor-fold>

    //<editor-fold desc="BlockItems">
    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM =
            ITEMS.registerSimpleBlockItem("example_block",
                    ActuallyElectricalBlocks.EXAMPLE_BLOCK);

    public static final DeferredItem<BlockItem> MACHINE_CHASSIS_ITEM =
            ITEMS.registerSimpleBlockItem("machine_chassis",
                    ActuallyElectricalBlocks.MACHINE_CHASSIS);
    //</editor-fold>
}
