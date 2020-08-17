package learning.jpa.lambda.service.impl;

import learning.jpa.lambda.bean.Item;

/**
 * @Classname ItemCreatorBlankConstruct
 * @Description TODO
 * @Date 2020/8/17 4:55 下午
 * @Author z7-x
 */
@FunctionalInterface
public interface ItemCreatorBlankConstruct {
    Item getItem();
}
