package net.sirjain.jains_desserts.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class JDFoodComponents {
    public static final FoodComponent BITESIZED_TIRAMISU = new FoodComponent.Builder()
            .saturationModifier(1.1f)
            .hunger(2)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*5, 0), 0.8F)
            .build();

    public static final FoodComponent BITESIZED_JELLY = new FoodComponent.Builder()
            .saturationModifier(1.1f)
            .hunger(2)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*4, 0), 0.5F)
            .build();

    public static final FoodComponent CHOCOLATE_CUPCAKE = registerBasicFoodComponent(2);
    public static final FoodComponent CREAM_CUPCAKE = registerBasicFoodComponent(2);
    public static final FoodComponent CHOCOLATE_ICECREAM = registerBasicFoodComponent(2);
    public static final FoodComponent ICECREAM_SUNDAE = registerBasicFoodComponent(3);
    public static final FoodComponent SUFFLE = registerBasicFoodComponent(3);

    public static FoodComponent registerBasicFoodComponent(int hunger) {
        return new FoodComponent.Builder()
                .saturationModifier(1.1f)
                .hunger(hunger)
                .build();
    }
}