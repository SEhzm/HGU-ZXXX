package site.hgu7.RecommendCourse.service;

import site.hgu7.RecommendCourse.domain.RecommendCourse;

import java.util.List;

/**
 * 首页推荐课的课程idService接口
 * 
 * @author hzm
 * @date 2024-11-06
 */
public interface IRecommendCourseService 
{
    /**
     * 查询首页推荐课的课程id
     * 
     * @param recommendId 首页推荐课的课程id主键
     * @return 首页推荐课的课程id
     */
    public RecommendCourse selectRecommendCourseByRecommendId(Long recommendId);

    /**
     * 查询首页推荐课的课程id列表
     * 
     * @param recommendCourse 首页推荐课的课程id
     * @return 首页推荐课的课程id集合
     */
    public List<RecommendCourse> selectRecommendCourseList(RecommendCourse recommendCourse);

    /**
     * 新增首页推荐课的课程id
     * 
     * @param recommendCourse 首页推荐课的课程id
     * @return 结果
     */
    public int insertRecommendCourse(RecommendCourse recommendCourse);

    /**
     * 修改首页推荐课的课程id
     * 
     * @param recommendCourse 首页推荐课的课程id
     * @return 结果
     */
    public int updateRecommendCourse(RecommendCourse recommendCourse);

    /**
     * 批量删除首页推荐课的课程id
     * 
     * @param recommendIds 需要删除的首页推荐课的课程id主键集合
     * @return 结果
     */
    public int deleteRecommendCourseByRecommendIds(Long[] recommendIds);

    /**
     * 删除首页推荐课的课程id信息
     * 
     * @param recommendId 首页推荐课的课程id主键
     * @return 结果
     */
    public int deleteRecommendCourseByRecommendId(Long recommendId);
}
