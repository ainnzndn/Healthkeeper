package com.example.healthkeeper.ApptCustomSpinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthkeeper.ApptCustomSpinner.Hospital_A188203;
import com.example.healthkeeper.R;

import java.util.List;

public class HospAdapterAppt_A188203 extends BaseAdapter {

    private Context context;
    private List<Hospital_A188203> hospitalA188203List;

    public HospAdapterAppt_A188203(Context context, List<Hospital_A188203> hospitalList) {
        this.context = context;
        this.hospitalA188203List = hospitalList;
    }

    @Override
    public int getCount() {
        return hospitalA188203List != null ? hospitalA188203List.size(): 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_hospital, viewGroup, false);

        TextView txtName =rootView.findViewById(R.id.name1);
        TextView txtAddress = rootView.findViewById(R.id.address1);
        ImageView imgView = rootView.findViewById(R.id.image1);

        txtName.setText(hospitalA188203List.get(i).getName());
        txtAddress.setText(hospitalA188203List.get(i).getAddress());
        imgView.setImageResource(hospitalA188203List.get(i).getImage());

        return rootView;
    }
}
