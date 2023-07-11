package z3roco01.chickennugget.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import z3roco01.chickennugget.recipe.CuttingBoardRecipeSerializer;
import z3roco01.chickennugget.recipe.MortarAndPestleRecipeSerializer;
import z3roco01.chickennugget.recipe.MortarAndPestleSameRecipeSerializer;

import static z3roco01.chickennugget.util.IdUtil.mkId;

public class RecipeSerializer {

    public static void register() {
        Registry.register(Registries.RECIPE_SERIALIZER, CuttingBoardRecipeSerializer.ID,        CuttingBoardRecipeSerializer.INSTANCE);
        Registry.register(Registries.RECIPE_SERIALIZER, MortarAndPestleRecipeSerializer.ID,     MortarAndPestleRecipeSerializer.INSTANCE);
        Registry.register(Registries.RECIPE_SERIALIZER, MortarAndPestleSameRecipeSerializer.ID, MortarAndPestleSameRecipeSerializer.INSTANCE);
    }
}
