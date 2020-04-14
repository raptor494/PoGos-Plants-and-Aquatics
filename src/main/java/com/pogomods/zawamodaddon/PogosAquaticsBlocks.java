package com.pogomods.zawamodaddon;

import com.pogomods.zawamodaddon.block.BlockCustomGravel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(PogosAquatics.MODID)
public class PogosAquaticsBlocks {
	
	public static final Block LARGE_GRAVEL = null;
	public static final Block MEDIUM_GRAVEL = null;
	public static final Block SMALL_GRAVEL = null;

	@EventBusSubscriber(modid = PogosAquatics.MODID)
	public static class Registration {
		
		static Block[] blocks_with_items;
		
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(blocks_with_items = new Block[] {
				createBlock("large_gravel", new BlockCustomGravel(MapColor.ADOBE, 0x74594B).setSoundType(SoundType.GROUND).setHardness(0.6F)),
				createBlock("medium_gravel", new BlockCustomGravel(MapColor.ADOBE, 0x74594B).setSoundType(SoundType.GROUND).setHardness(0.6F)),
				createBlock("small_gravel", new BlockCustomGravel(MapColor.ADOBE, 0x74594B).setSoundType(SoundType.GROUND).setHardness(0.6F)),
			});
		}
		
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			IForgeRegistry<Item> registry = event.getRegistry();
			for (Block block : blocks_with_items) {
				registry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
			}
		}
		
		private static Block createBlock(String name, Block block) {
			return block.setUnlocalizedName(PogosAquatics.MODID + '.' + name)
						.setRegistryName(PogosAquatics.MODID, name)
						.setCreativeTab(PogosAquaticsTabs.MAIN_TAB);
		}
		
	}
	
}
