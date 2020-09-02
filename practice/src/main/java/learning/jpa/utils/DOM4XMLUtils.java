package learning.jpa.utils;

import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Classname DOM4XMLUtils
 * @Description TODO
 * @Date 2020/8/17 3:42 下午
 * @Author z7-x
 */
public class DOM4XMLUtils {
    /**
     * @param path
     * @Description: 方法 getDocument 的功能描述：获取整个XML文件的Document
     * @Return org.w3c.dom.Document
     * @Author z7-x
     * @Date 2020/8/17 3:44 下午
     */
    public static Document getDocument(String path) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            document = db.parse(path);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
        return document;
    }

    /**
     * @param document
     * @param path
     * @Description: 方法 writer2xml 的功能描述：更新修改后的XML文件
     * @Return void
     * @Author z7-x
     * @Date 2020/8/17 3:44 下午
     */
    public static void writer2xml(Document document, String path) {
        TransformerFactory tf = TransformerFactory.newInstance();
        try {
            Transformer ts = tf.newTransformer();
            ts.transform(new DOMSource(document), new StreamResult(path));
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param clazz
     * @param ele
     * @Description: 方法 conversionToBean 的功能描述：将xml文件映射成javaBean 注意 xml文件Node 不能为中文
     * @Return java.lang.Object
     * @Author z7-x
     * @Date 2020/8/17 3:46 下午
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Object conversionToBean(Class clazz, Node ele) {
        Object object = null;
        try {
            object = clazz.newInstance();
            Class[] parameterTypes = new Class[]{String.class};
            NodeList list = ele.getChildNodes();
            int len = list.getLength();
            for (int i = 0; i < len; i++) {
                try {
                    Node node = list.item(i);
                    String nodeName = node.getNodeName().trim();
                    String nodeVal = null;
                    Node valueNode = node.getFirstChild();
                    if (valueNode != null) {
                        nodeVal = valueNode.getNodeValue();
                    }

                    Object[] arguments = new Object[]{nodeVal};
                    if (nodeName.length() > 0) {
                        String first = nodeName.substring(0, 1);
                        String last = nodeName.substring(1);
                        Method method = clazz.getMethod("set" + first.toUpperCase() + last, parameterTypes);
                        method.invoke(object, arguments);
                    }
                } catch (NoSuchMethodException e) {
                }
            }
            return object;
        } catch (Exception e) {
            return null;
        }
    }


}
