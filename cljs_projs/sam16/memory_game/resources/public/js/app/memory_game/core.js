// Compiled by ClojureScript 1.9.671 {}
goog.provide('memory_game.core');
goog.require('cljs.core');
memory_game.core.board = cljs.core.atom.call(null,new cljs.core.PersistentVector(null, 16, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"id","id",-1388402092),(1),new cljs.core.Keyword(null,"value","value",305978217)," ",new cljs.core.Keyword(null,"status","status",-1997798413),"closed",new cljs.core.Keyword(null,"matched","matched",-975207164),"no"], null),new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"id","id",-1388402092),(2),new cljs.core.Keyword(null,"value","value",305978217),"",new cljs.core.Keyword(null,"status","status",-1997798413),"closed",new cljs.core.Keyword(null,"matched","matched",-975207164),"no"], null),new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"id","id",-1388402092),(3),new cljs.core.Keyword(null,"value","value",305978217),"",new cljs.core.Keyword(null,"status","status",-1997798413),"closed",new cljs.core.Keyword(null,"matched","matched",-975207164),"no"], null),new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"id","id",-1388402092),(4),new cljs.core.Keyword(null,"value","value",305978217),"",new cljs.core.Keyword(null,"status","status",-1997798413),"closed",new cljs.core.Keyword(null,"matched","matched",-975207164),"no"], null),new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"id","id",-1388402092),(5),new cljs.core.Keyword(null,"value","value",305978217),"",new cljs.core.Keyword(null,"status","status",-1997798413),"closed",new cljs.core.Keyword(null,"matched","matched",-975207164),"no"], null),new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"id","id",-1388402092),(6),new cljs.core.Keyword(null,"value","value",305978217),"",new cljs.core.Keyword(null,"status","status",-1997798413),"closed",new cljs.core.Keyword(null,"matched","matched",-975207164),"no"], null),new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"id","id",-1388402092),(7),new cljs.core.Keyword(null,"value","value",305978217),"",new cljs.core.Keyword(null,"status","status",-1997798413),"closed",new cljs.core.Keyword(null,"matched","matched",-975207164),"no"], null),new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"id","id",-1388402092),(8),new cljs.core.Keyword(null,"value","value",305978217),"",new cljs.core.Keyword(null,"status","status",-1997798413),"closed",new cljs.core.Keyword(null,"matched","matched",-975207164),"no"], null),new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"id","id",-1388402092),(9),new cljs.core.Keyword(null,"value","value",305978217),"",new cljs.core.Keyword(null,"status","status",-1997798413),"closed",new cljs.core.Keyword(null,"matched","matched",-975207164),"no"], null),new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"id","id",-1388402092),(10),new cljs.core.Keyword(null,"value","value",305978217),"",new cljs.core.Keyword(null,"status","status",-1997798413),"closed",new cljs.core.Keyword(null,"matched","matched",-975207164),"no"], null),new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"id","id",-1388402092),(11),new cljs.core.Keyword(null,"value","value",305978217),"",new cljs.core.Keyword(null,"status","status",-1997798413),"closed",new cljs.core.Keyword(null,"matched","matched",-975207164),"no"], null),new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"id","id",-1388402092),(12),new cljs.core.Keyword(null,"value","value",305978217),"",new cljs.core.Keyword(null,"status","status",-1997798413),"closed",new cljs.core.Keyword(null,"matched","matched",-975207164),"no"], null),new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"id","id",-1388402092),(13),new cljs.core.Keyword(null,"value","value",305978217),"",new cljs.core.Keyword(null,"status","status",-1997798413),"closed",new cljs.core.Keyword(null,"matched","matched",-975207164),"no"], null),new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"id","id",-1388402092),(14),new cljs.core.Keyword(null,"value","value",305978217),"",new cljs.core.Keyword(null,"status","status",-1997798413),"closed",new cljs.core.Keyword(null,"matched","matched",-975207164),"no"], null),new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"id","id",-1388402092),(15),new cljs.core.Keyword(null,"value","value",305978217),"",new cljs.core.Keyword(null,"status","status",-1997798413),"closed",new cljs.core.Keyword(null,"matched","matched",-975207164),"no"], null),new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"id","id",-1388402092),(16),new cljs.core.Keyword(null,"value","value",305978217),"",new cljs.core.Keyword(null,"status","status",-1997798413),"closed",new cljs.core.Keyword(null,"matched","matched",-975207164),"no"], null)], null));
memory_game.core.log = (function memory_game$core$log(var_args){
var args__8118__auto__ = [];
var len__8111__auto___8543 = arguments.length;
var i__8112__auto___8544 = (0);
while(true){
if((i__8112__auto___8544 < len__8111__auto___8543)){
args__8118__auto__.push((arguments[i__8112__auto___8544]));

var G__8545 = (i__8112__auto___8544 + (1));
i__8112__auto___8544 = G__8545;
continue;
} else {
}
break;
}

var argseq__8119__auto__ = ((((0) < args__8118__auto__.length))?(new cljs.core.IndexedSeq(args__8118__auto__.slice((0)),(0),null)):null);
return memory_game.core.log.cljs$core$IFn$_invoke$arity$variadic(argseq__8119__auto__);
});

