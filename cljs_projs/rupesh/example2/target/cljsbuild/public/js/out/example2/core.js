// Compiled by ClojureScript 1.9.854 {}
goog.provide('example2.core');
goog.require('cljs.core');
goog.require('reagent.core');
goog.require('ajax.core');
goog.require('goog.History');
example2.core.server = "http://localhost:3000/";
example2.core.get_by_id = (function example2$core$get_by_id(id){
return document.getElementById(id);
});
example2.core.log = (function example2$core$log(var_args){
var args__40331__auto__ = [];
var len__40324__auto___45933 = arguments.length;
var i__40325__auto___45934 = (0);
while(true){
if((i__40325__auto___45934 < len__40324__auto___45933)){
args__40331__auto__.push((arguments[i__40325__auto___45934]));

var G__45935 = (i__40325__auto___45934 + (1));
i__40325__auto___45934 = G__45935;
continue;
} else {
}
break;
}

var argseq__40332__auto__ = ((((0) < args__40331__auto__.length))?(new cljs.core.IndexedSeq(args__40331__auto__.slice((0)),(0),null)):null);
return example2.core.log.cljs$core$IFn$_invoke$arity$variadic(argseq__40332__auto__);
});

example2.core.log.cljs$core$IFn$_invoke$arity$variadic = (function (params){
return console.log(cljs.core.apply.call(null,cljs.core.str,params));
});

example2.core.log.cljs$lang$maxFixedArity = (0);

example2.core.log.cljs$lang$applyTo = (function (seq45932){
return example2.core.log.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq.call(null,seq45932));
});

example2.core.show_output = (function example2$core$show_output(response){
var cap = new cljs.core.Keyword(null,"cap","cap",-817621587).cljs$core$IFn$_invoke$arity$1(response);
var low = new cljs.core.Keyword(null,"low","low",-1601362409).cljs$core$IFn$_invoke$arity$1(response);
var upp = new cljs.core.Keyword(null,"upp","upp",1964543752).cljs$core$IFn$_invoke$arity$1(response);
document.getElementById("str-1").value = cap;

document.getElementById("str-2").value = low;

return document.getElementById("str-3").value = upp;
});
example2.core.error_handler = (function example2$core$error_handler(params){
return example2.core.log.call(null,"@@@",params);
});
example2.core.home_page = (function example2$core$home_page(){
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"div.container","div.container",72419955),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"h2","h2",-372662728),"hello world"], null),new cljs.core.PersistentVector(null, 6, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"form","form",-1624062471),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"action","action",-811238024),"#",new cljs.core.Keyword(null,"method","method",55703592),"get",new cljs.core.Keyword(null,"on-submit","on-submit",1227871159),(function (e){
var s1 = example2.core.get_by_id.call(null,"input-str").value;
var s2 = "some value";
example2.core.log.call(null,example2.core.s);

return ajax.core.GET.call(null,[cljs.core.str.cljs$core$IFn$_invoke$arity$1(example2.core.server),cljs.core.str.cljs$core$IFn$_invoke$arity$1("manipulate-string")].join(''),new cljs.core.PersistentArrayMap(null, 6, [new cljs.core.Keyword(null,"params","params",710516235),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"s1","s1",-1301860037),s1,new cljs.core.Keyword(null,"s2","s2",-1025927265),s2], null),new cljs.core.Keyword(null,"format","format",-1306924766),new cljs.core.Keyword(null,"json","json",1279968570),new cljs.core.Keyword(null,"response-format","response-format",1664465322),new cljs.core.Keyword(null,"json","json",1279968570),new cljs.core.Keyword(null,"keywords?","keywords?",764949733),true,new cljs.core.Keyword(null,"handler","handler",-195596612),example2.core.show_output,new cljs.core.Keyword(null,"error-handler","error-handler",-484945776),example2.core.error_handler], null));
})], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"div","div",1057191632),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"input","input",556931961),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"type","type",1174270348),"text",new cljs.core.Keyword(null,"id","id",-1388402092),"input-str"], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"input","input",556931961),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"type","type",1174270348),"submit",new cljs.core.Keyword(null,"value","value",305978217),"Submit"], null)], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"div","div",1057191632),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"input","input",556931961),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"disabled","disabled",-1529784218),true,new cljs.core.Keyword(null,"type","type",1174270348),"text",new cljs.core.Keyword(null,"id","id",-1388402092),"str-1"], null)], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"div","div",1057191632),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"input","input",556931961),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"disabled","disabled",-1529784218),true,new cljs.core.Keyword(null,"type","type",1174270348),"text",new cljs.core.Keyword(null,"id","id",-1388402092),"str-2"], null)], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"div","div",1057191632),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"input","input",556931961),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"disabled","disabled",-1529784218),true,new cljs.core.Keyword(null,"type","type",1174270348),"text",new cljs.core.Keyword(null,"id","id",-1388402092),"str-3"], null)], null)], null)], null)], null);
});
example2.core.mount_components = (function example2$core$mount_components(){
return reagent.core.render.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [example2.core.home_page], null),document.getElementById("app"));
});
example2.core.init_BANG_ = (function example2$core$init_BANG_(){
return example2.core.mount_components.call(null);
});

//# sourceMappingURL=core.js.map
