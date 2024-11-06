package site.hgu7.CaruCourse.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import site.hgu7.common.annotation.Excel;
import site.hgu7.common.core.domain.BaseEntity;

/**
 * 首页轮播图展示的课程id对象 caru_course
 * 
 * @author hzm
 * @date 2024-11-06
 */
public class CaruCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long caruId;

    /** 轮播图课程id */
    @Excel(name = "轮播图课程id")
    private Long CaruCourseId;

    public void setCaruId(Long caruId) 
    {
        this.caruId = caruId;
    }

    public Long getCaruId() 
    {
        return caruId;
    }
    public void setCaruCourseId(Long CaruCourseId) 
    {
        this.CaruCourseId = CaruCourseId;
    }

    public Long getCaruCourseId() 
    {
        return CaruCourseId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("caruId", getCaruId())
            .append("CaruCourseId", getCaruCourseId())
            .toString();
    }
}

