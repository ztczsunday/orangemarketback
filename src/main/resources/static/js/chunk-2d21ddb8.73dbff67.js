(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d21ddb8"],{d2a5:function(e,t,n){"use strict";n.r(t);var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("VanTabs",{model:{value:e.active,callback:function(t){e.active=t},expression:"active"}},[n("VanTab",{attrs:{title:"商品"}},[n("VanList",{attrs:{finished:e.commodities.finished,"finished-text":"没有更多了"},on:{load:e.onLoadCommodity},model:{value:e.commodities.loading,callback:function(t){e.$set(e.commodities,"loading",t)},expression:"commodities.loading"}},e._l(e.commodities.items,(function(t,a){return n("VanCard",{key:a,attrs:{thumb:t.mainIcon,title:t.commodityName},on:{click:function(n){return e.$router.push("/ProductDetail?cid="+t.cid)}}})})),1)],1),n("VanTab",{attrs:{title:"店铺"}},[n("VanList",{attrs:{finished:e.shop.finished,"finished-text":"没有更多了"},on:{load:e.onLoadShop},model:{value:e.shop.loading,callback:function(t){e.$set(e.shop,"loading",t)},expression:"shop.loading"}},e._l(e.shop.items,(function(t,a){return n("VanCard",{key:a,attrs:{thumb:t.shopIcon,title:t.shopName},on:{click:function(n){return e.$router.push("/Shop?sid="+t.sid)}},scopedSlots:e._u([{key:"tags",fn:function(){return[n("van-tag",{attrs:{plain:"",type:"danger"}},[e._v("好评数："+e._s(t.praiseCount))]),n("van-tag",{attrs:{plain:"",type:"primary"}},[e._v("评论数："+e._s(t.commentCount))])]},proxy:!0}],null,!0)})})),1)],1)],1)],1)},o=[],i=n("1da1"),s=(n("96cf"),n("d3b7"),n("3ca3"),n("ddb0"),{name:"Favorite",created:function(){},data:function(){return{active:null,shop:{loading:null,finished:!1,nowPage:0,pageSize:10,items:[]},commodities:{loading:null,finished:!1,nowPage:0,pageSize:10,items:[]}}},methods:{onLoadCommodity:function(){var e=this;return Object(i["a"])(regeneratorRuntime.mark((function t(){var a,o,i,s,r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,n.e("chunk-4a8a29de").then(n.bind(null,"31ca"));case 2:return a=t.sent,o=a.$,i=new FormData,i.append("pages",e.nowPage),i.append("pageSize",e.pageSize),t.next=9,o.get("/favoritesCommodity");case 9:s=t.sent,r=s.data.information,Array.prototype.push.apply(e.commodities.items,r.records),e.commodities.nowPage++,e.commodities.finished=e.commodities.nowPage>=r.total/r.size;case 14:case"end":return t.stop()}}),t)})))()},onLoadShop:function(){var e=this;return Object(i["a"])(regeneratorRuntime.mark((function t(){var a,o,i,s,r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,n.e("chunk-4a8a29de").then(n.bind(null,"31ca"));case 2:return a=t.sent,o=a.$,i=new FormData,i.append("pages",e.nowPage),i.append("pageSize",e.pageSize),t.next=9,o.get("/favoritesShop");case 9:s=t.sent,r=s.data.information,Array.prototype.push.apply(e.shop.items,r.records),e.shop.nowPage++,e.shop.finished=e.shop.nowPage>=r.total/r.size;case 14:case"end":return t.stop()}}),t)})))()}}}),r=s,c=n("2877"),d=Object(c["a"])(r,a,o,!1,null,"0b0f8c6e",null);t["default"]=d.exports}}]);