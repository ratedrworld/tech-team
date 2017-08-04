// Compiled by ClojureScript 1.9.671 {}
goog.provide('tic_tac_toe.core');
goog.require('cljs.core');
goog.require('clojure.string');
tic_tac_toe.core.get_input = (function tic_tac_toe$core$get_input(){
return cljs.core.mapv.call(null,cljs.core.vec,cljs.core.partition.call(null,(3),(function (){var iter__7775__auto__ = (function tic_tac_toe$core$get_input_$_iter__9500(s__9501){
return (new cljs.core.LazySeq(null,(function (){
var s__9501__$1 = s__9501;
while(true){
var temp__4657__auto__ = cljs.core.seq.call(null,s__9501__$1);
if(temp__4657__auto__){
var xs__5205__auto__ = temp__4657__auto__;
var i = cljs.core.first.call(null,xs__5205__auto__);
var iterys__7771__auto__ = ((function (s__9501__$1,i,xs__5205__auto__,temp__4657__auto__){
return (function tic_tac_toe$core$get_input_$_iter__9500_$_iter__9502(s__9503){
return (new cljs.core.LazySeq(null,((function (s__9501__$1,i,xs__5205__auto__,temp__4657__auto__){
return (function (){
var s__9503__$1 = s__9503;
while(true){
var temp__4657__auto____$1 = cljs.core.seq.call(null,s__9503__$1);
if(temp__4657__auto____$1){
var s__9503__$2 = temp__4657__auto____$1;
if(cljs.core.chunked_seq_QMARK_.call(null,s__9503__$2)){
var c__7773__auto__ = cljs.core.chunk_first.call(null,s__9503__$2);
var size__7774__auto__ = cljs.core.count.call(null,c__7773__auto__);
var b__9505 = cljs.core.chunk_buffer.call(null,size__7774__auto__);
if((function (){var i__9504 = (0);
while(true){
if((i__9504 < size__7774__auto__)){
var j = cljs.core._nth.call(null,c__7773__auto__,i__9504);
var blockno = [cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('');
cljs.core.chunk_append.call(null,b__9505,document.getElementById(blockno).innerHTML);

var G__9506 = (i__9504 + (1));
i__9504 = G__9506;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__9505),tic_tac_toe$core$get_input_$_iter__9500_$_iter__9502.call(null,cljs.core.chunk_rest.call(null,s__9503__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__9505),null);
}
} else {
var j = cljs.core.first.call(null,s__9503__$2);
var blockno = [cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('');
return cljs.core.cons.call(null,document.getElementById(blockno).innerHTML,tic_tac_toe$core$get_input_$_iter__9500_$_iter__9502.call(null,cljs.core.rest.call(null,s__9503__$2)));
}
} else {
return null;
}
break;
}
});})(s__9501__$1,i,xs__5205__auto__,temp__4657__auto__))
,null,null));
});})(s__9501__$1,i,xs__5205__auto__,temp__4657__auto__))
;
var fs__7772__auto__ = cljs.core.seq.call(null,iterys__7771__auto__.call(null,cljs.core.range.call(null,(3))));
if(fs__7772__auto__){
return cljs.core.concat.call(null,fs__7772__auto__,tic_tac_toe$core$get_input_$_iter__9500.call(null,cljs.core.rest.call(null,s__9501__$1)));
} else {
var G__9507 = cljs.core.rest.call(null,s__9501__$1);
s__9501__$1 = G__9507;
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
})()));
});
tic_tac_toe.core.set_output = (function tic_tac_toe$core$set_output(board){
var iter__7775__auto__ = (function tic_tac_toe$core$set_output_$_iter__9508(s__9509){
return (new cljs.core.LazySeq(null,(function (){
var s__9509__$1 = s__9509;
while(true){
var temp__4657__auto__ = cljs.core.seq.call(null,s__9509__$1);
if(temp__4657__auto__){
var xs__5205__auto__ = temp__4657__auto__;
var i = cljs.core.first.call(null,xs__5205__auto__);
var iterys__7771__auto__ = ((function (s__9509__$1,i,xs__5205__auto__,temp__4657__auto__){
return (function tic_tac_toe$core$set_output_$_iter__9508_$_iter__9510(s__9511){
return (new cljs.core.LazySeq(null,((function (s__9509__$1,i,xs__5205__auto__,temp__4657__auto__){
return (function (){
var s__9511__$1 = s__9511;
while(true){
var temp__4657__auto____$1 = cljs.core.seq.call(null,s__9511__$1);
if(temp__4657__auto____$1){
var s__9511__$2 = temp__4657__auto____$1;
if(cljs.core.chunked_seq_QMARK_.call(null,s__9511__$2)){
var c__7773__auto__ = cljs.core.chunk_first.call(null,s__9511__$2);
var size__7774__auto__ = cljs.core.count.call(null,c__7773__auto__);
var b__9513 = cljs.core.chunk_buffer.call(null,size__7774__auto__);
if((function (){var i__9512 = (0);
while(true){
if((i__9512 < size__7774__auto__)){
var j = cljs.core._nth.call(null,c__7773__auto__,i__9512);
var blockno = [cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('');
cljs.core.chunk_append.call(null,b__9513,document.getElementById([cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('')).innerHTML = cljs.core.get_in.call(null,board,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [i,j], null)));

var G__9514 = (i__9512 + (1));
i__9512 = G__9514;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__9513),tic_tac_toe$core$set_output_$_iter__9508_$_iter__9510.call(null,cljs.core.chunk_rest.call(null,s__9511__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__9513),null);
}
} else {
var j = cljs.core.first.call(null,s__9511__$2);
var blockno = [cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('');
return cljs.core.cons.call(null,document.getElementById([cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('')).innerHTML = cljs.core.get_in.call(null,board,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [i,j], null)),tic_tac_toe$core$set_output_$_iter__9508_$_iter__9510.call(null,cljs.core.rest.call(null,s__9511__$2)));
}
} else {
return null;
}
break;
}
});})(s__9509__$1,i,xs__5205__auto__,temp__4657__auto__))
,null,null));
});})(s__9509__$1,i,xs__5205__auto__,temp__4657__auto__))
;
var fs__7772__auto__ = cljs.core.seq.call(null,iterys__7771__auto__.call(null,cljs.core.range.call(null,(3))));
if(fs__7772__auto__){
return cljs.core.concat.call(null,fs__7772__auto__,tic_tac_toe$core$set_output_$_iter__9508.call(null,cljs.core.rest.call(null,s__9509__$1)));
} else {
var G__9515 = cljs.core.rest.call(null,s__9509__$1);
s__9509__$1 = G__9515;
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
});
tic_tac_toe.core.restart = (function tic_tac_toe$core$restart(){
console.log("hello");

return cljs.core.doall.call(null,(function (){var iter__7775__auto__ = (function tic_tac_toe$core$restart_$_iter__9516(s__9517){
return (new cljs.core.LazySeq(null,(function (){
var s__9517__$1 = s__9517;
while(true){
var temp__4657__auto__ = cljs.core.seq.call(null,s__9517__$1);
if(temp__4657__auto__){
var xs__5205__auto__ = temp__4657__auto__;
var i = cljs.core.first.call(null,xs__5205__auto__);
var iterys__7771__auto__ = ((function (s__9517__$1,i,xs__5205__auto__,temp__4657__auto__){
return (function tic_tac_toe$core$restart_$_iter__9516_$_iter__9518(s__9519){
return (new cljs.core.LazySeq(null,((function (s__9517__$1,i,xs__5205__auto__,temp__4657__auto__){
return (function (){
var s__9519__$1 = s__9519;
while(true){
var temp__4657__auto____$1 = cljs.core.seq.call(null,s__9519__$1);
if(temp__4657__auto____$1){
var s__9519__$2 = temp__4657__auto____$1;
if(cljs.core.chunked_seq_QMARK_.call(null,s__9519__$2)){
var c__7773__auto__ = cljs.core.chunk_first.call(null,s__9519__$2);
var size__7774__auto__ = cljs.core.count.call(null,c__7773__auto__);
var b__9521 = cljs.core.chunk_buffer.call(null,size__7774__auto__);
if((function (){var i__9520 = (0);
while(true){
if((i__9520 < size__7774__auto__)){
var j = cljs.core._nth.call(null,c__7773__auto__,i__9520);
var blockno = [cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('');
cljs.core.chunk_append.call(null,b__9521,document.getElementById([cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('')).innerHTML = "");

var G__9522 = (i__9520 + (1));
i__9520 = G__9522;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__9521),tic_tac_toe$core$restart_$_iter__9516_$_iter__9518.call(null,cljs.core.chunk_rest.call(null,s__9519__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__9521),null);
}
} else {
var j = cljs.core.first.call(null,s__9519__$2);
var blockno = [cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('');
return cljs.core.cons.call(null,document.getElementById([cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('')).innerHTML = "",tic_tac_toe$core$restart_$_iter__9516_$_iter__9518.call(null,cljs.core.rest.call(null,s__9519__$2)));
}
} else {
return null;
}
break;
}
});})(s__9517__$1,i,xs__5205__auto__,temp__4657__auto__))
,null,null));
});})(s__9517__$1,i,xs__5205__auto__,temp__4657__auto__))
;
var fs__7772__auto__ = cljs.core.seq.call(null,iterys__7771__auto__.call(null,cljs.core.range.call(null,(3))));
if(fs__7772__auto__){
return cljs.core.concat.call(null,fs__7772__auto__,tic_tac_toe$core$restart_$_iter__9516.call(null,cljs.core.rest.call(null,s__9517__$1)));
} else {
var G__9523 = cljs.core.rest.call(null,s__9517__$1);
s__9517__$1 = G__9523;
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
tic_tac_toe.core.x_or_o_QMARK_ = (function tic_tac_toe$core$x_or_o_QMARK_(input){
if(cljs.core.odd_QMARK_.call(null,cljs.core.count.call(null,cljs.core.filter.call(null,cljs.core.empty_QMARK_,cljs.core.flatten.call(null,input))))){
return "X";
} else {
return "O";
}
});
tic_tac_toe.core.make_move = (function tic_tac_toe$core$make_move(i,j,brd){
return cljs.core.vec.call(null,(function (){var iter__7775__auto__ = (function tic_tac_toe$core$make_move_$_iter__9524(s__9525){
return (new cljs.core.LazySeq(null,(function (){
var s__9525__$1 = s__9525;
while(true){
var temp__4657__auto__ = cljs.core.seq.call(null,s__9525__$1);
if(temp__4657__auto__){
var s__9525__$2 = temp__4657__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,s__9525__$2)){
var c__7773__auto__ = cljs.core.chunk_first.call(null,s__9525__$2);
var size__7774__auto__ = cljs.core.count.call(null,c__7773__auto__);
var b__9527 = cljs.core.chunk_buffer.call(null,size__7774__auto__);
if((function (){var i__9526 = (0);
while(true){
if((i__9526 < size__7774__auto__)){
var x = cljs.core._nth.call(null,c__7773__auto__,i__9526);
cljs.core.chunk_append.call(null,b__9527,cljs.core.vec.call(null,(function (){var iter__7775__auto__ = ((function (i__9526,x,c__7773__auto__,size__7774__auto__,b__9527,s__9525__$2,temp__4657__auto__){
return (function tic_tac_toe$core$make_move_$_iter__9524_$_iter__9528(s__9529){
return (new cljs.core.LazySeq(null,((function (i__9526,x,c__7773__auto__,size__7774__auto__,b__9527,s__9525__$2,temp__4657__auto__){
return (function (){
var s__9529__$1 = s__9529;
while(true){
var temp__4657__auto____$1 = cljs.core.seq.call(null,s__9529__$1);
if(temp__4657__auto____$1){
var s__9529__$2 = temp__4657__auto____$1;
if(cljs.core.chunked_seq_QMARK_.call(null,s__9529__$2)){
var c__7773__auto____$1 = cljs.core.chunk_first.call(null,s__9529__$2);
var size__7774__auto____$1 = cljs.core.count.call(null,c__7773__auto____$1);
var b__9531 = cljs.core.chunk_buffer.call(null,size__7774__auto____$1);
if((function (){var i__9530 = (0);
while(true){
if((i__9530 < size__7774__auto____$1)){
var y = cljs.core._nth.call(null,c__7773__auto____$1,i__9530);
cljs.core.chunk_append.call(null,b__9531,(((cljs.core._EQ_.call(null,x,i)) && (cljs.core._EQ_.call(null,y,j)))?(function (){
document.getElementById([cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('')).innerHTML = tic_tac_toe.core.x_or_o_QMARK_.call(null,brd);

return tic_tac_toe.core.x_or_o_QMARK_.call(null,brd);
})()
:cljs.core.get_in.call(null,brd,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [x,y], null))));

var G__9536 = (i__9530 + (1));
i__9530 = G__9536;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__9531),tic_tac_toe$core$make_move_$_iter__9524_$_iter__9528.call(null,cljs.core.chunk_rest.call(null,s__9529__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__9531),null);
}
} else {
var y = cljs.core.first.call(null,s__9529__$2);
return cljs.core.cons.call(null,(((cljs.core._EQ_.call(null,x,i)) && (cljs.core._EQ_.call(null,y,j)))?(function (){
document.getElementById([cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('')).innerHTML = tic_tac_toe.core.x_or_o_QMARK_.call(null,brd);

return tic_tac_toe.core.x_or_o_QMARK_.call(null,brd);
})()
:cljs.core.get_in.call(null,brd,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [x,y], null))),tic_tac_toe$core$make_move_$_iter__9524_$_iter__9528.call(null,cljs.core.rest.call(null,s__9529__$2)));
}
} else {
return null;
}
break;
}
});})(i__9526,x,c__7773__auto__,size__7774__auto__,b__9527,s__9525__$2,temp__4657__auto__))
,null,null));
});})(i__9526,x,c__7773__auto__,size__7774__auto__,b__9527,s__9525__$2,temp__4657__auto__))
;
return iter__7775__auto__.call(null,cljs.core.range.call(null,(3)));
})()));

var G__9537 = (i__9526 + (1));
i__9526 = G__9537;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__9527),tic_tac_toe$core$make_move_$_iter__9524.call(null,cljs.core.chunk_rest.call(null,s__9525__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__9527),null);
}
} else {
var x = cljs.core.first.call(null,s__9525__$2);
return cljs.core.cons.call(null,cljs.core.vec.call(null,(function (){var iter__7775__auto__ = ((function (x,s__9525__$2,temp__4657__auto__){
return (function tic_tac_toe$core$make_move_$_iter__9524_$_iter__9532(s__9533){
return (new cljs.core.LazySeq(null,((function (x,s__9525__$2,temp__4657__auto__){
return (function (){
var s__9533__$1 = s__9533;
while(true){
var temp__4657__auto____$1 = cljs.core.seq.call(null,s__9533__$1);
if(temp__4657__auto____$1){
var s__9533__$2 = temp__4657__auto____$1;
if(cljs.core.chunked_seq_QMARK_.call(null,s__9533__$2)){
var c__7773__auto__ = cljs.core.chunk_first.call(null,s__9533__$2);
var size__7774__auto__ = cljs.core.count.call(null,c__7773__auto__);
var b__9535 = cljs.core.chunk_buffer.call(null,size__7774__auto__);
if((function (){var i__9534 = (0);
while(true){
if((i__9534 < size__7774__auto__)){
var y = cljs.core._nth.call(null,c__7773__auto__,i__9534);
cljs.core.chunk_append.call(null,b__9535,(((cljs.core._EQ_.call(null,x,i)) && (cljs.core._EQ_.call(null,y,j)))?(function (){
document.getElementById([cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('')).innerHTML = tic_tac_toe.core.x_or_o_QMARK_.call(null,brd);

return tic_tac_toe.core.x_or_o_QMARK_.call(null,brd);
})()
:cljs.core.get_in.call(null,brd,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [x,y], null))));

var G__9538 = (i__9534 + (1));
i__9534 = G__9538;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__9535),tic_tac_toe$core$make_move_$_iter__9524_$_iter__9532.call(null,cljs.core.chunk_rest.call(null,s__9533__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__9535),null);
}
} else {
var y = cljs.core.first.call(null,s__9533__$2);
return cljs.core.cons.call(null,(((cljs.core._EQ_.call(null,x,i)) && (cljs.core._EQ_.call(null,y,j)))?(function (){
document.getElementById([cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('')).innerHTML = tic_tac_toe.core.x_or_o_QMARK_.call(null,brd);

return tic_tac_toe.core.x_or_o_QMARK_.call(null,brd);
})()
:cljs.core.get_in.call(null,brd,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [x,y], null))),tic_tac_toe$core$make_move_$_iter__9524_$_iter__9532.call(null,cljs.core.rest.call(null,s__9533__$2)));
}
} else {
return null;
}
break;
}
});})(x,s__9525__$2,temp__4657__auto__))
,null,null));
});})(x,s__9525__$2,temp__4657__auto__))
;
return iter__7775__auto__.call(null,cljs.core.range.call(null,(3)));
})()),tic_tac_toe$core$make_move_$_iter__9524.call(null,cljs.core.rest.call(null,s__9525__$2)));
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
tic_tac_toe.core.done_row_QMARK_ = (function tic_tac_toe$core$done_row_QMARK_(i,board){
return cljs.core.reduce.call(null,(function (a,x){
if((cljs.core._EQ_.call(null,a,x)) && (cljs.core.not_EQ_.call(null,x,""))){
return a;
} else {
return false;
}
}),cljs.core.mapv.call(null,(function (p1__9539_SHARP_){
return cljs.core.get_in.call(null,board,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [i,p1__9539_SHARP_], null));
}),cljs.core.range.call(null,(0),(3))));
});
tic_tac_toe.core.done_col_QMARK_ = (function tic_tac_toe$core$done_col_QMARK_(i,board){
return cljs.core.reduce.call(null,(function (a,x){
if((cljs.core._EQ_.call(null,a,x)) && (cljs.core.not_EQ_.call(null,x,""))){
return a;
} else {
return false;
}
}),cljs.core.mapv.call(null,(function (p1__9540_SHARP_){
return cljs.core.get_in.call(null,board,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__9540_SHARP_,i], null));
}),cljs.core.range.call(null,(0),(3))));
});
tic_tac_toe.core.diag1_QMARK_ = (function tic_tac_toe$core$diag1_QMARK_(board){
return cljs.core.reduce.call(null,(function (a,x){
if((cljs.core._EQ_.call(null,a,x)) && (cljs.core.not_EQ_.call(null,x,""))){
return a;
} else {
return false;
}
}),cljs.core.mapv.call(null,(function (p1__9541_SHARP_,p2__9542_SHARP_){
return cljs.core.get_in.call(null,board,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__9541_SHARP_,p2__9542_SHARP_], null));
}),cljs.core.range.call(null,(0),(3)),cljs.core.range.call(null,(0),(3))));
});
tic_tac_toe.core.diag2_QMARK_ = (function tic_tac_toe$core$diag2_QMARK_(board){
return cljs.core.reduce.call(null,(function (a,x){
if((cljs.core._EQ_.call(null,a,x)) && (cljs.core.not_EQ_.call(null,x,""))){
return a;
} else {
return false;
}
}),cljs.core.mapv.call(null,(function (p1__9543_SHARP_,p2__9544_SHARP_){
return cljs.core.get_in.call(null,board,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__9543_SHARP_,p2__9544_SHARP_], null));
}),cljs.core.range.call(null,(0),(3)),cljs.core.reverse.call(null,cljs.core.range.call(null,(0),(3)))));
});
tic_tac_toe.core.won_QMARK_ = (function tic_tac_toe$core$won_QMARK_(board){
var or__6986__auto__ = cljs.core.some.call(null,(function (p1__9545_SHARP_){
if(cljs.core.not_EQ_.call(null,p1__9545_SHARP_,false)){
return p1__9545_SHARP_;
} else {
return null;
}
}),cljs.core.map.call(null,(function (p1__9546_SHARP_){
return tic_tac_toe.core.done_row_QMARK_.call(null,p1__9546_SHARP_,board);
}),cljs.core.range.call(null,(3))));
if(cljs.core.truth_(or__6986__auto__)){
return or__6986__auto__;
} else {
var or__6986__auto____$1 = cljs.core.some.call(null,((function (or__6986__auto__){
return (function (p1__9547_SHARP_){
if(cljs.core.not_EQ_.call(null,p1__9547_SHARP_,false)){
return p1__9547_SHARP_;
} else {
return null;
}
});})(or__6986__auto__))
,cljs.core.map.call(null,((function (or__6986__auto__){
return (function (p1__9548_SHARP_){
return tic_tac_toe.core.done_col_QMARK_.call(null,p1__9548_SHARP_,board);
});})(or__6986__auto__))
,cljs.core.range.call(null,(3))));
if(cljs.core.truth_(or__6986__auto____$1)){
return or__6986__auto____$1;
} else {
var or__6986__auto____$2 = tic_tac_toe.core.diag1_QMARK_.call(null,board);
if(cljs.core.truth_(or__6986__auto____$2)){
return or__6986__auto____$2;
} else {
return tic_tac_toe.core.diag2_QMARK_.call(null,board);
}
}
}
});
/**
 * TIC TAC TOE MAIN FUNCTION
 */
tic_tac_toe.core.ttt_main = (function tic_tac_toe$core$ttt_main(i,j){
var inp_board = tic_tac_toe.core.get_input.call(null);
var new$ = tic_tac_toe.core.make_move.call(null,i,j,inp_board);
if(cljs.core.truth_(tic_tac_toe.core.won_QMARK_.call(null,new$))){
alert([cljs.core.str.cljs$core$IFn$_invoke$arity$1("Player "),cljs.core.str.cljs$core$IFn$_invoke$arity$1(tic_tac_toe.core.won_QMARK_.call(null,new$)),cljs.core.str.cljs$core$IFn$_invoke$arity$1(" Won..!!")].join(''));

return tic_tac_toe.core.restart.call(null);
} else {
return false;
}
});

//# sourceMappingURL=core.js.map