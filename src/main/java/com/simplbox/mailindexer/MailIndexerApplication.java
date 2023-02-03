package com.simplbox.mailindexer;

import com.simplbox.mailindexer.model.MailDocumentModel;
import com.simplbox.mailindexer.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class MailIndexerApplication implements CommandLineRunner{
	@Autowired
	MailRepository mailRepository;
	public static void main(String[] args) throws MessagingException, IOException {
		SpringApplication.run(MailIndexerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String path = "D:/Code/emails";
		List<MimeMessage> mails = MailIndexer.index(path);

		if (!mails.isEmpty()) {
			for (MimeMessage mail : mails) {
				System.out.println("Data creation started...");

				mailRepository.save(
						MailDocumentModel.builder()
								.withId(mail.getContentMD5())
								.withContentType(mail.getContentType())
								.withSubject(mail.getSubject())
								.withDate(mail.getSentDate())
								.withFrom(Arrays.asList(mail.getFrom()))
								.withRecipients(Arrays.asList(mail.getAllRecipients()))
								.withReplyTo(Arrays.asList(mail.getReplyTo()))
								.build()
				);

				System.out.println("Data creation complete...");
			}
		}
	}
}
