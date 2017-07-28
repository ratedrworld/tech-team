// Compiled by ClojureScript 1.9.671 {}
goog.provide('memory_game.core2');
goog.require('cljs.core');
goog.require('clojure.string');
memory_game.core2.board = cljs.core.PersistentHashMap.fromArrays([(0),(7),(1),(4),(15),(13),(6),(3),(12),(2),(11),(9),(5),(14),(10),(8)],[new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"A",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"B",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"C",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"H",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"E",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"D",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"C",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"A",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"F",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"G",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"F",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"D",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"G",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"H",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"E",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"B",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null)]);
/**
 * reads input from DOM
 */
memory_game.core2.get_map = (function memory_game$core2$get_map(){
var iter__7775__auto__ = (function memory_game$core2$get_map_$_iter__8542(s__8543){
return (new cljs.core.LazySeq(null,(function (){
var s__8543__$1 = s__8543;
while(true){
var temp__4657__auto__ = cljs.core.seq.call(null,s__8543__$1);
if(temp__4657__auto__){
var s__8543__$2 = temp__4657__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,s__8543__$2)){
var c__7773__auto__ = cljs.core.chunk_first.call(null,s__8543__$2);
var size__7774__auto__ = cljs.core.count.call(null,c__7773__auto__);
var b__8545 = cljs.core.chunk_buffer.call(null,size__7774__auto__);
if((function (){var i__8544 = (0);
while(true){
if((i__8544 < size__7774__auto__)){
var i = cljs.core._nth.call(null,c__7773__auto__,i__8544);
var prod = document.getElementById(i).value;
cljs.core.chunk_append.call(null,b__8545,prod);

var G__8546 = (i__8544 + (1));
i__8544 = G__8546;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8545),memory_game$core2$get_map_$_iter__8542.call(null,cljs.core.chunk_rest.call(null,s__8543__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8545),null);
}
} else {
var i = cljs.core.first.call(null,s__8543__$2);
var prod = document.getElementById(i).value;
return cljs.core.cons.call(null,prod,memory_game$core2$get_map_$_iter__8542.call(null,cljs.core.rest.call(null,s__8543__$2)));
}
} else {
return null;
}
break;
}
}),null,null));
});
return iter__7775__auto__.call(null,cljs.core.range.call(null,(16)));
});
/**
 * check if two open are equal or not
 */
memory_game.core2.check = (function memory_game$core2$check(lis){
return cljs.core._EQ_.call(null,cljs.core.second.call(null,cljs.core.first.call(null,lis)),cljs.core.second.call(null,cljs.core.second.call(null,lis)));
});
memory_game.core2.splitter = (function memory_game$core2$splitter(x){
return clojure.string.split.call(null,x,"_");
});
/**
 * removes the empty and already checked correct options
 */
memory_game.core2.filter_list = (function memory_game$core2$filter_list(lis){
return cljs.core.remove.call(null,(function (p1__8547_SHARP_){
return cljs.core._EQ_.call(null,"T",cljs.core.last.call(null,p1__8547_SHARP_));
}),cljs.core.map.call(null,memory_game.core2.splitter,cljs.core.remove.call(null,cljs.core.empty_QMARK_,lis)));
});
/**
 * Switches value of :open
 */
memory_game.core2.change_open = (function memory_game$core2$change_open(a){
document.getElementById(a).value = [cljs.core.str.cljs$core$IFn$_invoke$arity$1(a),cljs.core.str.cljs$core$IFn$_invoke$arity$1("_"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(cljs.core.get_in.call(null,memory_game.core2.board,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [a,new cljs.core.Keyword(null,"val","val",128701612)], null))),cljs.core.str.cljs$core$IFn$_invoke$arity$1("_T_F")].join('');

var arr = memory_game.core2.filter_list.call(null,memory_game.core2.get_map.call(null));
var ff = cljs.core.first.call(null,cljs.core.first.call(null,arr));
var sf = cljs.core.second.call(null,cljs.core.first.call(null,arr));
var fs = cljs.core.first.call(null,cljs.core.second.call(null,arr));
var ss = cljs.core.second.call(null,cljs.core.second.call(null,arr));
if(cljs.core._EQ_.call(null,(2),cljs.core.count.call(null,arr))){
if(cljs.core.truth_(memory_game.core2.check.call(null,arr))){
document.getElementById(ff).value = [cljs.core.str.cljs$core$IFn$_invoke$arity$1(ff),cljs.core.str.cljs$core$IFn$_invoke$arity$1("_"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(sf),cljs.core.str.cljs$core$IFn$_invoke$arity$1("_F_T")].join('');

document.getElementById(ff).disabled = true;

document.getElementById(fs).value = [cljs.core.str.cljs$core$IFn$_invoke$arity$1(fs),cljs.core.str.cljs$core$IFn$_invoke$arity$1("_"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(ss),cljs.core.str.cljs$core$IFn$_invoke$arity$1("_F_T")].join('');

return document.getElementById(fs).disabled = true;
} else {
document.getElementById(ff).value = "";

return document.getElementById(fs).value = "";
}
} else {
return null;
}
});
/**
 * Gives the valid ans after swapping
 */
memory_game.core2.swapping = (function memory_game$core2$swapping(num){
var arr = cljs.core.mapv.call(null,memory_game.core2.read_string,clojure.string.split.call(null,[cljs.core.str.cljs$core$IFn$_invoke$arity$1(num)].join(''),(new RegExp(""))));
return cljs.core.first.call(null,cljs.core.remove.call(null,cljs.core.nil_QMARK_,(function (){var iter__7775__auto__ = ((function (arr){
return (function memory_game$core2$swapping_$_iter__8548(s__8549){
return (new cljs.core.LazySeq(null,((function (arr){
return (function (){
var s__8549__$1 = s__8549;
while(true){
var temp__4657__auto__ = cljs.core.seq.call(null,s__8549__$1);
if(temp__4657__auto__){
var s__8549__$2 = temp__4657__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,s__8549__$2)){
var c__7773__auto__ = cljs.core.chunk_first.call(null,s__8549__$2);
var size__7774__auto__ = cljs.core.count.call(null,c__7773__auto__);
var b__8551 = cljs.core.chunk_buffer.call(null,size__7774__auto__);
if((function (){var i__8550 = (0);
while(true){
if((i__8550 < size__7774__auto__)){
var i = cljs.core._nth.call(null,c__7773__auto__,i__8550);
var mynum = cljs.core.flatten.call(null,new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.take.call(null,i,arr),cljs.core.get.call(null,arr,(i + (1))),cljs.core.get.call(null,arr,i),cljs.core.drop.call(null,(i + (2)),arr)], null));
cljs.core.chunk_append.call(null,b__8551,(cljs.core.truth_(memory_game.core2.valid_QMARK_.call(null,mynum))?memory_game.core2.read_string.call(null,cljs.core.apply.call(null,cljs.core.str,mynum)):null));

var G__8552 = (i__8550 + (1));
i__8550 = G__8552;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8551),memory_game$core2$swapping_$_iter__8548.call(null,cljs.core.chunk_rest.call(null,s__8549__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8551),null);
}
} else {
var i = cljs.core.first.call(null,s__8549__$2);
var mynum = cljs.core.flatten.call(null,new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.take.call(null,i,arr),cljs.core.get.call(null,arr,(i + (1))),cljs.core.get.call(null,arr,i),cljs.core.drop.call(null,(i + (2)),arr)], null));
return cljs.core.cons.call(null,(cljs.core.truth_(memory_game.core2.valid_QMARK_.call(null,mynum))?memory_game.core2.read_string.call(null,cljs.core.apply.call(null,cljs.core.str,mynum)):null),memory_game$core2$swapping_$_iter__8548.call(null,cljs.core.rest.call(null,s__8549__$2)));
}
} else {
return null;
}
break;
}
});})(arr))
,null,null));
});})(arr))
;
return iter__7775__auto__.call(null,cljs.core.range.call(null,(cljs.core.count.call(null,arr) - (1))));
})()));
});
/**
 * Checks whether the number is valid or not
 */
memory_game.core2.valid_QMARK_ = (function memory_game$core2$valid_QMARK_(arr){
if((cljs.core.mod.call(null,cljs.core.reduce.call(null,cljs.core._PLUS_,cljs.core.map.call(null,memory_game.core2.part_add,cljs.core.partition.call(null,(2),cljs.core.reverse.call(null,arr)))),(10)) === (0))){
return true;
} else {
return false;
}
});
memory_game.core2.part_add = (function memory_game$core2$part_add(part){
if((((2) * cljs.core.second.call(null,part)) >= (10))){
return (cljs.core.first.call(null,part) + (((2) * cljs.core.second.call(null,part)) - (9)));
} else {
return (cljs.core.first.call(null,part) + ((2) * cljs.core.second.call(null,part)));
}
});

//# sourceMappingURL=core2.js.map