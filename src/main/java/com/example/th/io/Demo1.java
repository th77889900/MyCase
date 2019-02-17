package com.example.th.io;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.*;

@Slf4j
public class Demo1 {
    public static void main(String[] args) {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        String result ;

        try {
            File src = new File("E:/test/QR-1024.jpg");
            fis = new FileInputStream(src);

            byte[] array = new byte[10];



            File dest = new File("E:/test/1024.jpg");

            fos = new FileOutputStream(dest);



            while (-1 != (fis.read(array))) {
                fos.write(array);
            }

            fos.flush();

        } catch (FileNotFoundException e) {
            log.warn("io file not found exception ", e);
        } catch (IOException e) {
            log.warn("io data exception ", e);
        }finally {

            if (!StringUtils.isEmpty(fis)) {
                try {
                    fis.close();
                } catch (IOException e) {
                    log.warn("io data exception ", e);
                }
            }

            if (!StringUtils.isEmpty(fos)) {
                try {
                    fos.close();
                } catch (IOException e) {
                    log.warn("io data exception ", e);
                }
            }

        }
    }
}
