package project.onepoint.erp.login.dto.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class LoginReq {
    @NotEmpty
    private String empId;
    @NotEmpty
    private String empPassword;

}