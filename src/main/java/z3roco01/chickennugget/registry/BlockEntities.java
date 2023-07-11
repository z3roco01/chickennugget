package z3roco01.chickennugget.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import z3roco01.chickennugget.block.CuttingBoardBlockEntity;
import z3roco01.chickennugget.block.MortarAndPestleBlockEntity;

import static z3roco01.chickennugget.registry.Blocks.CUTTING_BOARD;
import static z3roco01.chickennugget.registry.Blocks.MORTAR_AND_PESTLE;
import static z3roco01.chickennugget.util.IdUtil.mkId;

public class BlockEntities {
    public static BlockEntityType<CuttingBoardBlockEntity>    CUTTING_BOARD_BLOCK_ENTITY;
    public static BlockEntityType<MortarAndPestleBlockEntity> MORTAR_AND_PESTLE_BLOCK_ENTITY;
    public static void register () {
        CUTTING_BOARD_BLOCK_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                mkId("cutting_board_block_entity"),
                FabricBlockEntityTypeBuilder.create(CuttingBoardBlockEntity::new, CUTTING_BOARD).build()
        );
        MORTAR_AND_PESTLE_BLOCK_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                mkId("mortar_and_pestle_block_entity"),
                FabricBlockEntityTypeBuilder.create(MortarAndPestleBlockEntity::new, MORTAR_AND_PESTLE).build()
        );

    }
}
