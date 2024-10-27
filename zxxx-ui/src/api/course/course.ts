import request from "@/utils/request";

const CONFIG_BASE_URL = "/api/v1/study";

class CourseAPI {
  /**
   * 获取课程列表
   */
  static getCourseList(courseTypeName : String, queryKeyName : number) {
    return request<any, StudyCourseVO[]>({
      url: `${CONFIG_BASE_URL}/course/list`,
      method: "get",
      params: {
        courseTypeName: courseTypeName,
        queryKeyName: queryKeyName
      },
    });
  }

  /**
   * 获取课程详情
   */
  static getCourseDetails(courseId : number) {
    return request<any, StudyCourseDetailsVO[]>({
      url: `${CONFIG_BASE_URL}/course/details/${courseId}`,
      method: "get",
    });
  }
  
  /**
   * 获取课程详情
   */
  static updateCourseDetailsView(descId : number) {
    return request({
      url: `${CONFIG_BASE_URL}/course/details/view/${descId}`,
      method: "get",
    });
  }

}

export default CourseAPI;

/** 课程类型对象 */
export interface CourseTypeVO {
  /** 主键 */
  id ?: number;
  /** 课程类型 */
  name ?: string;
}

/** 课程列表对象 */
export interface StudyCourseVO {
  /** 主键 */
  id : number;

  createTime : string;

  name : string;

  courseTypeName : string;

  img : string;

  courseDesc : string;

  courseEvaluate : string;
}

/** 课程详情对象 */
export interface StudyCourseDetailsVO {
  /** 主键 */
  id : number;

  createTime : string;

  courseDetails : string;

  courseId : number;

  chapterView : number;

  videoAddress : string;

  chapterTitle : string;

  chapterEvaluate : string;
}