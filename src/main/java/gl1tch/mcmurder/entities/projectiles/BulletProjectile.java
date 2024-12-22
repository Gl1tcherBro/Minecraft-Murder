package gl1tch.mcmurder.entities.projectiles;

import gl1tch.mcmurder.damagerTypes.ModDamageTypes;
import gl1tch.mcmurder.utils.ModStuffs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.projectile.AbstractWindChargeEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static gl1tch.mcmurder.entities.ModEntities.BULLET_PROJECTILE_ENTITY_TYPE;
import static gl1tch.mcmurder.gamerules.ModGameRules.MC_MURDER_HELPER;

public class BulletProjectile extends AbstractWindChargeEntity implements FlyingItemEntity {
    private static ItemStack itemStack = Items.STONE_BUTTON.getDefaultStack();

    private int _lifeTimeTicks = 0;

    private Entity _owner;

    private boolean oneShots;

    public BulletProjectile(EntityType<? extends AbstractWindChargeEntity> entityType, World world) {
        super(entityType, world);
    }

    public BulletProjectile(World world, Entity owner) {
        super(BULLET_PROJECTILE_ENTITY_TYPE, world);

        this._owner = owner;
    }

    public Entity getOwner() {
        return this._owner;
    }

    @Override
    public void setOwner(@Nullable Entity entity) {
        super.setOwner(entity);

        this._owner = entity;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);

        if (!this.getWorld().isClient) {
            entityHitResult.getEntity().damage(new DamageSource(ModStuffs.damageTypeReference(ModDamageTypes.BULLET_DAMAGE, this.getWorld()), this.getOwner()), 7.5f);

            if (oneShots) {
                entityHitResult.getEntity().kill();
            }
        }
    }

    @Override
    protected void createExplosion(Vec3d pos) {
    }

    @Override
    public void tick() {
        super.tick();

        World world = super.getEntityWorld();

        if (!world.isClient) {
            if (world.getGameRules().getBoolean(MC_MURDER_HELPER)) {
                this.oneShots = true;
            }
        }

        this._lifeTimeTicks++;

        if (_lifeTimeTicks >= 1200) {
            this.remove(RemovalReason.DISCARDED);
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);

        this.remove(RemovalReason.DISCARDED);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
    }

    @Override
    public ItemStack getStack() {
        return itemStack;
    }
}
