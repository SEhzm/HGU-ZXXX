package site.hug7.study.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import site.hgu7.common.domain.Result;
import site.hug7.study.domain.vo.StudyCourseVO;
import site.hug7.study.domain.vo.StudyCourseDetailsVO;
import site.hug7.study.service.StudyCourseService;

import java.util.List;

/**
 * @author jlc
 * @date 2024/9/7 20:42
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "9.课程学习")
@RequestMapping("/api/v1/study")
public class StudyCourseController {

    private final StudyCourseService studyCourseService;


    @GetMapping("/course/list")
    @Operation(summary = "课程列表")
    public Result<List<StudyCourseVO>> list(@RequestParam(required = false) String courseTypeName,
                                            @RequestParam(required = false) String queryKeyName) {
        List<StudyCourseVO> result = studyCourseService.courseList(courseTypeName, queryKeyName);
        return Result.success(result);
    }


    @GetMapping("/course/details/{courseId}")
    @Operation(summary = "查询课程详情")
    public Result<List<StudyCourseDetailsVO>> details(@PathVariable Integer courseId) {
        List<StudyCourseDetailsVO> result = studyCourseService.courseDetailsList(courseId);
        return Result.success(result);
    }

    @GetMapping("/course/details/view/{descId}")
    @Operation(summary = "更新课程详情的浏览量")
    public Result detailsView(@PathVariable Integer descId) {
        studyCourseService.courseDetailsView(descId);
        return Result.success();
    }


}
