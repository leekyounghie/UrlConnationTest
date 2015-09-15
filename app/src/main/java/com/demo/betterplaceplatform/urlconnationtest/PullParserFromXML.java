package com.demo.betterplaceplatform.urlconnationtest;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class PullParserFromXML {

    ArrayList<AirlineItem_old> Items;
    AirlineItem_old item;

    public PullParserFromXML(String data) {


        boolean boolean_airline = false,
                boolean_airport = false,
                boolean_airportCode = false,
                boolean_flightId = false,
                boolean_scheduleDateTime = false,
                boolean_estimatedDateTime = false,
                boolean_chkinrange = false,
                boolean_gatenumber = false,
                boolean_remark = false,
                boolean_carousel = false;

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            String sTag;
            parser.setInput(new StringReader(data));

            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:            // 문서의 시작
                        Items = new ArrayList<>();
                        Log.i("PullXML", "여기까지 성공_1");
                        break;

                    case XmlPullParser.END_DOCUMENT:        // 문서의 끝
                        break;

                    case XmlPullParser.START_TAG:                 // 시작 태그를 만나면 이름을 살펴봐서 작업(아무 일도 안하거나 값을 읽어 저장
                        sTag = parser.getName();
                        if (sTag.equals("item"))
                            item = new AirlineItem_old();
                        if (sTag.equals("airline"))
                            boolean_airline = true;
                        else if (sTag.equals("airport"))
                            boolean_airport = true;
                        else if (sTag.equals("airportCode"))
                            boolean_airportCode = true;
                        else if (sTag.equals("flightId"))
                            boolean_flightId = true;
                        else if (sTag.equals("scheduleDateTime"))
                            boolean_scheduleDateTime = true;
                        else if (sTag.equals("estimatedDateTime"))
                            boolean_estimatedDateTime = true;
                        else if (sTag.equals("chkinrange"))
                            boolean_chkinrange = true;
                        else if (sTag.equals("gatenumber"))
                            boolean_gatenumber = true;
                        else if (sTag.equals("remark"))
                            boolean_remark = true;
                        else if (sTag.equals("carousel"))
                            boolean_carousel = true;
                        break;

                    case XmlPullParser.END_TAG:                   // End 태그를 만나면
                        sTag = parser.getName();
                        if (sTag.equalsIgnoreCase("item") && item != null) {
                            Items.add(item);
                        }
                        break;
                    case XmlPullParser.TEXT:
                        if (boolean_airline) {
                            item.setAirline(parser.getText());
                            boolean_airline = false;
                        } else if (boolean_airport) {
                            item.setAirport(parser.getText());
                            boolean_airport = false;
                        } else if (boolean_airportCode) {
                            item.setAirportCode(parser.getText());
                            boolean_airportCode = false;
                        } else if (boolean_flightId) {
                            item.setFlightId(parser.getText());
                            boolean_flightId = false;
                        } else if (boolean_scheduleDateTime) {
                            item.setScheduleDateTime(parser.getText());
                            boolean_scheduleDateTime = false;
                        } else if (boolean_estimatedDateTime) {
                            item.setEstimatedDateTime(parser.getText());
                            boolean_estimatedDateTime = false;
                        } else if (boolean_chkinrange) {
                            item.setChkinrange(parser.getText());
                            boolean_chkinrange = false;
                        } else if (boolean_gatenumber) {
                            item.setRemark(parser.getText());
                            boolean_gatenumber = false;
                        } else if (boolean_remark) {
                            item.setCarousel(parser.getText());
                            boolean_remark = false;
                        } else if (boolean_carousel) {
                            item.setRemark(parser.getText());
                            boolean_carousel = false;
                            break;
                        }
                        eventType = parser.next();
                }
                Log.i("PullXML", Items.get(0).getAirline() + " " + Items.get(0).getFlightId());
                Log.i("PullXML", Items.get(1).getAirline() + " " + Items.get(0).getFlightId());
                Log.i("PullXML", Items.get(2).getAirline() + " " + Items.get(0).getFlightId());
            }
        } catch (Exception e) {

        }
        Log.i("PullXML", "여기까지 성공_1");
    }
}
