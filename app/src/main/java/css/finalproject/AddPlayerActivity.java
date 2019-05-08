package css.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPlayerActivity extends AppCompatActivity {
    Button buttonSave;
    EditText editTextName, editTextBats, editTextHits;
    PlayerFirebaseData playerDataSource;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);


        // link each editText variable to the xml layout
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextBats = (EditText) findViewById(R.id.editTextBats);
        editTextHits = (EditText) findViewById(R.id.editTextHits);

        playerDataSource = new PlayerFirebaseData();
        playerDataSource.open();

        // setup button
        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //add player
                String name = editTextName.getText().toString();
                String bats = editTextBats.getText().toString();
                String hits = editTextHits.getText().toString();
                playerDataSource.createPlayer(bats, hits, name);
                Intent mainActIntent = new Intent(v.getContext(), MainActivity.class);
                finish();
                startActivity(mainActIntent);

            }
        });

    }
}
