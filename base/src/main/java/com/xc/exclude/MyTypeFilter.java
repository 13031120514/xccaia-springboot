package com.xc.exclude;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @Author: xiaochuan.cai
 * @Date: 2020/12/1
 * @Description:
 */
public class MyTypeFilter implements TypeFilter {

  @Override
  public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactony)
      throws IOException {
    ClassMetadata classMetadata = metadataReader.getClassMetadata();
    String className = classMetadata.getClassName();
    System.out.println("className --> ** + className");
    if (className.contains("com.sgcc.eip.cmc.cable.acquisition.listener") ||
        className.contains("com.sgcc.eip.cmc.cable.acquisition.job")) {
      System.out.println("exclude java file is " + className);
      return true;
    }
    return false;

  }
}
