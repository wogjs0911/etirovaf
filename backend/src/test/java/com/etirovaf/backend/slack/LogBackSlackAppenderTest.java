package com.etirovaf.backend.slack;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LogBackSlackAppenderTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test(){
        try{
            Integer[] array = {1,2,3,4,5};
            System.out.println(array[6]);

        } catch (Exception e){
            logger.error("Error level 테스트");
        }
    }
}
