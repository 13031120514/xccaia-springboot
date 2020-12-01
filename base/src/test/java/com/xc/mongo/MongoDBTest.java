package com.xc.mongo;


import com.xc.dto.Student;
import com.xc.mongo.DynamicRepository;
import com.xc.mongo.MongoCondition;
import com.xc.mongo.QueryParam;
import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class MongoDBTest {


    @Autowired
    private MongoOperations mongoOperations;
    @Resource
    private DynamicRepository dynamicRepository;

    @Test
    public void test0() {
        Student student = new Student(1, 18);

        XcDocumnet xc = new XcDocumnet();
        xc.age = 18;
        xc.name = "xccaia";
        xc.student = student;
        System.out.println(student);
        mongoOperations.save(xc);
//        Student student = dynamicRepository.queryOne(XcDocumnet.class, "XcDocumnet");


    }

    @Test
    public void test1() {
        QueryParam queryParam = new QueryParam("name", "xccaia");
        List<QueryParam> params = Lists.newArrayList();
        params.add(queryParam);
//        Map map = dynamicRepository.queryOne(params, Map.class, "user");
        XcDocumnet xcDocumnet = dynamicRepository.queryOne(params, XcDocumnet.class, "xcDocumnet");
        System.out.println(xcDocumnet);
    }

    @Test
    public void test11() {
        QueryParam queryParam = new QueryParam("name", "xccaia");
        List<QueryParam> params = Lists.newArrayList();
        params.add(queryParam);
//        Map map = dynamicRepository.queryOne(params, Map.class, "user");
        Map xcDocumnet = dynamicRepository.queryOne(params, Map.class, "xcDocumnet");
        System.out.println(xcDocumnet.get("student"));
        System.out.println(xcDocumnet.get("student") instanceof Student);
    }


    @Test
    public void test2() {
        QueryParam queryParam = new QueryParam("_id", 2);
        List<QueryParam> params = Lists.newArrayList();
        params.add(queryParam);
//        Map map = dynamicRepository.queryOne(params, Map.class, "user");
        Student student = dynamicRepository.queryOne(params, Student.class, "student");
//        if (map != null) {
//            return map.get(MONGO_METADATA.ATTRIBUTES);
//        }
        System.out.println(student);
    }

    @Test
    public void addStudent() {
        Student student = new Student();
        student.setId(3);
        student.setAge(34);
        System.out.println("0000000000");
        System.out.println("0000000000");
        System.out.println("0000000000");
        mongoOperations.save(student);
        System.out.println("111111111111111");
        System.out.println("111111111111111");
        System.out.println("111111111111111");
        List<QueryParam> queryParams = new ArrayList<>();

        queryParams.add(new QueryParam("_id", 11));
        Query query = new Query();
        List<Map> mapList = this.mongoOperations.find(query, Map.class, "student");
        System.out.println(mapList);

        if (CollectionUtils.isNotEmpty(queryParams)) {
            Criteria criteria = new Criteria();
            queryParams.forEach(queryParam -> MongoCondition.execute(criteria, queryParam));
            query.addCriteria(criteria);
        }
        System.out.println("------------");
        mapList = this.mongoOperations.find(query, Map.class, "student");

        System.out.println(mapList);

    }
}
