package z3roco01.chickennugget.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.Vanishable;

public class KnifeItem extends Item {
    public KnifeItem() {
        super(new FabricItemSettings().maxDamage(128));
    }
}
