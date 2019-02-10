package endfamily.qiufeng.js.modpe.obj;
import endfamily.qiufeng.js.*;

public class PlayerObj extends EntityObj
{
	public int gamemode=0;
	public int fov=70;
	public PlayerObj(double x,double y,double z,double yaw,double pitch){
		super(x,y,z,yaw,pitch);
	}
	public void setGamemode(int mode){
		switch(mode){
			case 0:
				canFly=false;
				isFlying=false;
				break;
			case 1:
				canFly=true;
				break;
			case 2:
				canBreakBlocks=false;
				break;
			default:
				Const.instance.print("[ERROR]Gamemode not identified");
		}
	}
}
