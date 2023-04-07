package net.sirjain.tiramisu.register;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sirjain.tiramisu.TiramisuMod;

public class TiramisuModItems {
    public static Item TIRAMISU_BLOCK_ITEM;

    public static void registerItems() {
        TIRAMISU_BLOCK_ITEM = Registry.register(
                Registries.ITEM,
                new Identifier(TiramisuMod.MOD_ID, "tiramisu"),
                new BlockItem(TiramisuModBlocks.TIRAMISU_BLOCK, new Item.Settings())
        );
    }

    public static void addItemsToTabs() {
        addItemToTab(ItemGroups.FOOD_AND_DRINK, TIRAMISU_BLOCK_ITEM);
    }


    public static void addItemToTab(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
}