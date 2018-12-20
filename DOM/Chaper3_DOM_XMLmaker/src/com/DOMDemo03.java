package com;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMDemo03 {
    public static void main(String[] args) {
        //建立DocumentBuilderFactory以获得DocumentBuilder对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        //定义Document接口对象，通过DocumentBuilder进行DOM树的转换操作
        Document doc;
        doc = builder.newDocument();

        //建立各个操作节点
        Element addresslist = doc.createElement("addresslist");
        Element linkman = doc.createElement("linkman");
        Element name = doc.createElement("name");
        Element email = doc.createElement("email");
        //设置节点的文本内容
        name.appendChild(doc.createTextNode("张士煜"));
        email.appendChild(doc.createTextNode("2453455@1124"));
        //设置节点关系
        linkman.appendChild(name);
        linkman.appendChild(email);
        addresslist.appendChild(linkman);
        doc.appendChild(addresslist);

        //输出文档到文件中
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = null;
        try {
            t = tf.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        t.setOutputProperty(OutputKeys.ENCODING,"GBK");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("appti/"+File.separator +"output.xml"));

        try {
            t.transform(source,result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }
}
