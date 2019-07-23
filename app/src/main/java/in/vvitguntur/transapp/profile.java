package in.vvitguntur.transapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class profile extends AppCompatActivity {
    private TextView userNameId;
    private TextView userAadharId;
    private TextView userGmailId;
    private TextView userAddressId;
    private TextView userMobileId;
    private TextView userCompletedOrdersId;

    String TAG = "firebase reterive";
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        userNameId = (TextView) findViewById(R.id.user_name_id);
        userAadharId = (TextView) findViewById(R.id.user_aadhar_id);
        userGmailId = (TextView) findViewById(R.id.user_gmail_id);
        userAddressId = (TextView) findViewById(R.id.user_address_id);
        userMobileId = (TextView) findViewById(R.id.user_mobile_id);
        userCompletedOrdersId = (TextView) findViewById(R.id.user_completed_orders_id);
        SharedPreferences sharedPreferences = getSharedPreferences("email",MODE_PRIVATE);
        uid = sharedPreferences.getString("uid" , "Username Not avaliable");
        Log.d("ursccc" , uid);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(uid);
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);

                DataSnapshot detailssnap = dataSnapshot.child(uid);
                Iterable<DataSnapshot> detailschild = detailssnap.getChildren();
                ArrayList<String> data = new ArrayList<>();

                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

}
