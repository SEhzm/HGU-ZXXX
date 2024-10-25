package site.hug7.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import site.hug7.study.domain.entity.StudyCourse;
import site.hug7.study.domain.vo.StudyCourseVO;

import java.util.List;

/**
 * @author jlc
 * @date 2024/9/7 20:40
 */
@Mapper
public interface StudyCourseMapper extends BaseMapper<StudyCourse> {


//    List<StudyCourseVO> selectList(LambdaQueryWrapper<StudyCourse> wrapper);

    List<StudyCourseVO> selectCourseList(@Param("id") Long id, @Param("queryKeyName") String queryKeyName);
}
