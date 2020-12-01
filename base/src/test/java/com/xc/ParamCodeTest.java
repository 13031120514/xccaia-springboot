//package com.xc;
//
//
//import com.xc.enums.BizParamType;
//import com.xc.enums.DataCollectMode;
//import com.xc.enums.DataType;
//import com.xc.mapper.BizParamMapper;
//import com.xc.mapper.CommonMapper;
//import com.xc.mapper.RawMaterialParamModelItemMapper;
//import com.xc.mapper.RawMaterialParamModelMapper;
//import com.xc.model.BizParam;
//import com.xc.model.BizParamInfo;
//import com.xc.model.RawMaterialParamModel;
//import com.xc.model.RawMaterialParamModelItem;
//import net.sourceforge.pinyin4j.PinyinHelper;
//import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
//import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
//import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
//import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.util.Date;
//import java.util.List;
//
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//public class ParamCodeTest {
//
//    @Autowired
//    private CommonMapper commonMapper;
//    @Autowired
//    private RawMaterialParamModelMapper rawMaterialParamModelMapper;
//    @Autowired
//    private RawMaterialParamModelItemMapper rawMaterialParamModelItemMapper;
//    @Autowired
//    private BizParamMapper bizParamMapper;
//
//
//    @Test
//    public void getData() throws Exception {
//        File file = new File("C:\\Users\\EDZ\\Desktop\\aa\\" +
////                "8-1.供应商生产试验数据采集表-中压电缆-20200906-v2.1 - 副本" +
//                "8-2.供应商生产试验数据采集表-高压电缆-20200906-v2.1 - 副本" +
//                ".xlsx");
//        System.out.println(file.exists());
//
//        InputStream stream = null;
//        Workbook xssfWorkbook = null;
//        String projecttype = "";
//        String infoName = "";
//        String paramName = "";
//        String paramCode = "";
//        Long moudleId = null;
//        //获取输入流
//        try {
//            stream = new FileInputStream(file);
//            xssfWorkbook = new XSSFWorkbook(stream);
//            Sheet Sheet = xssfWorkbook.getSheetAt(0);
//            int rowNum = Sheet.getLastRowNum();
//            for (int i = 4; i <= rowNum; i++) {
//                Row row = Sheet.getRow(i);
//                projecttype = "".equals(row.getCell(1).getStringCellValue()) ? projecttype : row.getCell(1).getStringCellValue();
//                infoName = "".equals(row.getCell(2).getStringCellValue()) ? infoName : row.getCell(2).getStringCellValue();
//                paramName = row.getCell(4).getStringCellValue();
//                paramCode = testPinyinInitial(paramName);
//                String strIndex = getCellValue((XSSFCell) row.getCell(3));
//                String unit=null;
//
//                if (null != projecttype & !"".equals(projecttype)
//                        && !"原材料、组部件检验".equals(projecttype)) {
//                    continue;
//                }
//
//                System.out.println("type:"+ projecttype + " infoName:" + infoName + " strIndex:" + strIndex
//                        + " paramName:" + paramName + " unit:"+unit);
//
//                String categoryCode = "10002";
//
//                RawMaterialParamModel search0 = new RawMaterialParamModel();
//                search0.setInfoName(infoName);
//                search0.setCategoryCode(categoryCode);
//                RawMaterialParamModel rawMaterialParamModel1 = rawMaterialParamModelMapper.selectOne(search0);
//                if (rawMaterialParamModel1 != null) {
//                    moudleId=rawMaterialParamModel1.getId();
//                    System.out.println("infoName 存在 :" + infoName);
//                } else {
//                    // 插入信息名称 RawMaterialParamModel infoName
//                    System.out.println("infoName 不存在 开始插入 :" + infoName);
//                    RawMaterialParamModel rawMaterialParamModel0 = new RawMaterialParamModel();
//                    rawMaterialParamModel0.setVersion(1);
//                    rawMaterialParamModel0.setCategoryCode(categoryCode);
//                    rawMaterialParamModel0.setInfoCode(testPinyinInitial(infoName));
//                    rawMaterialParamModel0.setInfoName(infoName);// 信息名称
//                    // TODO 数据量 ?
////                    rawMaterialParamModel0.setParamNumber();// 数据项数量
//                    rawMaterialParamModel0.setCreatedBy("caixiaochuan");
//                    rawMaterialParamModel0.setCreatedTime(new Date());
//                    int insert = rawMaterialParamModelMapper.insert(rawMaterialParamModel0);
//
//                    rawMaterialParamModel0=rawMaterialParamModelMapper.selectOne(rawMaterialParamModel0);
//                    moudleId=rawMaterialParamModel0.getId();
//                    System.out.println("insert rawMaterialParamModelMapper.insert(rawMaterialParamModel0):" + insert);
//                    System.out.println("infoName 不存在 完成插入 :" + infoName);
//
//                }
//
//                BizParam search = new BizParam();
//                search.setParamName(paramName);
//                search.setType(BizParamType.RAW_MATERIAL);// 原材料
////                search.setCategoryCode(categoryCode);// 全是空
//                List<BizParam> bizParamList = bizParamMapper.select(search);
//                if (bizParamList != null) {
//                    BizParam bizParam0= bizParamList.get(0);
//                    paramCode=bizParam0.getParamCode();
//                    System.out.println("paramName 存在 :" + paramName);
//                    // 查看单位
////                    if(unit !=null && !unit.equals(bizParam0.getUnit())){
////                        // 不一致,更新单位
////                        bizParam0.setUnit(unit);
////                        bizParamMapper.updateByPrimaryKey(bizParam0);
////                    }
//                } else {
//                    System.out.println("paramName 不存在 :" + paramName);
//                    BizParam insertInfo = new BizParam();
//                    insertInfo.setVersion(1);
//                    insertInfo.setParamName(paramName);
//                    insertInfo.setParamCode(paramCode);
//                    // TODO 数据类型
//                    insertInfo.setParamDataType(DataType.NUMBER);
//                    insertInfo.setType(BizParamType.RAW_MATERIAL);
//                    insertInfo.setCreatedBy("caixiaochuan");
//                    insertInfo.setCreatedTime(new Date());
//                    bizParamMapper.insert(insertInfo);
//                    System.out.println("paramName 不存在 完成插入 :" + paramName);
//
//                }
//
//                RawMaterialParamModelItem rawMaterialParamModelItemSearch = new RawMaterialParamModelItem();
//                rawMaterialParamModelItemSearch.setParamCode(paramCode);
//                rawMaterialParamModelItemSearch.setModelId(moudleId);
//                List<RawMaterialParamModelItem> rawMaterialParamModelItemList = rawMaterialParamModelItemMapper.select(rawMaterialParamModelItemSearch);
//                if (rawMaterialParamModelItemList == null) {
//
//                    System.out.println("rawMaterialParamModelItem paramName 不存在 开始插入 :" + paramName);
//
//
//                    RawMaterialParamModelItem rawMaterialParamModelItem0= new RawMaterialParamModelItem();
//                    rawMaterialParamModelItem0.setParamCode(paramCode);
//                    rawMaterialParamModelItem0.setModelId(moudleId);
//                    // TODO 数据暂时没取到
////                    rawMaterialParamModelItem0.setPivotal();
////                    rawMaterialParamModelItem0.setRequired();
//                    rawMaterialParamModelItem0.setCollectMode(DataCollectMode.MANUAL);
//                    rawMaterialParamModelItemMapper.insert(rawMaterialParamModelItem0);
//                    System.out.println("rawMaterialParamModelItem paramName 不存在 完成插入 :" + paramName);
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Test
//    public void get1111111111111111111() {
//
//
////        RawMaterialParamModel
////        List<RawMaterialParamModel> list = rawMaterialParamModelMapper.select(
////                new RawMaterialParamModel()
////                        .setId(2L));
////
////        System.out.println(list);
////        System.out.println(list);
//
////        String paramCode = "xccaai";
////        String saveParrmCodeSql = getSaveRawMaterialParamModelItemSql(paramCode,null);
////
////        int i = commonMapper.saveBizParam(saveParrmCodeSql);
////        System.out.println(i);
//
//        System.out.println(testPinyinInitial("下次"));
//        System.out.println(testPinyinInitial("中国"));
//        System.out.println(testPinyinInitial("行业"));
//
//
//    }
//
//    private String getSaveRawMaterialParamModelItemSql(String paramCode, Integer moudle_id) {
//        String saveSql = "INSERT INTO cds_raw_material_param_model_item\n" +
//                "(id, model_id, param_code, required, pivotal, collect_mode, remark, created_by, created_time, updated_by, updated_time)\n" +
//                "VALUES(null, " + moudle_id + ", '" + paramCode + "', 1, 1, 'MANUAL', NULL, \"caixiaochuan\", now(), NULL, now());";
//        return saveSql;
//    }
//
//
//    @Test
//    public void getBizParambyName() {
////        BizParam paramByName = commonMapper.getParamByName("色散系数");
////        BizParam paramByName = commonMapper.getParamByName(new BizParam().setParamName("色散系数"));
////        System.out.println(paramByName);
//        List<RawMaterialParamModelItem> list;
//        list = commonMapper.getRawMaterialParamModelItem
//                (new RawMaterialParamModelItem()
//                        .setId(471L)
//                        .setParamCode("DZL")
//                );
//        System.out.println(list);
//        System.out.println(list);
//        System.out.println(list);
//        System.out.println(list);
//
//    }
//
//
//    @Test
//    public void getOneTest() {
//        System.out.println(commonMapper.getOneTest());
//    }
//
//
//    public static String getCellValue(XSSFCell cell) {
//        if (cell == null) return "";
//        if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
//            return cell.getStringCellValue();
//        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
//            return String.valueOf(cell.getBooleanCellValue());
//        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
//            return cell.getCellFormula();
//        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
//            return String.valueOf(cell.getNumericCellValue());
//        }
//        return "";
//
//    }
//
//    /**
//     * 获取中文首字母大写
//     *
//     * @param name
//     * @throws BadHanyuPinyinOutputFormatCombination
//     */
//    public String testPinyinInitial(String name) {
////        String name = "中文拼音";
//        try {
//            char[] charArray = name.toCharArray();
//            StringBuilder pinyin = new StringBuilder();
//            HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
//            // 设置大小写格式
//            defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
//            // 设置声调格式：
//            defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
//            for (int i = 0; i < charArray.length; i++) {
//                // 匹配中文,非中文转换会转换成null
//                if (Character.toString(charArray[i]).matches("[\\u4E00-\\u9FA5]+")) {
//                    String[] hanyuPinyinStringArray = PinyinHelper
//                            .toHanyuPinyinStringArray(charArray[i], defaultFormat);
//                    if (hanyuPinyinStringArray != null) {
//                        pinyin.append(hanyuPinyinStringArray[0].charAt(0));
//                    }
//                }
//            }
////            System.err.println(pinyin);
//            return pinyin.toString();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
////结果
//
////    @Test
////    public void monthExecute() {
////        List<User> users = userMapper.GetUserbyId(1);
////        System.out.println(users);
////    }
////    @Test
////    public void getOneTest() {
////        System.out.println(userMapper.getOneTest());
////        System.out.println(userMapper.getOneTest());
////        System.out.println(userMapper.getOneTest());
////    }
//
//}
