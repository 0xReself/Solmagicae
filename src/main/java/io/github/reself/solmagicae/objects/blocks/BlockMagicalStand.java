package io.github.reself.solmagicae.objects.blocks;

import io.github.reself.solmagicae.entity.TileEntityMagicalStand;
import io.github.reself.solmagicae.render.RendererMagicalStand;
import io.github.reself.solmagicae.util.Reference;
import io.github.reself.solmagicae.util.Util;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
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

public class BlockMagicalStand extends BlockBase implements ITileEntityProvider {
	
	public static final AxisAlignedBB MAGICAL_STANDING_AABB = new AxisAlignedBB(0.25d, 0, 0.25d, 0.75d, 1, 0.75d);
	
	public BlockMagicalStand() {
		super("magical_stand", Material.CLOTH);
		GameRegistry.registerTileEntity(TileEntityMagicalStand.class, new ResourceLocation(Reference.MODID, "TileEntityMagicalStand"));
		initModel();
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagicalStand.class, new RendererMagicalStand());
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {	
		TileEntityMagicalStand entity = (TileEntityMagicalStand)Util.getExistingTileEntity(world, pos);
        if (entity != null) {
			if (entity.getStack().isEmpty()) {
				if (!player.getHeldItem(hand).isEmpty()) {
					entity.setStack(player.getHeldItem(hand));
					player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
					player.openContainer.detectAndSendChanges();
				}
			} else {
				ItemStack stack = entity.getStack();
				entity.setStack(ItemStack.EMPTY);
				if (!player.inventory.addItemStackToInventory(stack)) {
					EntityItem entityItem = new EntityItem(world, pos.getX(), pos.getY() + 1, pos.getZ(), stack);
					world.spawnEntity(entityItem);
				} else {
					player.openContainer.detectAndSendChanges();
				}
			} 
		}
		return true;
	}
	
	@Override
	public boolean hasTileEntity() {
		return true;
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
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return MAGICAL_STANDING_AABB;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityMagicalStand();
	}
}
