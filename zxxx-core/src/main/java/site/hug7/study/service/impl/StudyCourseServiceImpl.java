package site.hug7.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import site.hgu7.common.core.domain.entity.SysDictData;
import site.hgu7.system.service.ISysDictDataService;
import site.hug7.study.domain.entity.StudyCourse;
import site.hug7.study.domain.vo.StudyCourseDetailsVO;
import site.hug7.study.domain.vo.StudyCourseVO;
import site.hug7.study.mapper.StudyCourseDetailsMapper;
import site.hug7.study.mapper.StudyCourseMapper;
import site.hug7.study.service.StudyCourseService;

import java.util.Collections;
import java.util.List;

/**
 * @author jlc
 * @date 2024/9/7 20:51
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class StudyCourseServiceImpl extends ServiceImpl<StudyCourseMapper, StudyCourse> implements StudyCourseService {


    private final ISysDictDataService dictItemService;

    private final StudyCourseDetailsMapper detailsMapper;


    /**
     * 查询课程列表信息
     *
     * @return
     */
    @Override
    public List<StudyCourseVO> courseList(String courseTypeName, String queryKeyName) {
        SysDictData sysDictData = new SysDictData();
        if (StringUtils.isNotEmpty(courseTypeName)) {
            sysDictData = dictItemService.getIdByName(courseTypeName);
            if (ObjectUtils.isEmpty(sysDictData)) {
                return Collections.emptyList();
            }
        }
        List<StudyCourseVO> list = baseMapper.selectCourseList(sysDictData.getDictCode(), queryKeyName);
        log.info("查询课程列表信息：{}", list);
        return list;

    }

    /**
     * 更具课程id查询课程详情
     *
     * @param courseId
     * @return
     */
    @Override
    public List<StudyCourseDetailsVO> courseDetailsList(Integer courseId) {

        List<StudyCourseDetailsVO> detailsVOS = detailsMapper.selectListByCourseId(courseId);
        return detailsVOS;
    }

    /**
     * 通过课程详情对浏览量进行更新，每次加一
     *
     * @param descId
     */
    @Override
    public void courseDetailsView(Integer descId) {
        if (descId != null) {
            detailsMapper.updateDetailsView(descId);
        }
    }
}
