package net.sirjain.jains_desserts.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.sirjain.jains_desserts.JainsDesserts;

public class JDBlocks {
    public static Block LARGE_CAKE;
    public static Block TIRAMISU_BLOCK;
    public static Block SWEET_BERRY_PIE;
    public static Block BANANA_CREAM_PIE;
    public static Block CARROT_CAKE;
    public static Block CHOCOLATE_CAKE;

    public static void registerBlocks() {
        LARGE_CAKE = registerBlock("large_cake", new LargeCakeBlock(getBlockSettings()));
        TIRAMISU_BLOCK = registerBlock("tiramisu", new TiramisuBlock(getBlockSettings()));
        SWEET_BERRY_PIE = registerBlock("sweet_berry_pie", new PieBlock(getBlockSettings()));
        BANANA_CREAM_PIE = registerBlock("banana_cream_pie", new PieBlock(getBlockSettings()));
        CARROT_CAKE = registerBlock("carrot_cake", new CarrotCakeBlock(getBlockSettings()));
        CHOCOLATE_CAKE = registerBlock("chocolate_cake", new ChocolateCakeBlock(getBlockSettings()));
    }

    public static Block registerBlock(String id, Block block) {
        return Registry.register(
                Registries.BLOCK,
                new Identifier(JainsDesserts.MOD_ID, id),
                block
        );
    }

    public static AbstractBlock.Settings getBlockSettings() {
        return AbstractBlock.Settings.create().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).nonOpaque();
    }
}
