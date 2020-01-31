package io.github.reself.solmagicae.objects.blocks;

import io.github.reself.solmagicae.entity.TileEntitySolarController;
import io.github.reself.solmagicae.render.ItemRenderAboveController;
import io.github.reself.solmagicae.util.Reference;
import io.github.reself.solmagicae.util.Util;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSolarController extends BlockBase implements ITileEntityProvider {
	
	public boolean construct;
	
	public BlockSolarController() {
		super("solar_generator", Material.CLOTH);
		this.construct = false;
		GameRegistry.registerTileEntity(TileEntitySolarController.class, new ResourceLocation(Reference.MODID, "TileEntitySolarController"));
	}	
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {				
		TileEntitySolarController entity = (TileEntitySolarController)Util.getExistingTileEntity(world, pos);
		if(entity != null) {			
			entity.isConstructValid();
		}
		return true;
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntitySolarController();
	}
}