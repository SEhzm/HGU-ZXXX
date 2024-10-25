package site.hug7.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import site.hug7.study.domain.entity.StudyCourseDetails;
import site.hug7.study.domain.vo.StudyCourseDetailsVO;

import java.util.List;

/**
 * @author jlc
 * @date 2024/9/7 20:40
 */
@Mapper
public interface StudyCourseDetailsMapper extends BaseMapper<StudyCourseDetails> {



    List<StudyCourseDetailsVO> selectListByCourseId(Integer courseId);

    void updateDetailsView(Integer descId);
}
