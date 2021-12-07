package glowredman.voxelmapfixer.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.thevoxelbox.voxelmap.j;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;

@Mixin(j.class)
public class MapMixin {
	
	@Redirect(
			method = "if(Lnet/minecraft/client/Minecraft;)V", //drawMinimap
			at = @At(value = "INVOKE", target = "Lcom/thevoxelbox/voxelmap/util/v;new()I", remap = false),
			remap = false)
	private int yCoord() {
		return (int) (Minecraft.getMinecraft().thePlayer.posY - 1);
	}
	
	@Redirect(
			method = "<init>(Lcom/thevoxelbox/voxelmap/interfaces/IVoxelMap;)V",
			at = @At(value = "INVOKE", target = "Lcom/thevoxelbox/voxelmap/b/y;do(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;I)Ljava/lang/Object;", remap = false),
			remap = false)
	private Object getPrivateFieldValueByType(Object var0, Class<?> var1, Class<?> var2, int var3) {
		return RenderManager.instance.entityRenderMap;
	}

}
