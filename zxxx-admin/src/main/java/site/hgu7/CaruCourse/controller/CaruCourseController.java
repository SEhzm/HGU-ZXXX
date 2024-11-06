package site.hgu7.CaruCourse.controller;

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

import site.hgu7.CaruCourse.domain.CaruCourse;
import site.hgu7.CaruCourse.service.ICaruCourseService;

import site.hgu7.common.annotation.Log;
import site.hgu7.common.core.controller.BaseController;
import site.hgu7.common.core.domain.AjaxResult;
import site.hgu7.common.core.page.TableDataInfo;
import site.hgu7.common.enums.BusinessType;
import site.hgu7.common.utils.poi.ExcelUtil;

/**
 * 首页轮播图展示的课程idController
 *
 * @author hzm
 * @date 2024-11-06
 */
@RestController
@RequestMapping("/CaruCourse/CaruCourse")
public class CaruCourseController extends BaseController
{
    @Autowired
    private ICaruCourseService caruCourseService;

    /**
     * 查询首页轮播图展示的课程id列表
     */
    @PreAuthorize("@ss.hasPermi('CaruCourse:CaruCourse:list')")
    @GetMapping("/list")
    public TableDataInfo list(CaruCourse caruCourse)
    {
        startPage();
        List<CaruCourse> list = caruCourseService.selectCaruCourseList(caruCourse);
        return getDataTable(list);
    }

    /**
     * 导出首页轮播图展示的课程id列表
     */
    @PreAuthorize("@ss.hasPermi('CaruCourse:CaruCourse:export')")
    @Log(title = "首页轮播图展示的课程id", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CaruCourse caruCourse)
    {
        List<CaruCourse> list = caruCourseService.selectCaruCourseList(caruCourse);
        ExcelUtil<CaruCourse> util = new ExcelUtil<CaruCourse>(CaruCourse.class);
        util.exportExcel(response, list, "首页轮播图展示的课程id数据");
    }

    /**
     * 获取首页轮播图展示的课程id详细信息
     */
    @PreAuthorize("@ss.hasPermi('CaruCourse:CaruCourse:query')")
    @GetMapping(value = "/{caruId}")
    public AjaxResult getInfo(@PathVariable("caruId") Long caruId)
    {
        return success(caruCourseService.selectCaruCourseByCaruId(caruId));
    }

    /**
     * 新增首页轮播图展示的课程id
     */
    @PreAuthorize("@ss.hasPermi('CaruCourse:CaruCourse:add')")
    @Log(title = "首页轮播图展示的课程id", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CaruCourse caruCourse)
    {
        return toAjax(caruCourseService.insertCaruCourse(caruCourse));
    }

    /**
     * 修改首页轮播图展示的课程id
     */
    @PreAuthorize("@ss.hasPermi('CaruCourse:CaruCourse:edit')")
    @Log(title = "首页轮播图展示的课程id", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CaruCourse caruCourse)
    {
        return toAjax(caruCourseService.updateCaruCourse(caruCourse));
    }

    /**
     * 删除首页轮播图展示的课程id
     */
    @PreAuthorize("@ss.hasPermi('CaruCourse:CaruCourse:remove')")
    @Log(title = "首页轮播图展示的课程id", businessType = BusinessType.DELETE)
    @DeleteMapping("/{caruIds}")
    public AjaxResult remove(@PathVariable Long[] caruIds)
    {
        return toAjax(caruCourseService.deleteCaruCourseByCaruIds(caruIds));
    }
}
