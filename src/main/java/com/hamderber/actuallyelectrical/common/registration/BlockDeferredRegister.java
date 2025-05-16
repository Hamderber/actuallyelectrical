package com.hamderber.actuallyelectrical.common.registration;

import com.hamderber.actuallyelectrical.ActuallyElectrical;
import com.hamderber.actuallyelectrical.common.Logger;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

public class BlockDeferredRegister extends DeferredRegister.Blocks {
    public BlockDeferredRegister() {
        super(ActuallyElectrical.MODID);
    }

    @Override
    public void register(@NotNull IEventBus modEventBus){
        super.register(modEventBus);
        Logger.debugRegisterTypeComplete(this);
    }
}
