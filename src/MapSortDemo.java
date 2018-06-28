import java.util.*;
import java.lang.*;
public class MapSortDemo {

    public static void main(String[] args) {

        Map<String, String> map = new TreeMap<String, String>();

        map.put("KFC", "kfc");
        map.put("WNBA", "wnba");
        map.put("NBA", "nba");
        map.put("CBA", "cba");

        Map<String, String> resultMap = sortMapByKey(map);    //按Key进行排序
//        Map<String, String> resultMap = sortMapByValue(map); //按Value进行排序

        for (Map.Entry<String, String> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    /**
     * 使用 Map按value进行排序
     * @param
     * @return
     */
    public static Map<String, String> sortMapByValue(Map<String, String> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, String> sortedMap = new LinkedHashMap<String, String>();
        List<Map.Entry<String, String>> entryList = new ArrayList<Map.Entry<String, String>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        Iterator<Map.Entry<String, String>> iter = entryList.iterator();
        Map.Entry<String, String> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }

    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String, String> sortMap = new TreeMap<String, String>(
                new MapKeyComparator());

        sortMap.putAll(map);

        return sortMap;
    }
}

class MapKeyComparator implements Comparator<String>{

    @Override
    public int compare(String str1, String str2) {

        return str1.compareTo(str2);
    }
}

class MapValueComparator implements Comparator<Map.Entry<String,String >> {
    @Override
    public int compare(Map.Entry<String,String> m1, Map.Entry<String,String> m2) {

        return m2.getValue().compareTo(m1.getValue());
    }

}