package com.henryfbp.hfbpOrbMod;


import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.config.Configuration;

import com.henryfbp.hfbpOrbMod.blocks.ModBlocks;
import com.henryfbp.hfbpOrbMod.items.ModItems;
import com.henryfbp.hfbpOrbMod.lib.Recipes;
import com.henryfbp.hfbpOrbMod.world.ModWorldGen;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

public class CommonProxy
{
	
	public static Configuration config;

    public void preInit(FMLPreInitializationEvent event)
    {
    	ModItems.init();
    	ModBlocks.init();
    	Recipes.initShapedRecipes();
    	Recipes.initShapelessRecipes();
    	Recipes.initSmeltingRecipes();
    	
    	config = new Configuration(event.getSuggestedConfigurationFile());
    	
    }

    public void init(FMLInitializationEvent event)
    {
    	GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}