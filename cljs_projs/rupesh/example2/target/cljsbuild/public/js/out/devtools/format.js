// Compiled by ClojureScript 1.9.854 {}
goog.provide('devtools.format');
goog.require('cljs.core');
goog.require('devtools.context');

/**
 * @interface
 */
devtools.format.IDevtoolsFormat = function(){};

devtools.format._header = (function devtools$format$_header(value){
if((!((value == null))) && (!((value.devtools$format$IDevtoolsFormat$_header$arity$1 == null)))){
return value.devtools$format$IDevtoolsFormat$_header$arity$1(value);
} else {
var x__39843__auto__ = (((value == null))?null:value);
var m__39844__auto__ = (devtools.format._header[goog.typeOf(x__39843__auto__)]);
if(!((m__39844__auto__ == null))){
return m__39844__auto__.call(null,value);
} else {
var m__39844__auto____$1 = (devtools.format._header["_"]);
if(!((m__39844__auto____$1 == null))){
return m__39844__auto____$1.call(null,value);
} else {
throw cljs.core.missing_protocol.call(null,"IDevtoolsFormat.-header",value);
}
}
}
});

devtools.format._has_body = (function devtools$format$_has_body(value){
if((!((value == null))) && (!((value.devtools$format$IDevtoolsFormat$_has_body$arity$1 == null)))){
return value.devtools$format$IDevtoolsFormat$_has_body$arity$1(value);
} else {
var x__39843__auto__ = (((value == null))?null:value);
var m__39844__auto__ = (devtools.format._has_body[goog.typeOf(x__39843__auto__)]);
if(!((m__39844__auto__ == null))){
return m__39844__auto__.call(null,value);
} else {
var m__39844__auto____$1 = (devtools.format._has_body["_"]);
if(!((m__39844__auto____$1 == null))){
return m__39844__auto____$1.call(null,value);
} else {
throw cljs.core.missing_protocol.call(null,"IDevtoolsFormat.-has-body",value);
}
}
}
});

devtools.format._body = (function devtools$format$_body(value){
if((!((value == null))) && (!((value.devtools$format$IDevtoolsFormat$_body$arity$1 == null)))){
return value.devtools$format$IDevtoolsFormat$_body$arity$1(value);
} else {
var x__39843__auto__ = (((value == null))?null:value);
var m__39844__auto__ = (devtools.format._body[goog.typeOf(x__39843__auto__)]);
if(!((m__39844__auto__ == null))){
return m__39844__auto__.call(null,value);
} else {
var m__39844__auto____$1 = (devtools.format._body["_"]);
if(!((m__39844__auto____$1 == null))){
return m__39844__auto____$1.call(null,value);
} else {
throw cljs.core.missing_protocol.call(null,"IDevtoolsFormat.-body",value);
}
}
}
});

