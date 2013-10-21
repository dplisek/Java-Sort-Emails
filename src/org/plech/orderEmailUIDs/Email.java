package org.plech.orderEmailUIDs;

import java.util.Date;

public class Email implements Comparable<Email> {

    private Date date;
    private String uid;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public int compareTo(Email o) {
        return date.compareTo(o.date);
    }
}
