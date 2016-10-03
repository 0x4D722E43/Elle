package modelloVoti2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gianluca
 */
public class CourseTest {
    Course course;
    Classroom room;
    Date startTime,endTime;
    ArrayList<Student> joined;
    HashMap<Student,Rating> raitings;

    public CourseTest(Classroom room, Date startTime, Date endTime) {
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
        this.joined = new ArrayList<>();
        this.raitings = new HashMap<>();
    }
    public Course getCourse(){
        return course;
    }
    void setCourse(Course c){
        this.course = c;
    }
    public void addStudent(Student stu){
        joined.add(stu);
    }
    public void rmStudent(Student stu){
        joined.remove(stu);
    }
    public void assignRate(Student stu,Rating rate){
        rate.setCourse(this.course);
        rate.setTest(this);
        raitings.put(stu, rate);
    }

    public boolean isValutated() {
        return raitings.keySet().containsAll(joined);
    }
    public Rating getRate(Student stu){
        return this.raitings.get(stu);
    }
    
    public class Rating {
        private Course course;
        private CourseTest test;
        private Integer value;
        private Student student;
        private Date data;
        private Integer status;//0 in sospeso, 1 accettato, 2 rifiutato;

        Rating(Integer value, Student student) {
            this.value = value;
            this.student = student;
            this.data = new Date();
        }
        private void setTest(CourseTest ct){
            this.test = ct;
        }
        private void setCourse(Course c){
            this.course = c;
        }
        
        public void suspend(){
            status = 3;
        }
        public void accept() {
            if(status==0){
                status = 1;
            }else{
                //throw 
            }
        }

        public void refuse() {
            if(status==0){
                status = 2;
            }else{
                //throw
            }
    }
    }
}
