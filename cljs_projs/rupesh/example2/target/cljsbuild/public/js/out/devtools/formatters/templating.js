// Compiled by ClojureScript 1.9.854 {}
goog.provide('devtools.formatters.templating');
goog.require('cljs.core');
goog.require('clojure.walk');
goog.require('devtools.util');
goog.require('devtools.protocols');
goog.require('devtools.formatters.helpers');
goog.require('devtools.formatters.state');
goog.require('clojure.string');
devtools.formatters.templating.mark_as_group_BANG_ = (function devtools$formatters$templating$mark_as_group_BANG_(value){
var x44006_44007 = value;
x44006_44007.devtools$protocols$IGroup$ = cljs.core.PROTOCOL_SENTINEL;


return value;
});
devtools.formatters.templating.group_QMARK_ = (function devtools$formatters$templating$group_QMARK_(value){
if(!((value == null))){
if((false) || ((cljs.core.PROTOCOL_SENTINEL === value.devtools$protocols$IGroup$))){
return true;
} else {
if((!value.cljs$lang$protocol_mask$partition$)){
return cljs.core.native_satisfies_QMARK_.call(null,devtools.protocols.IGroup,value);
} else {
return false;
}
}
} else {
return cljs.core.native_satisfies_QMARK_.call(null,devtools.protocols.IGroup,value);
}
});
devtools.formatters.templating.mark_as_template_BANG_ = (function devtools$formatters$templating$mark_as_template_BANG_(value){
var x44009_44010 = value;
x44009_44010.devtools$protocols$ITemplate$ = cljs.core.PROTOCOL_SENTINEL;


return value;
});
devtools.formatters.templating.template_QMARK_ = (function devtools$formatters$templating$template_QMARK_(value){
if(!((value == null))){
if((false) || ((cljs.core.PROTOCOL_SENTINEL === value.devtools$protocols$ITemplate$))){
return true;
} else {
if((!value.cljs$lang$protocol_mask$partition$)){
return cljs.core.native_satisfies_QMARK_.call(null,devtools.protocols.ITemplate,value);
} else {
return false;
}
}
} else {
return cljs.core.native_satisfies_QMARK_.call(null,devtools.protocols.ITemplate,value);
}
});
devtools.formatters.templating.mark_as_surrogate_BANG_ = (function devtools$formatters$templating$mark_as_surrogate_BANG_(value){
var x44012_44013 = value;
x44012_44013.devtools$protocols$ISurrogate$ = cljs.core.PROTOCOL_SENTINEL;


return value;
});
devtools.formatters.templating.surrogate_QMARK_ = (function devtools$formatters$templating$surrogate_QMARK_(value){
if(!((value == null))){
if((false) || ((cljs.core.PROTOCOL_SENTINEL === value.devtools$protocols$ISurrogate$))){
return true;
} else {
if((!value.cljs$lang$protocol_mask$partition$)){
return cljs.core.native_satisfies_QMARK_.call(null,devtools.protocols.ISurrogate,value);
} else {
return false;
}
}
} else {
return cljs.core.native_satisfies_QMARK_.call(null,devtools.protocols.ISurrogate,value);
}
});
devtools.formatters.templating.reference_QMARK_ = (function devtools$formatters$templating$reference_QMARK_(value){
var and__39148__auto__ = devtools.formatters.templating.group_QMARK_.call(null,value);
if(cljs.core.truth_(and__39148__auto__)){
return cljs.core._EQ_.call(null,(value[(0)]),"object");
} else {
return and__39148__auto__;
}
});
devtools.formatters.templating.make_group = (function devtools$formatters$templating$make_group(var_args){
var args__40331__auto__ = [];
var len__40324__auto___44020 = arguments.length;
var i__40325__auto___44021 = (0);
while(true){
if((i__40325__auto___44021 < len__40324__auto___44020)){
args__40331__auto__.push((arguments[i__40325__auto___44021]));

var G__44022 = (i__40325__auto___44021 + (1));
i__40325__auto___44021 = G__44022;
continue;
} else {
}
break;
}

var argseq__40332__auto__ = ((((0) < args__40331__auto__.length))?(new cljs.core.IndexedSeq(args__40331__auto__.slice((0)),(0),null)):null);
return devtools.formatters.templating.make_group.cljs$core$IFn$_invoke$arity$variadic(argseq__40332__auto__);
});

