package com.example.th.netprogram.democase;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class Demo3 {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com.hk/webhp?hl=zh-CN&sourceid=cnhp&gws_rd=ssl&pli=1");

            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"), "utf-8"));

            String msg = null;

            while ((msg = bufferReader.readLine()) != null) {
                writer.append(msg);
                writer.newLine();
            }

            writer.flush();
            writer.close();
            bufferReader.close();

        } catch (MalformedURLException e) {
            log.warn("path is wrong ", e);
        } catch (UnsupportedEncodingException e) {
            log.warn("UnsupportedEncodingException ", e);
        } catch (IOException e) {
            log.warn("IO exception ", e);
        }

    }
}
