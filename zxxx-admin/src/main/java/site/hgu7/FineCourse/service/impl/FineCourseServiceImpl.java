package site.hgu7.FineCourse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.hgu7.FineCourse.domain.FineCourse;
import site.hgu7.FineCourse.mapper.FineCourseMapper;
import site.hgu7.FineCourse.service.IFineCourseService;

import java.util.List;

/**
 * 精品课的课程idService业务层处理
 * 
 * @author hzm
 * @date 2024-11-06
 */
@Service
public class FineCourseServiceImpl implements IFineCourseService 
{
    @Autowired
    private FineCourseMapper fineCourseMapper;

    /**
     * 查询精品课的课程id
     * 
     * @param fineId 精品课的课程id主键
     * @return 精品课的课程id
     */
    @Override
    public FineCourse selectFineCourseByFineId(Long fineId)
    {
        return fineCourseMapper.selectFineCourseByFineId(fineId);
    }

    /**
     * 查询精品课的课程id列表
     * 
     * @param fineCourse 精品课的课程id
     * @return 精品课的课程id
     */
    @Override
    public List<FineCourse> selectFineCourseList(FineCourse fineCourse)
    {
        return fineCourseMapper.selectFineCourseList(fineCourse);
    }

    /**
     * 新增精品课的课程id
     * 
     * @param fineCourse 精品课的课程id
     * @return 结果
     */
    @Override
    public int insertFineCourse(FineCourse fineCourse)
    {
        return fineCourseMapper.insertFineCourse(fineCourse);
    }

    /**
     * 修改精品课的课程id
     * 
     * @param fineCourse 精品课的课程id
     * @return 结果
     */
    @Override
    public int updateFineCourse(FineCourse fineCourse)
    {
        return fineCourseMapper.updateFineCourse(fineCourse);
    }

    /**
     * 批量删除精品课的课程id
     * 
     * @param fineIds 需要删除的精品课的课程id主键
     * @return 结果
     */
    @Override
    public int deleteFineCourseByFineIds(Long[] fineIds)
    {
        return fineCourseMapper.deleteFineCourseByFineIds(fineIds);
    }

    /**
     * 删除精品课的课程id信息
     * 
     * @param fineId 精品课的课程id主键
     * @return 结果
     */
    @Override
    public int deleteFineCourseByFineId(Long fineId)
    {
        return fineCourseMapper.deleteFineCourseByFineId(fineId);
    }
}
