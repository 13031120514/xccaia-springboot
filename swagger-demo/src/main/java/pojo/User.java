package pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：xccaia
 * @ Date       ：2020-03-31
 * @ Description：
 */
@Data
public class User {

    @ApiModelProperty(value = "用户id")
    private Integer id;
    @ApiModelProperty(value = "用户名称")
    private String userName;
    @ApiModelProperty(value = "备注")
    private String remark;

    public User(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
    }


    public User(Integer id, String userName, String remark) {
        this.id = id;
        this.userName = userName;
        this.remark = remark;
    }
}
