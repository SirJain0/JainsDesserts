package net.sirjain.jains_desserts.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.sirjain.jains_desserts.JainsDesserts;
import net.sirjain.jains_desserts.blocks.JDBlocks;

public class JDItems {
    public static Item TIRAMISU_BLOCK_ITEM;
    public static Item SWEET_BERRY_PIE_BLOCK_ITEM;
    public static Item BANANA_CREAM_PIE_BLOCK_ITEM;
    public static Item CARROT_CAKE_BLOCK_ITEM;

    public static Item BITESIZED_TIRAMISU;
    public static Item BITESIZED_JELLY;
    public static Item CHOCOLATE_CUPCAKE;
    public static Item CREAM_CUPCAKE;
    public static Item CHOCOLATE_ICECREAM;
    public static Item ICECREAM_SUNDAE;
    public static Item SUFFLE;

    public static void registerItems() {
        TIRAMISU_BLOCK_ITEM = registerBlockItem("tiramisu", JDBlocks.TIRAMISU_BLOCK);
        SWEET_BERRY_PIE_BLOCK_ITEM = registerBlockItem("sweet_berry_pie", JDBlocks.SWEET_BERRY_PIE);
        BANANA_CREAM_PIE_BLOCK_ITEM = registerBlockItem("banana_cream_pie", JDBlocks.BANANA_CREAM_PIE);
        CARROT_CAKE_BLOCK_ITEM = registerBlockItem("carrot_cake", JDBlocks.CARROT_CAKE);

        BITESIZED_TIRAMISU = registerFoodItem("bitesized_tiramisu", JDFoodComponents.BITESIZED_TIRAMISU);
        BITESIZED_JELLY = registerFoodItem("bitesized_jelly", JDFoodComponents.BITESIZED_JELLY);
        CHOCOLATE_CUPCAKE = registerFoodItem("chocolate_cupcake", JDFoodComponents.CHOCOLATE_CUPCAKE);
        CREAM_CUPCAKE = registerFoodItem("cream_cupcake", JDFoodComponents.CREAM_CUPCAKE);
        CHOCOLATE_ICECREAM = registerFoodItem("chocolate_icecream", JDFoodComponents.CHOCOLATE_ICECREAM);
        ICECREAM_SUNDAE = registerFoodItem("icecream_sundae", JDFoodComponents.ICECREAM_SUNDAE);
        SUFFLE = registerFoodItem("suffle", JDFoodComponents.SUFFLE);
    }

    public static BlockItem registerBlockItem(String id, Block block) {
        return Registry.register(
                Registries.ITEM,
                new Identifier(JainsDesserts.MOD_ID, id),
                new BlockItem(block, new Item.Settings())
        );
    }

    public static Item registerFoodItem(String id, FoodComponent foodComponent) {
        return Registry.register(
                Registries.ITEM,
                new Identifier(JainsDesserts.MOD_ID, id),
                new Item(new Item.Settings().food(foodComponent))
        );
    }

    public static void addItemsToTabs() {
        addItemToTab(TIRAMISU_BLOCK_ITEM);
        addItemToTab(SWEET_BERRY_PIE_BLOCK_ITEM);
        addItemToTab(BANANA_CREAM_PIE_BLOCK_ITEM);
        addItemToTab(CARROT_CAKE_BLOCK_ITEM);

        addItemToTab(BITESIZED_TIRAMISU);
        addItemToTab(BITESIZED_JELLY);
        addItemToTab(CHOCOLATE_CUPCAKE);
        addItemToTab(CREAM_CUPCAKE);
        addItemToTab(CHOCOLATE_ICECREAM);
        addItemToTab(ICECREAM_SUNDAE);
        addItemToTab(SUFFLE);
    }

    public static void addItemToTab(Item item) {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(item));
    }
}