package com.darkness.Naree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class LawsActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(LawsActivity.this,MainActivity.class));
        LawsActivity.this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laws);
        RecyclerView recyclerView = findViewById(R.id.recycleLaws);
        String[] laws = new String[]{"Child Marriage Restraint Act, 2028 (1972)","Muluki Civil Code, 2074 (2017)","Social Customs and Practices Act, 2033 (1976)"," Muluki Civil Code, 2074 (2017)","Labor Act, 2074 (2017)","National Safe Abortion Service Guidelines, 2060 (2002)","Sexual Harassment at Workplace Prevention Act, 2071 (2014)","Electronic Transactions Act, 2063 (2008) & Muluki Criminal Code, 2074 (2017)","National Women Commission Act, 2063 (2006)","Labor Act, 2074 (2017)"};

        MyAdapter adapter = new MyAdapter(this, laws, position -> {
            Intent intent = new Intent(LawsActivity.this,LawDisplayerActivity.class);
            intent.putExtra("position",position);
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        findViewById(R.id.backBtn).setOnClickListener(view -> {
            startActivity(new Intent(LawsActivity.this,MainActivity.class));
            LawsActivity.this.finish();
        });
    }
}