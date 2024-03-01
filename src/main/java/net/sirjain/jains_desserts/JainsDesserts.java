package net.sirjain.jains_desserts;

import net.fabricmc.api.ModInitializer;
import net.sirjain.jains_desserts.blocks.JDBlocks;
import net.sirjain.jains_desserts.items.JDItems;

public class JainsDesserts implements ModInitializer {
	public static final String MOD_ID = "jains_desserts";

	@Override
	public void onInitialize() {
		System.out.println("Hello, Jain's Desserts!");

		JDBlocks.registerBlocks();
		JDItems.registerItems();
		JDItems.addItemsToTabs();
	}
}
