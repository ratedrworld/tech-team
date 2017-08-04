// Compiled by ClojureScript 1.9.671 {}
goog.provide('tic_tac_toe.new_xo');
goog.require('cljs.core');
goog.require('clojure.string');
tic_tac_toe.new_xo.restart = (function tic_tac_toe$new_xo$restart(){
console.log("restart");

cljs.core.reset_BANG_.call(null,tic_tac_toe.new_xo.board,tic_tac_toe.new_xo.blank.call(null));

return cljs.core.doall.call(null,(function (){var iter__7775__auto__ = (function tic_tac_toe$new_xo$restart_$_iter__8664(s__8665){
return (new cljs.core.LazySeq(null,(function (){
var s__8665__$1 = s__8665;
while(true){
var temp__4657__auto__ = cljs.core.seq.call(null,s__8665__$1);
if(temp__4657__auto__){
var xs__5205__auto__ = temp__4657__auto__;
var i = cljs.core.first.call(null,xs__5205__auto__);
var iterys__7771__auto__ = ((function (s__8665__$1,i,xs__5205__auto__,temp__4657__auto__){
return (function tic_tac_toe$new_xo$restart_$_iter__8664_$_iter__8666(s__8667){
return (new cljs.core.LazySeq(null,((function (s__8665__$1,i,xs__5205__auto__,temp__4657__auto__){
return (function (){
var s__8667__$1 = s__8667;
while(true){
var temp__4657__auto____$1 = cljs.core.seq.call(null,s__8667__$1);
if(temp__4657__auto____$1){
var s__8667__$2 = temp__4657__auto____$1;
if(cljs.core.chunked_seq_QMARK_.call(null,s__8667__$2)){
var c__7773__auto__ = cljs.core.chunk_first.call(null,s__8667__$2);
var size__7774__auto__ = cljs.core.count.call(null,c__7773__auto__);
var b__8669 = cljs.core.chunk_buffer.call(null,size__7774__auto__);
if((function (){var i__8668 = (0);
while(true){
if((i__8668 < size__7774__auto__)){
var j = cljs.core._nth.call(null,c__7773__auto__,i__8668);
var blockno = [cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('');
cljs.core.chunk_append.call(null,b__8669,document.getElementById(blockno).innerHTML = "");

var G__8670 = (i__8668 + (1));
i__8668 = G__8670;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8669),tic_tac_toe$new_xo$restart_$_iter__8664_$_iter__8666.call(null,cljs.core.chunk_rest.call(null,s__8667__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8669),null);
}
} else {
var j = cljs.core.first.call(null,s__8667__$2);
var blockno = [cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('');
return cljs.core.cons.call(null,document.getElementById(blockno).innerHTML = "",tic_tac_toe$new_xo$restart_$_iter__8664_$_iter__8666.call(null,cljs.core.rest.call(null,s__8667__$2)));
}
} else {
return null;
}
break;
}
});})(s__8665__$1,i,xs__5205__auto__,temp__4657__auto__))
,null,null));
});})(s__8665__$1,i,xs__5205__auto__,temp__4657__auto__))
;
var fs__7772__auto__ = cljs.core.seq.call(null,iterys__7771__auto__.call(null,cljs.core.range.call(null,(3))));
if(fs__7772__auto__){
return cljs.core.concat.call(null,fs__7772__auto__,tic_tac_toe$new_xo$restart_$_iter__8664.call(null,cljs.core.rest.call(null,s__8665__$1)));
} else {
var G__8671 = cljs.core.rest.call(null,s__8665__$1);
s__8665__$1 = G__8671;
continue;
}
} else {
return null;
}
break;
}
}),null,null));
});
return iter__7775__auto__.call(null,cljs.core.range.call(null,(3)));
})());
});
tic_tac_toe.new_xo.blank = (function tic_tac_toe$new_xo$blank(){
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, ["","",""], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, ["","",""], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, ["","",""], null)], null);
});
tic_tac_toe.new_xo.board = cljs.core.atom.call(null,tic_tac_toe.new_xo.blank.call(null));
tic_tac_toe.new_xo.x_or_o_QMARK_ = (function tic_tac_toe$new_xo$x_or_o_QMARK_(){
if(cljs.core.odd_QMARK_.call(null,cljs.core.count.call(null,cljs.core.filter.call(null,cljs.core.empty_QMARK_,cljs.core.flatten.call(null,cljs.core.deref.call(null,tic_tac_toe.new_xo.board)))))){
return "X";
} else {
return "O";
}
});
tic_tac_toe.new_xo.make_move = (function tic_tac_toe$new_xo$make_move(i,j){
var a = tic_tac_toe.new_xo.x_or_o_QMARK_.call(null);
cljs.core.swap_BANG_.call(null,tic_tac_toe.new_xo.board,cljs.core.assoc_in,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [i,j], null),a);

return document.getElementById([cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('')).innerHTML = a;
});
tic_tac_toe.new_xo.done_row_QMARK_ = (function tic_tac_toe$new_xo$done_row_QMARK_(i){
return cljs.core.reduce.call(null,(function (a,x){
if((cljs.core._EQ_.call(null,a,x)) && (cljs.core.not_EQ_.call(null,x,""))){
return a;
} else {
return false;
}
}),cljs.core.mapv.call(null,(function (p1__8672_SHARP_){
return cljs.core.get_in.call(null,cljs.core.deref.call(null,tic_tac_toe.new_xo.board),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [i,p1__8672_SHARP_], null));
}),cljs.core.range.call(null,(0),(3))));
});
tic_tac_toe.new_xo.done_col_QMARK_ = (function tic_tac_toe$new_xo$done_col_QMARK_(i){
return cljs.core.reduce.call(null,(function (a,x){
if((cljs.core._EQ_.call(null,a,x)) && (cljs.core.not_EQ_.call(null,x,""))){
return a;
} else {
return false;
}
}),cljs.core.mapv.call(null,(function (p1__8673_SHARP_){
return cljs.core.get_in.call(null,cljs.core.deref.call(null,tic_tac_toe.new_xo.board),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__8673_SHARP_,i], null));
}),cljs.core.range.call(null,(0),(3))));
});
tic_tac_toe.new_xo.diag1_QMARK_ = (function tic_tac_toe$new_xo$diag1_QMARK_(){
return cljs.core.reduce.call(null,(function (a,x){
if((cljs.core._EQ_.call(null,a,x)) && (cljs.core.not_EQ_.call(null,x,""))){
return a;
} else {
return false;
}
}),cljs.core.mapv.call(null,(function (p1__8674_SHARP_,p2__8675_SHARP_){
return cljs.core.get_in.call(null,cljs.core.deref.call(null,tic_tac_toe.new_xo.board),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__8674_SHARP_,p2__8675_SHARP_], null));
}),cljs.core.range.call(null,(0),(3)),cljs.core.range.call(null,(0),(3))));
});
tic_tac_toe.new_xo.diag2_QMARK_ = (function tic_tac_toe$new_xo$diag2_QMARK_(){
return cljs.core.reduce.call(null,(function (a,x){
if((cljs.core._EQ_.call(null,a,x)) && (cljs.core.not_EQ_.call(null,x,""))){
return a;
} else {
return false;
}
}),cljs.core.mapv.call(null,(function (p1__8676_SHARP_,p2__8677_SHARP_){
return cljs.core.get_in.call(null,cljs.core.deref.call(null,tic_tac_toe.new_xo.board),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__8676_SHARP_,p2__8677_SHARP_], null));
}),cljs.core.range.call(null,(0),(3)),cljs.core.reverse.call(null,cljs.core.range.call(null,(0),(3)))));
});
tic_tac_toe.new_xo.won_QMARK_ = (function tic_tac_toe$new_xo$won_QMARK_(){
var or__6986__auto__ = cljs.core.some.call(null,(function (p1__8678_SHARP_){
if(cljs.core.not_EQ_.call(null,p1__8678_SHARP_,false)){
return p1__8678_SHARP_;
} else {
return null;
}
}),cljs.core.map.call(null,(function (p1__8679_SHARP_){
return tic_tac_toe.new_xo.done_row_QMARK_.call(null,p1__8679_SHARP_);
}),cljs.core.range.call(null,(3))));
if(cljs.core.truth_(or__6986__auto__)){
return or__6986__auto__;
} else {
var or__6986__auto____$1 = cljs.core.some.call(null,((function (or__6986__auto__){
return (function (p1__8680_SHARP_){
if(cljs.core.not_EQ_.call(null,p1__8680_SHARP_,false)){
return p1__8680_SHARP_;
} else {
return null;
}
});})(or__6986__auto__))
,cljs.core.map.call(null,((function (or__6986__auto__){
return (function (p1__8681_SHARP_){
return tic_tac_toe.new_xo.done_col_QMARK_.call(null,p1__8681_SHARP_);
});})(or__6986__auto__))
,cljs.core.range.call(null,(3))));
if(cljs.core.truth_(or__6986__auto____$1)){
return or__6986__auto____$1;
} else {
var or__6986__auto____$2 = tic_tac_toe.new_xo.diag1_QMARK_.call(null);
if(cljs.core.truth_(or__6986__auto____$2)){
return or__6986__auto____$2;
} else {
return tic_tac_toe.new_xo.diag2_QMARK_.call(null);
}
}
}
});
/**
 * TIC TAC TOE MAIN FUNCTION
 */
tic_tac_toe.new_xo.ttt_main = (function tic_tac_toe$new_xo$ttt_main(i,j){
var new$ = tic_tac_toe.new_xo.make_move.call(null,i,j);
if(cljs.core.truth_(tic_tac_toe.new_xo.won_QMARK_.call(null))){
alert([cljs.core.str.cljs$core$IFn$_invoke$arity$1("Player "),cljs.core.str.cljs$core$IFn$_invoke$arity$1(tic_tac_toe.new_xo.won_QMARK_.call(null)),cljs.core.str.cljs$core$IFn$_invoke$arity$1(" Won..!!")].join(''));

return tic_tac_toe.new_xo.restart.call(null);
} else {
return false;
}
});

//# sourceMappingURL=new_xo.js.map