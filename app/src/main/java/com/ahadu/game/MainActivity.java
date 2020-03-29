package com.ahadu.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView r ;
    EditText guess;
    LinearLayoutManager linearLayoutManager;
    Button btn;
    int ran;
    List<taker> takers = new ArrayList<>();
    int s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = findViewById(R.id.recycler);
        guess = findViewById(R.id.guess);
        btn = findViewById(R.id.submit);

        linearLayoutManager = new LinearLayoutManager(this);//create layout manager
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);//set the orientation of layout vertical


        do{
            ran = generateRandom();
        }while (ran==0);


           // order.setText("there is no duplicate");//next get the user input and check it with the random number
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int x = Integer.parseInt(guess.getText().toString());
                    int[] hello = numbr(ran,x);
                    takers.add(new taker(x+"",hello[0]+"",hello[1]+""));
                    if(hello[0]==4&&hello[1]==4){
                        guess.setText("Winner");
                        btn.setText(ran+"");
                    }
                    adapt a  =new adapt(getApplicationContext(),takers);
                    r.setAdapter(a);
                    r.setLayoutManager(linearLayoutManager);
                }
            });



    }
    public int generateRandom(){
        double y = Math.random()*10000;
        s = ((int) y);
        String a = s+"";
        char[] x = a.toCharArray();
        if(s>1000) {
            for (int i = 0; i < x.length - 1; i++) {
                for (int j = i + 1; j < x.length; j++) {
                    if (x[i] == x[j]) {
                        return 0;
                    }
                }
            }

        }else{
            return 0;
        }

        return s;
    }

    public int[] numbr(int x,int y){
        int number = 0,order=0;
        String forX = x+"";
        char[] toX = forX.toCharArray();
        String forY = y+"";
        char[] toY = forY.toCharArray();

        for(int i=0;i<toX.length;i++){
            for(int j=0;j<toY.length;j++){
                if(toX[i]==toY[j]){
                    number++;
                    if(i==j){
                        order++;
                    }
                }
            }
        }
        int[] pass = {number,order};
        return pass;
    }
}
