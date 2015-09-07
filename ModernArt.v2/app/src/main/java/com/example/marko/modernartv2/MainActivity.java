package com.example.marko.modernartv2;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends Activity {

    private SeekBar mSeekBar;
    private static final int ALLERTAG = 0;
    private final  String url="https://www.moma.org/learn/moma_learning/themes/what-is-modern-art";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mSeekBar = (SeekBar) findViewById(R.id.seek_bar);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int seekBarProgress = 0;
            private TextView mRectangle1 = (TextView)findViewById(R.id.rectangle1);
            private TextView mRectangle2 = (TextView)findViewById(R.id.rectangle2);
            private TextView mRectangle3 = (TextView)findViewById(R.id.rectangle3);
            private TextView mRectangle4 = (TextView)findViewById(R.id.rectangle4);


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                seekBarProgress = progress;
                mRectangle1.setBackgroundColor(0xffaaaa00 + (0x100 * (progress))); //yellow color
                mRectangle2.setBackgroundColor(0xff00aa00 + (0x10000 * (progress))); //green color
                mRectangle3.setBackgroundColor(0xffaa0000 + (0x100 * (progress))); // red color
                mRectangle4.setBackgroundColor(0xff0000aa + (0x10000 * (progress))); //blue color
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.select_link, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.more_information) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Visit Modern Art website for more information about background style.")
                    .setCancelable(false);
            alertDialog.setNegativeButton("Not now!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Intent webIntent = new Intent(Intent.ACTION_VIEW);
                    webIntent.setData(Uri.parse(url));
                    startActivity(webIntent);
                }
            });
            alertDialog.create();
            alertDialog.show();

            return true;
        }
        else{
            return super.onOptionsItemSelected(item);
        }
    }
}
