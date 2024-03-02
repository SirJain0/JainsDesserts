package net.sirjain.jains_desserts.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.ShapeContext;
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

public class PieBlock extends CakeBlock {
    public static final VoxelShape SHAPE_1 = Block.createCuboidShape(1, 0, 1, 15, 5, 15);
    public static final VoxelShape SHAPE_2 = Block.createCuboidShape(1, 0, 1, 15, 5, 15);
    public static final VoxelShape SHAPE_3 = Block.createCuboidShape(1, 0, 8, 15, 5, 15);
    public static final VoxelShape SHAPE_4 = Block.createCuboidShape(1, 0, 8, 8, 5, 15);
    public static VoxelShape[] BITES_TO_SHAPE = new VoxelShape[] { SHAPE_1, SHAPE_2, SHAPE_3, SHAPE_4, SHAPE_4, SHAPE_4, SHAPE_4 };

    public PieBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(BITES, 0));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BITES_TO_SHAPE[(state.get(BITES))];
    }

    protected static ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canConsume(false)) {
            return ActionResult.PASS;
        } else {
            player.incrementStat(Stats.EAT_CAKE_SLICE);
            player.getHungerManager().add(2, 0.3F);

            int bitesState = state.get(BITES);
            world.emitGameEvent(player, GameEvent.EAT, pos);

            if (bitesState < 3) {
                world.setBlockState(pos, state.with(BITES, bitesState + 1), Block.NOTIFY_LISTENERS);
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
