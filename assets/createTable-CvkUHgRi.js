import{c as y}from"./gen-conCc7f1.js";import{r as p,j as s,o as C,l as h,e as a,m as f,d as r,p as i,f as m,D as c,v as w}from"./index-jM1GIEzG.js";const T=f("span",null,"创建表语句(支持多个建表语句)：",-1),B={class:"dialog-footer"},U={__name:"createTable",emits:["ok"],setup(N,{expose:_,emit:v}){const e=p(!1),t=p(""),{proxy:u}=w(),V=v;function x(){e.value=!0}function b(){if(t.value===""){u.$modal.msgError("请输入建表语句");return}y({sql:t.value}).then(n=>{u.$modal.msgSuccess(n.msg),n.code===200&&(e.value=!1,V("ok"))})}return _({show:x}),(n,o)=>{const g=s("el-input"),d=s("el-button"),k=s("el-dialog");return C(),h(k,{title:"创建表",modelValue:m(e),"onUpdate:modelValue":o[2]||(o[2]=l=>c(e)?e.value=l:null),width:"800px",top:"5vh","append-to-body":""},{footer:a(()=>[f("div",B,[r(d,{type:"primary",onClick:b},{default:a(()=>[i("确 定")]),_:1}),r(d,{onClick:o[1]||(o[1]=l=>e.value=!1)},{default:a(()=>[i("取 消")]),_:1})])]),default:a(()=>[T,r(g,{type:"textarea",rows:10,placeholder:"请输入文本",modelValue:m(t),"onUpdate:modelValue":o[0]||(o[0]=l=>c(t)?t.value=l:null)},null,8,["modelValue"])]),_:1},8,["modelValue"])}}};export{U as default};
