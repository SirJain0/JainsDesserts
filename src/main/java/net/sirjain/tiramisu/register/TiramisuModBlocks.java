package net.sirjain.tiramisu.register;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.sirjain.tiramisu.TiramisuMod;
import net.sirjain.tiramisu.blocks.TiramisuBlock;

public class TiramisuModBlocks {
    public static Block TIRAMISU_BLOCK;

    public static void registerBlocks() {
        TIRAMISU_BLOCK = Registry.register(
                Registries.BLOCK,
                new Identifier(TiramisuMod.MOD_ID, "tiramisu"),
                new TiramisuBlock(AbstractBlock.Settings.of(Material.CAKE).strength(0.5F).sounds(BlockSoundGroup.WOOL).nonOpaque())
        );
    }
}
