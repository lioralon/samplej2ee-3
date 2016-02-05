package com.zplcod;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

public class EncodeResource {

	public static final void call() throws Throwable {

		Resource res1 = new ClassPathResource("file1.txt");
		EncodedResource encRes1=new EncodedResource(res1,"UTF-8");
		String content = FileCopyUtils.copyToString(encRes1.getReader());
		System.out.println(content);
		
	}
}
