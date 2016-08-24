package com.henryfbp.hfbpOrbMod.items;

import com.henryfbp.hfbpOrbMod.Main;

import net.minecraft.item.ItemPickaxe;

public class ItemModPickaxe extends ItemPickaxe
{
	public ItemModPickaxe(String unlocalizedName, ToolMaterial toolMaterial)
	{
		super(toolMaterial);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Main.MODID + ":" + unlocalizedName);
	}

}
