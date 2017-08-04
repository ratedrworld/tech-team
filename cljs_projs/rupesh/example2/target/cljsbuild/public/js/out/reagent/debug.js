// Compiled by ClojureScript 1.9.854 {}
goog.provide('reagent.debug');
goog.require('cljs.core');
reagent.debug.has_console = typeof console !== 'undefined';
reagent.debug.tracking = false;
if(typeof reagent.debug.warnings !== 'undefined'){
} else {
reagent.debug.warnings = cljs.core.atom.call(null,null);
}
if(typeof reagent.debug.track_console !== 'undefined'){
} else {
reagent.debug.track_console = (function (){var o = ({});
o.warn = ((function (o){
return (function() { 
var G__44488__delegate = function (args){
return cljs.core.swap_BANG_.call(null,reagent.debug.warnings,cljs.core.update_in,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"warn","warn",-436710552)], null),cljs.core.conj,cljs.core.apply.call(null,cljs.core.str,args));
};
var G__44488 = function (var_args){
var args = null;
if (arguments.length > 0) {
var G__44489__i = 0, G__44489__a = new Array(arguments.length -  0);
while (G__44489__i < G__44489__a.length) {G__44489__a[G__44489__i] = arguments[G__44489__i + 0]; ++G__44489__i;}
  args = new cljs.core.IndexedSeq(G__44489__a,0,null);
} 
return G__44488__delegate.call(this,args);};
G__44488.cljs$lang$maxFixedArity = 0;
G__44488.cljs$lang$applyTo = (function (arglist__44490){
var args = cljs.core.seq(arglist__44490);
return G__44488__delegate(args);
});
G__44488.cljs$core$IFn$_invoke$arity$variadic = G__44488__delegate;
return G__44488;
})()
;})(o))
;

o.error = ((function (o){
return (function() { 
var G__44491__delegate = function (args){
return cljs.core.swap_BANG_.call(null,reagent.debug.warnings,cljs.core.update_in,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"error","error",-978969032)], null),cljs.core.conj,cljs.core.apply.call(null,cljs.core.str,args));
};
var G__44491 = function (var_args){
var args = null;
if (arguments.length > 0) {
var G__44492__i = 0, G__44492__a = new Array(arguments.length -  0);
while (G__44492__i < G__44492__a.length) {G__44492__a[G__44492__i] = arguments[G__44492__i + 0]; ++G__44492__i;}
  args = new cljs.core.IndexedSeq(G__44492__a,0,null);
} 
return G__44491__delegate.call(this,args);};
G__44491.cljs$lang$maxFixedArity = 0;
G__44491.cljs$lang$applyTo = (function (arglist__44493){
var args = cljs.core.seq(arglist__44493);
return G__44491__delegate(args);
});
G__44491.cljs$core$IFn$_invoke$arity$variadic = G__44491__delegate;
return G__44491;
})()
;})(o))
;

return o;
})();
}
reagent.debug.track_warnings = (function reagent$debug$track_warnings(f){
reagent.debug.tracking = true;

cljs.core.reset_BANG_.call(null,reagent.debug.warnings,null);

f.call(null);

var warns = cljs.core.deref.call(null,reagent.debug.warnings);
cljs.core.reset_BANG_.call(null,reagent.debug.warnings,null);

reagent.debug.tracking = false;

return warns;
});

//# sourceMappingURL=debug.js.map
