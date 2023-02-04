package com.simplbox.mailindexer.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.mail.Address;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Document("maildocumentmodel")
public class MailDocumentModel {
    @Id
    private String id;
    private String contentType;
    private String subject;
    private Date date;
    private List<Address> from;
    private List<Address> recipients;
    private List<Address> replyTo;
    private String body;

}
