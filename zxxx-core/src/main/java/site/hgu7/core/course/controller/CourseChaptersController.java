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
import site.hgu7.common.core.domain.R;
import site.hgu7.common.domain.Result;
import site.hgu7.common.enums.BusinessType;
import site.hgu7.core.course.domain.CourseChapters;
import site.hgu7.core.course.service.ICourseChaptersService;
import site.hgu7.common.utils.poi.ExcelUtil;
import site.hgu7.common.core.page.TableDataInfo;

/**
 * course_chaptersController
 *
 * @author hzm
 * @date 2024-10-27
 */
@RestController
@RequestMapping("/course/chapters")
public class CourseChaptersController extends BaseController {
    @Autowired
    private ICourseChaptersService courseChaptersService;

    /**
     * 查询course_chapters列表
     */
    @PreAuthorize("@ss.hasPermi('course:chapters:list')")
    @GetMapping("/list")
    public TableDataInfo list(CourseChapters courseChapters) {
        startPage();
        List<CourseChapters> list = courseChaptersService.selectCourseChaptersList(courseChapters);
        return getDataTable(list);
    }

    /**
     * 导出course_chapters列表
     */
    @PreAuthorize("@ss.hasPermi('course:chapters:export')")
    @Log(title = "course_chapters", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CourseChapters courseChapters) {
        List<CourseChapters> list = courseChaptersService.selectCourseChaptersList(courseChapters);
        ExcelUtil<CourseChapters> util = new ExcelUtil<CourseChapters>(CourseChapters.class);
        util.exportExcel(response, list, "course_chapters数据");
    }

    /**
     * 获取course_chapters详细信息
     */
    @PreAuthorize("@ss.hasPermi('course:chapters:query')")
    @GetMapping(value = "/{chapterId}")
    public AjaxResult getChaptersInfo(@PathVariable("chapterId") Integer chapterId) {
        return success(courseChaptersService.selectCourseChaptersByChapterId(chapterId));
    }

    /**
     * 新增course_chapters
     */
    @PreAuthorize("@ss.hasPermi('course:chapters:add')")
    @Log(title = "course_chapters", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CourseChapters courseChapters) {
        return toAjax(courseChaptersService.insertCourseChapters(courseChapters));
    }

    /**
     * 修改course_chapters
     */
    @PreAuthorize("@ss.hasPermi('course:chapters:edit')")
    @Log(title = "course_chapters", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CourseChapters courseChapters) {
        return toAjax(courseChaptersService.updateCourseChapters(courseChapters));
    }

    /**
     * 删除course_chapters
     */
    @PreAuthorize("@ss.hasPermi('course:chapters:remove')")
    @Log(title = "course_chapters", businessType = BusinessType.DELETE)
    @DeleteMapping("/{chapterIds}")
    public AjaxResult remove(@PathVariable Integer[] chapterIds) {
        return toAjax(courseChaptersService.deleteCourseChaptersByChapterIds(chapterIds));
    }


    /**
     * 获取course_chapters详细信息
     */
    @GetMapping(value = "/getChaptersInfoByChapterId/{chapterId}")
    public R getChaptersInfoByChapterId(@PathVariable("chapterId") Integer chapterId) {
        return R.ok(courseChaptersService.getChaptersInfoByChapterId(chapterId));
    }
}
