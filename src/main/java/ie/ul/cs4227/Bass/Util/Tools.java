package ie.ul.cs4227.Bass.Util;

import java.util.Date;

public interface Tools {
	public abstract int launch(Date birthDay) throws Exception;	
	public abstract void uploadfile(byte[] file, String filePath, String fileName)throws Exception;
}
