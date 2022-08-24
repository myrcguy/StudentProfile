import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.text.DecimalFormat;

public class Student {
    private String studentIdentity;
    private String studentUniversity;
    //Constructor for object takes in the information
    public Student(String studentID, String studentUni, Vector<String> studentAcademicRecords, Vector<String> studentResearch, Vector<String> studentProjects, Vector<String> studentCertificates,int studentNum) throws IOException{
        //Creating objectes to hold data for each using Arrays;
        studentIdentity = studentID;
        studentUniversity = studentUni;

        //Creating the objects from each class and passing the vector that is associated with the class
        PersonalInfo studentInfo = new PersonalInfo(studentID,studentUni);
        AcademicRecords sAcademics = new AcademicRecords(studentAcademicRecords);
        Projects sProjects = new Projects(studentProjects,studentResearch);
        Certificates sCertificates = new Certificates(studentCertificates);


        //Using io.file, and filewriter to format and output the data from the vectors that are returned in each class
        File outputFile = new File("student_" + studentNum + ".txt");
        System.out.println("student_" + studentNum + ".txt" + " file created");
        outputFile.createNewFile();

        /*This constructor is called each time a new student is looped from in the
            MainClass.java file, the write function is written into the constructor
        */
        FileWriter outputFileWrite = new FileWriter(outputFile);
        outputFileWrite.write("Name:" + studentInfo.getStudentName() + "\n");
        outputFileWrite.write("Phone Number:" + studentInfo.getStudentPhone() + "\n");
        outputFileWrite.write("\nAcademic: \n");

        //Formatting gpa using format class, so that the gpa has 2 decimal places
        String pattern = "#.##";
        DecimalFormat gpaFormatted =  new DecimalFormat(pattern);
        String formattedGpa = gpaFormatted.format(sAcademics.getGPA());

        outputFileWrite.write(studentInfo.getStudentUni() + " GPA: " + formattedGpa + "\n");
        Vector<String> AcademicVector = sAcademics.getAcademicVector();
        for(int i = 0; i < (sAcademics.getAcademicVector()).size(); i++){
            outputFileWrite.write(AcademicVector.get(i) + ", " );
        }
        outputFileWrite.write("\n\nResearches:\n");
        for(int i = 0; i < (sProjects.getStudentResearchVector()).size(); i++){
            outputFileWrite.write(sProjects.getStudentResearchVector().get(i) + "\n");
        }
        outputFileWrite.write("\nProjects:\n");
        for(int i = 0; i < (sProjects.getStudentProjectsVector()).size(); i++){
            outputFileWrite.write(sProjects.getStudentProjectsVector().get(i) + "\n");
        }
        outputFileWrite.write("\nCertificates:\n");
        for(int i = 0; i < (sCertificates.getStudentCertificatesVector()).size(); i++){
            outputFileWrite.write(sCertificates.getStudentCertificatesVector().get(i) + "\n");
        }

        //Closing file and making sure that data is not received through output channel
        outputFileWrite.flush();
        outputFileWrite.close();


    }


}
