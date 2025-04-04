package com.example.items;

import com.example.ExampleMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item EXAMPLE_ITEM = registerItem("example_item", new Item(new Item.Settings()));

    private static Item registerItem(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ExampleMod.MOD_ID, id), item);
    }

    public static void registerModItems() {
        ExampleMod.LOGGER.debug("Registering Mod Items for " + ExampleMod.MOD_ID);
    }
}
