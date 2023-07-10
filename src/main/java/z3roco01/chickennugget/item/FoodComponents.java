package z3roco01.chickennugget.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class FoodComponents {
    public static final FoodComponent ChickenNuggetFoodComponent       = mkMeatFoodComponent(5,0.6F, new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.15F);
    public static final FoodComponent CookedChickenNuggetFoodComponent = mkMeatFoodComponent(12, 1.2F);
    public static final FoodComponent ChickenPieceFoodComponent        = mkMeatFoodComponent(2, 0.3F, new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3F);
    public static final FoodComponent BreadingFoodComponent            = mkFoodComponent(3, 0.3F);
    public static final FoodComponent ToastFoodComponent               = mkFoodComponent(10, 0.7F);

    private static FoodComponent mkFoodComponent(int hunger, float saturation) {
        return mkFoodComponentBuilder(hunger, saturation, null, null).build();
    }
    private static FoodComponent mkFoodComponent(int hunger, float saturation, @Nullable StatusEffectInstance statusEffect, @Nullable Float chance) {
        return mkFoodComponentBuilder(hunger, saturation, statusEffect, chance).build();
    }

    private static FoodComponent mkMeatFoodComponent(int hunger, float saturation) {
        return mkFoodComponentBuilder(hunger, saturation, null, null).meat().build();
    }

    private static FoodComponent mkMeatFoodComponent(int hunger, float saturation, @Nullable StatusEffectInstance statusEffect, @Nullable Float chance) {
        return mkFoodComponentBuilder(hunger, saturation, statusEffect, chance).meat().build();
    }

    private static FoodComponent.Builder mkFoodComponentBuilder(int hunger, float saturation, @Nullable StatusEffectInstance statusEffect, @Nullable Float chance) {
        FoodComponent.Builder builder = (new FoodComponent.Builder()).hunger(hunger).saturationModifier(saturation);
        if(statusEffect != null && chance != null)
            builder.statusEffect(statusEffect, chance);

        return builder;
    }
}
