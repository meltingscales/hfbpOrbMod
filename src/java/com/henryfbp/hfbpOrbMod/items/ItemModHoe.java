package com.henryfbp.hfbpOrbMod.items;

import com.henryfbp.hfbpOrbMod.Main;

import net.minecraft.item.ItemHoe;

public class ItemModHoe extends ItemHoe
{
	public ItemModHoe(String unlocalizedName, ToolMaterial toolMaterial)
	{
		super(toolMaterial);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Main.MODID + ":" + unlocalizedName);
	}

}
