package com.pogomods.zawamodaddon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class PogosAquaticsTabs {

	public static final CreativeTabs MAIN_TAB = new CreativeTabs("pogos_aquatics") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(PogosAquaticsBlocks.LARGE_GRAVEL);
		}
		
	};
	
}
