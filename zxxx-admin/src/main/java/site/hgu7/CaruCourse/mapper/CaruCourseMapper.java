package site.hgu7.CaruCourse.mapper;

import site.hgu7.CaruCourse.domain.CaruCourse;

import java.util.List;

/**
 * 首页轮播图展示的课程idMapper接口
 *
 * @author hzm
 * @date 2024-11-06
 */
public interface CaruCourseMapper
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
     * 删除首页轮播图展示的课程id
     *
     * @param caruId 首页轮播图展示的课程id主键
     * @return 结果
     */
    public int deleteCaruCourseByCaruId(Long caruId);

    /**
     * 批量删除首页轮播图展示的课程id
     *
     * @param caruIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCaruCourseByCaruIds(Long[] caruIds);
}
