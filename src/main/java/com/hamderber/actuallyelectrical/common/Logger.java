package com.hamderber.actuallyelectrical.common;

import com.hamderber.actuallyelectrical.ActuallyElectrical;
import com.mojang.logging.LogUtils;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Logger {
    private static final org.slf4j.Logger LOGGER = LogUtils.getLogger();

    public static <T> void debugRegisterTypeComplete(DeferredRegister<T> register) {
        LOGGER.debug("Completed registration for DeferredRegister<{}> with mod ID: {}",
                register.getRegistryKey().location(), ActuallyElectrical.MODID);
    }
}
