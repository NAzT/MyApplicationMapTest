package models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

// [START post_class]
@IgnoreExtraProperties
public class EnviSensorModel {

    public String id;
    public String temp;
    public String humid;
    public String time;
    public String pm1;
    public String pm25;
    public String pm10;

    public EnviSensorModel() {
        // Default constructor required for calls to DataSnapshot.getValue(EnviSensorModel.class)
    }


    // [START post_to_map]
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("time", time);
        result.put("temp", temp);
        result.put("humid", humid);
        result.put("pm1", pm1);
        result.put("pm10", pm10);
        result.put("pm25", pm25);

        return result;
    }
    // [END post_to_map]

}
// [END post_class]
