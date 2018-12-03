package net.maxproit.salesforce.masum.model.local;

public class Attachment {
    int id,leadId;
    byte[] profilePic,idCard,visitingCard;

    public Attachment(int id, int leadId, byte[] profilePic, byte[] idCard, byte[] visitingCard) {
        this.id = id;
        this.leadId = leadId;
        this.profilePic = profilePic;
        this.idCard = idCard;
        this.visitingCard = visitingCard;
    }

    public Attachment(int leadId, byte[] profilePic, byte[] idCard, byte[] visitingCard) {
        this.leadId = leadId;
        this.profilePic = profilePic;
        this.idCard = idCard;
        this.visitingCard = visitingCard;
    }

    public int getId() {
        return id;
    }

    public int getLeadId() {
        return leadId;
    }

    public byte[] getProfilePic() {
        return profilePic;
    }

    public byte[] getIdCard() {
        return idCard;
    }

    public byte[] getVisitingCard() {
        return visitingCard;
    }
}
