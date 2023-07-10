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
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import z3roco01.chickennugget.recipe.CuttingBoardRecipe;

import java.util.Optional;

public class CuttingBoard extends Block implements BlockEntityProvider {
    public CuttingBoard() {
        super(FabricBlockSettings.create());
        this.settings.hardness(2);
        this.settings.strength(3);
        this.settings.sounds(BlockSoundGroup.WOOD);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.isClient) return ActionResult.SUCCESS;

        Inventory inv = (Inventory) world.getBlockEntity(pos);
        ItemStack handItemStack = player.getStackInHand(hand);

        SimpleInventory simpInv = new SimpleInventory(inv.getStack(0), handItemStack);
        Optional<CuttingBoardRecipe> match = world.getRecipeManager().getFirstMatch(CuttingBoardRecipe.Type.INSTANCE, simpInv, world);

        if(match.isPresent() && match.get().getOutput().getItem() != Items.AIR) {
            inv.getStack(0).decrement(1);
            if(handItemStack.isDamageable()) {
                handItemStack.setDamage(handItemStack.getDamage()+1);
                if(handItemStack.getDamage() >= handItemStack.getMaxDamage()){
                    player.sendToolBreakStatus(hand);
                    if(handItemStack.getItem() == z3roco01.chickennugget.registry.Items.HAMMER || handItemStack.getItem() == z3roco01.chickennugget.registry.Items.KNIFE)
                        handItemStack.decrement(1);
                }
                //player.getStackInHand(hand).damage(1, player, (p) -> p.sendToolBreakStatus(hand));
            }else {
                handItemStack.decrement(1);
            }

            player.getInventory().offerOrDrop(match.get().getOutput().copy());
            world.updateListeners(pos, state, state, Block.NOTIFY_LISTENERS);
        }else{
            if(inv.getStack(0).isEmpty()) {
                inv.setStack(0, handItemStack.copyWithCount(1));
                handItemStack.decrement(1);

                player.playSound(SoundEvents.BLOCK_WOOL_PLACE, 1, 1);
            }else {
                player.getInventory().offerOrDrop(inv.getStack(0).copy());
                inv.setStack(0, new ItemStack(Items.AIR, 1));

                player.playSound(SoundEvents.BLOCK_WOOL_PLACE, 1, 1);
            }
        }

        world.updateListeners(pos, state, state, Block.NOTIFY_LISTENERS);
        return ActionResult.SUCCESS;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CuttingBoardBlockEntity(pos, state);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(
                VoxelShapes.cuboid(0.1875f, 0.0f, 0.25f, 0.8125f, 0.0625f, 1.0f),
                VoxelShapes.cuboid(0.3125f, 0.0f, 0.0f,  0.6875f,  0.0625f, 0.25f)
        );
    }
}
