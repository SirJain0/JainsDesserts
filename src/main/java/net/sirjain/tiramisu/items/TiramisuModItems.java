package net.sirjain.tiramisu.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.sirjain.tiramisu.TiramisuMod;
import net.sirjain.tiramisu.blocks.TiramisuModBlocks;

public class TiramisuModItems {
    public static Item TIRAMISU_BLOCK_ITEM;
    public static Item BITESIZED_TIRAMISU;

    public static void registerItems() {
        TIRAMISU_BLOCK_ITEM = Registry.register(
                Registries.ITEM,
                new Identifier(TiramisuMod.MOD_ID, "tiramisu"),
                new BlockItem(TiramisuModBlocks.TIRAMISU_BLOCK, new Item.Settings())
        );

        BITESIZED_TIRAMISU = Registry.register(
                Registries.ITEM,
                new Identifier(TiramisuMod.MOD_ID, "bitesized_tiramisu"),
                new Item(new Item.Settings().food(TiramisuFoodComponents.BITESIZED_TIRAMISU))
        );
    }

    public static void addItemsToTabs() {
        addItemToTab(ItemGroups.FOOD_AND_DRINK, TIRAMISU_BLOCK_ITEM);
        addItemToTab(ItemGroups.FOOD_AND_DRINK, BITESIZED_TIRAMISU);
    }


    public static void addItemToTab(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
}