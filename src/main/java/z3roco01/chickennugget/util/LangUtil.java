package z3roco01.chickennugget.util;

import net.minecraft.text.Text;

public class LangUtil {
    public static Text getTooltip(String key) {
        return Text.translatable("item.chickennugget.tooltips" + key);
    }
}
