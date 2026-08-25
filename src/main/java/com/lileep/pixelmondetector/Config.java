package com.lileep.pixelmondetector;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {

    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec CLIENT_SPEC;

    public static final ModConfigSpec.IntValue RANGE;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        RANGE = builder
                .comment("Detection radius in blocks")
                .defineInRange("range", 32, 1, 256);

        SPEC = builder.build();
        CLIENT_SPEC = SPEC;
    }
}
