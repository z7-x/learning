package learning.jpa.service;

import learning.jpa.utils.DOM4XMLUtils;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.transaction.Transactional;

/**
 * @Classname XmlDocument
 * @Description 此类用于解析xml, 解析方式为DOM解析
 * @Date 2020/8/17 11:57 上午
 * @Author z7-x
 */
@Service
@Transactional
public class XMLDocumentService {

    /**
     * @Description: 方法 parserXml 的功能描述：解析dom
     * @param filePath
     * @Return void
     * @Author z7-x
     * @Date 2020/8/17 4:16 下午
     */
    public void parserXml(String filePath) {
        Document document = DOM4XMLUtils.getDocument(filePath);
        NodeList users = document.getChildNodes();

        for (int i = 0; i < users.getLength(); i++) {
            Node user = users.item(i);
            NodeList userInfo = user.getChildNodes();

            for (int j = 0; j < userInfo.getLength(); j++) {
                Node node = userInfo.item(j);
                NodeList userMeta = node.getChildNodes();

                for (int k = 0; k < userMeta.getLength(); k++) {
                    if (userMeta.item(k).getNodeName() == "#text") {
                        System.out.println(userMeta.item(k).getNodeName() + "\n" + userMeta.item(k).getTextContent());
                    }
                }
            }
        }
    }
}
