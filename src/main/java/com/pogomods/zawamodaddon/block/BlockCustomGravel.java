package com.pogomods.zawamodaddon.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGravel;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCustomGravel extends BlockGravel {

	private final MapColor mapColor;
	private final int dustColor;
	
	public BlockCustomGravel(MapColor mapColor, int dustColor) {
		this.mapColor = mapColor;
		this.dustColor = dustColor;
	}
	
	@Override
	public Block setSoundType(SoundType sound) {
		return super.setSoundType(sound);
	}
	
	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return mapColor;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getDustColor(IBlockState state) {
		return dustColor;
	}
	
}
