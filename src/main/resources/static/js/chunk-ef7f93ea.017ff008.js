(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-ef7f93ea"],{"6fbd":function(t,e,a){"use strict";a.r(e);var r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("VanSteps",{attrs:{active:t.active}},[a("VanStep",[t._v("买家下单")]),a("VanStep",[t._v("买家付款")]),a("VanStep",[t._v("卖家发货")]),a("VanStep",[t._v("买家收货")]),a("VanStep",[t._v("交易完成")])],1),t.flag?a("OrderCard",{attrs:{place:"OrderDetail",order:t.order,value:t.order.countCommodity}}):t._e(),a("ARow",{staticClass:"messageBlock"},[a("ARow",{style:{"font-size":"4vw","font-weight":"bold"}},[t._v(" 订单详情： ")]),a("ARow",{style:{"font-size":"3vw"}},[a("ACol",{attrs:{span:"8"}},[t._v(" 订单号： ")]),a("ACol",[t._v(" "+t._s(t.information.orderId)+" ")])],1),a("ARow",{style:{"font-size":"3vw"}},[a("ACol",{attrs:{span:"8"}},[t._v(" 邮寄地址： ")]),a("ACol",[t._v(" "+t._s(t.information.addressDetails)+" ")])],1),t._l(t.information.statusDate,(function(e,r){return a("ARow",{key:r,style:{"font-size":"3vw"}},[1===e.id?a("ARow",[a("ACol",{attrs:{span:"8"}},[t._v(" 创建时间： ")]),a("ACol",[t._v(" "+t._s(e.date)+" ")])],1):t._e(),2===e.id?a("ARow",[a("ACol",{attrs:{span:"8"}},[t._v(" 付款时间： ")]),a("ACol",[t._v(" "+t._s(e.date)+" ")])],1):t._e(),3===e.id?a("ARow",[a("ACol",{attrs:{span:"8"}},[t._v(" 发货时间： ")]),a("ACol",[t._v(" "+t._s(e.date)+" ")])],1):t._e(),4===e.id?a("ARow",[a("ACol",{attrs:{span:"8"}},[t._v(" 完成时间： ")]),a("ACol",[t._v(" "+t._s(e.date)+" ")])],1):t._e(),5===e.id?a("ARow",[a("ACol",{attrs:{span:"8"}},[t._v(" 评价时间： ")]),a("ACol",[t._v(" "+t._s(e.date)+" ")])],1):t._e(),6===e.id?a("ARow",[a("ACol",{attrs:{span:"8"}},[t._v(" 取消时间： ")]),a("ACol",[t._v(" "+t._s(e.date)+" ")])],1):t._e()],1)}))],2),1===t.active?a("ARow",{style:{margin:"10px"}},[a("ARow",{style:{"font-size":"4vw","font-weight":"bold"}},[t._v(" 商品已下单，请尽快付款 ")]),a("VanButton",{staticClass:"button",attrs:{color:"#3737e3"},on:{click:t.pay}},[t._v(" 立即付款 ")])],1):t._e(),2===t.active?a("ARow",{style:{margin:"10px"}},[a("ARow",{style:{"font-size":"4vw","font-weight":"bold"}},[t._v(" 请耐心等待卖家发货..."),a("br"),t._v(" 等不及了？催促卖家试试 ")]),a("VanButton",{staticClass:"button",attrs:{color:"#3737e3"},on:{click:t.sentMessage}},[t._v(" 催促卖家 ")])],1):t._e(),3===t.active?a("ARow",{style:{margin:"10px"}},[a("ARow",{style:{"font-size":"4vw","font-weight":"bold"}},[t._v(" 请确认收到商品，再确认收货，切勿提前收货 ")]),a("VanButton",{staticClass:"button",attrs:{color:"#3737e3"},on:{click:t.recieveConfirm}},[t._v(" 确认收货 ")])],1):t._e(),4===t.information.recordId?a("ARow",{style:{margin:"10px"}},[a("ARow",{style:{"font-size":"4vw","font-weight":"bold"}},[t._v(" 可以跟更多的人分享购物体验哦 ")]),a("VanField",{attrs:{rows:"2",autosize:"",label:"评论",type:"textarea",maxlength:"100",placeholder:"请输入留言","show-word-limit":""},model:{value:t.message,callback:function(e){t.message=e},expression:"message"}}),a("VanButton",{style:{width:"40%","margin-left":"9%"},attrs:{color:"orange",round:"",type:"info"},on:{click:function(e){return t.postComment(!1)}}},[t._v(" 属实拉胯 ")]),a("div",{style:{width:"2%",display:"inline-block"}}),a("VanButton",{style:{width:"40%"},attrs:{color:"#00CCFF",round:"",type:"info"},on:{click:function(e){return t.postComment(!0)}}},[t._v(" 特别好评 ")])],1):t._e()],1)},o=[],n=a("1da1"),i=(a("96cf"),a("a9e3"),a("d3b7"),a("3ca3"),a("ddb0"),a("e447")),s=a("d399"),d={name:"OrderDetail",data:function(){return{flag:!1,active:1,place:"OrderDetail",message:"",order:null,id:Number,information:{orderId:Number,shopName:String,countCommodity:Number,commodityName:String,subName:String,price:Number,itemName:String,subIcon:String,statusDate:[],addressDetails:String,recordId:Number,cid:Number,sid:Number}}},methods:{pay:function(){var t=this;return Object(n["a"])(regeneratorRuntime.mark((function e(){var r,o,n,i;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,a.e("chunk-4a8a29de").then(a.bind(null,"31ca"));case 2:return r=e.sent,o=r.$,n=new FormData,n.append("orderId",t.id),n.append("recordId",2),e.next=9,o.put("/orderStateflow",n);case 9:i=e.sent,console.log(i),window.location.href="http://localhost:8081/Alipay?orderId=".concat(t.id);case 12:case"end":return e.stop()}}),e)})))()},recieveConfirm:function(){var t=this;return Object(n["a"])(regeneratorRuntime.mark((function e(){var r,o,n,i;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,a.e("chunk-4a8a29de").then(a.bind(null,"31ca"));case 2:return r=e.sent,o=r.$,n=new FormData,n.append("orderId",t.id),n.append("recordId",4),e.next=9,o.put("/orderStateflow",n);case 9:if(i=e.sent,!i.data.success){e.next=15;break}return e.next=13,t.reload();case 13:e.next=16;break;case 15:Object(s["a"])("确认收货失败");case 16:case"end":return e.stop()}}),e)})))()},sentMessage:function(){var t=this;return Object(n["a"])(regeneratorRuntime.mark((function e(){var r,o,n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,a.e("chunk-4a8a29de").then(a.bind(null,"31ca"));case 2:return r=e.sent,o=r.$,n=new FormData,n.append("myType","用户"),n.append("oppId",t.information.sid),n.append("oppType","商家"),n.append("chatContent","gkd，发货！"),e.next=11,o.post("/user/sendChat",n);case 11:return e.next=13,t.$router.push({name:"私聊界面"});case 13:case"end":return e.stop()}}),e)})))()},postComment:function(t){var e=this;return Object(n["a"])(regeneratorRuntime.mark((function r(){var o,n,i,d,c;return regeneratorRuntime.wrap((function(r){while(1)switch(r.prev=r.next){case 0:if(""!==e.message){r.next=4;break}Object(s["a"])("请输入评论"),r.next=28;break;case 4:return r.next=6,a.e("chunk-4a8a29de").then(a.bind(null,"31ca"));case 6:return o=r.sent,n=o.$,i=new FormData,i.append("cid",e.information.cid),i.append("commentDetails",e.message),i.append("praise",t),r.next=14,n.post("/user/comment",i);case 14:if(d=r.sent,console.log(d),!d.data.success){r.next=27;break}return Object(s["a"])("评论成功"),c=new FormData,c.append("orderId",e.id),c.append("recordId",5),r.next=23,n.put("/orderStateflow",c);case 23:return r.next=25,e.reload();case 25:r.next=28;break;case 27:Object(s["a"])("评论失败");case 28:case"end":return r.stop()}}),r)})))()},reload:function(){var t=this;return Object(n["a"])(regeneratorRuntime.mark((function e(){var r,o,n,i;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return t.id=t.$store.state.orderId,e.next=3,a.e("chunk-4a8a29de").then(a.bind(null,"31ca"));case 3:return r=e.sent,o=r.$,e.next=7,o.get("/orderDetail?orderId=".concat(t.id));case 7:for(n=e.sent,console.log(n.data.information),t.order=n.data.information.order,t.information.itemName=n.data.information.state[0].recordId,t.information.addressDetails=n.data.information.order.addressDetails,t.information.subIcon=n.data.information.order.subIcon,t.information.orderId=n.data.information.order.orderId,t.information.shopName=n.data.information.order.shopName,t.information.countCommodity=n.data.information.order.countCommodity,t.information.commodityName=n.data.information.order.commodityName,t.information.subName=n.data.information.order.subName,t.information.price=n.data.information.order.price,i=0;i<n.data.information.state.length;i++)t.information.statusDate.unshift({id:n.data.information.state[i].recordId,date:n.data.information.state[i].statusDate[0]+"."+n.data.information.state[i].statusDate[1]+"."+n.data.information.state[i].statusDate[2]+" "+n.data.information.state[i].statusDate[3]+":"+n.data.information.state[i].statusDate[4]+":"+n.data.information.state[i].statusDate[5]});t.information.recordId=n.data.information.state[0].recordId,t.information.cid=n.data.information.order.cid,t.information.sid=n.data.information.order.sid,t.information.recordId>=4?t.active=4:t.active=t.information.recordId,t.flag=!0;case 25:case"end":return e.stop()}}),e)})))()}},components:{OrderCard:i["a"]},created:function(){var t=this;return Object(n["a"])(regeneratorRuntime.mark((function e(){var r,o,n,i;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return t.id=t.$store.state.orderId,e.next=3,a.e("chunk-4a8a29de").then(a.bind(null,"31ca"));case 3:return r=e.sent,o=r.$,e.next=7,o.get("/orderDetail?orderId=".concat(t.id));case 7:for(n=e.sent,console.log(n.data.information),t.order=n.data.information.order,t.information.itemName=n.data.information.state[0].recordId,t.information.addressDetails=n.data.information.order.addressDetails,t.information.subIcon=n.data.information.order.subIcon,t.information.orderId=n.data.information.order.orderId,t.information.shopName=n.data.information.order.shopName,t.information.countCommodity=n.data.information.order.countCommodity,t.information.commodityName=n.data.information.order.commodityName,t.information.subName=n.data.information.order.subName,t.information.price=n.data.information.order.price,i=0;i<n.data.information.state.length;i++)t.information.statusDate.unshift({id:n.data.information.state[i].recordId,date:n.data.information.state[i].statusDate[0]+"."+n.data.information.state[i].statusDate[1]+"."+n.data.information.state[i].statusDate[2]+" "+n.data.information.state[i].statusDate[3]+":"+n.data.information.state[i].statusDate[4]+":"+n.data.information.state[i].statusDate[5]});t.information.recordId=n.data.information.state[0].recordId,t.information.cid=n.data.information.order.cid,t.information.sid=n.data.information.order.sid,t.information.recordId>=4?t.active=4:t.active=t.information.recordId,t.flag=!0;case 25:case"end":return e.stop()}}),e)})))()}},c=d,m=(a("a2f9"),a("2877")),u=Object(m["a"])(c,r,o,!1,null,"d2779bf0",null);e["default"]=u.exports},a2f9:function(t,e,a){"use strict";a("fec7")},bb44:function(t,e,a){},e447:function(t,e,a){"use strict";var r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"card"},["SetOrder"!==t.place?a("van-cell",{style:{"font-weight":"bold","font-size":"120%","border-radius":"25px"},attrs:{"is-link":""},on:{click:t.toShop}},[a("van-icon",{attrs:{name:"shop-o"}}),t._v(" "+t._s(t.order.shopName)+" ")],1):a("van-cell",{style:{"font-weight":"bold","font-size":"120%","border-radius":"25px"}},[a("van-icon",{attrs:{name:"shop-o"}}),t._v(" "+t._s(t.order.shopName)+" ")],1),"OrderManage"===t.place?a("ARow",{staticStyle:{color:"red","font-weight":"bold","margin-left":"20px"},attrs:{span:"12"}},[t._v(" 订单"+t._s(t.order.itemName)+" ")]):t._e(),a("ARow",{attrs:{type:"flex",justify:"end"}},[a("ACol",{attrs:{span:"10"}},[a("div",[a("img",{staticClass:"goodsPicture",attrs:{src:t.order.subIcon}})])]),a("ACol",{attrs:{span:"1"}}),a("ACol",{attrs:{span:"12"}},[a("div",{style:{"font-weight":"bold","font-size":"3vw",color:"black"}},[a("span",[t._v(" "+t._s(t.order.commodityName)+" ")]),a("br"),a("span",{style:{"font-size":"2vw",color:"grey"}},[t._v(" "+t._s(t.order.subName)+" ")])])]),a("ACol",{style:{"font-size":"2vw",color:"grey"}},[t._v(" ￥ "+t._s(t.order.price)+" *"+t._s(t.value)+" ")])],1),a("ARow",{attrs:{justify:"end",type:"flex"}},[a("ACol",{style:{"font-weight":"bold","font-size":"3vw",color:"grey"}},[t._v(" 总价：￥ "+t._s(t.order.price*t.value)+" ")])],1),"OrderManage"===t.place?a("ARow",{attrs:{justify:"end",type:"flex"}},[a("ACol",[a("van-button",{style:{height:"35px","margin-right":"5px",width:"25vw"},attrs:{round:"",type:"info",color:"orange"},on:{click:t.toOrderDetail}},[t._v("查看详情")])],1)],1):t._e()],1)},o=[],n=(a("a9e3"),{props:{place:String,order:null,value:Number},name:"Card",data:function(){return{buttonType:null,goodAmount:0}},methods:{toShop:function(){this.$router.push({path:"/Shop"})},toOrderDetail:function(){this.$store.state.orderId=this.order.orderId,this.$router.push({path:"/OrderDetail"})}}}),i=n,s=(a("f25b"),a("2877")),d=Object(s["a"])(i,r,o,!1,null,"29ee5940",null);e["a"]=d.exports},f25b:function(t,e,a){"use strict";a("bb44")},fec7:function(t,e,a){}}]);