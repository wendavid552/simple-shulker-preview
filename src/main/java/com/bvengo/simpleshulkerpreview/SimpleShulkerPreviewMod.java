package com.bvengo.simpleshulkerpreview;

import com.bvengo.simpleshulkerpreview.config.ConfigOptions;
import com.bvengo.simpleshulkerpreview.util.AutoMixinAuditExecutor;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Simple Shulker Preview Mod
 */
@Environment(EnvType.CLIENT)
public class SimpleShulkerPreviewMod implements ClientModInitializer {
    public static final String MOD_ID = "simpleshulkerpreview";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
        AutoMixinAuditExecutor.run();
        LOGGER.info(LOGGER.getName() + " loading...");

		AutoConfig.register(ConfigOptions.class, GsonConfigSerializer::new);

		LOGGER.info(LOGGER.getName() + " loaded.");


    }
}
