package com.chkry.frontpage;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {


    String[] chkry = {"HELLO","world","welcome","tothe","World","come","on","keep","going","where","are","you","mr","friend","see","them","tommorow","also","nice","stamps","duty"};

    public static Set<String> arrList = new TreeSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayAdapter adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.listlayout, chkry);
        final ListView listViewpost = (ListView) findViewById(R.id.listViewpost);
        listViewpost.setAdapter(adapter);


        //TeMP


        ///Temp

        listViewpost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Object o = listViewpost.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Position is : "+ position, Toast.LENGTH_SHORT).show();
                String str=(String)o;//As you are using Default String Adapter
//              Toast.makeText(getBaseContext(),str,Toast.LENGTH_SHORT).show();


//PErfect Code [Start]
//                CheckBox cb = (CheckBox) ((listViewpost.getChildAt(position)).findViewById(R.id.chkbox));
//                cb.setChecked(!cb.isChecked());
//Perfect Code [END]


                CheckBox cb = (CheckBox) view ;
                cb.setChecked(!cb.isChecked());


                if (str!=null && !str.isEmpty()) {
                    if (cb.isChecked()) {
                        arrList.add(str);
                        Toast.makeText(getApplicationContext(), "Added "+str+" successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        arrList.remove(str);
                        Toast.makeText(getApplicationContext(), "Removed "+str+" successfully", Toast.LENGTH_SHORT).show();
                    }
                }






            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, PostActivity.class);
                startActivity(i);

//                Snackbar.make(view, "Thank You for clicking,CHAKRI", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
