package com.aarone.mineandblade

import net.minecraft.client.Minecraft
import net.minecraft.world.item.Item
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.entity.player.EntityItemPickupEvent
import net.minecraftforge.eventbus.api.Event
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.runForDist

/**
 * Main mod class. Should be an `object` declaration annotated with `@Mod`.
 * The modid should be declared in this object and should match the modId entry
 * in mods.toml.
 *
 * An example for blocks is in the `blocks` package of this mod.
 */
@Mod(MineAndBladeMod.ID)
object MineAndBladeMod {
    const val ID = "mine_and_blade"

    // the logger for our mod
    val LOGGER: Logger = LogManager.getLogger(ID)

    init {
        runForDist(
            clientTarget = {
                MinecraftForge.EVENT_BUS.register(VillagerInteractionEventHandler(LOGGER))
                MOD_BUS.addListener(MineAndBladeMod::onClientSetup)
            },
            serverTarget = {
                MOD_BUS.addListener(MineAndBladeMod::onServerSetup)
            })
    }

    /**
     * This is used for initializing client specific
     * things such as renderers and keymaps
     * Fired on the mod specific event bus.
     */
    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.log(Level.INFO, "Initializing client...")
    }

    /**
     * Fired on the global Forge bus.
     */
    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {
        LOGGER.log(Level.INFO, "Server starting...")
    }
}