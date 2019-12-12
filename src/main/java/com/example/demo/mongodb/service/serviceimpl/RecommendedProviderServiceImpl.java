package com.example.demo.mongodb.service.serviceimpl;

import com.example.demo.mongodb.dao.ThreadDao;
import com.example.demo.mongodb.entity.thread.BrefThread;
import com.example.demo.mongodb.entity.thread.Thread;
import com.example.demo.mongodb.service.RecommendedProviderService;
import com.example.demo.mysql.entity.UserEntity;
import com.example.demo.mysql.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("recommendedProviderService")
public class RecommendedProviderServiceImpl implements RecommendedProviderService {

  @Autowired
  private ThreadDao threadDao;

  @Autowired
  private UserEntityService userEntityService;

  @Override
  public List<BrefThread> getRecommendedBriefThreads() {

    List<Thread> threads = threadDao.collectRecommendedBriefThreads(10);

    List<BrefThread> brefThreads = new ArrayList<>();

    for (Thread thread : threads) {
      BrefThread brefThread = new BrefThread();
      brefThread.setCreatedUserId(thread.getCreatedUserId());
      brefThread.setThreadId(thread.getId());
      brefThread.setTrSubject(thread.getTrSubject());
      brefThread.setImageList(thread.getImageList());
      brefThread.setCreatedTime(thread.getCreatedTime());
      brefThread.setHeat(thread.getHeat());

      Optional<UserEntity> byUserId = userEntityService.findByUserId(Long.valueOf(thread.getCreatedUserId()));
      if (byUserId.isPresent()) {
        brefThread.setCreatedUserName(byUserId.get().getUserName());
      }
      brefThreads.add(brefThread);
    }
    return brefThreads;
  }
}
