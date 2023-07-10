package z3roco01.chickennugget.recipe;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static z3roco01.chickennugget.util.IdUtil.mkId;

public class CuttingBoardRecipeSerializer implements RecipeSerializer<CuttingBoardRecipe> {
    private CuttingBoardRecipeSerializer() {}
    public static final CuttingBoardRecipeSerializer INSTANCE = new CuttingBoardRecipeSerializer();
    public static final Identifier ID = mkId("cutting_board_recipe");

    @Override
    public CuttingBoardRecipe read(Identifier id, JsonObject json) {
        CuttingBoardRecipe.JsonFormat recipeJson = new Gson().fromJson(json, CuttingBoardRecipe.JsonFormat.class);

        if(recipeJson.onBoard == null || recipeJson.inHand == null || recipeJson.result == null) {
            throw new JsonParseException("A needed JsonObject is missing !");
        }

        Ingredient onBoard = Ingredient.fromJson(recipeJson.onBoard);
        Ingredient inHand  = Ingredient.fromJson(recipeJson.inHand);

        String outputId     = recipeJson.result.get("item").getAsString();
        int    outputAmount = recipeJson.result.get("amount").getAsInt();
        if(outputId.isEmpty() || outputAmount < 1) {
            throw new JsonParseException("Result JsonObject has invalid data !");
        }
        ItemStack output = new ItemStack(Registries.ITEM.getOrEmpty(new Identifier(outputId)).orElseThrow(() -> new JsonSyntaxException("No such item " + outputId + " !")), outputAmount);

        return new CuttingBoardRecipe(onBoard, inHand, output, id);
    }

    @Override
    public CuttingBoardRecipe read(Identifier id, PacketByteBuf buf) {
        Ingredient onBoard = Ingredient.fromPacket(buf);
        Ingredient inHand  = Ingredient.fromPacket(buf);
        ItemStack  output  = buf.readItemStack();

        return new CuttingBoardRecipe(onBoard, inHand, output, id);
    }

    @Override
    public void write(PacketByteBuf buf, CuttingBoardRecipe recipe) {
        recipe.getOnBoard().write(buf);
        recipe.getInHand().write(buf);
        buf.writeItemStack(recipe.getOutput());
    }
}
