package com.hamderber.actuallyelectrical.common.registries;

import com.hamderber.actuallyelectrical.ActuallyElectrical;
import com.hamderber.actuallyelectrical.common.registration.CreativeTabDeferredRegister;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ActuallyElectricalCreativeTabs {
    public static final CreativeTabDeferredRegister CREATIVE_MODE_TABS = new CreativeTabDeferredRegister();

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB =
            CREATIVE_MODE_TABS.register(ActuallyElectrical.MODID, () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.actuallyelectrical"))
                .icon(() -> ActuallyElectricalItems.CIRCUIT_DESIGN_BENCH_ITEM
                    .get()
                    .getDefaultInstance())
                .displayItems((parameters, output) -> {
                    ActuallyElectricalItems.ITEMS
                        .getEntries()
                        .stream()
                        .map(DeferredHolder::value)
                        .forEach(output::accept);
                }).build());
}
