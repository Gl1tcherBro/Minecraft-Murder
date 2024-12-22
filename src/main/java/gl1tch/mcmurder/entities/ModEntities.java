package gl1tch.mcmurder.entities;

import gl1tch.mcmurder.MinecraftMurder;
import gl1tch.mcmurder.entities.projectiles.BulletProjectile;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<BulletProjectile> BULLET_PROJECTILE_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(MinecraftMurder.MOD_ID, "bullet"),
            EntityType.Builder.<BulletProjectile>create(BulletProjectile::new, SpawnGroup.MISC)
                    .dimensions(0.25F, 0.25F)
                    .build());

    public static void registerModEntities() {
        MinecraftMurder.LOGGER.info("Registering entities for " + MinecraftMurder.MOD_ID);
    }
}
