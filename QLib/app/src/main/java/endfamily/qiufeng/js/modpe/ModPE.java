package endfamily.qiufeng.js.modpe;
import endfamily.qiufeng.js.*;
import endfamily.qiufeng.js.modpe.obj.*;
import endfamily.qiufeng.util.*;
import java.io.*;
import java.util.*;
import android.os.*;
import org.json.*;
import org.mozilla.javascript.*;

public class ModPE extends ModClass
{
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
		if(Storage.instance.lang.containsKey(name))text=Storage.instance.lang.get(name);
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
		Storage.instance.lang.put(prefix,text);
	}
	/* leaveGame
	*/
	public void leaveGame(){
		Const.instance.print("Player has left.");
	}
	/* log
	*  @param String str
	*/
	public void log(String str){
		Const.instance.print(str,1);
	}
	/* open an InputStream on a relative path.
	 * @param String path : Relative path
	 */
	public FileInputStream openInputStreamFromTexturePack(String path) throws FileNotFoundException{
		return new FileInputStream(new File(engine.file,path));
	}
	/* overrideTexture
	*  @param from
	*  @param to
	*/
	public void overrideTexture(String from,String to){
		Const.instance.print("Texture '"+from+"' has been changed to '"+to+"'.");
	}
	/* readData
	*  @param key
	*/
	public Object readData(String key){
		File dir=new File(Environment.getExternalStorageDirectory(),".endfamily");
		dir.mkdirs();
		File f=new File(dir,"EMULATOR.json");
		try{
			FileInputStream fis=new FileInputStream(f);
			byte[] bts=new byte[0];
			for(int i=0;(i=fis.read())!=-1;){
				bts=ArrayUtils.push(bts,(byte)i);
			}
			JSONObject jr=new JSONObject(new String(bts));
			JSONObject jrr=new JSONObject();
			if(jr.has(Storage.instance.levelName))
				jrr=jr.getJSONObject(Storage.instance.levelName);
			else{
				jr.put(Storage.instance.levelName,jrr);
				FileOutputStream fos=new FileOutputStream(f);
				try{
					fos.write(jr.toString(4).getBytes());
				}catch(JSONException je){
					Const.instance.print("I just cant modify......Whyyyyyyyyyyyy");
				}
				fos.close();
			}
			return Context.javaToJS(jrr.get(key),engine.scope);
		}catch(IOException e){
			return null;
		}catch(JSONException je){
			Const.instance.print("[ERROR]Json File brocken!Recreating Json...");
			try{
				FileOutputStream fos=new FileOutputStream(f);
				fos.write("{}".getBytes());
				fos.close();
			}catch(IOException ie){
				Const.instance.print("[ERROR]Can't recreate JSON file '"+f.getPath()+"' . Please ensure that you have the permission.");
				return null;
			}
			return null;
		}
	}
	/* saveData
	*  String key
	*  Object value
	*/
	public void saveData(String key,Object value){
		File dir=new File(Environment.getExternalStorageDirectory(),".endfamily");
		dir.mkdirs();
		File f=new File(dir,"EMULATOR.json");
		try{
			FileInputStream fis=new FileInputStream(f);
			byte[] bts=new byte[0];
			for(int i=0;(i=fis.read())!=-1;){
				bts=ArrayUtils.push(bts,(byte)i);
			}
			JSONObject jr=new JSONObject(new String(bts));
			JSONObject jrr=new JSONObject();
			if(jr.has(Storage.instance.levelName)){
				jrr=jr.getJSONObject(Storage.instance.levelName);
			}
			jrr.put(key,value);
			if(!jr.has(Storage.instance.levelName)){
				jr.put(Storage.instance.levelName,jrr);
			}
			FileOutputStream fos=new FileOutputStream(f);
			try{
				fos.write(jr.toString(4).getBytes());
			}catch(JSONException je){
				Const.instance.print("I just cant create one......Whyyyyyyyyyyyy");
			}
			fos.close();
		}catch(IOException|JSONException e){
			Const.instance.print("[IOException]Does not exist or Bad JSON Token",2);
			Const.instance.print("[INFO]Recreating one...");
			try{
				JSONObject jo=new JSONObject();
				JSONObject joo=new JSONObject();
				joo.put(key,value);
				jo.put(Storage.instance.levelName,joo);
				FileOutputStream fos=new FileOutputStream(f);
				try{
					fos.write(jo.toString(4).getBytes());
				}catch(JSONException je){
					Const.instance.print("I just cant create one......Whyyyyyyyyyyyy");
				}
				fos.close();
			}catch(IOException|JSONException ie){
				Const.instance.print(ie.getClass().getName()+":"+ie.getMessage());
				Const.instance.print("[ERROR]Can't recreate JSON file '"+f.getPath()+"' . Please ensure that you have the permission.");
			}
		}
	}
	/* removeData
	*  @param String key
	*/
	public void removeData(String key){
		File dir=new File(Environment.getExternalStorageDirectory(),".endfamily");
		dir.mkdirs();
		File f=new File(dir,Storage.instance.levelName);
		try{
			FileInputStream fis=new FileInputStream(f);
			byte[] bts=new byte[0];
			for(int i=0;(i=fis.read())!=-1;){
				bts=ArrayUtils.push(bts,(byte)i);
			}
			JSONObject jr=new JSONObject(new String(bts));
			if(!jr.has(Storage.instance.levelName))
				return;
			JSONObject jrr=jr.getJSONObject(Storage.instance.levelName);
			jrr.remove(key);
			FileOutputStream fos=new FileOutputStream(f);
			try{
				fos.write(jr.toString(4).getBytes());
			}catch(JSONException je){
				Const.instance.print("I just cant create one......Whyyyyyyyyyyyy");
			}
			fos.close();
		}catch(IOException|JSONException e){
			Const.instance.print("[IOException]Does not exist or Bad JSON Token",2);
			Const.instance.print("[INFO]Recreating one...");
			try{
				JSONObject jo=new JSONObject();
				FileOutputStream fos=new FileOutputStream(f);
				try{
					fos.write(jo.toString(4).getBytes());
				}catch(JSONException je){
					Const.instance.print("I just cant create one......Whyyyyyyyyyyyy");
				}
				fos.close();
			}catch(IOException ie){
				Const.instance.print(ie.getClass().getName()+":"+ie.getMessage());
				Const.instance.print("[ERROR]Can't recreate JSON file '"+f.getPath()+"' . Please ensure that you have the permission.");
			}
		}
	}
	/* resetFov
	*/
	public void resetFov(){
		Storage.instance.player.fov=70;
	}
	/* setFov
	*  @param int fov
	*/
	public void setFov(int fov){
		Storage.instance.player.fov=fov;
	}
	/* resetImages
	*/
	public void resetImages(){
		Const.instance.print("Images reset");
	}
	/* selectLevel
	*  @param String path
	*/
	public void selectLevel(String path){
		Storage.instance.levelName=path;
	}
	/* setCamera
	*  @param int uuid
	*/
	public void setCamera(int uuid){
		Storage.instance.cameraUUID=uuid;
	}
	/* setFoodItem
	*  @param int id
	*  @param String texture
	*  @param int data
	*  @param int hunger
	*  @param String name
	*  @param int maxStack
	*/
	public void setFoodItem(int id,String texture,int data,int hunger,String name,int maxStack){
		ItemIdentifier iden=new ItemIdentifier(id,data);
		ItemObj obj=new ItemObj(1,texture,name,maxStack);
		obj.hunger=hunger;
		Storage.instance.items.put(iden,obj);
	}
	/* setGameSpeed
	*  @param int speed
	*/
	public void setGameSpeed(int speed){
		Storage.instance.gameSpeed=speed;
	}
	/* setGuiBlocks
	*  @param String path
	*  @warning deprecated
	*/
	@Deprecated
	public void setGuiBlocks(String path){
		Const.instance.print("[WARNING]Method 'ModPE.setGuiBlocks' is Deprecated in ModPE.");
	}
	/* setItems
	*  @param String path
	*  @warning deprecated
	*/
	@Deprecated
	public void setItems(String path){
		Const.instance.print("[WARNING]Method 'ModPE.setItems' is Deprecated in ModPE.");
	}
}
