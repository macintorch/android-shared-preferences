package ainor.com.my.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("ainor.com.my.sharedpreferences", Context.MODE_PRIVATE);

        /*
        ArrayList<String> childrens = new ArrayList<>();

        childrens.add("Asad");
        childrens.add("Affan");
        childrens.add("Azka");

        try {
            sharedPreferences.edit().putString("childrens", ObjectSerializer.serialize(childrens)).apply();


        } catch (IOException e) {
            e.printStackTrace();
        }

        */

        ArrayList<String> newChildrens = new ArrayList<>();

        try {
            newChildrens = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("childrens", ObjectSerializer.serialize(new ArrayList<>())));


        } catch (IOException e) {
            e.printStackTrace();
        }
Log.i("new childrens", newChildrens.toString());

        //sharedPreferences.edit().putString("username","ainor").apply();

        //String username = sharedPreferences.getString("username","");

        //Log.i("username", username);
    }
}
