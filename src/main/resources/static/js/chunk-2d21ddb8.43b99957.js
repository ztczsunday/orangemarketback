(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d21ddb8"],{d2a5:function(e,n,t){"use strict";t.r(n);var a=function(){var e=this,n=e.$createElement,t=e._self._c||n;return t("div",[t("VanTabs",{model:{value:e.active,callback:function(n){e.active=n},expression:"active"}},[t("VanTab",{attrs:{title:"商品"}},[t("VanList",{attrs:{finished:e.commodities.finished,"finished-text":"没有更多了"},on:{load:e.onLoadCommodity},model:{value:e.commodities.loading,callback:function(n){e.$set(e.commodities,"loading",n)},expression:"commodities.loading"}},e._l(e.commodities.items,(function(n,a){return t("VanCard",{key:a,attrs:{thumb:n.mainIcon,title:n.commodityName},on:{click:function(t){return e.$router.push("/?cid="+n.cid)}}})})),1)],1),t("VanTab",{attrs:{title:"店铺"}},[t("VanList",{attrs:{finished:e.shop.finished,"finished-text":"没有更多了"},on:{load:e.onLoadShop},model:{value:e.shop.loading,callback:function(n){e.$set(e.shop,"loading",n)},expression:"shop.loading"}},e._l(e.shop.items,(function(n,a){return t("VanCard",{key:a,attrs:{thumb:n.shopIcon,title:n.shopName},on:{click:function(t){return e.$router.push("/?sid="+n.cid)}}})})),1)],1)],1)],1)},o=[],i=t("1da1"),s=(t("96cf"),t("d3b7"),t("3ca3"),t("ddb0"),{name:"Favorite",created:function(){},data:function(){return{active:null,shop:{loading:null,finished:!1,nowPage:0,pageSize:10,items:[]},commodities:{loading:null,finished:!1,nowPage:0,pageSize:10,items:[]}}},methods:{onLoadCommodity:function(){var e=this;return Object(i["a"])(regeneratorRuntime.mark((function n(){var a,o,i,s,r;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return n.next=2,t.e("chunk-4a8a29de").then(t.bind(null,"31ca"));case 2:return a=n.sent,o=a.$,i=new FormData,i.append("pages",e.nowPage),i.append("pageSize",e.pageSize),n.next=9,o.get("/favoritesCommodity");case 9:s=n.sent,r=s.data.information,Array.prototype.push.apply(e.commodities.items,r.records),e.commodities.nowPage++,e.commodities.finished=e.commodities.nowPage>=r.total/r.size;case 14:case"end":return n.stop()}}),n)})))()},onLoadShop:function(){var e=this;return Object(i["a"])(regeneratorRuntime.mark((function n(){var a,o,i,s,r;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return n.next=2,t.e("chunk-4a8a29de").then(t.bind(null,"31ca"));case 2:return a=n.sent,o=a.$,i=new FormData,i.append("pages",e.nowPage),i.append("pageSize",e.pageSize),n.next=9,o.get("/favoritesShop");case 9:s=n.sent,r=s.data.information,Array.prototype.push.apply(e.shop.items,r.records),e.shop.nowPage++,e.shop.finished=e.shop.nowPage>=r.total/r.size;case 14:case"end":return n.stop()}}),n)})))()}}}),r=s,c=t("2877"),d=Object(c["a"])(r,a,o,!1,null,"49a19eb9",null);n["default"]=d.exports}}]);