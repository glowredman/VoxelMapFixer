package glowredman.voxelmapfixer.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.thevoxelbox.voxelmap.j;

import net.minecraft.client.Minecraft;

@Mixin(value = j.class, remap = false)
public class MapMixin {
	
	@Redirect(
			method = "if(Lnet/minecraft/client/Minecraft;)V",
			at = @At(value = "INVOKE", target = "Lcom/thevoxelbox/voxelmap/util/v;new()I", remap = false),
			remap = false)
	private int yCoord() {
		return (int) (Minecraft.getMinecraft().thePlayer.posY - 1);
	}

}
