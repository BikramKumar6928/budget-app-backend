package com.example.demo.mapper;

/**
 * Mapper interface
 * @param <MF> - Map from type
 * @param <MT> - Map to type
 */
public interface MapperInterface<MF, MT> {
    MT map(MF mapFromType);

    MF reverseMap(MT mapToType);
}
