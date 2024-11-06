package site.hgu7.core.course.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HomeCourseVo {
    private List<Course> CaruCourseId;
    private List<Course> findCourseId;
    private List<Course> recommendCourseId;
}
