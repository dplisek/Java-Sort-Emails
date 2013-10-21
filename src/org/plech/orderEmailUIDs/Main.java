package org.plech.orderEmailUIDs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        List<Email> emails = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dateStr;
        while ((dateStr = reader.readLine()) != null) {
            Email email = new Email();
            email.setDate(getDate(dateStr));
            email.setUid(getUid(reader));
            emails.add(email);
            skipEmptyLines(reader);
        }
        Collections.sort(emails);
        for (Email email : emails) {
            System.out.println(email.getUid());
        }
    }

    private static Date getDate(String dateStr) throws ParseException {
        dateStr = dateStr.substring("date.received: ".length());
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
    }

    private static String getUid(BufferedReader reader) throws IOException {
        return reader.readLine().substring("uid: ".length());
    }

    private static void skipEmptyLines(BufferedReader reader) throws IOException {
        reader.readLine();
    }
}
