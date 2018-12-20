
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.util.Iterator;

public class DOM4JRead {
    public static void main(String[] args) {
        File file = new File("xml_demo_03.xml");
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();
        Iterator iter = root.elementIterator();
        while (iter.hasNext()){
            Element linkMan = (Element)iter.next();
            System.out.println("姓名:"+linkMan.elementText("name"));
            System.out.println("邮件："+linkMan.elementText("email"));
        }
    }
}
