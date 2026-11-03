package com.meteorx;

import com.meteorx.modules.combat.*;
import com.meteorx.modules.movement.*;
import com.meteorx.modules.render.*;
import com.meteorx.modules.player.*;
import com.meteorx.modules.world.*;
import com.meteorx.modules.misc.*;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MeteorX extends MeteorAddon {
    public static final Logger LOG = LoggerFactory.getLogger("MeteorX");

    @Override
    public void onInitialize() {
        LOG.info("MeteorX loading — Meteor style GUI + modules inspired by Meteor / LiquidBounce / DoomsDay");

        // Combat
        Modules.get().add(new KillAuraPlus());
        Modules.get().add(new TriggerBot());
        Modules.get().add(new VelocityPlus());
        Modules.get().add(new CriticalsPlus());
        Modules.get().add(new AutoTotemPlus());
        Modules.get().add(new AimAssist());

        // Movement
        Modules.get().add(new SpeedPlus());
        Modules.get().add(new Strafe());
        Modules.get().add(new FlightPlus());
        Modules.get().add(new ScaffoldPlus());
        Modules.get().add(new NoSlowPlus());
        Modules.get().add(new JesusPlus());
        Modules.get().add(new SpiderPlus());

        // Render
        Modules.get().add(new ESPPlus());
        Modules.get().add(new TracersPlus());
        Modules.get().add(new NametagsPlus());
        Modules.get().add(new XrayPlus());
        Modules.get().add(new FullbrightPlus());
        Modules.get().add(new StorageESP());

        // Player
        Modules.get().add(new AutoArmorPlus());
        Modules.get().add(new FastUse());
        Modules.get().add(new NoFallPlus());
        Modules.get().add(new InventoryMove());

        // World
        Modules.get().add(new NukerPlus());
        Modules.get().add(new TimerPlus());

        // Misc
        Modules.get().add(new MiddleClickFriend());
        Modules.get().add(new DiscordRPC());

        LOG.info("MeteorX modules registered.");
    }

    @Override
    public void onRegisterCategories() {
        // Using default Meteor categories so GUI stays 100% native
    }

    @Override
    public String getPackage() {
        return "com.meteorx";
    }
}
