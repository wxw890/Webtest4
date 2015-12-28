package controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import dao.UploadDao;
import dto.UploadDto;

@Controller
@RequestMapping("/upload.spring")//클래스 위부분에 @RequestMapping인 annotation을 추가해줘서 value을 주면 메서드에 그동안 반복해야했던 value를 반복적으로 안써도 되면서 깔끔하다.
public class UploadController {
	
	@RequestMapping(params={"ver=first"})//params={"ver=first"}는 파라미터가 first인 요청을 받는다라는 뜻
	public String firstHandle(){
		return "upload1";
	}
	

	@RequestMapping(params={"ver=first"}, method=RequestMethod.POST)
	public String firstSubmitHandler(UploadDto uploadDto, HttpServletRequest req) throws IOException{
		/*
		System.out.println(uploadDto.getTitle());
		System.out.println(uploadDto.getName());
		System.out.println(uploadDto.getUpFile().getOriginalFilename());
		 */
		
		MultipartFile file = uploadDto.getUpFile();//uploadDto.getUpFile()의 type이 MultipartFile이므로 MultipartFile로 받아준다.
		System.out.println(uploadDto.getUpFile().getOriginalFilename());
		String path = 
			WebUtils.getRealPath(req.getSession().getServletContext(), "/upload");//WebUtils.getRealPath는 실제 경로를 전달해준다. 즉, upload폴더의 위치를 알아 낼수 있다.
		System.out.println("파일경로:"+path);
		UploadDao uploadDao = new UploadDao();
		uploadDao.writeFile(file, path, file.getOriginalFilename());//실제 파일 업로드를 시켜주는 부분
		
		return "completeUpload1";
	}
	
}
