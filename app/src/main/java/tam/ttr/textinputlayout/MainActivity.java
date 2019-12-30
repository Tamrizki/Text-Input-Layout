package tam.ttr.textinputlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    // TODO 3 Deklarasi dan Inisialisasi
    private TextInputLayout til_username, til_password;
    private TextInputEditText tx_username, tx_password;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        til_username = findViewById(R.id.til_username);
        til_password = findViewById(R.id.til_password);

        tx_username = findViewById(R.id.et_username);
        tx_password = findViewById(R.id.et_password);

        btn = findViewById(R.id.btn_login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });
    }

    public void requestFocus(View view)
    {
        if (view.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
// TODO 4 Buat pengkondisian pada form
    private boolean validate_username()
    {
        if (tx_username.getText().toString().trim().isEmpty()){
            til_username.setError("Enter name");
            requestFocus(til_username);
            return false;
        }
        else if (tx_username.getText().toString().trim().length()<3){
            tx_username.setError("Minimum 3 characters");
            requestFocus(til_username);
            return false;
        }
        return true;
    }

    private boolean validate_password()
    {
        if (tx_password.getText().toString().trim().isEmpty()){
            til_password.setError("Enter name");
//            requestFocus(til_password);
            return false;
        }
        else if (tx_password.getText().toString().trim().length()<3){
            til_password.setError("Minimum 3 characters");
//            requestFocus(til_password);
            return false;
        }
        return true;
    }
// TODO 5 Memasukan validasi yang telah dibuat dan aksi klik button
    private void submit(){
        if (!validate_username()){
            return;
        }else if (!validate_password()){
          return;
        }
        Toast.makeText(this, "Login with username "+tx_username.getText().toString()+" and pass "+tx_password.getText().toString() , Toast.LENGTH_SHORT).show();
    }
}
