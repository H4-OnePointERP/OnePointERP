package project.onepoint.erp.approval.dto.res;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LeaveRes {

    private int emp_seq;
    private int leave_seq;
    private int app_seq;
    private String leave_type;
    private String leave_text;
    private LocalDate leave_st_dt;
    private LocalDate leave_end_dt;

}
