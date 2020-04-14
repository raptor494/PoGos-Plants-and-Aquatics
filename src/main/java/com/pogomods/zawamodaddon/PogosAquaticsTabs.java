package com.pogomods.zawamodaddon;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class PogosAquaticsTabs {

	public static final CreativeTabs MAIN_TAB = new CreativeTabs("pogos_aquatics") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(PogosAquaticsBlocks.GRAVEL);
		}
		
		@Override
		public void displayAllRelevantItems(NonNullList<ItemStack> list) {
			for (Item block : PogosAquaticsBlocks.Registration.items) {
				block.getSubItems(this, list);
			}
			for (Item item : PogosAquaticsItems.Registration.items) {
				item.getSubItems(this, list);
			}
		};
		
	};
	
}