devtools.format.setup_BANG_ = (function devtools$format$setup_BANG_(){
if(cljs.core.truth_(devtools.format._STAR_setup_done_STAR_)){
return null;
} else {
devtools.format._STAR_setup_done_STAR_ = true;

devtools.format.make_template_fn = (function (){var temp__4655__auto__ = (devtools.context.get_root.call(null)["devtools"]);
if(cljs.core.truth_(temp__4655__auto__)){
var o41759 = temp__4655__auto__;
var temp__4655__auto____$1 = (o41759["formatters"]);
if(cljs.core.truth_(temp__4655__auto____$1)){
var o41760 = temp__4655__auto____$1;
var temp__4655__auto____$2 = (o41760["templating"]);
if(cljs.core.truth_(temp__4655__auto____$2)){
var o41761 = temp__4655__auto____$2;
return (o41761["make_template"]);
} else {
return null;
}
} else {
return null;
}
} else {
return null;
}
})();

devtools.format.make_group_fn = (function (){var temp__4655__auto__ = (devtools.context.get_root.call(null)["devtools"]);
if(cljs.core.truth_(temp__4655__auto__)){
var o41762 = temp__4655__auto__;
var temp__4655__auto____$1 = (o41762["formatters"]);
if(cljs.core.truth_(temp__4655__auto____$1)){
var o41763 = temp__4655__auto____$1;
var temp__4655__auto____$2 = (o41763["templating"]);
if(cljs.core.truth_(temp__4655__auto____$2)){
var o41764 = temp__4655__auto____$2;
return (o41764["make_group"]);
} else {
return null;
}
} else {
return null;
}
} else {
return null;
}
})();

devtools.format.make_reference_fn = (function (){var temp__4655__auto__ = (devtools.context.get_root.call(null)["devtools"]);
if(cljs.core.truth_(temp__4655__auto__)){
var o41765 = temp__4655__auto__;
var temp__4655__auto____$1 = (o41765["formatters"]);
if(cljs.core.truth_(temp__4655__auto____$1)){
var o41766 = temp__4655__auto____$1;
var temp__4655__auto____$2 = (o41766["templating"]);
if(cljs.core.truth_(temp__4655__auto____$2)){
var o41767 = temp__4655__auto____$2;
return (o41767["make_reference"]);
} else {
return null;
}
} else {
return null;
}
} else {
return null;
}
})();

devtools.format.make_surrogate_fn = (function (){var temp__4655__auto__ = (devtools.context.get_root.call(null)["devtools"]);
if(cljs.core.truth_(temp__4655__auto__)){
var o41768 = temp__4655__auto__;
var temp__4655__auto____$1 = (o41768["formatters"]);
if(cljs.core.truth_(temp__4655__auto____$1)){
var o41769 = temp__4655__auto____$1;
var temp__4655__auto____$2 = (o41769["templating"]);
if(cljs.core.truth_(temp__4655__auto____$2)){
var o41770 = temp__4655__auto____$2;
return (o41770["make_surrogate"]);
} else {
return null;
}
} else {
return null;
}
} else {
return null;
}
})();

devtools.format.render_markup_fn = (function (){var temp__4655__auto__ = (devtools.context.get_root.call(null)["devtools"]);
if(cljs.core.truth_(temp__4655__auto__)){
var o41771 = temp__4655__auto__;
var temp__4655__auto____$1 = (o41771["formatters"]);
if(cljs.core.truth_(temp__4655__auto____$1)){
var o41772 = temp__4655__auto____$1;
var temp__4655__auto____$2 = (o41772["templating"]);
if(cljs.core.truth_(temp__4655__auto____$2)){
var o41773 = temp__4655__auto____$2;
return (o41773["render_markup"]);
} else {
return null;
}
} else {
return null;
}
} else {
return null;
}
})();

devtools.format._LT_header_GT__fn = (function (){var temp__4655__auto__ = (devtools.context.get_root.call(null)["devtools"]);
if(cljs.core.truth_(temp__4655__auto__)){
var o41774 = temp__4655__auto__;
var temp__4655__auto____$1 = (o41774["formatters"]);
if(cljs.core.truth_(temp__4655__auto____$1)){
var o41775 = temp__4655__auto____$1;
var temp__4655__auto____$2 = (o41775["markup"]);
if(cljs.core.truth_(temp__4655__auto____$2)){
var o41776 = temp__4655__auto____$2;
return (o41776["_LT_header_GT_"]);
} else {
return null;
}
} else {
return null;
}
} else {
return null;
}
})();

devtools.format._LT_standard_body_GT__fn = (function (){var temp__4655__auto__ = (devtools.context.get_root.call(null)["devtools"]);
if(cljs.core.truth_(temp__4655__auto__)){
var o41777 = temp__4655__auto__;
var temp__4655__auto____$1 = (o41777["formatters"]);
if(cljs.core.truth_(temp__4655__auto____$1)){
var o41778 = temp__4655__auto____$1;
var temp__4655__auto____$2 = (o41778["markup"]);
if(cljs.core.truth_(temp__4655__auto____$2)){
var o41779 = temp__4655__auto____$2;
return (o41779["_LT_standard_body_GT_"]);
} else {
return null;
}
} else {
return null;
}
} else {
return null;
}
})();

if(cljs.core.truth_(devtools.format.make_template_fn)){
} else {
throw (new Error("Assert failed: make-template-fn"));
}

if(cljs.core.truth_(devtools.format.make_group_fn)){
} else {
throw (new Error("Assert failed: make-group-fn"));
}

if(cljs.core.truth_(devtools.format.make_reference_fn)){
} else {
throw (new Error("Assert failed: make-reference-fn"));
}

if(cljs.core.truth_(devtools.format.make_surrogate_fn)){
} else {
throw (new Error("Assert failed: make-surrogate-fn"));
}

if(cljs.core.truth_(devtools.format.render_markup_fn)){
} else {
throw (new Error("Assert failed: render-markup-fn"));
}

if(cljs.core.truth_(devtools.format._LT_header_GT__fn)){
} else {
throw (new Error("Assert failed: <header>-fn"));
}

if(cljs.core.truth_(devtools.format._LT_standard_body_GT__fn)){
return null;
} else {
throw (new Error("Assert failed: <standard-body>-fn"));
}
}
});
devtools.format.render_markup = (function devtools$format$render_markup(var_args){
var args__40331__auto__ = [];
var len__40324__auto___41781 = arguments.length;
var i__40325__auto___41782 = (0);
while(true){
if((i__40325__auto___41782 < len__40324__auto___41781)){
args__40331__auto__.push((arguments[i__40325__auto___41782]));

var G__41783 = (i__40325__auto___41782 + (1));
i__40325__auto___41782 = G__41783;
continue;
} else {
}
break;
}

var argseq__40332__auto__ = ((((0) < args__40331__auto__.length))?(new cljs.core.IndexedSeq(args__40331__auto__.slice((0)),(0),null)):null);
return devtools.format.render_markup.cljs$core$IFn$_invoke$arity$variadic(argseq__40332__auto__);
});

