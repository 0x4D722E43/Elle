package progettoelle.registrazionevoti.domain;

import java.io.Serializable;

public enum ExamResultStatus implements Serializable{
    
    BOOKED, PASSED_PENDING, FAILED_PENDING, ACCEPTED, REJECTED, FAILED;

}
