package edu.ucsb.cs.cs185.mohit.newcsvparser;

import android.content.res.AssetManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //InputStream is = getResources()

/** slurping
        CSVReader reader = new CSVReader(new FileReader("cars.csv"));
        List myEntries = reader.readAll();
*/
        System.out.println("-----------------starting the parsing -----------------");



        ArrayList<String> csvCategoryNames = new ArrayList<String>();                       // arraylist to store the name of the csv stuff

    try {
        InputStreamReader csvStreamReader = new InputStreamReader( getAssets().open("cars.csv") );
        CSVReader reader = new CSVReader(csvStreamReader);

        String[] firstLine;
        firstLine = reader.readNext();
        for ( int i = 0 ; i < firstLine.length ; i++)
        {
            csvCategoryNames.add(firstLine[i] ); /// adding the row names to the category names
        }
        System.out.println("Header names: " + firstLine[0] +"   "+firstLine[1]+"  " + firstLine[2]+ "   " + firstLine[3] + " " + firstLine[4]);



        ArrayList<inputCSVdata> csvDataRows = new ArrayList<inputCSVdata>();                //creating an arraylist of inputCSV Data Class
        //**
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            System.out.println(nextLine[0] + "  " +  nextLine[1] + "  "+ nextLine[2] + "  "+ nextLine[3] + "  " +nextLine[4] );
            //to add the the first column name as a string
            //csvDataRows.name.add(nextLine[0]);



           // if (nextLine[1] == null || nextLine[2] == null || nextLine[3] == null|| nextLine[4] == null|| nextLine[5] == null|| nextLine[6] == null|| nextLine[7] == null )
           //    continue;

            inputCSVdata tempRowdata = new inputCSVdata();

            tempRowdata.name = nextLine[0];

            try {


                tempRowdata.economy = Float.parseFloat(nextLine[1]);
                tempRowdata.cylinders = Float.parseFloat(nextLine[2]);
                tempRowdata.displacement = Float.parseFloat(nextLine[3]);
                tempRowdata.power = Float.parseFloat(nextLine[4]);
                tempRowdata.weight = Float.parseFloat(nextLine[5]);
                tempRowdata.accelerate = Float.parseFloat(nextLine[6]);
                tempRowdata.year = Float.parseFloat(nextLine[7]);
            }
            catch(NumberFormatException ex)
            {
                System.out.println("found a 0 lol ");
                tempRowdata.economy = 0.0f;
                tempRowdata.cylinders = 0.0f;
                tempRowdata.displacement = 0.0f;
                tempRowdata.power = 0.0f;
                tempRowdata.weight = 0.0f;
                tempRowdata.accelerate = 0.0f;
                tempRowdata.year = 0.0f;

            }



            /**
            for ( int i = 1 ; i < nextLine.length ; i++ ) {
                tempRowdata.floatData.add(Float.parseFloat(nextLine[i]));
            }
             /*/


           csvDataRows.add(tempRowdata);
        }
        //*/


       System.out.println("size of arraylist is: " +  csvDataRows.size() );



    }
    catch (IOException e) {
        e.printStackTrace();
    }








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
