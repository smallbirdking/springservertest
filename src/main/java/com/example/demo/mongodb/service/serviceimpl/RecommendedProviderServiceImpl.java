package com.example.demo.mongodb.service.serviceimpl;

import com.example.demo.mongodb.entity.thread.BrefThread;
import com.example.demo.mongodb.service.RecommendedProviderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("recommendedProviderService")
public class RecommendedProviderServiceImpl implements RecommendedProviderService {

  @Override
  public List<BrefThread> getRecommendedBriefThreads() {
    return null;
  }
}
