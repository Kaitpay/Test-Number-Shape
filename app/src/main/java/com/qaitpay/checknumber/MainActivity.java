package com.qaitpay.checknumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String message ="";
    TextView title,intro ;
    EditText userNumber;
    class Number {
        int number ;
        boolean isSquareNum(){
            double squareRoot = Math.sqrt(number);
            if ((squareRoot == Math.floor(squareRoot))) {
                return true;
            }
            else{
                return false;
            }
        }
        boolean isTrianglar() {
            int counter =1;

            int trianglerNumber =1;
            while ((trianglerNumber<number)){
                counter++;
                trianglerNumber= trianglerNumber+counter;
            }
            if(trianglerNumber==number)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title);
        intro = findViewById(R.id.intro);
        userNumber = findViewById(R.id.userNumber);

    }

    public void testNumber(View view) {
        Number myNumber = new Number();

        if (userNumber.getText().toString().isEmpty()) {
            message = " Please Enter Your Number";
        } else {

            myNumber.number = Integer.parseInt(userNumber.getText().toString());
            if (myNumber.isSquareNum()) {
                if (myNumber.isTrianglar()) {

                    message = myNumber.number + " The number is both triangular and square";
                } else {
                    message = myNumber.number + " The number is square but not triangular ";
                }

            } else {
                if (myNumber.isTrianglar()) {

                    message = myNumber.number + " The number is triangular but not square";
                } else {
                    message = myNumber.number + " The number is not square and not triangular ";
                }


            }
        }
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

    }
}