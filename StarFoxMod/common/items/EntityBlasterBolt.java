package alphacentauri17.StarFoxMod.common.items;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBlasterBolt extends EntityThrowable
{
   private float explosionRadius;
public EntityBlasterBolt(World par1World)
   {
       super(par1World);
   }
   public EntityBlasterBolt(World par1World, EntityPlayer par3EntityPlayer)
   {
       super(par1World, par3EntityPlayer);
   }
   public EntityBlasterBolt(World par1World, double par2, double par4, double par6)
   {
       super(par1World, par2, par4, par6);
   }
   @Override
   protected void onImpact(MovingObjectPosition movingobjectposition) 
   {  
     this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, true);		
     this.setDead();
   }
private boolean getPowered() {
	// TODO Auto-generated method stub
	return false;
}
}