package endfamily.qiufeng.js.modpe;
import java.util.*;
import endfamily.qiufeng.js.modpe.obj.*;

public class Storage
{
	public static Storage instance=new Storage();
	public HashMap<ItemIdentifier,ItemObj> items=new HashMap<>();
	public HashMap<String,String> lang=new HashMap<>();
	public String levelName="EMULATOR";
	public EntityObj[] entities=new EntityObj[0];
	public PlayerObj player=new PlayerObj(0,0,0,0,0);
	public int cameraUUID=player.uuid;
	public int gameSpeed=20;
}
