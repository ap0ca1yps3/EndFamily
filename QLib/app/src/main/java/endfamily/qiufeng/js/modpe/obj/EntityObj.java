package endfamily.qiufeng.js.modpe.obj;
import java.util.*;

public class EntityObj extends Obj
{
	public static int currentUUID=0;
	public double x=0,y=0,z=0;
	public double yaw=0,pitch=0;
	public AItem[] inventory=new AItem[30];
	public AItem[] armor=new AItem[4];
	public int uuid=currentUUID++;
	public boolean isSneaking=false;
	public boolean isFlying=false;
	public boolean canFly=false;
	public boolean isMountable=false;
	public boolean canBreakBlocks=true;

	public EntityObj(double x, double y, double z, double yaw, double pitch){
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
		// Not using `Arrays.fill` to ensure every instance is different.
		for(int i=0;i<inventory.length;i++){
			inventory[i]=new AItem(new ItemIdentifier(0,0),new ItemObj(0,"",""));
		}
		for(int i=0;i<armor.length;i++){
			armor[i]=new AItem(new ItemIdentifier(0,0),new ItemObj(0,"",""));
		}
	}
	
}
