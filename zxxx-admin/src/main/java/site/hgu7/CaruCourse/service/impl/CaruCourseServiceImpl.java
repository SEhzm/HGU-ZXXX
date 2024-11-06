package site.hgu7.CaruCourse.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.hgu7.CaruCourse.mapper.CaruCourseMapper;
import site.hgu7.CaruCourse.domain.CaruCourse;
import site.hgu7.CaruCourse.service.ICaruCourseService;

/**
 * 首页轮播图展示的课程idService业务层处理
 *
 * @author hzm
 * @date 2024-11-06
 */
@Service
public class CaruCourseServiceImpl implements ICaruCourseService
{
    @Autowired
    private CaruCourseMapper caruCourseMapper;

    /**
     * 查询首页轮播图展示的课程id
     *
     * @param caruId 首页轮播图展示的课程id主键
     * @return 首页轮播图展示的课程id
     */
    @Override
    public CaruCourse selectCaruCourseByCaruId(Long caruId)
    {
        return caruCourseMapper.selectCaruCourseByCaruId(caruId);
    }

    /**
     * 查询首页轮播图展示的课程id列表
     *
     * @param caruCourse 首页轮播图展示的课程id
     * @return 首页轮播图展示的课程id
     */
    @Override
    public List<CaruCourse> selectCaruCourseList(CaruCourse caruCourse)
    {
        return caruCourseMapper.selectCaruCourseList(caruCourse);
    }

    /**
     * 新增首页轮播图展示的课程id
     *
     * @param caruCourse 首页轮播图展示的课程id
     * @return 结果
     */
    @Override
    public int insertCaruCourse(CaruCourse caruCourse)
    {
        return caruCourseMapper.insertCaruCourse(caruCourse);
    }

    /**
     * 修改首页轮播图展示的课程id
     *
     * @param caruCourse 首页轮播图展示的课程id
     * @return 结果
     */
    @Override
    public int updateCaruCourse(CaruCourse caruCourse)
    {
        return caruCourseMapper.updateCaruCourse(caruCourse);
    }

    /**
     * 批量删除首页轮播图展示的课程id
     *
     * @param caruIds 需要删除的首页轮播图展示的课程id主键
     * @return 结果
     */
    @Override
    public int deleteCaruCourseByCaruIds(Long[] caruIds)
    {
        return caruCourseMapper.deleteCaruCourseByCaruIds(caruIds);
    }

    /**
     * 删除首页轮播图展示的课程id信息
     *
     * @param caruId 首页轮播图展示的课程id主键
     * @return 结果
     */
    @Override
    public int deleteCaruCourseByCaruId(Long caruId)
    {
        return caruCourseMapper.deleteCaruCourseByCaruId(caruId);
    }
}
