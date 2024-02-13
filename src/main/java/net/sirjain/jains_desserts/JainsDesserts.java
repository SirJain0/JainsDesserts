package net.sirjain.jains_desserts;

import net.fabricmc.api.ModInitializer;
import net.sirjain.jains_desserts.blocks.TiramisuModBlocks;
import net.sirjain.jains_desserts.items.TiramisuModItems;

public class JainsDesserts implements ModInitializer {
	public static final String MOD_ID = "tiramisu";

	@Override
	public void onInitialize() {
		System.out.println("Hello, Tiramisu Mod!");

		TiramisuModBlocks.registerBlocks();
		TiramisuModItems.registerItems();
		TiramisuModItems.addItemsToTabs();
	}
}
