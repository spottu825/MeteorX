# MeteorX

Meteor Client Addon – clean native Meteor GUI + modules inspired by Meteor / LiquidBounce / DoomsDay.

## Branches

| Branch | Minecraft | Java | Status |
|--------|-----------|------|--------|
| `main` | **1.21.4** | 21 | Ready |
| `26.3` | **26.3** | 25 | Ready |

## Modules included
Combat: KillAuraPlus, TriggerBot, VelocityPlus, CriticalsPlus, AutoTotemPlus, AimAssist  
Movement: SpeedPlus, Strafe, FlightPlus, ScaffoldPlus, NoSlowPlus, JesusPlus, SpiderPlus  
Render: ESPPlus, TracersPlus, NametagsPlus, XrayPlus, FullbrightPlus, StorageESP  
Player: AutoArmorPlus, FastUse, NoFallPlus, InventoryMove  
World: NukerPlus, TimerPlus  
Misc: MiddleClickFriend, DiscordRPC

## Build

### 1.21.4 (main)
```bash
git checkout main
./gradlew build
```

### 26.3
```bash
git checkout 26.3
# Requires Java 25
./gradlew build
```

Jar appears in `build/libs/`

## Install
1. Matching Fabric + Meteor Client for your version
2. Fabric API
3. Drop the jar in mods/
4. Right Shift → modules appear in normal Meteor categories

Works with Sodium + performance mods.
