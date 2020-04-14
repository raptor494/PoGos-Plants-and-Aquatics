package com.pogomods.zawamodaddon.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCustomGravel extends BlockFalling {
	
	public static final PropertyEnum<BlockCustomGravel.EnumType> VARIANT = PropertyEnum.create("variant", BlockCustomGravel.EnumType.class);
	
	public BlockCustomGravel() {
		this.setDefaultState(this.getDefaultState().withProperty(VARIANT, BlockCustomGravel.EnumType.SMALL));
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(VARIANT).getMetadata();
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (BlockCustomGravel.EnumType type : BlockCustomGravel.EnumType.values()) {
			items.add(new ItemStack(this, 1, type.getMetadata()));
		}
	}
	
	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.getValue(VARIANT).getMapColor();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, BlockCustomGravel.EnumType.byMetadata(meta));
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
	@SideOnly(Side.CLIENT)
	public int getDustColor(IBlockState state) {
		return state.getValue(VARIANT).getDustColor();
	}
	
	@Override
	public Block setSoundType(SoundType sound) {
		return super.setSoundType(sound);
	}
	
	public static enum EnumType implements IStringSerializable {
		SMALL(0, "small_gravel", "small", MapColor.ADOBE, 0x74594B),
		MEDIUM(1, "medium_gravel", "medium", MapColor.ADOBE, 0x74594B),
		LARGE(2, "large_gravel", "large", MapColor.ADOBE, 0x74594B);
		
		private static final EnumType[] META_LOOKUP = new EnumType[values().length];
		private final int meta;
        private final String name;
        private final MapColor mapColor;
        private final String unlocalizedName;
        private final int dustColor;
        
        private EnumType(int meta, String name, String unlocalizedName, MapColor mapColor, int dustColor) {
        	this.meta = meta;
        	this.name = name;
        	this.mapColor = mapColor;
        	this.unlocalizedName = unlocalizedName;
        	this.dustColor = dustColor;
        }
        
        @SideOnly(Side.CLIENT)
        public int getDustColor() {
        	return dustColor	;
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
