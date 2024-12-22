package gl1tch.mcmurder;

import gl1tch.mcmurder.entities.BulletEntityRenderer;
import gl1tch.mcmurder.entities.ModEntities;
import gl1tch.mcmurder.entities.projectiles.BulletProjectile;
import gl1tch.mcmurder.utils.ModStuffs;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static gl1tch.mcmurder.entities.ModEntities.BULLET_PROJECTILE_ENTITY_TYPE;

public class MinecraftMurderClient implements ClientModInitializer {
	public static final String MOD_ID = "mcmurder";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(BULLET_PROJECTILE_ENTITY_TYPE, (context) ->
				new FlyingItemEntityRenderer<>(context));
	}
}
