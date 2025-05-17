package com.hamderber.actuallyelectrical.common.registries;

import com.hamderber.actuallyelectrical.common.item.ItemDebuggerTool;
import com.hamderber.actuallyelectrical.common.registration.ItemDeferredRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class ActuallyElectricalItems {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister();

    //<editor-fold desc="Items">
    public static final DeferredItem<Item> ITEM_DEBUGGER_TOOL =
            ITEMS.registerItem("item_debugger_tool",
                    ItemDebuggerTool::new,
                    new Item.Properties());
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
