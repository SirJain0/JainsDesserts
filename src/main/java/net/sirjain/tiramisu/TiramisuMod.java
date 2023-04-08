package net.sirjain.tiramisu;

import net.fabricmc.api.ModInitializer;
import net.sirjain.tiramisu.blocks.TiramisuModBlocks;
import net.sirjain.tiramisu.items.TiramisuModItems;

public class TiramisuMod implements ModInitializer {
	public static final String MOD_ID = "tiramisu";

	@Override
	public void onInitialize() {
		System.out.println("Hello, Tiramisu Mod!");

		TiramisuModBlocks.registerBlocks();
		TiramisuModItems.registerItems();
		TiramisuModItems.addItemsToTabs();
	}
}
