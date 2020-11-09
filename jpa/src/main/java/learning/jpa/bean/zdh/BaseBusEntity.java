package learning.jpa.bean.zdh;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseBusEntity implements Serializable {

    private static final long serialVersionUID = -6543503526965322995L;

    protected static final String FIELDS_BY_CREATOR = "creator";
    protected static final String FIELDS_BY_CREATE_TIME = "createdAt";
    protected static final String FIELDS_BY_MODIFIER = "modifier";
    protected static final String FIELDS_BY_MODIFY_TIME = "updatedAt";
    protected static final String[] BASE_FIELDS = {FIELDS_BY_CREATOR, FIELDS_BY_CREATE_TIME, FIELDS_BY_MODIFIER, FIELDS_BY_MODIFY_TIME};
    protected static final String BASE_JSONFIELDS = FIELDS_BY_CREATOR + ",create_time," + FIELDS_BY_MODIFIER + ",modify_time";

    /**
     * 创建人
     */
    @Column(updatable = false, name = "CREATOR", length = 20)
    private String creator;
    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, name = "CREATE_TIME")
    private Date createdAt;
    /**
     * 最后修改人
     */
    @Column(name = "MODIFIER", length = 20)
    private String modifier;
    /**
     * 最后修改时间
     */
    @JsonProperty("modify_time")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFY_TIME")
    private Date updatedAt;

}