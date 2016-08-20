package com.henryfbp.tutorial.lib;

import com.henryfbp.tutorial.blocks.ModBlocks;
import com.henryfbp.tutorial.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Recipes
{
	public static void initShapedRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tutorialBlock), new Object[]{ //2x2 tut item gives tut block
			"DD",
			"DD", 'D', ModItems.tutorialItem});
	}
	
	public static void initShapelessRecipes()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 3, 4), ModItems.tutorialItem); //tut item gives 3 lapis
	}
	
	public static void initSmeltingRecipes()
	{
		GameRegistry.addSmelting(ModBlocks.tutorialBlock, new ItemStack(Blocks.lapis_block), 1F);//smelt tut block gives lapis block
	}
}
