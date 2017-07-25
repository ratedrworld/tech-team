// Compiled by ClojureScript 1.9.671 {}
goog.provide('sachin_cljs.core');
goog.require('cljs.core');
goog.require('clojure.string');
/**
 * Splits the plaintext into partitions of size key
 */
sachin_cljs.core.split_plaintext = (function sachin_cljs$core$split_plaintext(plaintext,key){
return cljs.core.vec.call(null,cljs.core.partition.call(null,(cljs.core.count.call(null,plaintext) / cljs.core.count.call(null,key)),clojure.string.split.call(null,plaintext,"")));
});
/**
 * Sorts the key according alphabet and returns the sorted pattern
 */
sachin_cljs.core.sort_key = (function sachin_cljs$core$sort_key(key){
return cljs.core.into.call(null,cljs.core.sorted_map.call(null),cljs.core.zipmap.call(null,clojure.string.split.call(null,key,""),cljs.core.range.call(null,cljs.core.count.call(null,key))));
});
/**
 * Encrypts the plaintext using key and returns
 */
sachin_cljs.core.encrypt = (function sachin_cljs$core$encrypt(plaintext,key){
return clojure.string.join.call(null,cljs.core.flatten.call(null,cljs.core.map.call(null,(function (x){
return cljs.core.get_in.call(null,sachin_cljs.core.split_plaintext.call(null,plaintext,key),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.second.call(null,x)], null));
}),sachin_cljs.core.sort_key.call(null,key))));
});
/**
 * Takes input from form and returns the output
 */
sachin_cljs.core.main = (function sachin_cljs$core$main(var_args){
var args__8118__auto__ = [];
var len__8111__auto___8586 = arguments.length;
var i__8112__auto___8587 = (0);
while(true){
if((i__8112__auto___8587 < len__8111__auto___8586)){
args__8118__auto__.push((arguments[i__8112__auto___8587]));

var G__8588 = (i__8112__auto___8587 + (1));
i__8112__auto___8587 = G__8588;
continue;
} else {
}
break;
}

var argseq__8119__auto__ = ((((0) < args__8118__auto__.length))?(new cljs.core.IndexedSeq(args__8118__auto__.slice((0)),(0),null)):null);
return sachin_cljs.core.main.cljs$core$IFn$_invoke$arity$variadic(argseq__8119__auto__);
});

sachin_cljs.core.main.cljs$core$IFn$_invoke$arity$variadic = (function (args){
var plaintext = document.getElementById("plaintext").value;
var key = document.getElementById("key").value;
var enc = sachin_cljs.core.encrypt.call(null,plaintext,key);
return document.getElementById("output").value = enc;
});

sachin_cljs.core.main.cljs$lang$maxFixedArity = (0);

sachin_cljs.core.main.cljs$lang$applyTo = (function (seq8585){
return sachin_cljs.core.main.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq.call(null,seq8585));
});


//# sourceMappingURL=core.js.map