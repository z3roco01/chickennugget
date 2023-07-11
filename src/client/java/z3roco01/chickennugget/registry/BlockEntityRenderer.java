package z3roco01.chickennugget.registry;

import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import z3roco01.chickennugget.block.CuttingBoardBlockEntityRenderer;
import z3roco01.chickennugget.block.MortarAndPestleBlockEntityRenderer;

public class BlockEntityRenderer {
    public static void register() {
        BlockEntityRendererRegistry.register(BlockEntities.CUTTING_BOARD_BLOCK_ENTITY, CuttingBoardBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockEntities.MORTAR_AND_PESTLE_BLOCK_ENTITY, MortarAndPestleBlockEntityRenderer::new);
    }
}
