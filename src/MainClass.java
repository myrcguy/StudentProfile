import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.FileInputStream;

class MainClass {


    public static void main(String[] args) throws IOException {
        Scanner fileIn = null;
        try{
            fileIn = new Scanner(new FileInputStream("Input.txt")); //Reading file named input.txt
        }
        catch(FileNotFoundException e)
        {
            System.out.print("File Not Fond."); //Exits if "input.txt" NOT found
            System.exit(0);

        }
        String studentAmount; //First integer of file reads total number of students


        int studentNum = 1; //Counts the student number, used for output file
        studentAmount = fileIn.nextLine();
        for(int i =0; i < Integer.parseInt(studentAmount); i++){ //Loops amount of times there are students, reads students one section at a time
            String studentID; //name of student and phone number all in a string
            String studentUni; //University of student

            String recordAmount; //Amount of academic records
            String projectAmount1; //Amount of projects
            String researchAmount; //Amount of research
            String certificateAmount; //Amount of certificates for student
            String skipLine; //SkipLine used to skip the blank space between students

            Vector<String> studentAcademicRecords = new Vector<String>(5); //Hold academic records in dynamic array
            Vector<String> studentResearch = new Vector<String>(5); //Hold student research history
            Vector<String> studentProjects = new Vector<String>(5); //Hold Student Projects
            Vector<String> studentCertificates = new Vector<String>(5); //Hold student Certificates

            //Scanning in first two lines of student which are always the same
            studentID = fileIn.nextLine();
            studentUni = fileIn.nextLine();

            /* My method for taking in student data is to read how many lines (how many of each type)
            ex. (projects,research) and loop that amount of times to scan in and add to vector
             */

            recordAmount = fileIn.nextLine();
            if(Integer.parseInt(recordAmount ) > 0) {
                for (int x = 0; x < Integer.parseInt(recordAmount); x++) {
                    studentAcademicRecords.add(fileIn.nextLine());
                }
            }

            researchAmount = fileIn.nextLine();
            if(Integer.parseInt(researchAmount) > 0) {
                for(int p = 0; p < Integer.parseInt(researchAmount); p++) {
                    studentResearch.add(fileIn.nextLine());
                }
            }

            projectAmount1 = fileIn.nextLine();
            if(Integer.parseInt(projectAmount1) > 0) {
                for (int j = 0; j < Integer.parseInt(projectAmount1); j++) {
                    studentProjects.add(fileIn.nextLine());
                }
            }



            certificateAmount = fileIn.nextLine();
            if(Integer.parseInt(certificateAmount) > 0){
                for(int y = 0; y < Integer.parseInt(certificateAmount); y++){
                    studentCertificates.add(fileIn.nextLine());
                }
            }

            //Create Student object and construct using ID,UNI and the vectors holding the information about student
            Student studentProfile = new Student(studentID,studentUni,studentAcademicRecords,studentResearch, studentProjects, studentCertificates,studentNum);


            //Checking to see if we reached EOF, if there is no next line exit loop
            if(fileIn.hasNextLine() == false){
                break;
            }
            //If there is a next line, it will be blank as following pattern of students written in txt file
            skipLine = fileIn.nextLine();
            studentNum++; //Iteration for amount of students
        }
    }
}
