package com.mattchiaravalloti.colorchanger;

import android.app.WallpaperManager;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private Random generator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    private void updateColors(int r, int g, int b) {
        View v = getWindow().getDecorView().findViewById(android.R.id.content);

        EditText redInput = (EditText)findViewById(R.id.redInput);
        EditText greenInput = (EditText)findViewById(R.id.greenInput);
        EditText blueInput = (EditText)findViewById(R.id.blueInput);
        EditText hexInput = (EditText)findViewById(R.id.hexInput);

        redInput.setText(Integer.toString(r));
        greenInput.setText(Integer.toString(g));
        blueInput.setText(Integer.toString(b));

        String rHex = Integer.toHexString(r);
        if (rHex.length() != 2) {
            rHex = "0" + rHex;
        }

        String gHex = Integer.toHexString(g);
        if (gHex.length() != 2) {
            gHex = "0" + gHex;
        }

        String bHex = Integer.toHexString(b);
        if (bHex.length() != 2) {
            bHex = "0" + bHex;
        }

        String hex = "#" + rHex + gHex + bHex;

        hexInput.setText(hex.toUpperCase());

        v.setBackgroundColor(Color.rgb(r,g,b));
    }

    private int hexToDecimal(String val1, String val2) {
        try {
            int decimalValue = Integer.valueOf(val1, 16) * 16;

            decimalValue += Integer.valueOf(val2, 16);

            return decimalValue;
        } catch (NumberFormatException e) {
            return 225;
        }
    }

    public void clickRandomButton(View view) {
        int r = generator.nextInt(256);
        int g = generator.nextInt(256);
        int b = generator.nextInt(256);

        updateColors(r,g,b);
    }

    public void clickRGBButton(View view) {
        EditText redInput = (EditText)findViewById(R.id.redInput);
        EditText greenInput = (EditText)findViewById(R.id.greenInput);
        EditText blueInput = (EditText)findViewById(R.id.blueInput);

        int r = Integer.parseInt(redInput.getText().toString());
        r = r < 256 ? r : 255;
        r = r >= 0 ? r : 0;

        int g = Integer.parseInt(greenInput.getText().toString());
        g = g < 256 ? g : 255;
        g = g >= 0 ? g : 0;

        int b = Integer.parseInt(blueInput.getText().toString());
        b = b < 256 ? b : 255;
        b = b >= 0 ? b : 0;

        updateColors(r,g,b);
    }

    public void clickHEXButton(View view) {
        EditText hexInput = (EditText)findViewById(R.id.hexInput);

        String hexValue = hexInput.getText().toString();

        if (hexValue.length() != 7 || !hexValue.contains("#")) {
            hexValue = "#FFFFFF";
            Toast.makeText(getApplicationContext(),
                    "Make sure to include '#' and 6 digits!",
                    Toast.LENGTH_LONG).show();
        }

        String rVal1 = Character.toString(hexValue.charAt(1));
        String rVal2 = Character.toString(hexValue.charAt(2));
        String gVal1 = Character.toString(hexValue.charAt(3));
        String gVal2 = Character.toString(hexValue.charAt(4));
        String bVal1 = Character.toString(hexValue.charAt(5));
        String bVal2 = Character.toString(hexValue.charAt(6));

        int r = hexToDecimal(rVal1, rVal2);
        int g = hexToDecimal(gVal1, gVal2);
        int b = hexToDecimal(bVal1, bVal2);

        updateColors(r,g,b);
    }
}
