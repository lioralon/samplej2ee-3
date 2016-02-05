package com.zplcod;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class PatternResolverSample {

	public static final void call() throws IOException {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource res1 = resolver.getResource("classpath:config/bean.xml");
		Resource res2 = new ClassPathResource("file1.txt");
		System.out.print(res1.getURI().toString() + res2.getURI().toString());
		Resource[] resources = resolver.getResources("classpath:config/*.xml");
		for (Resource res : resources) {
			System.out.println(res.getDescription());
		}

	}
}
