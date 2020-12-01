package com.xc.mapper;


import com.xc.model.SupplierProtocolGatherConfigItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;


@Mapper
public interface SupplierProtocolGatherConfigItemMapper extends BaseMapper<SupplierProtocolGatherConfigItem> {

    @Select("\t\tSELECT\n" +
            "\t\t\ta.id\n" +
            "\t\t\t,a.model_id as `modelId`\n" +
            "\t\t\t,a.pivotal\n" +
            "\t\t\t,a.collect_mode\n" +
            "\t\t\t,a.required as `nullable`\n" +
            "\t\t\t,b.param_code as `protocolKey`\n" +
            "\t        ,b.param_name as `protocolKeyDesc`\n" +
            "\t        ,b.param_data_type as `protocolValueType`\n" +
            "\t\tFROM\n" +
            "\t\t\tcds_raw_material_param_model_item a\n" +
            "-- \t\t\tcds_supplier_raw_material_param_config_item a\n" +
            "\t\t\tleft outer join cds_biz_param b on a.param_code=b.param_code\n" +
            "\t\t\tand type='RAW_MATERIAL'\n" +
            "\t\tWHERE\n" +
            "\t\t\tmodel_id =  #{modelId}" +
            "\t\t\tlimit 2" +
            "")
    List<SupplierProtocolGatherConfigItem> getListByModleId(@Param("modelId") int modelId);

}