devtools.formatters.templating.make_group.cljs$core$IFn$_invoke$arity$variadic = (function (items){
var group = devtools.formatters.templating.mark_as_group_BANG_.call(null,[]);
var seq__44016_44023 = cljs.core.seq.call(null,items);
var chunk__44017_44024 = null;
var count__44018_44025 = (0);
var i__44019_44026 = (0);
while(true){
if((i__44019_44026 < count__44018_44025)){
var item_44027 = cljs.core._nth.call(null,chunk__44017_44024,i__44019_44026);
if(!((item_44027 == null))){
if(cljs.core.coll_QMARK_.call(null,item_44027)){
(group["push"]).apply(group,devtools.formatters.templating.mark_as_group_BANG_.call(null,cljs.core.into_array.call(null,item_44027)));
} else {
group.push(devtools.formatters.helpers.pref.call(null,item_44027));
}
} else {
}

var G__44028 = seq__44016_44023;
var G__44029 = chunk__44017_44024;
var G__44030 = count__44018_44025;
var G__44031 = (i__44019_44026 + (1));
seq__44016_44023 = G__44028;
chunk__44017_44024 = G__44029;
count__44018_44025 = G__44030;
i__44019_44026 = G__44031;
continue;
} else {
var temp__4657__auto___44032 = cljs.core.seq.call(null,seq__44016_44023);
if(temp__4657__auto___44032){
var seq__44016_44033__$1 = temp__4657__auto___44032;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__44016_44033__$1)){
var c__39994__auto___44034 = cljs.core.chunk_first.call(null,seq__44016_44033__$1);
var G__44035 = cljs.core.chunk_rest.call(null,seq__44016_44033__$1);
var G__44036 = c__39994__auto___44034;
var G__44037 = cljs.core.count.call(null,c__39994__auto___44034);
var G__44038 = (0);
seq__44016_44023 = G__44035;
chunk__44017_44024 = G__44036;
count__44018_44025 = G__44037;
i__44019_44026 = G__44038;
continue;
} else {
var item_44039 = cljs.core.first.call(null,seq__44016_44033__$1);
if(!((item_44039 == null))){
if(cljs.core.coll_QMARK_.call(null,item_44039)){
(group["push"]).apply(group,devtools.formatters.templating.mark_as_group_BANG_.call(null,cljs.core.into_array.call(null,item_44039)));
} else {
group.push(devtools.formatters.helpers.pref.call(null,item_44039));
}
} else {
}

var G__44040 = cljs.core.next.call(null,seq__44016_44033__$1);
var G__44041 = null;
var G__44042 = (0);
var G__44043 = (0);
seq__44016_44023 = G__44040;
chunk__44017_44024 = G__44041;
count__44018_44025 = G__44042;
i__44019_44026 = G__44043;
continue;
}
} else {
}
}
break;
}

return group;
});

devtools.formatters.templating.make_group.cljs$lang$maxFixedArity = (0);

devtools.formatters.templating.make_group.cljs$lang$applyTo = (function (seq44015){
return devtools.formatters.templating.make_group.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq.call(null,seq44015));
});

devtools.formatters.templating.make_template = (function devtools$formatters$templating$make_template(var_args){
var args__40331__auto__ = [];
var len__40324__auto___44051 = arguments.length;
var i__40325__auto___44052 = (0);
while(true){
if((i__40325__auto___44052 < len__40324__auto___44051)){
args__40331__auto__.push((arguments[i__40325__auto___44052]));

var G__44053 = (i__40325__auto___44052 + (1));
i__40325__auto___44052 = G__44053;
continue;
} else {
}
break;
}

var argseq__40332__auto__ = ((((2) < args__40331__auto__.length))?(new cljs.core.IndexedSeq(args__40331__auto__.slice((2)),(0),null)):null);
return devtools.formatters.templating.make_template.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),(arguments[(1)]),argseq__40332__auto__);
});

