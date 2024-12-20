package site.hgu7.core.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.hgu7.common.utils.SecurityUtils;
import site.hgu7.core.course.domain.CourseEnrollments;
import site.hgu7.core.course.mapper.CourseEnrollmentsMapper;
import site.hgu7.core.course.service.ICourseEnrollmentsService;

import java.util.List;

/**
 * course_enrollmentsService业务层处理
 * 
 * @author hzm
 * @date 2024-10-27
 */
@Service
public class CourseEnrollmentsServiceImpl implements ICourseEnrollmentsService 
{
    @Autowired
    private CourseEnrollmentsMapper courseEnrollmentsMapper;

    /**
     * 查询course_enrollments
     * 
     * @param enrollmentId course_enrollments主键
     * @return course_enrollments
     */
    @Override
    public CourseEnrollments selectCourseEnrollmentsByEnrollmentId(Integer enrollmentId)
    {
        return courseEnrollmentsMapper.selectCourseEnrollmentsByEnrollmentId(enrollmentId);
    }

    /**
     * 查询course_enrollments列表
     * 
     * @param courseEnrollments course_enrollments
     * @return course_enrollments
     */
    @Override
    public List<CourseEnrollments> selectCourseEnrollmentsList(CourseEnrollments courseEnrollments)
    {
        List<CourseEnrollments> enrollments = courseEnrollmentsMapper.selectCourseEnrollmentsList(courseEnrollments);
        // 提取所有课程ID
        for (CourseEnrollments enrollment : enrollments) {
            String courseName = courseEnrollmentsMapper.selectCourseNamesByIds(enrollment.getCourseId());
            String courseTeacher = courseEnrollmentsMapper.selectCourseTeacherByIds(enrollment.getCourseId());
            enrollment.setCourseName(courseName);
            enrollment.setTeacher(courseTeacher);
        }
        return enrollments;
    }

    /**
     * 新增course_enrollments
     * 
     * @param courseEnrollments course_enrollments
     * @return 结果
     */
    @Override
    public int insertCourseEnrollments(CourseEnrollments courseEnrollments)
    {
        return courseEnrollmentsMapper.insertCourseEnrollments(courseEnrollments);
    }

    /**
     * 修改course_enrollments
     * 
     * @param courseEnrollments course_enrollments
     * @return 结果
     */
    @Override
    public int updateCourseEnrollments(CourseEnrollments courseEnrollments)
    {
        return courseEnrollmentsMapper.updateCourseEnrollments(courseEnrollments);
    }

    /**
     * 批量删除course_enrollments
     * 
     * @param enrollmentIds 需要删除的course_enrollments主键
     * @return 结果
     */
    @Override
    public int deleteCourseEnrollmentsByEnrollmentIds(Integer[] enrollmentIds)
    {
        return courseEnrollmentsMapper.deleteCourseEnrollmentsByEnrollmentIds(enrollmentIds);
    }

    /**
     * 删除course_enrollments信息
     * 
     * @param enrollmentId course_enrollments主键
     * @return 结果
     */
    @Override
    public int deleteCourseEnrollmentsByEnrollmentId(Integer enrollmentId)
    {
        return courseEnrollmentsMapper.deleteCourseEnrollmentsByEnrollmentId(enrollmentId);
    }
    @Override
    public int selectCourse(Integer courseIds) {
        Long userId = SecurityUtils.getUserId();
        return courseEnrollmentsMapper.selectCourse(courseIds,userId);
    }

    @Override
    public Integer getCourseStudyTotal(Integer courseId) {
        return courseEnrollmentsMapper.getCourseStudyTotal(courseId);
    }

    @Override
    public void updateLearningProgress(Integer courseId, Integer chapterId,Long userId) {
        courseEnrollmentsMapper.updateLearningProgress(courseId,chapterId,userId);
    }
}
