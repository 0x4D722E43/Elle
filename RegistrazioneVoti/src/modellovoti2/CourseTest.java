/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellovoti2;

import java.util.Date;

/**
 *
 * @author Gianluca
 */
public class CourseTest {
    Archive archive;
    String room;
    Date startTime,endTime;
    Integer ID;

    public CourseTest(String room, Date startTime, Date endTime) {
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public Course getCourse(){
        return archive.getCourse(this);
    }

    public void addStudent(Student stu){
        archive.joinToTest(stu,this);
    }
    public void rmStudent(Student stu){
        archive.unjoinFromTest(stu,this);
    }
    public void assignRate(Student stu,Rating rate){
        archive.assignRate(rate,stu,this);
    }

    public boolean isValutated() {
        return archive.isValutated(this);
    }
    public Rating getRate(Student stu){
        return archive.getRates(this);
    }
    public Integer getID(){
        return ID;
    }
    void setID(Integer id){
        this.ID = id;
    }

    public String getClassRoom() {
        return this.room;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
    
    public class Rating {
        private Integer value;
        private Student student;
        private Date data;
        private Integer status;//0 in sospeso, 1 accettato, 2 rifiutato;

        Rating(Integer value, Student student) {
            this.value = value;
            this.student = student;
            this.data = new Date();
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
