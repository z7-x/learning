package learning.jpa.service;

import learning.jpa.service.impl.SendMessageImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Classname WeChatService
 * @Description TODO
 * @Date 2020/10/9 10:27 上午
 * @Author z7-x
 */
@Service
@Data
public class WeChatService implements SendMessageImpl {

    @Value("${SendMessage.WeChat}")
    private String WeChat;
    @Value("${SendMessage.DingDing}")
    private String DingDing;


    @Override
    public void sendMessage(Object messages) {
        System.out.println(messages + " 微信：" + getWeChat() + "叮叮：" + getDingDing());
        System.out.println("success");
    }
}