devtools.format.render_markup.cljs$core$IFn$_invoke$arity$variadic = (function (args){
devtools.format.setup_BANG_.call(null);

return cljs.core.apply.call(null,devtools.format.render_markup_fn,args);
});

devtools.format.render_markup.cljs$lang$maxFixedArity = (0);

devtools.format.render_markup.cljs$lang$applyTo = (function (seq41780){
return devtools.format.render_markup.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq.call(null,seq41780));
});

devtools.format.make_template = (function devtools$format$make_template(var_args){
var args__40331__auto__ = [];
var len__40324__auto___41785 = arguments.length;
var i__40325__auto___41786 = (0);
while(true){
if((i__40325__auto___41786 < len__40324__auto___41785)){
args__40331__auto__.push((arguments[i__40325__auto___41786]));

var G__41787 = (i__40325__auto___41786 + (1));
i__40325__auto___41786 = G__41787;
continue;
} else {
}
break;
}

var argseq__40332__auto__ = ((((0) < args__40331__auto__.length))?(new cljs.core.IndexedSeq(args__40331__auto__.slice((0)),(0),null)):null);
return devtools.format.make_template.cljs$core$IFn$_invoke$arity$variadic(argseq__40332__auto__);
});

devtools.format.make_template.cljs$core$IFn$_invoke$arity$variadic = (function (args){
devtools.format.setup_BANG_.call(null);

return cljs.core.apply.call(null,devtools.format.make_template_fn,args);
});

devtools.format.make_template.cljs$lang$maxFixedArity = (0);

devtools.format.make_template.cljs$lang$applyTo = (function (seq41784){
return devtools.format.make_template.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq.call(null,seq41784));
});

devtools.format.make_group = (function devtools$format$make_group(var_args){
var args__40331__auto__ = [];
var len__40324__auto___41789 = arguments.length;
var i__40325__auto___41790 = (0);
while(true){
if((i__40325__auto___41790 < len__40324__auto___41789)){
args__40331__auto__.push((arguments[i__40325__auto___41790]));

var G__41791 = (i__40325__auto___41790 + (1));
i__40325__auto___41790 = G__41791;
continue;
} else {
}
break;
}

var argseq__40332__auto__ = ((((0) < args__40331__auto__.length))?(new cljs.core.IndexedSeq(args__40331__auto__.slice((0)),(0),null)):null);
return devtools.format.make_group.cljs$core$IFn$_invoke$arity$variadic(argseq__40332__auto__);
});

devtools.format.make_group.cljs$core$IFn$_invoke$arity$variadic = (function (args){
devtools.format.setup_BANG_.call(null);

return cljs.core.apply.call(null,devtools.format.make_group_fn,args);
});

devtools.format.make_group.cljs$lang$maxFixedArity = (0);

devtools.format.make_group.cljs$lang$applyTo = (function (seq41788){
return devtools.format.make_group.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq.call(null,seq41788));
});

devtools.format.make_surrogate = (function devtools$format$make_surrogate(var_args){
var args__40331__auto__ = [];
var len__40324__auto___41793 = arguments.length;
var i__40325__auto___41794 = (0);
while(true){
if((i__40325__auto___41794 < len__40324__auto___41793)){
args__40331__auto__.push((arguments[i__40325__auto___41794]));

var G__41795 = (i__40325__auto___41794 + (1));
i__40325__auto___41794 = G__41795;
continue;
} else {
}
break;
}

var argseq__40332__auto__ = ((((0) < args__40331__auto__.length))?(new cljs.core.IndexedSeq(args__40331__auto__.slice((0)),(0),null)):null);
return devtools.format.make_surrogate.cljs$core$IFn$_invoke$arity$variadic(argseq__40332__auto__);
});

