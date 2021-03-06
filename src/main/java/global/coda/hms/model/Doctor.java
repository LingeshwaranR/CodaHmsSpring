package global.coda.hms.model;

import java.util.List;

/**
 * The type Doctor.
 */
public class Doctor extends User {

    /**
     * Gets specialization.
     *
     * @return the specialization
     */
    public String getSpecialist() {
        return specialist;
    }

    /**
     * Sets specialization.
     *
     * @param specialist the specialization
     */
    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    /**
     * The Specialization.
     */

    /**
     * Gets patient list.
     *
     * @return the patient list
     */
    public List<Patient> getPatientList() {
        return patientList;
    }

    /**
     * Sets patient list.
     *
     * @param patientList the patient list
     */
    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    /**
     * The Patient list.
     */
    String specialist;
    List<Patient> patientList;

}
