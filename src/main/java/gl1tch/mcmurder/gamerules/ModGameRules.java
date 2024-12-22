package gl1tch.mcmurder.gamerules;

import gl1tch.mcmurder.MinecraftMurder;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class ModGameRules {
    public static final GameRules.Key<GameRules.BooleanRule> MC_MURDER_HELPER = GameRuleRegistry.register("shouldHelpWithMcMurder", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(false));

    public static void registerModGameRules() {
        MinecraftMurder.LOGGER.info("Registering GameRules for " + MinecraftMurder.MOD_ID);
    }
}
