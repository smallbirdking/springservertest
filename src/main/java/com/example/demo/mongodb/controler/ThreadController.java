package com.example.demo.mongodb.controler;

import com.example.demo.mongodb.entity.thread.BrefThread;
import com.example.demo.mongodb.entity.thread.RecommendedThreadsResponse;
import com.example.demo.mongodb.entity.thread.Thread;
import com.example.demo.mongodb.entity.thread.ThreadResponse;
import com.example.demo.mongodb.service.RecommendedProviderService;
import com.example.demo.mongodb.service.ThreadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/thread")
public class ThreadController extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(ThreadController.class);

    @Autowired
    private ThreadService threadService;

    @Autowired
    private RecommendedProviderService recommendedProviderService;

    @RequestMapping("/find_userid")
    public List<Thread> findByUserId(Long userId) {
        return threadService.findByUserId(userId);
    }

    @RequestMapping("/find/threadid")
    public Thread findByThreadId(String threadId) {
        return threadService.findByThreadId(threadId);
    }


//    @RequestMapping(value= "/insert_thread/thread_content", method = RequestMethod.PUT)
//    public void saveThread(@RequestBody Thread thread) {
//        threadService.insertThread(thread);
//    }

    @RequestMapping(value = "/insert_thread/thread_content", method = RequestMethod.PUT)
    public ThreadResponse saveThread(@RequestBody Thread thread) throws ParseException {
        ThreadResponse response = new ThreadResponse();
        long userId = authenticate(response);
        if (userId>0) {
            //Thread thread = new Thread();
            thread.setCreatedUserId(userId);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", Locale.getDefault());
//            thread.setCreatedTime(thread.getCreatedTime());//sdf.parse(threadContent.getCreatedTime()));
//            thread.setTrBody(thread.getTrBody());
//            thread.setTrSubject(thread.getTrSubject());
            thread.setAdminList(Arrays.asList(userId));
//            thread.setImageList(thread.getImageList());
            threadService.insertThread(thread);
        }
        return response;
    }

    @RequestMapping(value = "/recommended/bref_thread", method = RequestMethod.GET)
    public RecommendedThreadsResponse collectRecommendedBriefThreads() {
      RecommendedThreadsResponse response = new RecommendedThreadsResponse();
      if (authenticate(response) > 0) {
        List<BrefThread> recommendedBriefThreads = recommendedProviderService.getRecommendedBriefThreads();
        for (BrefThread thread : recommendedBriefThreads) {

        }
        response.setRecommendedBriefThreads(recommendedBriefThreads);
      }
      return response;
    }



    @RequestMapping()
    public long defaultCall() {
      //Call the default method directly, or use the 'forward' String. Example:
      System.out.println("default method");
      return -1;
    }
}
