package com.pogomods.zawamodaddon;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(PogosAquatics.MODID)
public class PogosAquaticsItems {

	
	@EventBusSubscriber(modid = PogosAquatics.MODID)
	public static class Registration {
		
		static Item[] items;
		
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll(items = new Item[] {
				
			});
		}
		
		@SubscribeEvent
		public static void registerItemModels(ModelRegistryEvent event) {
			for (Item item : items) {
				if (!item.getHasSubtypes()) {
					ModelLoader.setCustomModelResourceLocation(item, 0,
						new ModelResourceLocation(item.getRegistryName(), "inventory"));
				}
			}
		}
		
		private static Item createItem(final String name, final Item item) {
			item.setUnlocalizedName(PogosAquatics.MODID + '.' + name)
				.setRegistryName(PogosAquatics.MODID, name)
				.setCreativeTab(PogosAquaticsTabs.MAIN_TAB);
			
			return item;
		}
		
	}
	
}
