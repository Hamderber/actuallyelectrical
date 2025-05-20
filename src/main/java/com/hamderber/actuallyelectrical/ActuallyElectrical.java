package com.hamderber.actuallyelectrical;

import com.hamderber.actuallyelectrical.common.Logger;
import com.hamderber.actuallyelectrical.common.registration.DataComponentTypes;
import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalBlocks;
import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalCreativeTabs;
import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalItems;

import com.hamderber.actuallyelectrical.util.ResistorColorUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import java.util.Arrays;
import java.util.stream.Collectors;

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

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents{
        @SubscribeEvent
        public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event) {
            // Parameters are the item stack and the tint index.
            event.register((stack, tintIndex) -> {
                        Double resistance = stack.get(DataComponentTypes.RESISTANCE_VALUE);
                        if (resistance == null) return -1;

                        int[] bandColors = ResistorColorUtils.getColorBands(resistance);

                        if (tintIndex <= 0 || tintIndex > bandColors.length) {
                            return -1;
                        }

                        Logger.LOGGER.debug("Tint index: {}, Resistance: {}, BandColors: [{}]",
                                tintIndex, resistance, Arrays.stream(bandColors)
                                        .mapToObj(c -> String.format("#%06X", c))
                                        .collect(Collectors.joining(", "))
                        );

                        // tintIndex corresponds to the model's layer.
                        return bandColors[tintIndex - 1]; // offset by 1 because bandColors[0] = layer1
                    },
                    // A varargs of items to apply the tinting to
                    ActuallyElectricalItems.RESISTOR_THROUGH_HOLE.value());
        }
    }
}