devtools.formatters.templating.make_template.cljs$core$IFn$_invoke$arity$variadic = (function (tag,style,children){
var tag__$1 = devtools.formatters.helpers.pref.call(null,tag);
var style__$1 = devtools.formatters.helpers.pref.call(null,style);
var template = devtools.formatters.templating.mark_as_template_BANG_.call(null,[tag__$1,((cljs.core.empty_QMARK_.call(null,style__$1))?({}):({"style": style__$1}))]);
var seq__44047_44054 = cljs.core.seq.call(null,children);
var chunk__44048_44055 = null;
var count__44049_44056 = (0);
var i__44050_44057 = (0);
while(true){
if((i__44050_44057 < count__44049_44056)){
var child_44058 = cljs.core._nth.call(null,chunk__44048_44055,i__44050_44057);
if(!((child_44058 == null))){
if(cljs.core.coll_QMARK_.call(null,child_44058)){
(template["push"]).apply(template,devtools.formatters.templating.mark_as_template_BANG_.call(null,cljs.core.into_array.call(null,cljs.core.keep.call(null,devtools.formatters.helpers.pref,child_44058))));
} else {
var temp__4655__auto___44059 = devtools.formatters.helpers.pref.call(null,child_44058);
if(cljs.core.truth_(temp__4655__auto___44059)){
var child_value_44060 = temp__4655__auto___44059;
template.push(child_value_44060);
} else {
}
}
} else {
}

var G__44061 = seq__44047_44054;
var G__44062 = chunk__44048_44055;
var G__44063 = count__44049_44056;
var G__44064 = (i__44050_44057 + (1));
seq__44047_44054 = G__44061;
chunk__44048_44055 = G__44062;
count__44049_44056 = G__44063;
i__44050_44057 = G__44064;
continue;
} else {
var temp__4657__auto___44065 = cljs.core.seq.call(null,seq__44047_44054);
if(temp__4657__auto___44065){
var seq__44047_44066__$1 = temp__4657__auto___44065;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__44047_44066__$1)){
var c__39994__auto___44067 = cljs.core.chunk_first.call(null,seq__44047_44066__$1);
var G__44068 = cljs.core.chunk_rest.call(null,seq__44047_44066__$1);
var G__44069 = c__39994__auto___44067;
var G__44070 = cljs.core.count.call(null,c__39994__auto___44067);
var G__44071 = (0);
seq__44047_44054 = G__44068;
chunk__44048_44055 = G__44069;
count__44049_44056 = G__44070;
i__44050_44057 = G__44071;
continue;
} else {
var child_44072 = cljs.core.first.call(null,seq__44047_44066__$1);
if(!((child_44072 == null))){
if(cljs.core.coll_QMARK_.call(null,child_44072)){
(template["push"]).apply(template,devtools.formatters.templating.mark_as_template_BANG_.call(null,cljs.core.into_array.call(null,cljs.core.keep.call(null,devtools.formatters.helpers.pref,child_44072))));
} else {
var temp__4655__auto___44073 = devtools.formatters.helpers.pref.call(null,child_44072);
if(cljs.core.truth_(temp__4655__auto___44073)){
var child_value_44074 = temp__4655__auto___44073;
template.push(child_value_44074);
} else {
}
}
} else {
}

var G__44075 = cljs.core.next.call(null,seq__44047_44066__$1);
var G__44076 = null;
var G__44077 = (0);
var G__44078 = (0);
seq__44047_44054 = G__44075;
chunk__44048_44055 = G__44076;
count__44049_44056 = G__44077;
i__44050_44057 = G__44078;
continue;
}
} else {
}
}
break;
}

return template;
});

devtools.formatters.templating.make_template.cljs$lang$maxFixedArity = (2);

