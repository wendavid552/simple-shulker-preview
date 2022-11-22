package com.bvengo.simpleshulkerpreview.util;

import com.bvengo.simpleshulkerpreview.SimpleShulkerPreviewMod;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.BaseText;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.MixinEnvironment;

import static com.bvengo.simpleshulkerpreview.util.Messenger.s;

public final class MixinUtil {
    public static boolean audit(@Nullable ServerCommandSource source) {
        boolean ok;
        BaseText response;
        try {
            MixinEnvironment.getCurrentEnvironment().audit();
            response = s("Mixin environment audited successfully");
            ok = true;
        } catch (Exception e) {
            SimpleShulkerPreviewMod.LOGGER.error("Error when auditing mixin", e);
            response = s(String.format("Mixin environment auditing failed, check console for more information (%s)", e));
            ok = false;
        }
        if (source != null) {
            source.sendFeedback(response, false);
        }
        return ok;
    }
}