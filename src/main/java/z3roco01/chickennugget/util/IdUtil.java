package z3roco01.chickennugget.util;

import net.minecraft.util.Identifier;

import static z3roco01.chickennugget.ChickenNugget.MODID;

public class IdUtil {
    public static Identifier mkId(String id) {
        return new Identifier(MODID, id);
    }
}
