package site.hgu7.core.course.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.hgu7.core.course.mapper.CourseChaptersMapper;
import site.hgu7.core.course.domain.CourseChapters;
import site.hgu7.core.course.service.ICourseChaptersService;

/**
 * course_chaptersService业务层处理
 * 
 * @author hzm
 * @date 2024-10-27
 */
@Service
public class CourseChaptersServiceImpl implements ICourseChaptersService 
{
    @Autowired
    private CourseChaptersMapper courseChaptersMapper;

    /**
     * 查询course_chapters
     * 
     * @param chapterId course_chapters主键
     * @return course_chapters
     */
    @Override
    public CourseChapters selectCourseChaptersByChapterId(Integer chapterId)
    {
        return courseChaptersMapper.selectCourseChaptersByChapterId(chapterId);
    }

    /**
     * 查询course_chapters列表
     * 
     * @param courseChapters course_chapters
     * @return course_chapters
     */
    @Override
    public List<CourseChapters> selectCourseChaptersList(CourseChapters courseChapters)
    {
        return courseChaptersMapper.selectCourseChaptersList(courseChapters);
    }

    /**
     * 新增course_chapters
     * 
     * @param courseChapters course_chapters
     * @return 结果
     */
    @Override
    public int insertCourseChapters(CourseChapters courseChapters)
    {
        return courseChaptersMapper.insertCourseChapters(courseChapters);
    }

    /**
     * 修改course_chapters
     * 
     * @param courseChapters course_chapters
     * @return 结果
     */
    @Override
    public int updateCourseChapters(CourseChapters courseChapters)
    {
        return courseChaptersMapper.updateCourseChapters(courseChapters);
    }

    /**
     * 批量删除course_chapters
     * 
     * @param chapterIds 需要删除的course_chapters主键
     * @return 结果
     */
    @Override
    public int deleteCourseChaptersByChapterIds(Integer[] chapterIds)
    {
        return courseChaptersMapper.deleteCourseChaptersByChapterIds(chapterIds);
    }

    /**
     * 删除course_chapters信息
     * 
     * @param chapterId course_chapters主键
     * @return 结果
     */
    @Override
    public int deleteCourseChaptersByChapterId(Integer chapterId)
    {
        return courseChaptersMapper.deleteCourseChaptersByChapterId(chapterId);
    }
}
