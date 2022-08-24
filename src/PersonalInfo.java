import java.util.*;
public class PersonalInfo {
    private String studentIdentity;
    private String studentName;
    private String studentPhone;
    private String studentUniversity;
    private String[] IDParts;
    public PersonalInfo(String studentID,String studentUni){
        /*Taking in data from constructor, splitting the Name from the phone number using .split method and
        storing into a vector, which is added to another vector to be returned */
        studentIdentity = studentID;
        IDParts = studentIdentity.split(",");
        studentName = IDParts[0];
        studentPhone = IDParts[1];

        studentUniversity = studentUni;

    }

    public String getStudentName(){
        return studentName;
    }
    public String getStudentPhone(){
        return studentPhone;
    }

    public String getStudentUni(){
        return studentUniversity;
    }

}