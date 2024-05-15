package com.example.healthkeeper.ApptCustomSpinner;

import com.example.healthkeeper.R;

import java.util.ArrayList;
import java.util.List;

public class SpecialistData_A188203 {

    public static List<Specialist_A188203> getSpecList() {
        List<Specialist_A188203> specialistA188203List = new ArrayList<>();

        Specialist_A188203 Spec = new Specialist_A188203();
        Spec.setName("Choose Specialist");
        Spec.setType("");
        Spec.setHosp("");
        Spec.setImage(R.drawable.person);
        specialistA188203List.add(Spec);

        Specialist_A188203 Spec1 = new Specialist_A188203();
        Spec1.setName("Dr. Michael Ang");
        Spec1.setType("Surgeon");
        Spec1.setHosp("Hospital Aman");
        Spec1.setImage(R.drawable.doctor3);
        specialistA188203List.add(Spec1);

        Specialist_A188203 Spec2 = new Specialist_A188203();
        Spec2.setName("Dr. Leanne John");
        Spec2.setType("OBGYn");
        Spec2.setHosp("Hospital Tuah");
        Spec2.setImage(R.drawable.doctor2);
        specialistA188203List.add(Spec2);

        Specialist_A188203 Spec3 = new Specialist_A188203();
        Spec3.setName("Dr. Kumar Raja");
        Spec3.setType("Pharmacist");
        Spec3.setHosp("Hospital Putra");
        Spec3.setImage(R.drawable.doctor4);
        specialistA188203List.add(Spec3);

        Specialist_A188203 Spec4 = new Specialist_A188203();
        Spec4.setName("Dr. Ying Lan");
        Spec4.setType("Veterinar");
        Spec4.setHosp("Hospital Aman");
        Spec4.setImage(R.drawable.doctor5);
        specialistA188203List.add(Spec4);

        Specialist_A188203 Spec5 = new Specialist_A188203();
        Spec5.setName("Dr. Suzanna Ramli");
        Spec5.setType("Dermatologist");
        Spec5.setHosp("Hospital Tuah");
        Spec5.setImage(R.drawable.doctor1);
        specialistA188203List.add(Spec5);

        Specialist_A188203 Spec6 = new Specialist_A188203();
        Spec6.setName("Dr. Ammar Zairi");
        Spec6.setType("Dentist");
        Spec6.setHosp("Hospital Putra");
        Spec6.setImage(R.drawable.doctor6);
        specialistA188203List.add(Spec6);

        return specialistA188203List;
    }
}
