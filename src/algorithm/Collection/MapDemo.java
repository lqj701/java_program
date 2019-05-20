package algorithm.Collection;

import com.alibaba.fastjson.JSONObject;

public class MapDemo {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("a", 1);
        map.put("b", 2);
        System.out.println(JSONObject.toJSONString(map.get("a")));
    }
}
