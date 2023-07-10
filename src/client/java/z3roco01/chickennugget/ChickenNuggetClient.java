package z3roco01.chickennugget;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import z3roco01.chickennugget.registry.BlockEntityRenderer;

@Environment(EnvType.CLIENT)
public class ChickenNuggetClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRenderer.register();
    }
}
