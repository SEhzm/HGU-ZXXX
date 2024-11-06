package site.hgu7.CaruCourse.service;

import site.hgu7.CaruCourse.domain.CaruCourse;

import java.util.List;

/**
 * 首页轮播图展示的课程idService接口
 *
 * @author hzm
 * @date 2024-11-06
 */
public interface ICaruCourseService
{
    /**
     * 查询首页轮播图展示的课程id
     *
     * @param caruId 首页轮播图展示的课程id主键
     * @return 首页轮播图展示的课程id
     */
    public CaruCourse selectCaruCourseByCaruId(Long caruId);

    /**
     * 查询首页轮播图展示的课程id列表
     *
     * @param caruCourse 首页轮播图展示的课程id
     * @return 首页轮播图展示的课程id集合
     */
    public List<CaruCourse> selectCaruCourseList(CaruCourse caruCourse);

    /**
     * 新增首页轮播图展示的课程id
     *
     * @param caruCourse 首页轮播图展示的课程id
     * @return 结果
     */
    public int insertCaruCourse(CaruCourse caruCourse);

    /**
     * 修改首页轮播图展示的课程id
     *
     * @param caruCourse 首页轮播图展示的课程id
     * @return 结果
     */
    public int updateCaruCourse(CaruCourse caruCourse);

    /**
     * 批量删除首页轮播图展示的课程id
     *
     * @param caruIds 需要删除的首页轮播图展示的课程id主键集合
     * @return 结果
     */
    public int deleteCaruCourseByCaruIds(Long[] caruIds);

    /**
     * 删除首页轮播图展示的课程id信息
     *
     * @param caruId 首页轮播图展示的课程id主键
     * @return 结果
     */
    public int deleteCaruCourseByCaruId(Long caruId);
}
