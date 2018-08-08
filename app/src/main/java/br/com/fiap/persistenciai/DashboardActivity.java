package br.com.fiap.persistenciai;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        sp = getSharedPreferences("login", MODE_PRIVATE);
    }

    public void Logout(View view) {
        SharedPreferences.Editor e = sp.edit();
        e.remove("usuario");
        e.remove("senha");
        e.remove("conectado");
        e.commit();
        finish();
    }
}
