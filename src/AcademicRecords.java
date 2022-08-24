import java.util.*;
public class AcademicRecords {
    private Vector<String> academicRecordVector;
    private Vector<Double> gpaVector = new Vector<Double>(5); //Creating a vector to hold students class's gpa
    private double cumulatativeGpa = 0; //Students total gpa
    private double Total = 0;
    public AcademicRecords(Vector<String> studentAcademicRecords){
        academicRecordVector = studentAcademicRecords;
        /*Using the academicResearchvector, which is in string format so class and double gpa value are together,
        the method  used below seperates he gpa double from the class name and calculates the total gpa */
        for(int i = 0; i < academicRecordVector.size(); i++){
            String stringFromVector = academicRecordVector.get(i);
            Scanner gpaString = new Scanner(stringFromVector);
            double gpa = 0.0;
            String className;
            while(gpaString.hasNext()){
                if(gpaString.hasNextDouble()) {
                    gpa = gpaString.nextDouble();
                    break;
                }
                else{
                    className = gpaString.next();
                }
            }
            gpaVector.add(gpa);

        }

        for(int i = 0; i <gpaVector.size(); i++){
            Total += gpaVector.get(i);
        }
        cumulatativeGpa = Total/gpaVector.size();
    }

    public double getGPA(){
        return cumulatativeGpa;
    }

    public Vector<String> getAcademicVector(){
        return academicRecordVector;
    }

}
