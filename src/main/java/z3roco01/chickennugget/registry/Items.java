package z3roco01.chickennugget.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import z3roco01.chickennugget.item.HammerItem;
import z3roco01.chickennugget.item.KnifeItem;
import z3roco01.chickennugget.item.RamenItem;

import static z3roco01.chickennugget.item.FoodComponents.*;
import static z3roco01.chickennugget.util.IdUtil.mkId;

public class Items {
    public static final Item CHICKEN_NUGGET        = new Item(new FabricItemSettings().food(ChickenNuggetFoodComponent));
    public static final Item COOKED_CHICKEN_NUGGET = new Item(new FabricItemSettings().food(CookedChickenNuggetFoodComponent));
    public static final Item BREADING              = new Item(new FabricItemSettings().food(BreadingFoodComponent));
    public static final Item TOAST                 = new Item(new FabricItemSettings().food(ToastFoodComponent));
    public static final Item CHICKEN_PIECE         = new Item(new FabricItemSettings().food(ChickenPieceFoodComponent));
    public static final Item KNIFE                 = new KnifeItem();
    public static final Item HAMMER                = new HammerItem();
    public static final Item CUTTING_BOARD_ITEM    = new BlockItem(Blocks.CUTTING_BOARD, new FabricItemSettings());


    public static void register() {
        Registry.register(Registries.ITEM, mkId("chicken_nugget"),        CHICKEN_NUGGET);
        Registry.register(Registries.ITEM, mkId("cooked_chicken_nugget"), COOKED_CHICKEN_NUGGET);
        Registry.register(Registries.ITEM, mkId("breading"),              BREADING);
        Registry.register(Registries.ITEM, mkId("toast"),                 TOAST);
        Registry.register(Registries.ITEM, mkId("chicken_piece"),         CHICKEN_PIECE);
        Registry.register(Registries.ITEM, mkId("knife"),                 KNIFE);
        Registry.register(Registries.ITEM, mkId("hammer"),                HAMMER);
        Registry.register(Registries.ITEM, mkId("cutting_board"),         CUTTING_BOARD_ITEM);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.add(CHICKEN_NUGGET);
            content.add(COOKED_CHICKEN_NUGGET);
            content.add(BREADING);
            content.add(TOAST);
            content.add(CHICKEN_PIECE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.add(KNIFE);
            content.add(HAMMER);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.add(CUTTING_BOARD_ITEM);
        });
    }
}
