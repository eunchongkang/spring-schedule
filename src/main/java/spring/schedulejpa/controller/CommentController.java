package spring.schedulejpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.schedulejpa.dto.*;
import spring.schedulejpa.entity.Comment;
import spring.schedulejpa.service.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments")
    public CommentSaveResponseDto saveComment(@RequestBody CommentSaveRequestDto commentSaveRequestDto){
        return commentService.saveComment(commentSaveRequestDto);
    }

    @GetMapping("/comments")
    public List<CommentAllResponseDto> getComment(@RequestParam String date){
        return commentService.getComment(date);
    }

    @GetMapping("/comments/{commentId}")
    public CommentDetailResponsDto getComments(@PathVariable Long commentId){
        return commentService.getComments(commentId);
    }

    @PutMapping("/comments/{commentId}")
    public CommentUpdateResponseDto updateComment(@PathVariable Long commentId,
                                                  @RequestBody CommentUpdateRequestDto commentUpdateRequestDto){
        return commentService.updateComment(commentId, commentUpdateRequestDto);
    }

    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId,
                              @RequestBody CommentDeleteRequestDto commentdeleteRequestDto){
        commentService.deleteComment(commentId, commentdeleteRequestDto);
    }
}
