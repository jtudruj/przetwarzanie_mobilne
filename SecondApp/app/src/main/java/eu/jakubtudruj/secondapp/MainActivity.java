package eu.jakubtudruj.secondapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginButtonClicked(View view) {
        Intent intent = new Intent(this, FormActivity.class);

        EditText loginEditText = (EditText) findViewById(R.id.loginEditText);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        String login = loginEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (login.equals("secret") && password.equals("passwd")) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Invalid login or password", Toast.LENGTH_SHORT).show();
        }

//        startActivity(intent);
    }
}
