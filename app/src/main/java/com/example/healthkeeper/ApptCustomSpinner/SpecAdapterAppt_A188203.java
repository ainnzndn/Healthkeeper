package com.example.healthkeeper.ApptCustomSpinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthkeeper.R;

import java.util.List;

public class SpecAdapterAppt_A188203 extends BaseAdapter {

    private Context context;
    private List<Specialist_A188203> specialistA188203List;

    public SpecAdapterAppt_A188203(Context context, List<Specialist_A188203> specialList) {
        this.context = context;
        this.specialistA188203List = specialList;
    }
    @Override
    public int getCount() { return specialistA188203List != null ? specialistA188203List.size(): 0;
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
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_specialist, viewGroup, false);

        TextView txtName =rootView.findViewById(R.id.name1);
        TextView txtType = rootView.findViewById(R.id.spec1);
        TextView tvHosp = rootView.findViewById(R.id.hosp1);
        ImageView imgView = rootView.findViewById(R.id.image1);

        txtName.setText(specialistA188203List.get(i).getName());
        txtType.setText(specialistA188203List.get(i).getType());
        tvHosp.setText(specialistA188203List.get(i).getHosp());
        imgView.setImageResource(specialistA188203List.get(i).getImage());

        return rootView;
    }
}
