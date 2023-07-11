package z3roco01.chickennugget.recipe;

import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class MortarAndPestleSameRecipe extends MortarAndPestleRecipe {
    private static Ingredient ingred;
    public MortarAndPestleSameRecipe(Ingredient ingred, ItemStack output, Identifier id) {
        super(ingred, ingred, ingred, output, id);
        this.ingred = ingred;
    }

    @Override
    public boolean matches(SimpleInventory inv, World world) {
        if(inv.size() != 3) return false;
        return ingred.test(inv.getStack(0)) && ingred.test(inv.getStack(1)) && ingred.test(inv.getStack(2));
    }

    public Ingredient getIngred() {
        return ingred;
    }

    public static class Type implements RecipeType<MortarAndPestleRecipe> {
        private Type() {}
        public static final MortarAndPestleSameRecipe.Type INSTANCE = new MortarAndPestleSameRecipe.Type();
        public static final String ID = "mortar_and_pestle_same_recipe";
    }

    public class JsonFormat {
        JsonObject ingredient;
        JsonObject result;
    }
}
