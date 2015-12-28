package dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class UploadDao {

		
private FileOutputStream fout;
	
	public void writeFile(MultipartFile file, String path, String filename) throws IOException{
		try{
			byte fileData[] = file.getBytes();
			fout = new FileOutputStream(path + File.separator + filename);//File.separator란 /또는 \를 사용부분을 통합시키기 위해서 사용함
			fout.write(fileData);
		}
		catch(IOException err){
			err.printStackTrace();
		}
		finally{
			fout.close();
		}
	}
}
