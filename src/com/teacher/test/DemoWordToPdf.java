package com.teacher.test;

import com.teacher.utils.OfficeOperate;
import org.junit.Test;

import java.io.FileNotFoundException;

public class DemoWordToPdf {
    @Test
    public void Demo(){
        try {
            OfficeOperate.Office2PDF("/home/misaki/Downloads/test.doc","/home/misaki/Downloads/test.pdf");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



}
