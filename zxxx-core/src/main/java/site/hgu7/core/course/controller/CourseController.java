package site.hgu7.core.course.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.hgu7.common.annotation.Log;
import site.hgu7.common.core.controller.BaseController;
import site.hgu7.common.core.domain.AjaxResult;
import site.hgu7.common.enums.BusinessType;
import site.hgu7.core.course.domain.Course;
import site.hgu7.core.course.service.ICourseService;
import site.hgu7.common.utils.poi.ExcelUtil;
import site.hgu7.common.core.page.TableDataInfo;

/**
 * courseController
 * 
 * @author hzm
 * @date 2024-10-27
 */
@RestController
@RequestMapping("/course/course")
public class CourseController extends BaseController
{
    @Autowired
    private ICourseService courseService;

    /**
     * 查询course列表
     */
    @PreAuthorize("@ss.hasPermi('course:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(Course course)
    {
        startPage();
        List<Course> list = courseService.selectCourseList(course);
        return getDataTable(list);
    }

    /**
     * 导出course列表
     */
    @PreAuthorize("@ss.hasPermi('course:course:export')")
    @Log(title = "course", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Course course)
    {
        List<Course> list = courseService.selectCourseList(course);
        ExcelUtil<Course> util = new ExcelUtil<Course>(Course.class);
        util.exportExcel(response, list, "course数据");
    }

    /**
     * 获取course详细信息
     */
    @PreAuthorize("@ss.hasPermi('course:course:query')")
    @GetMapping(value = "/{courseId}")
    public AjaxResult getInfo(@PathVariable("courseId") Integer courseId)
    {
        return success(courseService.selectCourseByCourseId(courseId));
    }

    /**
     * 新增course
     */
    @PreAuthorize("@ss.hasPermi('course:course:add')")
    @Log(title = "course", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Course course)
    {
        return toAjax(courseService.insertCourse(course));
    }

    /**
     * 修改course
     */
    @PreAuthorize("@ss.hasPermi('course:course:edit')")
    @Log(title = "course", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Course course)
    {
        return toAjax(courseService.updateCourse(course));
    }

    /**
     * 删除course
     */
    @PreAuthorize("@ss.hasPermi('course:course:remove')")
    @Log(title = "course", businessType = BusinessType.DELETE)
	@DeleteMapping("/{courseIds}")
    public AjaxResult remove(@PathVariable Integer[] courseIds)
    {
        return toAjax(courseService.deleteCourseByCourseIds(courseIds));
    }



}
