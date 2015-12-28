package dto;
//dto를 만든다. 파일 업로드시 제목, 이름, 파일을 dto로 쉽게 저장해서 사용하기 위해서 만듬...  

import org.springframework.web.multipart.MultipartFile;

public class UploadDto {

	private String title;
	private String name;
	private MultipartFile upFile;//Spring 에서 제공하는 upload 
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getUpFile() {
		return upFile;
	}
	public void setUpFile(MultipartFile upFile) {
		this.upFile = upFile;
	}
	
	
}
