package site.hgu7.core.course.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.hgu7.core.course.mapper.CourseMapper;
import site.hgu7.core.course.domain.Course;
import site.hgu7.core.course.service.ICourseService;

/**
 * courseService业务层处理
 * 
 * @author hzm
 * @date 2024-10-27
 */
@Service
public class CourseServiceImpl implements ICourseService 
{
    @Autowired
    private CourseMapper courseMapper;

    /**
     * 查询course
     * 
     * @param courseId course主键
     * @return course
     */
    @Override
    public Course selectCourseByCourseId(Integer courseId)
    {
        return courseMapper.selectCourseByCourseId(courseId);
    }

    /**
     * 查询course列表
     * 
     * @param course course
     * @return course
     */
    @Override
    public List<Course> selectCourseList(Course course)
    {
        return courseMapper.selectCourseList(course);
    }

    /**
     * 新增course
     * 
     * @param course course
     * @return 结果
     */
    @Override
    public int insertCourse(Course course)
    {
        return courseMapper.insertCourse(course);
    }

    /**
     * 修改course
     * 
     * @param course course
     * @return 结果
     */
    @Override
    public int updateCourse(Course course)
    {
        return courseMapper.updateCourse(course);
    }

    /**
     * 批量删除course
     * 
     * @param courseIds 需要删除的course主键
     * @return 结果
     */
    @Override
    public int deleteCourseByCourseIds(Integer[] courseIds)
    {
        return courseMapper.deleteCourseByCourseIds(courseIds);
    }

    /**
     * 删除course信息
     * 
     * @param courseId course主键
     * @return 结果
     */
    @Override
    public int deleteCourseByCourseId(Integer courseId)
    {
        return courseMapper.deleteCourseByCourseId(courseId);
    }
}
