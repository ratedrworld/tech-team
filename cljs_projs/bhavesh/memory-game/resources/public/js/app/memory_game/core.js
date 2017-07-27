// Compiled by ClojureScript 1.9.671 {}
goog.provide('memory_game.core');
goog.require('cljs.core');
memory_game.core.make_rand_arr = (function memory_game$core$make_rand_arr(n){
var limit = (n * n);
var arr = cljs.core.range.call(null,(0),(limit / (2)));
return cljs.core.shuffle.call(null,cljs.core.concat.call(null,arr,arr));
});
memory_game.core.make_board = (function memory_game$core$make_board(var_args){
var G__8591 = arguments.length;
switch (G__8591) {
case 1:
return memory_game.core.make_board.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 3:
return memory_game.core.make_board.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str.cljs$core$IFn$_invoke$arity$1("Invalid arity: "),cljs.core.str.cljs$core$IFn$_invoke$arity$1(arguments.length)].join('')));

}
});

memory_game.core.make_board.cljs$core$IFn$_invoke$arity$1 = (function (n){
return memory_game.core.make_board.call(null,cljs.core.PersistentArrayMap.EMPTY,memory_game.core.make_rand_arr.call(null,n),(1));
});

memory_game.core.make_board.cljs$core$IFn$_invoke$arity$3 = (function (board,rand_arr,pos){
if(cljs.core.empty_QMARK_.call(null,rand_arr)){
return board;
} else {
return memory_game.core.make_board.call(null,cljs.core.assoc.call(null,board,pos,[cljs.core.str.cljs$core$IFn$_invoke$arity$1(cljs.core.first.call(null,rand_arr))].join('')),cljs.core.rest.call(null,rand_arr),(pos + (1)));
}
});

memory_game.core.make_board.cljs$lang$maxFixedArity = 3;

memory_game.core.board = memory_game.core.make_board.call(null,(4));
memory_game.core.disable = (function memory_game$core$disable(id1,id2){
cljs.core.doall.call(null,cljs.core.map.call(null,(function (p1__8593_SHARP_){
return document.getElementById(p1__8593_SHARP_).disabled = true;
}),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [id1,id2], null)));

return document.getElementById((17)).value = "";
});
memory_game.core.clear = (function memory_game$core$clear(id1,id2){
return window.setTimeout((function (x){
return cljs.core.doall.call(null,cljs.core.map.call(null,(function (p1__8594_SHARP_){
return document.getElementById(p1__8594_SHARP_).value = "";
}),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [id1,id2,(17)], null)));
}),((1) * (1000)));
});
memory_game.core.check = (function memory_game$core$check(id1,id2){
if(cljs.core._EQ_.call(null,id1,id2)){
return document.getElementById(id1).value = "";
} else {
var values = cljs.core.map.call(null,(function (p1__8595_SHARP_){
return document.getElementById(p1__8595_SHARP_).value;
}),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [id1,id2], null));
if(cljs.core.truth_(cljs.core.apply.call(null,cljs.core._EQ_,values))){
return memory_game.core.disable.call(null,id1,id2);
} else {
return memory_game.core.clear.call(null,id1,id2);
}
}
});
/**
 * I don't do a whole lot ... yet.
 */
memory_game.core._main = (function memory_game$core$_main(id){
var value = cljs.core.get.call(null,memory_game.core.board,id);
var last_tile = document.getElementById((17)).value;
document.getElementById(id).value = value;

if(cljs.core.empty_QMARK_.call(null,last_tile)){
return document.getElementById((17)).value = id;
} else {
return memory_game.core.check.call(null,id,last_tile);
}
});

//# sourceMappingURL=core.js.map