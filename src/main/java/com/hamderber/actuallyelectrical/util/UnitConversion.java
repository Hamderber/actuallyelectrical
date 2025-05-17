package com.hamderber.actuallyelectrical.util;

public class UnitConversion {
    /*
    RF = energy, RF/tick = power

    1 RF = 1 Joule
    1 tick = 1/20 sec
    1 RF/tick = 20 RF/sec = 20 Joules/sec = 20 watts
    1 RF = 1 watt*second
    1 watt = 1 RF/tick * (1/20)

    therefore,

    1kWh = 3,600,00 J = 3,600,000 RF
     */
    public static float rfTokWh(float rf) {
        return rf / 3_600_000f;
    }

    public static float kWhToRF(float kwh) {
        return kwh * 3_600_000f;
    }

    public static float rfTickToWatts(float rfPerTick) {
        return rfPerTick * 20f;
    }

    public static float wattsToRFTick(float watts) {
        return watts / 20f;
    }
}
