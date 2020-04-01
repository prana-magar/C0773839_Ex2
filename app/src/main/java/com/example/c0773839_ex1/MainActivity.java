package com.example.c0773839_ex1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProviderClient;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText email;
    EditText password;
    Button btnLogin;
    TextView textViewMsg;
    AlertDialog.Builder builder ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.buttonLogin);
        textViewMsg = findViewById(R.id.textViewMsg);
        builder = new AlertDialog.Builder(this);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validate(email.getText().toString(), password.getText().toString())){
                    textViewMsg.setText(getResources().getString(R.string.success_login));
                    textViewMsg.setTextColor(getResources().getColor(R.color.colorSuccess));
//                    Intent newIntent = new Intent(MainActivity.this, Main2Activity.class);
////                    startActivity(newIntent);
                }
                else{
                    textViewMsg.setText(getResources().getString(R.string.failure_login));
                    textViewMsg.setTextColor(getResources().getColor(R.color.colorFailure));
                    showAlert();
                }

            }
        });
    }

    protected void showAlert(){
        builder.setTitle("Aleeert");
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"cancelling",Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }


    protected Boolean validate(String email, String password){
        if(email.equals("admin@123")){
            if(password.equals("s3cr3t")){
                return true;
            }
        }
        return false;
    }
}
