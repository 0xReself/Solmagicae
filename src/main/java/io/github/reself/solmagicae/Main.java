package io.github.reself.solmagicae;

import io.github.reself.solmagicae.gen.SolarGen;
import io.github.reself.solmagicae.init.EntityInit;
import io.github.reself.solmagicae.proxy.CommonProxy;
import io.github.reself.solmagicae.tab.SolmagicaeTab;
import io.github.reself.solmagicae.util.Reference;
import io.github.reself.solmagicae.util.handlers.RenderHandler;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class Main {
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final SolmagicaeTab SOLMAGICAETAB = new SolmagicaeTab();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		EntityInit.registerEntity();
		RenderHandler.registerEntityRenders();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		Reference.LOGGER.info(Reference.NAME + " starting..");
		GameRegistry.registerWorldGenerator(new SolarGen(), 0);	
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
