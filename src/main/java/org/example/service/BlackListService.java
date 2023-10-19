package org.example.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWriter {
    private final List<String> listIP = new ArrayList<>();
    private final String BLACKLIST = "src/main/resources/blacklist.txt";

    public void read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(BLACKLIST));
        String line = reader.readLine();
        while (line != null) {
            listIP.add(line);
            line = reader.readLine();
        }
    }

    public void delete(String valueIp) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(BLACKLIST));
        checkingListNotEmpty();
        listIP.remove(valueIp);

        for (String s : listIP) {
            writer.write(s + "\n");
        }
        writer.close();
    }

    public void save(String valueIp) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(BLACKLIST));
        checkingListNotEmpty();
        listIP.add(valueIp);
        printWriter.println(valueIp);

        printWriter.close();
    }

    public List<String> getListIP() throws IOException {
        checkingListNotEmpty();

        return listIP;
    }

    private void checkingListNotEmpty() throws IOException {
        if (listIP.isEmpty()) {
            read();
        }
    }


}
