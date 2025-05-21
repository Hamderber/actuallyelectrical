package com.hamderber.actuallyelectrical.client;

import com.hamderber.actuallyelectrical.common.registration.DataComponentTypes;
import com.hamderber.actuallyelectrical.common.registries.ActuallyElectricalItems;
import com.hamderber.actuallyelectrical.records.ResistanceRecord;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import static com.hamderber.actuallyelectrical.ActuallyElectrical.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents{
    @SubscribeEvent
    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event) {
        // https://docs.neoforged.net/docs/1.21.1/resources/client/models/
        // Parameters are the item stack and the tint index.
        event.register((stack, tintIndex) -> {
                    Double resistance = stack.get(DataComponentTypes.RESISTANCE_VALUE);
                    if (resistance == null) return -1;

                    ResistanceRecord resistanceRecord = ResistanceRecord.create(resistance);
                    int[] bandColors = resistanceRecord.getColorBands();

                    if (tintIndex <= 0 || tintIndex > bandColors.length) {
                        return -1;
                    }

                    // offset by 1 because bandColors[0] = layer1
                    return bandColors[tintIndex - 1];
                },
                // A varargs of items to apply the tinting to
                ActuallyElectricalItems.RESISTOR_THROUGH_HOLE.value());
    }
}
