package com.example.demo.mysql.service;

import com.example.demo.mysql.entity.CommentEntity;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<CommentEntity> findCommentsByThreadId(String threadId, int begin);

    List<CommentEntity> findSubCommentsByThreadId(String threadId, long lastCommentId, int begin);

    Optional<CommentEntity> insertComment(CommentEntity comment);

    int deleteComment(long commentId);

    int revertComment(long commentId);
}
