package com.xc.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;

public class JsonT<T>  {

    public static void main(String[] args) {


        ProtocolGatherRepDTO<User> protocolGatherRepDTO = new ProtocolGatherRepDTO();
        User user = new User().setId(1).setUser1(new User1().setId(11));
        user.setUser1List(Arrays.asList(new User1[]{new User1().setId(1111)}));
        protocolGatherRepDTO.setMessage("1").setData(user);
//
        try {
            String jsonString = new ObjectMapper().writeValueAsString(protocolGatherRepDTO);
            System.out.println(jsonString);


            ProtocolGatherRepDTO<User> protocolGatherRepDTO1 =
                    (ProtocolGatherRepDTO<User>) new ObjectMapper().
                            readValue(jsonString, ProtocolGatherRepDTO.class);


//            protocolGatherRepDTO1 = getProtocolGatherRepDTO1(jsonString);
            protocolGatherRepDTO1 = (ProtocolGatherRepDTO<User>) getProtocolGatherRepDTO1(jsonString
                    , new TypeReference<ProtocolGatherRepDTO<User>>() {
                    }
            );


            System.out.println(protocolGatherRepDTO1);
            System.out.println(protocolGatherRepDTO1.getData().getClass());
            System.out.println(protocolGatherRepDTO1.getData().getId());
            System.out.println(protocolGatherRepDTO1.getData().getUser1().getId());
            System.out.println(protocolGatherRepDTO1.getData().getUser1List().get(0).getId());

        } catch (Exception e) {
            e.printStackTrace();
        }


//        User user=new User();
//        user.setId(11);
//        try {
////            String jsonString = new ObjectMapper().writeValueAsString(user);
////            System.out.println(jsonString);
//
//            String jsonString="{\"id\":11,\"name\":null,\"age\":11}";
////             jsonString="{\"id\":11}";
//            User user1 = new ObjectMapper().readValue(jsonString, User.class);
//            System.out.println(user1);
//            System.out.println(user1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

    private static <T> T getProtocolGatherRepDTO1(String jsonString, TypeReference<T> typeReference) {
        try {
            return new ObjectMapper().readValue(jsonString, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
