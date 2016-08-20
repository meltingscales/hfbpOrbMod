package com.henryfbp.tutorial.blocks;

import java.util.ArrayList;

import com.henryfbp.tutorial.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModBlockMultiOre extends Block
{

	protected ModBlockMultiOre(String unlocalizedName, Material material)
	{
		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setStepSound(soundTypeStone);
		this.setHardness(10.0F);
		this.setResistance(20.0F);
		this.setHarvestLevel("pickaxe", 2);
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

		drops.add(new ItemStack(Items.coal, 		world.rand.nextInt(3) + 1));
		drops.add(new ItemStack(Items.iron_ingot, 	world.rand.nextInt(2) + 1));
		drops.add(new ItemStack(Items.gold_ingot, 	world.rand.nextInt(2) + 1));
		drops.add(new ItemStack(Items.dye,			world.rand.nextInt(3) + 2, 4)); //for lapis, it's dye
		drops.add(new ItemStack(Items.redstone, 	world.rand.nextInt(2) + 2));
		drops.add(new ItemStack(Items.coal, 		world.rand.nextInt(3) + 1));
		
		if(world.rand.nextFloat() < 0.5F)
			drops.add(new ItemStack(Items.diamond));
		
		return drops;
	}
	
	
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune, ArrayList<ItemStack> items) //this one lets you call it
	{																															  //with items passed in as a list
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();																  //for easier calling and reusability
		
		for(int i = 0; i<items.size(); i++)
			drops.add(items.get(i));
		
		return drops;
	}
	
}
