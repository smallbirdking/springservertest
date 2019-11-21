package com.example.demo.mongodb.service;

import com.example.demo.mongodb.entity.thread.BrefThread;

import java.util.List;

public interface RecommendedProviderService {
  List<BrefThread> getRecommendedBriefThreads();

}
