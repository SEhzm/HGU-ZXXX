import{u as me,r as p,C as fe,J as _e,$ as be,j as i,G as S,o as m,c as F,H as s,I as G,f as a,d as e,e as l,k as K,D as L,p as g,l as v,m as Y,z as Q,K as ge,L as ve,B as he,a0 as ye,v as we}from"./index-jM1GIEzG.js";import{a as Ce,b as Ne,s as ke,p as xe,d as Se}from"./gen-conCc7f1.js";import Ve from"./importTable-DUwkmToH.js";import $e from"./createTable-CvkUHgRi.js";const De={class:"app-container"},Re=he({name:"Gen"}),ze=Object.assign(Re,{setup(Te){const I=me(),{proxy:u}=we(),q=p([]),V=p(!0),k=p(!0),$=p([]),U=p(!0),D=p(!0),R=p(0),P=p([]),h=p([]),z=p(""),M=fe({queryParams:{pageNum:1,pageSize:10,tableName:void 0,tableComment:void 0},preview:{open:!1,title:"代码预览",data:{},activeName:"domain.java"}}),{queryParams:r,preview:f}=_e(M);be(()=>{const o=I.query.t;o!=null&&o!=z.value&&(z.value=o,r.value.pageNum=Number(I.query.pageNum),h.value=[],u.resetForm("queryForm"),y())});function y(){V.value=!0,Ce(u.addDateRange(r.value,h.value)).then(o=>{q.value=o.rows,R.value=o.total,V.value=!1})}function w(){r.value.pageNum=1,y()}function O(o){const t=o.tableName||P.value;if(t==""){u.$modal.msgError("请选择要生成的数据");return}o.genType==="1"?Ne(o.tableName).then(T=>{u.$modal.msgSuccess("成功生成到自定义路径："+o.genPath)}):u.$download.zip("/tool/gen/batchGenCode?tables="+t,"ruoyi.zip")}function A(o){const t=o.tableName;u.$modal.confirm('确认要强制同步"'+t+'"表结构吗？').then(function(){return ke(t)}).then(()=>{u.$modal.msgSuccess("同步成功")}).catch(()=>{})}function H(){u.$refs.importRef.show()}function J(){u.$refs.createRef.show()}function W(){h.value=[],u.resetForm("queryRef"),w()}function X(o){xe(o.tableId).then(t=>{f.value.data=t.data,f.value.open=!0,f.value.activeName="domain.java"})}function Z(){u.$modal.msgSuccess("复制成功")}function ee(o){$.value=o.map(t=>t.tableId),P.value=o.map(t=>t.tableName),U.value=o.length!=1,D.value=!o.length}function B(o){const t=o.tableId||$.value[0];ye.push({path:"/tool/gen-edit/index/"+t,query:{pageNum:r.value.pageNum}})}function E(o){const t=o.tableId||$.value;u.$modal.confirm('是否确认删除表编号为"'+t+'"的数据项？').then(function(){return Se(t)}).then(()=>{y(),u.$modal.msgSuccess("删除成功")}).catch(()=>{})}return y(),(o,t)=>{const T=i("el-input"),x=i("el-form-item"),te=i("el-date-picker"),d=i("el-button"),le=i("el-form"),C=i("el-col"),ae=i("right-toolbar"),ne=i("el-row"),b=i("el-table-column"),N=i("el-tooltip"),oe=i("el-table"),ie=i("pagination"),re=i("el-link"),se=i("el-tab-pane"),ue=i("el-tabs"),de=i("el-dialog"),_=S("hasPermi"),ce=S("hasRole"),pe=S("loading"),j=S("copyText");return m(),F("div",De,[s(e(le,{model:a(r),ref:"queryRef",inline:!0},{default:l(()=>[e(x,{label:"表名称",prop:"tableName"},{default:l(()=>[e(T,{modelValue:a(r).tableName,"onUpdate:modelValue":t[0]||(t[0]=n=>a(r).tableName=n),placeholder:"请输入表名称",clearable:"",style:{width:"200px"},onKeyup:K(w,["enter"])},null,8,["modelValue"])]),_:1}),e(x,{label:"表描述",prop:"tableComment"},{default:l(()=>[e(T,{modelValue:a(r).tableComment,"onUpdate:modelValue":t[1]||(t[1]=n=>a(r).tableComment=n),placeholder:"请输入表描述",clearable:"",style:{width:"200px"},onKeyup:K(w,["enter"])},null,8,["modelValue"])]),_:1}),e(x,{label:"创建时间",style:{width:"308px"}},{default:l(()=>[e(te,{modelValue:a(h),"onUpdate:modelValue":t[2]||(t[2]=n=>L(h)?h.value=n:null),"value-format":"YYYY-MM-DD",type:"daterange","range-separator":"-","start-placeholder":"开始日期","end-placeholder":"结束日期"},null,8,["modelValue"])]),_:1}),e(x,null,{default:l(()=>[e(d,{type:"primary",icon:"Search",onClick:w},{default:l(()=>[g("搜索")]),_:1}),e(d,{icon:"Refresh",onClick:W},{default:l(()=>[g("重置")]),_:1})]),_:1})]),_:1},8,["model"]),[[G,a(k)]]),e(ne,{gutter:10,class:"mb8"},{default:l(()=>[e(C,{span:1.5},{default:l(()=>[s((m(),v(d,{type:"primary",plain:"",icon:"Download",disabled:a(D),onClick:O},{default:l(()=>[g("生成")]),_:1},8,["disabled"])),[[_,["tool:gen:code"]]])]),_:1}),e(C,{span:1.5},{default:l(()=>[s((m(),v(d,{type:"primary",plain:"",icon:"Plus",onClick:J},{default:l(()=>[g("创建")]),_:1})),[[ce,["admin"]]])]),_:1}),e(C,{span:1.5},{default:l(()=>[s((m(),v(d,{type:"info",plain:"",icon:"Upload",onClick:H},{default:l(()=>[g("导入")]),_:1})),[[_,["tool:gen:import"]]])]),_:1}),e(C,{span:1.5},{default:l(()=>[s((m(),v(d,{type:"success",plain:"",icon:"Edit",disabled:a(U),onClick:B},{default:l(()=>[g("修改")]),_:1},8,["disabled"])),[[_,["tool:gen:edit"]]])]),_:1}),e(C,{span:1.5},{default:l(()=>[s((m(),v(d,{type:"danger",plain:"",icon:"Delete",disabled:a(D),onClick:E},{default:l(()=>[g("删除")]),_:1},8,["disabled"])),[[_,["tool:gen:remove"]]])]),_:1}),e(ae,{showSearch:a(k),"onUpdate:showSearch":t[3]||(t[3]=n=>L(k)?k.value=n:null),onQueryTable:y},null,8,["showSearch"])]),_:1}),s((m(),v(oe,{data:a(q),onSelectionChange:ee},{default:l(()=>[e(b,{type:"selection",align:"center",width:"55"}),e(b,{label:"序号",type:"index",width:"50",align:"center"},{default:l(n=>[Y("span",null,Q((a(r).pageNum-1)*a(r).pageSize+n.$index+1),1)]),_:1}),e(b,{label:"表名称",align:"center",prop:"tableName","show-overflow-tooltip":!0}),e(b,{label:"表描述",align:"center",prop:"tableComment","show-overflow-tooltip":!0}),e(b,{label:"实体",align:"center",prop:"className","show-overflow-tooltip":!0}),e(b,{label:"创建时间",align:"center",prop:"createTime",width:"160"}),e(b,{label:"更新时间",align:"center",prop:"updateTime",width:"160"}),e(b,{label:"操作",align:"center",width:"330","class-name":"small-padding fixed-width"},{default:l(n=>[e(N,{content:"预览",placement:"top"},{default:l(()=>[s(e(d,{link:"",type:"primary",icon:"View",onClick:c=>X(n.row)},null,8,["onClick"]),[[_,["tool:gen:preview"]]])]),_:2},1024),e(N,{content:"编辑",placement:"top"},{default:l(()=>[s(e(d,{link:"",type:"primary",icon:"Edit",onClick:c=>B(n.row)},null,8,["onClick"]),[[_,["tool:gen:edit"]]])]),_:2},1024),e(N,{content:"删除",placement:"top"},{default:l(()=>[s(e(d,{link:"",type:"primary",icon:"Delete",onClick:c=>E(n.row)},null,8,["onClick"]),[[_,["tool:gen:remove"]]])]),_:2},1024),e(N,{content:"同步",placement:"top"},{default:l(()=>[s(e(d,{link:"",type:"primary",icon:"Refresh",onClick:c=>A(n.row)},null,8,["onClick"]),[[_,["tool:gen:edit"]]])]),_:2},1024),e(N,{content:"生成代码",placement:"top"},{default:l(()=>[s(e(d,{link:"",type:"primary",icon:"Download",onClick:c=>O(n.row)},null,8,["onClick"]),[[_,["tool:gen:code"]]])]),_:2},1024)]),_:1})]),_:1},8,["data"])),[[pe,a(V)]]),s(e(ie,{total:a(R),page:a(r).pageNum,"onUpdate:page":t[4]||(t[4]=n=>a(r).pageNum=n),limit:a(r).pageSize,"onUpdate:limit":t[5]||(t[5]=n=>a(r).pageSize=n),onPagination:y},null,8,["total","page","limit"]),[[G,a(R)>0]]),e(de,{title:a(f).title,modelValue:a(f).open,"onUpdate:modelValue":t[7]||(t[7]=n=>a(f).open=n),width:"80%",top:"5vh","append-to-body":"",class:"scrollbar"},{default:l(()=>[e(ue,{modelValue:a(f).activeName,"onUpdate:modelValue":t[6]||(t[6]=n=>a(f).activeName=n)},{default:l(()=>[(m(!0),F(ge,null,ve(a(f).data,(n,c)=>(m(),v(se,{label:c.substring(c.lastIndexOf("/")+1,c.indexOf(".vm")),name:c.substring(c.lastIndexOf("/")+1,c.indexOf(".vm")),key:n},{default:l(()=>[s((m(),v(re,{underline:!1,icon:"DocumentCopy",style:{float:"right"}},{default:l(()=>[g(" 复制")]),_:2},1024)),[[j,n],[j,Z,"callback"]]),Y("pre",null,Q(n),1)]),_:2},1032,["label","name"]))),128))]),_:1},8,["modelValue"])]),_:1},8,["title","modelValue"]),e(a(Ve),{ref:"importRef",onOk:w},null,512),e(a($e),{ref:"createRef",onOk:w},null,512)])}}});export{ze as default};
