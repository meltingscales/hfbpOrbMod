package com.henryfbp.hfbpOrbMod.items;

import com.henryfbp.hfbpOrbMod.Main;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;

public class ItemModAxe extends ItemAxe
{
	public ItemModAxe(String unlocalizedName, ToolMaterial toolMaterial)
	{
		super(toolMaterial);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Main.MODID + ":" + unlocalizedName);
	}

}
