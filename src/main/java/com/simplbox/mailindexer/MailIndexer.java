package com.simplbox.mailindexer;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


public class MailIndexer {
    public static List<MimeMessage> index(String emlPath) throws MessagingException, IOException {
        File folder = new File(emlPath);
        File[] listOfFiles = folder.listFiles();
        List mails = new ArrayList<MimeMessage>();
        if (listOfFiles!=null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                    mails.add(parseEml(emlPath, file));
                }
            }
        }
        return mails;
    }
    private static MimeMessage parseEml(String path, File emlFile) throws IOException, MessagingException {
        Properties props = new Properties();
        Session mailSession = Session.getDefaultInstance(props, null);
        InputStream source = new FileInputStream(emlFile);
        MimeMessage message = new MimeMessage(mailSession, source);
        System.out.println("Subject : " + message.getSubject());
        System.out.println("From : " + Arrays.toString(message.getFrom()));
        System.out.println("Recipients : " + Arrays.toString(message.getAllRecipients()));
        System.out.println("Sent Date : " +  message.getSentDate());
        System.out.println("Reply to : " + Arrays.toString(message.getReplyTo()));
        System.out.println("Content Type : " +  message.getContentType());

        return message;


//        System.out.println("Header : " +  java.util.Arrays.asList((InternetHeader)message.getHeader().nextElement()));
        /*
        String contentType = message.getContentType();
        if (contentType.contains("multipart")) {
            System.out.println("Multipart EMail File");
            Multipart multiPart = (Multipart) message.getContent();
            int numberOfParts = multiPart.getCount();
            System.out.println("Parts:::"+numberOfParts);
            for (int partCount = 0; partCount < numberOfParts; partCount++) {
                MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                    String fileName = part.getFileName();
                    String extension="";
                    String path = path + File.separator + fileName;
                    int i=fileName.lastIndexOf(".");
                    if(i>0)
                    {
                        extension=fileName.substring(i+1);
                    }
                    if(extension.equalsIgnoreCase("pdf"))
                    {
                        part.saveFile(path);
                    }
                }
            }
        }
        */
//        System.out.println("--------------");
//        System.out.println("Body : " +  message.getContent().toString());
//        System.out.println("--------------");
//        System.out.println("--------------");


    }
}
