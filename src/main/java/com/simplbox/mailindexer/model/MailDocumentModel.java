package com.simplbox.mailindexer.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.mail.Address;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
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
    private Object body;

    private MailDocumentModel(Builder builder) {
        setId(builder.id);
        setContentType(builder.contentType);
        setSubject(builder.subject);
        setDate(builder.date);
        setFrom(builder.from);
        setRecipients(builder.recipients);
        setReplyTo(builder.replyTo);
        setBody(builder.body);
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * {@code MailDocumentModel} builder static inner class.
     */
    public static final class Builder {
        private String id;
        private String contentType;
        private String subject;
        private Date date;
        private List<Address> from;
        private List<Address> recipients;
        private List<Address> replyTo;
        private Object body;

        private Builder() {
        }

        /**
         * Sets the {@code id} and returns a reference to this Builder enabling method chaining.
         *
         * @param id the {@code id} to set
         * @return a reference to this Builder
         */
        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the {@code contentType} and returns a reference to this Builder enabling method chaining.
         *
         * @param contentType the {@code contentType} to set
         * @return a reference to this Builder
         */
        public Builder withContentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        /**
         * Sets the {@code subject} and returns a reference to this Builder enabling method chaining.
         *
         * @param subject the {@code subject} to set
         * @return a reference to this Builder
         */
        public Builder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        /**
         * Sets the {@code date} and returns a reference to this Builder enabling method chaining.
         *
         * @param date the {@code date} to set
         * @return a reference to this Builder
         */
        public Builder withDate(Date date) {
            this.date = date;
            return this;
        }

        /**
         * Sets the {@code from} and returns a reference to this Builder enabling method chaining.
         *
         * @param from the {@code from} to set
         * @return a reference to this Builder
         */
        public Builder withFrom(List<Address> from) {
            this.from = from;
            return this;
        }

        /**
         * Sets the {@code recipients} and returns a reference to this Builder enabling method chaining.
         *
         * @param recipients the {@code recipients} to set
         * @return a reference to this Builder
         */
        public Builder withRecipients(List<Address> recipients) {
            this.recipients = recipients;
            return this;
        }

        /**
         * Sets the {@code replyTo} and returns a reference to this Builder enabling method chaining.
         *
         * @param replyTo the {@code replyTo} to set
         * @return a reference to this Builder
         */
        public Builder withReplyTo(List<Address> replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        /**
         * Sets the {@code body} and returns a reference to this Builder enabling method chaining.
         *
         * @param body the {@code body} to set
         * @return a reference to this Builder
         */
        public Builder withBody(Object body) {
            this.body = body;
            return this;
        }

        /**
         * Returns a {@code MailDocumentModel} built from the parameters previously set.
         *
         * @return a {@code MailDocumentModel} built with parameters of this {@code MailDocumentModel.Builder}
         */
        public MailDocumentModel build() {
            return new MailDocumentModel(this);
        }
    }
}
