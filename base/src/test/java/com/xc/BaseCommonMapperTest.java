package com.xc;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xc.enums.*;
import com.xc.mapper.*;
import com.xc.model.*;
import net.minidev.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class BaseCommonMapperTest {


  @Autowired
  private CommonMapper commonMapper;
  @Autowired
  private RawMaterialParamModelMapper rawMaterialParamModelMapper;
  @Autowired
  private RawMaterialParamModelItemMapper rawMaterialParamModelItemMapper;
  @Autowired
  private BizParamMapper bizParamMapper;
  @Autowired
  private SupplierProtocolGatherConfigItemMapper supplierProtocolGatherConfigItemMapper;
  @Autowired
  private SupplierProtocolGatherConfigMapper supplierProtocolGatherConfigMapper;

  @Autowired
  private SupplierRawMaterialParamConfigItemMapper supplierRawMaterialParamConfigItemMapper;
  @Autowired
  private SupplierRawMaterialParamConfigMapper supplierRawMaterialParamConfigMapper;


  @Test
  public void getSaveBizParam() {

    BizParam bizParam = new BizParam();

    bizParam.setVersion(1);
    bizParam.setParamCode("xccaia");
    bizParam.setParamDataType(DataType.NUMBER);
    bizParam.setType(BizParamType.EXPERIMENT);
    bizParam.setCreatedBy("xccaia");
    int insert = bizParamMapper.insert(bizParam);
    System.out.println(insert);
    System.out.println(bizParam);
    BizParam bizParam1 = bizParamMapper.selectOne(bizParam);
    System.out.println(bizParam1);
    bizParam1.setCategoryCode("xccaai");
    bizParamMapper.updateByPrimaryKey(bizParam1);

  }


  @Test
  public void getRawMaterialParamModel() {
    RawMaterialParamModel rawMaterialParamModel = new RawMaterialParamModel();
    rawMaterialParamModel.setId(2L);
    RawMaterialParamModel rawMaterialParamModel1 = rawMaterialParamModelMapper.selectOne(rawMaterialParamModel);
    System.out.println(rawMaterialParamModel1);
    System.out.println(rawMaterialParamModel1);
  }


  @Test
  public void getRawMaterialParamModelItem() {
    RawMaterialParamModelItem rawMaterialParamModelItem = new RawMaterialParamModelItem();
//        rawMaterialParamModelItem.setId(2L);
    rawMaterialParamModelItem.setModelId(4L);
    List<RawMaterialParamModelItem> rawMaterialParamModelItemList = rawMaterialParamModelItemMapper.select(rawMaterialParamModelItem);
    System.out.println(rawMaterialParamModelItemList);
    System.out.println(rawMaterialParamModelItemList.size());
  }


  @Test
  public void getData1111() throws Exception {

    RawMaterialParamModelItem rawMaterialParamModelItem = new RawMaterialParamModelItem();
    rawMaterialParamModelItem.setId(471L);
    RawMaterialParamModelItem rawMaterialParamModelItem1 = rawMaterialParamModelItemMapper.selectOne(rawMaterialParamModelItem);

    System.out.println(rawMaterialParamModelItem1);
    rawMaterialParamModelItem1.setId(null);
    rawMaterialParamModelItemMapper.insert(rawMaterialParamModelItem1);

  }


  @Test
  public void rawMaterialParamModelList() {
    List<RawMaterialParamModel> list = rawMaterialParamModelMapper.select(
        new RawMaterialParamModel()
            .setId(2L));

    System.out.println(list.size());
    System.out.println(list.size());

//        System.out.println(new RawMaterialParamCodeTest().testPinyinInitial("下次"));
//        System.out.println(new RawMaterialParamCodeTest().testPinyinInitial("中国"));

    list = rawMaterialParamModelMapper.selectAll();
    System.out.println(list.size());
    System.out.println(list.size());

    list = rawMaterialParamModelMapper.select(
        new RawMaterialParamModel()
            .setId(211111L));
    System.out.println(list.size());
    System.out.println(list.size());

    list = rawMaterialParamModelMapper.select(
        new RawMaterialParamModel()
            .setCategoryCode("10004"));
    System.out.println(list.size());
    System.out.println(list.size());

    list = rawMaterialParamModelMapper.select(
        new RawMaterialParamModel());
    System.out.println(list.size());
    System.out.println(list.size());
//        list = rawMaterialParamModelMapper.select();

  }

  @Test
  public void testSupplierProtocolGatherConfigItemMapper() {

    int rowNum = 0;

    SupplierProtocolGatherConfig supplierProtocolGatherConfig = new SupplierProtocolGatherConfig();
    supplierProtocolGatherConfig.setCategoryCode("222");
    rowNum = supplierProtocolGatherConfigMapper.insert(supplierProtocolGatherConfig);

    System.out.println(rowNum);

    SupplierProtocolGatherConfigItem supplierProtocolGatherConfigItem = new SupplierProtocolGatherConfigItem();

    supplierProtocolGatherConfigItem.setProtocolKey("test");

    rowNum = supplierProtocolGatherConfigItemMapper.insert(supplierProtocolGatherConfigItem);

    System.out.println(rowNum);

  }


  @Test
  public void testSupplierProtocolGatherConfigMapper() {

    SupplierProtocolGatherConfig supplierProtocolGatherConfig = new SupplierProtocolGatherConfig();
    supplierProtocolGatherConfig.setProtocolId("1");
    supplierProtocolGatherConfig = supplierProtocolGatherConfigMapper.selectOne(supplierProtocolGatherConfig);
    System.out.println(supplierProtocolGatherConfig);
    supplierProtocolGatherConfig.setCycle("1234567");
    supplierProtocolGatherConfig.setAmount("11");
    int i = supplierProtocolGatherConfigMapper.updateByPrimaryKeySelective(supplierProtocolGatherConfig);

    System.out.println(i);
    System.out.println(i);
    System.out.println(i);
//        int rowNum = 0;
//        SupplierProtocolGatherConfig supplierProtocolGatherConfig = new SupplierProtocolGatherConfig();
//        supplierProtocolGatherConfig.setCategoryCode("222");
//        System.out.println("1111111111111111111111");
//        System.out.println(supplierProtocolGatherConfig.getId());
//        System.out.println(supplierProtocolGatherConfig.getId());
//        rowNum = supplierProtocolGatherConfigMapper.insert(supplierProtocolGatherConfig);

//        System.out.println(rowNum);
//        System.out.println(supplierProtocolGatherConfig.getId());
//        System.out.println(supplierProtocolGatherConfig.getId());
//        supplierProtocolGatherConfig = new SupplierProtocolGatherConfig();
//        supplierProtocolGatherConfig.setCategoryCode("22211");
//        rowNum = supplierProtocolGatherConfigMapper.insertUseGeneratedKeys(supplierProtocolGatherConfig);
//        System.out.println(rowNum);
//        System.out.println(supplierProtocolGatherConfig.getId());

//        SupplierProtocolGatherConfigItem supplierProtocolGatherConfigItem = new SupplierProtocolGatherConfigItem();
//
//        supplierProtocolGatherConfigItem.setProtocolKey("test");
//
//        rowNum = supplierProtocolGatherConfigItemMapper.insert(supplierProtocolGatherConfigItem);
//
//        System.out.println(rowNum);

  }


  @Test
  public void get111() {

    List<SupplierProtocolGatherConfigItem> list = supplierProtocolGatherConfigItemMapper.getListByModleId(4);
    System.out.println(list.size());
    System.out.println(list.size());

    String requesttString = null;
    try {
      requesttString = new ObjectMapper().writeValueAsString(list);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    System.out.println(requesttString);
  }

  @Autowired
  SupplierInformationTimelyMapper supplierInformationTimelyMapper;

  @Test
  public void getsupplierInformationTimelyMapper() {

    List<SupplierInformationTimely> list = supplierInformationTimelyMapper.selectAll();
    list.forEach(info -> System.out.println(info));

  }

}
