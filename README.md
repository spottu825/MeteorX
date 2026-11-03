# MeteorX (1.21.4)

Meteor Client Addon – clean native Meteor GUI + modules inspired by Meteor / LiquidBounce / DoomsDay.

**Target:** Minecraft **1.21.4** (Java 21 friendly so it can be built easily)

## Modules included
Combat: KillAuraPlus, TriggerBot, VelocityPlus, CriticalsPlus, AutoTotemPlus, AimAssist  
Movement: SpeedPlus, Strafe, FlightPlus, ScaffoldPlus, NoSlowPlus, JesusPlus, SpiderPlus  
Render: ESPPlus, TracersPlus, NametagsPlus, XrayPlus, FullbrightPlus, StorageESP  
Player: AutoArmorPlus, FastUse, NoFallPlus, InventoryMove  
World: NukerPlus, TimerPlus  
Misc: MiddleClickFriend, DiscordRPC

## Build (on your machine)

```bash
# Need Java 21+
java -version

# In the MeteorX folder
./gradlew build
# or if no wrapper yet:
gradle wrapper --gradle-version 8.12
./gradlew build
```

Jar → `build/libs/meteorx-1.0.0-1.21.4.jar`

## Install
1. Fabric for 1.21.4
2. Meteor Client for 1.21.4
3. Fabric API
4. Drop the jar in mods/
5. Right Shift → modules appear in normal Meteor categories

Works with Sodium + performance mods.

Want the 26.3 version later? Just say and we can switch back when you have Java 25.
