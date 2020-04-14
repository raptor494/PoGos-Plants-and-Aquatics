package com.pogomods.zawamodaddon;

import com.pogomods.zawamodaddon.block.BlockColoredSand;
import com.pogomods.zawamodaddon.block.BlockCustomGravel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(PogosAquatics.MODID)
public class PogosAquaticsBlocks {
	
	public static final Block GRAVEL = null;
	public static final Block SAND = null;

	@EventBusSubscriber(modid = PogosAquatics.MODID)
	public static class Registration {
	
		static Item[] items;
		
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(new Block[] {
				createBlock("gravel", new BlockCustomGravel().setSoundType(SoundType.GROUND).setHardness(0.6F)),
				createBlock("sand", new BlockColoredSand().setSoundType(SoundType.SAND).setHardness(0.5F))
			});
		}
		
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll(items = new Item[] {
				createItemBlock(GRAVEL, itemStack -> BlockCustomGravel.EnumType.byMetadata(itemStack.getMetadata()).getUnlocalizedName()),
				createItemBlock(SAND, itemStack -> BlockColoredSand.EnumType.byMetadata(itemStack.getMetadata()).getUnlocalizedName()),
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
			
			Item item;
			
			item = Item.getItemFromBlock(GRAVEL);
			for (BlockCustomGravel.EnumType type : BlockCustomGravel.EnumType.values()) {
				ModelLoader.setCustomModelResourceLocation(item, type.getMetadata(),
					new ModelResourceLocation(PogosAquatics.getResource(type.getName()), "inventory"));
			}
			
			item = Item.getItemFromBlock(SAND);
			for (BlockColoredSand.EnumType type : BlockColoredSand.EnumType.values()) {
				ModelLoader.setCustomModelResourceLocation(item, type.getMetadata(),
					new ModelResourceLocation(PogosAquatics.getResource(type.getName()), "inventory"));
			}
		}
		
		private static Block createBlock(String name, Block block) {
			return block.setUnlocalizedName(PogosAquatics.MODID + '.' + name)
						.setRegistryName(PogosAquatics.MODID, name)
						.setCreativeTab(PogosAquaticsTabs.MAIN_TAB);
		}
		
		private static Item createItemBlock(Block block) {
			return new ItemBlock(block).setRegistryName(block.getRegistryName());
		}
		
		private static Item createItemBlock(Block block, ItemMultiTexture.Mapper nameMapper) {
			return new ItemMultiTexture(block, block, nameMapper).setRegistryName(block.getRegistryName());
		}
		
	}
	
}
