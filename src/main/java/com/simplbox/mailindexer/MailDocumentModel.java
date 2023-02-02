package com.simplbox.mailindexer;

import org.springframework.data.annotation.Id;

public class MailDocumentModel {
    @Id
    private String id;
    private String subject;
    private String replyTo;
    private String contentType;
    private String from;
    private String recipients;
    private String date;
    private String body;

    public MailDocumentModel() {}

}
