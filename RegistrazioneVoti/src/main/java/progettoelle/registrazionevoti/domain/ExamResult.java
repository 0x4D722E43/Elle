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
    
    public void grade(Integer grade) {
        if (grade < 18) status = ExamResultStatus.FAILED_PENDING;
        else if (grade >= 18) status = ExamResultStatus.PASSED_PENDING;
        this.grade = grade;
    }
    
    public String getPrintableGrade() {
        if (grade < 31) return String.valueOf(grade);
        else return "30L";
    }
    
    public boolean isPassed() {
        return status == ExamResultStatus.PASSED_PENDING;
    }
    
    public boolean isFailed() {
        return status == ExamResultStatus.FAILED_PENDING;
    }

    public Student getStudent() {
        return student;
    }
    
    public Exam getExam() {
        return exam;
    }
    
    public Integer getGrade() {
        return grade;
    }
    
    public ExamResultStatus getStatus() {
        return status;
    }

    public Course getCourse() {
        return exam.getCourse();
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
    
    public void setStatus(ExamResultStatus status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "ExamResult { " + getId() + "}";
    }
    
}