devtools.formatters.templating.make_template.cljs$lang$applyTo = (function (seq44044){
var G__44045 = cljs.core.first.call(null,seq44044);
var seq44044__$1 = cljs.core.next.call(null,seq44044);
var G__44046 = cljs.core.first.call(null,seq44044__$1);
var seq44044__$2 = cljs.core.next.call(null,seq44044__$1);
return devtools.formatters.templating.make_template.cljs$core$IFn$_invoke$arity$variadic(G__44045,G__44046,seq44044__$2);
});

devtools.formatters.templating.concat_templates_BANG_ = (function devtools$formatters$templating$concat_templates_BANG_(var_args){
var args__40331__auto__ = [];
var len__40324__auto___44081 = arguments.length;
var i__40325__auto___44082 = (0);
while(true){
if((i__40325__auto___44082 < len__40324__auto___44081)){
args__40331__auto__.push((arguments[i__40325__auto___44082]));

var G__44083 = (i__40325__auto___44082 + (1));
i__40325__auto___44082 = G__44083;
continue;
} else {
}
break;
}

var argseq__40332__auto__ = ((((1) < args__40331__auto__.length))?(new cljs.core.IndexedSeq(args__40331__auto__.slice((1)),(0),null)):null);
return devtools.formatters.templating.concat_templates_BANG_.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__40332__auto__);
});

devtools.formatters.templating.concat_templates_BANG_.cljs$core$IFn$_invoke$arity$variadic = (function (template,templates){
return devtools.formatters.templating.mark_as_template_BANG_.call(null,(template["concat"]).apply(template,cljs.core.into_array.call(null,cljs.core.map.call(null,cljs.core.into_array,cljs.core.keep.call(null,devtools.formatters.helpers.pref,templates)))));
});

devtools.formatters.templating.concat_templates_BANG_.cljs$lang$maxFixedArity = (1);

devtools.formatters.templating.concat_templates_BANG_.cljs$lang$applyTo = (function (seq44079){
var G__44080 = cljs.core.first.call(null,seq44079);
var seq44079__$1 = cljs.core.next.call(null,seq44079);
return devtools.formatters.templating.concat_templates_BANG_.cljs$core$IFn$_invoke$arity$variadic(G__44080,seq44079__$1);
});

devtools.formatters.templating.extend_template_BANG_ = (function devtools$formatters$templating$extend_template_BANG_(var_args){
var args__40331__auto__ = [];
var len__40324__auto___44086 = arguments.length;
var i__40325__auto___44087 = (0);
while(true){
if((i__40325__auto___44087 < len__40324__auto___44086)){
args__40331__auto__.push((arguments[i__40325__auto___44087]));

var G__44088 = (i__40325__auto___44087 + (1));
i__40325__auto___44087 = G__44088;
continue;
} else {
}
break;
}

var argseq__40332__auto__ = ((((1) < args__40331__auto__.length))?(new cljs.core.IndexedSeq(args__40331__auto__.slice((1)),(0),null)):null);
return devtools.formatters.templating.extend_template_BANG_.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__40332__auto__);
});

devtools.formatters.templating.extend_template_BANG_.cljs$core$IFn$_invoke$arity$variadic = (function (template,args){
return devtools.formatters.templating.concat_templates_BANG_.call(null,template,args);
});

devtools.formatters.templating.extend_template_BANG_.cljs$lang$maxFixedArity = (1);

devtools.formatters.templating.extend_template_BANG_.cljs$lang$applyTo = (function (seq44084){
var G__44085 = cljs.core.first.call(null,seq44084);
var seq44084__$1 = cljs.core.next.call(null,seq44084);
return devtools.formatters.templating.extend_template_BANG_.cljs$core$IFn$_invoke$arity$variadic(G__44085,seq44084__$1);
});

devtools.formatters.templating.make_surrogate = (function devtools$formatters$templating$make_surrogate(var_args){
var G__44090 = arguments.length;
switch (G__44090) {
case 1:
return devtools.formatters.templating.make_surrogate.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return devtools.formatters.templating.make_surrogate.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return devtools.formatters.templating.make_surrogate.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
case 4:
return devtools.formatters.templating.make_surrogate.cljs$core$IFn$_invoke$arity$4((arguments[(0)]),(arguments[(1)]),(arguments[(2)]),(arguments[(3)]));

break;
default:
throw (new Error([cljs.core.str.cljs$core$IFn$_invoke$arity$1("Invalid arity: "),cljs.core.str.cljs$core$IFn$_invoke$arity$1(arguments.length)].join('')));

}
});

