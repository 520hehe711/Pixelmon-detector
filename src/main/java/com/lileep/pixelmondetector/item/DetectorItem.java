package com.lileep.pixelmondetector.item;

import com.lileep.pixelmondetector.Config;
import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class DetectorItem extends Item {

    public DetectorItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            int range = Config.RANGE.get();

            List<PixelmonEntity> nearby = level.getEntitiesOfClass(
                    PixelmonEntity.class,
                    new AABB(player.blockPosition()).inflate(range),
                    e -> e.isAlive()
            );

            if (nearby.isEmpty()) {
                player.sendSystemMessage(Component.translatable("message.pixelmondetector.none"));
            } else {
                player.sendSystemMessage(Component.translatable("message.pixelmondetector.found", nearby.size()));
            }
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
