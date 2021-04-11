package ie.ul.cs4227.Bass.Service.Interceptor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class LogInterceptor implements Interceptor{
	private final String OUT_FILE = "RentalLog.txt";
    public LogInterceptor(){
    }
	@Override
	public void execute(Object context) {
		String out = context.toString();

        OutputStream os = null;
        try {
            boolean append = new File(OUT_FILE).exists();
            os = new FileOutputStream(new File(OUT_FILE), append);
            os.write(out.getBytes(), 0, out.length());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                os.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
		
	}
}
