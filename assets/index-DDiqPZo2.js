import{$ as h,r as c,K as ne,L as te,j as d,A as z,o as C,c as le,G as i,T as F,f as t,d as o,e,k as ae,p as s,l as R,R as K,m as de,x as re,v as me}from"./index-BZSdQ0IZ.js";function ue(r){return h({url:"/RecommendCourse/RecommendCourse/list",method:"get",params:r})}function se(r){return h({url:"/RecommendCourse/RecommendCourse/"+r,method:"get"})}function ce(r){return h({url:"/RecommendCourse/RecommendCourse",method:"post",data:r})}function ie(r){return h({url:"/RecommendCourse/RecommendCourse",method:"put",data:r})}function pe(r){return h({url:"/RecommendCourse/RecommendCourse/"+r,method:"delete"})}const fe={class:"app-container"},_e={class:"dialog-footer"},Ce=re({name:"RecommendCourse"}),Re=Object.assign(Ce,{setup(r){const{proxy:p}=me(),U=c([]),f=c(!1),I=c(!0),b=c(!0),x=c([]),P=c(!0),q=c(!0),S=c(0),V=c(""),L=ne({form:{},queryParams:{pageNum:1,pageSize:10,recommendCourseId:null},rules:{}}),{queryParams:m,form:_,rules:Q}=te(L);function g(){I.value=!0,ue(m.value).then(a=>{U.value=a.rows,S.value=a.total,I.value=!1})}function j(){f.value=!1,$()}function $(){_.value={recommendId:null,recommendCourseId:null},p.resetForm("RecommendCourseRef")}function D(){m.value.pageNum=1,g()}function A(){p.resetForm("queryRef"),D()}function G(a){x.value=a.map(n=>n.recommendId),P.value=a.length!=1,q.value=!a.length}function O(){$(),f.value=!0,V.value="添加首页推荐课的课程id"}function B(a){$();const n=a.recommendId||x.value;se(n).then(y=>{_.value=y.data,f.value=!0,V.value="修改首页推荐课的课程id"})}function H(){p.$refs.RecommendCourseRef.validate(a=>{a&&(_.value.recommendId!=null?ie(_.value).then(n=>{p.$modal.msgSuccess("修改成功"),f.value=!1,g()}):ce(_.value).then(n=>{p.$modal.msgSuccess("新增成功"),f.value=!1,g()}))})}function E(a){const n=a.recommendId||x.value;p.$modal.confirm('是否确认删除首页推荐课的课程id编号为"'+n+'"的数据项？').then(function(){return pe(n)}).then(()=>{g(),p.$modal.msgSuccess("删除成功")}).catch(()=>{})}function J(){p.download("RecommendCourse/RecommendCourse/export",{...m.value},`RecommendCourse_${new Date().getTime()}.xlsx`)}return g(),(a,n)=>{const y=d("el-input"),N=d("el-form-item"),u=d("el-button"),T=d("el-form"),w=d("el-col"),M=d("right-toolbar"),W=d("el-row"),k=d("el-table-column"),X=d("el-table"),Y=d("pagination"),Z=d("el-dialog"),v=z("hasPermi"),ee=z("loading");return C(),le("div",fe,[i(o(T,{model:t(m),ref:"queryRef",inline:!0,"label-width":"128px"},{default:e(()=>[o(N,{label:"推荐课的课程id",prop:"recommendCourseId"},{default:e(()=>[o(y,{modelValue:t(m).recommendCourseId,"onUpdate:modelValue":n[0]||(n[0]=l=>t(m).recommendCourseId=l),placeholder:"请输入推荐课的课程id",clearable:"",onKeyup:ae(D,["enter"])},null,8,["modelValue"])]),_:1}),o(N,null,{default:e(()=>[o(u,{type:"primary",icon:"Search",onClick:D},{default:e(()=>[s("搜索")]),_:1}),o(u,{icon:"Refresh",onClick:A},{default:e(()=>[s("重置")]),_:1})]),_:1})]),_:1},8,["model"]),[[F,t(b)]]),o(W,{gutter:10,class:"mb8"},{default:e(()=>[o(w,{span:1.5},{default:e(()=>[i((C(),R(u,{type:"primary",plain:"",icon:"Plus",onClick:O},{default:e(()=>[s("新增")]),_:1})),[[v,["RecommendCourse:RecommendCourse:add"]]])]),_:1}),o(w,{span:1.5},{default:e(()=>[i((C(),R(u,{type:"success",plain:"",icon:"Edit",disabled:t(P),onClick:B},{default:e(()=>[s("修改")]),_:1},8,["disabled"])),[[v,["RecommendCourse:RecommendCourse:edit"]]])]),_:1}),o(w,{span:1.5},{default:e(()=>[i((C(),R(u,{type:"danger",plain:"",icon:"Delete",disabled:t(q),onClick:E},{default:e(()=>[s("删除")]),_:1},8,["disabled"])),[[v,["RecommendCourse:RecommendCourse:remove"]]])]),_:1}),o(w,{span:1.5},{default:e(()=>[i((C(),R(u,{type:"warning",plain:"",icon:"Download",onClick:J},{default:e(()=>[s("导出")]),_:1})),[[v,["RecommendCourse:RecommendCourse:export"]]])]),_:1}),o(M,{showSearch:t(b),"onUpdate:showSearch":n[1]||(n[1]=l=>K(b)?b.value=l:null),onQueryTable:g},null,8,["showSearch"])]),_:1}),i((C(),R(X,{data:t(U),onSelectionChange:G},{default:e(()=>[o(k,{type:"selection",width:"55",align:"center"}),o(k,{label:"id",align:"center",prop:"recommendId"}),o(k,{label:"推荐课的课程id",align:"center",prop:"recommendCourseId"}),o(k,{label:"操作",align:"center","class-name":"small-padding fixed-width"},{default:e(l=>[i((C(),R(u,{link:"",type:"primary",icon:"Edit",onClick:oe=>B(l.row)},{default:e(()=>[s("修改")]),_:2},1032,["onClick"])),[[v,["RecommendCourse:RecommendCourse:edit"]]]),i((C(),R(u,{link:"",type:"primary",icon:"Delete",onClick:oe=>E(l.row)},{default:e(()=>[s("删除")]),_:2},1032,["onClick"])),[[v,["RecommendCourse:RecommendCourse:remove"]]])]),_:1})]),_:1},8,["data"])),[[ee,t(I)]]),i(o(Y,{total:t(S),page:t(m).pageNum,"onUpdate:page":n[2]||(n[2]=l=>t(m).pageNum=l),limit:t(m).pageSize,"onUpdate:limit":n[3]||(n[3]=l=>t(m).pageSize=l),onPagination:g},null,8,["total","page","limit"]),[[F,t(S)>0]]),o(Z,{title:t(V),modelValue:t(f),"onUpdate:modelValue":n[5]||(n[5]=l=>K(f)?f.value=l:null),width:"500px","append-to-body":""},{footer:e(()=>[de("div",_e,[o(u,{type:"primary",onClick:H},{default:e(()=>[s("确 定")]),_:1}),o(u,{onClick:j},{default:e(()=>[s("取 消")]),_:1})])]),default:e(()=>[o(T,{ref:"RecommendCourseRef",model:t(_),rules:t(Q),"label-width":"80px"},{default:e(()=>[o(N,{label:"推荐课的课程id",prop:"recommendCourseId"},{default:e(()=>[o(y,{modelValue:t(_).recommendCourseId,"onUpdate:modelValue":n[4]||(n[4]=l=>t(_).recommendCourseId=l),placeholder:"请输入推荐课的课程id"},null,8,["modelValue"])]),_:1})]),_:1},8,["model","rules"])]),_:1},8,["title","modelValue"])])}}});export{Re as default};
