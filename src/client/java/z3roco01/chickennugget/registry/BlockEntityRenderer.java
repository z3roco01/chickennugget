package z3roco01.chickennugget.registry;

import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import z3roco01.chickennugget.block.CuttingBoardBlockEntityRenderer;

public class BlockEntityRenderer {
    public static void register() {
        BlockEntityRendererRegistry.register(BlockEntities.CUTTING_BOARD_BLOCK_ENTITY, CuttingBoardBlockEntityRenderer::new);
    }
}
