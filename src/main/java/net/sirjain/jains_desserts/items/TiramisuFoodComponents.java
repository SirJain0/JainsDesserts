package net.sirjain.jains_desserts.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class TiramisuFoodComponents {
    public static final FoodComponent BITESIZED_TIRAMISU = new FoodComponent.Builder()
            .saturationModifier(1.1f)
            .hunger(2)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*5, 0), 0.8F)
            .build();
}