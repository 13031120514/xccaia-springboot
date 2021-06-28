package com.xc.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;

import java.util.Iterator;
import java.util.Map;

public class ObjectMapperTest {


  public static void main(String[] args) throws Exception {


       /* ObjectMapper mapper = new ObjectMapper();
        String message="{\"code\":\"EXCEPTION\",\"msgInfo\":\"交易支付异常\"} ";
        JsonNode jsonNode = mapper.readTree(message);
        System.out.println(jsonNode.get("code"));
*/

    String json = "{\"username\":\"tom\",\"company\":{\"companyName\":\"中华\",\"address\":\"北京\"},\"cars\":[\"奔驰\",\"宝马\"]";

    String arrayJson = "[{\"number\":64,\"result\":\"SUCCESS\"},{\"number\":65,\"result\":\"FAILURE\"},{\"number\":66,\"result\":\"ABORTED\"},{\"number\":67,\"result\":\"SUCCESS\"}]";

    System.out.println(json);
    System.out.println(arrayJson);

    ObjectMapper mapper = new ObjectMapper();
    JsonNode jsonNode = mapper.readTree(json);
    jsonNode = mapper.readTree(arrayJson);

    Iterator<Map.Entry<String, JsonNode>> jsonNodes = jsonNode.fields();
    while (jsonNodes.hasNext()) {
      Map.Entry<String, JsonNode> node = jsonNodes.next();
      System.err.println("遍历获取key:" + node.getKey());
      System.err.println("遍历获取值:" + node.getValue().toString());
    }


  }

}
