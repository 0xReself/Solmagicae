package io.github.reself.solmagicae.objects.blocks;

import io.github.reself.solmagicae.entity.TileEntitySolarArray;
import io.github.reself.solmagicae.entity.TileEntitySolarController;
import io.github.reself.solmagicae.render.ItemRenderAboveController;
import io.github.reself.solmagicae.util.Reference;
import io.github.reself.solmagicae.util.Util;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SolarArrayTile extends BlockBase implements ITileEntityProvider{
	
	public static final AxisAlignedBB SOLAR_ARRAY_AABB = new AxisAlignedBB(0, 0, 0, 1, 0.75, 1);
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	public SolarArrayTile() {
		super("solar_array", Material.CLOTH);
		GameRegistry.registerTileEntity(TileEntitySolarArray.class, new ResourceLocation(Reference.MODID, "TileEntitySolarArray"));
		initModel();
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarArray.class, new ItemRenderAboveController());
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		Reference.LOGGER.info(player.inventory.currentItem + "   " + player.inventory.getStackInSlot(player.inventory.currentItem).getDisplayName());
		
		if(player.inventory.getStackInSlot(player.inventory.currentItem).getItem() instanceof ItemBlock)
		{
			ItemBlock temp = (ItemBlock) player.inventory.getStackInSlot(player.inventory.currentItem).getItem();
			if(temp.getBlock() instanceof BaseLens) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntitySolarArray entitySolarArray = (TileEntitySolarArray)Util.getExistingTileEntity(world, pos);
		if(entitySolarArray != null) {
			entitySolarArray.onBreak();
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntitySolarArray();
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public void onEntityWalk(World world, BlockPos pos, Entity entity) {
		entity.setRotationYawHead(60);
	}

	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SOLAR_ARRAY_AABB;
	}
}
