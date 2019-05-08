package css.finalproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PlayerAdapter extends ArrayAdapter<Batter> {

    private List<Batter> playerList;            // The list of player to display
    private Context context;                // The original activity that displays this
    private int layoutResource;                   // the layout to use


    public PlayerAdapter(Context context, int resource, List<Batter> playerList) {
        super(context, resource, playerList);
        this.context = context;
        this.layoutResource = resource;
        this.playerList = playerList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the player we are displaying
        Batter player = playerList.get(position);
        View view;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(R.layout.player_row_layout, null);

        TextView tvName=(TextView)view.findViewById(R.id.textViewName);
        TextView tvBats=(TextView)view.findViewById(R.id.textViewBats);
        TextView tvHits=(TextView)view.findViewById(R.id.textViewHits);
        tvName.setText(player.getPlayerName());
        tvBats.setText(player.getAtBats());
        tvHits.setText(player.getHits());

        return(view);
    }
}
