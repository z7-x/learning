package learning.jpa.bean.basis;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * @Classname BaseBusEntity
 * @Description TODO
 * @Date 2020/8/13 4:16 下午
 * @Author z7-x
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@ApiModel(description = "基础类")
public class BaseBusEntity implements Serializable {

    @Column(updatable = false, name = "CREATOR", length = 20)
    @ApiModelProperty(value = "创建人")
    private String creator;

    @JsonProperty("create_time")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, name = "CREATE_TIME")
    @ApiModelProperty(value = "创建时间")
    private Date createdAt;

    @Column(name = "MODIFIER", length = 20)
    @ApiModelProperty(value = "最后修改人")
    private String modifier;

    @JsonProperty("modify_time")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFY_TIME")
    @ApiModelProperty(value = "最后修改时间")
    private Date updatedAt;
}
