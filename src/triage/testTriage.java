package triage;

public class testTriage {

    public static void main(String[] args) {
        TriageSystem_2_KShiven triage = new TriageSystem_2_KShiven();

        triage.add_patient("Mason", Integer.MAX_VALUE);
        triage.add_medical_professional("shiven");
        triage.print_status();
        System.out.println("---------------------");

        triage.add_medical_professional("Alan Turing");
        triage.print_status();
    }

}
