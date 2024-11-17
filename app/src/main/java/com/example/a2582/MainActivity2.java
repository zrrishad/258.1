package com.example.a2582;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView ed2Name,ed2Username,edPass2,edBlood2,edGender2,edAge2,edBirthday2,edHeight2,edWeight,edEye2;





    public static String DetName="";
    public static String DetUser="";
    public static String DetPass="";
    public static String DetBlood="";
    public static String DetGender="";
    public static String DetAge="";
    public static String DetBirthday="";
    public static String DetHeight="";
    public static String DetWeight="";
    public static String DetEye="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);


        ed2Name=findViewById(R.id.ed2Name);
        ed2Username=findViewById(R.id.ed2Username);
        edPass2=findViewById(R.id.edPass2);
        edBlood2 =findViewById(R.id.edBlood2);
        edGender2=findViewById(R.id.edGender2);
        edAge2=findViewById(R.id.edAge2);
        edBirthday2=findViewById(R.id. edBirthday2);
       edEye2 =findViewById(R.id. edEye2);
        edHeight2=findViewById(R.id.edHeight2);
        edWeight=findViewById(R.id.edWeight);



        ed2Name.setText("   Name : " + DetName);
        ed2Username.setText("   Username : "+DetUser);
        edPass2.setText("   Password : "+DetPass);
        edBlood2.setText("   Blood Group : "+DetBlood);
        edGender2.setText("   Gender : "+DetGender);
        edAge2.setText("   Age : "+DetAge);
        edBirthday2.setText("   Birthday : "+DetBirthday);
        edHeight2.setText("   Height : "+DetHeight);
        edWeight.setText("   Weight : "+DetWeight);
        edEye2.setText("   EyeColor : "+DetEye);


    }
}