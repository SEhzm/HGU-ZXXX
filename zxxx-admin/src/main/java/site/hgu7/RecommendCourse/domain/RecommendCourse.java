package site.hgu7.RecommendCourse.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import site.hgu7.common.annotation.Excel;
import site.hgu7.common.core.domain.BaseEntity;


/**
 * 首页推荐课的课程id对象 recommend_course
 * 
 * @author hzm
 * @date 2024-11-06
 */
public class RecommendCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "id")
    private Long recommendId;

    /** 推荐课的课程id */
    @Excel(name = "推荐课的课程id")
    private Long recommendCourseId;

    public void setRecommendId(Long recommendId) 
    {
        this.recommendId = recommendId;
    }

    public Long getRecommendId() 
    {
        return recommendId;
    }
    public void setRecommendCourseId(Long recommendCourseId) 
    {
        this.recommendCourseId = recommendCourseId;
    }

    public Long getRecommendCourseId() 
    {
        return recommendCourseId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recommendId", getRecommendId())
            .append("recommendCourseId", getRecommendCourseId())
            .toString();
    }
}
