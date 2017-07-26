// Compiled by ClojureScript 1.9.671 {}
goog.provide('tic_tac_toe.core');
goog.require('cljs.core');
/**
 * Converts the input X and O to 1 and O respectively
 */
tic_tac_toe.core.convert_to_input = (function tic_tac_toe$core$convert_to_input(board){
return cljs.core.mapv.call(null,cljs.core.vec,cljs.core.partition.call(null,(3),cljs.core.mapv.call(null,(function (p1__9467_SHARP_){
if(cljs.core._EQ_.call(null,"X",p1__9467_SHARP_)){
return (1);
} else {
if(cljs.core._EQ_.call(null,"O",p1__9467_SHARP_)){
return (0);
} else {
return null;
}
}
}),board)));
});
/**
 * Returns X or O according to last move
 */
tic_tac_toe.core.next_move = (function tic_tac_toe$core$next_move(board){
var in$ = cljs.core.flatten.call(null,board);
var cx = cljs.core.count.call(null,cljs.core.filter.call(null,((function (in$){
return (function (p1__9468_SHARP_){
return cljs.core._EQ_.call(null,(1),p1__9468_SHARP_);
});})(in$))
,in$));
var co = cljs.core.count.call(null,cljs.core.filter.call(null,((function (in$,cx){
return (function (p1__9469_SHARP_){
return cljs.core._EQ_.call(null,(0),p1__9469_SHARP_);
});})(in$,cx))
,in$));
if((cx <= co)){
return "X";
} else {
return "O";
}
});
/**
 * Checks if elements on row are in win state
 */
tic_tac_toe.core.check_row = (function tic_tac_toe$core$check_row(input){
return cljs.core.some.call(null,cljs.core.true_QMARK_,cljs.core.mapv.call(null,(function (p1__9470_SHARP_){
return cljs.core._EQ_.call(null,(1),cljs.core.count.call(null,((cljs.core._EQ_.call(null,cljs.core.list(null),cljs.core.distinct.call(null,cljs.core.get.call(null,input,p1__9470_SHARP_))))?new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(0),(0)], null):cljs.core.distinct.call(null,cljs.core.get.call(null,input,p1__9470_SHARP_)))));
}),cljs.core.range.call(null,(0),(3))));
});
/**
 * Checks if elements on column are in win state
 */
tic_tac_toe.core.check_column = (function tic_tac_toe$core$check_column(input){
return cljs.core.some.call(null,cljs.core.true_QMARK_,cljs.core.mapv.call(null,(function (x){
return cljs.core._EQ_.call(null,(1),cljs.core.count.call(null,((cljs.core._EQ_.call(null,cljs.core.list(null),cljs.core.distinct.call(null,cljs.core.map.call(null,(function (p1__9471_SHARP_){
return cljs.core.get_in.call(null,input,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__9471_SHARP_,x], null));
}),cljs.core.range.call(null,(0),(3))))))?new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(0),(0)], null):cljs.core.distinct.call(null,cljs.core.map.call(null,(function (p1__9472_SHARP_){
return cljs.core.get_in.call(null,input,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__9472_SHARP_,x], null));
}),cljs.core.range.call(null,(0),(3)))))));
}),cljs.core.range.call(null,(0),(3))));
});
tic_tac_toe.core.check_diagonal = (function tic_tac_toe$core$check_diagonal(input){
return cljs.core.some.call(null,cljs.core.true_QMARK_,cljs.core.map.call(null,(function (p1__9473_SHARP_){
return cljs.core._EQ_.call(null,(1),cljs.core.count.call(null,((cljs.core._EQ_.call(null,cljs.core.list(null),cljs.core.distinct.call(null,p1__9473_SHARP_)))?new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(0),(0)], null):cljs.core.distinct.call(null,p1__9473_SHARP_))));
}),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[cljs.core.map.call(null,(function (p1__9474_SHARP_,p2__9475_SHARP_){
return cljs.core.get_in.call(null,input,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__9474_SHARP_,p2__9475_SHARP_], null));
}),cljs.core.range.call(null,(0),(3)),cljs.core.range.call(null,(0),(3))),cljs.core.map.call(null,(function (p1__9476_SHARP_,p2__9477_SHARP_){
return cljs.core.get_in.call(null,input,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__9476_SHARP_,p2__9477_SHARP_], null));
}),cljs.core.list((2),(1),(0)),cljs.core.list((0),(1),(2)))],null))));
});
/**
 * Returns true if user has won else false
 */
tic_tac_toe.core.check_win_QMARK_ = (function tic_tac_toe$core$check_win_QMARK_(input){
var or__6986__auto__ = tic_tac_toe.core.check_row.call(null,input);
if(cljs.core.truth_(or__6986__auto__)){
return or__6986__auto__;
} else {
var or__6986__auto____$1 = tic_tac_toe.core.check_column.call(null,input);
if(cljs.core.truth_(or__6986__auto____$1)){
return or__6986__auto____$1;
} else {
return tic_tac_toe.core.check_diagonal.call(null,input);
}
}
});
tic_tac_toe.core.play = (function tic_tac_toe$core$play(inp){
document.getElementById(inp).disabled = true;

document.getElementById(inp).value = tic_tac_toe.core.next_move.call(null,tic_tac_toe.core.convert_to_input.call(null,cljs.core.mapv.call(null,(function (p1__9479_SHARP_){
return document.getElementById(p1__9479_SHARP_).value;
}),cljs.core.range.call(null,(0),(9)))));

var in$ = cljs.core.mapv.call(null,(function (p1__9480_SHARP_){
return document.getElementById(p1__9480_SHARP_).value;
}),cljs.core.range.call(null,(0),(9)));
if(cljs.core.truth_(tic_tac_toe.core.check_win_QMARK_.call(null,tic_tac_toe.core.convert_to_input.call(null,in$)))){
return alert([cljs.core.str.cljs$core$IFn$_invoke$arity$1("Congratulations: Player "),cljs.core.str.cljs$core$IFn$_invoke$arity$1(document.getElementById(inp).value),cljs.core.str.cljs$core$IFn$_invoke$arity$1(" wins")].join(''));
} else {
return null;
}
});

//# sourceMappingURL=core.js.map