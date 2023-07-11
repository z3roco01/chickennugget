package z3roco01.chickennugget.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import z3roco01.chickennugget.recipe.CuttingBoardRecipe;
import z3roco01.chickennugget.recipe.MortarAndPestleRecipe;
import z3roco01.chickennugget.recipe.MortarAndPestleSameRecipe;

import static z3roco01.chickennugget.util.IdUtil.mkId;

public class RecipeType {

    public static void register() {
        Registry.register(Registries.RECIPE_TYPE, mkId(CuttingBoardRecipe.Type.ID),        CuttingBoardRecipe.Type.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, mkId(MortarAndPestleRecipe.Type.ID),     MortarAndPestleRecipe.Type.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, mkId(MortarAndPestleSameRecipe.Type.ID), MortarAndPestleSameRecipe.Type.INSTANCE);
    }
}
