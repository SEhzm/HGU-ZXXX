package site.hgu7.core.course.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.hgu7.common.annotation.Log;
import site.hgu7.common.core.controller.BaseController;
import site.hgu7.common.core.domain.AjaxResult;
import site.hgu7.common.core.domain.R;
import site.hgu7.common.enums.BusinessType;
import site.hgu7.common.utils.SecurityUtils;
import site.hgu7.core.course.domain.CourseEnrollments;
import site.hgu7.core.course.service.ICourseEnrollmentsService;
import site.hgu7.common.utils.poi.ExcelUtil;
import site.hgu7.common.core.page.TableDataInfo;

/**
 * course_enrollmentsController
 *
 * @author hzm
 * @date 2024-10-27
 */
@RestController
@RequestMapping("/course/enrollments")
public class CourseEnrollmentsController extends BaseController {
    @Autowired
    private ICourseEnrollmentsService courseEnrollmentsService;

    /**
     * 查询course_enrollments列表
     */
    @PreAuthorize("@ss.hasPermi('course:enrollments:list')")
    @GetMapping("/list")
    public TableDataInfo list(CourseEnrollments courseEnrollments) {
        startPage();
        List<CourseEnrollments> list = courseEnrollmentsService.selectCourseEnrollmentsList(courseEnrollments);
        return getDataTable(list);
    }

    /**
     * 查询我的选课记录列表
     */
    @PreAuthorize("@ss.hasPermi('course:enrollments:list')")
    @GetMapping("/myList")
    public TableDataInfo myList(CourseEnrollments courseEnrollments) {
        courseEnrollments.setUserId(SecurityUtils.getUserId());
        startPage();
        List<CourseEnrollments> list = courseEnrollmentsService.selectCourseEnrollmentsList(courseEnrollments);
        return getDataTable(list);
    }

    /**
     * 导出course_enrollments列表
     */
    @PreAuthorize("@ss.hasPermi('course:enrollments:export')")
    @Log(title = "course_enrollments", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CourseEnrollments courseEnrollments) {
        List<CourseEnrollments> list = courseEnrollmentsService.selectCourseEnrollmentsList(courseEnrollments);
        ExcelUtil<CourseEnrollments> util = new ExcelUtil<CourseEnrollments>(CourseEnrollments.class);
        util.exportExcel(response, list, "course_enrollments数据");
    }

    /**
     * 获取course_enrollments详细信息
     */
    @PreAuthorize("@ss.hasPermi('course:enrollments:query')")
    @GetMapping(value = "/{enrollmentId}")
    public AjaxResult getInfo(@PathVariable("enrollmentId") Integer enrollmentId) {
        return success(courseEnrollmentsService.selectCourseEnrollmentsByEnrollmentId(enrollmentId));
    }

    /**
     * 新增course_enrollments
     */
    @PreAuthorize("@ss.hasPermi('course:enrollments:add')")
    @Log(title = "course_enrollments", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CourseEnrollments courseEnrollments) {
        return toAjax(courseEnrollmentsService.insertCourseEnrollments(courseEnrollments));
    }

    /**
     * 修改course_enrollments
     */
    @PreAuthorize("@ss.hasPermi('course:enrollments:edit')")
    @Log(title = "course_enrollments", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CourseEnrollments courseEnrollments) {
        return toAjax(courseEnrollmentsService.updateCourseEnrollments(courseEnrollments));
    }

    /**
     * 删除course_enrollments
     */
    @PreAuthorize("@ss.hasPermi('course:enrollments:remove')")
    @Log(title = "course_enrollments", businessType = BusinessType.DELETE)
    @DeleteMapping("/{enrollmentIds}")
    public AjaxResult remove(@PathVariable Integer[] enrollmentIds) {
        return toAjax(courseEnrollmentsService.deleteCourseEnrollmentsByEnrollmentIds(enrollmentIds));
    }

    /**
     * 选择course,选课
     */
    @GetMapping("/selectCourse/{courseId}")
    public AjaxResult selectCourse(@PathVariable Integer courseId) {
        return toAjax(courseEnrollmentsService.selectCourse(courseId));
    }

    /**
     * 根据课程号，userid，查出章节号
     *
     * @param
     * @return
     */
    @PreAuthorize("@ss.hasPermi('course:enrollments:list')")
    @GetMapping("/getChaptersIdByCourseId")
    public TableDataInfo getChaptersIdByCourseId(@RequestParam("courseId") Integer courseId) {
        Long userId = SecurityUtils.getUserId();
        CourseEnrollments courseEnrollments = new CourseEnrollments();
        courseEnrollments.setCourseId(courseId);
        courseEnrollments.setUserId(userId);
        List<CourseEnrollments> enrollments = courseEnrollmentsService.selectCourseEnrollmentsList(courseEnrollments);
        return getDataTable(enrollments);
    }

    /**
     * 获取课程总的选课人数
     * @return
     */
    @GetMapping("/getCourseStudyTotal")
    public R getCourseStudyTotal(@RequestParam("courseId") Integer courseId){
    Integer total= courseEnrollmentsService.getCourseStudyTotal(courseId);
    return R.ok(total);
    }

}
