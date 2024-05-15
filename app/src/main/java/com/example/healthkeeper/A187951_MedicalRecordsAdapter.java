package com.example.healthkeeper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class A187951_MedicalRecordsAdapter extends RecyclerView.Adapter<A187951_MedicalRecordsAdapter.ViewHolder> {
    Context context;
    ArrayList<A187951_MedicalRecords> medicalRecordsA187951ArrayList;
    OnItemClickListener onItemClickListener;

    public A187951_MedicalRecordsAdapter(Context context, ArrayList<A187951_MedicalRecords> arrayList) {
        this.context = context;
        this.medicalRecordsA187951ArrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.medical_records_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvMedName.setText(medicalRecordsA187951ArrayList.get(position).getMedicineName());
        holder.tvMedType.setText(medicalRecordsA187951ArrayList.get(position).getMedicineType());
        holder.tvMedDoses.setText(medicalRecordsA187951ArrayList.get(position).getMedicineDoses());
        holder.tvMedUses.setText(medicalRecordsA187951ArrayList.get(position).getMedicineUses());
        holder.tvMedQuantity.setText(medicalRecordsA187951ArrayList.get(position).getMedicineQuantity());
        holder.tvMedWarning.setText(medicalRecordsA187951ArrayList.get(position).getMedicineWarning());
        holder.tvMedExpired.setText(medicalRecordsA187951ArrayList.get(position).getMedicineExpired());
        holder.itemView.setOnClickListener(view -> onItemClickListener.onClick(medicalRecordsA187951ArrayList.get(position)));
    }

    @Override
    public int getItemCount() {
        return medicalRecordsA187951ArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMedName, tvMedType, tvMedDoses, tvMedUses, tvMedQuantity, tvMedWarning, tvMedExpired;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMedName = itemView.findViewById(R.id.item_name);
            tvMedType = itemView.findViewById(R.id.item_type);
            tvMedDoses = itemView.findViewById(R.id.item_doses);
            tvMedUses = itemView.findViewById(R.id.item_uses);
            tvMedQuantity = itemView.findViewById(R.id.item_quantity);
            tvMedWarning = itemView.findViewById(R.id.item_warning);
            tvMedExpired = itemView.findViewById(R.id.item_expired);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(A187951_MedicalRecords medicalRecords_a187951);
    }
}