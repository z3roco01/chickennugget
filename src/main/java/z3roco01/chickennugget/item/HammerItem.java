package z3roco01.chickennugget.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.Item;

public class HammerItem extends Item {
    public HammerItem() {
        super(new FabricItemSettings().maxDamage(128));
    }
}