memory_game.core.log.cljs$core$IFn$_invoke$arity$variadic = (function (args){
return console.log(cljs.core.apply.call(null,cljs.core.str,args));
});

memory_game.core.log.cljs$lang$maxFixedArity = (0);

memory_game.core.log.cljs$lang$applyTo = (function (seq8542){
return memory_game.core.log.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq.call(null,seq8542));
});

memory_game.core.alphabets = (function memory_game$core$alphabets(){
return cljs.core.map.call(null,cljs.core.char$,cljs.core.range.call(null,(65),(91)));
});
memory_game.core.rand_alphs = (function memory_game$core$rand_alphs(size){
return cljs.core.shuffle.call(null,cljs.core.mapcat.call(null,(function (x){
var a = [cljs.core.str.cljs$core$IFn$_invoke$arity$1(cljs.core.rand_nth.call(null,memory_game.core.alphabets.call(null)))].join('');
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [a,a], null);
}),cljs.core.range.call(null,(size * (2)))));
});
memory_game.core.init = (function memory_game$core$init(init_lis){
cljs.core.doall.call(null,cljs.core.map.call(null,(function (x,y){
cljs.core.swap_BANG_.call(null,memory_game.core.board,cljs.core.update_in,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [y], null),cljs.core.assoc,new cljs.core.Keyword(null,"value","value",305978217),x);

return [cljs.core.str.cljs$core$IFn$_invoke$arity$1(x)].join('');
}),init_lis,cljs.core.range.call(null,(0),(16))));

return memory_game.core.log.call(null,cljs.core.deref.call(null,memory_game.core.board));
});
memory_game.core.set_value = (function memory_game$core$set_value(place,value){
return document.getElementById(place).value = value;
});
memory_game.core.change_status = (function memory_game$core$change_status(id1,id2){
cljs.core.swap_BANG_.call(null,memory_game.core.board,cljs.core.update_in,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [(id1 - (1))], null),cljs.core.assoc,new cljs.core.Keyword(null,"matched","matched",-975207164),"yes");

cljs.core.swap_BANG_.call(null,memory_game.core.board,cljs.core.update_in,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [(id2 - (1))], null),cljs.core.assoc,new cljs.core.Keyword(null,"matched","matched",-975207164),"yes");

document.getElementById(id1).disabled = true;

document.getElementById(id2).disabled = true;

return memory_game.core.log.call(null,"Changed status");
});
memory_game.core.close_cards = (function memory_game$core$close_cards(id1,id2){
memory_game.core.set_value.call(null,id1,"");

memory_game.core.set_value.call(null,id2,"");

cljs.core.swap_BANG_.call(null,memory_game.core.board,cljs.core.assoc_in,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(id1 - (1)),new cljs.core.Keyword(null,"status","status",-1997798413)], null),"closed");

cljs.core.swap_BANG_.call(null,memory_game.core.board,cljs.core.update_in,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [(id2 - (1))], null),cljs.core.assoc,new cljs.core.Keyword(null,"status","status",-1997798413),"closed");

return memory_game.core.log.call(null,"close cards");
});
memory_game.core.open_card = (function memory_game$core$open_card(pos){
cljs.core.swap_BANG_.call(null,memory_game.core.board,cljs.core.update_in,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [(pos - (1))], null),cljs.core.assoc,new cljs.core.Keyword(null,"status","status",-1997798413),"open");

memory_game.core.set_value.call(null,pos,cljs.core.get_in.call(null,cljs.core.deref.call(null,memory_game.core.board),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(pos - (1)),new cljs.core.Keyword(null,"value","value",305978217)], null)));

