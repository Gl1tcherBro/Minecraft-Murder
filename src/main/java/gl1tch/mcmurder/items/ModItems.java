package gl1tch.mcmurder.items;

import gl1tch.mcmurder.MinecraftMurder;
import gl1tch.mcmurder.items.custom.GunItem;
import gl1tch.mcmurder.items.custom.KnifeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final Item KNIFE_ITEM = registerItem("knife", new KnifeItem(ToolMaterials.IRON, new Item.Settings()
            .attributeModifiers(KnifeItem.createAttributeModifiers(ToolMaterials.IRON, -2, -2f))));
    public static Item GUN_ITEM = registerItem("gun", new GunItem(new Item.Settings()
            .maxCount(1)
            .maxDamage(250)));

    public static <T extends Item> T registerItem(String name, T item) {
        return Registry.register(Registries.ITEM, MinecraftMurder.MOD_ID + ":" + name, item);
    }

    public static void registerModItems() {
        MinecraftMurder.LOGGER.info("Registering mod items for " + MinecraftMurder.MOD_ID);
    }
}
