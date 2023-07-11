package z3roco01.chickennugget;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import z3roco01.chickennugget.registry.*;

public class ChickenNugget implements ModInitializer {
    public static final String MODID = "chickennugget";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public void onInitialize() {
        LOGGER.info("Starting init !");

        Blocks.register();
        BlockEntities.register();
        Items.register();
        RecipeSerializer.register();
        RecipeType.register();
        PlacedFeatures.register();

        LOGGER.info("Finished init !");
    }
}
