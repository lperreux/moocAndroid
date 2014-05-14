package com.osiatis.moocandroid;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    private String username;
    private String date;
    private String globalMsg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("main", "dans la méthode onCreate");
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onOkClick(View v) {

        Log.i("main", "click sur OK");
        EditText edit = (EditText) findViewById(R.id.mainConnexionValue);
        username = edit.getText().toString();

        setContentView(R.layout.activity_forum);
        TextView forumTitle = (TextView) findViewById(R.id.forumTitle);
        forumTitle.setText("Vous êtes connectés sur le forum de " + username);
        return true;
    }

    public boolean newMessage(View v) {

        getDate();
        EditText msg = (EditText) findViewById(R.id.forumMessageValue);
        TextView listMessage = (TextView) findViewById(R.id.forumListMessage);

        String newMsg = date + " " + username + " : " + msg.getText().toString() + "\n";
        globalMsg = newMsg.concat(globalMsg);
        listMessage.setText(globalMsg);

        msg.setText("");
        return true;
    }

    public boolean getDate(){

        Date today = new Date();
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.SHORT, new Locale("FR","fr"));
        date = shortDateFormat.format(today);
        return true;
    }


}
