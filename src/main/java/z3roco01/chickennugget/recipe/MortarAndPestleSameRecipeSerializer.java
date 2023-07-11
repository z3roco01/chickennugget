package z3roco01.chickennugget.recipe;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import static z3roco01.chickennugget.util.IdUtil.mkId;

public class MortarAndPestleSameRecipeSerializer implements RecipeSerializer<MortarAndPestleSameRecipe> {
    private MortarAndPestleSameRecipeSerializer() {

    }
    public static final MortarAndPestleSameRecipeSerializer INSTANCE = new MortarAndPestleSameRecipeSerializer();
    public static final Identifier ID = mkId("mortar_and_pestle_same_recipe");
    @Override
    public MortarAndPestleSameRecipe read(Identifier id, JsonObject json) {
        MortarAndPestleSameRecipe.JsonFormat recipeJson = new Gson().fromJson(json, MortarAndPestleSameRecipe.JsonFormat.class);

        if(recipeJson.ingredient == null || recipeJson.result == null) {
            throw new JsonParseException("A needed JsonObject is missing !");
        }

        Ingredient ingred = Ingredient.fromJson(recipeJson.ingredient);

        String outputId     = recipeJson.result.get("item").getAsString();
        int    outputAmount = recipeJson.result.get("amount").getAsInt();
        if(outputId.isEmpty() || outputAmount < 1) {
            throw new JsonParseException("Result JsonObject has invalid data !");
        }
        ItemStack output = new ItemStack(Registries.ITEM.getOrEmpty(new Identifier(outputId)).orElseThrow(() -> new JsonSyntaxException("No such item " + outputId + " !")), outputAmount);

        return new MortarAndPestleSameRecipe(ingred, output, id);
    }

    @Override
    public MortarAndPestleSameRecipe read(Identifier id, PacketByteBuf buf) {
        Ingredient ingred = Ingredient.fromPacket(buf);
        ItemStack  output  = buf.readItemStack();

        return new MortarAndPestleSameRecipe(ingred, output, id);
    }

    @Override
    public void write(PacketByteBuf buf, MortarAndPestleSameRecipe recipe) {
        recipe.getIngred().write(buf);
        buf.writeItemStack(recipe.getOutput());
    }
}
