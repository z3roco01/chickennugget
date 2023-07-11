package z3roco01.chickennugget.recipe;

import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import static z3roco01.chickennugget.util.ItemUtil.*;

public class MortarAndPestleRecipe implements Recipe<SimpleInventory> {
    private final Ingredient ingred1;
    private final Ingredient ingred2;
    private final Ingredient ingred3;
    private final ItemStack  output;
    private final Identifier id;
    public MortarAndPestleRecipe(Ingredient ingred1, Ingredient ingred2, Ingredient ingred3, ItemStack output, Identifier id) {
        this.ingred1 = ingred1;
        this.ingred2 = ingred2;
        this.ingred3 = ingred3;
        this.output  = output;
        this.id      = id;
    }

    @Override
    public boolean matches(SimpleInventory inv, World world) {
        if(inv.size() != 3) return false;
        return invTest(inv, ingred1) && invTest(inv, ingred2) && invTest(inv, ingred3);
    }

    @Override
    public ItemStack craft(SimpleInventory inv, DynamicRegistryManager registryManager) {
        return ItemStack.EMPTY;
    }

    public Ingredient getIngred1() {
        return ingred1;
    }

    public Ingredient getIngred2() {
        return ingred2;
    }

    public Ingredient getIngred3() {
        return ingred3;
    }

    public ItemStack getOutput() {
        return output;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return MortarAndPestleRecipeSerializer.INSTANCE;
    }

    public static class Type implements RecipeType<MortarAndPestleRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "mortar_and_pestle_recipe";
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public class JsonFormat {
        JsonObject ingredient1;
        JsonObject ingredient2;
        JsonObject ingredient3;
        JsonObject result;
    }

}
