package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;
import net.minecraft.text.Text;

public class ExampleMod implements ModInitializer {

	public static final String MOD_ID = "modid";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
			BlockState state = world.getBlockState(pos);
			/* 手动的旁观者检查是必要的，因为 AttackBlockCallbacks 会在旁观者检查之前应用 */
			if (state.isToolRequired() && !player.isSpectator() &&
					player.getMainHandStack().isEmpty()) {
				// 给玩家施加一个伤害
				// player.damage(DamageSource.field_5869, 1.0F);
				// 将字符串转换为 Text 对象
				player.sendMessage(Text.literal("Hello, Player!"), false);
			}
			return ActionResult.PASS;
		});
	}

}
