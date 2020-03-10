package com.example.demo.mysql.service;

import com.example.demo.mysql.entity.comment.CommentEntity;

import java.util.List;
import java.util.Optional;

public interface CommentEntityService {
    List<CommentEntity> findCommentsByThreadId(String threadId, int begin);

    List<CommentEntity> findSubCommentsByThreadId(String threadId, long lastCommentId, int begin);

    Optional<CommentEntity> insertComment(CommentEntity comment);

    int deleteComment(long commentId);

    int revertComment(long commentId);

    int getPrimeCommentAmount(String threadId);

    int getSubCommentAmount(String threadId, long lastCommentId);
}
