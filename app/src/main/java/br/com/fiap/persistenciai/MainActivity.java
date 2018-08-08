package br.com.fiap.persistenciai;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUser;
    EditText edtPass;
    CheckBox chkManterConectado;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        chkManterConectado = findViewById(R.id.chkManterConectado);

        sp = getSharedPreferences("login", MODE_PRIVATE);

        boolean conectado = sp.getBoolean("conectado", false);
        if (conectado){
            abrirDashboard();
        }
    }

    public void Login(View view) {

        String user = edtUser.getText().toString();
        String pass = edtPass.getText().toString();
        if (user.equals("fiap") && pass.equals("fiap")){

            if (chkManterConectado.isChecked()){
                SharedPreferences.Editor e = sp.edit();
                e.putString("usuario", user);
                e.putString("senha", pass);
                e.putBoolean("conectado", true);
                e.commit();
            }

            abrirDashboard();
        }else {
            Toast.makeText(this, R.string.logininvelido, Toast.LENGTH_SHORT).show();
        }


    }

    private void abrirDashboard(){
        Intent it = new Intent(this, DashboardActivity.class);
        startActivity(it);
    }
}
