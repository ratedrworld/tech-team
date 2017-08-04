// Compiled by ClojureScript 1.9.854 {}
goog.provide('example2.ajax');
goog.require('cljs.core');
goog.require('ajax.core');
example2.ajax.local_uri_QMARK_ = (function example2$ajax$local_uri_QMARK_(p__45965){
var map__45966 = p__45965;
var map__45966__$1 = ((((!((map__45966 == null)))?((((map__45966.cljs$lang$protocol_mask$partition0$ & (64))) || ((cljs.core.PROTOCOL_SENTINEL === map__45966.cljs$core$ISeq$)))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__45966):map__45966);
var uri = cljs.core.get.call(null,map__45966__$1,new cljs.core.Keyword(null,"uri","uri",-774711847));
return cljs.core.not.call(null,cljs.core.re_find.call(null,/^\w+?:\/\//,uri));
});
example2.ajax.default_headers = (function example2$ajax$default_headers(request){
if(cljs.core.truth_(example2.ajax.local_uri_QMARK_.call(null,request))){
return cljs.core.update.call(null,cljs.core.update.call(null,request,new cljs.core.Keyword(null,"uri","uri",-774711847),(function (p1__45968_SHARP_){
return [cljs.core.str.cljs$core$IFn$_invoke$arity$1(context),cljs.core.str.cljs$core$IFn$_invoke$arity$1(p1__45968_SHARP_)].join('');
})),new cljs.core.Keyword(null,"headers","headers",-835030129),(function (p1__45969_SHARP_){
return cljs.core.merge.call(null,new cljs.core.PersistentArrayMap(null, 1, ["x-csrf-token",csrfToken], null),p1__45969_SHARP_);
}));
} else {
return request;
}
});
example2.ajax.load_interceptors_BANG_ = (function example2$ajax$load_interceptors_BANG_(){
return cljs.core.swap_BANG_.call(null,ajax.core.default_interceptors,cljs.core.conj,ajax.core.to_interceptor.call(null,new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"name","name",1843675177),"default headers",new cljs.core.Keyword(null,"request","request",1772954723),example2.ajax.default_headers], null)));
});

//# sourceMappingURL=ajax.js.map
