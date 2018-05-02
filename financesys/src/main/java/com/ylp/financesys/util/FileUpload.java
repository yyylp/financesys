package com.ylp.financesys.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	public Map<String, String>  upload(HttpServletRequest request,MultipartFile file,String path) {
		Map<String, String> map=new HashMap<String, String>();
		if (!file.isEmpty()&&file!=null) {
			String savePath=path+"_"+new Date().getTime()+file.getOriginalFilename();
			String basePath=request.getServletContext().getRealPath("");
			File dest=new File(new File(basePath).getParent(),savePath);
			try {
				file.transferTo(dest);
				map.put("upload",savePath);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
}
