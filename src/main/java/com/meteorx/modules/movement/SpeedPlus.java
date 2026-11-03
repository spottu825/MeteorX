package com.meteorx.modules.movement;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;

public class SpeedPlus extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Double> speed = sgGeneral.add(new DoubleSetting.Builder()
        .name("speed")
        .description("Movement speed multiplier.")
        .defaultValue(1.6)
        .min(0.1)
        .max(10)
        .sliderMax(5)
        .build()
    );

    private final Setting<Boolean> onlyOnGround = sgGeneral.add(new BoolSetting.Builder()
        .name("only-on-ground")
        .description("Only boost when on ground.")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> inWater = sgGeneral.add(new BoolSetting.Builder()
        .name("in-water")
        .description("Allow in water.")
        .defaultValue(false)
        .build()
    );

    public SpeedPlus() {
        super(Categories.Movement, "speed-plus", "Speed boost inspired by Meteor + LiquidBounce + DoomsDay.");
    }

    @EventHandler
    private void onTick(TickEvent.Pre event) {
        if (mc.player == null) return;
        if (onlyOnGround.get() && !mc.player.isOnGround()) return;
        if (!inWater.get() && mc.player.isTouchingWater()) return;

        if (mc.player.forwardSpeed != 0 || mc.player.sidewaysSpeed != 0) {
            mc.player.setVelocity(
                mc.player.getVelocity().x * speed.get() * 0.3,
                mc.player.getVelocity().y,
                mc.player.getVelocity().z * speed.get() * 0.3
            );
        }
    }
}
