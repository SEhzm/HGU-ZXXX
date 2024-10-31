package site.hgu7.core.notice.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.hgu7.core.notice.domain.NoticeVo;

import java.util.List;

@Mapper
public interface noticeMapper {
    Long selectUserRoleById(Long userId);

    List<NoticeVo> getNoticeList(Long userRoleId, List<Integer> courseIdList);
}
