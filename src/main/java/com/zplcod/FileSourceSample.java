package com.zplcod;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class FileSourceSample {
	public static final void call() {

		String filePath = "C:/Documents/Sources/Java/samplej2ee/target/classes/file1.txt";
		Resource res1 = new FileSystemResource(filePath);
		Resource res2 = new ClassPathResource("file1.txt");
		try {
			InputStream iput1 = res1.getInputStream();
			InputStream iput2 = res2.getInputStream();
			System.out.println("res1:" + res1.getFilename());
			System.out.println("res2:" + res2.getFilename());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
