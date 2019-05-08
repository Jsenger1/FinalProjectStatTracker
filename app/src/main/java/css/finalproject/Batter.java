package css.finalproject;

import java.io.Serializable;

public class Batter implements Serializable {
    private String key;
    private String atBats;
    private String hits;
    private String playerName;



    public Batter(String key, String atBats, String hits, String playerNumber){
        this.key = key;
        this.atBats = atBats;
        this.hits = hits;
        this.playerName = playerNumber;

    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAtBats(){
        return atBats;
    }

    public void setAtBats(String atBats){
        this.atBats = atBats;
    }

    public String getHits(){
        return hits;
    }

    public void setHits(String hits){
        this.hits = hits;
    }

    public String getPlayerName(){
        return playerName;
    }

    public void setPlayerNumber(String playerNumber){
        this.playerName = playerNumber;
    }

   /*public double calcAvg(){
        double avg = this.atBats / this.hits;
        return avg;
    }
    **/

}
