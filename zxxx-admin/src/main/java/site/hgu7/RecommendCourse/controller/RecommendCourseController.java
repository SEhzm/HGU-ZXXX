package site.hgu7.RecommendCourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import site.hgu7.RecommendCourse.domain.RecommendCourse;
import site.hgu7.RecommendCourse.service.IRecommendCourseService;
import site.hgu7.common.annotation.Log;
import site.hgu7.common.core.controller.BaseController;
import site.hgu7.common.core.domain.AjaxResult;
import site.hgu7.common.core.page.TableDataInfo;
import site.hgu7.common.enums.BusinessType;
import site.hgu7.common.utils.poi.ExcelUtil;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 首页推荐课的课程idController
 * 
 * @author hzm
 * @date 2024-11-06
 */
@RestController
@RequestMapping("/RecommendCourse/RecommendCourse")
public class RecommendCourseController extends BaseController
{
    @Autowired
    private IRecommendCourseService recommendCourseService;

    /**
     * 查询首页推荐课的课程id列表
     */
    @PreAuthorize("@ss.hasPermi('RecommendCourse:RecommendCourse:list')")
    @GetMapping("/list")
    public TableDataInfo list(RecommendCourse recommendCourse)
    {
        startPage();
        List<RecommendCourse> list = recommendCourseService.selectRecommendCourseList(recommendCourse);
        return getDataTable(list);
    }

    /**
     * 导出首页推荐课的课程id列表
     */
    @PreAuthorize("@ss.hasPermi('RecommendCourse:RecommendCourse:export')")
    @Log(title = "首页推荐课的课程id", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RecommendCourse recommendCourse)
    {
        List<RecommendCourse> list = recommendCourseService.selectRecommendCourseList(recommendCourse);
        ExcelUtil<RecommendCourse> util = new ExcelUtil<RecommendCourse>(RecommendCourse.class);
        util.exportExcel(response, list, "首页推荐课的课程id数据");
    }

    /**
     * 获取首页推荐课的课程id详细信息
     */
    @PreAuthorize("@ss.hasPermi('RecommendCourse:RecommendCourse:query')")
    @GetMapping(value = "/{recommendId}")
    public AjaxResult getInfo(@PathVariable("recommendId") Long recommendId)
    {
        return success(recommendCourseService.selectRecommendCourseByRecommendId(recommendId));
    }

    /**
     * 新增首页推荐课的课程id
     */
    @PreAuthorize("@ss.hasPermi('RecommendCourse:RecommendCourse:add')")
    @Log(title = "首页推荐课的课程id", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RecommendCourse recommendCourse)
    {
        return toAjax(recommendCourseService.insertRecommendCourse(recommendCourse));
    }

    /**
     * 修改首页推荐课的课程id
     */
    @PreAuthorize("@ss.hasPermi('RecommendCourse:RecommendCourse:edit')")
    @Log(title = "首页推荐课的课程id", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RecommendCourse recommendCourse)
    {
        return toAjax(recommendCourseService.updateRecommendCourse(recommendCourse));
    }

    /**
     * 删除首页推荐课的课程id
     */
    @PreAuthorize("@ss.hasPermi('RecommendCourse:RecommendCourse:remove')")
    @Log(title = "首页推荐课的课程id", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recommendIds}")
    public AjaxResult remove(@PathVariable Long[] recommendIds)
    {
        return toAjax(recommendCourseService.deleteRecommendCourseByRecommendIds(recommendIds));
    }
}
