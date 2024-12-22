package gl1tch.mcmurder.items.custom;

import gl1tch.mcmurder.MinecraftMurder;
import gl1tch.mcmurder.entities.ModEntities;
import gl1tch.mcmurder.entities.projectiles.BulletProjectile;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.AirBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.command.PlaySoundCommand;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.apache.logging.log4j.core.jmx.Server;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static gl1tch.mcmurder.entities.ModEntities.BULLET_PROJECTILE_ENTITY_TYPE;

public class GunItem extends BowItem {
    public GunItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!world.isClient) {
            if (remainingUseTicks <= 71995) {
                world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_GENERIC_EXPLODE.value(), SoundCategory.PLAYERS, 1f, 2f);

                if (!user.isInCreativeMode()) {
                    stack.setDamage(stack.getDamage() + 1);
                }

                BulletProjectile bulletProjectile = new BulletProjectile(world, user);

                bulletProjectile.setPos(user.getEyePos().x, user.getEyePos().y - 0.25, user.getEyePos().z);
                bulletProjectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5f, 0);

                world.spawnEntity(bulletProjectile);
            }
        }

        if (user instanceof PlayerEntity playerEntity) {
            ItemStack itemStack = playerEntity.getProjectileType(stack);
            if (!itemStack.isEmpty()) {
                int i = this.getMaxUseTime(stack, user) - remainingUseTicks;
                float f = getPullProgress(i);
                if (!((double)f < 0.1)) {
                    playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
                }
            }
        }
    }

    @Override
    protected void shoot(LivingEntity shooter, ProjectileEntity projectile, int index, float speed, float divergence, float yaw, @Nullable LivingEntity target) {
        if (projectile.getType().isIn(EntityTypeTags.ARROWS)) {
            projectile.remove(Entity.RemovalReason.DISCARDED);
        } else {
            projectile.setVelocity(shooter, shooter.getPitch(), shooter.getYaw() + yaw, 0.0F, speed, divergence);
        }
    }
}