devtools.formatters.templating.make_surrogate.cljs$core$IFn$_invoke$arity$1 = (function (object){
return devtools.formatters.templating.make_surrogate.call(null,object,null);
});

devtools.formatters.templating.make_surrogate.cljs$core$IFn$_invoke$arity$2 = (function (object,header){
return devtools.formatters.templating.make_surrogate.call(null,object,header,null);
});

devtools.formatters.templating.make_surrogate.cljs$core$IFn$_invoke$arity$3 = (function (object,header,body){
return devtools.formatters.templating.make_surrogate.call(null,object,header,body,(0));
});

devtools.formatters.templating.make_surrogate.cljs$core$IFn$_invoke$arity$4 = (function (object,header,body,start_index){
return devtools.formatters.templating.mark_as_surrogate_BANG_.call(null,(function (){var obj44092 = {"target":object,"header":header,"body":body,"startIndex":(function (){var or__39160__auto__ = start_index;
if(cljs.core.truth_(or__39160__auto__)){
return or__39160__auto__;
} else {
return (0);
}
})()};
return obj44092;
})());
});

devtools.formatters.templating.make_surrogate.cljs$lang$maxFixedArity = 4;

devtools.formatters.templating.get_surrogate_target = (function devtools$formatters$templating$get_surrogate_target(surrogate){
if(cljs.core.truth_(devtools.formatters.templating.surrogate_QMARK_.call(null,surrogate))){
} else {
throw (new Error("Assert failed: (surrogate? surrogate)"));
}

return (surrogate["target"]);
});
devtools.formatters.templating.get_surrogate_header = (function devtools$formatters$templating$get_surrogate_header(surrogate){
if(cljs.core.truth_(devtools.formatters.templating.surrogate_QMARK_.call(null,surrogate))){
} else {
throw (new Error("Assert failed: (surrogate? surrogate)"));
}

return (surrogate["header"]);
});
devtools.formatters.templating.get_surrogate_body = (function devtools$formatters$templating$get_surrogate_body(surrogate){
if(cljs.core.truth_(devtools.formatters.templating.surrogate_QMARK_.call(null,surrogate))){
} else {
throw (new Error("Assert failed: (surrogate? surrogate)"));
}

return (surrogate["body"]);
});
devtools.formatters.templating.get_surrogate_start_index = (function devtools$formatters$templating$get_surrogate_start_index(surrogate){
if(cljs.core.truth_(devtools.formatters.templating.surrogate_QMARK_.call(null,surrogate))){
} else {
throw (new Error("Assert failed: (surrogate? surrogate)"));
}

return (surrogate["startIndex"]);
});
devtools.formatters.templating.make_reference = (function devtools$formatters$templating$make_reference(var_args){
var args__40331__auto__ = [];
var len__40324__auto___44100 = arguments.length;
var i__40325__auto___44101 = (0);
while(true){
if((i__40325__auto___44101 < len__40324__auto___44100)){
args__40331__auto__.push((arguments[i__40325__auto___44101]));

var G__44102 = (i__40325__auto___44101 + (1));
i__40325__auto___44101 = G__44102;
continue;
} else {
}
break;
}

var argseq__40332__auto__ = ((((1) < args__40331__auto__.length))?(new cljs.core.IndexedSeq(args__40331__auto__.slice((1)),(0),null)):null);
return devtools.formatters.templating.make_reference.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__40332__auto__);
});

