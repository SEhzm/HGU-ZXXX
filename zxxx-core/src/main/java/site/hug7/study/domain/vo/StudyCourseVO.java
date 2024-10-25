package site.hug7.study.domain.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import site.hgu7.common.core.domain.BaseEntity;

/**
 * @author jlc
 * @date 2024/9/7 20:27
 */

@Schema(description = "课程列表")
@Data
public class StudyCourseVO extends BaseEntity {


    @Schema(description = "课程名称")
    private String name;

    @Schema(description = "课程类型")
    private String courseTypeName;

    @Schema(description = "课程图片")
    private String img;

    @Schema(description = "课程介绍")
    private String courseDesc;

    @Schema(description = "课程评价率")
    private String courseEvaluate;
}
