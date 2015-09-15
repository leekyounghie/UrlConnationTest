package com.demo.betterplaceplatform.urlconnationtest;

import android.app.ListActivity;

/**
 * Created by starnamu on 2015-09-10.
 */
public class BoardActivity extends ListActivity {
   /* private ProgressDialog dialog;
    protected ArrayList<Map<String, String>> dataList;
    String url = "http://openapi.airport.kr/openapi/service/StatusOfPassengerFlights/getPassengerArrivals?" +
            "ServiceKey=RN5il12RYM%2FXFWaIm8otCbez%2B5W1YxN91ZzBtYx4u3hh24IgLuMAr5L" +
            "EvByuM62KPv7l8Y4qbNUy0AgE2YtWHw%3D%3D";

    private AsyncTask<Void, Integer, Void> mTask = new AsyncTask<Void, Integer, Void>() {


        protected Void doInBackground(Void... p) {

            // 새롭게 데이터를 가져오는 부분(기존 List는 삭제)
            dataList = new ArrayList<Map<String, String>>();


            try {
                publishProgress(1);        // 접속 중
                // 5초가 지나면 타임아웃 시킨다. 설정하지 않으면 계속 기다림
                HttpParams params = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(params, 10000);

                DefaultHttpClient client = new DefaultHttpClient(params);
                // POST 방식으로 요청을 보내기 위해 요청주소를 인자값으로 객체 생성
                HttpPost request =
//                           new HttpPost("http://14.37.37.161:8080/main2.xml");
//                        new HttpPost("http://14.37.37.166:8080/sp/re/xml");
                        new HttpPost(url);
                ArrayList<BasicNameValuePair> parameters =
                        new ArrayList<BasicNameValuePair>();

                // 인자값을 ArrayList로 저장
                parameters.add(new BasicNameValuePair("id", "완쌤"));

                // 요청 객체(HttpPost)에 파라미터를 인코딩해서 저장
                request.setEntity(
                        new UrlEncodedFormEntity(parameters, "UTF-8"));


                publishProgress(2);        // 데이터 수신 중
                // 요청을 실행해서 응답을 받는다.
                HttpResponse response = client.execute(request);
                InputStream is = response.getEntity().getContent();


                // XMLPullParser 이용 파싱
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser parser = factory.newPullParser();
                parser.setInput(is, "UTF-8");


                publishProgress(3);        // 데이터 분석중
                int event = XmlPullParser.START_DOCUMENT;
                while ((event = parser.next()) != XmlPullParser.END_DOCUMENT) {
                    switch (event) {
                        case XmlPullParser.START_TAG:
                            // item 태그가 아니면 건너뛴다.
                            if (!parser.getName().equals("item"))
                                break;
                            String title = parser.getAttributeValue(null, "airline");
                            String wdate = parser.getAttributeValue(null, "airport");
                            HashMap<String, String> map = new HashMap<String, String>();
                            map.put("airline", title);
                            map.put("airport", wdate);
                            dataList.add(map);

                    }
                }


            } catch (Exception e) {
                publishProgress(-1);
                Log.e("net", "게시판 오류", e);
            }


            return null;

        }

        protected void onProgressUpdate(Integer[] values) {
            switch (values[0]) {
                case -1:
                    Toast.makeText(getApplicationContext(), "통신 오류", Toast.LENGTH_LONG).show();
                    break;
                case 1:
                    dialog.setMessage("접속 중...");
                    break;
                case 2:
                    dialog.setMessage("데이터 수신 중...");
                    break;
                case 3:
                    dialog.setMessage("데이터 분석 중...");
                    break;
            }
            dialog.setProgress(values[0]);
        }

        protected void onPostExecute(Void result) {
            SimpleAdapter adapter = new SimpleAdapter(
                    getApplicationContext(), dataList,
                    android.R.layout.simple_list_item_2,
                    new String[]{"title", "wdate"},
                    new int[]{android.R.id.text1, android.R.id.text2});
            setListAdapter(adapter);

            dialog.dismiss();
            Toast.makeText(getApplicationContext(), "로딩완료", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        // ProgressDialog 띄워서 1~100까지 게이지를 채우고 사라질 것.
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading...");
        dialog.setMessage("접속 시작");
        dialog.setCancelable(false);
        dialog.setMax(3);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.show();

        mTask.execute();
    }*/

}
