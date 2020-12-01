package com.xc.mapper;


import com.xc.model.SupplierProtocolGatherConfig;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.MySqlMapper;

//tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper
@Mapper
public interface SupplierProtocolGatherConfigMapper extends BaseMapper<SupplierProtocolGatherConfig>, MySqlMapper<SupplierProtocolGatherConfig> {


}
