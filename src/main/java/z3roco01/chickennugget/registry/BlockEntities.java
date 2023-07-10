package z3roco01.chickennugget.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import z3roco01.chickennugget.block.CuttingBoard;
import z3roco01.chickennugget.block.CuttingBoardBlockEntity;

import static z3roco01.chickennugget.registry.Blocks.CUTTING_BOARD;
import static z3roco01.chickennugget.util.IdUtil.mkId;

public class BlockEntities {
    public static BlockEntityType<CuttingBoardBlockEntity> CUTTING_BOARD_BLOCK_ENTITY;
    public static void register () {
        CUTTING_BOARD_BLOCK_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                mkId("cutting_board_block_entity"),
                FabricBlockEntityTypeBuilder.create(CuttingBoardBlockEntity::new, CUTTING_BOARD).build()
        );
    }
}
