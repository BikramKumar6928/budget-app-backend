package com.example.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper interface
 * @param <MF> - Map from type
 * @param <MT> - Map to type
 */
public interface MapperInterface<MF, MT> {
    MT map(MF mapFromType);

    default List<MT> mapList(List<MF> mapToType){
        return mapToType.stream().map(this::map).collect(Collectors.toList());
    }

    MF reverseMap(MT mapToType);

    default List<MF> reverseMapList(List<MT> mapToType){
        return mapToType.stream().map(this::reverseMap).collect(Collectors.toList());

    }
}
