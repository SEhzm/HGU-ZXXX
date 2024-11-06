package site.hgu7.core.course.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import site.hgu7.common.annotation.Excel;
import site.hgu7.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * course_chapters对象 course_chapters
 * 
 * @author hzm
 * @date 2024-10-27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseChapters extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 章节id */
    private Integer chapterId;

    /** 课程id */
    @Excel(name = "课程id")
    private Integer courseId;

    @Excel(name = "课程名")
    private String courseName;

    /** 章节标题 */
    @Excel(name = "章节标题")
    private String chapterTitle;

    /** 章节描述 */
    @Excel(name = "章节描述")
    private String chapterDescription;

    /** 视频链接 */
    @Excel(name = "视频链接")
    private String videoUrl;

    /** 章节顺序 */
    @Excel(name = "章节顺序")
    private String position;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("chapterId", getChapterId())
            .append("courseId", getCourseId())
            .append("chapterTitle", getChapterTitle())
            .append("chapterDescription", getChapterDescription())
            .append("videoUrl", getVideoUrl())
            .append("position", getPosition())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
