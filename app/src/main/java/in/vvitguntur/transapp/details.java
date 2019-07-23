package in.vvitguntur.transapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class details extends AppCompatActivity {


    private TextInputEditText userNameId;
    private TextInputEditText userAadharId;
    private TextInputEditText userGmailId;
    private TextInputEditText userAddressId;
    private TextInputEditText userMobileId;
    private TextInputEditText userDob;
    private TextInputEditText userDriving;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        SharedPreferences sharedPreferences = getSharedPreferences("email",MODE_PRIVATE);
        uid = sharedPreferences.getString("uid" , "Username Not avaliable");
        Log.d("ursccc" , uid);
        userNameId = (TextInputEditText) findViewById(R.id.user_name_id);
        userAadharId = (TextInputEditText) findViewById(R.id.user_aadhar_id);
        userGmailId = (TextInputEditText) findViewById(R.id.user_gmail_id);
        userAddressId = (TextInputEditText) findViewById(R.id.user_address_id);
        userMobileId = (TextInputEditText) findViewById(R.id.user_mobile_id);
        userDob = (TextInputEditText) findViewById(R.id.user_dob);
        userDriving = (TextInputEditText) findViewById(R.id.user_driving);



    }

    public void submit(View view) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(uid);
        databaseReference.child("Name").setValue(userNameId.getText().toString());
        databaseReference.child("Email").setValue(userGmailId.getText().toString());
        databaseReference.child("Aadhar").setValue(userAadharId.getText().toString());
        databaseReference.child("Address").setValue(userAddressId.getText().toString());
        databaseReference.child("Mobile").setValue(userMobileId.getText().toString());
        databaseReference.child("Dob").setValue(userDob.getText().toString());
        databaseReference.child("Driving").setValue(userDriving.getText().toString());

    }
}
