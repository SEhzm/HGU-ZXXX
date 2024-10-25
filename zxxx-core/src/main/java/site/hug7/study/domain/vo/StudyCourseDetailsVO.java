package site.hug7.study.domain.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.hgu7.common.core.domain.BaseEntity;

/**
 * @author jlc
 * @date 2024/9/7 20:27
 */

@Schema(description = "课程章节详细信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyCourseDetailsVO extends BaseEntity {

    @Schema(description = "课程章节详情")
    private String courseDetails;

    @Schema(description = "课程id")
    private Integer courseId;

    @Schema(description = "课程视频地址")
    private String videoAddress;

    @Schema(description = "章节标题")
    private String chapterTitle;

    @Schema(description = "章节浏览量")
    private Integer chapterView;

    @Schema(description = "章节评价率")
    private String chapterEvaluate;
}
