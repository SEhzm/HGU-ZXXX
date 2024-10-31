package site.hgu7.core.notice.service;

import site.hgu7.core.notice.domain.NoticeVo;

import java.util.List;

public interface INoticeService {
    Long selectUserRoleById(Long userId);

    List<NoticeVo> getNoticeList(Long userRoleId, List<Integer> courseIdList);
}
