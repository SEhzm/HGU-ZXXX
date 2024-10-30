package site.hgu7.core.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import site.hgu7.core.course.domain.Course;

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

    @Select("SELECT EXISTS(SELECT 1 FROM course_enrollments WHERE course_id = #{courseId} AND user_id = #{userId})")
    Boolean getIsSelect(Integer courseId,Long userId);
}