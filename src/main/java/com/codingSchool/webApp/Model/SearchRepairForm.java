package com.codingSchool.webApp.Model;

import com.codingSchool.webApp.Domain.User;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class SearchRepairForm {


    private static final String DATETIME_PATTERN = "^([0-9]{4}\\-[0-9]{2}\\-[0-9]{2})*$";
    private static final String SSN_PATTERN = "^[0-9]*$";
    private static final int SSN_MINSIZE = 9;

    @NotNull(message = "{insert.ssn.null}")
    @Pattern(regexp = SSN_PATTERN, message = "{insert.ssn.invalid}")
    @Size(min = SSN_MINSIZE, message = "{insert.ssn.size}")
    private String ssn;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
            this.ssn = ssn;
    }
}
