package com.example.demo.utils;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    public static <E> List<E> mutableEmptyIfNull(List<E> list){
        if(CollectionUtils.isEmpty(list)){
            return new ArrayList<>();
        }
        return list;
    }
}
