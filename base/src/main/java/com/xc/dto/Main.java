package com.xc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) {


//        ProtocolGatherRepDTO protocolGatherRepDTO = new ProtocolGatherRepDTO();
//
//        protocolGatherRepDTO.setMessage("1").setData(new User().setId(2));
//
//        try {
//            String jsonString = new ObjectMapper().writeValueAsString(protocolGatherRepDTO);
//            System.out.println(jsonString);
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);

//        private int id ;
//        private int age ;
//        private String name;

        User user=new User();
        user.setId(11);
        try {
            String jsonString = objectMapper.writeValueAsString(user);
            System.out.println(jsonString);

//            String jsonString="{\"id\":11,\"name\":null,\"age\":11}";
//             jsonString="{\"name\":null,\"age\":11}";
////             jsonString="{\"id\":11}";
//            User user1 = new ObjectMapper().readValue(jsonString, User.class);
//            System.out.println(user1);
//            System.out.println(user1);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
