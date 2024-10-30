package site.hgu7.core.course.service;

import java.util.List;
import site.hgu7.core.course.domain.Course;
import site.hgu7.core.course.domain.HomeCourse;

/**
 * courseService接口
 * 
 * @author hzm
 * @date 2024-10-27
 */
public interface ICourseService 
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
     * 批量删除course
     * 
     * @param courseIds 需要删除的course主键集合
     * @return 结果
     */
    public int deleteCourseByCourseIds(Integer[] courseIds);

    /**
     * 删除course信息
     * 
     * @param courseId course主键
     * @return 结果
     */
    public int deleteCourseByCourseId(Integer courseId);

    /**
     * 获取首页轮播图,推荐,精品课的课程id
     * @return
     */
    HomeCourse getHomeCourse();
}
