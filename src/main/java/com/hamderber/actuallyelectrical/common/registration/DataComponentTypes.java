package com.hamderber.actuallyelectrical.common.registration;

import com.hamderber.actuallyelectrical.ActuallyElectrical;
import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.UnaryOperator;

public class DataComponentTypes {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, ActuallyElectrical.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Double>> RESISTANCE_VALUE =
            register("resistance_value", builder -> builder.persistent(Codec.DOUBLE));

    private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>>
        register(String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        //https://docs.neoforged.net/docs/1.21.1/items/datacomponents
            return DATA_COMPONENT_TYPES.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }
    public static void register(IEventBus eventBus){
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}
