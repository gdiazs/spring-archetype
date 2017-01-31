package com.example.exampleapp.service;

import com.example.exampleapp.domain.Sample;

public interface SampleService {

  public String getServiceName();

  public Iterable<Sample> findAll();
}
