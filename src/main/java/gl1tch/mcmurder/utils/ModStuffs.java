package gl1tch.mcmurder.utils;

import gl1tch.mcmurder.damagerTypes.ModDamageTypes;
import gl1tch.mcmurder.entities.ModEntities;
import gl1tch.mcmurder.gamerules.ModGameRules;
import gl1tch.mcmurder.items.ModItems;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

public class ModStuffs {
    public static void register() {
        ModGameRules.registerModGameRules();
        ModEntities.registerModEntities();
        ModDamageTypes.registerDamageTypes();
        ModItems.registerModItems();
    }

    public static RegistryEntry.Reference<DamageType> damageTypeReference(RegistryKey<DamageType> damageType, World world) {
        return world.getRegistryManager()
                .get(RegistryKeys.DAMAGE_TYPE)
                .entryOf(damageType);
    }
}
