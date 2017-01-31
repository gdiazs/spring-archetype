package com.example.exampleapp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exampleapp.domain.Sample;
import com.example.exampleapp.repository.SampleRepository;

@Service
public class SampleServiceImpl implements SampleService {


  private SampleRepository exampleappRepository;

  @Autowired
  public SampleServiceImpl(SampleRepository exampleappRepository) {
    this.exampleappRepository = exampleappRepository;
  }


  @Override
  public String getServiceName() {
    return this.getClass().getName();
  }


  @Override
  public Iterable<Sample> findAll() {
    return (Collection<Sample>) this.exampleappRepository.findAll();
  }

}
