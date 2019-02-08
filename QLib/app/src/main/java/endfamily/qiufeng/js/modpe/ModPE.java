package endfamily.qiufeng.js.modpe;
import endfamily.qiufeng.js.*;
import java.io.*;
import endfamily.qiufeng.js.modpe.obj.*;
import endfamily.qiufeng.util.*;
import java.util.*;

public class ModPE extends ModClass
{
	private HashMap<String,String> lang=new HashMap<>();
	private ItemObj items[]={};
	public ModPE(JsEngine je){
		super(je);
	}
	/* dumpVtable
	*  @param String str
	*  @param int i
	*/
	public void dumpVtable(String str,int i){
		Const.instance.print("[DUMP]"+str+","+i);
	}
	/* getBytesFromTexturePack
	*  @param String path
	*/
	public byte[] getBytesFromTexturePack(String path) throws IOException{
		byte bts[]={};
		FileInputStream in=openInputStreamFromTexturePack(path);
		for(int b=0;(b=in.read())!=-1;){
			bts=ArrayUtils.push(bts,(byte)b);
		}
		return bts;
	}
	/* getI18n
	*  @param String name
	*/
	public String getI18n(String name){
		String text=name;
		if(lang.containsKey(name))text=lang.get(name);
		Const.instance.print("[I18n]"+text);
		return text;
	}
	/* getLanguage
	*  @desc gets the current language
	*/
	public String getLanguage(){
		return Locale.getDefault().getLanguage();
	}
	/* getMinecraftVersion
	* @desc gets version of Minecraft
	*/
	public String getMinecraftVersion(){
		return "V1.1.0.55";
	}
	/* langEdit
	*  @param String prefix
	*  @param String text
	*/
	public void langEdit(String prefix,String text){
		lang.put(prefix,text);
	}
	/* open an InputStream on a relative path.
	 * @param String path : Relative path
	 */
	public FileInputStream openInputStreamFromTexturePack(String path) throws FileNotFoundException{
		return new FileInputStream(new File(engine.file,path));
	}
}
