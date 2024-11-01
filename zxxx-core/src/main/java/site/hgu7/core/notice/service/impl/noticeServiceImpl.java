package site.hgu7.core.notice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.hgu7.core.notice.domain.NoticeVo;
import site.hgu7.core.notice.mapper.noticeMapper;
import site.hgu7.core.notice.service.INoticeService;

import java.util.List;

import static site.hgu7.common.utils.PageUtils.startPage;

@Service
public class noticeServiceImpl implements INoticeService {

    @Autowired
    private noticeMapper noticeMapper;

    @Override
    public Long selectUserRoleById(Long userId) {

        return noticeMapper.selectUserRoleById(userId);
    }

    @Override
    public List<NoticeVo> getNoticeList(Long userRoleId, List<Integer> courseIdList) {
        List<NoticeVo> noticeVo = noticeMapper.getNoticeList(userRoleId,courseIdList);
        return noticeVo;
    }
}