devtools.formatters.templating.make_reference.cljs$core$IFn$_invoke$arity$variadic = (function (object,p__44096){
var vec__44097 = p__44096;
var state_override_fn = cljs.core.nth.call(null,vec__44097,(0),null);
if(((state_override_fn == null)) || (cljs.core.fn_QMARK_.call(null,state_override_fn))){
} else {
throw (new Error("Assert failed: (or (nil? state-override-fn) (fn? state-override-fn))"));
}

if((object == null)){
return devtools.formatters.templating.make_template.call(null,new cljs.core.Keyword(null,"span","span",1394872991),new cljs.core.Keyword(null,"nil-style","nil-style",-1505044832),new cljs.core.Keyword(null,"nil-label","nil-label",-587789203));
} else {
var sub_state = ((!((state_override_fn == null)))?state_override_fn.call(null,devtools.formatters.state.get_current_state.call(null)):devtools.formatters.state.get_current_state.call(null));
return devtools.formatters.templating.make_group.call(null,"object",({"object": object, "config": sub_state}));
}
});

devtools.formatters.templating.make_reference.cljs$lang$maxFixedArity = (1);

devtools.formatters.templating.make_reference.cljs$lang$applyTo = (function (seq44094){
var G__44095 = cljs.core.first.call(null,seq44094);
var seq44094__$1 = cljs.core.next.call(null,seq44094);
return devtools.formatters.templating.make_reference.cljs$core$IFn$_invoke$arity$variadic(G__44095,seq44094__$1);
});

devtools.formatters.templating._STAR_current_render_stack_STAR_ = cljs.core.PersistentVector.EMPTY;
devtools.formatters.templating._STAR_current_render_path_STAR_ = cljs.core.PersistentVector.EMPTY;
devtools.formatters.templating.print_preview = (function devtools$formatters$templating$print_preview(markup){
var _STAR_print_level_STAR_44103 = cljs.core._STAR_print_level_STAR_;
cljs.core._STAR_print_level_STAR_ = (1);

try{return cljs.core.pr_str.call(null,markup);
}finally {cljs.core._STAR_print_level_STAR_ = _STAR_print_level_STAR_44103;
}});
devtools.formatters.templating.add_stack_separators = (function devtools$formatters$templating$add_stack_separators(stack){
return cljs.core.interpose.call(null,"-------------",stack);
});
devtools.formatters.templating.replace_fns_with_markers = (function devtools$formatters$templating$replace_fns_with_markers(stack){
var f = (function (v){
if(cljs.core.fn_QMARK_.call(null,v)){
return "##fn##";
} else {
return v;
}
});
return clojure.walk.prewalk.call(null,f,stack);
});
devtools.formatters.templating.pprint_render_calls = (function devtools$formatters$templating$pprint_render_calls(stack){
return cljs.core.map.call(null,devtools.util.pprint_str,stack);
});
devtools.formatters.templating.pprint_render_stack = (function devtools$formatters$templating$pprint_render_stack(stack){
return clojure.string.join.call(null,"\n",devtools.formatters.templating.add_stack_separators.call(null,devtools.formatters.templating.pprint_render_calls.call(null,devtools.formatters.templating.replace_fns_with_markers.call(null,cljs.core.reverse.call(null,stack)))));
});
devtools.formatters.templating.pprint_render_path = (function devtools$formatters$templating$pprint_render_path(path){
return devtools.util.pprint_str.call(null,path);
});
devtools.formatters.templating.assert_markup_error = (function devtools$formatters$templating$assert_markup_error(msg){
throw (new Error([cljs.core.str.cljs$core$IFn$_invoke$arity$1("Assert failed: "),cljs.core.str.cljs$core$IFn$_invoke$arity$1([cljs.core.str.cljs$core$IFn$_invoke$arity$1(msg),cljs.core.str.cljs$core$IFn$_invoke$arity$1("\n"),cljs.core.str.cljs$core$IFn$_invoke$arity$1("Render path: "),cljs.core.str.cljs$core$IFn$_invoke$arity$1(devtools.formatters.templating.pprint_render_path.call(null,devtools.formatters.templating._STAR_current_render_path_STAR_)),cljs.core.str.cljs$core$IFn$_invoke$arity$1("\n"),cljs.core.str.cljs$core$IFn$_invoke$arity$1("Render stack:\n"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(devtools.formatters.templating.pprint_render_stack.call(null,devtools.formatters.templating._STAR_current_render_stack_STAR_))].join('')),cljs.core.str.cljs$core$IFn$_invoke$arity$1("\n"),cljs.core.str.cljs$core$IFn$_invoke$arity$1("false")].join('')));

});
devtools.formatters.templating.surrogate_markup_QMARK_ = (function devtools$formatters$templating$surrogate_markup_QMARK_(markup){
return (cljs.core.sequential_QMARK_.call(null,markup)) && (cljs.core._EQ_.call(null,cljs.core.first.call(null,markup),"surrogate"));
});
devtools.formatters.templating.render_special = (function devtools$formatters$templating$render_special(name,args){
var G__44104 = name;
switch (G__44104) {
case "surrogate":
var obj = cljs.core.first.call(null,args);
var converted_args = cljs.core.map.call(null,devtools.formatters.templating.render_json_ml_STAR_,cljs.core.rest.call(null,args));
return cljs.core.apply.call(null,devtools.formatters.templating.make_surrogate,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [obj], null),converted_args));

break;
case "reference":
var obj = cljs.core.first.call(null,args);
var converted_obj = (cljs.core.truth_(devtools.formatters.templating.surrogate_markup_QMARK_.call(null,obj))?devtools.formatters.templating.render_json_ml_STAR_.call(null,obj):obj);
return cljs.core.apply.call(null,devtools.formatters.templating.make_reference,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [converted_obj], null),cljs.core.rest.call(null,args)));

