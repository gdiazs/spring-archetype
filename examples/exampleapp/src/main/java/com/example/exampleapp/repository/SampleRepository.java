package com.example.exampleapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.exampleapp.domain.Sample;

@Repository
public interface SampleRepository extends CrudRepository<Sample, Long> {

}
