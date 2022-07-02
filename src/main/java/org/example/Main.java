package org.example;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        URL postUrl = new URL("https://dummy.restapiexample.com/api/v1/create");
        HttpURLConnection http = (HttpURLConnection)postUrl.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter name: ");
        jsonObject.put("name",in.next());
        jsonObject.put("salary","123");
        jsonObject.put("age","23");
        byte[] out = jsonObject.toJSONString().getBytes(StandardCharsets.UTF_8);

        OutputStream stream = http.getOutputStream();
        stream.write(out);

        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());

        http.disconnect();
    }
}
