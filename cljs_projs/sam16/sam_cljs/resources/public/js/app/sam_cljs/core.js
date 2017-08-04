// Compiled by ClojureScript 1.9.671 {}
goog.provide('sam_cljs.core');
goog.require('cljs.core');
goog.require('clojure.string');
sam_cljs.core.sort_cipher = (function sam_cljs$core$sort_cipher(cipher){
return cljs.core.into.call(null,cljs.core.sorted_map.call(null),cljs.core.zipmap.call(null,cipher,cljs.core.range.call(null,cljs.core.count.call(null,cipher))));
});
sam_cljs.core.transform_cipher = (function sam_cljs$core$transform_cipher(input,cipher){
var pair_count = (cljs.core.count.call(null,input) / cljs.core.count.call(null,cipher));
var ip_vec = cljs.core.vec.call(null,cljs.core.partition.call(null,pair_count,input));
return clojure.string.join.call(null,cljs.core.flatten.call(null,cljs.core.map.call(null,((function (pair_count,ip_vec){
return (function (p1__8794_SHARP_){
return cljs.core.get_in.call(null,ip_vec,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.second.call(null,p1__8794_SHARP_)], null));
});})(pair_count,ip_vec))
,sam_cljs.core.sort_cipher.call(null,cipher))));
});
/**
 * I don't do a whole lot ... yet.
 */
sam_cljs.core.encryption_main = (function sam_cljs$core$encryption_main(var_args){
var args__8118__auto__ = [];
var len__8111__auto___8796 = arguments.length;
var i__8112__auto___8797 = (0);
while(true){
if((i__8112__auto___8797 < len__8111__auto___8796)){
args__8118__auto__.push((arguments[i__8112__auto___8797]));

var G__8798 = (i__8112__auto___8797 + (1));
i__8112__auto___8797 = G__8798;
continue;
} else {
}
break;
}

var argseq__8119__auto__ = ((((0) < args__8118__auto__.length))?(new cljs.core.IndexedSeq(args__8118__auto__.slice((0)),(0),null)):null);
return sam_cljs.core.encryption_main.cljs$core$IFn$_invoke$arity$variadic(argseq__8119__auto__);
});

sam_cljs.core.encryption_main.cljs$core$IFn$_invoke$arity$variadic = (function (args){
var inp_string = document.getElementById("inp-string").value;
var cipher_key = document.getElementById("inp-key").value;
var inp = cljs.core.js__GT_clj.call(null,cljs.core.clj__GT_js.call(null,inp_string).split(""));
var cipher = clojure.string.split.call(null,cipher_key,"");
var cipher_text = sam_cljs.core.transform_cipher.call(null,inp,cipher);
return document.getElementById("cipher-text").value = cipher_text;
});

sam_cljs.core.encryption_main.cljs$lang$maxFixedArity = (0);

sam_cljs.core.encryption_main.cljs$lang$applyTo = (function (seq8795){
return sam_cljs.core.encryption_main.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq.call(null,seq8795));
});


//# sourceMappingURL=core.js.map