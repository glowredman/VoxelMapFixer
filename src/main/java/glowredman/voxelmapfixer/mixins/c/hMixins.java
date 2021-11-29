package glowredman.voxelmapfixer.mixins.c;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import cpw.mods.fml.common.FMLCommonHandler;

@Mixin(targets = "com.thevoxelbox.voxelmap.c.h", remap = false)
public class hMixins {
	
	
	@Redirect(
			method = {"if()V", "for()V"},
			at = @At(value = "INVOKE", target = "Ljava/lang/System;exit(I)V", remap = false),
			remap = false)
	private static void exit(int status) {
		FMLCommonHandler.instance().exitJava(status, false);
	}

}
