package com.henryfbp.hfbpOrbMod.blocks;

import com.henryfbp.hfbpOrbMod.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public final class ModBlocks
{
	public static Block tutorialBlock;
	public static ModBlockOre tutorial_ore;
	public static ModBlockMultiOre tutorial_multi_ore;
	
	public static final void init()
	{
		GameRegistry.registerBlock(tutorialBlock = new BasicBlock("tutorialBlock", Material.iron), "tutorialBlock");
		GameRegistry.registerBlock(tutorial_ore = new ModBlockOre("tutorial_ore", Material.rock, ModItems.tutorialItem, 2, 4), "tutorial_ore");
		GameRegistry.registerBlock(tutorial_multi_ore = new ModBlockMultiOre("tutorial_multi_ore", Material.rock), "tutorial_multi_ore");
	}
}
