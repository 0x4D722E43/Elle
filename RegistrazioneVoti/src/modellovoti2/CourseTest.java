/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellovoti2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Gianluca
 */
public class CourseTest {
    Archive archive;
    String room;
    Date startTime,endTime;
    Integer ID;

    CourseTest(String room, Date startTime, Date endTime) {
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    /**
     *
     * @return the relative course
     */
    public Course getCourse(){
        return archive.getCourse(this);
    }

    /**
     *Join a student from the test
     * @param student
     */
    public void join(Student stu){
        archive.joinToTest(stu,this);
    }

    /**
     * Unjoin a student from the test
     * @param student
     */
    public void unjoin(Student stu){
        archive.unjoinFromTest(stu,this);
    }
    
    /**
     * Assign a rate to a student
     * @param student
     * @param rate
     */
    public void assignRate(Student stu,Integer rate){
        archive.assignRate(new Rating(rate),stu,this);
    }

    /**
     *
     * @return if is assigned a rate to all the student
     */
    public boolean isValutated() {
        return archive.isValutated(this);
    }

    /**
     *
     * @return Students joined to test
     */
    public ArrayList<Student> getJoined(){
        return archive.getJoined(this);
    }
    
    /**
     *
     * @param student
     * @return the rate of the student
     */
    public Rating getRate(Student stu){
        return archive.getRating(stu,this);
    }
    public Integer getID(){
        return ID;
    }
    void setID(Integer id){
        this.ID = id;
    }

    /**
     *
     * @return the classroom where test is located
     */
    public String getClassRoom() {
        return this.room;
    }

    /**
     *
     * @return the starting time of test
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     *
     * @return the ending time of test
     */
    public Date getEndTime() {
        return endTime;
    }

    void setArchive(Archive archive) {
        this.archive = archive;
    }
    
    public class Rating {
        private Integer value;
        private Date data;
        private Integer status;//0 in sospeso, 1 accettato, 2 rifiutato;

        Rating(Integer value) {
            this.value = value;
            this.data = new Date();
        }
        public Integer getValue(){
            return value;
        }
        public Integer getStatus(){
            return status;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.ID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CourseTest other = (CourseTest) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }
    
}
