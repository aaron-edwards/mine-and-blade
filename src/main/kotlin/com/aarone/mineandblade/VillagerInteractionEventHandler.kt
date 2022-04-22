package com.aarone.mineandblade

import net.minecraft.world.entity.npc.Villager
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.BannerItem
import net.minecraftforge.event.entity.player.PlayerInteractEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import org.apache.logging.log4j.Logger

class VillagerInteractionEventHandler(private val log: Logger) {
    @SubscribeEvent
    fun interact(event: PlayerInteractEvent.EntityInteract) {
        if(event.player.isLocalPlayer && event.target is Villager && event.player.mainHandItem.item is BannerItem) {
            interact(event.player, event.target as Villager)
        }
    }

    private fun interact(player: Player, villager: Villager) {
        log.debug(
            "Interacting with Villager " +
                    "[Profession=${villager.villagerData.profession}]" +
                    "[Type=${villager.villagerData.type}]"
        )
    }
}