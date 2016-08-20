package com.henryfbp.tutorial;


import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import com.henryfbp.tutorial.blocks.ModBlocks;
import com.henryfbp.tutorial.item.ModItems;
import com.henryfbp.tutorial.world.ModWorldGen;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

public class CommonProxy
{

    public void preInit(FMLPreInitializationEvent e)
    {
    	ModItems.init();
    	ModBlocks.init();
    }

    public void init(FMLInitializationEvent e)
    {
    	GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
    }

    public void postInit(FMLPostInitializationEvent e)
    {

    }
}