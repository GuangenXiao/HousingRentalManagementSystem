package ie.ul.cs4227.Bass.Util;

import java.util.Date;
import java.io.File;
import java.io.FileOutputStream;
public class FileTools implements Tools{

	@Override
	public int launch(Date birthDay) throws Exception {
		return 0;
	}

	@Override
	public void uploadfile(byte[] file, String filePath, String fileName) throws Exception {
		File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
	}
     
}
