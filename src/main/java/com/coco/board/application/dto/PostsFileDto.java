package com.coco.board.application.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class PostsFileDto {

    private String memberId;
    private String title;
    private String content;
    private List<MultipartFile> files;
}
