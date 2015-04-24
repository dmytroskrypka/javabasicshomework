package myxmlparser;

import java.io.IOException;

/**
 * Demonstration of MY Simple XML Parser in action
 */
public class MyParserDemo {
    public static void main(String[] args) throws IOException {
        MySimpleXMLParser xml;
        //xml = new MySimpleXMLParser(MyParserDemo.class.getResourceAsStream("example.xml"));
        xml = new MySimpleXMLParser("C:\\Temp\\example.xml");

        String value = xml.get("catalog/book/author");
        System.out.println(value);
    }
}
