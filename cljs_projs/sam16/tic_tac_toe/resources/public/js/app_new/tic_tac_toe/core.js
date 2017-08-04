// Compiled by ClojureScript 1.9.671 {}
goog.provide('tic_tac_toe.core');
goog.require('cljs.core');
goog.require('clojure.string');
tic_tac_toe.core.get_input = (function tic_tac_toe$core$get_input(){
return cljs.core.mapv.call(null,cljs.core.vec,cljs.core.partition.call(null,(3),(function (){var iter__7775__auto__ = (function tic_tac_toe$core$get_input_$_iter__8573(s__8574){
return (new cljs.core.LazySeq(null,(function (){
var s__8574__$1 = s__8574;
while(true){
var temp__4657__auto__ = cljs.core.seq.call(null,s__8574__$1);
if(temp__4657__auto__){
var xs__5205__auto__ = temp__4657__auto__;
var i = cljs.core.first.call(null,xs__5205__auto__);
var iterys__7771__auto__ = ((function (s__8574__$1,i,xs__5205__auto__,temp__4657__auto__){
return (function tic_tac_toe$core$get_input_$_iter__8573_$_iter__8575(s__8576){
return (new cljs.core.LazySeq(null,((function (s__8574__$1,i,xs__5205__auto__,temp__4657__auto__){
return (function (){
var s__8576__$1 = s__8576;
while(true){
var temp__4657__auto____$1 = cljs.core.seq.call(null,s__8576__$1);
if(temp__4657__auto____$1){
var s__8576__$2 = temp__4657__auto____$1;
if(cljs.core.chunked_seq_QMARK_.call(null,s__8576__$2)){
var c__7773__auto__ = cljs.core.chunk_first.call(null,s__8576__$2);
var size__7774__auto__ = cljs.core.count.call(null,c__7773__auto__);
var b__8578 = cljs.core.chunk_buffer.call(null,size__7774__auto__);
if((function (){var i__8577 = (0);
while(true){
if((i__8577 < size__7774__auto__)){
var j = cljs.core._nth.call(null,c__7773__auto__,i__8577);
var blockno = [cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('');
cljs.core.chunk_append.call(null,b__8578,document.getElementById(blockno).innerHTML);

var G__8579 = (i__8577 + (1));
i__8577 = G__8579;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8578),tic_tac_toe$core$get_input_$_iter__8573_$_iter__8575.call(null,cljs.core.chunk_rest.call(null,s__8576__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8578),null);
}
} else {
var j = cljs.core.first.call(null,s__8576__$2);
var blockno = [cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('');
return cljs.core.cons.call(null,document.getElementById(blockno).innerHTML,tic_tac_toe$core$get_input_$_iter__8573_$_iter__8575.call(null,cljs.core.rest.call(null,s__8576__$2)));
}
} else {
return null;
}
break;
}
});})(s__8574__$1,i,xs__5205__auto__,temp__4657__auto__))
,null,null));
});})(s__8574__$1,i,xs__5205__auto__,temp__4657__auto__))
;
var fs__7772__auto__ = cljs.core.seq.call(null,iterys__7771__auto__.call(null,cljs.core.range.call(null,(3))));
if(fs__7772__auto__){
return cljs.core.concat.call(null,fs__7772__auto__,tic_tac_toe$core$get_input_$_iter__8573.call(null,cljs.core.rest.call(null,s__8574__$1)));
} else {
var G__8580 = cljs.core.rest.call(null,s__8574__$1);
s__8574__$1 = G__8580;
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
var iter__7775__auto__ = (function tic_tac_toe$core$set_output_$_iter__8581(s__8582){
return (new cljs.core.LazySeq(null,(function (){
var s__8582__$1 = s__8582;
while(true){
var temp__4657__auto__ = cljs.core.seq.call(null,s__8582__$1);
if(temp__4657__auto__){
var xs__5205__auto__ = temp__4657__auto__;
var i = cljs.core.first.call(null,xs__5205__auto__);
var iterys__7771__auto__ = ((function (s__8582__$1,i,xs__5205__auto__,temp__4657__auto__){
return (function tic_tac_toe$core$set_output_$_iter__8581_$_iter__8583(s__8584){
return (new cljs.core.LazySeq(null,((function (s__8582__$1,i,xs__5205__auto__,temp__4657__auto__){
return (function (){
var s__8584__$1 = s__8584;
while(true){
var temp__4657__auto____$1 = cljs.core.seq.call(null,s__8584__$1);
if(temp__4657__auto____$1){
var s__8584__$2 = temp__4657__auto____$1;
if(cljs.core.chunked_seq_QMARK_.call(null,s__8584__$2)){
var c__7773__auto__ = cljs.core.chunk_first.call(null,s__8584__$2);
var size__7774__auto__ = cljs.core.count.call(null,c__7773__auto__);
var b__8586 = cljs.core.chunk_buffer.call(null,size__7774__auto__);
if((function (){var i__8585 = (0);
while(true){
if((i__8585 < size__7774__auto__)){
var j = cljs.core._nth.call(null,c__7773__auto__,i__8585);
var blockno = [cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('');
cljs.core.chunk_append.call(null,b__8586,document.getElementById([cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('')).innerHTML = cljs.core.get_in.call(null,board,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [i,j], null)));

var G__8587 = (i__8585 + (1));
i__8585 = G__8587;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8586),tic_tac_toe$core$set_output_$_iter__8581_$_iter__8583.call(null,cljs.core.chunk_rest.call(null,s__8584__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8586),null);
}
} else {
var j = cljs.core.first.call(null,s__8584__$2);
var blockno = [cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('');
return cljs.core.cons.call(null,document.getElementById([cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('')).innerHTML = cljs.core.get_in.call(null,board,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [i,j], null)),tic_tac_toe$core$set_output_$_iter__8581_$_iter__8583.call(null,cljs.core.rest.call(null,s__8584__$2)));
}
} else {
return null;
}
break;
}
});})(s__8582__$1,i,xs__5205__auto__,temp__4657__auto__))
,null,null));
});})(s__8582__$1,i,xs__5205__auto__,temp__4657__auto__))
;
var fs__7772__auto__ = cljs.core.seq.call(null,iterys__7771__auto__.call(null,cljs.core.range.call(null,(3))));
if(fs__7772__auto__){
return cljs.core.concat.call(null,fs__7772__auto__,tic_tac_toe$core$set_output_$_iter__8581.call(null,cljs.core.rest.call(null,s__8582__$1)));
} else {
var G__8588 = cljs.core.rest.call(null,s__8582__$1);
s__8582__$1 = G__8588;
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

return cljs.core.doall.call(null,(function (){var iter__7775__auto__ = (function tic_tac_toe$core$restart_$_iter__8589(s__8590){
return (new cljs.core.LazySeq(null,(function (){
var s__8590__$1 = s__8590;
while(true){
var temp__4657__auto__ = cljs.core.seq.call(null,s__8590__$1);
if(temp__4657__auto__){
var xs__5205__auto__ = temp__4657__auto__;
var i = cljs.core.first.call(null,xs__5205__auto__);
var iterys__7771__auto__ = ((function (s__8590__$1,i,xs__5205__auto__,temp__4657__auto__){
return (function tic_tac_toe$core$restart_$_iter__8589_$_iter__8591(s__8592){
return (new cljs.core.LazySeq(null,((function (s__8590__$1,i,xs__5205__auto__,temp__4657__auto__){
return (function (){
var s__8592__$1 = s__8592;
while(true){
var temp__4657__auto____$1 = cljs.core.seq.call(null,s__8592__$1);
if(temp__4657__auto____$1){
var s__8592__$2 = temp__4657__auto____$1;
if(cljs.core.chunked_seq_QMARK_.call(null,s__8592__$2)){
var c__7773__auto__ = cljs.core.chunk_first.call(null,s__8592__$2);
var size__7774__auto__ = cljs.core.count.call(null,c__7773__auto__);
var b__8594 = cljs.core.chunk_buffer.call(null,size__7774__auto__);
if((function (){var i__8593 = (0);
while(true){
if((i__8593 < size__7774__auto__)){
var j = cljs.core._nth.call(null,c__7773__auto__,i__8593);
var blockno = [cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('');
cljs.core.chunk_append.call(null,b__8594,document.getElementById([cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('')).innerHTML = "");

var G__8595 = (i__8593 + (1));
i__8593 = G__8595;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8594),tic_tac_toe$core$restart_$_iter__8589_$_iter__8591.call(null,cljs.core.chunk_rest.call(null,s__8592__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8594),null);
}
} else {
var j = cljs.core.first.call(null,s__8592__$2);
var blockno = [cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('');
return cljs.core.cons.call(null,document.getElementById([cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('')).innerHTML = "",tic_tac_toe$core$restart_$_iter__8589_$_iter__8591.call(null,cljs.core.rest.call(null,s__8592__$2)));
}
} else {
return null;
}
break;
}
});})(s__8590__$1,i,xs__5205__auto__,temp__4657__auto__))
,null,null));
});})(s__8590__$1,i,xs__5205__auto__,temp__4657__auto__))
;
var fs__7772__auto__ = cljs.core.seq.call(null,iterys__7771__auto__.call(null,cljs.core.range.call(null,(3))));
if(fs__7772__auto__){
return cljs.core.concat.call(null,fs__7772__auto__,tic_tac_toe$core$restart_$_iter__8589.call(null,cljs.core.rest.call(null,s__8590__$1)));
} else {
var G__8596 = cljs.core.rest.call(null,s__8590__$1);
s__8590__$1 = G__8596;
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
return cljs.core.vec.call(null,(function (){var iter__7775__auto__ = (function tic_tac_toe$core$make_move_$_iter__8597(s__8598){
return (new cljs.core.LazySeq(null,(function (){
var s__8598__$1 = s__8598;
while(true){
var temp__4657__auto__ = cljs.core.seq.call(null,s__8598__$1);
if(temp__4657__auto__){
var s__8598__$2 = temp__4657__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,s__8598__$2)){
var c__7773__auto__ = cljs.core.chunk_first.call(null,s__8598__$2);
var size__7774__auto__ = cljs.core.count.call(null,c__7773__auto__);
var b__8600 = cljs.core.chunk_buffer.call(null,size__7774__auto__);
if((function (){var i__8599 = (0);
while(true){
if((i__8599 < size__7774__auto__)){
var x = cljs.core._nth.call(null,c__7773__auto__,i__8599);
cljs.core.chunk_append.call(null,b__8600,cljs.core.vec.call(null,(function (){var iter__7775__auto__ = ((function (i__8599,x,c__7773__auto__,size__7774__auto__,b__8600,s__8598__$2,temp__4657__auto__){
return (function tic_tac_toe$core$make_move_$_iter__8597_$_iter__8601(s__8602){
return (new cljs.core.LazySeq(null,((function (i__8599,x,c__7773__auto__,size__7774__auto__,b__8600,s__8598__$2,temp__4657__auto__){
return (function (){
var s__8602__$1 = s__8602;
while(true){
var temp__4657__auto____$1 = cljs.core.seq.call(null,s__8602__$1);
if(temp__4657__auto____$1){
var s__8602__$2 = temp__4657__auto____$1;
if(cljs.core.chunked_seq_QMARK_.call(null,s__8602__$2)){
var c__7773__auto____$1 = cljs.core.chunk_first.call(null,s__8602__$2);
var size__7774__auto____$1 = cljs.core.count.call(null,c__7773__auto____$1);
var b__8604 = cljs.core.chunk_buffer.call(null,size__7774__auto____$1);
if((function (){var i__8603 = (0);
while(true){
if((i__8603 < size__7774__auto____$1)){
var y = cljs.core._nth.call(null,c__7773__auto____$1,i__8603);
cljs.core.chunk_append.call(null,b__8604,(((cljs.core._EQ_.call(null,x,i)) && (cljs.core._EQ_.call(null,y,j)))?(function (){
document.getElementById([cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('')).innerHTML = tic_tac_toe.core.x_or_o_QMARK_.call(null,brd);

return tic_tac_toe.core.x_or_o_QMARK_.call(null,brd);
})()
:cljs.core.get_in.call(null,brd,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [x,y], null))));

var G__8609 = (i__8603 + (1));
i__8603 = G__8609;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8604),tic_tac_toe$core$make_move_$_iter__8597_$_iter__8601.call(null,cljs.core.chunk_rest.call(null,s__8602__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8604),null);
}
} else {
var y = cljs.core.first.call(null,s__8602__$2);
return cljs.core.cons.call(null,(((cljs.core._EQ_.call(null,x,i)) && (cljs.core._EQ_.call(null,y,j)))?(function (){
document.getElementById([cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('')).innerHTML = tic_tac_toe.core.x_or_o_QMARK_.call(null,brd);

return tic_tac_toe.core.x_or_o_QMARK_.call(null,brd);
})()
:cljs.core.get_in.call(null,brd,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [x,y], null))),tic_tac_toe$core$make_move_$_iter__8597_$_iter__8601.call(null,cljs.core.rest.call(null,s__8602__$2)));
}
} else {
return null;
}
break;
}
});})(i__8599,x,c__7773__auto__,size__7774__auto__,b__8600,s__8598__$2,temp__4657__auto__))
,null,null));
});})(i__8599,x,c__7773__auto__,size__7774__auto__,b__8600,s__8598__$2,temp__4657__auto__))
;
return iter__7775__auto__.call(null,cljs.core.range.call(null,(3)));
})()));

var G__8610 = (i__8599 + (1));
i__8599 = G__8610;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8600),tic_tac_toe$core$make_move_$_iter__8597.call(null,cljs.core.chunk_rest.call(null,s__8598__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8600),null);
}
} else {
var x = cljs.core.first.call(null,s__8598__$2);
return cljs.core.cons.call(null,cljs.core.vec.call(null,(function (){var iter__7775__auto__ = ((function (x,s__8598__$2,temp__4657__auto__){
return (function tic_tac_toe$core$make_move_$_iter__8597_$_iter__8605(s__8606){
return (new cljs.core.LazySeq(null,((function (x,s__8598__$2,temp__4657__auto__){
return (function (){
var s__8606__$1 = s__8606;
while(true){
var temp__4657__auto____$1 = cljs.core.seq.call(null,s__8606__$1);
if(temp__4657__auto____$1){
var s__8606__$2 = temp__4657__auto____$1;
if(cljs.core.chunked_seq_QMARK_.call(null,s__8606__$2)){
var c__7773__auto__ = cljs.core.chunk_first.call(null,s__8606__$2);
var size__7774__auto__ = cljs.core.count.call(null,c__7773__auto__);
var b__8608 = cljs.core.chunk_buffer.call(null,size__7774__auto__);
if((function (){var i__8607 = (0);
while(true){
if((i__8607 < size__7774__auto__)){
var y = cljs.core._nth.call(null,c__7773__auto__,i__8607);
cljs.core.chunk_append.call(null,b__8608,(((cljs.core._EQ_.call(null,x,i)) && (cljs.core._EQ_.call(null,y,j)))?(function (){
document.getElementById([cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('')).innerHTML = tic_tac_toe.core.x_or_o_QMARK_.call(null,brd);

return tic_tac_toe.core.x_or_o_QMARK_.call(null,brd);
})()
:cljs.core.get_in.call(null,brd,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [x,y], null))));

var G__8611 = (i__8607 + (1));
i__8607 = G__8611;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8608),tic_tac_toe$core$make_move_$_iter__8597_$_iter__8605.call(null,cljs.core.chunk_rest.call(null,s__8606__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__8608),null);
}
} else {
var y = cljs.core.first.call(null,s__8606__$2);
return cljs.core.cons.call(null,(((cljs.core._EQ_.call(null,x,i)) && (cljs.core._EQ_.call(null,y,j)))?(function (){
document.getElementById([cljs.core.str.cljs$core$IFn$_invoke$arity$1("box"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(i),cljs.core.str.cljs$core$IFn$_invoke$arity$1(j)].join('')).innerHTML = tic_tac_toe.core.x_or_o_QMARK_.call(null,brd);

return tic_tac_toe.core.x_or_o_QMARK_.call(null,brd);
})()
:cljs.core.get_in.call(null,brd,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [x,y], null))),tic_tac_toe$core$make_move_$_iter__8597_$_iter__8605.call(null,cljs.core.rest.call(null,s__8606__$2)));
}
} else {
return null;
}
break;
}
});})(x,s__8598__$2,temp__4657__auto__))
,null,null));
});})(x,s__8598__$2,temp__4657__auto__))
;
return iter__7775__auto__.call(null,cljs.core.range.call(null,(3)));
})()),tic_tac_toe$core$make_move_$_iter__8597.call(null,cljs.core.rest.call(null,s__8598__$2)));
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
}),cljs.core.mapv.call(null,(function (p1__8612_SHARP_){
return cljs.core.get_in.call(null,board,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [i,p1__8612_SHARP_], null));
}),cljs.core.range.call(null,(0),(3))));
});
tic_tac_toe.core.done_col_QMARK_ = (function tic_tac_toe$core$done_col_QMARK_(i,board){
return cljs.core.reduce.call(null,(function (a,x){
if((cljs.core._EQ_.call(null,a,x)) && (cljs.core.not_EQ_.call(null,x,""))){
return a;
} else {
return false;
}
}),cljs.core.mapv.call(null,(function (p1__8613_SHARP_){
return cljs.core.get_in.call(null,board,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__8613_SHARP_,i], null));
}),cljs.core.range.call(null,(0),(3))));
});
tic_tac_toe.core.diag1_QMARK_ = (function tic_tac_toe$core$diag1_QMARK_(board){
return cljs.core.reduce.call(null,(function (a,x){
if((cljs.core._EQ_.call(null,a,x)) && (cljs.core.not_EQ_.call(null,x,""))){
return a;
} else {
return false;
}
}),cljs.core.mapv.call(null,(function (p1__8614_SHARP_,p2__8615_SHARP_){
return cljs.core.get_in.call(null,board,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__8614_SHARP_,p2__8615_SHARP_], null));
}),cljs.core.range.call(null,(0),(3)),cljs.core.range.call(null,(0),(3))));
});
tic_tac_toe.core.diag2_QMARK_ = (function tic_tac_toe$core$diag2_QMARK_(board){
return cljs.core.reduce.call(null,(function (a,x){
if((cljs.core._EQ_.call(null,a,x)) && (cljs.core.not_EQ_.call(null,x,""))){
return a;
} else {
return false;
}
}),cljs.core.mapv.call(null,(function (p1__8616_SHARP_,p2__8617_SHARP_){
return cljs.core.get_in.call(null,board,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__8616_SHARP_,p2__8617_SHARP_], null));
}),cljs.core.range.call(null,(0),(3)),cljs.core.reverse.call(null,cljs.core.range.call(null,(0),(3)))));
});
tic_tac_toe.core.won_QMARK_ = (function tic_tac_toe$core$won_QMARK_(board){
var or__6986__auto__ = cljs.core.some.call(null,(function (p1__8618_SHARP_){
if(cljs.core.not_EQ_.call(null,p1__8618_SHARP_,false)){
return p1__8618_SHARP_;
} else {
return null;
}
}),cljs.core.map.call(null,(function (p1__8619_SHARP_){
return tic_tac_toe.core.done_row_QMARK_.call(null,p1__8619_SHARP_,board);
}),cljs.core.range.call(null,(3))));
if(cljs.core.truth_(or__6986__auto__)){
return or__6986__auto__;
} else {
var or__6986__auto____$1 = cljs.core.some.call(null,((function (or__6986__auto__){
return (function (p1__8620_SHARP_){
if(cljs.core.not_EQ_.call(null,p1__8620_SHARP_,false)){
return p1__8620_SHARP_;
} else {
return null;
}
});})(or__6986__auto__))
,cljs.core.map.call(null,((function (or__6986__auto__){
return (function (p1__8621_SHARP_){
return tic_tac_toe.core.done_col_QMARK_.call(null,p1__8621_SHARP_,board);
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