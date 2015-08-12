package com.codeaholicguy.dota2matchticker;

import com.codeaholicguy.dota2matchticker.job.GosuGamersParsingJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hoangnn
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(new Object[]{Application.class}, args);
    }
}
