package site.hgu7.core.course.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import site.hgu7.common.annotation.Excel;
import site.hgu7.common.core.domain.BaseEntity;

/**
 * course_enrollments对象 course_enrollments
 * 
 * @author hzm
 * @date 2024-10-27
 */
@Data
public class CourseEnrollments extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 选课id */
    private Integer enrollmentId;

    /** 课程id */
    @Excel(name = "课程id")
    private Integer courseId;

//    课程名
    @Excel(name = "课程名")
    private String courseName;

    /** 创建者用户id */
    @Excel(name = "创建者用户id")
    private Long userId;

    /** 选课日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "选课日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date enrollmentDate;

    /** 章节id */
    @Excel(name = "章节id")
    private Integer chapterId;

    /** 课程状态 */
    @Excel(name = "课程状态")
    private String courseStatus;

}
