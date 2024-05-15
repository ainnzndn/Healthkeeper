package com.example.healthkeeper.ApptCustomSpinner;

import com.example.healthkeeper.R;

import java.util.ArrayList;
import java.util.List;

public class HospitalData_A188203 {
    public static List<Hospital_A188203> getHospitalList() {

        List<Hospital_A188203> hospitalA188203List = new ArrayList<>();

        Hospital_A188203 Hosp = new Hospital_A188203();
        Hosp.setName("Choose Hospital");
        Hosp.setAddress("");
        Hosp.setImage(R.drawable.location);
        hospitalA188203List.add(Hosp);

        Hospital_A188203 Hosp1 = new Hospital_A188203();
        Hosp1.setName("Hospital Aman");
        Hosp1.setAddress("Seksyen 16, Bandar Baru Bangi, 43650, Selangor.");
        Hosp1.setImage(R.drawable.hosp1);
        hospitalA188203List.add(Hosp1);

        Hospital_A188203 Hosp2 = new Hospital_A188203();
        Hosp2.setName("Hospital Tuah");
        Hosp2.setAddress("Jalan Semenyih, Bandar Kajang, 43000, Selangor.");
        Hosp2.setImage(R.drawable.hosp2);
        hospitalA188203List.add(Hosp2);

        Hospital_A188203 Hosp3 = new Hospital_A188203();
        Hosp3.setName("Hospital Putra");
        Hosp3.setAddress("Bukit Serdang, Seri Serdang, 43300, Selangor.");
        Hosp3.setImage(R.drawable.hosp3);
        hospitalA188203List.add(Hosp3);

        return hospitalA188203List;
    }
}
