package net.sirjain.tiramisu.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;

public class TiramisuBlock extends CakeBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2, 0, 2, 14, 7, 14);

    public TiramisuBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(BITES, 0));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected static ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canConsume(false)) {
            return ActionResult.PASS;
        } else {
            player.incrementStat(Stats.EAT_CAKE_SLICE);
            player.getHungerManager().add(3, 0.1F);
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 8, 0));

            int bitesState = state.get(BITES);
            world.emitGameEvent(player, GameEvent.EAT, pos);

            if (bitesState < 6) {
                world.setBlockState(pos, state.with(BITES, bitesState + 1), 3);
            } else {
                world.removeBlock(pos, false);
                world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }

            return ActionResult.SUCCESS;
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (world.isClient) {
            if (tryEat(world, pos, state, player).isAccepted()) {
                return ActionResult.SUCCESS;
            }

            if (itemStack.isEmpty()) {
                return ActionResult.CONSUME;
            }
        }

        return tryEat(world, pos, state, player);
    }
}
