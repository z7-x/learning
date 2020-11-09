package learning.jpa.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import learning.jpa.service.XMLDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname XmlAnalysisController
 * @Description TODO
 * @Date 2020/8/17 2:00 下午
 * @Author z7-x
 */
@RestController
@RequestMapping("/xml")
@Api(tags = "解析Xml", description = "解析Xml")
public class AnalysisXMLController {
    @Autowired
    private XMLDocumentService xmlDocumentService;

    final String filePath = "/Volumes/工作文档/spring/boot-test/springboot/learn-practice/jpa/src/main/java/learning/features/lambda/instructions.xml";

    @ApiOperation(value = "dom解析xml", notes = "dom解析xml")
    @RequestMapping(method = RequestMethod.GET, value = "/dom")
    public void analysisXml() {
        xmlDocumentService.parserXml(filePath);
    }
}
