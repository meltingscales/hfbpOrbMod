package com.henryfbp.hfbpOrbMod.lib;

import com.henryfbp.hfbpOrbMod.Main;

import cpw.mods.fml.common.FMLCommonHandler;

public class ModConfiguration
{
	
	public static 		boolean cheapRecipe;
	public static final boolean CHEAPRECIPE_DEFAULT = false;
	public static final String 	CHEAPRECIPE_NAME 	= "Cheap recipe for tutorial block?";
	/**/
	
	
	
	public static void syncConfig()
	{
		FMLCommonHandler.instance().bus().register(Main.instance);
		
		final String RECIPES = Main.config.CATEGORY_GENERAL + Main.config.CATEGORY_SPLITTER + "Recipes";
		Main.config.addCustomCategoryComment(RECIPES, "Enable or disable recipes");
		cheapRecipe = Main.config.get(RECIPES, CHEAPRECIPE_NAME, CHEAPRECIPE_DEFAULT).getBoolean(CHEAPRECIPE_DEFAULT);
		
		if(Main.config.hasChanged())
		{
			Main.config.save();
		}
		/**/
		
		
		
	}
}
