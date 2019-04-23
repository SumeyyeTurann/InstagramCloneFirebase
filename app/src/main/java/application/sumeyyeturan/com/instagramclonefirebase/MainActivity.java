 package application.sumeyyeturan.com.instagramclonefirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

 public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText emailText;
    EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        emailText = findViewById(R.id.editTextEmail);
        passwordText = findViewById(R.id.editTextSifre);
    }
    public void SignIn(View view){
        
    }
    //kayıt işlemi başarılı olursa ne olacak ve başarısız olursa ne olacak
    public void SignUp(View view){
        mAuth.createUserWithEmailAndPassword(emailText.getText().toString(),passwordText.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() { //başarılı olursa
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Kullanuıcı Kayıt Edildi!", Toast.LENGTH_SHORT).show();

                            //Kullanıcı kayıt olunca Ana Sayfaya aktarıyor
                            Intent intent = new Intent(getApplicationContext(),AnaSayfaActivity.class);
                            startActivity(intent);
                        }

                    }
                }).addOnFailureListener(this, new OnFailureListener() { //başarısız olursa
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this,e.getLocalizedMessage(),Toast.LENGTH_SHORT).show(); //bana hata mesajını kısa bir şekilde göster

            }
        });
    }
}
