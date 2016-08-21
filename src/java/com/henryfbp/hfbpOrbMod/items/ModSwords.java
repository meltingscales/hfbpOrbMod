package com.henryfbp.hfbpOrbMod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ModSwords extends ItemSword
{
	
	public ModSwords(ToolMaterial material)
	{
		super(material);
		this.setUnlocalizedName("modSword");
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
}
