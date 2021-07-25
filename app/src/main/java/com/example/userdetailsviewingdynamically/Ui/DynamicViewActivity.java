package com.example.userdetailsviewingdynamically.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.userdetailsviewingdynamically.Adapters.RecyclerViewAdapter;
import com.example.userdetailsviewingdynamically.Model.Address;
import com.example.userdetailsviewingdynamically.Model.Company;
import com.example.userdetailsviewingdynamically.Model.Geo;
import com.example.userdetailsviewingdynamically.Model.MainModel;
import com.example.userdetailsviewingdynamically.Network.RetrofitInstance;
import com.example.userdetailsviewingdynamically.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DynamicViewActivity extends AppCompatActivity {

    Button addButton;
    LinearLayout linearLayout;

    public static List<MainModel> list=new ArrayList<>();
    RecyclerViewAdapter adapter1;
    int listSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_view);

        RetrofitInstance.getDataFromApi();
        addButton=findViewById(R.id.add_button_id);
        linearLayout=findViewById(R.id.linear_layout_container_id);

        listSize=list.size();
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNew();
            }
        });
    }


    public void addNew(){
        for(int i=0;i<listSize;i++) {
            View view = getLayoutInflater().inflate(R.layout.item_design_for_recyclerview_in_first_activity, null, false);
            TextView name = view.findViewById(R.id.name_id_in_card);
            TextView username = view.findViewById(R.id.username_id_in_card);
            TextView email = view.findViewById(R.id.email_id_in_card);
            TextView phone = view.findViewById(R.id.phone_id_in_card);
            TextView address = view.findViewById(R.id.address_id_in_card);
            TextView company = view.findViewById(R.id.company_id_in_card);

            name.setText(list.get(i).getName());
            username.setText(list.get(i).getUsername());
            email.setText(list.get(i).getEmail());
            phone.setText(list.get(i).getPhone());
            address.setText(list.get(i).getAddress().getCity());
            company.setText(list.get(i).getCompany().getName());
            linearLayout.addView(view);

        }

    }
}