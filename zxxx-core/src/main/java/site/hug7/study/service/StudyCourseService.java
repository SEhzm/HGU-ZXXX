package site.hug7.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import site.hug7.study.domain.entity.StudyCourse;
import site.hug7.study.domain.vo.StudyCourseDetailsVO;
import site.hug7.study.domain.vo.StudyCourseVO;

import java.util.List;

/**
 * @author jlc
 * @date 2024/9/7 20:50
 */
public interface StudyCourseService extends IService<StudyCourse> {


    /**
     * 查询课程列表信息
     * @return
     */
    List<StudyCourseVO> courseList(String courseTypeName, String queryKeyName);

    /**
     * 更具课程id查询课程详情
     * @param courseId
     * @return
     */
    List<StudyCourseDetailsVO> courseDetailsList(Integer courseId);

    /**
     * 通过课程详情对浏览量进行更新，每次加一
     * @param descId
     */
    void courseDetailsView(Integer descId);
}
