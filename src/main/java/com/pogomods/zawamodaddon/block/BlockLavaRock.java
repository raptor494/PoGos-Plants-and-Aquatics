package com.pogomods.zawamodaddon.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockLavaRock extends Block {

	public static final PropertyEnum<BlockLavaRock.EnumType> VARIANT = PropertyEnum.create("variant", BlockLavaRock.EnumType.class);
	
	public BlockLavaRock() {
		super(Material.ROCK);
		this.setDefaultState(this.getDefaultState().withProperty(VARIANT, BlockLavaRock.EnumType.BLACK));
	}
	
	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.getValue(VARIANT).getMapColor();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(VARIANT).getMetadata();
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (BlockLavaRock.EnumType type : BlockLavaRock.EnumType.values()) {
			items.add(new ItemStack(this, 1, type.getMetadata()));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, BlockLavaRock.EnumType.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(VARIANT).getMetadata();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, VARIANT);
	}
	
	@Override
	public Block setSoundType(SoundType sound) {
		return super.setSoundType(sound);
	}
	
	public static enum EnumType implements IStringSerializable {
		BLACK(0, "black_lava_rock", "black", MapColor.BLACK),
		RED(1, "red_lava_rock", "red", MapColor.RED_STAINED_HARDENED_CLAY);
		
		private static final EnumType[] META_LOOKUP = new EnumType[values().length];
		private final int meta;
        private final String name;
        private final MapColor mapColor;
        private final String unlocalizedName;
        
        private EnumType(int meta, String name, String unlocalizedName, MapColor mapColor) {
        	this.meta = meta;
        	this.name = name;
        	this.mapColor = mapColor;
        	this.unlocalizedName = unlocalizedName;
        }
        
        public int getMetadata() {
        	return meta;
        }
        
        @Override
		public String toString() {
        	return name;
        }
        
        public MapColor getMapColor() {
        	return mapColor;
        }
        
        public static EnumType byMetadata(int meta) {
        	if (meta < 0 || meta >= META_LOOKUP.length) {
        		meta = 0;
        	}
        	
        	return META_LOOKUP[meta];
        }
        
        @Override
		public String getName() {
        	return name;
        }
        
        public String getUnlocalizedName() {
        	return unlocalizedName;
        }
        
        static {
        	for (EnumType type : values()) {
        		META_LOOKUP[type.getMetadata()] = type;
        	}
        }
        
	}
	
}
