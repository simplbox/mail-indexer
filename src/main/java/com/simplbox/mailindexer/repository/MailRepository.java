package com.simplbox.mailindexer.repository;

import com.simplbox.mailindexer.model.MailDocumentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface MailRepository extends MongoRepository<MailDocumentModel, String> {
}
