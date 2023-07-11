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

public class MortarAndPestleRecipeSerializer implements RecipeSerializer<MortarAndPestleRecipe> {
    private MortarAndPestleRecipeSerializer() {}
    public static final MortarAndPestleRecipeSerializer INSTANCE = new MortarAndPestleRecipeSerializer();
    public static final Identifier ID = mkId("mortar_and_pestle_recipe");
    @Override
    public MortarAndPestleRecipe read(Identifier id, JsonObject json) {
        MortarAndPestleRecipe.JsonFormat recipeJson = new Gson().fromJson(json, MortarAndPestleRecipe.JsonFormat.class);

        if(recipeJson.ingredient1 == null || recipeJson.ingredient2 == null || recipeJson.ingredient3 == null || recipeJson.result == null) {
            throw new JsonParseException("A needed JsonObject is missing !");
        }

        Ingredient ingred1 = Ingredient.fromJson(recipeJson.ingredient1);
        Ingredient ingred2 = Ingredient.fromJson(recipeJson.ingredient2);
        Ingredient ingred3 = Ingredient.fromJson(recipeJson.ingredient3);

        String outputId     = recipeJson.result.get("item").getAsString();
        int    outputAmount = recipeJson.result.get("amount").getAsInt();
        if(outputId.isEmpty() || outputAmount < 1) {
            throw new JsonParseException("Result JsonObject has invalid data !");
        }
        ItemStack output = new ItemStack(Registries.ITEM.getOrEmpty(new Identifier(outputId)).orElseThrow(() -> new JsonSyntaxException("No such item " + outputId + " !")), outputAmount);

        return new MortarAndPestleRecipe(ingred1, ingred2, ingred3, output, id);
    }

    @Override
    public MortarAndPestleRecipe read(Identifier id, PacketByteBuf buf) {
        Ingredient ingred1 = Ingredient.fromPacket(buf);
        Ingredient ingred2 = Ingredient.fromPacket(buf);
        Ingredient ingred3 = Ingredient.fromPacket(buf);
        ItemStack  output  = buf.readItemStack();

        return new MortarAndPestleRecipe(ingred1, ingred2, ingred3, output, id);
    }

    @Override
    public void write(PacketByteBuf buf, MortarAndPestleRecipe recipe) {
        recipe.getIngred1().write(buf);
        recipe.getIngred2().write(buf);
        recipe.getIngred3().write(buf);
        buf.writeItemStack(recipe.getOutput());
    }
}
