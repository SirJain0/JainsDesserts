package net.sirjain.tiramisu.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.sirjain.tiramisu.TiramisuMod;

public class TiramisuModBlocks {
    public static Block TIRAMISU_BLOCK;

    public static void registerBlocks() {
        TIRAMISU_BLOCK = Registry.register(
                Registries.BLOCK,
                new Identifier(TiramisuMod.MOD_ID, "tiramisu"),
                new TiramisuBlock(AbstractBlock.Settings.create().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).nonOpaque())
        );
    }
}
