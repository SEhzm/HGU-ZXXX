import{W as t}from"./index-BPL31SMt.js";function n(e){return t({url:"/course/enrollments/myList",method:"get",params:e})}function o(e){return t({url:"/course/enrollments/getChaptersIdByCourseId?courseId="+e,method:"get"})}function s(e){return t({url:`/course/enrollments/getCourseStudyTotal?courseId=${e}`,method:"get"})}function u(e){return t({url:"/course/enrollments/"+e,method:"get"})}function l(e){return t({url:"/course/enrollments",method:"post",data:e})}function m(e){return t({url:"/course/enrollments",method:"put",data:e})}function d(e){return t({url:"/course/enrollments/"+e,method:"delete"})}export{s as a,u as b,l as c,d,o as g,n as m,m as u};
