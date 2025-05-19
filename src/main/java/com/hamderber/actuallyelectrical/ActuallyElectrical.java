package com.hamderber.actuallyelectrical;

import com.hamderber.actuallyelectrical.common.registration.DataComponentTypes;
import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalBlocks;
import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalCreativeTabs;
import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalItems;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(ActuallyElectrical.MODID)
public class ActuallyElectrical
{
    public static final String MODID = "actuallyelectrical";

    public ActuallyElectrical(IEventBus modEventBus, ModContainer modContainer)
    {
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        addRegistrationListeners(modEventBus);
    }

    private void addRegistrationListeners(IEventBus modEventBus) {
        ActuallyElectricalItems.ITEMS.register(modEventBus);
        ActuallyElectricalBlocks.BLOCKS.register(modEventBus);
        ActuallyElectricalCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        DataComponentTypes.register(modEventBus);
    }
}
