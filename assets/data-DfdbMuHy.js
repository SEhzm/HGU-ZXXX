import{r as c,u as Ve,C as we,R as he,j as u,O as H,o as i,c as w,P as b,Q as M,f as t,d as l,e as a,G as S,H as D,l as m,k as ke,p as r,M as W,z as U,S as Te,m as X,B as Se,v as De,T as Ue,U as xe,V as Le,W as B,X as Re,Y as $e}from"./index-CAKBMZA9.js";import{g as Ne,o as Pe}from"./type-DBDx8j8V.js";const qe={class:"app-container"},ze={key:0},Be={class:"dialog-footer"},Oe=Se({name:"Data"}),je=Object.assign(Oe,{setup(Ee){const{proxy:_}=De(),{sys_normal_disable:x}=_.useDict("sys_normal_disable"),O=c([]),g=c(!1),L=c(!0),T=c(!0),R=c([]),E=c(!0),F=c(!0),$=c(0),N=c(""),Q=c(""),j=c([]),I=Ve(),Y=c([{value:"default",label:"默认"},{value:"primary",label:"主要"},{value:"success",label:"成功"},{value:"info",label:"信息"},{value:"warning",label:"警告"},{value:"danger",label:"危险"}]),J=we({form:{},queryParams:{pageNum:1,pageSize:10,dictType:void 0,dictLabel:void 0,status:void 0},rules:{dictLabel:[{required:!0,message:"数据标签不能为空",trigger:"blur"}],dictValue:[{required:!0,message:"数据键值不能为空",trigger:"blur"}],dictSort:[{required:!0,message:"数据顺序不能为空",trigger:"blur"}]}}),{queryParams:d,form:n,rules:Z}=he(J);function ee(s){Ne(s).then(o=>{d.value.dictType=o.data.dictType,Q.value=o.data.dictType,y()})}function le(){Pe().then(s=>{j.value=s.data})}function y(){L.value=!0,Ue(d.value).then(s=>{O.value=s.rows,$.value=s.total,L.value=!1})}function te(){g.value=!1,P()}function P(){n.value={dictCode:void 0,dictLabel:void 0,dictValue:void 0,cssClass:void 0,listClass:"default",dictSort:0,status:"0",remark:void 0},_.resetForm("dataRef")}function q(){d.value.pageNum=1,y()}function ae(){const s={path:"/system/dict"};_.$tab.closeOpenPage(s)}function oe(){_.resetForm("queryRef"),d.value.dictType=Q.value,q()}function ne(){P(),g.value=!0,N.value="添加字典数据",n.value.dictType=d.value.dictType}function de(s){R.value=s.map(o=>o.dictCode),E.value=s.length!=1,F.value=!s.length}function K(s){P();const o=s.dictCode||R.value;xe(o).then(h=>{n.value=h.data,g.value=!0,N.value="修改字典数据"})}function se(){_.$refs.dataRef.validate(s=>{s&&(n.value.dictCode!=null?Le(n.value).then(o=>{B().removeDict(d.value.dictType),_.$modal.msgSuccess("修改成功"),g.value=!1,y()}):Re(n.value).then(o=>{B().removeDict(d.value.dictType),_.$modal.msgSuccess("新增成功"),g.value=!1,y()}))})}function A(s){const o=s.dictCode||R.value;_.$modal.confirm('是否确认删除字典编码为"'+o+'"的数据项？').then(function(){return $e(o)}).then(()=>{y(),_.$modal.msgSuccess("删除成功"),B().removeDict(d.value.dictType)}).catch(()=>{})}function ue(){_.download("system/dict/data/export",{...d.value},`dict_data_${new Date().getTime()}.xlsx`)}return ee(I.params&&I.params.dictId),le(),(s,o)=>{const h=u("el-option"),z=u("el-select"),p=u("el-form-item"),C=u("el-input"),f=u("el-button"),G=u("el-form"),k=u("el-col"),ie=u("right-toolbar"),re=u("el-row"),v=u("el-table-column"),pe=u("el-tag"),ce=u("dict-tag"),me=u("el-table"),fe=u("pagination"),_e=u("el-input-number"),ve=u("el-radio"),be=u("el-radio-group"),ge=u("el-dialog"),V=H("hasPermi"),ye=H("loading");return i(),w("div",qe,[b(l(G,{model:t(d),ref:"queryRef",inline:!0},{default:a(()=>[l(p,{label:"字典名称",prop:"dictType"},{default:a(()=>[l(z,{modelValue:t(d).dictType,"onUpdate:modelValue":o[0]||(o[0]=e=>t(d).dictType=e),style:{width:"200px"}},{default:a(()=>[(i(!0),w(S,null,D(t(j),e=>(i(),m(h,{key:e.dictId,label:e.dictName,value:e.dictType},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(p,{label:"字典标签",prop:"dictLabel"},{default:a(()=>[l(C,{modelValue:t(d).dictLabel,"onUpdate:modelValue":o[1]||(o[1]=e=>t(d).dictLabel=e),placeholder:"请输入字典标签",clearable:"",style:{width:"200px"},onKeyup:ke(q,["enter"])},null,8,["modelValue"])]),_:1}),l(p,{label:"状态",prop:"status"},{default:a(()=>[l(z,{modelValue:t(d).status,"onUpdate:modelValue":o[2]||(o[2]=e=>t(d).status=e),placeholder:"数据状态",clearable:"",style:{width:"200px"}},{default:a(()=>[(i(!0),w(S,null,D(t(x),e=>(i(),m(h,{key:e.value,label:e.label,value:e.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(p,null,{default:a(()=>[l(f,{type:"primary",icon:"Search",onClick:q},{default:a(()=>[r("搜索")]),_:1}),l(f,{icon:"Refresh",onClick:oe},{default:a(()=>[r("重置")]),_:1})]),_:1})]),_:1},8,["model"]),[[M,t(T)]]),l(re,{gutter:10,class:"mb8"},{default:a(()=>[l(k,{span:1.5},{default:a(()=>[b((i(),m(f,{type:"primary",plain:"",icon:"Plus",onClick:ne},{default:a(()=>[r("新增")]),_:1})),[[V,["system:dict:add"]]])]),_:1}),l(k,{span:1.5},{default:a(()=>[b((i(),m(f,{type:"success",plain:"",icon:"Edit",disabled:t(E),onClick:K},{default:a(()=>[r("修改")]),_:1},8,["disabled"])),[[V,["system:dict:edit"]]])]),_:1}),l(k,{span:1.5},{default:a(()=>[b((i(),m(f,{type:"danger",plain:"",icon:"Delete",disabled:t(F),onClick:A},{default:a(()=>[r("删除")]),_:1},8,["disabled"])),[[V,["system:dict:remove"]]])]),_:1}),l(k,{span:1.5},{default:a(()=>[b((i(),m(f,{type:"warning",plain:"",icon:"Download",onClick:ue},{default:a(()=>[r("导出")]),_:1})),[[V,["system:dict:export"]]])]),_:1}),l(k,{span:1.5},{default:a(()=>[l(f,{type:"warning",plain:"",icon:"Close",onClick:ae},{default:a(()=>[r("关闭")]),_:1})]),_:1}),l(ie,{showSearch:t(T),"onUpdate:showSearch":o[3]||(o[3]=e=>W(T)?T.value=e:null),onQueryTable:y},null,8,["showSearch"])]),_:1}),b((i(),m(me,{data:t(O),onSelectionChange:de},{default:a(()=>[l(v,{type:"selection",width:"55",align:"center"}),l(v,{label:"字典编码",align:"center",prop:"dictCode"}),l(v,{label:"字典标签",align:"center",prop:"dictLabel"},{default:a(e=>[(e.row.listClass==""||e.row.listClass=="default")&&(e.row.cssClass==""||e.row.cssClass==null)?(i(),w("span",ze,U(e.row.dictLabel),1)):(i(),m(pe,{key:1,type:e.row.listClass=="primary"?"":e.row.listClass,class:Te(e.row.cssClass)},{default:a(()=>[r(U(e.row.dictLabel),1)]),_:2},1032,["type","class"]))]),_:1}),l(v,{label:"字典键值",align:"center",prop:"dictValue"}),l(v,{label:"字典排序",align:"center",prop:"dictSort"}),l(v,{label:"状态",align:"center",prop:"status"},{default:a(e=>[l(ce,{options:t(x),value:e.row.status},null,8,["options","value"])]),_:1}),l(v,{label:"备注",align:"center",prop:"remark","show-overflow-tooltip":!0}),l(v,{label:"创建时间",align:"center",prop:"createTime",width:"180"},{default:a(e=>[X("span",null,U(s.parseTime(e.row.createTime)),1)]),_:1}),l(v,{label:"操作",align:"center",width:"160","class-name":"small-padding fixed-width"},{default:a(e=>[b((i(),m(f,{link:"",type:"primary",icon:"Edit",onClick:Ce=>K(e.row)},{default:a(()=>[r("修改")]),_:2},1032,["onClick"])),[[V,["system:dict:edit"]]]),b((i(),m(f,{link:"",type:"primary",icon:"Delete",onClick:Ce=>A(e.row)},{default:a(()=>[r("删除")]),_:2},1032,["onClick"])),[[V,["system:dict:remove"]]])]),_:1})]),_:1},8,["data"])),[[ye,t(L)]]),b(l(fe,{total:t($),page:t(d).pageNum,"onUpdate:page":o[4]||(o[4]=e=>t(d).pageNum=e),limit:t(d).pageSize,"onUpdate:limit":o[5]||(o[5]=e=>t(d).pageSize=e),onPagination:y},null,8,["total","page","limit"]),[[M,t($)>0]]),l(ge,{title:t(N),modelValue:t(g),"onUpdate:modelValue":o[14]||(o[14]=e=>W(g)?g.value=e:null),width:"500px","append-to-body":""},{footer:a(()=>[X("div",Be,[l(f,{type:"primary",onClick:se},{default:a(()=>[r("确 定")]),_:1}),l(f,{onClick:te},{default:a(()=>[r("取 消")]),_:1})])]),default:a(()=>[l(G,{ref:"dataRef",model:t(n),rules:t(Z),"label-width":"80px"},{default:a(()=>[l(p,{label:"字典类型"},{default:a(()=>[l(C,{modelValue:t(n).dictType,"onUpdate:modelValue":o[6]||(o[6]=e=>t(n).dictType=e),disabled:!0},null,8,["modelValue"])]),_:1}),l(p,{label:"数据标签",prop:"dictLabel"},{default:a(()=>[l(C,{modelValue:t(n).dictLabel,"onUpdate:modelValue":o[7]||(o[7]=e=>t(n).dictLabel=e),placeholder:"请输入数据标签"},null,8,["modelValue"])]),_:1}),l(p,{label:"数据键值",prop:"dictValue"},{default:a(()=>[l(C,{modelValue:t(n).dictValue,"onUpdate:modelValue":o[8]||(o[8]=e=>t(n).dictValue=e),placeholder:"请输入数据键值"},null,8,["modelValue"])]),_:1}),l(p,{label:"样式属性",prop:"cssClass"},{default:a(()=>[l(C,{modelValue:t(n).cssClass,"onUpdate:modelValue":o[9]||(o[9]=e=>t(n).cssClass=e),placeholder:"请输入样式属性"},null,8,["modelValue"])]),_:1}),l(p,{label:"显示排序",prop:"dictSort"},{default:a(()=>[l(_e,{modelValue:t(n).dictSort,"onUpdate:modelValue":o[10]||(o[10]=e=>t(n).dictSort=e),"controls-position":"right",min:0},null,8,["modelValue"])]),_:1}),l(p,{label:"回显样式",prop:"listClass"},{default:a(()=>[l(z,{modelValue:t(n).listClass,"onUpdate:modelValue":o[11]||(o[11]=e=>t(n).listClass=e)},{default:a(()=>[(i(!0),w(S,null,D(t(Y),e=>(i(),m(h,{key:e.value,label:e.label+"("+e.value+")",value:e.value},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(p,{label:"状态",prop:"status"},{default:a(()=>[l(be,{modelValue:t(n).status,"onUpdate:modelValue":o[12]||(o[12]=e=>t(n).status=e)},{default:a(()=>[(i(!0),w(S,null,D(t(x),e=>(i(),m(ve,{key:e.value,value:e.value},{default:a(()=>[r(U(e.label),1)]),_:2},1032,["value"]))),128))]),_:1},8,["modelValue"])]),_:1}),l(p,{label:"备注",prop:"remark"},{default:a(()=>[l(C,{modelValue:t(n).remark,"onUpdate:modelValue":o[13]||(o[13]=e=>t(n).remark=e),type:"textarea",placeholder:"请输入内容"},null,8,["modelValue"])]),_:1})]),_:1},8,["model","rules"])]),_:1},8,["title","modelValue"])])}}});export{je as default};
