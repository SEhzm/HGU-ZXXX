package site.hgu7.core.course.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import site.hgu7.core.course.domain.CourseChapters;

import java.util.List;

/**
 * course_chaptersMapper接口
 *
 * @author hzm
 * @date 2024-10-27
 */
@Mapper
public interface CourseChaptersMapper {
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
     * 删除course_chapters
     *
     * @param chapterId course_chapters主键
     * @return 结果
     */
    public int deleteCourseChaptersByChapterId(Integer chapterId);

    /**
     * 批量删除course_chapters
     *
     * @param chapterIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCourseChaptersByChapterIds(Integer[] chapterIds);

    @Select("select chapter_title from course_chapters where chapter_id = #{chapterId}")
    CourseChapters getChaptersInfoByChapterId(Integer chapterId);


    @Select("select course_name from course where course_id=#{courseId}")
    String getCourseNameById(Integer courseId);
}
