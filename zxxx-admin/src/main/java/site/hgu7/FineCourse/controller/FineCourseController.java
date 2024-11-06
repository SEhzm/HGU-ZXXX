package site.hgu7.FineCourse.controller;

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

import site.hgu7.FineCourse.domain.FineCourse;
import site.hgu7.FineCourse.service.IFineCourseService;

import site.hgu7.common.annotation.Log;
import site.hgu7.common.core.controller.BaseController;
import site.hgu7.common.core.domain.AjaxResult;
import site.hgu7.common.core.page.TableDataInfo;
import site.hgu7.common.enums.BusinessType;
import site.hgu7.common.utils.poi.ExcelUtil;

/**
 * 精品课的课程idController
 * 
 * @author hzm
 * @date 2024-11-06
 */
@RestController
@RequestMapping("/FineCourse/FineCourse")
public class FineCourseController extends BaseController
{
    @Autowired
    private IFineCourseService fineCourseService;

    /**
     * 查询精品课的课程id列表
     */
    @PreAuthorize("@ss.hasPermi('FineCourse:FineCourse:list')")
    @GetMapping("/list")
    public TableDataInfo list(FineCourse fineCourse)
    {
        startPage();
        List<FineCourse> list = fineCourseService.selectFineCourseList(fineCourse);
        return getDataTable(list);
    }

    /**
     * 导出精品课的课程id列表
     */
    @PreAuthorize("@ss.hasPermi('FineCourse:FineCourse:export')")
    @Log(title = "精品课的课程id", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FineCourse fineCourse)
    {
        List<FineCourse> list = fineCourseService.selectFineCourseList(fineCourse);
        ExcelUtil<FineCourse> util = new ExcelUtil<FineCourse>(FineCourse.class);
        util.exportExcel(response, list, "精品课的课程id数据");
    }

    /**
     * 获取精品课的课程id详细信息
     */
    @PreAuthorize("@ss.hasPermi('FineCourse:FineCourse:query')")
    @GetMapping(value = "/{fineId}")
    public AjaxResult getInfo(@PathVariable("fineId") Long fineId)
    {
        return success(fineCourseService.selectFineCourseByFineId(fineId));
    }

    /**
     * 新增精品课的课程id
     */
    @PreAuthorize("@ss.hasPermi('FineCourse:FineCourse:add')")
    @Log(title = "精品课的课程id", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FineCourse fineCourse)
    {
        return toAjax(fineCourseService.insertFineCourse(fineCourse));
    }

    /**
     * 修改精品课的课程id
     */
    @PreAuthorize("@ss.hasPermi('FineCourse:FineCourse:edit')")
    @Log(title = "精品课的课程id", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FineCourse fineCourse)
    {
        return toAjax(fineCourseService.updateFineCourse(fineCourse));
    }

    /**
     * 删除精品课的课程id
     */
    @PreAuthorize("@ss.hasPermi('FineCourse:FineCourse:remove')")
    @Log(title = "精品课的课程id", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fineIds}")
    public AjaxResult remove(@PathVariable Long[] fineIds)
    {
        return toAjax(fineCourseService.deleteFineCourseByFineIds(fineIds));
    }
}
