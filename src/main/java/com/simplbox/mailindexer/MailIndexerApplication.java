package com.simplbox.mailindexer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
public class MailIndexerApplication {

	public static void main(String[] args) throws MessagingException, IOException {
		String path = "D:/Code/emails";
		MailIndexer.index(path);
		SpringApplication.run(MailIndexerApplication.class, args);
	}

}
