package org.example;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/* main method를 실행했을 때 Tomcat을 실행시키기 위하여 WebApplication으로 이름 변경함. */
public class WebApplicationServer {
	private static final Logger log = LoggerFactory.getLogger(WebApplicationServer.class);

	public static void main(String[] args) throws Exception {
		String webappDirLocation = "webapps/";
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080); // port :: 8080으로 설정

		// localhost:8080으로 입력했을 때 webappDirLocation을 바라보도록 한다.
		// 경로를 입력했을 때 webappDirLocation를 root로 보고 위 파일의 하위에 있는 파일들을 찾아서 실행함.
		tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
		log.info("configuring app with basedir: {}", new File("./" + webappDirLocation).getAbsolutePath());

		tomcat.start();
		tomcat.getServer().await();
	}
}
