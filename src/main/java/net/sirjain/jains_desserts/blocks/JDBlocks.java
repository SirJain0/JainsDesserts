package net.sirjain.jains_desserts.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.sirjain.jains_desserts.JainsDesserts;

public class JDBlocks {
    public static Block TIRAMISU_BLOCK;
    public static Block SWEET_BERRY_PIE;
    public static Block BANANA_CREAM_PIE;

    public static void registerBlocks() {
        TIRAMISU_BLOCK = registerBlock("tiramisu", new TiramisuBlock(getBlockSettings()));
        SWEET_BERRY_PIE = registerBlock("sweet_berry_pie", new PieBlock(getBlockSettings()));
        BANANA_CREAM_PIE = registerBlock("banana_cream_pie", new PieBlock(getBlockSettings()));
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
