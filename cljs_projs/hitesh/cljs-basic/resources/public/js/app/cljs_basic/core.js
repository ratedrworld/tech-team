// Compiled by ClojureScript 1.9.671 {}
goog.provide('cljs_basic.core');
goog.require('cljs.core');
goog.require('clojure.string');
/**
 * Converts input to output
 */
cljs_basic.core.get_output = (function cljs_basic$core$get_output(input){
return clojure.string.join.call(null," ",cljs.core.mapv.call(null,clojure.string.capitalize,clojure.string.split.call(null,input,/ /)));
});
/**
 * Encrypts the string based on key
 */
cljs_basic.core.encrypt = (function cljs_basic$core$encrypt(stri,key){
var split_arr = cljs.core.partition.call(null,(cljs.core.count.call(null,stri) / cljs.core.count.call(null,key)),clojure.string.split.call(null,stri,""));
var split_key = clojure.string.split.call(null,key,"");
return cljs.core.apply.call(null,cljs.core.str,cljs.core.flatten.call(null,cljs.core.vals.call(null,cljs.core.sort.call(null,cljs.core.zipmap.call(null,split_key,split_arr)))));
});
/**
 * I don't do a whole lot ... yet.
 */
cljs_basic.core.mymain = (function cljs_basic$core$mymain(var_args){
var args__8118__auto__ = [];
var len__8111__auto___8765 = arguments.length;
var i__8112__auto___8766 = (0);
while(true){
if((i__8112__auto___8766 < len__8111__auto___8765)){
args__8118__auto__.push((arguments[i__8112__auto___8766]));

var G__8767 = (i__8112__auto___8766 + (1));
i__8112__auto___8766 = G__8767;
continue;
} else {
}
break;
}

var argseq__8119__auto__ = ((((0) < args__8118__auto__.length))?(new cljs.core.IndexedSeq(args__8118__auto__.slice((0)),(0),null)):null);
return cljs_basic.core.mymain.cljs$core$IFn$_invoke$arity$variadic(argseq__8119__auto__);
});

cljs_basic.core.mymain.cljs$core$IFn$_invoke$arity$variadic = (function (args){
var stri = document.getElementById("stri").value;
var key = document.getElementById("key").value;
var output = cljs_basic.core.encrypt.call(null,stri,key);
return document.getElementById("output").value = output;
});

cljs_basic.core.mymain.cljs$lang$maxFixedArity = (0);

cljs_basic.core.mymain.cljs$lang$applyTo = (function (seq8764){
return cljs_basic.core.mymain.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq.call(null,seq8764));
});


//# sourceMappingURL=core.js.map