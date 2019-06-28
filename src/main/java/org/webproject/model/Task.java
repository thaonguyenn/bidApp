package org.webproject.model;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class Task {
	MainActivity mContext;
    Double duration;
//constructor is used to get the context.
    public Task(MainActivity mContext) {
        this.mContext = mContext;
    }
    protected String doInBackground(String... params) {
        try {
            URL url=new URL(params[0]);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int statuscode=con.getResponseCode();
            if(statuscode==HttpURLConnection.HTTP_OK)
            {
                BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder sb=new StringBuilder();
                String line=br.readLine();
                while(line!=null)
                {
                    sb.append(line);
                    line=br.readLine();
                }
                String json=sb.toString();
                JSONObject root=new JSONObject(json);
                JSONArray array_rows=root.getJSONArray("rows");
                JSONObject object_rows=array_rows.getJSONObject(0);
                JSONArray array_elements=object_rows.getJSONArray("elements");
                JSONObject  object_elements=array_elements.getJSONObject(0);
                JSONObject object_duration=object_elements.getJSONObject("duration");
                JSONObject object_distance=object_elements.getJSONObject("distance");

                return object_duration.getString("value")+","+object_distance.getString("value");

            }
        } catch (MalformedURLException e) {
            System.out.println("error MalformedURLException");
        } catch (IOException e) {
            System.out.println("error IOException");
        } catch (JSONException e) {
            System.out.println("error JSONException");
        }


        return null;
    }
   
}
