package com.henryfbp.hfbpOrbMod.items;

import com.henryfbp.hfbpOrbMod.Main;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemTool;

public class ItemModSpade extends ItemSpade
{
	public ItemModSpade(String unlocalizedName, ToolMaterial toolMaterial)
	{
		super(toolMaterial);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Main.MODID + ":" + unlocalizedName);

	}

}
