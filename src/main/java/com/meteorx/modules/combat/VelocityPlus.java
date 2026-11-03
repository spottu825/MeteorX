package com.meteorx.modules.combat;

import meteordevelopment.meteorclient.events.packets.PacketEvent;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;

public class VelocityPlus extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Double> horizontal = sgGeneral.add(new DoubleSetting.Builder()
        .name("horizontal")
        .description("Horizontal velocity modifier.")
        .defaultValue(0.0)
        .min(0)
        .max(1)
        .sliderMax(1)
        .build()
    );

    private final Setting<Double> vertical = sgGeneral.add(new DoubleSetting.Builder()
        .name("vertical")
        .description("Vertical velocity modifier.")
        .defaultValue(0.0)
        .min(0)
        .max(1)
        .sliderMax(1)
        .build()
    );

    private final Setting<Boolean> onlyInAir = sgGeneral.add(new BoolSetting.Builder()
        .name("only-in-air")
        .description("Only modify velocity while in air.")
        .defaultValue(false)
        .build()
    );

    public VelocityPlus() {
        super(Categories.Combat, "velocity-plus", "Reduces knockback. Inspired by Meteor / DoomsDay velocity modules.");
    }

    @EventHandler
    private void onPacketReceive(PacketEvent.Receive event) {
        if (!(event.packet instanceof EntityVelocityUpdateS2CPacket packet)) return;
        if (mc.player == null) return;
        if (packet.getEntityId() != mc.player.getId()) return;

        if (onlyInAir.get() && mc.player.isOnGround()) return;

        event.cancel();
    }
}
