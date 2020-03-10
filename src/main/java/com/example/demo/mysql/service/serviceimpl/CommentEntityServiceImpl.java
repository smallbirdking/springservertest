package com.example.demo.mysql.service.serviceimpl;

import com.example.demo.mysql.entity.comment.CommentEntity;
import com.example.demo.mysql.repository.CommentEntityRepository;
import com.example.demo.mysql.service.CommentEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("commentEntityService")
public class CommentEntityServiceImpl implements CommentEntityService {
    public static final int COMMENT_DEFAUT_SHOWING_NUMBER = 10;
    public static final int SUB_COMMENT_DEFAUT_SHOWING_NUMBER = 5;
    public static final int DELETE_STATUS = 2;
    public static final int NORMAL_STATUS = 1;
    @Autowired
    private CommentEntityRepository commentEntityRepository;
    @Override
    public List<CommentEntity> findCommentsByThreadId(String threadId, int begin) {
        return commentEntityRepository.findPrimeCommentByThreadID(threadId, begin, begin + COMMENT_DEFAUT_SHOWING_NUMBER);
    }

    @Override
    public List<CommentEntity> findSubCommentsByThreadId(String threadId, long lastCommentId, int begin) {
        return commentEntityRepository.findSubCommentByThreadID(threadId, lastCommentId, begin, begin+ SUB_COMMENT_DEFAUT_SHOWING_NUMBER);
    }

    @Override
    public Optional<CommentEntity> insertComment(CommentEntity comment) {
        CommentEntity commentEntity = commentEntityRepository.save(comment);
        return Optional.of(commentEntity);
    }

    @Override
    public int deleteComment(long commentId) {
        return commentEntityRepository.updateStatus(commentId, DELETE_STATUS);
    }

    @Override
    public int revertComment(long commentId) {
        return commentEntityRepository.updateStatus(commentId, NORMAL_STATUS);
    }

    @Override
    public int getPrimeCommentAmount(String threadId) {
        return commentEntityRepository.countPrimeCommentAmount(threadId);
    }

    @Override
    public int getSubCommentAmount(String threadId, long lastCommentId) {
        return commentEntityRepository.countSubCommentAmount(threadId, lastCommentId);
    }
}
