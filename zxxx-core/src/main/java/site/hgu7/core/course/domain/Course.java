package site.hgu7.core.course.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import site.hgu7.common.annotation.Excel;
import site.hgu7.common.core.domain.BaseEntity;

/**
 * course对象 course
 *
 * @author hzm
 * @date 2024-10-27
 */
@Data
public class Course extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程id
 */
    private Integer courseId;

    /** 课程名
 */
    @Excel(name = "课程名 ")
    private String courseName;

    /** 课程简介
 */
    @Excel(name = "课程简介 ")
    private String courseDescription;

    /** 创建者id
 */
    @Excel(name = "创建者id ")
    private Long userId;

    /** 创建时间
 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间 ", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 更新时间
 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间 ", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    /** 讲师 */
    @Excel(name = "讲师")
    private String teacher;

    /** 课程分类 */
    @Excel(name = "课程分类")
    private String courseCategory;

    /** 课程封面 */
    @Excel(name = "课程封面")
    private String courseImg;

}
