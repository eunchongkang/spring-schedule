package spring.schedulejpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import spring.schedulejpa.dto.*;
import spring.schedulejpa.entity.Comment;
import spring.schedulejpa.entity.Schedule;
import spring.schedulejpa.repository.CommentRepository;
import spring.schedulejpa.repository.ScheduleRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(@RequestBody CommentSaveRequestDto commentSaveRequestDto) {
        Long scheduleId = commentSaveRequestDto.getScheduleid();
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NoSuchElementException("Id가 존재하지 않습니다."));

        Comment comment = new Comment(
                commentSaveRequestDto.getContent(),
                commentSaveRequestDto.getUsername(),
                schedule
        );

        Comment savedComment = commentRepository.save(comment);

        return new CommentSaveResponseDto(
                savedComment.getId(),
                savedComment.getContent(),
                savedComment.getUsername(),
                savedComment.getCreatedAt(),
                savedComment.getModifiedAt(),
                scheduleId
        );
    }

    public List<CommentAllResponseDto> getComment(String date) {
        LocalDateTime startTime = LocalDate.parse(date).atStartOfDay();
        LocalDateTime endTime = LocalDate.parse(date).atTime(LocalTime.MAX);

        List<Comment> commentList = commentRepository.findAllByCreatedAtBetweenOrderByModifiedAtDesc(startTime, endTime);

        List<CommentAllResponseDto> DtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentAllResponseDto AllResponseDto = new CommentAllResponseDto(
                    comment.getId(),
                    comment.getContent(),
                    comment.getUsername(),
                    comment.getCreatedAt(),
                    comment.getModifiedAt()
            );
            DtoList.add(AllResponseDto);
        }
        return DtoList;
    }

    public CommentDetailResponsDto getComments(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NoSuchElementException("Id가 존재하지 않습니다."));
                return new CommentDetailResponsDto(
                        comment.getId(),
                        comment.getContent(),
                        comment.getUsername(),
                        comment.getCreatedAt(),
                        comment.getModifiedAt()
        );
    }

    @Transactional
    public CommentUpdateResponseDto updateComment(Long commentId, CommentUpdateRequestDto commentUpdateRequestDto){
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NoSuchElementException("Id가 존재하지 않습니다."));

        comment.update(
                commentUpdateRequestDto.getContent(),
                commentUpdateRequestDto.getUsername()

        );

        return new CommentUpdateResponseDto(
                comment.getId(),
                comment.getContent(),
                comment.getUsername()
        );
    }

    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new NoSuchElementException("댓글이 존재하지 않습니다."));
            commentRepository.delete(comment);
    }

}
