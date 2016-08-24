package com.henryfbp.hfbpOrbMod.blocks;

import com.henryfbp.hfbpOrbMod.items.ModItem;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public final class ModBlocks
{
	public static Block tutorialBlock;
	public static ModBlockOre tutorialOre;
	public static ModBlockMultiOre tutorialMultiOre;
	
	public static final void init()
	{
		GameRegistry.registerBlock(tutorialBlock = new BasicBlock("tutorialBlock", Material.glass), "tutorialBlock");
		
		GameRegistry.registerBlock(tutorialOre = new ModBlockOre("tutorialOre", Material.rock, ModItem.tutorialItem, 2, 4), "tutorialOre");
		GameRegistry.registerBlock(tutorialMultiOre = new ModBlockMultiOre("tutorialMultiOre", Material.rock), "tutorialMultiOre");
	}
}
