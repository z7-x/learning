package learning.jpa.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import learning.jpa.bean.basis.BaseBusEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Classname Task
 * @Description 定时任务
 * @Date 2020/8/17 1:31 下午
 * @Author z7-x
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LEARN_TASK")
@ApiModel("定时任务")
public class Task extends BaseBusEntity {
    @Id
    @Column(name = "TASK_ID")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @ApiModelProperty(value = "任务编号")
    private String taskId;

    @Column(name = "EXPRESSION")
    @ApiModelProperty(value = "任务表达式", required = true, example = "表达式格式: */5 * * * * ?")
    private String expression;

    @Column(name = "STATUS")
    @ApiModelProperty(value = "任务状态 0 删除 1启动 2 停止", required = false, example = "0 代表 删除;1 代表 启动;2 代表 停止")
    private Integer status;

    @Column(name = "TASK_NAME")
    @ApiModelProperty(value = "任务名", required = true, example = "任务一")
    private String taskName;
}
