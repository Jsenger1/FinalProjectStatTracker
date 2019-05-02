package css.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd, buttonDetails, buttonDelete;
    ListView listViewPlayer;
    ArrayAdapter<Batter> batterAdapter;
    DatabaseReference myPlayerDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
