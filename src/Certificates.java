import java.util.*;
public class Certificates {
    private Vector<String> studentCertificatesVector = new Vector<String>(5);
    private String[] certificateParts;
    private String stringCertificates;
    public Certificates(Vector<String> studentCertificates){
        //Again splitting the data from the certificate using this method below
        for(int i = 0; i < studentCertificates.size(); i++){
            stringCertificates = studentCertificates.get(i);
            certificateParts = stringCertificates.split(":");
            studentCertificatesVector.add(certificateParts[1]);
            studentCertificatesVector.add(certificateParts[0]);
        }
    }

    public Vector<String> getStudentCertificatesVector(){
        return studentCertificatesVector;
    }

}
