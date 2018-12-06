package com.teacher.utils;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.ConnectException;

public class OfficeOperate {
    public static int Office2PDF(String sourceFile, String destFile) throws FileNotFoundException {
        try {
            File inputFile = new File(sourceFile);
            if (!inputFile.exists()) {
                return -1;// 找不到源文件, 则返回-1
            }

            // 如果目标路径不存在, 则新建该路径
            File outputFile = new File(destFile);
            if (!outputFile.getParentFile().exists()) {
                outputFile.getParentFile().mkdirs();
            }

            // connect to an OpenOffice.org instance running on port 8100
            OpenOfficeConnection connection = new SocketOpenOfficeConnection(
                    "127.0.0.1", 8100);
            connection.connect();

            // convert
            DocumentConverter converter = new OpenOfficeDocumentConverter(
                    connection);
            converter.convert(inputFile, outputFile);

            // close the connection
            connection.disconnect();

            return 0;
        } catch (ConnectException e) {
            e.printStackTrace();
        }

        return 1;
    }

}



