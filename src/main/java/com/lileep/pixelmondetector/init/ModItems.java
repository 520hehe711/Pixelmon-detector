package com.lileep.pixelmondetector.init;

import com.lileep.pixelmondetector.PixelmonDetector;
import com.lileep.pixelmondetector.item.DetectorItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(PixelmonDetector.MODID);

    public static final DeferredItem<DetectorItem> DETECTOR_ITEM =
            ITEMS.registerItem(
                    "detector",
                    DetectorItem::new,
                    new Item.Properties().stacksTo(1)
            );
}
