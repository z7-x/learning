package learning.features.lambda.service.impl;

import learning.features.lambda.bean.Item;

/**
 * @Classname ItemCreatorParamContruct
 * @Description TODO
 * @Date 2020/8/17 4:56 下午
 * @Author z7-x
 */
@FunctionalInterface
public interface ItemCreatorParamConstruct {
    Item getItem(int id, String name, double price);
}
