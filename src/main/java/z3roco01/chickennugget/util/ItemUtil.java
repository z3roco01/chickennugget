package z3roco01.chickennugget.util;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;

public class ItemUtil {
    public static boolean addToFirstEmpty(Inventory inv, ItemStack stack) {
        for(int i = 0; i < inv.size(); ++i) {
            ItemStack curStack = inv.getStack(i);
            if(curStack.isEmpty()) {
                inv.setStack(i, stack.copyWithCount(1));
                return true;
            }
        }
        return false;
    }

    public static ItemStack getFirstAndEmpty(Inventory inv) {
        ItemStack ret = ItemStack.EMPTY;
        for(int i = 0; i < inv.size(); ++i) {
            ItemStack curStack = inv.getStack(i);
            if(!curStack.isEmpty()) {
                ret = curStack.copyAndEmpty();

                break;
            }
        }
        return ret;
    }

    public static boolean isFull(Inventory inv) {
        boolean full = true;
        for(int i = 0; i < inv.size(); ++i) {
            if(inv.getStack(i).isEmpty()) {
                full = false;
                break;
            }
        }

        return full;
    }

    public static void emptyInv(Inventory inv) {
        for(int i = 0; i < inv.size(); ++i) {
            inv.setStack(i, ItemStack.EMPTY);
        }
    }

    public static boolean invTest(Inventory inv, Ingredient ingred) {
        boolean ret = false;
        for(int i = 0; i < inv.size(); ++i) {
            if(ingred.test(inv.getStack(i))) {
                ret = true;
                break;
            }
        }

        return ret;
    }
}
