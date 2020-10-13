package com.example.mybatis.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Classname MUser
 * @Description TODO
 * @Date 2020/10/12 2:55 下午
 * @Author z7-x
 */
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "LEARN_USER")
@ApiModel(description = "用户信息")
public class MUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "用户编号")
    private String userId;

    @ApiModelProperty(value = "姓名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String passWord;
}
