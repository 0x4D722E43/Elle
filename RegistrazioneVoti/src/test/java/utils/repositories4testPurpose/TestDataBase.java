/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.repositories4testPurpose;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

import progettoelle.registrazionevoti.domain.BaseEntity;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.DegreeCourse;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Faculty;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.domain.Student;

/**
 *
 * @author mrc
 */
public class TestDataBase {

    private ArrayList<Course> courses;
    private ArrayList<DegreeCourse> degreeCourses;
    private ArrayList<Exam> exams;
    private ArrayList<ExamResult> examResults;
    private ArrayList<Faculty> faculties;
    private ArrayList<Professor> professors;
    private ArrayList<Student> students;
    private ArrayList<Enrollment> enrolling;

    public TestDataBase() {
        courses = new ArrayList<>();
        degreeCourses = new ArrayList<>();
        exams = new ArrayList<>();
        examResults = new ArrayList<>();
        faculties = new ArrayList<>();
        professors = new ArrayList<>();
        students = new ArrayList<>();
        enrolling = new ArrayList<>();
    }

    public void init() {
        initFaculty();
        initDegreeCourse();
        initProf();
        initStudents();
        initCourse();
        initExams();
        initExamResults();
        initEnrolling();
        
    }

    ArrayList<Course> getCourses() {
        return courses;
    }

    ArrayList<DegreeCourse> getDegreeCourses() {
        return degreeCourses;
    }


    ArrayList<Exam> getExams() {
        return exams;
    }


    ArrayList<ExamResult> getExamResults() {
        return examResults;
    }

    ArrayList<Faculty> getFaculties() {
        return faculties;
    }


    ArrayList<Professor> getProfessors() {
        return professors;
    }


    ArrayList<Student> getStudents() {
        return students;
    }

    List<Enrollment> getEnrolling() {
        return enrolling;
    }


    private void initFaculty() {
        Faculty tmp = new Faculty("Ingegneria");
        tmp.setId(1L);
        faculties.add(tmp);
        tmp = new Faculty("Economia");
        tmp.setId(2L);
        faculties.add(tmp);

    }

    private void initDegreeCourse() {
        //ID(PROGRESSIVO), NOME, ID FACOLTà
        String[][] data = new String[][]{
            {"Ingegneria Elettronica e Informatica", "1"},
            {"Bioingegneria", "1"},
            {"Ingegneria civile e ambientale", "1"},
            {"Ingegneria Industriale", "1"},
            {"Ingegneria edile-archidettura", "1"},
            {"Amministrazione, controllo e finanza", "2"},
            {"Economia", "2"},
            {"Management", "2"},};
        for (int i = 0; i < data.length; i++) {
            long f_id = Long.parseLong(data[i][1]);
            String name = data[i][0];
            DegreeCourse tmp = new DegreeCourse(name, (Faculty) getById(faculties, f_id));
            tmp.setId(Integer.toUnsignedLong(i+1));
            degreeCourses.add(tmp);
        }
    }

    private void initProf() {
        //ID(PROGRESSIVO),NOME,COGNOME,ID FACOLTA'
        String[][] data = new String[][]{
            {"Albert", "Einstein", "1"},
            {"Thomas", "Edison", "1"},
            {"George", "Boole", "1"},
            {"John", "Nash", "2"},};
        for (int i = 0; i < data.length; i++) {
            String name = data[i][0], 
                    surname = data[i][1];
            
            String email = name.toLowerCase() + "."
                    + surname.toLowerCase() + "@unipv.it";
            
            long f_id = Long.parseLong(data[i][2]);
            
            Professor tmp = new Professor(email, name, surname,
                    (Faculty) getById(faculties, f_id));
            tmp.setId(Integer.toUnsignedLong(i+1));
            professors.add(tmp);
        }
    }

