package site.hgu7.RecommendCourse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.hgu7.RecommendCourse.domain.RecommendCourse;
import site.hgu7.RecommendCourse.mapper.RecommendCourseMapper;
import site.hgu7.RecommendCourse.service.IRecommendCourseService;

import java.util.List;

/**
 * 首页推荐课的课程idService业务层处理
 * 
 * @author hzm
 * @date 2024-11-06
 */
@Service
public class RecommendCourseServiceImpl implements IRecommendCourseService 
{
    @Autowired
    private RecommendCourseMapper recommendCourseMapper;

    /**
     * 查询首页推荐课的课程id
     * 
     * @param recommendId 首页推荐课的课程id主键
     * @return 首页推荐课的课程id
     */
    @Override
    public RecommendCourse selectRecommendCourseByRecommendId(Long recommendId)
    {
        return recommendCourseMapper.selectRecommendCourseByRecommendId(recommendId);
    }

    /**
     * 查询首页推荐课的课程id列表
     * 
     * @param recommendCourse 首页推荐课的课程id
     * @return 首页推荐课的课程id
     */
    @Override
    public List<RecommendCourse> selectRecommendCourseList(RecommendCourse recommendCourse)
    {
        return recommendCourseMapper.selectRecommendCourseList(recommendCourse);
    }

    /**
     * 新增首页推荐课的课程id
     * 
     * @param recommendCourse 首页推荐课的课程id
     * @return 结果
     */
    @Override
    public int insertRecommendCourse(RecommendCourse recommendCourse)
    {
        return recommendCourseMapper.insertRecommendCourse(recommendCourse);
    }

    /**
     * 修改首页推荐课的课程id
     * 
     * @param recommendCourse 首页推荐课的课程id
     * @return 结果
     */
    @Override
    public int updateRecommendCourse(RecommendCourse recommendCourse)
    {
        return recommendCourseMapper.updateRecommendCourse(recommendCourse);
    }

    /**
     * 批量删除首页推荐课的课程id
     * 
     * @param recommendIds 需要删除的首页推荐课的课程id主键
     * @return 结果
     */
    @Override
    public int deleteRecommendCourseByRecommendIds(Long[] recommendIds)
    {
        return recommendCourseMapper.deleteRecommendCourseByRecommendIds(recommendIds);
    }

    /**
     * 删除首页推荐课的课程id信息
     * 
     * @param recommendId 首页推荐课的课程id主键
     * @return 结果
     */
    @Override
    public int deleteRecommendCourseByRecommendId(Long recommendId)
    {
        return recommendCourseMapper.deleteRecommendCourseByRecommendId(recommendId);
    }
}
