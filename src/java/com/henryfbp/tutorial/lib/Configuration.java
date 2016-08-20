package com.henryfbp.tutorial.lib;

import com.henryfbp.tutorial.Main;

import cpw.mods.fml.common.FMLCommonHandler;

public class Configuration
{
	public static void syncConfig()
	{
		FMLCommonHandler.instance().bus().register(Main.instance);
		
		
	}
}
