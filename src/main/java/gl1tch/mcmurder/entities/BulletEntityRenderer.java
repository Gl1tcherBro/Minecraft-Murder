package gl1tch.mcmurder.entities;

import gl1tch.mcmurder.MinecraftMurder;
import gl1tch.mcmurder.entities.projectiles.BulletProjectile;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class BulletEntityRenderer extends EntityRenderer<BulletProjectile> {
    public BulletEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);

        ctx.getModelManager().getModel(Identifier.of(MinecraftMurder.MOD_ID, "bulletModel"));
    }

    @Override
    public Identifier getTexture(BulletProjectile entity) {
        return null;
    }
}