    private void initStudents() {
        //ID(PROGRESSIVO),NOME,COGNOME,ID FACOLTA'
        String[][] data = new String[][]{
            {"Alessandro", "Del Piero", "412345", "1"},
            {"Francesca", "Totti", "416754", "1"},
            {"Filippo", "Inzaghi", "456789", "1"},
            {"Gianluca", "Vialli", "422390", "1"},
            {"Bobo", "Vieri", "516754", "1"},
            {"Dino", "Zoff", "483589", "1"},};
        for (int i = 0; i < data.length; i++) {
            String name = data[i][0], 
                    surname = data[i][1],
                    mat = data[i][2];
            String email = name.toLowerCase().replace(" ", "") + "."
                    + surname.toLowerCase().replace(" ", "") + "01@universitadipavia.it";
            long dc_id = Long.parseLong(data[i][3]);
            Student tmp = new Student(email, name, surname, mat,
                        (DegreeCourse)getById(degreeCourses, dc_id));
            tmp.setPassword("password");
            tmp.setId(Integer.toUnsignedLong(i+5));
            students.add(tmp);
            
        }
    }

    private void initCourse() {
        //ID(Progressivo),Nome , cfu, id corso di laurea, id professore
        String[][] data = new String[][]{
            {"Analisi I","9","1","1"},
            {"Analisi II","9","1","3"},
            {"Fisica I","9","1","1"},
            {"Fisica II","9","1","2"},
            {"Algebra e geometria","6","1","1"},
            {"Economia","6","1","4"},
            {"Campi e Circuiti I","9","1","2"},
            {"Campi e Circuiti II","9","1","2"},
            {"Fondamenti di informatica","12","1","3"}
        };
        for(int i=0; i<data.length;i++){
            String name = data[i][0];
            long id_cdl = Long.parseLong(data[i][2]),
                    id_prof = Long.parseLong(data[i][2]);
            int cfu = Integer.parseInt(data[i][1]);
            Course tmp = new Course(name, cfu, 
                    (Professor)getById(professors, id_prof),
                    (DegreeCourse)getById(degreeCourses, id_cdl));
            tmp.setId(Integer.toUnsignedLong(i+1));
            courses.add(tmp);
         }
    }

    private void initExams() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //iscrizioni aperte?, data [yyyy-MM-dd HH:mm:ss], Descrizione, aula, id_corso
        String[][] data = new String[][]{
            {"NO","2017-01-19 09:00:00","Prova scritta","EF4","1"},            
            {"","2017-02-20 09:00:00","Prova scritta","EF2","1"},
        };
        for(int i=0;i<data.length;i++){
            Calendar cal = Calendar.getInstance();
            try {
                cal.setTime(sdf.parse(data[i][1]));
            } catch (ParseException ex) {
                Logger.getLogger(TestDataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
            String descrizione = data[i][2],
                    aula = data[i][3];
            long id_course = Long.parseLong(data[i][4]);
            Exam tmp = new Exam((Course)getById(courses, id_course), cal, aula, descrizione);
            tmp.setId(Integer.toUnsignedLong(i+1));
            if(data[i][0].equals("NO")) tmp.closeBookings();
            exams.add(tmp);
        }
        
    }

    private void initExamResults() {
        //id(progr), VOTO, STATUS(enum), id exam, id student
        String[][] data = new String[][]{
            {"18","PASSED_PENDING","1","5"},
            {"27","PASSED_PENDING","1","6"},
            {"15","FAILED_PENDING","1","7"},
            {"21","PASSED_PENDING","1","8"},
            {"30","PASSED_PENDING","1","9"},
            {"28","PASSED_PENDING","1","10"},
            {"0","BOOKED","2","11"},
            {"0","BOOKED","2","12"},
            {"0","BOOKED","2","13"},
            {"0","BOOKED","2","14"},
            {"0","BOOKED","2","15"}          
        };
        for(int i=0;i<data.length;i++){            
            Student student = (Student)getById(students, Long.parseLong(data[i][3]));
            Exam exam = (Exam)getById(exams, Long.parseLong(data[i][2]));
            Integer grade =Integer.parseInt(data[i][0]);
            ExamResult tmp = new ExamResult(student, exam);
            tmp.setGrade(grade==0?null:grade);
            tmp.setId(Integer.toUnsignedLong(i+1));
            examResults.add(tmp);
        }

    }

    private BaseEntity getById(List all, long id) {
        for (Object be : all) {
            if (((BaseEntity) be).getId().equals(id)) {
                return (BaseEntity) be;
            }
        }
        return null;
    }

    private void initEnrolling() {
        int i=1;
        for(Student s:students){
            Course c = (Course)getById(courses, 1);
            Enrollment tmp = new Enrollment(s, c);
            tmp.setId(Integer.toUnsignedLong(i++));
            enrolling.add(tmp);
        }
    }

}
