package com.henryfbp.tutorial;

import com.henryfbp.tutorial.lib.Recipes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main
{

    public static final String MODID = "tutorial";
    public static final String MODNAME = "Tutorial Mod";
    public static final String VERSION = "1.0.0";
        
    @SidedProxy(clientSide="com.henryfbp.tutorial.ClientProxy", serverSide="com.henryfbp.tutorial.ServerProxy")
    public static CommonProxy proxy;
    public static ClientProxy cproxy;
    public static ServerProxy sproxy;
    
    public static Configuration config;
    
    @Instance
    public static Main instance = new Main();
        
     
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	proxy.preInit(event);
    	Recipes.initShapedRecipes();
    	Recipes.initShapelessRecipes();
    	Recipes.initSmeltingRecipes();
    }
        
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init(event);
    }
        
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	proxy.postInit(event);
    }
}
