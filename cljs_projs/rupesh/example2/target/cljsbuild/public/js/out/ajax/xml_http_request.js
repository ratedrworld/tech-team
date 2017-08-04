// Compiled by ClojureScript 1.9.854 {}
goog.provide('ajax.xml_http_request');
goog.require('cljs.core');
goog.require('ajax.protocols');
ajax.xml_http_request.ready_state = (function ajax$xml_http_request$ready_state(e){
return new cljs.core.PersistentArrayMap(null, 5, [(0),new cljs.core.Keyword(null,"not-initialized","not-initialized",-1937378906),(1),new cljs.core.Keyword(null,"connection-established","connection-established",-1403749733),(2),new cljs.core.Keyword(null,"request-received","request-received",2110590540),(3),new cljs.core.Keyword(null,"processing-request","processing-request",-264947221),(4),new cljs.core.Keyword(null,"response-ready","response-ready",245208276)], null).call(null,e.target.readyState);
});
ajax.xml_http_request.xmlhttprequest = ((cljs.core._EQ_.call(null,cljs.core._STAR_target_STAR_,"nodejs"))?(function (){var xmlhttprequest = require("@pupeno/xmlhttprequest").XMLHttpRequest;
goog.object.set(global,"XMLHttpRequest",xmlhttprequest);

return xmlhttprequest;
})():window.XMLHttpRequest);
ajax.xml_http_request.xmlhttprequest.prototype.ajax$protocols$AjaxImpl$ = cljs.core.PROTOCOL_SENTINEL;

ajax.xml_http_request.xmlhttprequest.prototype.ajax$protocols$AjaxImpl$_js_ajax_request$arity$3 = (function (this$,p__44829,handler){
var map__44830 = p__44829;
var map__44830__$1 = ((((!((map__44830 == null)))?((((map__44830.cljs$lang$protocol_mask$partition0$ & (64))) || ((cljs.core.PROTOCOL_SENTINEL === map__44830.cljs$core$ISeq$)))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__44830):map__44830);
var uri = cljs.core.get.call(null,map__44830__$1,new cljs.core.Keyword(null,"uri","uri",-774711847));
var method = cljs.core.get.call(null,map__44830__$1,new cljs.core.Keyword(null,"method","method",55703592));
var body = cljs.core.get.call(null,map__44830__$1,new cljs.core.Keyword(null,"body","body",-2049205669));
var headers = cljs.core.get.call(null,map__44830__$1,new cljs.core.Keyword(null,"headers","headers",-835030129));
var timeout = cljs.core.get.call(null,map__44830__$1,new cljs.core.Keyword(null,"timeout","timeout",-318625318),(0));
var with_credentials = cljs.core.get.call(null,map__44830__$1,new cljs.core.Keyword(null,"with-credentials","with-credentials",-1163127235),false);
var response_format = cljs.core.get.call(null,map__44830__$1,new cljs.core.Keyword(null,"response-format","response-format",1664465322));
var this$__$1 = this;
this$__$1.withCredentials = with_credentials;

this$__$1.onreadystatechange = ((function (this$__$1,map__44830,map__44830__$1,uri,method,body,headers,timeout,with_credentials,response_format){
return (function (p1__44828_SHARP_){
if(cljs.core._EQ_.call(null,new cljs.core.Keyword(null,"response-ready","response-ready",245208276),ajax.xml_http_request.ready_state.call(null,p1__44828_SHARP_))){
return handler.call(null,this$__$1);
} else {
return null;
}
});})(this$__$1,map__44830,map__44830__$1,uri,method,body,headers,timeout,with_credentials,response_format))
;

this$__$1.open(method,uri,true);

this$__$1.timeout = timeout;

var temp__4657__auto___44842 = new cljs.core.Keyword(null,"type","type",1174270348).cljs$core$IFn$_invoke$arity$1(response_format);
if(cljs.core.truth_(temp__4657__auto___44842)){
var response_type_44843 = temp__4657__auto___44842;
this$__$1.responseType = cljs.core.name.call(null,response_type_44843);
} else {
}

var seq__44832_44844 = cljs.core.seq.call(null,headers);
var chunk__44833_44845 = null;
var count__44834_44846 = (0);
var i__44835_44847 = (0);
while(true){
if((i__44835_44847 < count__44834_44846)){
var vec__44836_44848 = cljs.core._nth.call(null,chunk__44833_44845,i__44835_44847);
var k_44849 = cljs.core.nth.call(null,vec__44836_44848,(0),null);
var v_44850 = cljs.core.nth.call(null,vec__44836_44848,(1),null);
this$__$1.setRequestHeader(k_44849,v_44850);

var G__44851 = seq__44832_44844;
var G__44852 = chunk__44833_44845;
var G__44853 = count__44834_44846;
var G__44854 = (i__44835_44847 + (1));
seq__44832_44844 = G__44851;
chunk__44833_44845 = G__44852;
count__44834_44846 = G__44853;
i__44835_44847 = G__44854;
continue;
} else {
var temp__4657__auto___44855 = cljs.core.seq.call(null,seq__44832_44844);
if(temp__4657__auto___44855){
var seq__44832_44856__$1 = temp__4657__auto___44855;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__44832_44856__$1)){
var c__39994__auto___44857 = cljs.core.chunk_first.call(null,seq__44832_44856__$1);
var G__44858 = cljs.core.chunk_rest.call(null,seq__44832_44856__$1);
var G__44859 = c__39994__auto___44857;
var G__44860 = cljs.core.count.call(null,c__39994__auto___44857);
var G__44861 = (0);
seq__44832_44844 = G__44858;
chunk__44833_44845 = G__44859;
count__44834_44846 = G__44860;
i__44835_44847 = G__44861;
continue;
} else {
var vec__44839_44862 = cljs.core.first.call(null,seq__44832_44856__$1);
var k_44863 = cljs.core.nth.call(null,vec__44839_44862,(0),null);
var v_44864 = cljs.core.nth.call(null,vec__44839_44862,(1),null);
this$__$1.setRequestHeader(k_44863,v_44864);

var G__44865 = cljs.core.next.call(null,seq__44832_44856__$1);
var G__44866 = null;
var G__44867 = (0);
var G__44868 = (0);
seq__44832_44844 = G__44865;
chunk__44833_44845 = G__44866;
count__44834_44846 = G__44867;
i__44835_44847 = G__44868;
continue;
}
} else {
}
}
break;
}

this$__$1.send((function (){var or__39160__auto__ = body;
if(cljs.core.truth_(or__39160__auto__)){
return or__39160__auto__;
} else {
return "";
}
})());

return this$__$1;
});

