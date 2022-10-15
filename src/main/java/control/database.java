package control;

public class database {

    String patient_name,patient_addr,diseases,status;

    public database(String s, String s1, String s2, String s3) {
        this.patient_name = patient_name;
        this.patient_addr = patient_addr;
        this.diseases = diseases;
        this.status = status;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_addr() {
        return patient_addr;
    }

    public void setPatient_addr(String patient_addr) {
        this.patient_addr = patient_addr;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}