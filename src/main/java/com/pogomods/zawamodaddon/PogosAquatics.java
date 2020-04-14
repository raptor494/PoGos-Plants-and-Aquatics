package com.pogomods.zawamodaddon;

import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
	modid = PogosAquatics.MODID, name = "Pogo's Plants and Aquatics", version = "1.12.2-1.0.0",
	dependencies = "required-before:zawa@[1.12.2-1.7.0,);required-before:bookworm@[1.12.2-2.3.0,);"
)
public class PogosAquatics {

	public static final String MODID = "pogos_aquatics";

	private static Logger logger;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}
	
	public static ResourceLocation getResource(String name) {
		return new ResourceLocation(MODID, name);
	}

}
