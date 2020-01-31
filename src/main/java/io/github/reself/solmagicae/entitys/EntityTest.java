package io.github.reself.solmagicae.entitys;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityTest extends EntityZombie {

	public EntityTest(World worldIn) {
		super(worldIn);
		this.setAIMoveSpeed(10f);
		this.addVelocity(0, 1, 0);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onUpdate() {
		this.fallDistance = 0;
		// TODO Auto-generated method stub
		super.onUpdate();
		if(onGround == true) {
			this.addVelocity(0, 1, 0);
		}
	}
}
