package site.hgu7.core.course.service;

import java.util.List;
import site.hgu7.core.course.domain.CourseChapters;

/**
 * course_chaptersService接口
 * 
 * @author hzm
 * @date 2024-10-27
 */
public interface ICourseChaptersService 
{
    /**
     * 查询course_chapters
     * 
     * @param chapterId course_chapters主键
     * @return course_chapters
     */
    public CourseChapters selectCourseChaptersByChapterId(Integer chapterId);

    /**
     * 查询course_chapters列表
     * 
     * @param courseChapters course_chapters
     * @return course_chapters集合
     */
    public List<CourseChapters> selectCourseChaptersList(CourseChapters courseChapters);

    /**
     * 新增course_chapters
     * 
     * @param courseChapters course_chapters
     * @return 结果
     */
    public int insertCourseChapters(CourseChapters courseChapters);

    /**
     * 修改course_chapters
     * 
     * @param courseChapters course_chapters
     * @return 结果
     */
    public int updateCourseChapters(CourseChapters courseChapters);

    /**
     * 批量删除course_chapters
     * 
     * @param chapterIds 需要删除的course_chapters主键集合
     * @return 结果
     */
    public int deleteCourseChaptersByChapterIds(Integer[] chapterIds);

    /**
     * 删除course_chapters信息
     * 
     * @param chapterId course_chapters主键
     * @return 结果
     */
    public int deleteCourseChaptersByChapterId(Integer chapterId);

    CourseChapters getChaptersInfoByChapterId(Integer chapterId);
}
