package css.finalproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd, buttonDetails, buttonDelete;
    ListView listViewPlayer;
    ArrayAdapter<Batter> playerAdapter;
    List<Batter> playerList;
    PlayerFirebaseData playerDataSource;
    DatabaseReference myPlayerDbRef;
    int positionSelected;
    Batter playerSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setupFirebaseDataChange();
        setupListView();
        setupAddButton();
        setupDetailButton();
        setupDeleteButton();

    }

    private void setupFirebaseDataChange(){
        playerDataSource = new PlayerFirebaseData();
        myPlayerDbRef = playerDataSource.open();
        myPlayerDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                playerList = playerDataSource.getAllPlayer(dataSnapshot);
                // Instantiate a custom adapter for displaying each player
                playerAdapter = new PlayerAdapter(MainActivity.this, android.R.layout.simple_list_item_single_choice, playerList);
                // Apply the adapter to the list
                listViewPlayer.setAdapter(playerAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("CIS3334", "onCancelled: ");
            }
        });
    }

    private void setupListView() {
        listViewPlayer = (ListView) findViewById(R.id.ListViewPlayers);
        listViewPlayer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View parent,
                                    int position, long id) {
                positionSelected = position;
                Log.d("MAIN", "Player selected at position " + positionSelected);
            }
        });
    }

    private void setupAddButton() {
        // Set up the button to add a new player using a seperate activity
        buttonAdd = (Button) findViewById(R.id.buttonAddPlayer);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Start up the add player activity with an intent
                Intent detailActIntent = new Intent(view.getContext(), AddPlayerActivity.class);
                finish();
                startActivity(detailActIntent);
            }
        });
    }

    private void setupDetailButton() {
        // Set up the button to display details on one player using a seperate activity
        buttonDetails = (Button) findViewById(R.id.buttonDetails);
        buttonDetails.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d("MAIN", "onClick for Details");
                Intent detailActIntent = new Intent(view.getContext(), PlayerDetailActivity.class);
                detailActIntent.putExtra("Player", playerList.get(positionSelected));
                finish();
                startActivity(detailActIntent);
            }
        });
    }

    private void setupDeleteButton() {
        // Set up the button to display details on one player using a seperate activity
        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("MAIN", "onClick for Delete");
                Log.d("MAIN", "Delete at position " + positionSelected);
                playerDataSource.deletePlayer(playerList.get(positionSelected));
                playerAdapter.remove( playerList.get(positionSelected) );
                playerAdapter.notifyDataSetChanged();
            }
        });
    }
}
