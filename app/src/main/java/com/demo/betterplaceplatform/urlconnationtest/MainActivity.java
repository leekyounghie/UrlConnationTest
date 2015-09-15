package com.demo.betterplaceplatform.urlconnationtest;


import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import org.w3c.dom.Element;

import java.io.InputStream;

public class MainActivity extends ActionBarActivity implements CommonConventions {
    String url = "http://openapi.airport.kr/openapi/service/StatusOfPassengerFlights/getPassengerArrivals?" +
            "ServiceKey=RN5il12RYM%2FXFWaIm8otCbez%2B5W1YxN91ZzBtYx4u3hh24IgLuMAr5L" +
            "EvByuM62KPv7l8Y4qbNUy0AgE2YtWHw%3D%3D";
    String[] PARSERITEMGROUP = {"airline", "airport", "airportCode", "flightId", "scheduleDateTime",
            "estimatedDateTime", "chkinrange", "gatenumber", "remark", "carousel", "ADStat"};
    TextView textView;
    Handler handler;
    Context mContext;
    String ItemName;
    Element[] element;
    StringBuffer strBuffer = new StringBuffer();
    InputStream inStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        handler = new Handler();
        mContext = getApplicationContext();

        GetDataTask getDataTask = new GetDataTask();
        getDataTask.execute(url);
    }

    private class GetDataTask extends AsyncTask<String, Void, InputStream> {
        ProgressDialog dialog;
        String str;

        @Override
        protected InputStream doInBackground(String... params) {
            /*******************************************8
             * URL  과 Okhttp 두개를 구현해 놓았습니다
             *********************************************/




           /* String Url = URLHADE + PDEPARTURES + SERVICEKEY;
            try {
                URL url = new URL(Url);
                inStream = url.openStream();*/

            OkHttpExample okHttpExample = new OkHttpExample();
            try {
                inStream = okHttpExample.doGetStreamRequest(url);
                str = okHttpExample.doGetStringRequest(url);
                return null;
            } catch (Exception e) {

            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("파일을 다운로드중");
            dialog.setMessage("잠시만 기다리세요...");
            dialog.setIndeterminate(true);
            dialog.setCancelable(true);
            dialog.show();
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            super.onPostExecute(inputStream);

            try {

                /*new AirlineParser(inStream);*/

                PullParserFromXML pullParserFromXML = new PullParserFromXML(str);
            } catch (Exception e) {
                e.printStackTrace();
            }

            dialog.dismiss();
        }


        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @TargetApi(Build.VERSION_CODES.HONEYCOMB)
        @Override
        protected void onCancelled(InputStream inputStream) {
            super.onCancelled(inputStream);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        public InputStream getInStream() {
            return inStream;
        }
    }
}


/*

    ArrayList<String> custonXmlParser() throws Exception {
        ArrayList<String> ArrString = new ArrayList<String>();
        ArrayList<String> emporaryArr = new ArrayList<String>();
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();

        xpp.setInput(new StringReader(str));
        int eventType = xpp.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {

            if (eventType == XmlPullParser.TEXT) {
                //Log.i("TAG", xpp.getText());
                emporaryArr.add(xpp.getText());
            }
            eventType = xpp.next();
        }

        for (int i = 2; i < emporaryArr.size(); i++) {
//                ArrString.add(emporaryArr.get(i));
//                Log.i("Item", "Counter....."+i+">>>>>"+ArrString.get(i));
        }

        for (int i = 1; i < emporaryArr.size() / 20; i++) {
            ArrString.add(emporaryArr.get(i));
            Log.i("Item", "Counter....." + i + ">>>>>" + ArrString.get(i));
        }

        Log.i("Length", Integer.toString(emporaryArr.size()));
        return ArrString;
    }
*/
/*

    ArrayList<AirlineItem> spriteArray() throws Exception {
        String str1 = null;
        String str2 = null;

        ArrayList<String> Stritem = custonXmlParser();
        ArrayList<AirlineItem> items = new ArrayList<AirlineItem>();
        AirlineItem item = null;
        String[] strings = new String[10];

        int stringSize = custonXmlParser().size();
        int count = 0;
        for (int i = 0, ii = 9; i > stringSize; i++, ii++) {
            count = ii % 9;
            strings[count] = Stritem.get(i);

            if (count > 9) {
                items.add(new AirlineItem(strings));
                count = 0;
                strings = null;
            }
        }
        str1 = Integer.toString(custonXmlParser().size());
        str2 = Integer.toString(items.size());

        Log.i("Length", str1 + "///" + str2);
        return items;
    }

    ArrayList<String> custonXmlParser() throws Exception {

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();
        ArrayList<String> ArrString = new ArrayList<String>();

        xpp.setInput(new StringReader(str));
        int eventType = xpp.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_DOCUMENT) {
                Log.i("TAG", "Start document");
            } else if (eventType == XmlPullParser.START_TAG) {
//                    Log.i("TAG", "Start tag " + xpp.getName());
                if ("item".equals(xpp.getName())) {
                    Log.i("TAG", "Start tag " + xpp.getName());
                }

            } else if (eventType == XmlPullParser.TEXT) {
//                    Log.i("TAG", xpp.getText());
                ArrString.add(xpp.getText());

            } else if (eventType == XmlPullParser.END_TAG) {
//                    Log.i("TAG", "End tag " + xpp.getName());
            }

            eventType = xpp.next();
        }
        System.out.println("End document");
        return ArrString;
    }*/