devtools.format.make_surrogate.cljs$core$IFn$_invoke$arity$variadic = (function (args){
devtools.format.setup_BANG_.call(null);

return cljs.core.apply.call(null,devtools.format.make_surrogate_fn,args);
});

devtools.format.make_surrogate.cljs$lang$maxFixedArity = (0);

devtools.format.make_surrogate.cljs$lang$applyTo = (function (seq41792){
return devtools.format.make_surrogate.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq.call(null,seq41792));
});

devtools.format.template = (function devtools$format$template(var_args){
var args__40331__auto__ = [];
var len__40324__auto___41797 = arguments.length;
var i__40325__auto___41798 = (0);
while(true){
if((i__40325__auto___41798 < len__40324__auto___41797)){
args__40331__auto__.push((arguments[i__40325__auto___41798]));

var G__41799 = (i__40325__auto___41798 + (1));
i__40325__auto___41798 = G__41799;
continue;
} else {
}
break;
}

var argseq__40332__auto__ = ((((0) < args__40331__auto__.length))?(new cljs.core.IndexedSeq(args__40331__auto__.slice((0)),(0),null)):null);
return devtools.format.template.cljs$core$IFn$_invoke$arity$variadic(argseq__40332__auto__);
});

devtools.format.template.cljs$core$IFn$_invoke$arity$variadic = (function (args){
devtools.format.setup_BANG_.call(null);

return cljs.core.apply.call(null,devtools.format.make_template_fn,args);
});

devtools.format.template.cljs$lang$maxFixedArity = (0);

devtools.format.template.cljs$lang$applyTo = (function (seq41796){
return devtools.format.template.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq.call(null,seq41796));
});

devtools.format.group = (function devtools$format$group(var_args){
var args__40331__auto__ = [];
var len__40324__auto___41801 = arguments.length;
var i__40325__auto___41802 = (0);
while(true){
if((i__40325__auto___41802 < len__40324__auto___41801)){
args__40331__auto__.push((arguments[i__40325__auto___41802]));

var G__41803 = (i__40325__auto___41802 + (1));
i__40325__auto___41802 = G__41803;
continue;
} else {
}
break;
}

var argseq__40332__auto__ = ((((0) < args__40331__auto__.length))?(new cljs.core.IndexedSeq(args__40331__auto__.slice((0)),(0),null)):null);
return devtools.format.group.cljs$core$IFn$_invoke$arity$variadic(argseq__40332__auto__);
});

devtools.format.group.cljs$core$IFn$_invoke$arity$variadic = (function (args){
devtools.format.setup_BANG_.call(null);

return cljs.core.apply.call(null,devtools.format.make_group_fn,args);
});

devtools.format.group.cljs$lang$maxFixedArity = (0);

devtools.format.group.cljs$lang$applyTo = (function (seq41800){
return devtools.format.group.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq.call(null,seq41800));
});

devtools.format.surrogate = (function devtools$format$surrogate(var_args){
var args__40331__auto__ = [];
var len__40324__auto___41805 = arguments.length;
var i__40325__auto___41806 = (0);
while(true){
if((i__40325__auto___41806 < len__40324__auto___41805)){
args__40331__auto__.push((arguments[i__40325__auto___41806]));

var G__41807 = (i__40325__auto___41806 + (1));
i__40325__auto___41806 = G__41807;
continue;
} else {
}
break;
}

var argseq__40332__auto__ = ((((0) < args__40331__auto__.length))?(new cljs.core.IndexedSeq(args__40331__auto__.slice((0)),(0),null)):null);
return devtools.format.surrogate.cljs$core$IFn$_invoke$arity$variadic(argseq__40332__auto__);
});

devtools.format.surrogate.cljs$core$IFn$_invoke$arity$variadic = (function (args){
devtools.format.setup_BANG_.call(null);

return cljs.core.apply.call(null,devtools.format.make_surrogate_fn,args);
});

devtools.format.surrogate.cljs$lang$maxFixedArity = (0);

devtools.format.surrogate.cljs$lang$applyTo = (function (seq41804){
return devtools.format.surrogate.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq.call(null,seq41804));
});

devtools.format.reference = (function devtools$format$reference(var_args){
var args__40331__auto__ = [];
var len__40324__auto___41815 = arguments.length;
var i__40325__auto___41816 = (0);
while(true){
if((i__40325__auto___41816 < len__40324__auto___41815)){
args__40331__auto__.push((arguments[i__40325__auto___41816]));

var G__41817 = (i__40325__auto___41816 + (1));
i__40325__auto___41816 = G__41817;
continue;
} else {
}
break;
}

var argseq__40332__auto__ = ((((1) < args__40331__auto__.length))?(new cljs.core.IndexedSeq(args__40331__auto__.slice((1)),(0),null)):null);
return devtools.format.reference.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__40332__auto__);
});

