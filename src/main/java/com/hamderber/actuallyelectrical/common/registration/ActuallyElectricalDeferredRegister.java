package com.hamderber.actuallyelectrical.common.registration;

import com.hamderber.actuallyelectrical.ActuallyElectrical;
import com.hamderber.actuallyelectrical.common.Logger;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

public class ActuallyElectricalDeferredRegister<T> extends DeferredRegister<T> {
    public ActuallyElectricalDeferredRegister(ResourceKey<? extends Registry<T>> registryKey) {
        super(registryKey, ActuallyElectrical.MODID);
    }

    @Override
    public void register(@NotNull IEventBus modEventBus){
        super.register(modEventBus);
        Logger.debugRegisterTypeComplete(this);
    }
}
