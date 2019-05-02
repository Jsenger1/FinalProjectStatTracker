package css.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlayerDetailActivity extends AppCompatActivity {
    Button buttonReturn;
    EditText editTextBats;
    EditText editTextHits;
    EditText editTextAvg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);

        Bundle bundle = getIntent().getExtras();
        Batter batter = (Batter) bundle.getSerializable("Batter");

        editTextBats = (EditText) findViewById(R.id.editTextBats);
        editTextHits = (EditText) findViewById(R.id.editTextHits);
        editTextAvg = (EditText) findViewById(R.id.editTextAvg);

        editTextBats.setText(batter.getAtBats());
        editTextHits.setText(batter.getHits());
        // Convert the double into a string
        Double avg = batter.calcAvg();
        String avgString = Double.toString(avg);
        editTextAvg.setText(avgString);


        // set up button
        buttonReturn = (Button) findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mainActIntent = new Intent(v.getContext(), MainActivity.class);
                finish();
                startActivity(mainActIntent);
            }
        });




    }
}
