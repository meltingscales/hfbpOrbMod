package com.henryfbp.tutorial;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main
{

    public static final String MODID = "tutorial";
    public static final String MODNAME = "Tutorial Mod";
    public static final String VERSION = "1.0.0";
        
    @SidedProxy(clientSide="com.henryfbp.tutorial.ClientProxy", serverSide="com.henryfbp.tutorial.ServerProxy")
    public static CommonProxy proxy;
    
    @Instance
    public static Main instance = new Main();
        
     
    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
    	proxy.preInit(e);
    }
        
    @EventHandler
    public void init(FMLInitializationEvent e)
    {
    	proxy.init(e);
    }
        
    @EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
    	proxy.postInit(e);
    }
}
