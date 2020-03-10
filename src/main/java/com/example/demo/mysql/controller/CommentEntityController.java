package com.example.demo.mysql.controller;

import com.example.demo.Util.AuthenUtil;
import com.example.demo.entity.ConstValue;
import com.example.demo.mongodb.entity.UserHeader;
import com.example.demo.mysql.entity.UserProfileEntity;
import com.example.demo.mysql.entity.comment.CommentDetail;
import com.example.demo.mysql.entity.comment.CommentEntity;
import com.example.demo.mysql.entity.comment.CommentReply;
import com.example.demo.mysql.entity.comment.CommentResponse;
import com.example.demo.mysql.entity.headportrait.HeadPortraitResponse;
import com.example.demo.mysql.service.CommentEntityService;
import com.example.demo.mysql.service.UserProfileEntityService;
import com.example.demo.mysql.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/comment")
public class CommentEntityController {

  @Autowired
  HttpServletRequest requestHeader;

  @Autowired
  private CommentEntityService commentEntityService;

  @Autowired
  private UserProfileEntityService userProfileEntityService;

  @Autowired
  private UserTokenService userTokenService;

  @GetMapping(value = "/find_comments_and_replies")
  public CommentResponse getCommentsAndReplies(@RequestParam("threadId") String threadId,@RequestParam("begin") int begin) {
    CommentResponse response = new CommentResponse();
    UserHeader userHeader = AuthenUtil.getUserHeader(requestHeader);
    long userId = userTokenService.verifyUserAuthen(userHeader, response);
    if (userId <= 0) {
      return response;
    }
    int primeCommentAmount = commentEntityService.getPrimeCommentAmount(threadId);
    if (primeCommentAmount > 0) {
      List<CommentEntity> primeComments = commentEntityService.findCommentsByThreadId(threadId, begin);
      List<CommentDetail> comments = Optional.ofNullable(primeComments)
          .orElseGet(Collections::emptyList)
          .stream()
          .filter(Objects::nonNull)
          .map(this::buildCommentWithReplies)
          .collect(Collectors.toList());
      response.setTotalAmount(primeCommentAmount);
      response.setCommentList(comments);
    }
    return response;
  }

  private CommentDetail buildCommentWithReplies(CommentEntity comment) {
    Stream<UserProfileEntity> userProfiles = userProfileEntityService.findByUserID(comment.getUserId());
    Optional<UserProfileEntity> userProfileEntity = userProfiles.findFirst();
    String nickName = ConstValue.DEF_NICK_NAME + comment.getUserId();
    String userLogo = "";
    if (userProfileEntity.isPresent()) {
      nickName = userProfileEntity.get().getNickName();
      userLogo = userProfileEntity.get().getHeadPortrait();
    }
    CommentDetail commentDetail = new CommentDetail(comment, nickName, userLogo);
    int subCommentAmount = commentEntityService.getSubCommentAmount(comment.getThreadId(), comment.getId());
    List<CommentEntity> subComments = commentEntityService.findSubCommentsByThreadId(comment.getThreadId(), comment.getId(), 0);
    if (subCommentAmount > 0) {
      List<CommentReply> replies = Optional.ofNullable(subComments)
          .orElseGet(Collections::emptyList)
          .stream()
          .filter(Objects::nonNull)
          .map(reply -> buildRepliy(reply, commentDetail.getNickName()))
          .collect(Collectors.toList());
      commentDetail.setReplyTotalAmount(subCommentAmount);
      commentDetail.setReplyList(replies);
    }
    return commentDetail;
  }

  private CommentReply buildRepliy(CommentEntity comment, String toReplyUserName) {
    Stream<UserProfileEntity> userProfiles = userProfileEntityService.findByUserID(comment.getUserId());
    Optional<UserProfileEntity> userProfileEntity = userProfiles.findFirst();
    String nickName = ConstValue.DEF_NICK_NAME + comment.getUserId();
    String userLogo = "";
    if (userProfileEntity.isPresent()) {
      nickName = userProfileEntity.get().getNickName();
      userLogo = userProfileEntity.get().getHeadPortrait();
    }
    CommentReply reply = new CommentReply(comment, nickName, userLogo);
    reply.setToReplyUserName(toReplyUserName);
    return reply;
  }
}