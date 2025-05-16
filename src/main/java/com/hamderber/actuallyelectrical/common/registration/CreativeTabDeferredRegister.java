package com.hamderber.actuallyelectrical.common.registration;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import org.jetbrains.annotations.NotNull;

public class CreativeTabDeferredRegister extends ActuallyElectricalDeferredRegister<CreativeModeTab> {
    public CreativeTabDeferredRegister() {
        super(Registries.CREATIVE_MODE_TAB);
    }

    @Override
    public void register(@NotNull IEventBus modEventBus) {
        super.register(modEventBus);
    }
}
