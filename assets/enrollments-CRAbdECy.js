import{$ as r}from"./index-DsBGqdpw.js";function n(e){return r({url:"/course/enrollments/myList",method:"get",params:e})}function o(e){return r({url:"/course/enrollments/updateLearningProgress",method:"get",params:e})}function s(e){return r({url:"/course/enrollments/getChaptersIdByCourseId?courseId="+e,method:"get"})}function u(e){return r({url:`/course/enrollments/getCourseStudyTotal?courseId=${e}`,method:"get"})}function l(e){return r({url:"/course/enrollments/"+e,method:"get"})}function a(e){return r({url:"/course/enrollments",method:"post",data:e})}function m(e){return r({url:"/course/enrollments",method:"put",data:e})}function d(e){return r({url:"/course/enrollments/"+e,method:"delete"})}export{u as a,l as b,m as c,a as d,d as e,s as g,n as m,o as u};