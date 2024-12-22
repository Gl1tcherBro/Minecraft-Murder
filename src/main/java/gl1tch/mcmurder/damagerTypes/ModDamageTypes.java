package gl1tch.mcmurder.damagerTypes;

import gl1tch.mcmurder.MinecraftMurder;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModDamageTypes {
    public static final RegistryKey<DamageType> KNIFE_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(MinecraftMurder.MOD_ID, "knife"));
    public static final RegistryKey<DamageType> BULLET_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(MinecraftMurder.MOD_ID, "bullet"));


    public static void registerDamageTypes() {
        MinecraftMurder.LOGGER.info("Registering damage types for " + MinecraftMurder.MOD_ID);
    }
}
