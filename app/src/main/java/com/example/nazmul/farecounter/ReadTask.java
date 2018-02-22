package com.example.nazmul.farecounter;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Nazmul on 2/2/2018.
 */

public class ReadTask extends AsyncTask<String, Void , String> {
    @Override
    protected String doInBackground(String... url) {
        // TODO Auto-generated method stub
        String data = "";
        try {
            MapHttpConnection http = new MapHttpConnection();
            data = http.readUr(url[0]);


        } catch (Exception e) {
            // TODO: handle exception
            Log.d("Background Task", e.toString());
        }
        return data;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        new ParserTask().execute(result);
    }
}

