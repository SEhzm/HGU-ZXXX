package site.hgu7.FineCourse.service;

import java.util.List;
import site.hgu7.FineCourse.domain.FineCourse;

/**
 * 精品课的课程idService接口
 * 
 * @author hzm
 * @date 2024-11-06
 */
public interface IFineCourseService 
{
    /**
     * 查询精品课的课程id
     * 
     * @param fineId 精品课的课程id主键
     * @return 精品课的课程id
     */
    public FineCourse selectFineCourseByFineId(Long fineId);

    /**
     * 查询精品课的课程id列表
     * 
     * @param fineCourse 精品课的课程id
     * @return 精品课的课程id集合
     */
    public List<FineCourse> selectFineCourseList(FineCourse fineCourse);

    /**
     * 新增精品课的课程id
     * 
     * @param fineCourse 精品课的课程id
     * @return 结果
     */
    public int insertFineCourse(FineCourse fineCourse);

    /**
     * 修改精品课的课程id
     * 
     * @param fineCourse 精品课的课程id
     * @return 结果
     */
    public int updateFineCourse(FineCourse fineCourse);

    /**
     * 批量删除精品课的课程id
     * 
     * @param fineIds 需要删除的精品课的课程id主键集合
     * @return 结果
     */
    public int deleteFineCourseByFineIds(Long[] fineIds);

    /**
     * 删除精品课的课程id信息
     * 
     * @param fineId 精品课的课程id主键
     * @return 结果
     */
    public int deleteFineCourseByFineId(Long fineId);
}
