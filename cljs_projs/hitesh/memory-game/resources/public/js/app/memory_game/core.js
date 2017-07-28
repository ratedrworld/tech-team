// Compiled by ClojureScript 1.9.671 {}
goog.provide('memory_game.core');
goog.require('cljs.core');
goog.require('clojure.string');
memory_game.core.board = cljs.core.atom.call(null,cljs.core.PersistentHashMap.fromArrays([(0),(7),(1),(4),(15),(13),(6),(3),(12),(2),(11),(9),(5),(14),(10),(8)],[new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"A",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"B",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"C",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"H",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"E",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"D",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"C",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"A",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"F",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"G",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"F",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"D",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"G",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"H",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"E",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"val","val",128701612),"B",new cljs.core.Keyword(null,"open","open",-1763596448),false,new cljs.core.Keyword(null,"done","done",-889844188),false], null)]));
/**
 * reads input from DOM
 */
memory_game.core.get_map = (function memory_game$core$get_map(){
return cljs.core.filter.call(null,(function (p1__8578_SHARP_){
return (cljs.core._EQ_.call(null,true,cljs.core.get_in.call(null,cljs.core.deref.call(null,memory_game.core.board),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__8578_SHARP_,new cljs.core.Keyword(null,"open","open",-1763596448)], null)))) && (cljs.core._EQ_.call(null,false,cljs.core.get_in.call(null,cljs.core.deref.call(null,memory_game.core.board),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__8578_SHARP_,new cljs.core.Keyword(null,"done","done",-889844188)], null))));
}),cljs.core.range.call(null,(16)));
});
/**
 * check if two open are equal or not
 */
memory_game.core.check = (function memory_game$core$check(a,b){
return cljs.core._EQ_.call(null,cljs.core.get_in.call(null,cljs.core.deref.call(null,memory_game.core.board),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [a,new cljs.core.Keyword(null,"val","val",128701612)], null)),cljs.core.get_in.call(null,cljs.core.deref.call(null,memory_game.core.board),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [b,new cljs.core.Keyword(null,"val","val",128701612)], null)));
});
memory_game.core.disable = (function memory_game$core$disable(id){
return document.getElementById(id).disabled = true;
});
memory_game.core.board_set = (function memory_game$core$board_set(id,val){
return document.getElementById(id).value = val;
});
memory_game.core.board_assoc = (function memory_game$core$board_assoc(id,k,val){
return cljs.core.swap_BANG_.call(null,memory_game.core.board,cljs.core.assoc_in,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [id,k], null),val);
});
/**
 * Close the unmatched cards
 */
memory_game.core.close_cards = (function memory_game$core$close_cards(fi,si){
memory_game.core.board_set.call(null,fi,"");

memory_game.core.board_set.call(null,si,"");

memory_game.core.board_assoc.call(null,fi,new cljs.core.Keyword(null,"open","open",-1763596448),false);

return memory_game.core.board_assoc.call(null,si,new cljs.core.Keyword(null,"open","open",-1763596448),false);
});
/**
 * Switches value of :open
 */
memory_game.core.change_open = (function memory_game$core$change_open(a){
memory_game.core.board_set.call(null,a,cljs.core.get_in.call(null,cljs.core.deref.call(null,memory_game.core.board),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [a,new cljs.core.Keyword(null,"val","val",128701612)], null)));

memory_game.core.board_assoc.call(null,a,new cljs.core.Keyword(null,"open","open",-1763596448),true);

var arr_8580 = memory_game.core.get_map.call(null);
var fi_8581 = cljs.core.first.call(null,arr_8580);
var si_8582 = cljs.core.second.call(null,arr_8580);
if(cljs.core._EQ_.call(null,(2),cljs.core.count.call(null,arr_8580))){
if(cljs.core.truth_(memory_game.core.check.call(null,fi_8581,si_8582))){
memory_game.core.disable.call(null,fi_8581);

memory_game.core.disable.call(null,si_8582);

memory_game.core.board_assoc.call(null,fi_8581,new cljs.core.Keyword(null,"open","open",-1763596448),false);

memory_game.core.board_assoc.call(null,si_8582,new cljs.core.Keyword(null,"open","open",-1763596448),false);

memory_game.core.board_assoc.call(null,fi_8581,new cljs.core.Keyword(null,"done","done",-889844188),true);

memory_game.core.board_assoc.call(null,si_8582,new cljs.core.Keyword(null,"done","done",-889844188),true);
} else {
window.setTimeout(((function (arr_8580,fi_8581,si_8582){
return (function (){
return memory_game.core.close_cards.call(null,fi_8581,si_8582);
});})(arr_8580,fi_8581,si_8582))
,((1) * (1000)));
}
} else {
}

if(cljs.core._EQ_.call(null,(16),cljs.core.count.call(null,cljs.core.filter.call(null,(function (p1__8579_SHARP_){
return cljs.core._EQ_.call(null,true,cljs.core.get_in.call(null,cljs.core.deref.call(null,memory_game.core.board),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__8579_SHARP_,new cljs.core.Keyword(null,"done","done",-889844188)], null)));
}),cljs.core.range.call(null,(16)))))){
alert("GAME SAMAPT KRIPIYA FIR SE SHURU KARE");

return location.reload(true);
} else {
return null;
}
});

//# sourceMappingURL=core.js.map