break;
default:
return devtools.formatters.templating.assert_markup_error.call(null,[cljs.core.str.cljs$core$IFn$_invoke$arity$1("no matching special tag name: '"),cljs.core.str.cljs$core$IFn$_invoke$arity$1(name),cljs.core.str.cljs$core$IFn$_invoke$arity$1("'")].join(''));

}
});
devtools.formatters.templating.emptyish_QMARK_ = (function devtools$formatters$templating$emptyish_QMARK_(v){
if((cljs.core.seqable_QMARK_.call(null,v)) || (cljs.core.array_QMARK_.call(null,v)) || (typeof v === 'string')){
return cljs.core.empty_QMARK_.call(null,v);
} else {
return false;
}
});
devtools.formatters.templating.render_subtree = (function devtools$formatters$templating$render_subtree(tag,children){
var vec__44106 = tag;
var html_tag = cljs.core.nth.call(null,vec__44106,(0),null);
var style = cljs.core.nth.call(null,vec__44106,(1),null);
return cljs.core.apply.call(null,devtools.formatters.templating.make_template,html_tag,style,cljs.core.map.call(null,devtools.formatters.templating.render_json_ml_STAR_,cljs.core.remove.call(null,devtools.formatters.templating.emptyish_QMARK_,cljs.core.map.call(null,devtools.formatters.helpers.pref,children))));
});
devtools.formatters.templating.render_json_ml_STAR_ = (function devtools$formatters$templating$render_json_ml_STAR_(markup){
if(!(cljs.core.sequential_QMARK_.call(null,markup))){
return markup;
} else {
var _STAR_current_render_path_STAR_44109 = devtools.formatters.templating._STAR_current_render_path_STAR_;
devtools.formatters.templating._STAR_current_render_path_STAR_ = cljs.core.conj.call(null,devtools.formatters.templating._STAR_current_render_path_STAR_,cljs.core.first.call(null,markup));

try{var tag = devtools.formatters.helpers.pref.call(null,cljs.core.first.call(null,markup));
if(typeof tag === 'string'){
return devtools.formatters.templating.render_special.call(null,tag,cljs.core.rest.call(null,markup));
} else {
if(cljs.core.sequential_QMARK_.call(null,tag)){
return devtools.formatters.templating.render_subtree.call(null,tag,cljs.core.rest.call(null,markup));
} else {
return devtools.formatters.templating.assert_markup_error.call(null,[cljs.core.str.cljs$core$IFn$_invoke$arity$1("invalid json-ml markup at "),cljs.core.str.cljs$core$IFn$_invoke$arity$1(devtools.formatters.templating.print_preview.call(null,markup)),cljs.core.str.cljs$core$IFn$_invoke$arity$1(":")].join(''));

}
}
}finally {devtools.formatters.templating._STAR_current_render_path_STAR_ = _STAR_current_render_path_STAR_44109;
}}
});
devtools.formatters.templating.render_json_ml = (function devtools$formatters$templating$render_json_ml(markup){
var _STAR_current_render_stack_STAR_44110 = devtools.formatters.templating._STAR_current_render_stack_STAR_;
var _STAR_current_render_path_STAR_44111 = devtools.formatters.templating._STAR_current_render_path_STAR_;
devtools.formatters.templating._STAR_current_render_stack_STAR_ = cljs.core.conj.call(null,devtools.formatters.templating._STAR_current_render_stack_STAR_,markup);

devtools.formatters.templating._STAR_current_render_path_STAR_ = cljs.core.conj.call(null,devtools.formatters.templating._STAR_current_render_path_STAR_,"<render-json-ml>");

try{return devtools.formatters.templating.render_json_ml_STAR_.call(null,markup);
}finally {devtools.formatters.templating._STAR_current_render_path_STAR_ = _STAR_current_render_path_STAR_44111;

devtools.formatters.templating._STAR_current_render_stack_STAR_ = _STAR_current_render_stack_STAR_44110;
}});
devtools.formatters.templating.assert_failed_markup_rendering = (function devtools$formatters$templating$assert_failed_markup_rendering(initial_value,value){
throw (new Error([cljs.core.str.cljs$core$IFn$_invoke$arity$1("Assert failed: "),cljs.core.str.cljs$core$IFn$_invoke$arity$1([cljs.core.str.cljs$core$IFn$_invoke$arity$1("result of markup rendering must be a template,\n"),cljs.core.str.cljs$core$IFn$_invoke$arity$1("resolved to "),cljs.core.str.cljs$core$IFn$_invoke$arity$1(devtools.util.pprint_str.call(null,value)),cljs.core.str.cljs$core$IFn$_invoke$arity$1("initial value: "),cljs.core.str.cljs$core$IFn$_invoke$arity$1(devtools.util.pprint_str.call(null,initial_value))].join('')),cljs.core.str.cljs$core$IFn$_invoke$arity$1("\n"),cljs.core.str.cljs$core$IFn$_invoke$arity$1("false")].join('')));

});
devtools.formatters.templating.render_markup_STAR_ = (function devtools$formatters$templating$render_markup_STAR_(initial_value,value){
while(true){
if(cljs.core.fn_QMARK_.call(null,value)){
var G__44112 = initial_value;
var G__44113 = value.call(null);
initial_value = G__44112;
value = G__44113;
continue;
} else {
if((value instanceof cljs.core.Keyword)){
var G__44114 = initial_value;
var G__44115 = devtools.formatters.helpers.pref.call(null,value);
initial_value = G__44114;
value = G__44115;
continue;
} else {
if(cljs.core.sequential_QMARK_.call(null,value)){
var G__44116 = initial_value;
var G__44117 = devtools.formatters.templating.render_json_ml.call(null,value);
initial_value = G__44116;
value = G__44117;
continue;
} else {
if(cljs.core.truth_(devtools.formatters.templating.template_QMARK_.call(null,value))){
return value;
} else {
if(cljs.core.truth_(devtools.formatters.templating.surrogate_QMARK_.call(null,value))){
return value;
} else {
if(cljs.core.truth_(devtools.formatters.templating.reference_QMARK_.call(null,value))){
return value;
} else {
return devtools.formatters.templating.assert_failed_markup_rendering.call(null,initial_value,value);

}
}
}
}
}
}
break;
}
});
devtools.formatters.templating.render_markup = (function devtools$formatters$templating$render_markup(value){
return devtools.formatters.templating.render_markup_STAR_.call(null,value,value);
});

//# sourceMappingURL=templating.js.map
