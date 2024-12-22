package gl1tch.mcmurder.items.custom;

import gl1tch.mcmurder.damagerTypes.ModDamageTypes;
import gl1tch.mcmurder.gamerules.ModGameRules;
import gl1tch.mcmurder.utils.ModStuffs;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class KnifeItem extends SwordItem {

    public KnifeItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();


        if (!world.isClient) {
            target.damage(new DamageSource(ModStuffs.damageTypeReference(ModDamageTypes.KNIFE_DAMAGE, world), attacker), 5f);

            if (world.getGameRules().getBoolean(ModGameRules.MC_MURDER_HELPER)) {
                target.kill();
            }
        }

        return super.postHit(stack, target, attacker);
    }
}
