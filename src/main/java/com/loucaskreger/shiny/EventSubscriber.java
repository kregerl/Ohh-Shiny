package com.loucaskreger.shiny;

import com.loucaskreger.shiny.goal.VillagerTemptGoal;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Shiny.MOD_ID, value = Dist.CLIENT)
public class EventSubscriber {

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void onEntitySpawn(final EntityJoinWorldEvent event) {
        if (event.getEntity().getType() == EntityType.VILLAGER) {
            var villager = (Villager) event.getEntity();
            villager.goalSelector.addGoal(1, new VillagerTemptGoal(villager));
        }
    }
}
