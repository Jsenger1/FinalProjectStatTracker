package css.finalproject;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class PlayerFirebaseData {
    DatabaseReference myPlayerDbRef;
    public static final String PlayerDataTag = "Player Data";

        public DatabaseReference open() {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            myPlayerDbRef = database.getReference(PlayerDataTag);
            return myPlayerDbRef;
    }

        public void close() {

    }

    public Batter createPlayer(int atBats, int hits, String playerName) {
        String key = myPlayerDbRef.child(PlayerDataTag).push().getKey();
        Batter newPlayer = new Batter(key, atBats, hits, playerName);
        myPlayerDbRef.child(key).setValue(newPlayer);
        return newPlayer;
    }

    public void deletePlayer(Batter player){
            String key = player.getKey();
            myPlayerDbRef.child(key).removeValue();
    }

    public List<Batter> getAllPlayer(DataSnapshot dataSnapshot){
            List<Batter> playerList = new ArrayList<Batter>();
            for (DataSnapshot data : dataSnapshot.getChildren()){
                Batter player = data.getValue(Batter.class);
                playerList.add(player);
            }
            return playerList;
    }



}
