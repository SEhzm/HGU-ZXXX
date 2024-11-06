import{r as g,K as ke,L as Ue,j as p,A as le,o as i,c as E,G as b,T as oe,f as o,d as e,e as a,k as N,F as ae,B as te,l as m,p as c,R as F,m as y,D as q,x as Ie,v as Ae,a0 as ue}from"./index-Bt1HRCNa.js";import{l as Se,a as xe,u as Ne,b as Ye,d as Te,c as $e}from"./course-DN4dYfxB.js";const Me={class:"app-container"},Re=y("div",{class:"el-upload__text"},[c(" Drop file here or "),y("em",null,"click to upload")],-1),Ee=y("div",{class:"el-upload__tip"}," 上传图片，最大500kb ",-1),Fe={class:"dialog-footer"},qe=y("div",{class:"el-upload__text"},[c(" Drop file here or "),y("em",null,"click to upload")],-1),Be=y("div",{class:"el-upload__tip"}," 上传mp4文件，最大200MB ",-1),Ke={class:"dialog-footer"},Pe=Ie({name:"Course"}),je=Object.assign(Pe,{setup(Le){const{proxy:v}=Ae(),{course_category:Y}=v.useDict("course_category"),B=g([]),V=g(!1),D=g(!1),T=g(!0),U=g(!0),$=g([]),K=g(!0),P=g(!0),M=g(0),I=g(""),C=ke({form:{},queryParams:{pageNum:1,pageSize:10,courseName:null,courseDescription:null,userId:null,createdAt:null,updatedAt:null,teacher:null,courseCategory:null,chapterId:null,courseId:null,chapterTitle:null,chapterDescription:null,videoUrl:null,position:null},rules:{}}),{queryParams:d,form:r,rules:L}=Ue(C),z="http://localhost:9800";g([]);const re=async u=>{const t=new FormData;t.append("file",u.file);try{const s=await ue.post(`${z}/file/upload`,t,{headers:{"Content-Type":"multipart/form-data"}}).then(n=>{C.form.videoUrl=n.data,console.log(C.form.videoUrl)});u.onSuccess&&u.onSuccess(s.data)}catch(s){u.onError&&u.onError(s)}},ne=async u=>{const t=new FormData;t.append("file",u.file);try{const s=await ue.post(`${z}/file/upload`,t,{headers:{"Content-Type":"multipart/form-data"}}).then(n=>{C.form.courseImg=n.data,console.log(C.form.courseImg)});u.onSuccess&&u.onSuccess(s.data)}catch(s){u.onError&&u.onError(s)}},Q=u=>{console.log("上传成功"+u),ElMessage({message:"上传成功",type:"success"})};function h(){T.value=!0,Se(d.value).then(u=>{B.value=u.rows,M.value=u.total,T.value=!1})}function j(){D.value=!1,V.value=!1,A()}function A(){r.value={courseId:null,courseName:null,courseDescription:null,userId:null,createdAt:null,updatedAt:null,teacher:null,courseCategory:null,courseImg:null},v.resetForm("courseRef")}function k(){d.value.pageNum=1,h()}function de(){v.resetForm("queryRef"),k()}function se(u){$.value=u.map(t=>t.courseId),K.value=u.length!=1,P.value=!u.length}function pe(){A(),V.value=!0,I.value="添加course"}function G(u){A();const t=u.courseId||$.value;xe(t).then(s=>{r.value=s.data,V.value=!0,I.value="修改course"})}function ce(){v.$refs.courseRef.validate(u=>{u&&(r.value.courseId!=null?Ne(r.value).then(t=>{v.$modal.msgSuccess("修改成功"),V.value=!1,h()}):Ye(r.value).then(t=>{v.$modal.msgSuccess("新增成功"),V.value=!1,h()}))})}function O(u){const t=u.courseId||$.value;v.$modal.confirm('是否确认删除course编号为"'+t+'"的数据项？').then(function(){return Te(t)}).then(()=>{h(),v.$modal.msgSuccess("删除成功")}).catch(()=>{})}function ie(u){A(),D.value=!0,this.form.courseId=u.courseId}function me(){$e(r.value).then(u=>{v.$modal.msgSuccess("新增成功"),D.value=!1,h()})}function fe(){v.download("course/course/export",{...d.value},`course_${new Date().getTime()}.xlsx`)}return h(),(u,t)=>{const s=p("el-input"),n=p("el-form-item"),S=p("el-date-picker"),_e=p("el-option"),ge=p("el-select"),f=p("el-button"),R=p("el-form"),x=p("el-col"),ve=p("right-toolbar"),be=p("el-row"),_=p("el-table-column"),ye=p("dict-tag"),Ve=p("el-table"),he=p("pagination"),Ce=p("el-radio"),we=p("el-radio-group"),H=p("el-tag"),J=p("upload-filled"),W=p("el-icon"),X=p("el-upload"),Z=p("el-dialog"),w=le("hasPermi"),De=le("loading");return i(),E("div",Me,[b(e(R,{model:o(d),ref:"queryRef",inline:!0,"label-width":"68px"},{default:a(()=>[e(n,{label:"课程名",prop:"courseName"},{default:a(()=>[e(s,{modelValue:o(d).courseName,"onUpdate:modelValue":t[0]||(t[0]=l=>o(d).courseName=l),placeholder:"请输入课程名",clearable:"",onKeyup:N(k,["enter"])},null,8,["modelValue"])]),_:1}),e(n,{label:"课程简介",prop:"courseDescription"},{default:a(()=>[e(s,{modelValue:o(d).courseDescription,"onUpdate:modelValue":t[1]||(t[1]=l=>o(d).courseDescription=l),placeholder:"请输入课程简介",clearable:"",onKeyup:N(k,["enter"])},null,8,["modelValue"])]),_:1}),e(n,{label:"创建者id",prop:"userId"},{default:a(()=>[e(s,{modelValue:o(d).userId,"onUpdate:modelValue":t[2]||(t[2]=l=>o(d).userId=l),placeholder:"请输入创建者id",clearable:"",onKeyup:N(k,["enter"])},null,8,["modelValue"])]),_:1}),e(n,{label:"创建时间",prop:"createdAt"},{default:a(()=>[e(S,{clearable:"",modelValue:o(d).createdAt,"onUpdate:modelValue":t[3]||(t[3]=l=>o(d).createdAt=l),type:"date","value-format":"YYYY-MM-DD",placeholder:"请选择创建时间"},null,8,["modelValue"])]),_:1}),e(n,{label:"更新时间",prop:"updatedAt"},{default:a(()=>[e(S,{clearable:"",modelValue:o(d).updatedAt,"onUpdate:modelValue":t[4]||(t[4]=l=>o(d).updatedAt=l),type:"date","value-format":"YYYY-MM-DD",placeholder:"请选择更新时间"},null,8,["modelValue"])]),_:1}),e(n,{label:"讲师",prop:"teacher"},{default:a(()=>[e(s,{modelValue:o(d).teacher,"onUpdate:modelValue":t[5]||(t[5]=l=>o(d).teacher=l),placeholder:"请输入讲师",clearable:"",onKeyup:N(k,["enter"])},null,8,["modelValue"])]),_:1}),e(n,{label:"课程分类",prop:"courseCategory"},{default:a(()=>[e(ge,{modelValue:o(d).courseCategory,"onUpdate:modelValue":t[6]||(t[6]=l=>o(d).courseCategory=l),placeholder:"请选择课程分类",clearable:""},{default:a(()=>[(i(!0),E(ae,null,te(o(Y),l=>(i(),m(_e,{key:l.value,label:l.label,value:l.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),e(n,null,{default:a(()=>[e(f,{type:"primary",icon:"Search",onClick:k},{default:a(()=>[c("搜索")]),_:1}),e(f,{icon:"Refresh",onClick:de},{default:a(()=>[c("重置")]),_:1})]),_:1})]),_:1},8,["model"]),[[oe,o(U)]]),e(be,{gutter:10,class:"mb8"},{default:a(()=>[e(x,{span:1.5},{default:a(()=>[b((i(),m(f,{type:"primary",plain:"",icon:"Plus",onClick:pe},{default:a(()=>[c("新增 ")]),_:1})),[[w,["course:course:add"]]])]),_:1}),e(x,{span:1.5},{default:a(()=>[b((i(),m(f,{type:"success",plain:"",icon:"Edit",disabled:o(K),onClick:G},{default:a(()=>[c("修改 ")]),_:1},8,["disabled"])),[[w,["course:course:edit"]]])]),_:1}),e(x,{span:1.5},{default:a(()=>[b((i(),m(f,{type:"danger",plain:"",icon:"Delete",disabled:o(P),onClick:O},{default:a(()=>[c("删除 ")]),_:1},8,["disabled"])),[[w,["course:course:remove"]]])]),_:1}),e(x,{span:1.5},{default:a(()=>[b((i(),m(f,{type:"warning",plain:"",icon:"Download",onClick:fe},{default:a(()=>[c("导出 ")]),_:1})),[[w,["course:course:export"]]])]),_:1}),e(ve,{showSearch:o(U),"onUpdate:showSearch":t[7]||(t[7]=l=>F(U)?U.value=l:null),onQueryTable:h},null,8,["showSearch"])]),_:1}),b((i(),m(Ve,{data:o(B),onSelectionChange:se},{default:a(()=>[e(_,{type:"selection",width:"55",align:"center"}),e(_,{label:"课程id",align:"center",prop:"courseId"}),e(_,{label:"课程名",align:"center",prop:"courseName"}),e(_,{label:"课程简介",align:"center",prop:"courseDescription","show-overflow-tooltip":""}),e(_,{label:"创建者id",align:"center",prop:"userId"}),e(_,{label:"创建时间",align:"center",prop:"createdAt",width:"180"},{default:a(l=>[y("span",null,q(u.parseTime(l.row.createdAt,"{y}-{m}-{d}")),1)]),_:1}),e(_,{label:"更新时间",align:"center",prop:"updatedAt",width:"180"},{default:a(l=>[y("span",null,q(u.parseTime(l.row.updatedAt,"{y}-{m}-{d}")),1)]),_:1}),e(_,{label:"讲师",align:"center",prop:"teacher"}),e(_,{label:"课程分类",align:"center",prop:"courseCategory"},{default:a(l=>[e(ye,{options:o(Y),value:l.row.courseCategory},null,8,["options","value"])]),_:1}),e(_,{label:"课程封面",align:"center",prop:"courseImg","show-overflow-tooltip":""}),e(_,{label:"操作",align:"center","class-name":"small-padding fixed-width"},{default:a(l=>[b((i(),m(f,{link:"",type:"primary",icon:"Edit",onClick:ee=>G(l.row)},{default:a(()=>[c("修改 ")]),_:2},1032,["onClick"])),[[w,["course:course:edit"]]]),b((i(),m(f,{link:"",type:"primary",icon:"Delete",onClick:ee=>O(l.row)},{default:a(()=>[c("删除 ")]),_:2},1032,["onClick"])),[[w,["course:course:remove"]]]),b((i(),m(f,{link:"",type:"primary",onClick:ee=>ie(l.row)},{default:a(()=>[c(" 上传章节 ")]),_:2},1032,["onClick"])),[[w,["course:course:add"]]])]),_:1})]),_:1},8,["data"])),[[De,o(T)]]),b(e(he,{total:o(M),page:o(d).pageNum,"onUpdate:page":t[8]||(t[8]=l=>o(d).pageNum=l),limit:o(d).pageSize,"onUpdate:limit":t[9]||(t[9]=l=>o(d).pageSize=l),onPagination:h},null,8,["total","page","limit"]),[[oe,o(M)>0]]),e(Z,{title:o(I),modelValue:o(V),"onUpdate:modelValue":t[17]||(t[17]=l=>F(V)?V.value=l:null),width:"500px","append-to-body":""},{footer:a(()=>[y("div",Fe,[e(f,{type:"primary",onClick:ce},{default:a(()=>[c("确 定")]),_:1}),e(f,{onClick:j},{default:a(()=>[c("取 消")]),_:1})])]),default:a(()=>[e(R,{ref:"courseRef",model:o(r),rules:o(L),"label-width":"80px"},{default:a(()=>[e(n,{label:"课程名",prop:"courseName"},{default:a(()=>[e(s,{modelValue:o(r).courseName,"onUpdate:modelValue":t[10]||(t[10]=l=>o(r).courseName=l),placeholder:"请输入课程名"},null,8,["modelValue"])]),_:1}),e(n,{label:"课程简介",prop:"courseDescription"},{default:a(()=>[e(s,{modelValue:o(r).courseDescription,"onUpdate:modelValue":t[11]||(t[11]=l=>o(r).courseDescription=l),placeholder:"请输入课程简介"},null,8,["modelValue"])]),_:1}),e(n,{label:"创建者id",prop:"userId"},{default:a(()=>[e(s,{modelValue:o(r).userId,"onUpdate:modelValue":t[12]||(t[12]=l=>o(r).userId=l),placeholder:"请输入创建者id"},null,8,["modelValue"])]),_:1}),e(n,{label:"创建时间",prop:"createdAt"},{default:a(()=>[e(S,{clearable:"",modelValue:o(r).createdAt,"onUpdate:modelValue":t[13]||(t[13]=l=>o(r).createdAt=l),type:"date","value-format":"YYYY-MM-DD",placeholder:"请选择创建时间"},null,8,["modelValue"])]),_:1}),e(n,{label:"更新时间",prop:"updatedAt"},{default:a(()=>[e(S,{clearable:"",modelValue:o(r).updatedAt,"onUpdate:modelValue":t[14]||(t[14]=l=>o(r).updatedAt=l),type:"date","value-format":"YYYY-MM-DD",placeholder:"请选择更新时间"},null,8,["modelValue"])]),_:1}),e(n,{label:"讲师",prop:"teacher"},{default:a(()=>[e(s,{modelValue:o(r).teacher,"onUpdate:modelValue":t[15]||(t[15]=l=>o(r).teacher=l),placeholder:"请输入讲师"},null,8,["modelValue"])]),_:1}),e(n,{label:"课程分类",prop:"courseCategory"},{default:a(()=>[e(we,{modelValue:o(r).courseCategory,"onUpdate:modelValue":t[16]||(t[16]=l=>o(r).courseCategory=l)},{default:a(()=>[(i(!0),E(ae,null,te(o(Y),l=>(i(),m(Ce,{key:l.value,label:l.value},{default:a(()=>[c(q(l.label),1)]),_:2},1032,["label"]))),128))]),_:1},8,["modelValue"])]),_:1}),e(n,{label:"课程封面",prop:"courseImg"},{default:a(()=>[o(C).form.courseImg?(i(),m(H,{key:0},{default:a(()=>[c("已上传")]),_:1})):(i(),m(X,{key:1,class:"upload-demo",drag:"",multiple:"","http-request":ne,"on-success":Q},{tip:a(()=>[Ee]),default:a(()=>[e(W,{class:"el-icon--upload"},{default:a(()=>[e(J)]),_:1}),Re]),_:1}))]),_:1})]),_:1},8,["model","rules"])]),_:1},8,["title","modelValue"]),e(Z,{title:o(I),modelValue:o(D),"onUpdate:modelValue":t[22]||(t[22]=l=>F(D)?D.value=l:null),width:"500px","append-to-body":""},{footer:a(()=>[y("div",Ke,[e(f,{type:"primary",onClick:me},{default:a(()=>[c("确 定")]),_:1}),e(f,{onClick:j},{default:a(()=>[c("取 消")]),_:1})])]),default:a(()=>[e(R,{ref:"chaptersRef",model:o(r),rules:o(L),"label-width":"80px"},{default:a(()=>[e(n,{label:"课程id",prop:"courseId"},{default:a(()=>[e(s,{disabled:"",modelValue:o(r).courseId,"onUpdate:modelValue":t[18]||(t[18]=l=>o(r).courseId=l),placeholder:""},null,8,["modelValue"])]),_:1}),e(n,{label:"章节标题",prop:"chapterTitle"},{default:a(()=>[e(s,{modelValue:o(r).chapterTitle,"onUpdate:modelValue":t[19]||(t[19]=l=>o(r).chapterTitle=l),placeholder:"请输入章节标题"},null,8,["modelValue"])]),_:1}),e(n,{label:"章节描述",prop:"chapterDescription"},{default:a(()=>[e(s,{modelValue:o(r).chapterDescription,"onUpdate:modelValue":t[20]||(t[20]=l=>o(r).chapterDescription=l),placeholder:"请输入章节描述"},null,8,["modelValue"])]),_:1}),e(n,{label:"视频链接",prop:"videoUrl"},{default:a(()=>[o(C).form.videoUrl?(i(),m(H,{key:0},{default:a(()=>[c("已上传")]),_:1})):(i(),m(X,{key:1,class:"upload-demo",drag:"",multiple:"","http-request":re,"on-success":Q},{tip:a(()=>[Be]),default:a(()=>[e(W,{class:"el-icon--upload"},{default:a(()=>[e(J)]),_:1}),qe]),_:1}))]),_:1}),e(n,{label:"章节顺序",prop:"position"},{default:a(()=>[e(s,{modelValue:o(r).position,"onUpdate:modelValue":t[21]||(t[21]=l=>o(r).position=l),placeholder:"请输入章节顺序"},null,8,["modelValue"])]),_:1})]),_:1},8,["model","rules"])]),_:1},8,["title","modelValue"])])}}});export{je as default};
