package z3roco01.chickennugget.block;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;

public class MortarAndPestleBlockEntityRenderer implements BlockEntityRenderer<MortarAndPestleBlockEntity> {
    public MortarAndPestleBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(MortarAndPestleBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();

        matrices.translate(0.5, 0.25, 0.5);
        matrices.scale(0.625f, 0.625f, 0.625f);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(270));
        //matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));

        ItemStack stack1 = entity.getStack(0);
        ItemStack stack2 = entity.getStack(1);
        ItemStack stack3 = entity.getStack(2);

        MinecraftClient.getInstance().getItemRenderer().renderItem(stack1, ModelTransformationMode.GROUND, light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
        int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
        MinecraftClient.getInstance().getItemRenderer().renderItem(stack1, ModelTransformationMode.GROUND, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 0);

        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(120));
        MinecraftClient.getInstance().getItemRenderer().renderItem(stack2, ModelTransformationMode.GROUND, light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
        lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
        MinecraftClient.getInstance().getItemRenderer().renderItem(stack2, ModelTransformationMode.GROUND, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 0);

        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(120));
        MinecraftClient.getInstance().getItemRenderer().renderItem(stack3, ModelTransformationMode.GROUND, light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
        lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
        MinecraftClient.getInstance().getItemRenderer().renderItem(stack3, ModelTransformationMode.GROUND, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 0);

        matrices.pop();
    }
}
