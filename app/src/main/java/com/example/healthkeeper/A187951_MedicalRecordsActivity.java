package com.example.healthkeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class A187951_MedicalRecordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_records_a187951);

        FirebaseApp.initializeApp(A187951_MedicalRecordsActivity.this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        FloatingActionButton add = findViewById(R.id.add_medicine);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1 = LayoutInflater.from(A187951_MedicalRecordsActivity.this).inflate(R.layout.add_medical_records_dialog, null);

                TextInputLayout med_name, med_type, med_doses, med_uses, med_quantity, med_warning, med_expired;
                med_name = view1.findViewById(R.id.med_name);
                med_type = view1.findViewById(R.id.med_type);
                med_doses = view1.findViewById(R.id.med_doses);
                med_uses = view1.findViewById(R.id.med_uses);
                med_quantity = view1.findViewById(R.id.med_quantity);
                med_warning = view1.findViewById(R.id.med_warning);
                med_expired = view1.findViewById(R.id.med_expired);

                TextInputEditText etMedName, etMedType, etMedDoses, etMedUses, etMedQuantity, etMedWarning, etMedExpired ;
                etMedName = view1.findViewById(R.id.et_medicine_name);
                etMedType = view1.findViewById(R.id.et_medicine_type);
                etMedDoses = view1.findViewById(R.id.et_medicine_doses);
                etMedUses = view1.findViewById(R.id.et_medicine_uses);
                etMedQuantity = view1.findViewById(R.id.et_medicine_quantity);
                etMedWarning = view1.findViewById(R.id.et_medicine_warning);
                etMedExpired = view1.findViewById(R.id.et_medicine_expired);

                AlertDialog alertDialog = new AlertDialog.Builder(A187951_MedicalRecordsActivity.this)
                        .setTitle("Add")
                        .setView(view1)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (Objects.requireNonNull(etMedName.getText()).toString().isEmpty()) {
                                    med_name.setError("This field is required!");
                                } else if (Objects.requireNonNull(etMedType.getText()).toString().isEmpty()) {
                                    med_type.setError("This field is required!");
                                } else if (Objects.requireNonNull(etMedDoses.getText()).toString().isEmpty()) {
                                    med_doses.setError("This field is required!");
                                } else if (Objects.requireNonNull(etMedUses.getText()).toString().isEmpty()) {
                                    med_uses.setError("This field is required!");
                                } else if (Objects.requireNonNull(etMedQuantity.getText()).toString().isEmpty()) {
                                    med_quantity.setError("This field is required!");
                                } else if (Objects.requireNonNull(etMedWarning.getText()).toString().isEmpty()) {
                                    med_warning.setError("This field is required!");
                                } else if (Objects.requireNonNull(etMedExpired.getText()).toString().isEmpty()) {
                                    med_expired.setError("This field is required!");
                                } else {
                                    ProgressDialog dialog = new ProgressDialog(A187951_MedicalRecordsActivity.this);
                                    dialog.setMessage("Storing in Database...");
                                    dialog.show();
                                    A187951_MedicalRecords medicalRecords_a187951 = new A187951_MedicalRecords();
                                    medicalRecords_a187951.setMedicineName(etMedName.getText().toString());
                                    medicalRecords_a187951.setMedicineType(etMedType.getText().toString());
                                    medicalRecords_a187951.setMedicineDoses(etMedDoses.getText().toString());
                                    medicalRecords_a187951.setMedicineUses(etMedUses.getText().toString());
                                    medicalRecords_a187951.setMedicineQuantity(etMedQuantity.getText().toString());
                                    medicalRecords_a187951.setMedicineWarning(etMedWarning.getText().toString());
                                    medicalRecords_a187951.setMedicineExpired(etMedExpired.getText().toString());

                                    database.getReference().child("medical records").push().setValue(medicalRecords_a187951).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            dialog.dismiss();
                                            dialogInterface.dismiss();
                                            Toast.makeText(A187951_MedicalRecordsActivity.this, "Saved Successfully!", Toast.LENGTH_SHORT).show();
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            dialog.dismiss();
                                            Toast.makeText(A187951_MedicalRecordsActivity.this, "There was an error while saving data", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .create();
                alertDialog.show();
            }
        });

        TextView empty = findViewById(R.id.empty);

        RecyclerView recyclerView = findViewById(R.id.recycler);

        database.getReference().child("medical records").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<A187951_MedicalRecords> arrayList = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    A187951_MedicalRecords medicalRecords_a187951 = dataSnapshot.getValue(A187951_MedicalRecords.class);
                    Objects.requireNonNull(medicalRecords_a187951).setId(dataSnapshot.getKey());
                    arrayList.add(medicalRecords_a187951);
                }

                if (arrayList.isEmpty()) {
                    empty.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                } else {
                    empty.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                }

                A187951_MedicalRecordsAdapter adapter = new A187951_MedicalRecordsAdapter(A187951_MedicalRecordsActivity.this, arrayList);
                recyclerView.setAdapter(adapter);

                adapter.setOnItemClickListener(new A187951_MedicalRecordsAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(A187951_MedicalRecords medicalRecords_a187951) {

                        View view = LayoutInflater.from(A187951_MedicalRecordsActivity.this).inflate(R.layout.add_medical_records_dialog, null);
                        TextInputLayout med_name, med_type, med_doses, med_uses, med_quantity, med_warning, med_expired;
                        TextInputEditText etMedName, etMedType, etMedDoses, etMedUses, etMedQuantity, etMedWarning, etMedExpired ;

                        etMedName = view.findViewById(R.id.et_medicine_name);
                        etMedType = view.findViewById(R.id.et_medicine_type);
                        etMedDoses = view.findViewById(R.id.et_medicine_doses);
                        etMedUses = view.findViewById(R.id.et_medicine_uses);
                        etMedQuantity = view.findViewById(R.id.et_medicine_quantity);
                        etMedWarning = view.findViewById(R.id.et_medicine_warning);
                        etMedExpired = view.findViewById(R.id.et_medicine_expired);

                        med_name = view.findViewById(R.id.med_name);
                        med_type = view.findViewById(R.id.med_type);
                        med_doses = view.findViewById(R.id.med_doses);
                        med_uses = view.findViewById(R.id.med_uses);
                        med_quantity = view.findViewById(R.id.med_quantity);
                        med_warning = view.findViewById(R.id.med_warning);
                        med_expired = view.findViewById(R.id.med_expired);

                        etMedName.setText(medicalRecords_a187951.getMedicineName());
                        etMedType.setText(medicalRecords_a187951.getMedicineType());
                        etMedDoses.setText(medicalRecords_a187951.getMedicineDoses());
                        etMedUses.setText(medicalRecords_a187951.getMedicineUses());
                        etMedQuantity.setText(medicalRecords_a187951.getMedicineQuantity());
                        etMedWarning.setText(medicalRecords_a187951.getMedicineWarning());
                        etMedExpired.setText(medicalRecords_a187951.getMedicineExpired());

                        ProgressDialog progressDialog = new ProgressDialog(A187951_MedicalRecordsActivity.this);

                        AlertDialog alertDialog = new AlertDialog.Builder(A187951_MedicalRecordsActivity.this)
                                .setTitle("Edit")
                                .setView(view)
                                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        if (Objects.requireNonNull(etMedName.getText()).toString().isEmpty()) {
                                            med_name.setError("This field is required!");
                                        } else if (Objects.requireNonNull(etMedType.getText()).toString().isEmpty()) {
                                            med_type.setError("This field is required!");
                                        } else if (Objects.requireNonNull(etMedDoses.getText()).toString().isEmpty()) {
                                            med_doses.setError("This field is required!");
                                        } else if (Objects.requireNonNull(etMedUses.getText()).toString().isEmpty()) {
                                            med_uses.setError("This field is required!");
                                        } else if (Objects.requireNonNull(etMedQuantity.getText()).toString().isEmpty()) {
                                            med_quantity.setError("This field is required!");
                                        } else if (Objects.requireNonNull(etMedWarning.getText()).toString().isEmpty()) {
                                            med_warning.setError("This field is required!");
                                        } else if (Objects.requireNonNull(etMedExpired.getText()).toString().isEmpty()) {
                                            med_expired.setError("This field is required!");
                                        } else {
                                            progressDialog.setMessage("Saving...");
                                            progressDialog.show();
                                            A187951_MedicalRecords medicalRecords1_a187951 = new A187951_MedicalRecords();
                                            medicalRecords1_a187951.setMedicineName(etMedName.getText().toString());
                                            medicalRecords1_a187951.setMedicineType(etMedType.getText().toString());
                                            medicalRecords1_a187951.setMedicineDoses(etMedDoses.getText().toString());
                                            medicalRecords1_a187951.setMedicineUses(etMedUses.getText().toString());
                                            medicalRecords1_a187951.setMedicineQuantity(etMedQuantity.getText().toString());
                                            medicalRecords1_a187951.setMedicineWarning(etMedWarning.getText().toString());
                                            medicalRecords1_a187951.setMedicineExpired(etMedExpired.getText().toString());

                                            database.getReference().child("medical records").child(medicalRecords_a187951.getMedicineID()).setValue(medicalRecords1_a187951).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void unused) {
                                                    progressDialog.dismiss();
                                                    dialogInterface.dismiss();
                                                    Toast.makeText(A187951_MedicalRecordsActivity.this, "Saved Successfully!", Toast.LENGTH_SHORT).show();
                                                }
                                            }).addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    progressDialog.dismiss();
                                                    Toast.makeText(A187951_MedicalRecordsActivity.this, "There was an error while saving data", Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                        }
                                    }
                                })
                                .setNeutralButton("Close", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                })
                                .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        progressDialog.setTitle("Deleting...");
                                        progressDialog.show();
                                        database.getReference().child("medical records").child(medicalRecords_a187951.getMedicineID()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                progressDialog.dismiss();
                                                Toast.makeText(A187951_MedicalRecordsActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                progressDialog.dismiss();
                                            }
                                        });
                                    }
                                }).create();
                        alertDialog.show();
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
