package com;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
public class DOMDemo01 {
    public static void main(String[] args) {
        //1建立DocumentBuilderFactory，用来取得DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }

        //定义Document接口对象，通过DocumentBuilder类进行DOM树的转换操作
        Document doc = null;
        try {
            //读取指定路径的XML文件
            doc =  builder.parse(File.separator + "/Users/appti/Downloads/GitHub项目/web_learning/Chapter3_DOM/Chapter3_DOM.iml ");
        }
        catch (SAXException e){
            e.printStackTrace();;
        }
        catch (IOException e){
            e.printStackTrace();
        }

        //查找name的节点
        NodeList nl = doc.getElementsByTagName("name");
        //输出Nodelist中第一个子节点中国呢文本节点的内容
        System.out.println("姓名"+ nl.item(0).getFirstChild().getNodeValue());




    }

}
