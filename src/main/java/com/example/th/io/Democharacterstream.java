package com.example.th.io;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.*;

@Slf4j
public class Democharacterstream {
    public static void main(String[] args) {

        FileReader fr = null;
        FileWriter fw = null;
        String result ;

        try {
            File src = new File("E:/test/QR-1024.jpg");
            fr = new FileReader(src);

            byte[] array = new byte[10];



            File dest = new File("E:/test/1024.jpg");

            fw = new FileWriter(dest);



//            while (-1 != (fw.read(array))) {
//                fw.write(array);
//            }


        } catch (FileNotFoundException e) {
            log.warn("io file not found exception ", e);
        } catch (IOException e) {
            log.warn("io data exception ", e);
        }finally {

            if (!StringUtils.isEmpty(fr)) {
                try {
                    fr.close();
                } catch (IOException e) {
                    log.warn("io data exception ", e);
                }
            }

            if (!StringUtils.isEmpty(fw)) {
                try {
                    fw.close();
                } catch (IOException e) {
                    log.warn("io data exception ", e);
                }
            }

        }
    }
}
