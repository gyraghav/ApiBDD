package utility;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import config.DataLoad;

import java.util.*;

import cucumber.api.DataTable;

public class StepUtil {


    public static Map<String, String> toMap(DataTable dataTable){
        List<Map<String, String>> mapList = dataTable.asMaps(String.class, String.class);
        return dataReplace(mapList.get(0));
    }

    /**
     * Return Map data from cucumber DataTable
     * @param dataTable
     * @return
     */
    public static HashMap<String, String> toHashMap(DataTable dataTable){
        List<Map<String, String>> mapList = dataTable.asMaps(String.class, String.class);
        Map<String, String> map = dataReplace(mapList.get(0));
        HashMap<String, String> hashMap = new HashMap<String,String>();
        for (Map.Entry<String,String> entry : map.entrySet()) {
            hashMap.put(entry.getKey(),entry.getValue());
        }
        return hashMap;
    }

    /**
     * To replace test data with generated data based on matching patterns like., <datetime>, <rstr5>
     * @param unmap
     * @return
     */
    public static Map<String, String> dataReplace(Map<String, String> unmap){

        final Map<String, String> map = new HashMap<String, String>(unmap);
        for (Map.Entry<String,String> entry : map.entrySet()) {

                if(entry.getValue().contains("<datetime>")){
                    String value = entry.getValue();
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyMMddHHmm");
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String ts = sdf1.format(timestamp);
                    value = value.replace("<datetime>",ts);
                    map.replace(entry.getKey(),entry.getValue(),value);
                }

                
            }
        return map;
    }
   

   
   

}
