package z3roco01.chickennugget;

import net.fabricmc.api.ModInitializer;
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

        LOGGER.info("Finished init !");
    }
}
