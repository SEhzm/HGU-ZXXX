import{r as f,K as ie,L as ce,j as u,A as q,o as h,c as me,G as _,T as B,f as t,d as e,e as a,k as U,p as i,l as v,R as F,m as C,D as z,x as fe,a0 as he,O as _e,v as ve}from"./index-BZSdQ0IZ.js";import{l as ge,g as be,u as ye,a as Ve,d as we}from"./chapters-Dkm97zEU.js";const Ue={class:"app-container"},Ce=C("div",{class:"el-upload__text"},[i(" 将文件拖拽进来 "),C("em",null,"或 点击上传")],-1),De=C("div",{class:"el-upload__tip"}," 上传视频文件，最大200MB ",-1),ke={class:"dialog-footer"},Ie=fe({name:"Chapters"}),xe=Object.assign(Ie,{setup(Se){const{proxy:g}=ve(),R=f([]),b=f(!1),S=f(!0),D=f(!0),A=f([]),$=f(!0),K=f(!0),T=f(0),x=f(""),k=ie({form:{},queryParams:{pageNum:1,pageSize:10,courseId:null,courseName:null,chapterTitle:null,chapterDescription:null,videoUrl:null,position:null,createdAt:null,updatedAt:null},rules:{}}),{queryParams:n,form:s,rules:L}=ce(k),Q="http://localhost:9800";f([]);const j=async r=>{const l=new FormData;l.append("file",r.file);try{const d=await he.post(`${Q}/file/upload`,l,{headers:{"Content-Type":"multipart/form-data"}}).then(p=>{k.form.videoUrl=p.data,console.log(k.form.videoUrl)});r.onSuccess&&r.onSuccess(d.data)}catch(d){r.onError&&r.onError(d)}},O=r=>{console.log("上传成功"+r),_e({message:"上传成功",type:"success"})};function V(){S.value=!0,ge(n.value).then(r=>{R.value=r.rows,T.value=r.total,S.value=!1})}function G(){b.value=!1,N()}function N(){s.value={chapterId:null,courseId:null,chapterTitle:null,chapterDescription:null,videoUrl:null,position:null,createdAt:null,updatedAt:null},g.resetForm("chaptersRef")}function y(){n.value.pageNum=1,V()}function H(){g.resetForm("queryRef"),y()}function J(r){A.value=r.map(l=>l.chapterId),$.value=r.length!=1,K.value=!r.length}function W(){N(),b.value=!0,x.value="添加course_chapters"}function Y(r){N();const l=r.chapterId||A.value;be(l).then(d=>{s.value=d.data,b.value=!0,x.value="修改course_chapters"})}function X(){g.$refs.chaptersRef.validate(r=>{r&&(s.value.chapterId!=null?ye(s.value).then(l=>{g.$modal.msgSuccess("修改成功"),b.value=!1,V()}):Ve(s.value).then(l=>{g.$modal.msgSuccess("新增成功"),b.value=!1,V()}))})}function E(r){const l=r.chapterId||A.value;g.$modal.confirm('是否确认删除course_chapters编号为"'+l+'"的数据项？').then(function(){return we(l)}).then(()=>{V(),g.$modal.msgSuccess("删除成功")}).catch(()=>{})}function Z(){g.download("course/chapters/export",{...n.value},`chapters_${new Date().getTime()}.xlsx`)}return V(),(r,l)=>{const d=u("el-input"),p=u("el-form-item"),M=u("el-date-picker"),m=u("el-button"),P=u("el-form"),I=u("el-col"),ee=u("right-toolbar"),le=u("el-row"),c=u("el-table-column"),te=u("el-table"),ae=u("pagination"),oe=u("el-tag"),ne=u("upload-filled"),re=u("el-icon"),de=u("el-upload"),pe=u("el-dialog"),w=q("hasPermi"),ue=q("loading");return h(),me("div",Ue,[_(e(P,{model:t(n),ref:"queryRef",inline:!0,"label-width":"68px"},{default:a(()=>[e(p,{label:"课程id",prop:"courseId"},{default:a(()=>[e(d,{modelValue:t(n).courseId,"onUpdate:modelValue":l[0]||(l[0]=o=>t(n).courseId=o),placeholder:"请输入课程id",clearable:"",onKeyup:U(y,["enter"])},null,8,["modelValue"])]),_:1}),e(p,{label:"课程名",prop:"courseName"},{default:a(()=>[e(d,{modelValue:t(n).courseName,"onUpdate:modelValue":l[1]||(l[1]=o=>t(n).courseName=o),placeholder:"请输入课程名",clearable:"",onKeyup:U(y,["enter"])},null,8,["modelValue"])]),_:1}),e(p,{label:"章节标题",prop:"chapterTitle"},{default:a(()=>[e(d,{modelValue:t(n).chapterTitle,"onUpdate:modelValue":l[2]||(l[2]=o=>t(n).chapterTitle=o),placeholder:"请输入章节标题",clearable:"",onKeyup:U(y,["enter"])},null,8,["modelValue"])]),_:1}),e(p,{label:"章节描述",prop:"chapterDescription"},{default:a(()=>[e(d,{modelValue:t(n).chapterDescription,"onUpdate:modelValue":l[3]||(l[3]=o=>t(n).chapterDescription=o),placeholder:"请输入章节描述",clearable:"",onKeyup:U(y,["enter"])},null,8,["modelValue"])]),_:1}),e(p,{label:"视频链接",prop:"videoUrl"},{default:a(()=>[e(d,{modelValue:t(n).videoUrl,"onUpdate:modelValue":l[4]||(l[4]=o=>t(n).videoUrl=o),placeholder:"请输入视频链接",clearable:"",onKeyup:U(y,["enter"])},null,8,["modelValue"])]),_:1}),e(p,{label:"章节顺序",prop:"position"},{default:a(()=>[e(d,{modelValue:t(n).position,"onUpdate:modelValue":l[5]||(l[5]=o=>t(n).position=o),placeholder:"请输入章节顺序",clearable:"",onKeyup:U(y,["enter"])},null,8,["modelValue"])]),_:1}),e(p,{label:"创建时间",prop:"createdAt"},{default:a(()=>[e(M,{clearable:"",modelValue:t(n).createdAt,"onUpdate:modelValue":l[6]||(l[6]=o=>t(n).createdAt=o),type:"date","value-format":"YYYY-MM-DD",placeholder:"请选择创建时间"},null,8,["modelValue"])]),_:1}),e(p,{label:"更新时间",prop:"updatedAt"},{default:a(()=>[e(M,{clearable:"",modelValue:t(n).updatedAt,"onUpdate:modelValue":l[7]||(l[7]=o=>t(n).updatedAt=o),type:"date","value-format":"YYYY-MM-DD",placeholder:"请选择更新时间"},null,8,["modelValue"])]),_:1}),e(p,null,{default:a(()=>[e(m,{type:"primary",icon:"Search",onClick:y},{default:a(()=>[i("搜索")]),_:1}),e(m,{icon:"Refresh",onClick:H},{default:a(()=>[i("重置")]),_:1})]),_:1})]),_:1},8,["model"]),[[B,t(D)]]),e(le,{gutter:10,class:"mb8"},{default:a(()=>[e(I,{span:1.5},{default:a(()=>[_((h(),v(m,{type:"primary",plain:"",icon:"Plus",onClick:W},{default:a(()=>[i("新增 ")]),_:1})),[[w,["course:chapters:add"]]])]),_:1}),e(I,{span:1.5},{default:a(()=>[_((h(),v(m,{type:"success",plain:"",icon:"Edit",disabled:t($),onClick:Y},{default:a(()=>[i("修改 ")]),_:1},8,["disabled"])),[[w,["course:chapters:edit"]]])]),_:1}),e(I,{span:1.5},{default:a(()=>[_((h(),v(m,{type:"danger",plain:"",icon:"Delete",disabled:t(K),onClick:E},{default:a(()=>[i("删除 ")]),_:1},8,["disabled"])),[[w,["course:chapters:remove"]]])]),_:1}),e(I,{span:1.5},{default:a(()=>[_((h(),v(m,{type:"warning",plain:"",icon:"Download",onClick:Z},{default:a(()=>[i("导出 ")]),_:1})),[[w,["course:chapters:export"]]])]),_:1}),e(ee,{showSearch:t(D),"onUpdate:showSearch":l[8]||(l[8]=o=>F(D)?D.value=o:null),onQueryTable:V},null,8,["showSearch"])]),_:1}),_((h(),v(te,{data:t(R),onSelectionChange:J},{default:a(()=>[e(c,{type:"selection",width:"55",align:"center"}),e(c,{label:"章节id",align:"center",prop:"chapterId","min-width":"18"}),e(c,{label:"课程id",align:"center",prop:"courseId","min-width":"18"}),e(c,{label:"课程名称",align:"center",prop:"courseName","min-width":"28"}),e(c,{label:"章节标题",align:"center",prop:"chapterTitle"}),e(c,{label:"章节描述",align:"center",prop:"chapterDescription","show-overflow-tooltip":"","min-width":"88"}),e(c,{label:"视频链接",align:"center",prop:"videoUrl","show-overflow-tooltip":""}),e(c,{label:"章节顺序",align:"center",prop:"position","min-width":"20"}),e(c,{label:"创建时间",align:"center",prop:"createdAt",width:"180"},{default:a(o=>[C("span",null,z(r.parseTime(o.row.createdAt,"{y}-{m}-{d}")),1)]),_:1}),e(c,{label:"更新时间",align:"center",prop:"updatedAt",width:"180"},{default:a(o=>[C("span",null,z(r.parseTime(o.row.updatedAt,"{y}-{m}-{d}")),1)]),_:1}),e(c,{label:"操作",align:"center","class-name":"small-padding fixed-width"},{default:a(o=>[_((h(),v(m,{link:"",type:"primary",icon:"Edit",onClick:se=>Y(o.row)},{default:a(()=>[i("修改 ")]),_:2},1032,["onClick"])),[[w,["course:chapters:edit"]]]),_((h(),v(m,{link:"",type:"primary",icon:"Delete",onClick:se=>E(o.row)},{default:a(()=>[i("删除 ")]),_:2},1032,["onClick"])),[[w,["course:chapters:remove"]]])]),_:1})]),_:1},8,["data"])),[[ue,t(S)]]),_(e(ae,{total:t(T),page:t(n).pageNum,"onUpdate:page":l[9]||(l[9]=o=>t(n).pageNum=o),limit:t(n).pageSize,"onUpdate:limit":l[10]||(l[10]=o=>t(n).pageSize=o),onPagination:V},null,8,["total","page","limit"]),[[B,t(T)>0]]),e(pe,{title:t(x),modelValue:t(b),"onUpdate:modelValue":l[15]||(l[15]=o=>F(b)?b.value=o:null),width:"500px","append-to-body":""},{footer:a(()=>[C("div",ke,[e(m,{type:"primary",onClick:X},{default:a(()=>[i("确 定")]),_:1}),e(m,{onClick:G},{default:a(()=>[i("取 消")]),_:1})])]),default:a(()=>[e(P,{ref:"chaptersRef",model:t(s),rules:t(L),"label-width":"80px"},{default:a(()=>[e(p,{label:"课程id",prop:"courseId"},{default:a(()=>[e(d,{modelValue:t(s).courseId,"onUpdate:modelValue":l[11]||(l[11]=o=>t(s).courseId=o),placeholder:"请输入课程id"},null,8,["modelValue"])]),_:1}),e(p,{label:"章节标题",prop:"chapterTitle"},{default:a(()=>[e(d,{modelValue:t(s).chapterTitle,"onUpdate:modelValue":l[12]||(l[12]=o=>t(s).chapterTitle=o),placeholder:"请输入章节标题"},null,8,["modelValue"])]),_:1}),e(p,{label:"章节描述",prop:"chapterDescription"},{default:a(()=>[e(d,{modelValue:t(s).chapterDescription,"onUpdate:modelValue":l[13]||(l[13]=o=>t(s).chapterDescription=o),placeholder:"请输入章节描述"},null,8,["modelValue"])]),_:1}),e(p,{label:"视频文件",prop:"videoUrl"},{default:a(()=>[t(k).form.videoUrl?(h(),v(oe,{key:0},{default:a(()=>[i("已上传")]),_:1})):(h(),v(de,{key:1,style:{width:"100%"},class:"upload-demo",drag:"",action:"https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15",multiple:"","http-request":j,"on-success":O,accept:"video/*"},{tip:a(()=>[De]),default:a(()=>[e(re,{class:"el-icon--upload"},{default:a(()=>[e(ne)]),_:1}),Ce]),_:1}))]),_:1}),e(p,{label:"章节顺序",prop:"position"},{default:a(()=>[e(d,{modelValue:t(s).position,"onUpdate:modelValue":l[14]||(l[14]=o=>t(s).position=o),placeholder:"请输入章节顺序"},null,8,["modelValue"])]),_:1})]),_:1},8,["model","rules"])]),_:1},8,["title","modelValue"])])}}});export{xe as default};
