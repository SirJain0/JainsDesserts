package net.sirjain.jains_desserts.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.sirjain.jains_desserts.blocks.JDBlocks;

public class JainsDessertsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(JDBlocks.SWEET_BERRY_PIE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JDBlocks.BANANA_CREAM_PIE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JDBlocks.CARROT_CAKE, RenderLayer.getCutout());
	}
}