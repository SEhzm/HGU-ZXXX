package site.hgu7.FineCourse.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import site.hgu7.common.annotation.Excel;
import site.hgu7.common.core.domain.BaseEntity;


/**
 * 精品课的课程id对象 fine_course
 * 
 * @author hzm
 * @date 2024-11-06
 */
public class FineCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "id")
    private Long fineId;

    /** 精品课的课程id */
    @Excel(name = "精品课的课程id")
    private Long findCourseId;

    public void setFineId(Long fineId) 
    {
        this.fineId = fineId;
    }

    public Long getFineId() 
    {
        return fineId;
    }
    public void setFindCourseId(Long findCourseId) 
    {
        this.findCourseId = findCourseId;
    }

    public Long getFindCourseId() 
    {
        return findCourseId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fineId", getFineId())
            .append("findCourseId", getFindCourseId())
            .toString();
    }
}
