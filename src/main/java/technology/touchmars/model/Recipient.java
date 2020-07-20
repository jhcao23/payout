package technology.touchmars.model;

import javax.persistence.*;

@Entity
@Table(name = "recipient")
public class Recipient extends Names{

    // the sender who creates this recipient,
    // assuming recipient is CRM based and sender has ownership to self created recipients.
    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = BusinessSender.class)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private BusinessSender sender;

    @Embedded
    private RecipientId recipientId;



}
