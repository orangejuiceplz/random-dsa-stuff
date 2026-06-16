package triage;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * this probabl works
 */
public class TriageSystem_2_KShiven {

    PriorityQueue<Patient> queue;
    ArrayList<MedicalProfessional> pro;
    public TriageSystem_2_KShiven() {

        pro = new ArrayList<>();
        queue = new PriorityQueue<>(new Patient.PatientSorter());

    }

    public void add_patient(String name, int priority) {
        Patient patient = new Patient(name, priority);
        queue.add(patient);
        MedicalProfessional professional = null;
        for (MedicalProfessional p: pro) {
            if (p.isAvailable()) {
                professional = p;
                break;
            }
        }

        if (professional == null) {
            System.out.println("There are no available professors to assign " + patient.getName() + " a doc");
            return;
        }


        if (queue.isEmpty()) {
            System.out.println("There is nobody in the queue to assign " + professional.getName() + " a patient.");
            return;
        }

            Patient pa = queue.poll();
            professional.setPatient(pa);


    }
    public void add_medical_professional(String name) {
        MedicalProfessional professional = new MedicalProfessional(name);
        pro.add(professional);

        if (queue.isEmpty()) {
            System.out.println("There is nobody in the queue.");
            return;
        }
        Patient patient = queue.poll();
        if (patient != null) {
            professional.setPatient(patient);
        }
    }
    public void update_patient_status(String profName, int status) {
        MedicalProfessional prof = null;
        for (MedicalProfessional p: pro) {
            if (p.getName().equals(profName))
                prof = p;
        }
        if (prof == null) {
            System.out.println("No professor is given with a name");
            return;
        }
        Patient patient = prof.getPatient();
        patient.setPriority(status);
        if (status == -1) {
            queue.remove(patient);
            patient = null;
        }
        if (status < -1) {
            System.out.println("Are you OK?");
        }
        if (prof.getPatient() == null) {
            if (!queue.isEmpty())
                prof.setPatient(queue.poll());
            else
                System.out.println("No waiting patients");
        }
    }
    public void print_status() {

        System.out.println("Current Medical Professionals: ");
        for (MedicalProfessional prof : pro) {
                System.out.println(prof + "\n");
        }
        print_pq(queue);
    }


    public static void print_pq(PriorityQueue<?> pq) {
        PriorityQueue<?> copy = new PriorityQueue<>(pq); while(!copy.isEmpty()) {
            System.out.println(copy.poll()); }
    }

}
