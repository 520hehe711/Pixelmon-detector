package com.lileep.pixelmondetector;

import com.lileep.pixelmondetector.init.ModItems;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;

@Mod(PixelmonDetector.MODID)
public class PixelmonDetector {

    public static final String MODID = "pixelmondetector";
    public static final Logger LOGGER = LogUtils.getLogger();

    public PixelmonDetector(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.ITEMS.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        modContainer.registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_SPEC);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.DETECTOR_ITEM.get());
        }
    }
}
