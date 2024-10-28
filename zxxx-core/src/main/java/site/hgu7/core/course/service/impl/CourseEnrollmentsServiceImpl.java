package site.hgu7.core.course.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.hgu7.common.utils.SecurityUtils;
import site.hgu7.core.course.mapper.CourseEnrollmentsMapper;
import site.hgu7.core.course.domain.CourseEnrollments;
import site.hgu7.core.course.domain.Course;
import site.hgu7.core.course.service.ICourseEnrollmentsService;

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
        List<Integer> courseIds = enrollments.stream()
                .map(CourseEnrollments::getCourseId)
                .distinct()
                .collect(Collectors.toList());

        Map<Integer, String> courseNameMap = new HashMap<>();
        for (Integer courseId : courseIds) {
            String courseName = courseEnrollmentsMapper.selectCourseNamesByIds(courseId);
            courseNameMap.put(courseId,courseName);
        }

        // 遍历每个报名记录，设置课程名称
        for (CourseEnrollments enrollment : enrollments) {
            Integer courseId = enrollment.getCourseId();
            String courseName = courseNameMap.get(courseId);
            enrollment.setCourseName(courseName);
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
}
