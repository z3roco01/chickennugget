package z3roco01.chickennugget.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import z3roco01.chickennugget.recipe.MortarAndPestleRecipe;

import java.util.Optional;

import static z3roco01.chickennugget.ChickenNugget.LOGGER;
import static z3roco01.chickennugget.util.ItemUtil.*;

public class MortarAndPestle extends Block implements BlockEntityProvider {
    public MortarAndPestle() {
        super(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.isClient) return ActionResult.SUCCESS;

        Inventory inv       = (Inventory) world.getBlockEntity(pos);
        ItemStack handStack = player.getStackInHand(hand);
        Optional<MortarAndPestleRecipe> match = world.getRecipeManager().getFirstMatch(MortarAndPestleRecipe.Type.INSTANCE, new SimpleInventory(inv.getStack(0), inv.getStack(1), inv.getStack(2)), world);

        if(player.isSneaking() || match.isEmpty()){
            if(handStack.isEmpty() || isFull(inv) || player.isSneaking()) {
                if(!inv.isEmpty()) {
                    player.getInventory().offerOrDrop(getFirstAndEmpty(inv));
                }
            }else {
                if(addToFirstEmpty(inv, handStack)) {
                    handStack.decrement(1);
                }
            }
        }else if(match.isPresent()) {
            for(int i = 0; i < inv.size(); ++i) {
                ItemStack curStack = inv.getStack(i);
                if(!curStack.getRecipeRemainder().isEmpty())
                    player.getInventory().offerOrDrop(curStack.getRecipeRemainder());
            }
            emptyInv(inv);

            player.getInventory().offerOrDrop(match.get().getOutput().copy());
        }

        world.updateListeners(pos, state, state, Block.NOTIFY_LISTENERS);
        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MortarAndPestleBlockEntity(pos, state);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(
                VoxelShapes.cuboid(0.125,  0,      0.125,  0.875,  0.0625, 0.875),
                VoxelShapes.cuboid(0.1875, 0.0625, 0.1875, 0.8125, 0.125,  0.8125),
                VoxelShapes.cuboid(0.125,  0.125,  0.125,  0.875,  0.25,   0.875),
                VoxelShapes.cuboid(0.0625, 0.25,   0.0625, 0.9375, 0.375,  0.9375),
                VoxelShapes.cuboid(0,      0.375,  0,      1,      0.5,    1)
        );
    }
}
