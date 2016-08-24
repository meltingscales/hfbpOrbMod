package com.henryfbp.hfbpOrbMod;

import com.henryfbp.hfbpOrbMod.lib.ModConfiguration;
import com.henryfbp.hfbpOrbMod.lib.Recipes;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main
{

    public static final String MODID = "hfbpOrbMod";
    public static final String MODNAME = "HenryFBPOrbMod";
    public static final String VERSION = "1.7.10.1";
        
    @SidedProxy(clientSide="com.henryfbp." + MODID + ".ClientProxy", serverSide="com.henryfbp." + MODID + ".ServerProxy")
    public static CommonProxy proxy;
    public static ClientProxy cproxy;
    public static ServerProxy sproxy;
    
    public static Configuration config;
    
    public static org.apache.logging.log4j.Logger log = FMLLog.getLogger();
    
    @Instance
    public static Main instance = new Main();
    
     
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	log.info(MODNAME+" preinit");
    	
    	proxy.preInit(event);
    	Recipes.initShapedRecipes();
    	Recipes.initShapelessRecipes();
    	Recipes.initSmeltingRecipes();
    	
    	config = new Configuration(event.getSuggestedConfigurationFile());
    	ModConfiguration.syncConfig();
    }
    
    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
    {
    	if(event.modID.equals(Main.MODID))
    	{
    		ModConfiguration.syncConfig();
    	}
    }
        
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	log.info(MODNAME+" init");
    	
    	proxy.init(event);
    	FMLCommonHandler.instance().bus().register(instance);
    }
        
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	log.info(MODNAME+" postinit");
    	
    	proxy.postInit(event);
    }
}
