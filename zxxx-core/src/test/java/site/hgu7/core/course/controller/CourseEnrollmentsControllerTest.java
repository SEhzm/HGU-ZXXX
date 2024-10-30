package site.hgu7.core.course.controller;

import java.util.*;
import java.math.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import site.hgu7.common.core.controller.BaseController;
import site.hgu7.common.core.domain.AjaxResult;
import site.hgu7.common.core.domain.R;
import site.hgu7.core.course.domain.CourseEnrollments;
import site.hgu7.core.course.service.ICourseEnrollmentsService;
import site.hgu7.common.utils.SecurityUtils;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CourseEnrollmentsControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ICourseEnrollmentsService courseEnrollmentsService;

    @InjectMocks
    private CourseEnrollmentsController courseEnrollmentsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(courseEnrollmentsController).build();
    }

    @Test
    void list_WithPermissions_ShouldReturnCourseEnrollments() throws Exception {
        CourseEnrollments courseEnrollments = new CourseEnrollments();
        List<CourseEnrollments> enrollmentsList = Arrays.asList(courseEnrollments);

        when(courseEnrollmentsService.selectCourseEnrollmentsList(any(CourseEnrollments.class)))
                .thenReturn(enrollmentsList);

        mockMvc.perform(get("/course/enrollments/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
        
        verify(courseEnrollmentsService, times(1)).selectCourseEnrollmentsList(any(CourseEnrollments.class));
    }

    @Test
    void myList_WithPermissions_ShouldReturnMyCourseEnrollments() throws Exception {
        CourseEnrollments courseEnrollments = new CourseEnrollments();
        courseEnrollments.setUserId(1L);
        List<CourseEnrollments> enrollmentsList = Arrays.asList(courseEnrollments);

        when(courseEnrollmentsService.selectCourseEnrollmentsList(any(CourseEnrollments.class)))
                .thenReturn(enrollmentsList);

        mockMvc.perform(get("/course/enrollments/myList")
                .principal(new MockPrincipal("admin")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
        
        verify(courseEnrollmentsService, times(1)).selectCourseEnrollmentsList(any(CourseEnrollments.class));
    }

    @Test
    void export_WithPermissions_ShouldExportCourseEnrollments() throws Exception {
        CourseEnrollments courseEnrollments = new CourseEnrollments();
        List<CourseEnrollments> enrollmentsList = Arrays.asList(courseEnrollments);

        when(courseEnrollmentsService.selectCourseEnrollmentsList(any(CourseEnrollments.class)))
                .thenReturn(enrollmentsList);

        mockMvc.perform(post("/course/enrollments/export")
                .principal(new MockPrincipal("user")))
                .andExpect(status().isOk());
        
        verify(courseEnrollmentsService, times(1)).selectCourseEnrollmentsList(any(CourseEnrollments.class));
    }

    @Test
    void getInfo_WithPermissions_ShouldReturnCourseEnrollmentInfo() throws Exception {
        int enrollmentId = 1;
        CourseEnrollments courseEnrollments = new CourseEnrollments();
        
        when(courseEnrollmentsService.selectCourseEnrollmentsByEnrollmentId(enrollmentId))
                .thenReturn(courseEnrollments);

        mockMvc.perform(get("/course/enrollments/{enrollmentId}", enrollmentId)
                .principal(new MockPrincipal("user")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
        
        verify(courseEnrollmentsService, times(1)).selectCourseEnrollmentsByEnrollmentId(enrollmentId);
    }

    @Test
    void add_WithPermissions_ShouldAddCourseEnrollment() throws Exception {
        CourseEnrollments courseEnrollments = new CourseEnrollments();
        
        when(courseEnrollmentsService.insertCourseEnrollments(any(CourseEnrollments.class)))
                .thenReturn(1);

        mockMvc.perform(post("/course/enrollments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"field1\":\"value1\", \"field2\":\"value2\"}")
                .principal(new MockPrincipal("user")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
        
        verify(courseEnrollmentsService, times(1)).insertCourseEnrollments(any(CourseEnrollments.class));
    }

    @Test
    void edit_WithPermissions_ShouldEditCourseEnrollment() throws Exception {
        CourseEnrollments courseEnrollments = new CourseEnrollments();
        
        when(courseEnrollmentsService.updateCourseEnrollments(any(CourseEnrollments.class)))
                .thenReturn(1);

        mockMvc.perform(put("/course/enrollments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"field1\":\"value1\", \"field2\":\"value2\"}")
                .principal(new MockPrincipal("user")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
        
        verify(courseEnrollmentsService, times(1)).updateCourseEnrollments(any(CourseEnrollments.class));
    }

    @Test
    void remove_WithPermissions_ShouldRemoveCourseEnrollment() throws Exception {
        int[] enrollmentIds = {1, 2, 3};
        
        when(courseEnrollmentsService.deleteCourseEnrollmentsByEnrollmentIds(any(Integer[].class)))
                .thenReturn(1);

        mockMvc.perform(delete("/course/enrollments/{enrollmentIds}", enrollmentIds)
                .principal(new MockPrincipal("user")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
        
        verify(courseEnrollmentsService, times(1)).deleteCourseEnrollmentsByEnrollmentIds(any(Integer[].class));
    }

    @Test
    void selectCourse_ShouldSelectCourse() throws Exception {
        int courseId = 1;
        
        when(courseEnrollmentsService.selectCourse(anyInt()))
                .thenReturn(1);

        mockMvc.perform(get("/course/enrollments/selectCourse/{courseId}", courseId)
                .principal(new MockPrincipal("user")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
        
        verify(courseEnrollmentsService, times(1)).selectCourse(anyInt());
    }

    @Test
    void getChaptersIdByCourseId_ShouldReturnChaptersId() throws Exception {
        int courseId = 1;
        Long userId = 1L;
        CourseEnrollments courseEnrollments = new CourseEnrollments();
        List<CourseEnrollments> enrollmentsList = Arrays.asList(courseEnrollments);

        when(courseEnrollmentsService.selectCourseEnrollmentsList(any(CourseEnrollments.class)))
                .thenReturn(enrollmentsList);

        mockMvc.perform(get("/course/enrollments/getChaptersIdByCourseId")
                .param("courseId", String.valueOf(courseId))
                .principal(new MockPrincipal("user")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
        
        verify(courseEnrollmentsService, times(1)).selectCourseEnrollmentsList(any(CourseEnrollments.class));
    }

    @Test
    void getCourseStudyTotal_ShouldReturnCourseStudyTotal() throws Exception {
        int courseId = 1;
        int total = 5;

        when(courseEnrollmentsService.getCourseStudyTotal(courseId))
                .thenReturn(total);

        mockMvc.perform(get("/course/enrollments/getCourseStudyTotal")
                .param("courseId", String.valueOf(courseId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data").value(total));
        
        verify(courseEnrollmentsService, times(1)).getCourseStudyTotal(courseId);
    }

    // Mock principal for testing
    private static class MockPrincipal implements java.security.Principal {
        private String name;

        MockPrincipal(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
