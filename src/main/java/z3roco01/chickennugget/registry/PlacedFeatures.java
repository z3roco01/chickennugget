package z3roco01.chickennugget.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import static z3roco01.chickennugget.util.IdUtil.mkId;

public class PlacedFeatures {
    public static RegistryKey<PlacedFeature> SALT_BLOCK_PLACED_KEY;

    public static void register() {
        SALT_BLOCK_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, mkId("salt_field"));

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, PlacedFeatures.SALT_BLOCK_PLACED_KEY);
    }
}