devtools.format.reference.cljs$core$IFn$_invoke$arity$variadic = (function (object,p__41811){
var vec__41812 = p__41811;
var state_override = cljs.core.nth.call(null,vec__41812,(0),null);
devtools.format.setup_BANG_.call(null);

return cljs.core.apply.call(null,devtools.format.make_reference_fn,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [object,((function (vec__41812,state_override){
return (function (p1__41808_SHARP_){
return cljs.core.merge.call(null,p1__41808_SHARP_,state_override);
});})(vec__41812,state_override))
], null));
});

devtools.format.reference.cljs$lang$maxFixedArity = (1);

devtools.format.reference.cljs$lang$applyTo = (function (seq41809){
var G__41810 = cljs.core.first.call(null,seq41809);
var seq41809__$1 = cljs.core.next.call(null,seq41809);
return devtools.format.reference.cljs$core$IFn$_invoke$arity$variadic(G__41810,seq41809__$1);
});

devtools.format.standard_reference = (function devtools$format$standard_reference(target){
devtools.format.setup_BANG_.call(null);

return devtools.format.make_template_fn.call(null,new cljs.core.Keyword(null,"ol","ol",932524051),new cljs.core.Keyword(null,"standard-ol-style","standard-ol-style",2143825615),devtools.format.make_template_fn.call(null,new cljs.core.Keyword(null,"li","li",723558921),new cljs.core.Keyword(null,"standard-li-style","standard-li-style",413442955),devtools.format.make_reference_fn.call(null,target)));
});
devtools.format.build_header = (function devtools$format$build_header(var_args){
var args__40331__auto__ = [];
var len__40324__auto___41819 = arguments.length;
var i__40325__auto___41820 = (0);
while(true){
if((i__40325__auto___41820 < len__40324__auto___41819)){
args__40331__auto__.push((arguments[i__40325__auto___41820]));

var G__41821 = (i__40325__auto___41820 + (1));
i__40325__auto___41820 = G__41821;
continue;
} else {
}
break;
}

var argseq__40332__auto__ = ((((0) < args__40331__auto__.length))?(new cljs.core.IndexedSeq(args__40331__auto__.slice((0)),(0),null)):null);
return devtools.format.build_header.cljs$core$IFn$_invoke$arity$variadic(argseq__40332__auto__);
});

devtools.format.build_header.cljs$core$IFn$_invoke$arity$variadic = (function (args){
devtools.format.setup_BANG_.call(null);

return devtools.format.render_markup.call(null,cljs.core.apply.call(null,devtools.format._LT_header_GT__fn,args));
});

devtools.format.build_header.cljs$lang$maxFixedArity = (0);

devtools.format.build_header.cljs$lang$applyTo = (function (seq41818){
return devtools.format.build_header.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq.call(null,seq41818));
});

devtools.format.standard_body_template = (function devtools$format$standard_body_template(var_args){
var args__40331__auto__ = [];
var len__40324__auto___41824 = arguments.length;
var i__40325__auto___41825 = (0);
while(true){
if((i__40325__auto___41825 < len__40324__auto___41824)){
args__40331__auto__.push((arguments[i__40325__auto___41825]));

var G__41826 = (i__40325__auto___41825 + (1));
i__40325__auto___41825 = G__41826;
continue;
} else {
}
break;
}

var argseq__40332__auto__ = ((((1) < args__40331__auto__.length))?(new cljs.core.IndexedSeq(args__40331__auto__.slice((1)),(0),null)):null);
return devtools.format.standard_body_template.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__40332__auto__);
});

devtools.format.standard_body_template.cljs$core$IFn$_invoke$arity$variadic = (function (lines,rest){
devtools.format.setup_BANG_.call(null);

var args = cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.map.call(null,(function (x){
return new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [x], null);
}),lines)], null),rest);
return devtools.format.render_markup.call(null,cljs.core.apply.call(null,devtools.format._LT_standard_body_GT__fn,args));
});

devtools.format.standard_body_template.cljs$lang$maxFixedArity = (1);

devtools.format.standard_body_template.cljs$lang$applyTo = (function (seq41822){
var G__41823 = cljs.core.first.call(null,seq41822);
var seq41822__$1 = cljs.core.next.call(null,seq41822);
return devtools.format.standard_body_template.cljs$core$IFn$_invoke$arity$variadic(G__41823,seq41822__$1);
});


//# sourceMappingURL=format.js.map