return memory_game.core.log.call(null,"Open card ",pos," With value ",cljs.core.get_in.call(null,cljs.core.deref.call(null,memory_game.core.board),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(pos - (1)),new cljs.core.Keyword(null,"value","value",305978217)], null)));
});
memory_game.core.filter_list = (function memory_game$core$filter_list(){
return cljs.core.filter.call(null,(function (x){
return (cljs.core._EQ_.call(null,"open",cljs.core.get_in.call(null,x,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"status","status",-1997798413)], null)))) && (cljs.core._EQ_.call(null,"no",cljs.core.get_in.call(null,x,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"matched","matched",-975207164)], null))));
}),cljs.core.deref.call(null,memory_game.core.board));
});
memory_game.core.check_match = (function memory_game$core$check_match(fil_lis){
var vec__8546 = fil_lis;
var a = cljs.core.nth.call(null,vec__8546,(0),null);
var b = cljs.core.nth.call(null,vec__8546,(1),null);
var map__8549 = a;
var map__8549__$1 = ((((!((map__8549 == null)))?((((map__8549.cljs$lang$protocol_mask$partition0$ & (64))) || ((cljs.core.PROTOCOL_SENTINEL === map__8549.cljs$core$ISeq$)))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__8549):map__8549);
var id1 = cljs.core.get.call(null,map__8549__$1,new cljs.core.Keyword(null,"id","id",-1388402092));
var val1 = cljs.core.get.call(null,map__8549__$1,new cljs.core.Keyword(null,"value","value",305978217));
var map__8550 = (function (){var or__6986__auto__ = b;
if(cljs.core.truth_(or__6986__auto__)){
return or__6986__auto__;
} else {
return cljs.core.PersistentArrayMap.EMPTY;
}
})();
var map__8550__$1 = ((((!((map__8550 == null)))?((((map__8550.cljs$lang$protocol_mask$partition0$ & (64))) || ((cljs.core.PROTOCOL_SENTINEL === map__8550.cljs$core$ISeq$)))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__8550):map__8550);
var id2 = cljs.core.get.call(null,map__8550__$1,new cljs.core.Keyword(null,"id","id",-1388402092));
var val2 = cljs.core.get.call(null,map__8550__$1,new cljs.core.Keyword(null,"value","value",305978217));
var my_fn = ((!(cljs.core._EQ_.call(null,val1,val2)))?((function (vec__8546,a,b,map__8549,map__8549__$1,id1,val1,map__8550,map__8550__$1,id2,val2){
return (function (x,y){
return window.setTimeout(((function (vec__8546,a,b,map__8549,map__8549__$1,id1,val1,map__8550,map__8550__$1,id2,val2){
return (function (){
return memory_game.core.close_cards.call(null,x,y);
});})(vec__8546,a,b,map__8549,map__8549__$1,id1,val1,map__8550,map__8550__$1,id2,val2))
,((1) * (1000)));
});})(vec__8546,a,b,map__8549,map__8549__$1,id1,val1,map__8550,map__8550__$1,id2,val2))
:memory_game.core.change_status);
if((cljs.core.count.call(null,fil_lis) > (1))){
return my_fn.call(null,id1,id2);
} else {
return null;
}
});
memory_game.core.game_over_QMARK_ = (function memory_game$core$game_over_QMARK_(){
if(cljs.core._EQ_.call(null,(16),cljs.core.count.call(null,cljs.core.filter.call(null,(function (x){
return cljs.core._EQ_.call(null,"yes",cljs.core.get_in.call(null,x,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"matched","matched",-975207164)], null)));
}),cljs.core.deref.call(null,memory_game.core.board))))){
alert("GAME OVER");

return location.reload(true);
} else {
return null;
}
});
memory_game.core.init.call(null,memory_game.core.rand_alphs.call(null,(4)));
/**
 * I don't do a whole lot ... yet.
 */
memory_game.core._main = (function memory_game$core$_main(pos){
memory_game.core.open_card.call(null,pos);

memory_game.core.check_match.call(null,memory_game.core.filter_list.call(null));

return memory_game.core.game_over_QMARK_.call(null);
});

//# sourceMappingURL=core.js.map