package endfamily.qiufeng.js.modpe.obj;

public class ItemObj extends Obj
{
	public int damage;
	public String path;
	public String name;
	public int maxStack;
	public int hunger=0;

	public ItemObj(int damage, String path, String name,int maxStack){
		this.damage = damage;
		this.path = path;
		this.name = name;
		this.maxStack=maxStack;
	}
}
