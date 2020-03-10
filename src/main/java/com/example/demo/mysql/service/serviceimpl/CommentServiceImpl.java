package com.example.demo.mysql.service.serviceimpl;

import com.example.demo.mysql.entity.comment.CommentEntity;
import com.example.demo.mysql.repository.CommentEntityRepository;
import com.example.demo.mysql.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentEntityRepository commentEntityRepository;
    @Override
    public List<CommentEntity> findCommentsByThreadId(String threadId, int begin) {
        List<CommentEntity> primeComments = commentEntityRepository.findPrimeCommentByThreadID(threadId, begin, begin + 10);
        for (CommentEntity commentEntity : primeComments) {
            List<CommentEntity> subComments = commentEntityRepository.findSubCommentByThreadID(threadId, commentEntity.getLastCommentId(), begin, begin + 10);
        }
        return null;
    }

    @Override
    public List<CommentEntity> findSubCommentsByThreadId(String threadId, long lastCommentId, int begin) {
        return commentEntityRepository.findSubCommentByThreadID(threadId, lastCommentId, begin, begin+10);
    }

    @Override
    public Optional<CommentEntity> insertComment(CommentEntity comment) {
        CommentEntity commentEntity = commentEntityRepository.save(comment);
        return Optional.of(commentEntity);
    }

    @Override
    public int deleteComment(long commentId) {
        return commentEntityRepository.updateStatus(commentId, 2);
    }

    @Override
    public int revertComment(long commentId) {
        return commentEntityRepository.updateStatus(commentId, 1);
    }

    @Override
    public Long getPrimeCommentAmount(String threadId) {
        return commentEntityRepository.countPrimeCommentAmount(threadId);
    }

    @Override
    public Long getSubCommentAmount(String threadId, long lastCommentId) {
        return commentEntityRepository.countSubCommentAmount(threadId, lastCommentId);
    }
}
