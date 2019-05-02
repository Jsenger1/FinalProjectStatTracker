package css.finalproject;

import java.io.Serializable;

public class Batter implements Serializable {
    private String key;
    private int atBats;
    private int hits;
    private String playerName;



    public Batter(String key, int atBats, int hits, String playerNumber){
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

    public int getAtBats(){
        return atBats;
    }
    public void setAtBats(int atBats){
        this.atBats = atBats;
    }
    public int getHits(){
        return hits;
    }
    public void setHits(int hits){
        this.hits = hits;
    }
    public String getPlayerNumber(){
        return playerName;
    }
    public void setPlayerNumber(String playerNumber){
        this.playerName = playerNumber;
    }
    public double calcAvg(){
        double avg = this.atBats / this.hits;
        return avg;
    }

}
