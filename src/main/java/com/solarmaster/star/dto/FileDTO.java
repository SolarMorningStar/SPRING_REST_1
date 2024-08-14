package com.solarmaster.star.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {
    private Integer fileId;
    private String fileType;
    private String fileName;
    private Long fileSize;
    private String fileExtension;
    private String url;
    private String contentType;
    private Integer createdBy;
    private Integer updatedBy;
    private Boolean isPublic;
    private Boolean isDeleted;
}
