package com.meteorx.modules.combat;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.entity.SortPriority;
import meteordevelopment.meteorclient.utils.entity.TargetUtils;
import meteordevelopment.meteorclient.utils.player.PlayerUtils;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

public class KillAuraPlus extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final SettingGroup sgTargeting = settings.createGroup("Targeting");
    private final SettingGroup sgRotation = settings.createGroup("Rotation");

    private final Setting<Double> range = sgGeneral.add(new DoubleSetting.Builder()
        .name("range")
        .description("Maximum attack range.")
        .defaultValue(4.2)
        .min(1)
        .max(6)
        .sliderMax(6)
        .build()
    );

    private final Setting<Double> wallsRange = sgGeneral.add(new DoubleSetting.Builder()
        .name("walls-range")
        .description("Range through walls.")
        .defaultValue(3.5)
        .min(0)
        .max(6)
        .sliderMax(6)
        .build()
    );

    private final Setting<Integer> delay = sgGeneral.add(new IntSetting.Builder()
        .name("delay")
        .description("Attack delay in ticks.")
        .defaultValue(0)
        .min(0)
        .max(20)
        .build()
    );

    private final Setting<Boolean> players = sgTargeting.add(new BoolSetting.Builder()
        .name("players")
        .description("Target players.")
        .defaultValue(true)
        .build()
    );

    private final Setting<Boolean> animals = sgTargeting.add(new BoolSetting.Builder()
        .name("animals")
        .description("Target animals.")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> monsters = sgTargeting.add(new BoolSetting.Builder()
        .name("monsters")
        .description("Target monsters.")
        .defaultValue(true)
        .build()
    );

    private final Setting<SortPriority> priority = sgTargeting.add(new EnumSetting.Builder<SortPriority>()
        .name("priority")
        .description("How to sort targets.")
        .defaultValue(SortPriority.ClosestAngle)
        .build()
    );

    private final Setting<Boolean> rotate = sgRotation.add(new BoolSetting.Builder()
        .name("rotate")
        .description("Rotate towards the target.")
        .defaultValue(true)
        .build()
    );

    private int hitTimer;

    public KillAuraPlus() {
        super(Categories.Combat, "kill-aura-plus", "Improved KillAura inspired by Meteor + LiquidBounce style.");
    }

    @EventHandler
    private void onTick(TickEvent.Pre event) {
        if (mc.player == null || mc.world == null) return;
        if (mc.player.isDead() || mc.player.isSpectator()) return;

        if (hitTimer > 0) {
            hitTimer--;
            return;
        }

        Entity target = TargetUtils.get(entity -> {
            if (!(entity instanceof LivingEntity living) || living.isDead()) return false;
            if (entity == mc.player) return false;
            if (!PlayerUtils.isWithin(entity, range.get())) return false;

            if (entity instanceof PlayerEntity) return players.get();
            return monsters.get() || animals.get();
        }, priority.get());

        if (target == null) return;

        if (rotate.get()) {
            // rotation placeholder
        }

        if (mc.player.getAttackCooldownProgress(0.5f) < 1.0f && delay.get() == 0) return;

        mc.interactionManager.attackEntity(mc.player, target);
        mc.player.swingHand(Hand.MAIN_HAND);
        hitTimer = delay.get();
    }
}
