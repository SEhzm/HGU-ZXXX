import{$ as b,r as c,K as oe,L as te,j as r,A as z,o as _,c as le,G as C,T as F,f as t,d as a,e,k as ue,p as i,l as v,R as K,m as re,x as ne,v as se}from"./index-B6WzBuqc.js";function de(n){return b({url:"/CaruCourse/CaruCourse/list",method:"get",params:n})}function ie(n){return b({url:"/CaruCourse/CaruCourse/"+n,method:"get"})}function ce(n){return b({url:"/CaruCourse/CaruCourse",method:"post",data:n})}function Ce(n){return b({url:"/CaruCourse/CaruCourse",method:"put",data:n})}function pe(n){return b({url:"/CaruCourse/CaruCourse/"+n,method:"delete"})}const me={class:"app-container"},fe={class:"dialog-footer"},_e=ne({name:"CaruCourse"}),ve=Object.assign(_e,{setup(n){const{proxy:p}=se(),U=c([]),m=c(!1),x=c(!0),y=c(!0),S=c([]),P=c(!0),q=c(!0),V=c(0),R=c(""),L=oe({form:{},queryParams:{pageNum:1,pageSize:10,CaruCourseId:null},rules:{}}),{queryParams:s,form:f,rules:Q}=te(L);function g(){x.value=!0,de(s.value).then(u=>{U.value=u.rows,V.value=u.total,x.value=!1})}function j(){m.value=!1,$()}function $(){f.value={caruId:null,CaruCourseId:null},p.resetForm("CaruCourseRef")}function D(){s.value.pageNum=1,g()}function A(){p.resetForm("queryRef"),D()}function G(u){S.value=u.map(o=>o.caruId),P.value=u.length!=1,q.value=!u.length}function O(){$(),m.value=!0,R.value="添加首页轮播图展示的课程id"}function B(u){$();const o=u.caruId||S.value;ie(o).then(w=>{f.value=w.data,m.value=!0,R.value="修改首页轮播图展示的课程id"})}function H(){p.$refs.CaruCourseRef.validate(u=>{u&&(f.value.caruId!=null?Ce(f.value).then(o=>{p.$modal.msgSuccess("修改成功"),m.value=!1,g()}):ce(f.value).then(o=>{p.$modal.msgSuccess("新增成功"),m.value=!1,g()}))})}function E(u){const o=u.caruId||S.value;p.$modal.confirm('是否确认删除首页轮播图展示的课程id编号为"'+o+'"的数据项？').then(function(){return pe(o)}).then(()=>{g(),p.$modal.msgSuccess("删除成功")}).catch(()=>{})}function J(){p.download("CaruCourse/CaruCourse/export",{...s.value},`CaruCourse_${new Date().getTime()}.xlsx`)}return g(),(u,o)=>{const w=r("el-input"),N=r("el-form-item"),d=r("el-button"),T=r("el-form"),k=r("el-col"),M=r("right-toolbar"),W=r("el-row"),I=r("el-table-column"),X=r("el-table"),Y=r("pagination"),Z=r("el-dialog"),h=z("hasPermi"),ee=z("loading");return _(),le("div",me,[C(a(T,{model:t(s),ref:"queryRef",inline:!0,"label-width":"68px"},{default:e(()=>[a(N,{label:"轮播图课程id",prop:"CaruCourseId"},{default:e(()=>[a(w,{modelValue:t(s).CaruCourseId,"onUpdate:modelValue":o[0]||(o[0]=l=>t(s).CaruCourseId=l),placeholder:"请输入轮播图课程id",clearable:"",onKeyup:ue(D,["enter"])},null,8,["modelValue"])]),_:1}),a(N,null,{default:e(()=>[a(d,{type:"primary",icon:"Search",onClick:D},{default:e(()=>[i("搜索")]),_:1}),a(d,{icon:"Refresh",onClick:A},{default:e(()=>[i("重置")]),_:1})]),_:1})]),_:1},8,["model"]),[[F,t(y)]]),a(W,{gutter:10,class:"mb8"},{default:e(()=>[a(k,{span:1.5},{default:e(()=>[C((_(),v(d,{type:"primary",plain:"",icon:"Plus",onClick:O},{default:e(()=>[i("新增")]),_:1})),[[h,["CaruCourse:CaruCourse:add"]]])]),_:1}),a(k,{span:1.5},{default:e(()=>[C((_(),v(d,{type:"success",plain:"",icon:"Edit",disabled:t(P),onClick:B},{default:e(()=>[i("修改")]),_:1},8,["disabled"])),[[h,["CaruCourse:CaruCourse:edit"]]])]),_:1}),a(k,{span:1.5},{default:e(()=>[C((_(),v(d,{type:"danger",plain:"",icon:"Delete",disabled:t(q),onClick:E},{default:e(()=>[i("删除")]),_:1},8,["disabled"])),[[h,["CaruCourse:CaruCourse:remove"]]])]),_:1}),a(k,{span:1.5},{default:e(()=>[C((_(),v(d,{type:"warning",plain:"",icon:"Download",onClick:J},{default:e(()=>[i("导出")]),_:1})),[[h,["CaruCourse:CaruCourse:export"]]])]),_:1}),a(M,{showSearch:t(y),"onUpdate:showSearch":o[1]||(o[1]=l=>K(y)?y.value=l:null),onQueryTable:g},null,8,["showSearch"])]),_:1}),C((_(),v(X,{data:t(U),onSelectionChange:G},{default:e(()=>[a(I,{type:"selection",width:"55",align:"center"}),a(I,{label:"id",align:"center",prop:"caruId"}),a(I,{label:"轮播图课程id",align:"center",prop:"CaruCourseId"}),a(I,{label:"操作",align:"center","class-name":"small-padding fixed-width"},{default:e(l=>[C((_(),v(d,{link:"",type:"primary",icon:"Edit",onClick:ae=>B(l.row)},{default:e(()=>[i("修改")]),_:2},1032,["onClick"])),[[h,["CaruCourse:CaruCourse:edit"]]]),C((_(),v(d,{link:"",type:"primary",icon:"Delete",onClick:ae=>E(l.row)},{default:e(()=>[i("删除")]),_:2},1032,["onClick"])),[[h,["CaruCourse:CaruCourse:remove"]]])]),_:1})]),_:1},8,["data"])),[[ee,t(x)]]),C(a(Y,{total:t(V),page:t(s).pageNum,"onUpdate:page":o[2]||(o[2]=l=>t(s).pageNum=l),limit:t(s).pageSize,"onUpdate:limit":o[3]||(o[3]=l=>t(s).pageSize=l),onPagination:g},null,8,["total","page","limit"]),[[F,t(V)>0]]),a(Z,{title:t(R),modelValue:t(m),"onUpdate:modelValue":o[5]||(o[5]=l=>K(m)?m.value=l:null),width:"500px","append-to-body":""},{footer:e(()=>[re("div",fe,[a(d,{type:"primary",onClick:H},{default:e(()=>[i("确 定")]),_:1}),a(d,{onClick:j},{default:e(()=>[i("取 消")]),_:1})])]),default:e(()=>[a(T,{ref:"CaruCourseRef",model:t(f),rules:t(Q),"label-width":"80px"},{default:e(()=>[a(N,{label:"轮播图课程id",prop:"CaruCourseId"},{default:e(()=>[a(w,{modelValue:t(f).CaruCourseId,"onUpdate:modelValue":o[4]||(o[4]=l=>t(f).CaruCourseId=l),placeholder:"请输入轮播图课程id"},null,8,["modelValue"])]),_:1})]),_:1},8,["model","rules"])]),_:1},8,["title","modelValue"])])}}});export{ve as default};
