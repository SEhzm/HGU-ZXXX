package site.hgu7.core.course.service;

import java.util.List;
import site.hgu7.core.course.domain.CourseEnrollments;

/**
 * course_enrollmentsService接口
 * 
 * @author hzm
 * @date 2024-10-27
 */
public interface ICourseEnrollmentsService 
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
     * 批量删除course_enrollments
     * 
     * @param enrollmentIds 需要删除的course_enrollments主键集合
     * @return 结果
     */
    public int deleteCourseEnrollmentsByEnrollmentIds(Integer[] enrollmentIds);

    /**
     * 删除course_enrollments信息
     * 
     * @param enrollmentId course_enrollments主键
     * @return 结果
     */
    public int deleteCourseEnrollmentsByEnrollmentId(Integer enrollmentId);

    int selectCourse(Integer courseIds);
}
