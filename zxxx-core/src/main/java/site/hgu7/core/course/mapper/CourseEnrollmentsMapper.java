package site.hgu7.core.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import site.hgu7.core.course.domain.Course;
import site.hgu7.core.course.domain.CourseEnrollments;

/**
 * course_enrollmentsMapper接口
 * 
 * @author hzm
 * @date 2024-10-27
 */
@Mapper
public interface CourseEnrollmentsMapper 
{
    /**
     * 查询course_enrollments
     * 
     * @param enrollmentId course_enrollments主键
     * @return course_enrollments
     */
    public CourseEnrollments selectCourseEnrollmentsByEnrollmentId(Integer enrollmentId);

    /**
     * 查询course_enrollments列表
     * 
     * @param courseEnrollments course_enrollments
     * @return course_enrollments集合
     */
    public List<CourseEnrollments> selectCourseEnrollmentsList(CourseEnrollments courseEnrollments);

    /**
     * 新增course_enrollments
     * 
     * @param courseEnrollments course_enrollments
     * @return 结果
     */
    public int insertCourseEnrollments(CourseEnrollments courseEnrollments);

    /**
     * 修改course_enrollments
     * 
     * @param courseEnrollments course_enrollments
     * @return 结果
     */
    public int updateCourseEnrollments(CourseEnrollments courseEnrollments);

    /**
     * 删除course_enrollments
     * 
     * @param enrollmentId course_enrollments主键
     * @return 结果
     */
    public int deleteCourseEnrollmentsByEnrollmentId(Integer enrollmentId);

    /**
     * 批量删除course_enrollments
     * 
     * @param enrollmentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCourseEnrollmentsByEnrollmentIds(Integer[] enrollmentIds);

    @Select("select course_name from course where course_id=#{courseId}")
    String selectCourseNamesByIds(Integer courseId);
}
