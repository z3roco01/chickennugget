package z3roco01.chickennugget.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import z3roco01.chickennugget.recipe.CuttingBoardRecipeSerializer;

import static z3roco01.chickennugget.util.IdUtil.mkId;

public class RecipeSerializer {

    public static void register() {
        Registry.register(Registries.RECIPE_SERIALIZER, CuttingBoardRecipeSerializer.ID, CuttingBoardRecipeSerializer.INSTANCE);
    }
}
