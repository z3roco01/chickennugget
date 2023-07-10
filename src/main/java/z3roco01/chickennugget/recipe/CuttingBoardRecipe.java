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

public class CuttingBoardRecipe implements Recipe<SimpleInventory> {
    private final Ingredient onBoard;
    private final Ingredient inHand;
    private final ItemStack  output;
    private final Identifier id;

    public CuttingBoardRecipe(Ingredient onBoard, Ingredient inHand, ItemStack output, Identifier id) {
        this.onBoard = onBoard;
        this.inHand  = inHand;
        this.output  = output;
        this.id      = id;
    }

    @Override
    public boolean matches(SimpleInventory inv, World world) {
        if(inv.size() != 2) return false;
        return onBoard.test(inv.getStack(0)) && inHand.test(inv.getStack(1));
    }

    @Override
    public ItemStack craft(SimpleInventory inv, DynamicRegistryManager registryManager) {
        return ItemStack.EMPTY;
    }

    public Ingredient getOnBoard() {
        return onBoard;
    }

    public Ingredient getInHand() {
        return inHand;
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
        return CuttingBoardRecipeSerializer.INSTANCE;
    }

    public static class Type implements RecipeType<CuttingBoardRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "cutting_board_recipe";
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public class JsonFormat {
        JsonObject onBoard;
        JsonObject inHand;
        JsonObject result;
    }
}
