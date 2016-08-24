package com.henryfbp.hfbpOrbMod.items;

import com.henryfbp.hfbpOrbMod.Main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public final class ModItem
{
	
	public static Item tutorialItem;
	public static ItemModSword tutorialSword;
	public static ItemModPickaxe tutorialPickaxe;
	public static ItemModAxe tutorialAxe;
	public static ItemModSpade tutorialSpade;
	public static ItemModHoe tutorialHoe;
	
	public static ToolMaterial tutorialMaterial = EnumHelper.addToolMaterial("Tutorialite", 1, 420, 3.0F, 0.5F, 20);
	
	public static final void init()
	{
		
		GameRegistry.registerItem(tutorialItem = new Item().setUnlocalizedName("tutorialItem").setCreativeTab(CreativeTabs.tabMisc).setTextureName(Main.MODID + ":tutorialItem"), "tutorialItem");
		GameRegistry.registerItem(tutorialSword = new ItemModSword("tutorialSword", tutorialMaterial), "Tutorial Sword");
		GameRegistry.registerItem(tutorialPickaxe = new ItemModPickaxe("tutorialPickaxe", tutorialMaterial), "Tutorial Pickaxe");
		GameRegistry.registerItem(tutorialAxe = new ItemModAxe("tutorialAxe", tutorialMaterial), "Tutorial Axe");
		GameRegistry.registerItem(tutorialSpade = new ItemModSpade("tutorialSpade", tutorialMaterial), "Tutorial Spade");
		GameRegistry.registerItem(tutorialHoe = new ItemModHoe("tutorialHoe", tutorialMaterial), "Tutorial Hoe");
		
		
	}
}
