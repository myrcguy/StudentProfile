import java.util.*;
public class Projects {
    private Vector<String> studentProjectsVector  = new Vector<String>(5);
    private Vector<String> studentResearchVector = new Vector<String>(5);
    private String[] researchParts;
    private String[] projectParts;
    private String stringResearch;
    private String stringProjects;
    public Projects(Vector<String> studentProjects,Vector<String> studentResearch){
        //Need to splt research into date/type format using split, into an array
        for(int i = 0; i < studentResearch.size(); i++){
            stringResearch = studentResearch.get(i);
            researchParts = stringResearch.split(":");
            studentResearchVector.add(researchParts[1]);
            studentResearchVector.add(researchParts[0]);
        }
        for(int i = 0; i < studentProjects.size(); i++){
            stringProjects = studentProjects.get(i);
            projectParts = stringProjects.split(":");
            studentProjectsVector.add(projectParts[1]);
            studentProjectsVector.add(projectParts[0]);
        }
    }



    public Vector<String> getStudentProjectsVector(){
        return studentProjectsVector;
    }
    public Vector<String> getStudentResearchVector(){
        return studentResearchVector;
    }
}
