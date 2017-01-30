package progettoelle.registrazionevoti.domain;

public class ExamResult extends BaseEntity {
    
    private Student student;
    private Exam exam;
    private Integer grade;
    private ExamResultStatus status;

    public ExamResult() {
    
    }
    
    public ExamResult(Student student, Exam exam) {
        this.student = student;
        this.exam = exam;
        status = ExamResultStatus.BOOKED;
    }

    public Exam getExam() {
        return exam;
    }
    
    public ExamResultStatus getStatus() {
        return status;
    }

    public Course getCourse() {
        return exam.getCourse();
    }

    public Integer getGrade() {
        return grade;
    }

    public Student getStudent() {
        return student;
    }
    
    public boolean isPassed() {
        return status == ExamResultStatus.PASSED_PENDING;
    }
    
    public boolean isFailed() {
        return status == ExamResultStatus.FAILED;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    public void setMark(Integer mark) {
        this.grade = mark;
        
        if (mark < 18) {
            status = ExamResultStatus.FAILED_PENDING;
        } else if (mark >= 18) {
            status = ExamResultStatus.PASSED_PENDING; 
        }
    }
    
    public void setStatus(ExamResultStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ExamResult{" + String.valueOf(getId()) + '}';
    }
    
}
