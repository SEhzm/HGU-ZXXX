package site.hgu7.core.course.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.hgu7.core.course.domain.Course;

import java.util.List;

/**
 * courseMapper接口
 * 
 * @author hzm
 * @date 2024-10-27
 */
@Mapper
public interface CourseMapper 
{
    /**
     * 查询course
     * 
     * @param courseId course主键
     * @return course
     */
    public Course selectCourseByCourseId(Integer courseId);

    /**
     * 查询course列表
     * 
     * @param course course
     * @return course集合
     */
    public List<Course> selectCourseList(Course course);

    /**
     * 新增course
     * 
     * @param course course
     * @return 结果
     */
    public int insertCourse(Course course);

    /**
     * 修改course
     * 
     * @param course course
     * @return 结果
     */
    public int updateCourse(Course course);

    /**
     * 删除course
     * 
     * @param courseId course主键
     * @return 结果
     */
    public int deleteCourseByCourseId(Integer courseId);

    /**
     * 批量删除course
     * 
     * @param courseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCourseByCourseIds(Integer[] courseIds);

    /**
     * 判断是否已选课
     * @param courseId
     * @param userId
     * @return
     */
    Boolean getIsSelect(Integer courseId,Long userId);

    /**
     * 获取轮播图课程id
     * @return List
     */
    List<Integer> getCaruCourseId();

    /**
     * 获取推荐课程id
     * @return
     */
    List<Integer> getFindCourseId();

    /**
     * 获取精品课程id
     * @return
     */
    List<Integer> getRecommendCourseId();
}
