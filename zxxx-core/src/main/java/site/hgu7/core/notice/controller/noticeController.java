package site.hgu7.core.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.hgu7.common.core.controller.BaseController;
import site.hgu7.common.core.domain.R;
import site.hgu7.common.core.domain.entity.SysUser;
import site.hgu7.common.core.page.TableDataInfo;
import site.hgu7.common.utils.SecurityUtils;
import site.hgu7.core.course.domain.CourseEnrollments;
import site.hgu7.core.course.service.ICourseEnrollmentsService;
import site.hgu7.core.notice.domain.NoticeVo;
import site.hgu7.core.notice.service.INoticeService;
import site.hgu7.system.service.ISysUserService;

import java.util.ArrayList;
import java.util.List;

import static site.hgu7.common.utils.PageUtils.startPage;

@RestController
@RequestMapping("/userNotice")
public class noticeController extends BaseController {

    @Autowired
    private ICourseEnrollmentsService courseEnrollmentsService;

    @Autowired
    private INoticeService noticeService;

    @GetMapping
    public TableDataInfo getNotice() {
        Long userId = SecurityUtils.getUserId();
        //1、拿到用户类型
        Long userRoleId = noticeService.selectUserRoleById(userId);

        //2、拿到用户选的课
        CourseEnrollments courseEnrollments = new CourseEnrollments();
        courseEnrollments.setUserId(SecurityUtils.getUserId());
        List<CourseEnrollments> list = courseEnrollmentsService.selectCourseEnrollmentsList(courseEnrollments);
        List<Integer> courseIdList = new ArrayList<>();
        for (CourseEnrollments enrollments : list) {
            courseIdList.add(enrollments.getCourseId());
        }
        startPage();
        List<NoticeVo> noticeVo = noticeService.getNoticeList(userRoleId, courseIdList);
        return getDataTable(noticeVo);
    }

}
