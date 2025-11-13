package com.quibus7.railwaymod;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main entry point for the Procedural Railway Worldgen Mod
 * Handles mod initialization and lifecycle events
 */
@Mod("railwaymod")
public class Common {
    public static final String MOD_ID = "railwaymod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public Common() {
        LOGGER.info("Procedural Railway Worldgen Mod initializing...");
    }
}