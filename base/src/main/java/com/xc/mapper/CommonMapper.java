package com.xc.mapper;

import com.xc.model.BizParamInfo;
import com.xc.model.RawMaterialParamModelItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommonMapper {


  @Select("select param_code as paramCode" +
      ",param_name as paramName" +
      ",id" +
      ",unit" +
      ",type" +
      ",category_code as categoryCode" +
      " from cds_biz_param where 1=1 and `type`='RAW_MATERIAL' " +
      "and param_Name=#{paramName}" +
      "limit 1 ")
  BizParamInfo getParamByName(BizParamInfo bizParamInfo);


  @Insert("${insertSql}")
  int saveBizParam(@Param("insertSql") String insertSql);

  @Insert("${updateSql}")
  int updateBizParam(@Param("updateSql") String insertSql);


  @Select("<script>" +
      "select " +
      "a.param_code as paramCode ," +
      "a.* from cds_raw_material_param_model_item a " +
      "where 1=1" +
      " <if test=\"id != null \" > and id = #{id} </if>" +
      " <if test=\"paramCode != null \" > and param_code = #{paramCode} </if>" +
      "</script>")
  @Results(@Result(property = "modelId", column = "model_id"))
  List<RawMaterialParamModelItem> getRawMaterialParamModelItem(RawMaterialParamModelItem rawMaterialParamModelItem);


  @Select("select 1 from dual")
  Integer getOneTest();


}
