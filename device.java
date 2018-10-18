package com.example.hp.tictactoegame;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class device extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
    }
    public void BuClick(View view) {

        Button buSelected = (Button) view;
        int CellID=0;
        switch ((buSelected.getId())){
            case R.id.bu1:
                CellID=1;
                break;
            case R.id.bu2:
                CellID=2;
                break;
            case R.id.bu3:
                CellID=3;
                break;
            case R.id.bu4:
                CellID=4;
                break;
            case R.id.bu5:
                CellID=5;
                break;
            case R.id.bu6:
                CellID=6;
                break;
            case R.id.bu7:
                CellID=7;
                break;
            case R.id.bu8:
                CellID=8;
                break;
            case R.id.bu9:
                CellID=9;
                break;
        }
        ticTakToe(CellID,buSelected);
    }
    int ActivePlayer=1; //1 for player 1 and 2 for player 2.
    ArrayList<Integer> Player1=new ArrayList<Integer>();//to hold player 1 data.
    ArrayList<Integer> Player2=new ArrayList<Integer>();//to hold player 2 data.
    void ticTakToe(int CellID,Button buSelected){
        if(ActivePlayer==1){
            buSelected.setBackgroundColor(Color.RED);
            buSelected.setText("X");
            Player1.add(CellID);
            ActivePlayer=2;
            AutoPlay();
        }
        else if(ActivePlayer==2){
            buSelected.setBackgroundColor(Color.YELLOW);
            buSelected.setText("0");
            Player2.add(CellID);
            ActivePlayer=1;
        }
        buSelected.setEnabled(false);
        toCheckWinner();
    }
    void toCheckWinner(){
        int winner=-1;
        //row1
        if(Player1.contains(1) && Player1.contains(2) && Player1.contains(3)){
            winner=1;
        }
        if(Player2.contains(1) && Player2.contains(2) && Player2.contains(3)){
            winner=2;
        }
        //row2
        if(Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){
            winner=1;
        }
        if(Player2.contains(4) && Player2.contains(4) && Player2.contains(6)){
            winner=2;
        }
        //row 3
        if(Player1.contains(7) && Player1.contains(8) && Player1.contains(9)){
            winner=1;
        }
        if(Player2.contains(7) && Player2.contains(8) && Player2.contains(9)){
            winner=2;
        }
        //column 1
        if(Player1.contains(1) && Player1.contains(4) && Player1.contains(7)){
            winner=1;
        }
        if(Player2.contains(1) && Player2.contains(4) && Player2.contains(7)){
            winner=2;
        }
        //column 2
        if(Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){
            winner=1;
        }
        if(Player2.contains(2) && Player2.contains(5) && Player2.contains(8)){
            winner=2;
        }
        //column 3
        if(Player1.contains(3) && Player1.contains(6) && Player1.contains(9)){
            winner=1;
        }
        if(Player2.contains(3) && Player2.contains(6) && Player2.contains(9)){
            winner=2;
        }
        //diagonal 1
        if(Player1.contains(1) && Player1.contains(5) && Player1.contains(9)){
            winner=1;
        }
        if(Player2.contains(1) && Player2.contains(5) && Player2.contains(9)){
            winner=2;
        }
        //diagonal 2
        if(Player1.contains(3) && Player1.contains(5) && Player1.contains(7)){
            winner=1;
        }
        if(Player2.contains(3) && Player2.contains(5) && Player2.contains(7)){
            winner=2;
        }
        if (winner !=-1){
            //we have a winner
            if (winner==1){
                Toast.makeText(this, "Player 1 wins", Toast.LENGTH_SHORT).show();
            }
            if (winner==2){
                Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT).show();
            }
        }
    }
    void AutoPlay(){
        ArrayList<Integer> EmptyCells = new ArrayList<Integer>(); //all cells that are not selected
        //find empty places
        for(int i=1;i<10;i++){
            if(!(Player1.contains(i) || Player2.contains(i))){
                EmptyCells.add(i);
            }
        }
        Random r=new Random();
        int RandomIndex=r.nextInt(EmptyCells.size()-0)+0;//if size=3 , select 0,1,2 .
        int CellID=EmptyCells.get(RandomIndex);
        Button buSelected;
        switch (CellID){
            case 1:
                buSelected=(Button) findViewById(R.id.bu1);
                break;
            case 2:
                buSelected=(Button) findViewById(R.id.bu2);
                break;
            case 3:
                buSelected=(Button) findViewById(R.id.bu3);;
                break;
            case 4:
                buSelected=(Button) findViewById(R.id.bu4);
                break;
            case 5:
                buSelected=(Button) findViewById(R.id.bu5);;
                break;
            case 6:
                buSelected=(Button) findViewById(R.id.bu6);;
                break;
            case 7:
                buSelected=(Button) findViewById(R.id.bu7);;
                break;
            case 8:
                buSelected=(Button) findViewById(R.id.bu8);;
                break;
            case 9:
                buSelected=(Button) findViewById(R.id.bu1);;
                break;
            default:
                buSelected=(Button) findViewById(R.id.bu1);
                break;
        }
        ticTakToe(CellID,buSelected);
    }

    public void changeScreen(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
