package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
public class SpringLearnApplication {
    static Date date=null;
    private static final Logger LOGGER= LoggerFactory.getLogger(SpringLearnApplication.class);
    public static void main(String[] args) {

       SpringApplication.run(SpringLearnApplication.class, args);
        ApplicationContext context=new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat simpleDateFormat=context.getBean("dateformat",SimpleDateFormat.class);
        String s="31/12/2018";
        try{
        date=simpleDateFormat.parse(s);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        displayDate();
    }
    public static void displayDate(){
        LOGGER.info("START");
        LOGGER.debug(String.valueOf(date));
        LOGGER.info("END");
    }
}
