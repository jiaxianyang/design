package com.example.design.base;

/**
 * @author jiaxianyang
 * @date 2025/1/5 10:36
 */
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class XmlErrorLocator {
    public static void main(String[] args) {
        StringBuilder xmlBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data.xml"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                xmlBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String xml = xmlBuilder.toString();

        try {
            parseXml(xml);
            System.out.println("XML 解析成功");
        } catch (DocumentException e) {
            System.out.println("XML 解析失败: " + e.getMessage());
        }
    }

    private static void parseXml(String xml) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new StringReader(xml));
    }
}
