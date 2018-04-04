package com.austin.anagrams;
import android.app.Application;

public class Global extends Application{

    private int challengeNum;

    public int getChallengeNum(){
        return challengeNum;
    }

    public void setChallengeNum(int x){
        this.challengeNum = x;
    }
}
