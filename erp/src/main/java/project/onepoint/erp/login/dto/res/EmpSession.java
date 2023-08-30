package project.onepoint.erp.login.dto.res;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class EmpSession {

    private int empSeq;
    private String empId;
    private String empName;

}