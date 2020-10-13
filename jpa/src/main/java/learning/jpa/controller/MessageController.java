package learning.jpa.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import learning.jpa.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname MessageController
 * @Description TODO
 * @Date 2020/10/9 10:56 上午
 * @Author z7-x
 */
@RestController
@RequestMapping("/messages")
@Api(tags = "消息发送配置", description = "消息发送配置")
public class MessageController {
    @Autowired
    private WeChatService weChatService;

    @ApiOperation(value = "消息发送配置", notes = "消息发送配置")
    @RequestMapping(method = RequestMethod.POST, value = "/send")
    public void sendMessage(){
        weChatService.sendMessage("发送消息配置");
    }
}
