package com.murilo.cursomc.config;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.dropbox.core.v2.DbxClientV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;


@Configuration
public class DropboxConfig  {
	
	private static final String ACCESS_TOKEN = System.getenv().get("DROPBOX_ACCESS_TOKEN");
	
	@Bean
	public DbxClientV2 dropboxClient() {
		DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/cursoionic").build();
		return new DbxClientV2(config, ACCESS_TOKEN);
	}
}
