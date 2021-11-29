package com.sgcc.eip.cmc.cable.biz.acquisition.dto.msg;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xc.dto.ProtocolGatherRepDTO;
import com.xc.dto.User;
import com.xc.dto.User1;

import java.util.Arrays;

public class MainTest {


  public static void main(String[] args) {

    System.out.println(1);
    System.out.println(2);
//        String responseMessage = "{\n" +
//                "\t\"status\": \"0\",\n" +
//                "\t\"message\": \"ok\",\n" +
//                "\t\"data\": {\n" +
//                "\t\"businessTableName\":\"gi_breakdown_tolerance_test\",\n" +
//                "\t\t\"protocolFieldList\": [{\n" +
//                "\t\t\t\t\"protocolKey\": \"supplierCode\",\n" +
//                "\t\t\t\t\"protocolKeyDesc\": \"供应商code\",\n" +
//                "\t\t\t\t\"protocolValueLenth\": \"50\",\n" +
//                "\t\t\t\t\"protocolValueType\": \"0\"\n" +
//                "\t\t\t}, {\n" +
//                "\t\t\t\t\"protocolKey\": \"checkTime\",\n" +
//                "\t\t\t\t\"protocolKeyDesc\": \"测试时间\",\n" +
//                "\t\t\t\t\"protocolValueLenth\": \"\",\n" +
//                "\t\t\t\t\"protocolValueType\": \"3\"\n" +
//                "\t\t}],\n" +
//                "\t\t\"info\": {\n" +
//                "\t\t\t\"protocolId\": \"12\",\n" +
//                "\t\t\t\"protocolUrl\": \"http://cp2.com.cn/hello\",\n" +
//                "\t\t\t\"pushName\":\"\",\n" +
//                "\t\t\t\"cycle\": \"0 */3 * * * ?\",\n" +
//                "\t\t\t\"requestType\": \"post\",\n" +
//                "\"amount\":\"100\"\n" +
//                "}\n" +
//                "}\n" +
//                "}";
//
//        ProtocolResponseDTO protocolResponseDTO=getObject(responseMessage,ProtocolResponseDTO.class);
////        ProtocolResponseDTO protocolResponseDTO= (ProtocolResponseDTO) getProtocolGatherRepDTO1(responseMessage,
////                new TypeReference(){});
//
//        System.out.println(protocolResponseDTO);

    String responseMessage = "{\n" +
        "\t\"status\": \"0\",\n" +
        "\t\"message\": \"ok\",\n" +
        "\t\"data\": [{\n" +
        "\t\t\"protocolName\": \"玻璃绝缘子_成品生产工艺_胶装养护\",\n" +
        "\t\t\"businessTableName\": \"gi_glass_binding_mai\",\n" +
        "\t\t\"protocolId\": \"11\",\n" +
        "\t\t\"protocolType\": \"1\",\n" +
        "\t\t\"protocolState\":\"2\",\n" +
        "\t\t\"protocolUrl\": \"http://192.168.86.127:90/report/getFgCheckEveryone\",\n" +
        "\t\t\"pushName\": \"\",\n" +
        "\t\t\"cycle\": \"0*/3***?\",\n" +
        "\t\t\"requestType\": \"get\",\n" +
        "\t\t\"amount\": \"100\"\n" +
        "\t}, {\n" +
        "\t\t\"protocolName\": \"玻璃绝缘子_尺寸检查\",\n" +
        "\t\t\"businessTableName\": \"gi_dimension_check\",\n" +
        "\t\t\"protocolId\": \"11\",\n" +
        "\t\t\"protocolType\": \"1\",\n" +
        "\t\t\"protocolState\":\"2\",\n" +
        "\t\t\"protocolUrl\": \"http://192.168.86.127:90/report/getCheckDimension\",\n" +
        "\t\t\"pushName\": \"\",\n" +
        "\t\t\"cycle\": \"0*/3***?\",\n" +
        "\t\t\"requestType\": \"get\",\n" +
        "\t\t\"amount\": \"100\"\n" +
        "\t}]\n" +
        "}";

    System.out.println(responseMessage);


  }

  private static <T> T getProtocolGatherRepDTO1(String jsonString, TypeReference<T> typeReference) {
    try {
      return new ObjectMapper().readValue(jsonString, typeReference);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private static <T> T getObject(String jsonString, Class clase) {
    try {
      return (T) new ObjectMapper().readValue(jsonString, clase);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
