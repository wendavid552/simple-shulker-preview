package com.bvengo.simpleshulkerpreview.util;

import com.bvengo.simpleshulkerpreview.SimpleShulkerPreviewMod;
import net.fabricmc.loader.api.FabricLoader;

public class AutoMixinAuditExecutor {
    private static final String KEYWORD_PROPERTY = "simpleshulkerpreview.mixin_audit";

    public static void run() {
        if (FabricLoader.getInstance().isDevelopmentEnvironment() && "true".equals(System.getProperty(KEYWORD_PROPERTY))) {
            SimpleShulkerPreviewMod.LOGGER.info("Triggered auto mixin audit");
            boolean ok = MixinUtil.audit(null);
            SimpleShulkerPreviewMod.LOGGER.info("Mixin audit result: " + (ok ? "successful" : "failed"));
            System.exit(ok ? 0 : 1);
        }
    }
}