ajax.xml_http_request.xmlhttprequest.prototype.ajax$protocols$AjaxRequest$ = cljs.core.PROTOCOL_SENTINEL;

ajax.xml_http_request.xmlhttprequest.prototype.ajax$protocols$AjaxRequest$_abort$arity$1 = (function (this$){
var this$__$1 = this;
return this$__$1.abort();
});

ajax.xml_http_request.xmlhttprequest.prototype.ajax$protocols$AjaxResponse$ = cljs.core.PROTOCOL_SENTINEL;

ajax.xml_http_request.xmlhttprequest.prototype.ajax$protocols$AjaxResponse$_body$arity$1 = (function (this$){
var this$__$1 = this;
return this$__$1.response;
});

ajax.xml_http_request.xmlhttprequest.prototype.ajax$protocols$AjaxResponse$_status$arity$1 = (function (this$){
var this$__$1 = this;
return this$__$1.status;
});

ajax.xml_http_request.xmlhttprequest.prototype.ajax$protocols$AjaxResponse$_status_text$arity$1 = (function (this$){
var this$__$1 = this;
return this$__$1.statusText;
});

ajax.xml_http_request.xmlhttprequest.prototype.ajax$protocols$AjaxResponse$_get_response_header$arity$2 = (function (this$,header){
var this$__$1 = this;
return this$__$1.getResponseHeader(header);
});

ajax.xml_http_request.xmlhttprequest.prototype.ajax$protocols$AjaxResponse$_was_aborted$arity$1 = (function (this$){
var this$__$1 = this;
return cljs.core._EQ_.call(null,(0),this$__$1.readyState);
});

//# sourceMappingURL=xml_http_request.js.map
