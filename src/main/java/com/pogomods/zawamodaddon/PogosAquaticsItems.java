package com.pogomods.zawamodaddon;

import static com.pogomods.zawamodaddon.PogosAquaticsBlocks.Registration.blocks_with_items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(PogosAquatics.MODID)
public class PogosAquaticsItems {

	
	@EventBusSubscriber(modid = PogosAquatics.MODID)
	public static class Registration {
		
		@SubscribeEvent
		public static void registerItemModels(ModelRegistryEvent event) {
			for (Block block : blocks_with_items) {
				Item item = Item.getItemFromBlock(block);
				ModelLoader.setCustomModelResourceLocation(item, 0,
					new ModelResourceLocation(item.getRegistryName(), "inventory"));
			}
		}
		
	}
	
}
